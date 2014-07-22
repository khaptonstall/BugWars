package org.wordpress.android.test;

/* Wordpress 2.1 Original Version Random - Test 0 folder */

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

	// Generated from trace 1738
	public void testTrace00000 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e0
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a2
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e3
		fireEvent (2, "Preferences", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a3
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e9
		fireEvent (1, 9, "Katie's Sweet Testing Blog", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a4
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e26
		fireEvent (23, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a5
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e38
		fireEvent (2131165256, 36, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a6
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e47
		fireEvent (16908298, 9, "", "listView", "selectListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a7
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e67
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a8
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e77
		fireEvent (8, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a9
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e83
		fireEvent (16908314, 17, "No", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a10
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e93
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a11
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e108
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a12
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e109
		fireEvent (8, "", "listView", "selectListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a13
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e138
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a14
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i132
		setInput (2131165236, "writeText", "90");
		// Setting input: i133
		setInput (2131165270, "writeText", "8");
		// Setting input: i134
		setInput (2131165273, "writeText", "11");
		// Setting input: i135
		setInput (2131165292, "writeText", "72");
		// Firing event: e154
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a15
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i148
		setInput (2131165236, "writeText", "90");
		// Setting input: i149
		setInput (2131165270, "writeText", "8");
		// Setting input: i150
		setInput (2131165273, "writeText", "11");
		// Setting input: i151
		setInput (2131165292, "writeText", "72");
		// Firing event: e161
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a16
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e201
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a17
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i308
		setInput (2131165236, "writeText", "90");
		// Setting input: i309
		setInput (2131165270, "writeText", "8");
		// Setting input: i310
		setInput (2131165273, "writeText", "11");
		// Setting input: i311
		setInput (2131165292, "writeText", "72");
		// Firing event: e207
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a18
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i408
		setInput (2131165236, "writeText", "90");
		// Setting input: i409
		setInput (2131165270, "writeText", "8");
		// Setting input: i410
		setInput (2131165273, "writeText", "11");
		// Setting input: i411
		setInput (2131165292, "writeText", "72");
		// Firing event: e235
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a19
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i448
		setInput (2131165236, "writeText", "90");
		// Setting input: i449
		setInput (2131165270, "writeText", "8");
		// Setting input: i450
		setInput (2131165273, "writeText", "11");
		// Setting input: i451
		setInput (2131165292, "writeText", "72");
		// Firing event: e248
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a20
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i524
		setInput (2131165236, "writeText", "90");
		// Setting input: i525
		setInput (2131165270, "writeText", "8");
		// Setting input: i526
		setInput (2131165273, "writeText", "11");
		// Setting input: i527
		setInput (2131165292, "writeText", "72");
		// Firing event: e270
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a21
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i620
		setInput (2131165236, "writeText", "90");
		// Setting input: i621
		setInput (2131165270, "writeText", "8");
		// Setting input: i622
		setInput (2131165273, "writeText", "11");
		// Setting input: i623
		setInput (2131165292, "writeText", "72");
		// Firing event: e297
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a22
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i692
		setInput (2131165236, "writeText", "90");
		// Setting input: i693
		setInput (2131165270, "writeText", "8");
		// Setting input: i694
		setInput (2131165273, "writeText", "11");
		// Setting input: i695
		setInput (2131165292, "writeText", "72");
		// Firing event: e318
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a23
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i732
		setInput (2131165236, "writeText", "90");
		// Setting input: i733
		setInput (2131165270, "writeText", "8");
		// Setting input: i734
		setInput (2131165273, "writeText", "11");
		// Setting input: i735
		setInput (2131165292, "writeText", "72");
		// Firing event: e331
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a24
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e369
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a25
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i904
		setInput (2131165236, "writeText", "90");
		// Setting input: i905
		setInput (2131165270, "writeText", "8");
		// Setting input: i906
		setInput (2131165273, "writeText", "11");
		// Setting input: i907
		setInput (2131165292, "writeText", "72");
		// Firing event: e380
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a26
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i940
		setInput (2131165236, "writeText", "90");
		// Setting input: i941
		setInput (2131165270, "writeText", "8");
		// Setting input: i942
		setInput (2131165273, "writeText", "11");
		// Setting input: i943
		setInput (2131165292, "writeText", "72");
		// Firing event: e392
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a27
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1012
		setInput (2131165236, "writeText", "90");
		// Setting input: i1013
		setInput (2131165270, "writeText", "8");
		// Setting input: i1014
		setInput (2131165273, "writeText", "11");
		// Setting input: i1015
		setInput (2131165292, "writeText", "72");
		// Firing event: e413
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a28
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1096
		setInput (2131165236, "writeText", "90");
		// Setting input: i1097
		setInput (2131165270, "writeText", "8");
		// Setting input: i1098
		setInput (2131165273, "writeText", "11");
		// Setting input: i1099
		setInput (2131165292, "writeText", "72");
		// Firing event: e437
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a29
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1196
		setInput (2131165236, "writeText", "90");
		// Setting input: i1197
		setInput (2131165270, "writeText", "8");
		// Setting input: i1198
		setInput (2131165273, "writeText", "11");
		// Setting input: i1199
		setInput (2131165292, "writeText", "72");
		// Firing event: e465
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a30
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1252
		setInput (2131165236, "writeText", "90");
		// Setting input: i1253
		setInput (2131165270, "writeText", "8");
		// Setting input: i1254
		setInput (2131165273, "writeText", "11");
		// Setting input: i1255
		setInput (2131165292, "writeText", "72");
		// Firing event: e482
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a31
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e515
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a32
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1380
		setInput (2131165236, "writeText", "90");
		// Setting input: i1381
		setInput (2131165270, "writeText", "8");
		// Setting input: i1382
		setInput (2131165273, "writeText", "11");
		// Setting input: i1383
		setInput (2131165292, "writeText", "72");
		// Firing event: e520
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a33
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1488
		setInput (2131165236, "writeText", "90");
		// Setting input: i1489
		setInput (2131165270, "writeText", "8");
		// Setting input: i1490
		setInput (2131165273, "writeText", "11");
		// Setting input: i1491
		setInput (2131165292, "writeText", "72");
		// Firing event: e550
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a34
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1516
		setInput (2131165236, "writeText", "90");
		// Setting input: i1517
		setInput (2131165270, "writeText", "8");
		// Setting input: i1518
		setInput (2131165273, "writeText", "11");
		// Setting input: i1519
		setInput (2131165292, "writeText", "72");
		// Firing event: e560
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a35
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1608
		setInput (2131165236, "writeText", "90");
		// Setting input: i1609
		setInput (2131165270, "writeText", "8");
		// Setting input: i1610
		setInput (2131165273, "writeText", "11");
		// Setting input: i1611
		setInput (2131165292, "writeText", "72");
		// Firing event: e586
		fireEvent (2131165289, 32, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a36
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e614
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a37
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e626
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a38
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1712
		setInput (2131165236, "writeText", "90");
		// Setting input: i1713
		setInput (2131165270, "writeText", "8");
		// Setting input: i1714
		setInput (2131165273, "writeText", "11");
		// Setting input: i1715
		setInput (2131165292, "writeText", "72");
		// Firing event: e643
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a39
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1748
		setInput (2131165236, "writeText", "90");
		// Setting input: i1749
		setInput (2131165270, "writeText", "8");
		// Setting input: i1750
		setInput (2131165273, "writeText", "11");
		// Setting input: i1751
		setInput (2131165292, "writeText", "72");
		// Firing event: e655
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a40
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1856
		setInput (2131165236, "writeText", "90");
		// Setting input: i1857
		setInput (2131165270, "writeText", "8");
		// Setting input: i1858
		setInput (2131165273, "writeText", "11");
		// Setting input: i1859
		setInput (2131165292, "writeText", "72");
		// Firing event: e685
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a41
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1892
		setInput (2131165236, "writeText", "90");
		// Setting input: i1893
		setInput (2131165270, "writeText", "8");
		// Setting input: i1894
		setInput (2131165273, "writeText", "11");
		// Setting input: i1895
		setInput (2131165292, "writeText", "72");
		// Firing event: e697
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a42
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1992
		setInput (2131165236, "writeText", "90");
		// Setting input: i1993
		setInput (2131165270, "writeText", "8");
		// Setting input: i1994
		setInput (2131165273, "writeText", "11");
		// Setting input: i1995
		setInput (2131165292, "writeText", "72");
		// Firing event: e725
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a43
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2028
		setInput (2131165236, "writeText", "90");
		// Setting input: i2029
		setInput (2131165270, "writeText", "8");
		// Setting input: i2030
		setInput (2131165273, "writeText", "11");
		// Setting input: i2031
		setInput (2131165292, "writeText", "72");
		// Firing event: e737
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a44
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2100
		setInput (2131165236, "writeText", "90");
		// Setting input: i2101
		setInput (2131165270, "writeText", "8");
		// Setting input: i2102
		setInput (2131165273, "writeText", "11");
		// Setting input: i2103
		setInput (2131165292, "writeText", "72");
		// Firing event: e758
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a45
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2220
		setInput (2131165236, "writeText", "90");
		// Setting input: i2221
		setInput (2131165270, "writeText", "8");
		// Setting input: i2222
		setInput (2131165273, "writeText", "11");
		// Setting input: i2223
		setInput (2131165292, "writeText", "72");
		// Firing event: e791
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a46
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e817
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a47
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2356
		setInput (2131165236, "writeText", "90");
		// Setting input: i2357
		setInput (2131165270, "writeText", "8");
		// Setting input: i2358
		setInput (2131165273, "writeText", "11");
		// Setting input: i2359
		setInput (2131165292, "writeText", "72");
		// Firing event: e831
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a48
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2404
		setInput (2131165236, "writeText", "90");
		// Setting input: i2405
		setInput (2131165270, "writeText", "8");
		// Setting input: i2406
		setInput (2131165273, "writeText", "11");
		// Setting input: i2407
		setInput (2131165292, "writeText", "72");
		// Firing event: e846
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a49
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2508
		setInput (2131165236, "writeText", "90");
		// Setting input: i2509
		setInput (2131165270, "writeText", "8");
		// Setting input: i2510
		setInput (2131165273, "writeText", "11");
		// Setting input: i2511
		setInput (2131165292, "writeText", "72");
		// Firing event: e875
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a50
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2540
		setInput (2131165236, "writeText", "90");
		// Setting input: i2541
		setInput (2131165270, "writeText", "8");
		// Setting input: i2542
		setInput (2131165273, "writeText", "11");
		// Setting input: i2543
		setInput (2131165292, "writeText", "72");
		// Firing event: e886
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a51
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2628
		setInput (2131165236, "writeText", "90");
		// Setting input: i2629
		setInput (2131165270, "writeText", "8");
		// Setting input: i2630
		setInput (2131165273, "writeText", "11");
		// Setting input: i2631
		setInput (2131165292, "writeText", "72");
		// Firing event: e911
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a52
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2696
		setInput (2131165236, "writeText", "90");
		// Setting input: i2697
		setInput (2131165270, "writeText", "8");
		// Setting input: i2698
		setInput (2131165273, "writeText", "11");
		// Setting input: i2699
		setInput (2131165292, "writeText", "72");
		// Firing event: e931
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a53
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2772
		setInput (2131165236, "writeText", "90");
		// Setting input: i2773
		setInput (2131165270, "writeText", "8");
		// Setting input: i2774
		setInput (2131165273, "writeText", "11");
		// Setting input: i2775
		setInput (2131165292, "writeText", "72");
		// Firing event: e953
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a54
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2848
		setInput (2131165236, "writeText", "90");
		// Setting input: i2849
		setInput (2131165270, "writeText", "8");
		// Setting input: i2850
		setInput (2131165273, "writeText", "11");
		// Setting input: i2851
		setInput (2131165292, "writeText", "72");
		// Firing event: e975
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a55
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2908
		setInput (2131165236, "writeText", "90");
		// Setting input: i2909
		setInput (2131165270, "writeText", "8");
		// Setting input: i2910
		setInput (2131165273, "writeText", "11");
		// Setting input: i2911
		setInput (2131165292, "writeText", "72");
		// Firing event: e993
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a56
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i2992
		setInput (2131165236, "writeText", "90");
		// Setting input: i2993
		setInput (2131165270, "writeText", "8");
		// Setting input: i2994
		setInput (2131165273, "writeText", "11");
		// Setting input: i2995
		setInput (2131165292, "writeText", "72");
		// Firing event: e1017
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a57
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3068
		setInput (2131165236, "writeText", "90");
		// Setting input: i3069
		setInput (2131165270, "writeText", "8");
		// Setting input: i3070
		setInput (2131165273, "writeText", "11");
		// Setting input: i3071
		setInput (2131165292, "writeText", "72");
		// Firing event: e1039
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a58
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3128
		setInput (2131165236, "writeText", "90");
		// Setting input: i3129
		setInput (2131165270, "writeText", "8");
		// Setting input: i3130
		setInput (2131165273, "writeText", "11");
		// Setting input: i3131
		setInput (2131165292, "writeText", "72");
		// Firing event: e1057
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a59
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3188
		setInput (2131165236, "writeText", "90");
		// Setting input: i3189
		setInput (2131165270, "writeText", "8");
		// Setting input: i3190
		setInput (2131165273, "writeText", "11");
		// Setting input: i3191
		setInput (2131165292, "writeText", "72");
		// Firing event: e1075
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a60
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3240
		setInput (2131165236, "writeText", "90");
		// Setting input: i3241
		setInput (2131165270, "writeText", "8");
		// Setting input: i3242
		setInput (2131165273, "writeText", "11");
		// Setting input: i3243
		setInput (2131165292, "writeText", "72");
		// Firing event: e1091
		fireEvent (2131165274, 16, "Select Categories", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a61
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e1114
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a62
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e1119
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a63
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1140
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a64
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3440
		setInput (2131165236, "writeText", "90");
		// Setting input: i3441
		setInput (2131165270, "writeText", "8");
		// Setting input: i3442
		setInput (2131165273, "writeText", "11");
		// Setting input: i3443
		setInput (2131165292, "writeText", "72");
		// Firing event: e1157
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a65
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3460
		setInput (2131165236, "writeText", "90");
		// Setting input: i3461
		setInput (2131165270, "writeText", "8");
		// Setting input: i3462
		setInput (2131165273, "writeText", "11");
		// Setting input: i3463
		setInput (2131165292, "writeText", "72");
		// Firing event: e1165
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a66
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3560
		setInput (2131165236, "writeText", "90");
		// Setting input: i3561
		setInput (2131165270, "writeText", "8");
		// Setting input: i3562
		setInput (2131165273, "writeText", "11");
		// Setting input: i3563
		setInput (2131165292, "writeText", "72");
		// Firing event: e1193
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a67
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3644
		setInput (2131165236, "writeText", "90");
		// Setting input: i3645
		setInput (2131165270, "writeText", "8");
		// Setting input: i3646
		setInput (2131165273, "writeText", "11");
		// Setting input: i3647
		setInput (2131165292, "writeText", "72");
		// Firing event: e1217
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a68
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3712
		setInput (2131165236, "writeText", "90");
		// Setting input: i3713
		setInput (2131165270, "writeText", "8");
		// Setting input: i3714
		setInput (2131165273, "writeText", "11");
		// Setting input: i3715
		setInput (2131165292, "writeText", "72");
		// Firing event: e1237
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a69
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3796
		setInput (2131165236, "writeText", "90");
		// Setting input: i3797
		setInput (2131165270, "writeText", "8");
		// Setting input: i3798
		setInput (2131165273, "writeText", "11");
		// Setting input: i3799
		setInput (2131165292, "writeText", "72");
		// Firing event: e1261
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a70
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i3836
		setInput (2131165236, "writeText", "90");
		// Setting input: i3837
		setInput (2131165270, "writeText", "8");
		// Setting input: i3838
		setInput (2131165273, "writeText", "11");
		// Setting input: i3839
		setInput (2131165292, "writeText", "72");
		// Firing event: e1274
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a71
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1308
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a72
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4016
		setInput (2131165236, "writeText", "90");
		// Setting input: i4017
		setInput (2131165270, "writeText", "8");
		// Setting input: i4018
		setInput (2131165273, "writeText", "11");
		// Setting input: i4019
		setInput (2131165292, "writeText", "72");
		// Firing event: e1325
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a73
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4076
		setInput (2131165236, "writeText", "90");
		// Setting input: i4077
		setInput (2131165270, "writeText", "8");
		// Setting input: i4078
		setInput (2131165273, "writeText", "11");
		// Setting input: i4079
		setInput (2131165292, "writeText", "72");
		// Firing event: e1343
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a74
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4108
		setInput (2131165236, "writeText", "90");
		// Setting input: i4109
		setInput (2131165270, "writeText", "8");
		// Setting input: i4110
		setInput (2131165273, "writeText", "11");
		// Setting input: i4111
		setInput (2131165292, "writeText", "72");
		// Firing event: e1354
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a75
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4224
		setInput (2131165236, "writeText", "90");
		// Setting input: i4225
		setInput (2131165270, "writeText", "8");
		// Setting input: i4226
		setInput (2131165273, "writeText", "11");
		// Setting input: i4227
		setInput (2131165292, "writeText", "72");
		// Firing event: e1386
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a76
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1415
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a77
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4340
		setInput (2131165236, "writeText", "90");
		// Setting input: i4341
		setInput (2131165270, "writeText", "8");
		// Setting input: i4342
		setInput (2131165273, "writeText", "11");
		// Setting input: i4343
		setInput (2131165292, "writeText", "72");
		// Firing event: e1421
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a78
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4432
		setInput (2131165236, "writeText", "90");
		// Setting input: i4433
		setInput (2131165270, "writeText", "8");
		// Setting input: i4434
		setInput (2131165273, "writeText", "11");
		// Setting input: i4435
		setInput (2131165292, "writeText", "72");
		// Firing event: e1447
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a79
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4528
		setInput (2131165236, "writeText", "90");
		// Setting input: i4529
		setInput (2131165270, "writeText", "8");
		// Setting input: i4530
		setInput (2131165273, "writeText", "11");
		// Setting input: i4531
		setInput (2131165292, "writeText", "72");
		// Firing event: e1474
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "10");

		retrieveWidgets();
		// Testing current activity: should be a80
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4560
		setInput (2131165236, "writeText", "90");
		// Setting input: i4561
		setInput (2131165270, "writeText", "8");
		// Setting input: i4562
		setInput (2131165273, "writeText", "11");
		// Setting input: i4563
		setInput (2131165292, "writeText", "72");
		// Firing event: e1485
		fireEvent (2131165289, 32, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a81
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1504
		fireEvent (16908795, 19, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a82
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1517
		fireEvent (16908794, 19, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a83
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1528
		fireEvent (16908794, 14, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a84
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1554
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a85
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1557
		fireEvent (16908795, 15, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a86
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1572
		fireEvent (16908796, 17, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a87
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1588
		fireEvent (16908795, 19, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a88
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1607
		fireEvent (16908313, 29, "Set", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a89
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1615
		fireEvent (16908794, 18, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a90
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1633
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a91
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4644
		setInput (2131165236, "writeText", "90");
		// Setting input: i4645
		setInput (2131165270, "writeText", "8");
		// Setting input: i4646
		setInput (2131165273, "writeText", "11");
		// Setting input: i4647
		setInput (2131165292, "writeText", "72");
		// Firing event: e1645
		fireEvent (2131165291, 34, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a92
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i4748
		setInput (2131165236, "writeText", "90");
		// Setting input: i4749
		setInput (2131165270, "writeText", "8");
		// Setting input: i4750
		setInput (2131165273, "writeText", "11");
		// Setting input: i4751
		setInput (2131165292, "writeText", "72");
		// Firing event: e1674
		fireEvent (2131165293, 37, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a93
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1684
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a94
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1697
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a95
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1701
		fireEvent (16908298, 9, "", "listView", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a96
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1714
		fireEvent (2131165410, 39, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a97
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1726
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a98
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1731
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a99
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1733
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a100
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1738
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a101
		solo.assertCurrentActivity("", "Posts");

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

