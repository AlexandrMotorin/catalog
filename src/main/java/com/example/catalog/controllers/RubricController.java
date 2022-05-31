package com.example.catalog.controllers;

import com.example.catalog.dto.RubricDto;
import com.example.catalog.dto.RubricPropertyDto;
import com.example.catalog.service.RubricService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/props/{id}")
    private void addPropertyForRubric(@PathVariable Long id, @RequestBody RubricPropertyDto props){
        rubricService.addProperty(id, props.getPropsId());
    }
}
