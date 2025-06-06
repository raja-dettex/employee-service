package com.emp_service.employee_service.schedular;

import com.emp_service.employee_service.service.TaskService;
import com.emp_service.employee_service.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TaskSchedular {

    @Autowired
    private TaskService taskService;


    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Scheduled(cron="0 * * * * ?")
    public void runTask() {
        Task task = taskService.getNextReadyTask();
        if(task != null) {
            Runnable runnableTask = new Runnable() {
                @Override
                public void run()  {
                    try {
                        Thread.sleep(2000);
                        System.out.println("running task : " + task.toString());
                    } catch(InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            };
            executorService.submit(runnableTask);
        }
    }
}
