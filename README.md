# StopWatch-Android
Minor Stop watch in Android Pure

This app show the different life cycle Methods in Android Application, 
Such as   
- On Create = When the app is getting created
- OnDestroy = When the app is getting destroy, closed or when config has changed
- OnStart = When the app getting started and gain the focus
- OnResume = When the app getting the focus, either from start or from the being minimized( after onPause/onRestart)
- OnPause = When the app is minimized but still on the foreground
- OnRestart = Just before the app has resume, when the app is from onPause
- OnStop = When the app is being out off focus and in the background
- onSaveInstance = Just before the app has been destroyed-- take the Bundle Obj which is wrapper of map which contain variable state         
     
Handler,
To handle the thread, which other wise would make the impossible for the android main cycle to continue as usual,

The handler will contain the Runnable obj in on of it method:
- put = Which will run the runnable obj immediately
- putDelay = Take the runnable obj and a long which say how long before the runnable is run again
      
