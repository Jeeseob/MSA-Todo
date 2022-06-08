package Jbae.visitor_management.controller;

import Jbae.visitor_management.dto.PersonProgramRequest;
import Jbae.visitor_management.dto.ProgramRequest;
import Jbae.visitor_management.service.PersonProgramService;
import Jbae.visitor_management.service.PersonService;
import Jbae.visitor_management.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/08
 */

@Controller
public class PersonProgramController {

    @Autowired
    private PersonProgramService personProgramService;

    @Autowired
    private ProgramService programService;

    @Autowired
    private PersonService personService;

    @GetMapping("/visit/person/{id}")
    public ModelAndView getProgramByPerson(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("visitor/programList");
        modelAndView.addObject("personProgramList", personProgramService.getProgramByPersonId(id));
        return modelAndView;
    }

    @GetMapping("/visit/program/{id}")
    public ModelAndView getPersonByProgram(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("visitor/personList");
        modelAndView.addObject("personProgramList", personProgramService.getPersonByProgramId(id));
        return modelAndView;
    }

    @PostMapping("/visit/add/")
    ModelAndView addProgram(@ModelAttribute("person-program") PersonProgramRequest request) {
        ModelAndView mav = new ModelAndView("redirect:/visitor/program?id=" + request.getProgramId());
        personProgramService.setRequest(request);
        return mav;
    }

    @RequestMapping("program/form/{id}")
    ModelAndView formProgram(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("program/program_add");
        modelAndView.addObject("programList", programService.getAllProgram());
        modelAndView.addObject("person", personService.getPerson(id));
        modelAndView.addObject("program", new ProgramRequest());
        return modelAndView;
    }
}
