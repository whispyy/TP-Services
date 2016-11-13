## Différents types de services

**Différents types de service**

- Services locaux :
   - lancé par une activité
   - se termine lorsqu'il a terminé d'effectuer ses opérations.
- Sercices distants
   - interaction client-serveur
   - se lance et se termine via un ServiceConnection.


--

**Cycles de vie des différents services**

<img src="img/services_lifecycle.jpg"/>

--

**Les flags**

* START_NOT_STICKY : En cas d'arrêt du service par le système, il n'est pas recrée
* START_STICKY : En cas d'arrêt du service par le système, il sera recrée mais le paramètre Intent sera null.
* START_REDELIVER_INTENT : En cas d'arrêt du service par le système, il sera recrée à l'identique.

--

**Les deux façons d'implémenter un service**

* Service : permet de créer un service où le code sera executé dans le "thread" principale.
* IntentService : permet de créer un service et gère une file d'attente des requête par ordre d'arrivée à chaque appel de startService().