package com.bilgeadam.aliergul.util.helper.progresbar;

public class ProgresBarThread implements Runnable, IOnClose {
	
	private boolean isProgressRon = true;
	private IOnClose progresBarThread;
	
	public ProgresBarThread() {
		
	}
	
	@Override
	public void run() {
		progresBarThread = this;
		final String[] icon = { "/", "|", "X", "\\" };
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
	
	public IOnClose getProgresBarThread() {
		return progresBarThread;
	}
	
	@Override
	public void onCloseRunable() {
		this.isProgressRon = false;
		
	}
	
}
