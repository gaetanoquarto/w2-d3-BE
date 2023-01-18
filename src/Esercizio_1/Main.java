package Esercizio_1;

public class Main {

	public static void main(String[] args) {
		
		Simbolo s1 = new Simbolo("*");
		Simbolo s2 = new Simbolo("#");
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();

	}

}

	class Simbolo implements Runnable {
	
	private String simbolo;
	
	public Simbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public void run() {
		for(int i = 1; i<10; i++) {
			System.out.println(simbolo);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}

		}
	}
