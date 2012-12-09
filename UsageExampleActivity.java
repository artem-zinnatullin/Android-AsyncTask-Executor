package ru.artemzin.android.asynctaskexecutor;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class UsageExampleActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TestTask task0 = new TestTask("task0");
		TestTask task1 = new TestTask("task1");
		TestTask task2 = new TestTask("task2");
		TestTask task3 = new TestTask("task3");
		TestTask task4 = new TestTask("task4");
		// Sleep for 5 seconds
		AsyncTaskExecutor.executeConcurrently(task0, Long.valueOf(5000));
		// Sleep for 1 second
		AsyncTaskExecutor.executeConcurrently(task1, Long.valueOf(1000));
		// Sleep for 0 second
		AsyncTaskExecutor.executeConcurrently(task2, Long.valueOf(0));
		// Sleep for 2 second
		AsyncTaskExecutor.executeConcurrently(task3, Long.valueOf(2000));
		// Sleep for 0.5 second
		AsyncTaskExecutor.executeConcurrently(task4, Long.valueOf(500));
		
		// As you can see, finish order: task2, task4, task1, task3, task0
		// Concurrently on any Android version!
	}
	
	private void showMessage(String message) {
		Log.d("AsyncTaskConcurrently", message);
		Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
		toast.show();
	}
	
	/**
	 * Task for test
	 * @author Artem Zinnatullin (artem.zinnatullin@gmail.com)
	 */
	private class TestTask extends AsyncTask<Long, Integer, Boolean> {

		private String name;
		
		public TestTask(String name) {
			this.name = name;
		}
		
		@Override
		protected Boolean doInBackground(Long... params) {
			try {
				Thread.sleep(params[0]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return true;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			if (result) {
				showMessage(this.name + " finished");
			}
		}
		
	}
}
