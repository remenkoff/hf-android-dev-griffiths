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

## Chapter 5. Views and View Groups: Enjoy the view

- GUI components are all types of view. They are all subclasses of the `android.view.View` class.
- All layouts are subclasses of the `android.view.ViewGroup` class. A view group is a type of view that can contain multiple views.
- The layout XML file gets converted to a `ViewGroup` containing a hierarchical tree of views.
- A linear layout lists views either horizontally or vertically. You specify the direction using the `android:orientation` attribute.
- A frame layout stacks views.
- Use `android:padding*` attributes to specify how much padding you want around a view.
- In a linear layout, use `android:layout_weight` if you want a view to use up extra space in the layout.
- `android:layout_gravity` lets you say where you want views to appear in their available space.
- `android:gravity` lets you say where you want the contents to appear inside a view.
- `<ToggleButton>` defines a toggle button that allows you to choose between two states by clicking a button.
- `<Switch>` defines a switch control that behaves in the same way as a toggle button. It requires API level 14 or above.
- `<CheckBox>` defines a checkbox.
- To define a group of radio buttons, first use `<RadioGroup>` to define the radio group. Then put individual radio buttons in the radio group using `<RadioButton>`.
- Use `<ImageView>` to display an image.
- `<ImageButton>` defines a button with no text, just an image.
- Add scrollbars using `<ScrollView>` or `<HorizontalScrollView>`.
- A `Toast` is a pop-up message.

## Chapter 6. Constraint Layouts: Put things in their place

- `Constraint layouts` are designed to work with Android Studio’s design editor. They have their own library and can be used in apps where the minimum SDK is API level 9 or above.
- Position views by adding `constraints`. Each view needs at least one horizontal and one vertical constraint.
- Center views by adding constraints to opposite sides of the view. Change the view’s bias to update its position between the constraints.
- You can change a view’s size to match its constraints if the view has constraints on opposing sides.
- You can specify a `width:height` aspect ratio for the view’s size.
- Clicking on the `Infer Constraints` button adds constraints to views based on their position in the `blueprint`.

## Chapter 7. List views and Adapters: Getting organized

- Sort your ideas for activities into top-level activities, category activities, and create / detail / edit / delete (`CRUD`) activities. Use the category activities to navigate from the top-level activities to the create `CRUD` activities.
- A list view displays items in a list. Add it to your layout using the `<ListView>` element.
- Use `android:entries` in your layout to populate the items in your list views from an array defined in `strings.xml`.
- An adapter acts as a bridge between an `AdapterView` and a data source. `ListViews` and `Spinners` are both types of `AdapterView`.
- An `ArrayAdapter` is an adapter that works with arrays.
- Handle click events on `Buttons` using `android:onClick` in the layout code. Handle click events elsewhere by creating a `listener` and implementing its click event.

## Chapter 8. Support Libraries and App Bars: Taking shortcuts

