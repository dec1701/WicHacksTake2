package Controller;

import Model.Task;

public class StatsManager {

    //Tasks completed
    private int totalTasks;

    private int totalStars;

    private double averageStars;

    public StatsManager(){
        totalTasks=0;
        totalStars = 0;
        averageStars = 0;
    }

    public void updateStats(Task t){
        totalTasks++;
        totalStars += t.getNumStars();

        averageStars = (double) totalTasks/totalStars;


    }

    public int getTotalTasks(){ return totalTasks; }


}
