# Lab Exam

This lab exam is open everything (Android documentation, labs and
examples, stackoverflow, Google, etc.). **You must not communicate with
others (in person or online) during the exam.**

## The NB Lakes App

Today, 22 March, is
[World Water Day](https://en.wikipedia.org/wiki/World_Water_Day). We
will celebrate this occasion by building an app that displays
information about lakes in New Brunswick.

This app will consist of two activities. The main activity will
include a ```RecyclerView``` where the items are names of lakes in New
Brunswick, along with checkboxes that the user can check when they
have visited a lake.

Clicking on the name of a lake will take the user to a detail activity
that shows the latitude and longitude for the lake that was clicked,
and a button to view the Wikipedia entry for the lake (if
available). Pressing back from the detail activity takes the user back
to the main activity. See examples below.

The instructor has Android devices with a sample solution
installed. You can ask to briefly borrow one of these devices to see
the intended functionality.

### Main activity:

![Main Activity](https://i.imgur.com/xyA5qxL.png?1)

### Detail activity:

![Detail Activity](https://i.imgur.com/znqsTu8.png?1)

## Skeleton Code

You have been provided with skeleton code. The structure of the app
will be familiar to you from previous labs.

```DataModel.java``` loads the lake data from a JSON assets file. This
JSON file stores information about lakes in New Brunswick.

```LakeInfo.java``` is a class representing information about a lake,
including its name, id (a unique identifier for the lake), latitude,
and longitude, as well a URL for its Wikipedia entry, and a boolean
indicating whether this URL is null. (Unfortunately, many lakes in New
Brunswick do not have Wikipedia entries. A list of the lakes with
Wikipedia entries is provided below.)

```MainActivity.java``` will display a list of names of lakes using a
``` RecyclerView```. When the name of a lake is clicked
```DetailActivity``` will be launched via an explicit
```Intent```. ```MainActivity``` will use ```SharedPreferences``` to
store information about which lakes the user has visited. For example,
in the screenshot for ```MainActivity``` the user has visited Adams
Lake and Amelia Lake. For the ```SharedPreferences``` the keys will be
lake ids and the values will be booleans (with true representing that
a user has visited a lake, and false representing that a user has not
visited a lake). If an id is not found in the ```SharedPreferences```
its value will be assumed to be false.

```DetailActivity.java``` will display information about a lake.

## Todo

Complete the TODOs in ```MainActivity.java``` and ```DetailActivity.java```.

The TODOs related to the ```SharedPreferences``` are labeled as
```TODO: SharedPreferences```. I recommend you do the other TODOs
first, and then come back to these ones.

**You may only modify ```MainActivity.java``` and
```DetailActivity.java```. You must not make changes to any other
files.** If you think you need to modify any other file, ask the
instructor or TA.

## Hints

Here are links to some documentation that might be helpful. All of
these, except for the ```AsyncTask``` documentation, are also included
in the skeleton at the point where they might be helpful.

### MainActivity

<http://developer.android.com/reference/android/os/AsyncTask.html>

<https://developer.android.com/reference/android/widget/CheckBox.html>

<https://developer.android.com/reference/android/widget/CompoundButton.html#setChecked(boolean)>

<https://developer.android.com/reference/android/content/SharedPreferences.html#getBoolean(java.lang.String,%20boolean)>

<https://developer.android.com/reference/android/content/SharedPreferences.html#edit()>

<https://developer.android.com/reference/android/content/SharedPreferences.Editor.html#putBoolean(java.lang.String,%20boolean)>

<https://developer.android.com/reference/android/content/SharedPreferences.Editor.html#apply()>

### DetailActivity

<https://developer.android.com/guide/components/intents-common.html#Browser>

<https://developer.android.com/reference/android/net/Uri.html#parse(java.lang.String)>

<https://developer.android.com/reference/android/content/Intent.html#resolveActivity(android.content.pm.PackageManager)>



## Lakes with Wikipedia entries

The following lakes have Wikipedia entries. (This will be useful
for testing your app.)

* Bolton Lake
* Cassidy Lake
* Chamcook Lake
* Grand Lake (the first one)
* Lake George
* Lake Utopia
* Lockhart Lake
* Skiff Lake
* Spednic Lake


## Deliverables

When you are done, submit ```MainActivity.java``` and
```DetailActivity.java``` to the LabExam Dropbox folder on D2L.

You can find these files in the directory at this relative path: ```LabExamSkeleton/app/src/main/java/mobiledev/unb/ca/labexam/```


## Final Words

Good luck, and have fun!

If you get stuck, ask a question. This is an exam, so the instructor
and TA can only provide limited answers. However, depending on the
nature of the problem, they might be able to help.

In any case, submit your best effort. Your code will be read when it
is marked, so it is possible to do well on this exam even if your code
does not run correctly.

In case you're curious, the information about lakes comes from
[GeoNames](http://www.geonames.org/).

