package sn.isi.l3gl.api.task_api.controller;


import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.task_core.services.TaskService;
import sn.isi.l3gl.core.task_core.entity.Task;
import sn.isi.l3gl.core.task_core.enumeration.StatusEnum;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestParam String title, @RequestParam String description) {
        return taskService.createTask(title, description);
    }

    @GetMapping
    public List<Task> listTasks() {
        return taskService.listTasks();
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable int id, @RequestParam StatusEnum status) {
        return taskService.updateStatus(id, status);
    }

    @GetMapping("/done/count")
    public long countCompletedTasks() {
        return taskService.countCompletedTasks();
    }
}