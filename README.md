#Android-AsyncTask-Executor

##Why use it?
Starting with Android Api >= [HONEYCOMB](http://developer.android.com/reference/android/os/Build.VERSION_CODES.html#HONEYCOMB) 
AsyncTasks are executed on serial, which means that you could not run 2 or more AsyncTasks concurrently 
without calling task.executeOnExecutor(...), it is not so easy as you would like to think.

AsyncTask-Executor takes all work for running AsyncTask concurrently on any Android OS version, it is better that using:

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    } else {
        task.execute();
    }

Because AsyncTask.THREAD_POOL_EXECUTOR available only on api >= 11; I`m using my own *threadPoolExecutor*

###With AsyncTaskExecutor you just need to write:

    AsyncTaskExecutor.executeConcurrently(task, params, ...);

And that is all. **No errors** on Android 2.x, 3.x and 4.x

---------------------------
#####Please, look in UsageExampleActivity.java to see usage example of AsyncTaskExecutor

---------------------------
###How to import AsyncTask-Executor to your Android Project?

* Just copy AsyncTaskExecutor.java to your Android project! (Simplest way)

* Or use AsyncTaskExecutor as Android Library Project (Good way, if you want to see javadoc)

* Or just use .jar file, look at Jar folder to get it (Easy way)

---------------------------

####Do not forget!
*AsyncTaskExecutor.executeConcurrently()* returns executing AsyncTask object and 
you can do what you want with it. For example, you could cancel running task or anything else you could do with AsyncTask object.

[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/artem-zinnatullin/android-asynctask-executor/trend.png)](https://bitdeli.com/free "Bitdeli Badge")
