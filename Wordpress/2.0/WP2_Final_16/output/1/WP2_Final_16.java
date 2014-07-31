package org.wordpress.android.test;

/* WordPress 2.0 Final - WP2_Final_16 */

/*	Add package and import declarations. Try CTRL+SHIFT+O if you're using Eclipse.
//	Robotium must be in the build path!!! Otherwise, Solo cannot be resolved to a class.
//	Additionally, the targetPackage for Instrumentation in AndroidManifest.xml should
//	be set to the package of the application under test (that is PACKAGE_NAME below) */

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;

import com.jayway.android.robotium.solo.Solo;
import android.view.View;
import android.webkit.WebView;
import android.widget.*;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import android.test.ActivityInstrumentationTestCase2;

import static android.content.Context.WINDOW_SERVICE;
import static android.view.Surface.*;

@SuppressWarnings("rawtypes")
public class AndroidGuiTest extends ActivityInstrumentationTestCase2 {
	
	// Attributes
	private Activity theActivity;
	private Map<Integer,View> theViews;
	private ArrayList<View> allViews = new ArrayList<View>(); // A list of all widgets
	private Solo solo;
	private TabHost	tabs;
	private int tabNum;

	public final static String PACKAGE_NAME = "org.wordpress.android";
	public final static String CLASS_NAME = "org.wordpress.android.Dashboard";
	public final static int SLEEP_AFTER_EVENT = 100;
	public final static int SLEEP_AFTER_RESTART = 100;
	public final static int SLEEP_ON_THROBBER = 100;
	public final static int SLEEP_AFTER_TASK = 100;
	public final static boolean FORCE_RESTART = false;

	public final static boolean IN_AND_OUT_FOCUS= true;

	public final static String CLICK = "click";
	public final static String BACK = "back";
	public final static String SCROLL_DOWN = "scrollDown";
	public final static String SWAP_TAB = "swapTab";
	public final static String TYPE_TEXT = "editText";
	public final static String LIST_SELECT = "selectListItem";
	public final static String LONG_CLICK = "longClick";
	public final static String LIST_LONG_SELECT = "longClickListItem";
	public final static String OPEN_MENU = "openMenu";
	public final static String SET_BAR = "setBar";
	public final static String SPINNER_SELECT = "selectSpinnerItem";
	public final static String CHANGE_ORIENTATION = "changeOrientation";
	public final static String CLICK_ON_TEXT = "clickText";
	public final static String WRITE_TEXT = "writeText";
	public final static String PRESS_KEY = "pressKey";
	public final static String RADIO_SELECT = "selectRadioItem";
	public final static String ACCELEROMETER_SENSOR_EVENT = "accelerometerSensorEvent";
	public final static String ORIENTATION_SENSOR_EVENT = "orientationSensorEvent";
	public final static String MAGNETIC_FIELD_SENSOR_EVENT = "magneticFieldSensorEvent";
	public final static String TEMPERATURE_SENSOR_EVENT = "temperatureSensorEvent";
	public final static String AMBIENT_TEMPERATURE_SENSOR_EVENT = "ambientTemperatureSensorEvent";
	public final static String GPS_LOCATION_CHANGE_EVENT = "gpsLocationChangeEvent";
	public final static String GPS_PROVIDER_DISABLE_EVENT = "gpsProviderDisableEvent";
	public final static String INCOMING_SMS_EVENT = "incomingSMSEvent";
	public final static String INCOMING_CALL_EVENT = "incomingCallEvent";
	public final static String FOCUS = "focus";
	public final static String BUTTON = "button";
	public final static String EDIT_TEXT = "editText";
	public final static String SEARCH_BAR = "searchBar";
	public final static String RADIO = "radio";
	public final static String RADIO_GROUP = "radioGroup";
	public final static String CHECKBOX = "check";
	public final static String TOGGLE_BUTTON = "toggle";
	public final static String TAB_HOST = "tabHost";
	public final static String NULL = "null";
	public final static String LIST_VIEW = "listView";
	public final static String SPINNER = "spinner";
	public final static String TEXT_VIEW = "text";
	public final static String MENU_VIEW = "menu";
	public final static String IMAGE_VIEW = "image";
	public final static String DIALOG_VIEW = "dialog";
	public final static String SEEK_BAR = "seekBar";
	public final static String RATING_BAR = "ratingBar";
	public final static String LINEAR_LAYOUT = "linearLayout";
	public final static String WEB_VIEW = "webPage";
	public final static String DATE_PICKER = "datePicker";
	public final static String TIME_PICKER = "timePicker";
	public final static String LIST_ITEM = "listItem";
	public final static String SPINNER_INPUT = "spinnerInput";
	public final static String MENU_ITEM = "menuItem";
	public final static String EMPTY_LIST = "emptyList";
	public final static String SINGLE_CHOICE_LIST = "singleChoiceList";
	public final static String MULTI_CHOICE_LIST = "multiChoiceList";
	public final static String PREFERENCE_LIST = "preferenceList";
	public final static String EMPTY_SPINNER = "emptySpinner";
	public final static String RELATIVE_LAYOUT = "relativeLayout";
	public final static String FOCUSABLE_EDIT_TEXT = "focusableEditText";
	public final static String[] PRECRAWLING = {};
	
