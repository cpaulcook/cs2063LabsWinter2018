# Lab 6 Notifications and Broadcast Receivers

Start by familiarizing yourself with the following documentation which
you will be using during this lab:

[Notifications](https://web.archive.org/web/20160303170900/https://developer.android.com/guide/topics/ui/notifiers/notifications.html)
Read at least up to the end of "Creating a simple notification". (I've
pointed you to an older version of this documentation because Android
has recently introduced ```NotificationChannel```s, which we won't be
using in this lab.)

[Alarms](http://developer.android.com/training/scheduling/alarms.html)
Up to the end of Cancel an Alarm.

[Monitoring battery state](http://developer.android.com/training/monitoring-device-state/battery-monitoring.html) 

[PendingIntents](http://developer.android.com/reference/android/app/PendingIntent.html)
Just read the class overview.

[BroadcastReceivers](http://developer.android.com/reference/android/content/BroadcastReceiver.html)
Just read the class overview.


## Introduction

In this lab we will build a photo taking app that reminds the user to
take a photo at regular intervals. This could be, for example, the
start of an app for a [365 Project](http://365project.org/)-like
photography project. We will also make the app adapt to the battery
state of the device to conserve power when the battery is low. In
	building this app we will learn about Android notifications, alarms
and BroadcastReceivers.




## Todo

Download the Lab 6 Skeleton from
[cs2063LabsWinter2018](https://github.com/cpaulcook/cs2063LabsWinter2018). This
is a single-```Activity``` app that has a button that dispatches an
implicit ```Intent``` to take a photo, and then saves the photo. (It's
the same code that we used to take a photo in Lab 3.)

Read the skeleton code and make sure you understand what it's doing.

### Notifications

First we'll add the functionality to have an alarm go off at regular
intervals to remind the user to take a picture. We'll start by writing
code to respond to this alarm; then we'll go back and set the
alarm. To receive an alarm we use a ```BroadcastReceiver```. Let's
create one.

Create a new Java file called
```AlarmReceiver.java```. ```AlarmReceiver``` will extend
```BroadcastReceiver``` .

Override ```AlarmReceiver```'s ```onReceive``` method. This method
will be called when the ```BroadcastReceiver``` receives a
broadcast. Just put a ```Log``` message in here for now.

We've added a component to our application. App components need to be
registered in ```AndroidManifest.xml```. To register our new
```BroadcastReceiver```, add the following ```receiver``` element
inside of the ```application``` element in ```AndroidManifest.xml``` :


```
        <receiver android:name=".AlarmReceiver"/>
```


In ```MainActivity.onCreate``` set an alarm. The alarm should repeat
roughly every 60 seconds, and should wake the device. The action of
the alarm should be to start ```AlarmReceiver```. The documentation on
[alarms](http://developer.android.com/training/scheduling/alarms.html)
will help you here.

(We would typically use alarms for much longer durations. For example,
for our daily photo app we might set the alarm to run once per
day. However, this short interval will be useful for testing and
debugging. It would be quite frustrating to have to wait a day to
determine if the alarm code you wrote is working properly...)

At this point you can run your app, and you should see log messages
from ```BroadcastReceiver``` indicating that ```onReceive``` is being
called.

Now let's go back to ```AlarmReceiver``` and finish implementing
```onReceive```. Follow this
[guide](https://web.archive.org/web/20160303170900/https://developer.android.com/guide/topics/ui/notifiers/notifications.html#SimpleNotification)
(and in particular the section "Creating a simple notification"). The
action of this notification will be to start
```MainActivity```. (I.e., clicking on the notification takes the user
back to the app.) When building your notification, you can set the
small icon to ```R.mipmap.ic_launcher```, and you should set
[```setAutoCancel```](http://developer.android.com/reference/android/app/Notification.Builder.html#setAutoCancel%28boolean%29)
to ```true``` so that when the user clicks on the notification it is
dismissed.

Now you can run your app. When the alarm fires, you should see the
notifications that you have created. Notice that the alarm continues
to fire even after you have closed the app.

### Conserving power

Now we will modify our app to conserve power when the battery is low
by disabling the alarm. Android sends an ```ACTION_BATTERY_LOW```
intent when the system changes to a low battery state, and an
```ACTION_BATTERY_OKAY``` intent when the battery level is high enough
again after previously being low. We will receive these intents to
change the behavior of our app.

In ```MainActivity``` create a new ```BroadcastReceiver``` called
```batteryInfoReceiver``` and ```@Override``` its ```onReceive```
method. This will look like this:

```
private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
    }
};
```

In ```MainActivity.onCreate``` create a new ```IntentFilter``` that
includes the actions ```ACTION_BATTERY_LOW``` and
```ACTION_BATTERY_OKAY```. Register ```batteryInfoReceiver``` so that
it will receive any intent that matches the filter you just created.

Hint: Create an
[```IntentFilter```](http://developer.android.com/reference/android/content/IntentFilter.html)
and call ```addAction``` to add the appropriate actions to it.

Hint: [```registerReceiver```](http://developer.android.com/reference/android/content/Context.html#registerReceiver%28android.content.BroadcastReceiver,%20android.content.IntentFilter%29)


Now implement ```batteryInfoReceiver.onReceive()```. If an
```ACTION_BATTERY_LOW``` intent is received, cancel the alarm. If an
```ACTION_BATTERY_OKAY``` intent is received, set the alarm just like
you did previously. Also show a ```Toast``` indicating which intent
was received.

We dynamically registered ```batteryInfoReceiver``` and so we also
need to unregister it to avoid memory leaks. ```@Override```
```MainActivity.onDestroy()``` and unregister
```batteryInfoReceiver``` here.

#### Note about testing

This portion of the lab is best tested on an Android emulator (which
you might have installed on your own computer, but is not available on
the lab machines). The Android emulator allows you to easily simulate
a device's battery state or location, receiving a text message, etc.

This portion of the lab will be very difficult to test if you are
using a physical device, and not an Android emulator. (You would have
to wait for the battery to become low to be able to test if the app
responded correctly!) For the purposes of this lab, if you are testing
on a physical device, instead have the app cancel the alarm if the AC
power is disconnected, and set the alarm when the AC power is
connected. To do this, just use ```ACTION_POWER_DISCONNECTED```
(instead of ```ACTION_BATTERY_LOW```) and ```ACTION_POWER_CONNECTED```
(instead of ```ACTION_BATTERY_OK``` ).

You will not be able to test this portion of the lab on the Android VM
on the computers in the lab.


## Deliverables

Show your working app running on an emulator to the instructor or TA




