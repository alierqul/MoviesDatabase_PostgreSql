package com.bilgeadam.aliergul.util.helper.progresbar;

public class MyProgressBar implements IProgresbarActionable {
	private static MyProgressBar instance;
	
	private MyProgressBar() {
		
	}
	public static MyProgressBar getInstance() {
		if(instance== null)
			instance=new MyProgressBar();
		return instance;
	}

	private ProgresBarThread pr = new ProgresBarThread();
	
	@Override
	public void onStartRunable() {
		 new Thread() {
			@Override
			public void run() {
				pr.onStartRunable();
			}
		}.start();	
		
	}

	@Override
	public void onCloseRunable() {
		pr.getProgresBarThread().onCloseRunable();
		
	}
}
