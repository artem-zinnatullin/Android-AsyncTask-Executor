Android-Async-Task-Executor
===========================

You want to execute your AsyncTask concurrently on any version of Android OS? You needed AsyncTaskExecutor!

---------------------------
#####Please, look in UsageExampleActivity.java to see usage example of AsyncTaskExecutor

---------------------------

It takes all work for running AsyncTask concurrently on any Android OS version, it is better that using:

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    } else {
        task.execute();
    }

Because AsyncTask.THREAD_POOL_EXECUTOR works only on api >= 11; I`m using own threadPoolExecutor

With AsyncTaskExecutor you just need to write:

    AsyncTaskExecutor.executeConcurrently(task, params);

And that is all. No errors on Android 2.x, 3.x and 4.x
