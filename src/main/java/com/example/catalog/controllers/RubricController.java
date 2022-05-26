package com.example.catalog.controllers;

import com.example.catalog.dto.RubricDto;
import com.example.catalog.service.RubricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rubric/")
@RequiredArgsConstructor
public class RubricController {

    private final RubricService rubricService;

    @PostMapping
    private void saveRubric(@RequestBody RubricDto rubric){
        rubricService.saveRubric(rubric);
    }

    @GetMapping("{id}")
    private RubricDto getRubric(@PathVariable Long id){
        return rubricService.findRubricById(id);
    }

    @GetMapping("hi")
    private String hello(){
        return "hi";
    }
}
