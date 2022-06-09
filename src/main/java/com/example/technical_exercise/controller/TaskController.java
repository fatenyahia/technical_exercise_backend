package com.example.technical_exercise.controller;

import com.example.technical_exercise.model.Task;
import com.example.technical_exercise.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")

public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id_task}")
    public Task findById(@PathVariable Long id_task){
        return taskRepository.findById(id_task).orElse(null);
    }

    @PostMapping("/save")
    public Task create(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PutMapping("/{id_task}")
    public Task update(@RequestBody Task task,@PathVariable Long id_task){
        task.setId(id_task);
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id_task}")
    public void delete(@PathVariable Long id_task){
            taskRepository.deleteById(id_task);
    }
}
