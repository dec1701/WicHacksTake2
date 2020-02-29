package Controller;

import Model.Task;

import java.util.HashMap;

public class TaskManager {

	private HashMap<Integer, Task> taskList;

	public TaskManager(){
		//taskList = new HashMap<>();
	}

	public void addTask(String task, int stars){

		int id = taskList.size()+1;
		Task t = new Task(id, task, stars);

		taskList.put(id, t);

	}

	public Task getTask(int id){
		return taskList.get(id);
	}

	public void removeTask(int id){
		taskList.remove(id);
	}

	public void alterTask(int id, String newData, int newStars){
		Task t = taskList.get(id);

		t.setData(newData);
		t.setNumStars(newStars);

	}

}
