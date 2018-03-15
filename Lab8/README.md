# Lab 8


In lecture we've seen how to detect gestures, create animations, and
play sounds. In this lab we'll put these pieces together to create a
game-like app.

The "game" begins with a blank screen. Tapping on the screen will
create a bubble at that location. The bubble will have a random size,
rotation, and direction of movement. Tapping on a bubble will pop it
and play a popping sound. Starting a fling gesture on a bubble will
fling that bubble off the screen, at a velocity determined by the
fling gesture. If left alone, a bubble will eventually move off the
screen. A counter at the bottom of the screen keeps track of the
number of bubbles on the screen.

If you'd like to see the app in action, a sample solution has been
installed on the tablet that the instructor has in the lab. Try it
out!

## Pair Programming

Pair programming has many benefits in software development, CS
education, and particularly learning mobile application development
(Seyam and McCrickard, 2016). In this lab, we will try pair
programming. You must work in pairs. You can work with anybody of your
choosing. (You will probably benefit most if you work with someone
other than your partner for the course project, but that's not a
requirement today.)

One of you will be the "driver"; the other will be the
"navigator". The driver types at the computer, while the navigator
reviews what is being written and watches for mistakes. Every 15
minutes, the driver and navigator should switch roles.

In a common model of pair programming the driver and navigator use a
single computer. Today we won't be quite so strict. The driver and
navigator will use a single instance of AndroidStudio, but can use
multiple computers (e.g., you might want AndroidStudio open on one lab
machine, and a browser with documentation on another).

**To receive credit for this lab you must pair program.**

Mohammed Seyam and D. Scott McCrickard. 2016. Teaching Mobile
Application Development with Pair Programming. In *Proceedings of the
47th ACM Technical Symposium on Computer Science Education (SIGCSE
2016)*, pages 96-101. Memphis, USA.

## Todo

Examine the code to get an understanding of what's already
implemented. You don't need to understand every line, but should
understand the overall structure of the app.

This lab requires you to learn independently and read lots of
documentation. The help section below gives you some pointers. Ask
questions if you get stuck!

Complete the TODOs in ```BubbleActivity``` by pair programming.

Have fun!

## Help

```SoundPool```:
http://developer.android.com/reference/android/media/SoundPool.html
Also see the ```SoundPool``` example on the course github.

```MotionEvent```:
http://developer.android.com/reference/android/view/MotionEvent.html 

See the ```GestureDetector``` examples here:
http://developer.android.com/training/gestures/detector.html and on
the course github for how to delegate ```MotionEvent```s.

See https://docs.oracle.com/javase/6/docs/api/java/util/Random.html
for information on generating random numbers in Java.

```Bitmap``` documentation (including how to create a scaled
```Bitmap```) http://developer.android.com/reference/android/graphics/Bitmap.html

More information on ```Canvas```:
http://developer.android.com/reference/android/graphics/Canvas.html


## Deliverable

Show your working app to the instructor or TA.

## Credits

This lab is based on materials from [Adam
Porter](https://github.com/aporter).
