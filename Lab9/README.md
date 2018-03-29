# Sensors

## Pair Programming

We will again be doing pair programming for this lab. See the README
from the previous lab for instructions on, and motivation for, pair
programming. You can again work with anybody of your choosing.

**To receive credit for this lab you must pair program.**

**Switch between the roles of navigator and driver every 10 to 15
minutes.**

## Introduction

In this lab you will build an app that displays a ball that the user
can control by tilting the device. You will also learn about low- and
high-pass filters.

You won't be able to test this app on the emulator. If you don't have
an Android device, you should choose a partner who does.

## Resources

The following documentation might be helpful for this lab.

http://developer.android.com/guide/topics/sensors/sensors_overview.html

http://developer.android.com/guide/topics/sensors/sensors_motion.html


## Todo

Read the skeleton code and make sure you understand what it's
doing. The code will be somewhat familiar to you. This lab is based on
the previous lab, the "bubbles" lab.

Complete the TODOs **by pair programming**.

## Deliverables

Show your working app to the instructor or TA

## Final words

When using sensor data to display data on the screen, it is important
to keep in mind the differences between the sensor coordinate system,
and the screen coordinates. We've simplified things is this lab by
locking the app to landscape mode, and assuming the natural
orientation of the device is portrait (which is the case for most
Android phones and tablets, but not all of them). The app probably
won't run correctly on a device that has landscape mode as its natural
orientation. You can, however, easily tweak the app to work on such a
device.

You can read more about this issue here:

http://android-developers.blogspot.ca/2010/09/one-screen-turn-deserves-another.html
