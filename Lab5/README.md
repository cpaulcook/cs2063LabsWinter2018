# Lab 6 - AsyncTask

In lecture we've seen the importance of moving long-running operations
off of the UI thread and into a worker thread. In this lab you will
implement (portions of) this functionality using an ```AsyncTask```.

Start by downloading the Lab 6 skeleton code.

This app uses the master/detail flow (MDF) pattern, which we briefly
saw in lecture 2. This app is similar in structure to an app created
using the default MDF template available through Android Studio (and
similar to the MDFDemo in the Examples directory). It presents a list
of recent earthquakes downloaded from the United States Geological
Survey. Selecting an earthquake presents further details about it. On
a small device, this is a separate activity; on a larger device, the
details are presented alongside the scrolling list.

This
[website](https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php)
describes a variety of [JSON](http://www.json.org/) feeds that provide
information about recent earthquakes. We will use data from the feed
that provides information about
[all earthquakes in the past day](https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson).

## Understanding the skeleton code

The MDF pattern employs multiple default layout files to make the UI
adapt to different screen sizes and orientations:

* activity_geodata_detail.xml
* activity_geodata_list.xml
* geodata_detail.xml
* geodata_list.xml
  * geodata_list.xml
  * geodata_list.xml (w900dp)
* geodata_list_content.xml


The best way to get your bearings in an existing project file is to
navigate to the ```AndroidManifest.xml``` and determine which
```Activity``` (represented by your Java source code files) contains
the ```<intent-filter>``` signifying it’s the ```MAIN```
```Activity```. This ```Activity``` will be identified by the
```android:name``` field. You can navigate to this Java file and see
which layout file it instantiates using ```setContentView()```; this
will be the first screen users are presented with when this
application is run. Navigate to the layout file being utilized by
```setContentView()``` in your ```MAIN``` ```Activity```.

Take a look at this and other layout files in both the Text and Design
editors. Recall that fragments must be hosted by an ```Activity```;
here, those ```Activity``` layouts are represented by
```activity_geodata_detail.xml``` and
```activity_geodata_list.xml```. Investigating
```activity_geodata_list.xml``` we can see it contains
```framelayout``` which includes the layout
```geodata_list```(.xml). Given there are two ```geodata_list.xml```
files, the Android operating system must decide which layout to
present. It does this based on screen size (which can be affected by
orientation). Here, the layout file containing ```w900dp``` will be
the one used for tablets in landscape mode, allowing both the list of
earthquakes and the details of the selected earthquake to be displayed
simultaneously side-by-side. The layout file without a screen size
modifier is the one that will be used for phones.

Take a look at the phone ```geodata_list.xml``` layout. Inside it we
see a single UI element, a ```RecyclerView```. The ```RecyclerView```
will be used as a scrolling list of earthquakes that, once selected,
will present a detailed description about that particular
earthquake. Now examine the other ```geodata_list.xml``` file. It
contains a ```RecyclerView``` and a ```FrameLayout``` (with id
```geodata_detail_container```) that will be programmatically set to
contain a ```Fragment``` representing earthquake details.

Going back to the ```GeoDataListActivity``` Java file we'll now
explore how fragments get managed based on what screen size we are
running on. Notice that ```GeoDataListActivity``` has a private
boolean variable ```mTwoPane```. This member variable represents
whether we are running on a screen size appropriate for displaying
both the earthquake list and earthquake details simultaneously. If
this variable is not ```true```, we assume we are running on a smaller
screen device such as a phone and the Android OS will deliver the
layout necessary to fit that screen size. If the variable is
```true``` the Android OS will deliver the layout details necessary to
put that user experience into effect.

The ```GeoDataListActivity``` class ```onCreate()``` method will
instantiate the ```MAIN``` ```Activity```, provide it the described
layout in ```setContentView()```, and handle managing ```Fragment```
attachments. Because we are designing our application for a positive
user experience on both phone and tablet, there are some important
details regarding how this is accomplished. First, notice we
instantiate a ```FragmentManager```. This manager will control which
fragments are active in the application based on the logic we provide
(in this case, the logic implemented by the MDF template).

This template checks if the ```geodata_detail_container```, which is
a ```NestedScrollView``` UI element in the
```activity_geodata_detail.xml```, is ```null```. If the
```geodata_detail_container``` is ```null```, we are in single pane
layout (i.e., a phone or tablet in portrait mode); if the
```geodata_detail_container``` is not ```null```, we are in a dual pane
layout (i.e., a tablet in landscape mode) utilizing fragments.

## Todo

Complete the TODOs in ```GeoDataListActivity``` and ```DataModel```.

Make sure your app behaves as expected with and without a network
connection. Make sure the floating action button (pink button in the
bottom right corner) still works while the data is refreshing.

If testing on a phone, it will be difficult to test that your app
displays the tablet landscape view correctly (i.e., the list of
earthquakes and selected earthquake details side-by-side). To see this
behavior, add a third layout resource file for ```geodata_list```
corresponding to landscape layout. Make its contents the same as
```geodata_list.xml (w900dp)```.


## Deliverable

Show your working app to the instructor or TA.
