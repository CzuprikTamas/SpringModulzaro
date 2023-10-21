package hu.progmatic.springmodulzaro.controller;


import hu.progmatic.springmodulzaro.model.Preorder;
import hu.progmatic.springmodulzaro.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/preorder")
public class PreorderController {

    private EntityService entityService;

    @GetMapping("/new/{person-id}")
    public String createNewPreorder(Model model, @PathVariable("person-id") Integer personId){
        model.addAttribute("personId", personId);
        model.addAttribute("preorder", new Preorder());
        return "new-preorder";
    }

    @PostMapping("/add/{person-id}")
    public String createPreorder(@ModelAttribute("preorder") Preorder preorder, @PathVariable("person-id") Integer personId){
        preorder.setPerson(entityService.getPersonById(personId));
        entityService.savePreorder(preorder);
        return "redirect:/home";
    }
}
