package io.github.vikie1.whatsoftware.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewsGetController {

    @GetMapping(value="/")
    public String getHome() {
        return "index";
    }
    

}