	private static Class<?> theClass;
	static {
		try {
			theClass = Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public AndroidGuiTest () {
		super(PACKAGE_NAME,theClass);
		this.theViews = new HashMap<Integer,View>();
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.solo = new Solo (getInstrumentation(), getActivity());
		restart();
		afterRestart();
		refreshCurrentActivity();
	}
	
	@Override
	protected void tearDown() throws Exception {
		try {
			solo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		theActivity.finish();
		super.tearDown();
	}

	// Test Cases

	// Generated from trace 1
	public void testTrace00000 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 174
	public void testTrace00001 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e11
		fireEvent (2131165258, 43, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a3
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e21
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a4
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e26
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a5
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e31
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a6
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e35
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a7
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e37
		fireEvent (2131165200, 18, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a8
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e45
		fireEvent (2131165251, 28, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a9
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i33
		setInput (2131165236, "writeText", "90");
		// Setting input: i34
		setInput (2131165268, "writeText", "85");
		// Setting input: i35
		setInput (2131165286, "writeText", "45");
		// Firing event: e69
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a10
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i42
		setInput (2131165236, "writeText", "90");
		// Setting input: i43
		setInput (2131165268, "writeText", "85");
		// Setting input: i44
		setInput (2131165286, "writeText", "45");
		// Firing event: e75
		fireEvent (2131165265, 10, "Content", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a11
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e103
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a12
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e110
		fireEvent (2131165295, 12, "\"", "toggle", "click");

		retrieveWidgets();
		// Testing current activity: should be a13
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e127
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a14
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e128
		fireEvent (2131165265, 3, "Content", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a15
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e148
		fireEvent (2131165297, 14, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a16
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e153
		fireEvent (8, "", "listView", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a17
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e167
		fireEvent (2131165293, 10, " ABC ", "toggle", "click");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 464
	public void testTrace00002 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e178
		fireEvent (2131165251, 21, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a18
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i108
		setInput (2131165236, "writeText", "90");
		// Setting input: i109
		setInput (2131165268, "writeText", "85");
		// Setting input: i110
		setInput (2131165286, "writeText", "45");
		// Firing event: e198
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a19
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i156
		setInput (2131165236, "writeText", "90");
		// Setting input: i157
		setInput (2131165268, "writeText", "85");
		// Setting input: i158
		setInput (2131165286, "writeText", "45");
		// Firing event: e217
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a20
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i183
		setInput (2131165236, "writeText", "90");
		// Setting input: i184
		setInput (2131165268, "writeText", "85");
		// Setting input: i185
		setInput (2131165286, "writeText", "45");
		// Firing event: e229
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a21
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i210
		setInput (2131165236, "writeText", "90");
		// Setting input: i211
		setInput (2131165268, "writeText", "85");
		// Setting input: i212
		setInput (2131165286, "writeText", "45");
		// Firing event: e241
		fireEvent (2131165265, 10, "Content", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a22
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e267
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a23
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i276
		setInput (2131165236, "writeText", "90");
		// Setting input: i277
		setInput (2131165268, "writeText", "85");
		// Setting input: i278
		setInput (2131165286, "writeText", "45");
		// Firing event: e278
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a24
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i315
		setInput (2131165236, "writeText", "90");
		// Setting input: i316
		setInput (2131165268, "writeText", "85");
		// Setting input: i317
		setInput (2131165286, "writeText", "45");
		// Firing event: e294
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a25
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i360
		setInput (2131165236, "writeText", "90");
		// Setting input: i361
		setInput (2131165268, "writeText", "85");
		// Setting input: i362
		setInput (2131165286, "writeText", "45");
		// Firing event: e312
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a26
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e337
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a27
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e352
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a28
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e355
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a29
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e361
		fireEvent (2131165201, 13, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a30
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e390
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a31
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e398
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a32
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e399
		fireEvent (1, "Add Account", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a33
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e408
		fireEvent (15, "Play notification sound", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a34
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e417
		fireEvent (1, 9, "Katie's Sweet Testing Blog", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a35
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e436
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a36
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e454
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a37
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e461
		fireEvent (2131165254, 31, "", "linearLayout", "click");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 466
	public void testTrace00003 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e471
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 668
	public void testTrace00004 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e473
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a39
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e477
		fireEvent (3, "Remove Blog", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a40
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e486
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a41
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e488
		fireEvent (16908314, 17, "No", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a42
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e503
		fireEvent (2131165263, 53, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a43
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e510
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a44
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e512
		fireEvent (1, "Home", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a45
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e527
		fireEvent (2131165258, 43, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a46
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e537
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a47
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e540
		fireEvent (2131165201, 20, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a48
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e546
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a49
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e556
		fireEvent (2131165255, 36, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a50
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e568
		fireEvent (16908298, 6, "", "listView", "selectListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a51
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e583
		fireEvent (2131165200, 47, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a52
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e604
		fireEvent (2131165263, 89, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a53
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e609
		fireEvent (2131165329, 7, "", "webPage", "longClick");

		retrieveWidgets();
		// Testing current activity: should be a54
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e616
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a55
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e618
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a56
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e627
		fireEvent (2131165201, 29, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a57
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e634
		fireEvent (2131165387, 15, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a58
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i501
		setInput (2131165236, "writeText", "90");
		// Setting input: i502
		setInput (2131165268, "writeText", "85");
		// Setting input: i503
		setInput (2131165286, "writeText", "45");
		// Firing event: e654
		fireEvent (2131165287, 33, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a59
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e665
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a60
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e668
		fireEvent (16908298, 6, "", "listView", "selectListItem", "1");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1094
	public void testTrace00005 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e682
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a61
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e683
		fireEvent (2131165200, 11, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a62
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e702
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a63
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e704
		fireEvent (1, "Add Account", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a64
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e718
		fireEvent (24, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a65
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e731
		fireEvent (2131165258, 43, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a66
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e740
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a67
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e751
		fireEvent (2131165257, 39, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a68
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e780
		fireEvent (2131165201, 41, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a69
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e790
		fireEvent (16908298, 6, "", "listView", "selectListItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a70
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e810
		fireEvent (2131165385, 38, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a71
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e821
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a72
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e824
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a73
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e834
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a74
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e854
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a75
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e862
		fireEvent (8, "", "listView", "selectListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a76
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i508
		setInput (2131165236, "writeText", "90");
		// Setting input: i509
		setInput (2131165286, "writeText", "45");
		// Firing event: e873
		fireEvent (2131165287, 20, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a77
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e889
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a78
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e907
		fireEvent (8, "", "listView", "longClickListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a79
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e911
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a80
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e916
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a81
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e921
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a82
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e922
		fireEvent (16908313, 15, "OK", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a83
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e940
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a84
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e952
		fireEvent (8, "", "listView", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a85
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e964
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a86
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e969
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a87
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e972
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a88
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e981
		fireEvent (16908298, 6, "", "listView", "selectListItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a89
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1003
		fireEvent (2131165387, 50, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a90
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i510
		setInput (2131165236, "writeText", "90");
		// Setting input: i511
		setInput (2131165286, "writeText", "45");
		// Firing event: e1010
		fireEvent (2131165265, 9, "Content", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a91
		solo.assertCurrentActivity("", "EditContent");

		// Testing transition 
		// Firing event: e1025
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a92
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1032
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a93
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1037
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a94
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1044
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a95
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1047
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a96
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i530
		setInput (2131165236, "writeText", "90");
		// Setting input: i531
		setInput (2131165286, "writeText", "45");
		// Firing event: e1051
		fireEvent (2131165283, 16, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a97
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1059
		fireEvent (16908794, 18, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a98
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1071
		fireEvent (16908795, 15, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a99
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1087
		fireEvent (16908794, 19, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a100
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1107
		fireEvent (16908313, 28, "Set", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a101
		solo.assertCurrentActivity("", "EditPost");

		solo.sleep (SLEEP_AFTER_TASK);
	}

	//Helper methods for doing the actual work with instrumentation

	public void afterRestart() {
		solo.setActivityOrientation(Solo.PORTRAIT);
		solo.sleep(SLEEP_AFTER_RESTART);
		waitOnThrobber();
		if (PRECRAWLING.length>0) {
			refreshCurrentActivity();
			retrieveWidgets();
			processPrecrawling();
		}
		
		Log.d("nofatclips", "Ready to operate after restarting...");
	}
	
	private void processPrecrawling() {
		Log.i("nofatclips", "Processing precrawling");
		String[] params = new String[3];
		int paramCount=0;
		for (String s: PRECRAWLING) {
			if (s == null) {
				switch (paramCount) {
					case 0: continue;
					case 1: {
						Log.i ("nofatclips", "Firing event " + params[0]);
						fireEventOnView(null, params[0], null);
						break;
					}
					case 2: {
						Log.i ("nofatclips", "Firing event " + params[0] + " with value: " + params[1]);
						fireEventOnView(null, params[0], params[1]);
						break;
					}
					case 3: {
						View v = getWidget(Integer.parseInt(params[1]));
						Log.i ("nofatclips", "Firing event " + params[0] + " on widget #" + params[1] + " with value: " + params[2]);
						fireEventOnView(v, params[0], params[2]);
						break;
					}
				};
				paramCount = 0;
			} else {
				params[paramCount] = s;
				paramCount++;
			}
		}
	}
	
	
	/*
	public void waitOnThrobber() {
		boolean flag;
		do {
			flag = false;
			ArrayList<ProgressBar> bars = solo.getCurrentProgressBars();
			for (ProgressBar b: bars) {
				if (b.isShown() && b.isIndeterminate()) {
					Log.d("nofatclips", "Waiting on Progress Bar #" + b.getId());
					flag = true;
					solo.sleep(500);
				}
			}
		} while (flag);
	}
	*/
	public void waitOnThrobber() {
		int sleepTime = SLEEP_ON_THROBBER;
		if (sleepTime==0) return;
		
		boolean flag;
		do {
			flag = false;
			ArrayList<ProgressBar> bars = solo.getCurrentProgressBars();
			for (ProgressBar b: bars) {
				if (b.isShown() && b.isIndeterminate()) {
					Log.d("nofatclips", "Waiting on Progress Bar #" + b.getId());
					flag = true;
					solo.sleep(500);
					sleepTime-=500;
				}
			}
		} while (flag && (sleepTime>0));
		sync();
	}
	
	public void retrieveWidgets () {
		home();
		clearWidgetList();
		ArrayList<View> viewList = (isInAndOutFocusEnabled())?solo.getViews():solo.getCurrentViews();
		for (View w: viewList) {
			String text = (w instanceof TextView)?": "+((TextView)w).getText().toString():"";
			Log.d("nofatclips", "Found widget: id=" + w.getId() + " ("+ w.toString() + ")" + text); // + " in window at [" + xy[0] + "," + xy[1] + "] on screen at [" + xy2[0] + "," + xy2[1] +"]");
			
			//
			allViews.add(w);
			//
			
			if (w.getId()>0) {
				theViews.put(w.getId(), w); // Add only if the widget has a valid ID
			}
			if (w instanceof TabHost) {
				setTabs((TabHost)w);
			}
		}
	}
	
	public void setTabs (TabHost t) {
		this.tabs = t;
		this.tabNum = t.getTabWidget().getTabCount();
	}
	
	public Map<Integer,View> getWidgets () {
		return this.theViews;
	}
	
	public View getWidget (int key) {
		return getWidgets().get(key);
	}
	
	public View getWidget (int theId, String theType, String theName) {
		for (View testee: getWidgetsById(theId)) {
			if (checkWidgetEquivalence(testee, theId, theType, theName)) {
				return testee;
			}
		}
		return null;
	}
	
	public View getWidget (String theType, String theName) {
		for (View testee: getWidgetsByType(theType)) {
			if (checkWidgetEquivalence(testee, theType, theName)) {
				return testee;
			}
		}
		return null;
	}
	
	public boolean checkWidgetEquivalence (View testee, int theId, String theType, String theName) {
		return ((theId == testee.getId()) && checkWidgetEquivalence (testee, theType, theName));
	}
	
	public boolean checkWidgetEquivalence (View testee, String theType, String theName) {
		Log.i("nofatclips", "Retrieved from return list id=" + testee.getId());
		String testeeSimpleType = getSimpleType(testee);
		String testeeType = testee.getClass().getName();
		Log.i("nofatclips", "Testing for type (" + testeeType + ") against the original (" + theType + ")");
		String testeeText = (testee instanceof TextView)?(((TextView)testee).getText().toString()):"";
		
		String testeeName = testeeText;
		if (testee instanceof EditText) {
			CharSequence hint = ((EditText)testee).getHint();
			testeeName = (hint==null)?"":hint.toString();
		}
		
		//		String testeeName = (testee instanceof EditText)?(((EditText)testee).getHint().toString()):testeeText;
		Log.i("nofatclips", "Testing for name (" + testeeName + ") against the original (" + theName + ")");
		if ( ((theType.equals(testeeType)) || (theType.equals(testeeSimpleType)) ) && (theName.equals(testeeName)) ) {
			return true;
		}
		return false;
	}
	
	
	public ArrayList<View> getWidgetsById (int id) {
		ArrayList<View> theList = new ArrayList<View>();
		for (View theView: getAllWidgets()) {
			if (theView.getId() == id) {
				Log.i("nofatclips", "Added to return list id=" + id);
				theList.add(theView);
			}
		}
		return theList;
	}
	
	public ArrayList<View> getWidgetsByType (String type) {
		ArrayList<View> theList = new ArrayList<View>();
		for (View theView: getAllWidgets()) {
			if (theView.getClass().getName().equals(type)) {
				Log.i("nofatclips", "Added to return list " + type + " with id=" + theView.getId());
				theList.add(theView);
			}
		}
		return theList;
	}
	
	public ArrayList<View> getAllWidgets () {
		return this.allViews;
	}
	
	public void clearWidgetList() {
		theViews.clear();
		allViews.clear();
	}
	
	public void doTestWidget (int theId, String theType, String theName) {
		if (theId == -1) return;
		assertNotNull("Testing for id #" + theId + " (" + theType + "): " + theName, getWidget(theId, theType, theName));
	}
	
	public void doTestWidget (String theType, String theName) {
		assertNotNull("Testing for type " + theType + "): " + theName, getWidget(theType, theName));
	}
	
	public void fireEvent (int widgetId, int widgetIndex, String widgetType, String eventType) {
		//fireEvent(widgetId, widgetIndex, widgetType, eventType, null);
		fireEvent(widgetId, widgetIndex, "", widgetType, eventType);
	}
	
	public void fireEvent (int widgetId, int widgetIndex, String widgetName, String widgetType, String eventType) {
		fireEvent(widgetId, widgetIndex, widgetName, widgetType, eventType, null);
	}
	
	public void fireEvent (int widgetIndex, String widgetName, String widgetType, String eventType) {
		fireEvent(widgetIndex, widgetName, widgetType, eventType, null);
	}
	
	public void fireEvent (int widgetId, int widgetIndex, String widgetName, String widgetType, String eventType, String value) {
		
		View v = null;
		if (widgetIndex<getAllWidgets().size()) {
			v = getAllWidgets().get(widgetIndex); // Search widget by index
		}
		if ((v!=null) && !checkWidgetEquivalence(v, widgetId, widgetType, widgetName)) {
			v = getWidget(widgetId, widgetType, widgetName);
		}
		if (v == null) {
			v = getWidget(widgetId);
		}
		if (v == null) {
			v = theActivity.findViewById(widgetId);
		}
		fireEventOnView (v, eventType, value);
	}
	
	public void fireEvent (int widgetIndex, String widgetName, String widgetType, String eventType, String value) {
		View v = null;
		if (eventType.equals(BACK) || eventType.equals(SCROLL_DOWN)) {
			fireEventOnView(null, eventType, null);
			return;
		} else if (eventType.equals(CLICK_ON_TEXT)) {
			Log.d("nofatclips", "Firing event: type= " + eventType + " value= " + value);
			fireEventOnView(null, eventType, value);
		}
		if (widgetType.equals(BUTTON)) {
			v = solo.getButton(widgetName);
		} else if (widgetType.equals(MENU_ITEM)) {
			v = solo.getText(widgetName);
		} else if (widgetType.equals(LIST_VIEW)) {
			v = solo.getCurrentListViews().get(0);
		}
		if (v == null) {
			for (View w: getAllWidgets()) {
				if (w instanceof Button) {
					Button candidate = (Button) w;
					if (candidate.getText().equals(widgetName)) {
						v = candidate;
					}
				}
				if (v!=null) break;
			}
		}
		fireEventOnView (v, eventType, value);
	}
	
	private void fireEventOnView (View v, String eventType, String value) {
		injectInteraction(v, eventType, value);
		solo.sleep(SLEEP_AFTER_EVENT);
		waitOnThrobber();
		refreshCurrentActivity();
	}
	
	public void setInput (int widgetId, String inputType, String value) {
		View v = getWidget(widgetId);
		if (v == null) {
			v = theActivity.findViewById(widgetId);
		}
		injectInteraction(v, inputType, value);
	}
	
	private void injectInteraction (View v, String interactionType, String value) {
		if (v!=null) {
			requestView(v);
		}
		if (interactionType.equals(CLICK)) {
			click (v);
		} else if (interactionType.equals(LONG_CLICK)) {
			longClick(v);
		} else if (interactionType.equals(BACK)) {
			solo.goBack();
		} else if (interactionType.equals(CHANGE_ORIENTATION)) {
			changeOrientation();
		} else if (interactionType.equals(CLICK_ON_TEXT)) {
			clickOnText(value);
		} else if (interactionType.equals(PRESS_KEY)) {
			pressKey(value);
		} else if (interactionType.equals(OPEN_MENU)) {
			solo.sendKey(Solo.MENU);
		} else if (interactionType.equals(SCROLL_DOWN)) {
			solo.scrollDown();
		} else if (interactionType.equals(SWAP_TAB) && (value!=null)) {
			if (v instanceof TabHost) {
				swapTab ((TabHost)v, value);
			} else {
				swapTab (this.tabs, value);
			}
		} else if (interactionType.equals(LIST_SELECT)) {
			selectListItem((ListView)v, value);
		} else if (interactionType.equals(LIST_LONG_SELECT)) {
			selectListItem((ListView)v, value, true);
		} else if (interactionType.equals(SPINNER_SELECT)) {
			selectSpinnerItem((Spinner)v, value);
		} else if (interactionType.equals(TYPE_TEXT)) {
			typeText((EditText)v, value);
		} else if (interactionType.equals(WRITE_TEXT)) {
			writeText((EditText)v, value);
		} else if (interactionType.equals(SET_BAR)) {
			solo.setProgressBar((ProgressBar)v, Integer.parseInt(value));
		} else {
			return;
		}
	}
	
	protected void typeText (EditText v, String value) {
		solo.enterText(v, value);
	}
	
	protected void writeText (EditText v, String value) {
		typeText (v, "");
		typeText (v, value);
	}
	
	public void changeOrientation() {
		Display display = ((WindowManager) getInstrumentation().getContext().getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
		int angle = display.getRotation();
		int newAngle = ((angle==ROTATION_0)||(angle==ROTATION_180))?Solo.LANDSCAPE:Solo.PORTRAIT;
		solo.setActivityOrientation(newAngle);
	}
	
	private void swapTab (TabHost t, String tab) {
		swapTab (t, Integer.valueOf(tab));
	}
	
	private void swapTab (final TabHost t, int num) {
		final int n = Math.min(this.tabNum, Math.max(1,num))-1;
		Log.i("nofatclips", "Swapping to tab " + num);
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				t.setCurrentTab(n);
			}
		});
		sync();
	}
	
	private void clickOnText (String text) {
		solo.clickOnText (text);
	}
	
	private void selectListItem (ListView l, String item) {
		selectListItem (l, Integer.valueOf(item), false);
	}
	
	private void selectListItem (ListView l, String item, boolean longClick) {
		selectListItem (l, Integer.valueOf(item), longClick);
	}
	
	private void selectListItem (final ListView l, int num, boolean longClick) {
		final int n = Math.min(l.getCount(), Math.max(1,num))-1;
		requestFocus(l);
		Log.i("nofatclips", "Swapping to listview item " + num);
		solo.sendKey(Solo.DOWN);
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				l.setSelection(n);
			}
		});
		sync();
		if (n<l.getCount()/2) {
			solo.sendKey(Solo.DOWN);
			solo.sendKey(Solo.UP);
		} else {
			solo.sendKey(Solo.UP);
			solo.sendKey(Solo.DOWN);
		}
		sync();
		if (longClick) {
			longClick (l.getSelectedView());
		} else {
			click (l.getSelectedView());
		}
	}
	
	public static boolean isInAndOutFocusEnabled () {
		return IN_AND_OUT_FOCUS;
	}
	
	protected void requestFocus (final View v) {
		getActivity().runOnUiThread(new Runnable() {
			public void run() {
				v.requestFocus();
			}
		});
		sync();
	}
	
	public void pressKey (String keyCode) {
		pressKey (Integer.parseInt(keyCode));
	}
	
	public void pressKey (int keyCode) {
		solo.sendKey(keyCode);
	}
	
	// Scroll until the view is on the screen if IN_AND_OUT_OF_FOCUS is enabled or if the force parameter is true
	protected void requestView (final View v, boolean force) {
		if (force || isInAndOutFocusEnabled()) {
			home();
			solo.sendKey(Solo.UP); // Solo.waitForView() requires a widget to be focused
			solo.waitForView(v, 1000, true);
		}
		requestFocus(v);
	}
	
	protected void requestView (final View v) {
		requestView(v, false);
	}
	
	
	private void selectSpinnerItem (Spinner l, String item) {
		selectSpinnerItem (l, Integer.valueOf(item));
	}
	
	private void selectSpinnerItem (final Spinner s, int num) {
		assertNotNull(s, "Cannon press spinner item: the spinner does not exist");
		Log.i("nofatclips", "Clicking the spinner view");
		click(s);
		sync();
		selectListItem(solo.getCurrentListViews().get(0), num, false);
	}
	
	protected void click (View v) {
		// TouchUtils.clickView(this, v);
		solo.clickOnView(v);
	}
	
	protected void longClick (View v) {
		solo.clickLongOnView(v);
	}
	
	public void home () {
		
		// Scroll listviews up
		final ArrayList<ListView> viewList = solo.getCurrentListViews();
		if (viewList.size() > 0) {
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					viewList.get(0).setSelection(0);
				}
			});
		}
		
		// Scroll scrollviews up
		final ArrayList<ScrollView> viewScroll = solo.getCurrentScrollViews();
		if (viewScroll.size() > 0) {
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					viewScroll.get(0).fullScroll(ScrollView.FOCUS_UP);
				}
			});
		}
		sync();
	}
	
	
	public void restart() {
		if (FORCE_RESTART) {
			ContextWrapper main = new ContextWrapper(solo.getCurrentActivity());
			Intent i = main.getBaseContext().getPackageManager().getLaunchIntentForPackage(main.getBaseContext().getPackageName() );
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
			main.startActivity(i);
		}
	}
	
	private void refreshCurrentActivity() {
		this.theActivity = solo.getCurrentActivity();
		Log.i("nofatclips", "Current activity is " + getActivity().getLocalClassName());
	}
	
	public String getSimpleType(View v) {
		String type = v.getClass().getName();
		if (type.endsWith("null"))
		return NULL;
		if (type.endsWith("RadioButton"))
		return RADIO;
		if (type.endsWith("CheckBox") || type.endsWith("CheckedTextView"))
		return CHECKBOX;
		if (type.endsWith("ToggleButton"))
		return TOGGLE_BUTTON;
		if (type.endsWith("IconMenuView"))
		return MENU_VIEW;
		if (type.endsWith("DatePicker"))
		return DATE_PICKER;
		if (type.endsWith("TimePicker"))
		return TIME_PICKER;
		if (type.endsWith("IconMenuItemView"))
		return MENU_ITEM;
		if (type.endsWith("DialogTitle"))
		return DIALOG_VIEW;
		if (type.endsWith("Button"))
		return BUTTON;
		if (type.endsWith("EditText"))
		return EDIT_TEXT;
		if (type.endsWith("Spinner")) {
			Spinner s = (Spinner)v;
			if (s.getCount() == 0) return EMPTY_SPINNER;
			return SPINNER;
		}
		if (type.endsWith("SeekBar"))
		return SEEK_BAR;
		if (v instanceof RatingBar && (!((RatingBar)v).isIndicator()))
		return RATING_BAR;
		if (type.endsWith("TabHost"))
		return TAB_HOST;
		if (type.endsWith("ListView") || type.endsWith("ExpandedMenuView")) {
			ListView l = (ListView)v;
			if (l.getCount() == 0) return EMPTY_LIST;
			
			if (l.getAdapter().getClass().getName().endsWith("PreferenceGroupAdapter")) {
				return PREFERENCE_LIST;
			}
			
			switch (l.getChoiceMode()) {
				case ListView.CHOICE_MODE_NONE: return LIST_VIEW;
				case ListView.CHOICE_MODE_SINGLE: return SINGLE_CHOICE_LIST;
				case ListView.CHOICE_MODE_MULTIPLE: return MULTI_CHOICE_LIST;
			}
		}
		if (type.endsWith("TextView"))
		return TEXT_VIEW;
		if (type.endsWith("ImageView"))
		return IMAGE_VIEW;
		if (type.endsWith("LinearLayout"))
		return LINEAR_LAYOUT;
		if ((v instanceof WebView) || type.endsWith("WebView"))
		return WEB_VIEW;
		if (type.endsWith("TwoLineListItem"))
		return LIST_ITEM;
		return "";
	}
	
	protected void assertNotNull (final View v) {
		ActivityInstrumentationTestCase2.assertNotNull(v);
	}
	
	protected void assertNotNull (final View v, String errorMessage) {
		ActivityInstrumentationTestCase2.assertNotNull(errorMessage, v);
	}
	
	public void sync() {
		getInstrumentation().waitForIdleSync();
	}
	
	public void debug (String msg) {
		Log.d("nofatclips",msg);
		for (View x: getWidgets().values()) {
			if (x instanceof TextView) {
				Log.i("nofatclips", ((TextView)x).getText().toString() + "[" + x.toString() + "]: " + x.getId());
			} else {
				Log.i("nofatclips", "[" + x.toString() + "]: " + x.getId());
			}
		}
	}

}

