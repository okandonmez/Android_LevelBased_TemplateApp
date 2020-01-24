# Android Level Based Template App
This repository is an Android project that contains a draft structure for my own projects, waiting for a completely independent design concern graphic to be added. Developed with native Java language, it is templated for my applications running on the level unlock logic as a result of progress.

## What Does it Contain ?
- Splash Screen
- Main Screen
- Level Choose Screen
- Game Scene

### Splash Screen
  - It is a simple splashscreen, so it is coded in the logic of transitioning to a new activity after waiting for a certain time. It takes the waiting time from the parameter in the splash function.

  - In the layout design of the screen, a logo and the title below it await in the middle of the screen horizontally.

### Main Screen
  - Main screen is basically a game that contains a logo for a game with buttons such as start game, help or social media directions.
  
### Level Choose Screen

 - Level choose screen is the page that reads the last part of the phone's memory and offers the user a screen design according to it, and is used to select a level. To change the content of this web page
    - layout structure of the relevant page
    - The file named "single_item" defining the adapter of gridview should be changed.


### Game Scene
 - In the game scene, only the jobs that the level should be completed successfully were programmed and left blank for new applications. When the level is completed successfully, it is a function that increases the level index if it needs to be increased by reading the level index recorded with the last success in the phone memory.
 
## What technologies are used ?
- Gradle : 
```
dependencies {
        classpath 'com.android.tools.build:gradle:3.4.1'
}
```
- and so
```
repositories {
        google()
        jcenter()
        
    }
```

- Managing for phone memory:
```
SharedPreferences
```


