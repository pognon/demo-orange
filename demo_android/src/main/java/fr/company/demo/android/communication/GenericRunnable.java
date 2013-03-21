package fr.company.demo.android.communication;


public class GenericRunnable implements Runnable{
	
	private Object o;

	public void run() {
		// TODO Auto-generated method stub
	}
	
	public void setObject(Object o){
		this.o = o;
	}
	
	public Object getObject(){
		return o;
	}

}
