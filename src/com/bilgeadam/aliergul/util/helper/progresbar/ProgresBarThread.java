package com.bilgeadam.aliergul.util.helper.progresbar;

public class ProgresBarThread implements  IProgresbarActionable {
	
	private boolean isProgressRon = true;
	private IProgresbarActionable progresBarThread;
	
	public IProgresbarActionable getProgresBarThread() {
		return progresBarThread;
	}
	
	@Override
	public void onCloseRunable() {
		this.isProgressRon = false;
		
	}

	@Override
	public void onStartRunable() {
		progresBarThread = this;
		final String[] icon ={ ".     ", "..    ", "...   ", " ... ","  ... ","   ...","    ..","     .","      " };
		isProgressRon = true;
		while (isProgressRon) {
			for (int i = 0; i < icon.length; i++) {
				System.out.printf("\r[ %s ]", icon[i]);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					
				}
			}
		}
		System.out.println();
		
	}
	
}
