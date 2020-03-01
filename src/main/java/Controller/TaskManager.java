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
	private int completed;
	private final int goal = 5;

	enum STATUS{
		NONE,
		SOME,
		ALL
	};

	public TaskManager(){
		taskList = new HashMap<Integer, Task>();
		archived = new HashMap<Integer, Task>();
		completed = 0;
		stats = new StatsManager();
		idCount = 0;
	}

	public void completeTask(int id){
		Task t = taskList.get(id);
		stats.updateStats(t);
		completed++;
		removeTask(t.getId());
	}

	public void addTask(String task){

		int id = idCount;
		idCount++;
		Task t = new Task(id, task);

		taskList.put(id, t);

	}

	public Task getTask(int id){
		return taskList.get(id);
	}

	public void removeTask(int id) {
		Task t = taskList.remove(id);
		archived.put(t.getId(), t);
	}

	public void alterTask(int id, String newData){
		Task t = taskList.get(id);
		t.setData(newData);
	}

	public STATUS getStatus(){
		if(completed == 0) return STATUS.NONE;
		else if(completed < goal) return STATUS.SOME;
		else return STATUS.ALL;
	}

	public Collection<Task> getTaskList(){ return taskList.values(); }

	public int getNumTasks(){ return taskList.size(); }

}
