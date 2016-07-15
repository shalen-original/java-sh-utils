# Shalen Java Utilites - java-sh-utils #

This is a library I created for my university assignments. It contains a list of useful Java functions, to use when needed.

_**Note**_: None of the methods implemented in this library was written aiming at the perfect, most optimized solution for that problem. The various methods are only asymptotically efficient. 

## Modules ##

### shutils.array ###
Handles basic array stuff such as swap and random array generation. It also implements some methods already present in the standard library (such as *clone*), because we were not allowed to use them.

### shtutils.profile ###
Contains a basic method profiler and classes related to the statistical elaboration of the results.

### shutils.data.visualization ###
Contains all the utilities that can be used to visualize data. Examples are:

* A class that represents a generic data table and allows to obtain the CSV, Latex, Matlab and HTML representation of the table;
* A class that represents a generic 2D scatter plots and allows to obtain the Latex representation of the table.

### shutils.search ###
Implements some of the most common search algorithms. As of now, *Linear search* and *Binary search* are implemented.

### shutils.sort ###
Implements some of the most common sorting algorithms. As of now, *Insertion Sort* and *Quick Sort* are implemented.

## Tests ##
The test folder contains all the JUnit test used to test if the implementation of the methods are correct. They are not the best of the world, but they will do.

## Copyright ##
All the material in this repository is licensed Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International [(CC BY-NC-SA 4.0)](http://creativecommons.org/licenses/by-nc-sa/4.0/)

The developer offers no warranty of any kind (read as: If this library breaks something you can't blame me).