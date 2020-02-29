package Model;

public class Task {

	private int id;
	private String data;
	private int numStars;


	public Task(int id, String data, int stars){
		this.id = id;
		this.data = data;
		numStars = stars;
	}

	public int getId(){
		return id;
	}

	public String getData(){
		return data;
	}

	public int getNumStars(){
		return numStars;
	}

	public void setData(String newData){
		data = newData;
	}

	public void setNumStars(int newStars){
		numStars = newStars;
	}

}
