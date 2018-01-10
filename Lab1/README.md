# Lab 1
This lab will introduce the Android Studio IDE and Android project structure through the creation of a simple 'Hello World!' application that will run on emulated or physical devices.

#### Lab marking

In order to get full marks for each lab you must 1.) attend the lab and work on the lab during the lab time, and 2.) show all deliverables to the instructor or TA before the end of lab (preferably), or while the instructor is taking attendance at the start of the next lab.


#### Objectives
* familiarize IDE navigation
* introduce running apps on physical and emulated devices
* introduce layout editor
* project structure breakdown, highlights
* console log, for debugging

#### Procedure
###### 1. Open Android Studio
* On the lab computers Android Studio is available under Linux, in a
  Windows VM (this is frustrating, and due to some technical
  limitations of Android Studio) Log in to Linux, then choose
  Applications → FCS VMs → Android Developer Studio VM, and then open
  AndroidStudio
* → Start a new Android Studio Project
* → Set Application name: Lab 1 Hello World
* → Company Domain: ca.unb.mobiledev, click Next

Take note of the Minimum SDK (Software Development Kit). This will be the SDK for which your apps will be compiled against. Android Studio will use this information to provide accurate auto-complete as well as provide warnings when your code is not appropriately targeting the set minimum SDK. 

While you should target the most current version of the SDK, setting a minimum SDK allows you to get backward compatability with devices running older versions, allowing your application to run on a larger percentage of devices.
* → Select Basic Activity, click Next

###### 2. Customize the Activity
Take note of the default values on this screen. Your MainActivity will
be the first activity to run when your application is launched. The
**Layout Name**: field is the name associated with this main
activity’s layout style. This **activity_main.xml** file will describe
_how_ the activity should look in terms of global design; toolbars, floating icons, dropdowns, etc. Another layout file, content_main.xml (not shown in the defaults), will provide components specific to the needs of this activity; TextViews, EditText, Buttons, etc. This idea will be expounded on in the project structure breakdown.

* → Click Finish

###### 3. Hello world!
Your application will open to a graphical user interface containing a drag-n-drop layout editor. On this window you can view your application name, Lab 1 Hello World appearing across the ActionBar/Toolbar. Also note a generic ‘Hello world!’ statement within the application body. 


###### 4. Running From Device
_Unlocking Developer Mode for Device:_

Navigate to your device Settings menu, find About Device,  locate the Build number and click it 7 times. You will receive notice that dev mode has been unlocked. Navigate back one menu to About Device; access the new Developer options menu and turn on USB debugging.

With Android Studio open, attach via USB cable an Android device to your workstation. You will need to "eject" your device from the host operating system. Then in the Android Studio VM (guest operating system) select Devices → USB and select your device. Detailed instructions on this process are available on the desktop of the Android Studio VM in "How to connect your device.txt".

On your device, press OK to allow USB debugging. Run the application by clicking Run → Run 'app'. You will be presented with the Choose Device screen. Ensure your device is selected and click OK.

Congratulations! You wrote your first app.


###### 5. Android x86

The lab computers do not have an Android Emulator installed (again due to some frustrating technical limitations). As a partial solution to address this, we instead have an Android x86 VM. To launch this, from the Linux machine select Applications → FCS VMs → Android 6 VM. Launch this VM and follow the instructions (on the desktop of the Android StudioVM) to connect to it. Now run your app on the VM.

This VM isn't as good as an Android Emulator. An emulator lets us simulate things like low battery state and receiving a text message, which this VM doesn't. It does, however, let us run apps, and test some basic functionality.


###### 5b. Android Studio Device Emulator

If you have Android Studio installed on your own computer, you'll want to configure an Android emulator and try running your app on that. This will be very helpful for future testing.

Android Studio comes equipped with built-in device emulators and options for emulating real world devices for testing the applications you develop, to ensure functionality is as you expect it across a range of device types. 

To access these emulators, locate the Run menu along the File menu bar along the top of Android Studio and click Run ‘app’. (You might need to click Stop first.) You can also run the emulator by clicking the familiar green Play button along the icon toolbar. Run the application now, and select "Create New Virtual Device". Create whatever type of virtual device you'd like to try, and run your app on this.


###### 6. Layout Editor
→ If you’ve navigated away from the layout editor, click the Project tab along the far left side of Android Studio, navigate to and double click res/layout/content_main.xml in the project structure.

→ Click the ‘Hello world!’ text in the application window preview. The text field, which is an Android object called TextView that we’ll learn more about later, is highlighted.

→ Take note of the Properties window that populates to the right. From this toolbar Android View objects can be customized. (You can also click the 'View All Properties' button to see even more options.)

