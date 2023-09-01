package com.bawp.todoister.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bawp.todoister.data.DoisterRepositary;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    public static DoisterRepositary repositary;
    public final  LiveData<List<Task>> allTasks;
    public TaskViewModel(@NonNull Application application) {
        super(application);

        repositary = new DoisterRepositary(application);
        allTasks = repositary.getAllTasks();
    }

    public LiveData<List<Task>> getAllTasks(){return allTasks;}
    public static void insert(Task task){ repositary.insert(task);}
    public LiveData<Task> get(long id){ return repositary.get(id);}
    public static void update(Task task) {repositary.update(task);}
    public static void delete(Task task) {repositary.delete(task);}
}
