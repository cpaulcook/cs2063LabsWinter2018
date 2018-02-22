# Storage: SQLite Databases

## Introduction

In this lab you will build a simple app that uses an
[SQLite database](https://www.sqlite.org/). 

You are provided with skeleton code, which includes two Java files:
```MainActiviy``` and ```DBHelper```. ```DBHelper``` is a subclass of
```SQLiteOpenHelper```. This class creates a database that has three
columns: an id, item, and number.

The app allows the user to add new rows to the database. The app also
allows the user to search for rows that have a particular item. Below
is a sample screenshot of the app after the user has searched for the
item "Cats". In this case the database had three rows with the item
"Cats" with the numbers "3", "5", and "10". (Note that the results
have been sorted by number.)

![Main Activity](https://i.imgur.com/cWblnHD.png?1)

In the case that a search item does not match any rows in the
database, a message indicating this is displayed, as shown below.

![Main Activity](https://i.imgur.com/wQ7Ub7F.png?1)



## Resources

The following documentation might be helpful in this lab.

SQLite databases in Android:
https://developer.android.com/training/data-storage/sqlite.html

(Android has recently introduced an alternative to SQLite databases
called the Room Persistence Library, mentioned in this
documentation. We won't be using that today, but you might want to
learn about it for your project.)

SimpleCursorAdapter: https://developer.android.com/reference/android/widget/SimpleCursorAdapter.html

The SQLite database example from class might also be helpful:
https://github.com/cpaulcook/cs2063LabsWinter2018/tree/master/Examples/DBDemo

## Todo


Read the skeleton code and make sure you understand what it's doing.

Complete the TODOs.

## Deliverables

Show your working app to the instructor or TA

