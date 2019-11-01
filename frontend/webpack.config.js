module.exports = {
    devtool: 'source-map',
    module: {
        rules: [{
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            loader: "babel-loader",
            options: {
                presets: ['@babel/preset-env', '@babel/preset-react']
            }
        }, {
            test: /\.css$/i,
            use: ['to-string-loader', 'css-loader']
        }, {
            test: /\.svg$/,
            use: {
                loader: 'svg-url-loader',
                options: {
                    encoding: 'base64'
                }
            }
        }]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    }
};