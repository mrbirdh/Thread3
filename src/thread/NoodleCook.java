package thread;

public class NoodleCook implements Runnable {
	private int noodleCount;
	private String[] burners = {"_","_","_","_"};
	
	public NoodleCook(int noodleCount) {
		this.noodleCount = noodleCount;
	}
	
	@Override
	public void run () {
		boolean flag = true;
		while (noodleCount > 0 && flag) {
			
			synchronized (this) {
				noodleCount--;
				System.out.println(
						Thread.currentThread().getName()
						+  ": " + noodleCount + "개 남음"
				);
				
			}
			
			for (int i = 0; i < burners.length; i++) {
//				if (!burners[i].equals("_")) {}
				synchronized (this) {
					
					burners[i] = Thread.currentThread().getName();
					System.out.println(
							"			" 
									+ Thread.currentThread().getName() 
									+ ": [" + (i + 1) +"]번 버너 ON" 
							);
					showBurners();
				}
				try {
					Thread.sleep(2000);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				synchronized (this) {
					burners[i] = "_";
					System.out.println(
							"			" 
									+ Thread.currentThread().getName() 
									+ ": [" + (i + 1) +"]번 버너 OFF" 
							);
					showBurners();
				}
				flag = false;
				
			}
			try {
				Thread.sleep(Math.round(1000 * Math.random()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void showBurners () {
		String print = "";
		for (int i = 0; i < burners.length; i++) {
			print += (" " + burners[i]);
		}
		System.out.println(print);
	}
}
