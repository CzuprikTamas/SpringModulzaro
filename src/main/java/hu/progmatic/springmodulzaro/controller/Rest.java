package hu.progmatic.springmodulzaro.controller;

import hu.progmatic.springmodulzaro.model.Person;
import hu.progmatic.springmodulzaro.model.Preorder;
import hu.progmatic.springmodulzaro.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class Rest {

    private EntityService entityService;

    @GetMapping("/persons")
    public List<Person> getAllPerson() {
        return entityService.getAllPerson();
    }

    @GetMapping("/preorders")
    public List<Preorder> getAllPreorder() {
        return entityService.getAllPreorder();
    }

    @GetMapping("/person/{id}/preorder")
    public List<Preorder> getAllPreorderByPerson(@PathVariable ("id") Integer id) {
        return entityService.getAllPreorderByPerson(entityService.getPersonById(id));
    }
}
