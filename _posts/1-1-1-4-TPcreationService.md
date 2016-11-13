## Création du Service

### 1. Récupération des sources

Télécharger l'archive ici : [https://github.com/whispyy/TP-Services/tree/local_service_initial](http://github.com/whispyy/TP-Services/tree/local_service_initial)

Ou clonez le dépot depuis mon git : [https://github.com/whispyy/TP-Services](https://github.com/whispyy/TP-Services) et basculez sur la branche : local_service_initial


--

### 2. Analyse de l'activité

L'activité est composée de deux boutons : Start et Cancel.
Start permet de lancer le service et Cancel de l'annuler.

Le service est ici appelé comme suit :

```java
Intent myIntent = new Intent(MainActivity.this, MyService.class);
```

```java
alarmManager.set(
	AlarmManager.RTC_WAKEUP, 
	calendar.getTimeInMillis(), 
	pendingIntent);
```

Il faut imaginer ici que tout cela revient à faire une programmation d'un délai suivi d'un appel à ```startService(myIntent)``` .

--

### 3. Création d'un service local

#### 3.1 Initialisation du service

<img src="img/createService1.png"/>

Note:

Nommer le service : MyService.java

--

#### 3.2 Remplir le service

**L'objectif est de créer un service ou l'on va pouvoir visualiser le cycle de vie d'un service.**

Pour cela je propose de commencer par implémenter des toasts sur chaque fonction du service en question.

> Il est nécéssaire de ré-écrire les méthodes d'un service distant :
>
> onBind(Intent intent) 
>
>onUnbind(Intent intent)

*Vérifier dans les paramètres android l'execution du service.*

--

### 3.3 Implémenter une notification

```java
@Override
    public int onStartCommand(...){
        /*
         * Here must be the code to execute
         * Voir PDF
         */

        super.onStartCommand(intent,flag,startId);
        return START_NOT_STICKY;
    }
```

