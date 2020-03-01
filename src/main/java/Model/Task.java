package Model;

public class Task {

	private int id;
	private String data;

	public Task(int id, String data){
		this.id = id;
		this.data = data;
;
	}
	public int getId(){
		return id;
	}

	public String getData(){
		return data;
	}

	public void setData(String newData){
		data = newData;
	}

}
