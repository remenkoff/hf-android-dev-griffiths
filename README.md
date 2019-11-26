# hf-android-dev-griffiths

Practical part of the "Head First Android Development" book.

## Chapter 1. Getting started: Diving in

Key points:

- Versions of Android have a version number, API level, and code name.
- Android Studio is a special version of IntelliJ IDEA that interfaces with the Android Software Development Kit (SDK) and the Gradle build system.
- A typical Android app is composed of activities, layouts, and resource files.
- Layouts describe what your app looks like. They’re held in the `app/src/main/res/layout` folder.
- Activities describe what your app does, and how it interacts with the user. The activities you write are held in the `app/src/main/java` folder.
- `AndroidManifest.xml` contains information about the app itself. It lives in the `app/src/main` folder.
- An AVD is an Android Virtual Device. It runs in the Android emulator and mimics a physical Android device.
- An APK is an Android application package. It’s like a JAR file for Android apps, and contains your app’s bytecode, libraries, and resources. You install an app on a device by installing the APK.
- Android apps run in separate processes using the Android runtime (ART).
- The `<TextView>` element is used for displaying text.

## Chapter 2. Building Interactive Apps: Apps that do something

Key points:

- The `<Button>` element is used to add a button.
- The `<Spinner>` element is used to add a spinner, which is a drop-down list of values.
- All GUI components are types of view. They inherit from the Android View class.
- `strings.xml` is a String resource file. It’s used to separate out text values from the layouts and activities, and supports localization.
- Add a String to `strings.xml` using: 

```XML
<string name="name">Value</string>
```

- Reference a String in the layout using: `"@string/name"`
- Add an array of String values to `strings.xml` using: 

```XML
<string-array name="array">
    <item>string1</item>
    ...
</string-array>
```

- Reference a `string-array` in the layout using: `"@array/array_name"`
- Make a button call a method when clicked by adding the following to the layout: `android:onClick="clickMethod"`
- There needs to be a corresponding method in the activity: 

```Java
public void clickMethod(View view) { 
    // ...
}
```

- `R.java` is generated for you. It enables you to get references for layouts, GUI components, Strings, and other resources in your Java code.
- Use `findViewById()` to get a reference to a view.
- Use `setText()` to set the text in a view.
- Use `getSelectedItem()` to get the selected item in a spinner.
- Add a custom class to an Android project by going to `File menu → New ... → Java Class`.

## Chapter 3. Multiple Activities and Intents: State your intent

Key points:

- A `task` is two or more activities chained together.
- The `<EditText>` element defines an editable text field for entering text. It inherits from the Android `View` class.
- You can add a new activity in Android Studio by choosing `File → New... → Activity`.
- Each activity you create must have an entry in `AndroidManifest.xml`.
- An intent is a type of message that Android components use to communicate with one another.
- An explicit intent specifies the component the intent is targeted at. You create an explicit intent using:

```Java
Intent intent = new Intent(this, Target.class);
```

- To start an activity, call `startActivity(intent)`. If no activities are found, it throws an `ActivityNotFoundException`.
- Use the `putExtra()` method to add extra information to an intent.
- Use the `getIntent()` method to retrieve the intent that started the activity.
- Use the `get*Extra()` methods to retrieve extra information associated with the intent. `getStringExtra()` retrieves a String, `getIntExtra()` retrieves an int, and so on.
- An activity action describes a standard operational action an activity can perform. For example, to send a message, use `Intent.ACTION_SEND`.
- To create an implicit intent that specifies an action, use:

```Java
Intent intent = new Intent(action);
```

- To describe the type of data in an intent, use the `setType()` method.
- Android resolves intents based on the named component, action, type of data, and categories specified in the intent. It compares the contents of the intent with the intent filters in each app’s `AndroidManifest.xml`. An activity must have a category of `DEFAULT` if it is to receive an implicit intent.
- The `createChooser()` method allows you to override the default Android activity chooser dialog. It lets you specify a title for the dialog, and doesn’t give the user the option of setting a default activity. If no activities can receive the intent it is passed, it displays a message. The `createChooser()` method returns an Intent.
- You retrieve the value of a String resource using `getString(R.string.stringname);`

## Chapter 4. The Activity Lifecycle: Being an activity

Key points:

- `Each app` runs `in its own process` by default.
- Only the `main thread` can update the user interface.
- Use a `Handler` to schedule code or post code to a different thread.
- A `device configuration change` results in the activity being destroyed and recreated.
- Your activity inherits the lifecycle methods from the `android.app.Activity` class. If you override any of these methods, you need to call up to the method in the superclass.
- `onSaveInstanceState(Bundle)` enables your activity to save its state before the activity gets destroyed. You can use the `Bundle` to restore state in `onCreate()`.
- You add values to a `Bundle` using `bundle.put*("name", value)`. You retrieve values from the bundle using `bundle.get*("name")`.
- `onCreate()` and `onDestroy()` deal with the birth and death of the activity.
- `onRestart()`, `onStart()`, and `onStop()` deal with the visibility of the activity.
- `onResume()` and `onPause()` handle when the activity gains and loses the focus.

<!--
## Chapter 5. Views and View Groups Enjoy the view

## Chapter 6. Constraint Layouts: Put things in their place

## Chapter 7. List views and Adapters: Getting organized

## Chapter 8. Support Libraries and App Bars: Taking shortcuts

## Chapter 9. Fragments: Make it modular

## Chapter 10. Fragments for Larger Interfaces: Different size, different interface

## Chapter 11. Dynamic Fragments: Nesting fragments

## Chapter 12. Design Support Library: Swipe right

## Chapter 13. Recycler Views and Card Views: Get recycling

## Chapter 14. Navigation Drawers: Going places

## Chapter 15. SQLite Databases: Fire up the database

## Chapter 16. Basic cursors: Getting data out

## Chapter 17. Cursors and AsyncTasks: Staying in the background

## Chapter 18. Started Services: At your service

## Chapter 19. Bound Services and Permissions: Bound together
>