- You add a basic app bar by applying a `theme` that contains one.
- The `A`ndroid Support Libraries` provide backward compatibility with older versions of Android.
- The `AppCompatActivity` class is a type of activity that resides in the `v7 AppCompat Support Library`. In general, your activity needs to extend the `AppCompatActivity` class whenever you want an app bar that provides backward compatibility with older versions of Android.
- The `android:theme` attribute in `AndroidManifest.xml` specifies which theme to apply.
- You define styles in a style resource file using the `<style>` element. The `name` attribute gives the style a name. The parent attribute specifies where the style should inherit its properties from.
- The latest app bar features are in the `Toolbar` class in the `v7 AppCompat Support Library`. You can use a toolbar as your app bar.
- Add `actions` to your app bar by adding them to a `menu resource file`.
- Add the items in the menu resource file to the app bar by implementing the activity’s `onCreateOptionsMenu()` method.
- You determine what items should do when clicked by implementing the activity’s `onOptionsItemSelected()` method.
- Add an `Up button` to your app bar to navigate up the app’s hierarchy. Specify the hierarchy in `AndroidManifest.xml`. Use the ActionBar `setDisplayHomeAsUpEnabled()` method to enable the `Up button`.
- You can share content by adding the `share action provider` to your app bar. Add it by including it in your menu resource file. Call its `setShareIntent()` method to pass it an intent describing the content you wish to share.

## Chapter 9. Fragments: Make it modular

- A fragment is used to control part of a screen. It `can be reused` across multiple activities.
- A fragment has an `associated layout`.
- The `onCreateView()` method gets called each time Android needs the fragment’s layout.
- Add a fragment to an activity’s layout using the `<fragment>` element and adding a `name` attribute.
- The fragment lifecycle methods tie in with the states of the activity that contains the fragment.
- The `Fragment` class doesn’t extend the `Activity` class or implement the `Context` class.
- Fragments don’t have a `findViewById()` method. Instead, use the `getView()` method to get a reference to the root view, then call the view’s `findViewById()` method.
- A `list fragment` is a fragment that comes complete with a `ListView`. You create one by subclassing `ListFragment`.

## Chapter 10. Fragments for Larger Interfaces: Different size, different interface

- Make apps look different on different devices by putting separate layouts in `device-appropriate folders`.
- Android keeps track of places you’ve visited within an app by adding them to the `back stack` as separate `transactions`. Pressing the Back button pops the last transaction off the back stack.
- Use a `frame layout` to add, replace, or remove fragments programmatically using `fragment transactions`.
- Begin the transaction by calling the `FragmentManager` `beginTransaction()` method. This creates a `FragmentTransaction` object.
- Add, replace, and delete fragments using the `FragmentTransaction` `add()`, `replace()`, and `remove()` methods.
- Add a transaction to the back stack using the `FragmentTransaction` `addToBackStack()` method.
- Commit a transaction using the `FragmentTransaction` `commit()` method. This applies all the updates in the transaction.
- Save the state of a fragment’s variables in the `Fragment` `onSaveInstanceState()` method.
- Restore the state of a fragment’s variables in the `Fragment` `onCreate()` method.

## Chapter 11. Dynamic Fragments: Nesting fragments

- Fragments can contain other fragments.
- If you use the `android:onClick` attribute in a fragment, Android will look for a method of that name in the fragment’s parent activity.
- Instead of using the `android:onClick` attribute in a fragment, make the fragment implement the `View.OnClickListener` interface and implement its `onClick()` method.
- If you use the `<fragment>` element in your layout, the fragment gets recreated when you rotate the device. If your fragment is dynamic, use a `fragment transaction` instead.
- Fragments contain two methods for getting a fragment manager, `getFragmentManager()` and `getChildFragmentManager()`.
- `getFragmentManager()` gets a reference to the fragment manager associated with the fragment’s parent activity. Any fragment transactions you create using this fragment manager are added to the `back stack` as extra transactions.
- `getChildFragmentManager()` gets a reference to the fragment manager associated with the fragment’s parent fragment. Any fragment transactions you create using this fragment manager are `nested inside the parent fragment transaction`.

## Chapter 12. Design Support Library: Swipe right

- Enable swipe navigation using a `view pager`.
- You tell a view pager about its pages by implementing a `fragment pager adapter`.
- Use the fragment pager adapter’s `getCount()` method to tell the view pager how many pages it should have. Use its `getItem()` method to tell it which fragment should appear on each page.
- Add tab navigation by implementing a `tab layout`. Put the toolbar and tab layout inside an `app bar layout` in your layout code, then attach the tab layout to the view pager in your activity code.
- The tab layout comes from the `Android Design Support Library`. This library helps you implement the `material design guidelines` in your app.
- Use a `coordinator layout` to coordinate animations between views.
- Add scrollable content the coordinator layout can coordinate using a `nested scroll view`.
- Use a `collapsing toolbar layout` to add a toolbar that collapses and grows in response to user scroll actions.
- Use a `FAB` (floating action button) to promote common or important user actions.
- A `snackbar` lets you display short messages that the user can interact with.

<!--

## Chapter 13. Recycler Views and Card Views: Get recycling

## Chapter 14. Navigation Drawers: Going places

## Chapter 15. SQLite Databases: Fire up the database

## Chapter 16. Basic cursors: Getting data out

## Chapter 17. Cursors and AsyncTasks: Staying in the background

## Chapter 18. Started Services: At your service

## Chapter 19. Bound Services and Permissions: Bound together
>
