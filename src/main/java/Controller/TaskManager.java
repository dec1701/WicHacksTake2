package Controller;

import Model.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TaskManager {

	private HashMap<Integer, Task> taskList;
	private HashMap<Integer, Task> archived;
	private static StatsManager stats;
	private static int idCount;

	public TaskManager(){
		taskList = new HashMap<Integer, Task>();
		archived = new HashMap<Integer, Task>();
		stats = new StatsManager();
		idCount = 0;
	}

	public void completeTask(int id){
		Task t = taskList.get(id);
		stats.updateStats(t);
		removeTask(t.getId());
	}

	public void addTask(String task, int stars){

		int id = idCount;
		idCount++;
		Task t = new Task(id, task, stars);

		taskList.put(id, t);

	}

	public Task getTask(int id){
		return taskList.get(id);
	}

	public void removeTask(int id) {
		Task t = taskList.remove(id);
		archived.put(t.getId(), t);
	}

	public void alterTask(int id, String newData, int newStars){
		Task t = taskList.get(id);

		t.setData(newData);
		t.setNumStars(newStars);

	}

	public Collection<Task> getTaskList(){ return taskList.values(); }

	public int getNumTasks(){ return taskList.size(); }

}
