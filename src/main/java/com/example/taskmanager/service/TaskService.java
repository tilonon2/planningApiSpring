package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Optional<Task> taskToUpdate = taskRepository.findById(id);
        if (taskToUpdate.isPresent()) {
            taskToUpdate.get().setName(task.getName());
            taskToUpdate.get().setCompleted(task.isCompleted());
            return taskRepository.save(taskToUpdate.get());
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


}
