package game.blackandwhite.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/game/{path:[^\\.]+}/**")
    public String forward() {
        return "forward:/";
    }
}