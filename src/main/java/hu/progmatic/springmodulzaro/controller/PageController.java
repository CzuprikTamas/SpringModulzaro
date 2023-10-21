package hu.progmatic.springmodulzaro.controller;

import hu.progmatic.springmodulzaro.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class PageController {

    private EntityService entityService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("personList", entityService.getAllPerson());
        return "home";
    }
}
