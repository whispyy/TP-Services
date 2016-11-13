# Service local VS distant

Ce service sera appelé par :

```java
bindService(
	Intent nomService, 
	ServiceConnection connexion, 
	int flag)
```

La connexion est gérée via le composant ServiceConnection d'Android.

--

```java
    @Override
    public void onCreate() {}

    @Override
    public IBinder onBind(Intent intent) {}

    @Override
    public boolean onUnbind(Intent intent) {}

    //Eventuellement une fonction onRebind(Intent intent);

    @Override
    public void onDestroy() {}
```