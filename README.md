# CoffeeGrinder-Java

## Requirements
Write an application that meets the following requirements:

1. A screen that displays a list of items from the following endpoint https://videotutoriale.com/coffee/coffee.php
2. Displays a detail screen when an item is selected by passing the item's ID to the endpoint like this https://videotutoriale.com/coffee/coffee.php?id=8.

The use of 3rd party libraries is acceptable.  The goal is provide an opportunity to show off and allow us to better evaluate your skill level
Make the project as advanced ( Swing / JavaFX UI ) or as simple ( Console ) as your time allows.  
Main focus should be on good sofware design principles, some basic stub classes have been created to provide a starting point, there is no requirement to use them
  - Model/View/Controller
  - Interfaces vs Implementation
  - Use of appropiate design patterns
  - High cohesion / Low coupling

The use of 3rd party libraries is acceptable.

## Gradle 
A Gradle project ( v5.4.1 ) has been setup with some initial dependencies that may be of use, there is no requirement to use them. 
The following commands can be used to build/clean/run/test the project. \
gradlew clean \
gradlew build \
gradlew run \
gradlew test

Application is expected to build and run by using the following command: \
'gradlew clean build run'

## IDE ( Experimental )
gradlew eclipse - Generate an eclipse project \
gradlew idea - Generate an IDEA project

## Other things to consider
* Error handling
* Multi-Threading
* Unit Tests
* Code Style
* Documentation
  - Yup, we all hate it.  Doesn't mean we shouldn't do it