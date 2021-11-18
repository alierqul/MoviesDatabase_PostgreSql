package com.bilgeadam.aliergul.util.helper.progresbar;

public enum MyProgressBar {
	getInstance;
	
	private ProgresBarThread pr = new ProgresBarThread();
	
	public void startProgress() {
		Thread progres = new Thread(pr);
		progres.start();
	}
	
	public void stopProgress() {
		pr.getProgresBarThread().onCloseRunable();
	}
}
