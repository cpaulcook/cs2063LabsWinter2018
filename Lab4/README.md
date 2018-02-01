# Lab 4: Scrolling lists

## Pre-lab reading

If you haven't yet done so, read the following documentation on
`RecyclerView`. This lab assumes you have read it.

https://developer.android.com/training/material/lists-cards.html (only
the section "Create Lists")

https://developer.android.com/guide/topics/ui/layout/recyclerview.html

## Introduction

Many mobile applications need to display a scrollable list of items,
where the user can select an item to take some action specific to
it. In this lab you will build an app that displays a scrolling list
of UNB CS courses (including course numbers, titles and credit
hours). Selecting a course from the list of courses in the main
activity takes the user to a detail activity showing the description
for the selected course. Here are screenshots of the app to show how
it works. (Yes, the course information we're using in this lab is a
bit out of date...)

![Main Activity](https://i.imgur.com/8vQZmXf.png?1)

![Detail Activity](https://i.imgur.com/qaqnSXb.png?1)

There are two common ways to display a scrolling list of items in
Android, a
[`ListView`](https://developer.android.com/guide/topics/ui/layout/listview.html)
and a
[`RecyclerView`](https://developer.android.com/guide/topics/ui/layout/recyclerview.html). The
`RecyclerView` offers greater flexibility, so we'll use it today.

Start by importing the Lab 4 skeleton project.

## Understanding the skeleton code

Note that there are four Java classes:

* `Course` represents a course (!). It provides methods to get the
  course title and description.

* `DataModel` accesses a ```JSON``` asset file included in the project
(in ```assets/CS.json```). This ```JSON``` file contains information
about Computer Science courses available at UNB. The ```DataModel```
class processes the ```JSON``` to create ```Course``` items. Note in
particular the `DataModel` constructor and the argument it takes, and
the `DataModel.getCourses()``` method.

* `DetailActivity` will correspond to the second screenshot above,
  displaying information about a specific course. It doesn't do much
  yet. You will complete it during the lab.

* `MainActivity` presents the scrolling list of courses using a
  `RecyclerView`. It contains an inner class `MyAdapter` that extends
  `RecyclerView.Adapter`. The `RecyclerView.Adapter` class provides a
  layer of abstraction between the `RecyclerView`'s `LayoutManager`
  and the underlying data that is being displayed, in this case a list
  of `Course` objects. `MyAdapter` itself contains an inner class,
  `ViewHolder` which represents an individual item to display in the
  scrolling list. `onCreateViewHolder` creates `ViewHolder` objects by
  inflating the corresponding XML layout resource file; it's already
  implemented for you. `onBindViewHolder` will be called when a
  particular item in the dataset needs to be displayed in the
  scrolling list, i.e., the user has scrolled and a new item comes
  into view. This method sets up the `ViewHolder` to display the
  corresponding item in the dataset. It is incomplete. You will finish
  it below.

Now take note of the layout files. `activity_detail.xml` and
`activity_main.xml` are layouts for `ActivityDetail` and
`ActivityMain`, respectively. (You can verify this by looking at the
calls these classes make to `setContentView()`.) `activity_main.xml`
includes a `RecyclerView`. Its `LayoutManager` has been set to a
`LinearLayoutManager` to give a list of items (as opposed to, for
example, a `GridLayoutManager` which would present the items in a
grid).

`item_layout.xml` will be used to display each item in the scrolling
list in `ActivityMain`. It contains just a single `TextView`.

## Implementation

Complete the TODOs in `MainActivity`

Then complete the TODOs in `DetailActivity`. I've included some hints
below.

TODO 3: On a smaller device, or for a very long course description,
all of the text won't fit on the screen, so we need to be able to
scroll the text. There are a variety of ways to make a `TextView`
scrollable. Try to independently figure out how to do this. (Google is
your friend and has the answer!) If you get stuck, let the instructor
or TA know, and we'll try to point you in the right direction.

TODO 4: The `ActionBar` corresponds to the text at the top of the
detail activity in the screen shot above (i.e., "CS2063 Introduction
to M..."). This might help you: [```getSupportActionBar()```](http://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html#getSupportActionBar%28%29)


## Deliverable

Show your working app to the instructor or TA.
