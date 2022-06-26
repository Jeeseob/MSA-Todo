package Jbae.visitor_management.controller;

import Jbae.visitor_management.dto.PersonRequest;
import Jbae.visitor_management.entity.Person;
import Jbae.visitor_management.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/04
 */

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person/list")
    public ModelAndView  getallPerson() {
        ModelAndView modelAndView = new ModelAndView("person/personList");
        modelAndView.addObject("personList", personService.getAllPerson());
        return modelAndView;
    }

    @GetMapping("/person")
    public ModelAndView getPerson(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("person/person");
        modelAndView.addObject("person", personService.getPerson(id));
        return modelAndView;
    }


    @PostMapping("/person/add")
    ModelAndView addPerson(@ModelAttribute("person") PersonRequest request) {
        ModelAndView modelAndView = new ModelAndView("redirect:/person/list");
        personService.setRequest(request);
        return modelAndView;
    }

    @RequestMapping("person/form")
    ModelAndView formPerson() {
        ModelAndView modelAndView = new ModelAndView("person/person_add");
        modelAndView.addObject("person", new Person());
        return modelAndView;
    }
}