→ Explore the options available, and customize this TextView. Change the font size, text colour, background colour, etc. Move the TextView around inside the app. Try selecting a different device for the layout editor; does the layout still look like you want it to? 

Note that font sizes should always be specified in 'sp', a scale-independent pixel. This is a convenient way to size fonts in Android that will ensure it stays looking good on a variety of device screens. For other objects you will want 'px' or density-independent pixels 'dp'. For more information read the [Dimension descriptions in the Android API Guide](http://developer.android.com/guide/topics/resources/more-resources.html#Dimension)

Finally, we won't be needing the floating mail icon so go ahead and select it and delete it from the view. You can't delete it from the content_main.xml file however, you'll have to navigate to /layout/activity_main.xml and remove it there. That is because it's considered a global layout element for this activity. 

If you access the Text tab at the bottom-left of the layout editor you can locate an XML line in activity_main that states ```<include layout=@layout/content_main"/>```. This tells the build process to factor in the content_main.xml layout contents into main's own.

Also note in the activity_main.xml Text tab that the entire layout you see in the layout editor appears described in XML. The same is true for content_main.xml. This provides two ways to work on Activity layouts.

Run the application by emulator once again and you’ll see the changes you’ve made reflected. 

**Deliverable 1**
Take a screenshot of your app running (on any device or emulator).

###### 7. Project Structure
We will now take a look at what every Android Studio project structure has in common to develop an understanding of how this folder structure is navigated and how each piece ties together.

More information about the project structure can be found at [https://developer.android.com/studio/projects/index.html#ProjectFiles](https://developer.android.com/studio/projects/index.html#ProjectFiles)

→ Project Structure:

	→ app
		→ manifests
			→ AndroidManifest.xml 
		→ java
			→ mobiledev.unb.ca.lab1HelloWorld
				→ MainActivity.java
			→ mobiledev.unb.ca.lab1HelloWorld (androidTest)
			→ mobiledev.unb.ca.lab1HelloWorld (test)
		→ res
			→ drawable
			→ layout
				→ activity_main.xml
				→ content_main.xml
			→ menu
				→ menu_main.xml
			→ mipmap
			→ values
				→ colors.xml
				→ dimens.xml
				→ strings.xml
				→ styles.xml
	→ Gradle Scripts


###### 7a. manifests directory

This directory contains the AndroidManifest.xml file. This file contains information that pertains to how your application should run, what activities within your project it depends on, and of those which is to run when the application is first launched, as well as any device/account access permissions users must agree to before being able to download your application if placed on the Google Play Store. 

Additional AndroidManifest.xml information: [https://developer.android.com/guide/topics/manifest/manifest-intro.html](https://developer.android.com/guide/topics/manifest/manifest-intro.html)

**Deliverable 2** The application theme is also described in this AndroidManifest file; provide the attribute tag that describes this.

Note the android:label attribute tag contains the application name we gave to our project. If you click this an @string resource named app_name will be revealed in as being the source of this text. We’ll explore the strings.xml resource below.

###### 7b. java directory

This java folder contains a sub-directory for your application code ```mobiledev.unb.ca.lab1introduction```, and sub-directories for testing. We'll focus on the non-test folder for now.

Given that no additional content has been added to the project in terms of Java classes so far, the only java resource file is our MainActivity.java that is generated when we created the project. Opening this file will reveal some familiar Java syntax and perhaps some unfamiliar Java syntax as well. 

A class named MainActivity is declared and the file contains some imports and the package under which this file belongs is denoted. The ```@Override``` annotation indicates that the subsequent method is being overwritten against the super methods from the extended Activity class.

Here we see ```onCreate()```, ```onCreateOptionsMenu()```, and ```onOptionsItemSelected()``` are all overridden. They take as parameters a ```Bundle```, ```Menu```, and ```MenuItem``` object respectively. In ```onCreate()``` the ```Bundle``` is passed up to the superclass from which we are overriding. Read the comments auto-generated for ```onCreateOptionsMenu()``` and ```onOptionsItemSelected()``` to discover their purpose.

Explore http://developer.android.com/reference/android/app/Activity.html and find the method ```setContentView()``` that is used inside the ```onCreate()``` method. Be sure to find the method which takes the proper parameter type, in this case a layout resource ID. 

**Deliverable 3** Describe what the ```setContentView()``` method call accomplishes for your application

Because we've removed the FloatingActionButton in our layout, let's go ahead and remove the code pertaining to this button from our ```onCreate()``` method. Find these lines and delete them.

```java
FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
```

###### 7c. res directory

This directory contains many different types of resources that get used inside an application. The drawable folder, empty for now, can contain custom image files that can be utilized in your application to add finely customized theming or object styles, icons or any other visual assets necessary for your application.

The layout directory contains activity_main.xml and content_main.xml. The actvivity_main.xml is the resource that is sent as a parameter to the ```setContentView()``` method call in our MainActivity.java class file discussed above. Open this file to once again reveal the GUI layout editor. Near the bottom left corner of this layout editor window, switch from the Design tab to the Text tab.  You’ll be presented with a hierarchy of XML tags each containing attributes relevant to defining the layout for the application you created in the GUI editor. Layouts can be designed in either fashion, by GUI or XML. The menu directory contains a similar file for customizing the layout for menu appearances in your application.

Explore http://developer.android.com/guide/topics/ui/declaring-layout.html. 

**Deliverable 4** What are the three common layout types? Why is it important to define IDs for view objects, especially when using RelativeLayout? 

The mipmap directory contains icons used for launch deck icons for the application. Note how multiple files are supplied; this is to target devices with differing levels of pixel density screens.

Under the values directory there first is a colors.xml. Initially this file contains the ```Primary```, ```Primary Dark```, and ```Accent``` colors for your application. These are used to simply create a cohesive color scheme experience across the application by allowing the Android OS to allow existing Android View Object components to rely on these three initial colors for coloring common application components (```TaskBars```, etc.). 

Second is a dimens.xml directory that contains XML containing Android Design guideline levels of margin and padding for application viewing. 

Most interesting in the values directory are the strings.xml and styles.xml. Open strings.xml and you’ll see XML tags containing the application name and the default Settings menu text display. This allows a string to be referenced in multiple locations within an application and only require being altered in one location to propagate changes throughout the app. New strings can be defined here and then referenced using the ```@string/string_name``` syntax we saw earlier. You can change your application string name here and it will be reflected along your application ```Toolbar``` when the activity is run.

The styles.xml is where application theming and specific Android object styling can be achieved. We will cover styles and theming in a future lab.

Under Gradle Scripts the file ```build.gradle (Module: app)``` is used to establish build requirements to ensure the proper syntax are being met for your target SDK choice. Notice there is a mindSdkVersion, targetSdkVersion, and versionCode value. The minSdkVersion indicates what the lowest SDK that is supported by your application. The targetSdkVersion is the optimized version you have in mind for your device; the general approach is to design with the newest in mind and support as large a percentage of the device population as possible. If the versionCode value is changed from one application development to the next, users will have updates triggered on their device.

###### 8. Supporting Different Languages

Now that we’re familiar with the strings.xml resource file, let’s take a look at how to add locale-specific string support.  On the Project Structure tab along the left-hand side of Android Studio, at the top where it currently says Android, set the view to Project.

![](http://i.imgur.com/BfxJ6ZO.png)

Right click the app/src/main/res directory and select New → Android resource directory. Set the directory name to values-es. Repeat the same process and set the directory name to values-fr.

Now right-click each of these folders and create a New → Values resource file and call each strings.xml. 
In the values-es/strings.xml file, add the following:

```xml

<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Mi Aplicación</string>
    <string name="action_settings">Ajustes</string>
</resources>
```
In the values-fr/strings.xml file, add the following:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Mon Application</string>
    <string name="action_settings">Paramètres</string>
</resources>
```

Run the application via the emulator once again. Access the settings menu from inside the emulator and set the language to French. Then locate your application icon in the application deck. Open your application and you will see your French strings have been selected based on your custom locale choice. Set the locale to es-Spanish and do the same. 

Notice that the string "Hello World!" is unaffected! This is because this string is hard-coded in content_main.xml. This is bad practice. Add a new string for "Hello World!" (or its translation) to each of your string resource files. Then modify content_main.xml to use this new string.

Once you've done this, take screenshots of your application with French and Spanish translations and save them. Then set the language of the emulator back to your preferred language.


###### 9. Console Log Debugging

Being able to identify what is occurring within your application at certain points in the running cycle is important for any development process. Android Studio offers the ability to have log messages printed to the console. Open MainActivity.java. Under the MainActivity class declare the following string:

```java
private static final String TAG = "MainActivity";
```

Now, inside ```onCreate()```, add the following:

```java
Log.i(TAG, "This is a log display!");
```

You will also need to add an ```import``` statement.

Run the application via the emulator or device once more. Along the bottom portion of Android Studio, click the Android Monitor tab. Set the log-level dropdown to Info and search for MainActivity. You'll be presented with a console log information that you built into the ```onCreate()``` function. This tactic can be utilized throughout the development cycle to test certain portions of your code to know how an application is behaving and where in the Activity lifecycle your application may be encountering problems.

**Deliverable 5** Take and save a screenshot of the log message window.

