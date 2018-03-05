# Lab Exam

This lab exam is open everything (Android documentation, labs and
examples, stackoverflow, Google, etc.). **You must not communicate with
others (in person or online) during the exam.**

## The Ducktionary App

Today you will build a dictionary app that gives definitions for
English words that include the substring *duck*. We will therefore
call this a "Ducktionary"!

This app will consist of two activities. The main activity will
include a ```RecyclerView``` where the items are English
words. Clicking on a word will take the user to a detail activity that
shows definitions for the word that was clicked. Pressing back from
the detail activity takes the user back to the main activity. See
examples of both activities below.

###Main activity:

![Main Activity](https://i.imgur.com/MVNM1ma.png)

<!-- https://imgur.com/MVNM1ma -->
<!-- https://i.imgur.com/MVNM1ma.png -->

###Detail activity:

![Detail Activity](https://i.imgur.com/TeCi3sJ.png)

<!-- https://imgur.com/TeCi3sJ -->
<!-- https://i.imgur.com/TeCi3sJ.png -->

## Skeleton Code

You have been provided with skeleton code. The structure of the app
will be familiar to you from previous labs.

```DataModel.java``` loads the dictionary data from a JSON assets
file. This JSON file stores English words that contain the substring
*duck* and their corresponding definitions.


```DictionaryEntry.java``` is a class representing a dictionary entry,
i.e., a word and its definition.

```MainActivity.java``` will display a list of words using a ```
RecyclerView```. When a word is clicked ```DetailActivity``` will be
launched via an explicit ```Intent```.

```DetailActivity.java``` will display a word and its definition.


## Todo

Complete the TODOs in ```MainActivity.java``` and ```DetailActivity.java```.

**You may only modify ```MainActivity.java``` and
```DetailActivity.java```. You must not make changes to any other
files.**

## Hints

Here are links to some documentation that might be helpful:

[```AsyncTask```](http://developer.android.com/reference/android/os/AsyncTask.html)

[```Activity.getSupportActionBar()```](http://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html#getSupportActionBar%28%29)

## Deliverables

When you are done, submit ```MainActivity.java``` and
```DetailActivity.java``` to the LabExam Dropbox folder on D2L.

You can find these files in this relative path: ```cs2063labs/LabExam/LabExam/app/src/main/java/mobiledev/unb/ca/labexam```


## Final Words

Good luck, and have fun!

If you get stuck, ask a question. This is an exam, so the instructor
and TA can only provide limited answers. However, depending on the
nature of the problem, they might be able to help.

In any case, submit your best effort. Your code will be read when it
is marked, so it is possible to do well on this exam even if your code
does not run correctly.

In case you're curious, the dictionary data that has been
provided comes from [WordNet](http://wordnet.princeton.edu/).
