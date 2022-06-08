package Jbae.visitor_management.controller;

import Jbae.visitor_management.dto.ProgramRequest;
import Jbae.visitor_management.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/08
 */
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @GetMapping("/program/list")
    public ModelAndView getAllProgram() {
        ModelAndView modelAndView = new ModelAndView("program/programList");
        modelAndView.addObject("programList", programService.getAllProgram());
        return modelAndView;
    }

    @GetMapping("/program")
    public ModelAndView getProgram(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("program/program");
        modelAndView.addObject("program", programService.getProgram(id));
        return modelAndView;
    }


    // StudentController.java
    @PostMapping("/program/add")
    ModelAndView addProgram(@ModelAttribute("program") ProgramRequest request) {
        // 학생 목록 화면으로 리다이렉트
        ModelAndView mav = new ModelAndView("redirect:/program/list");
        programService.setRequest(request);	// DB - Student 테이블에 입력
        return mav;
    }

    @RequestMapping("program/form")
    ModelAndView formProgram() {
        // templates 폴더 아래 html 경로 입력(확장자 생략)
        ModelAndView modelAndView = new ModelAndView("program/program_add");
        modelAndView.addObject("program", new ProgramRequest());
        return modelAndView;
    }
}
