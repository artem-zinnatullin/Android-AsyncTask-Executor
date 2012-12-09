Android-Async-Task-Executor
===========================

You want to execute your AsyncTask concurrently on any version of Android OS? You needed AsyncTaskExecutor!

---------------------------
#####Please, look in UsageExampleActivity.java to see usage example of AsyncTaskExecutor

---------------------------

#####Just copy AsyncTaskExecutor.java to your Android project!

It takes all work for running AsyncTask concurrently on any Android OS version, it is better that using:

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    } else {
        task.execute();
    }

Because AsyncTask.THREAD_POOL_EXECUTOR available only on api >= 11; I`m using own threadPoolExecutor

With AsyncTaskExecutor you just need to write:

    AsyncTaskExecutor.executeConcurrently(task, params);

And that is all. No errors on Android 2.x, 3.x and 4.x

####Do not forget!
*AsyncTaskExecutor.executeConcurrently()* returns executing AsyncTask object and 
you can do what you want with it. For example, you could cancel running task or anything else you could do with AsyncTask object.
