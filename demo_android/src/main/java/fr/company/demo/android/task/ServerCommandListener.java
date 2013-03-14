package fr.company.demo.android.task;

import java.io.InputStream;
import java.util.List;

public interface ServerCommandListener {
	
	public void requestStarted();
	public void requestFinished(List<?> response, String token , Exception error);
	public void imageDownloadFinished(InputStream is, String token , Exception error);

}
