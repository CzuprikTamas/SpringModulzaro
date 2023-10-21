package hu.progmatic.springmodulzaro.controller;

import hu.progmatic.springmodulzaro.model.Person;
import hu.progmatic.springmodulzaro.service.EntityService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private EntityService entityService;

    @GetMapping("/new")
    public String createNewPerson(Model model) {
        model.addAttribute("person", new Person());
        return "new-person";
    }

    @PostMapping("/add")
    public String createPerson(@ModelAttribute ("newPerson") Person person) {
        entityService.savePerson(person);
        return "redirect:/home";
    }

    @GetMapping("/{id}")
    public String getPersonById(Model model, @PathVariable Integer id) {
        Person person = entityService.getPersonById(id);
        model.addAttribute("preorders", entityService.getAllPreorderByPerson(person));
        model.addAttribute("person", person);
        return "person";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        entityService.deletePreorderByPerson(entityService.getPersonById(id));
        entityService.deletePersonById(id);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String updatePerson(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("person", entityService.getPersonById(id));
        return "person-update";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Integer id, @ModelAttribute("person") Person updated) {
        entityService.savePerson(updated);
        return "redirect:/person/" + id;
    }
}
