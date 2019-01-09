package game.blackandwhite.backend.square;

import game.blackandwhite.backend.core.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board2d<T extends Piece> {
    final int[] size;
    final Piece[] data;
    int placedPieces = 0;

    public Board2d() {
        size = null;
        data = null;
    }

    public Board2d(int x, int y) {
        size = new int[] { x, y };
        data = new Piece[x * y];
    }

    public Board2d(Board2d<T> copyFrom) {
        size = copyFrom.size;
        data = copyFrom.data.clone();
        placedPieces = copyFrom.placedPieces;
    }

    public T get(int x, int y) {
        @SuppressWarnings("unchecked")
        T p = (T) data[getIndex(x, y)];
        return p;
    }

    public String toString(int x, int y, String empty) {
        T p = get(x, y);
        if (p != null) {
            return p.toString();
        }

        return empty;
    }

    public boolean hasPiece(int x, int y) {
        return get(x, y) != null;
    }

    public Board2d<T> set(Square<T> square, T p) {
        return set(square.x(), square.y(), p);
    }

    public Board2d<T> set(int x, int y, T p) {
        int index = getIndex(x, y);
        updatePlacedPieces(index, p == null);
        data[index] = p;
        return this;
    }

    private void updatePlacedPieces(int index, boolean remove) {
        Piece p = data[index];
        if (remove && p != null) {
            placedPieces--;
        } else if (!remove && p == null) {
            placedPieces++;
        }
    }

    private int getIndex(int x, int y) {
        return x + y * size[0];
    }

    public List<Square<T>> toList() {
        List<Square<T>> ret = new ArrayList<>(data.length);
        int count = 0;
        for (int y = 0; y < size[1]; y++) {
            for (int x = 0; x < size[0]; x++) {
                @SuppressWarnings("unchecked")
                T entry = (T) data[count];
                ret.add(new Square<>(x, y, entry, this));
                count++;
            }
        }

        return ret;
    }

    public int set(String boardStr, Map<Character, T> charToPiece) {
        if (boardStr.length() != data.length) {
            String msg = String.format("boardStr length (%d) must equals board size (%d)", boardStr.length(),
                    data.length);
            throw new IllegalArgumentException(msg);
        }
        int count = 0;
        int index = 0;
        for (int i = 0; i < boardStr.length(); i++) {
            char c = boardStr.charAt(i);
            T p = charToPiece.get(c);
            if (p != null) {
                data[index] = p;
                count++;
            }
            index++;
        }
        return count;
    }

    public int getPlayedPieces() {
        return placedPieces;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int x = 0; x < size[0]; x++) {
            sb.append("[");
            for (int y = 0; y < size[1]; y++) {
                sb.append(toString(x, y, " "));
            }
            sb.append("]");
        }
        sb.append("]");
        return sb.toString();
    }
}
