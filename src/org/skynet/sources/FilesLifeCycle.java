package org.skynet.sources;

public interface FilesLifeCycle {

	
	public void onIntialise();
	public void onRun();
	public void onSuspend();
	public void onDestroy();
	
}
