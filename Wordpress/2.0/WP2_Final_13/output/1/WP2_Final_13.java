package org.wordpress.android.test;

/* Wordpress 2.0 Final - WP2_Final_13 */

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

	// Generated from trace 788
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
		// Firing event: e2
		fireEvent (1, "Add Account", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a3
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e15
		fireEvent (23, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a4
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e27
		fireEvent (2131165255, 36, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a5
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e41
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a6
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e49
		fireEvent (8, "", "listView", "selectListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a7
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i27
		setInput (2131165236, "writeText", "90");
		// Setting input: i28
		setInput (2131165268, "writeText", "85");
		// Setting input: i29
		setInput (2131165286, "writeText", "45");
		// Firing event: e67
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a8
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i51
		setInput (2131165236, "writeText", "90");
		// Setting input: i52
		setInput (2131165268, "writeText", "85");
		// Setting input: i53
		setInput (2131165286, "writeText", "45");
		// Firing event: e78
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a9
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i117
		setInput (2131165236, "writeText", "90");
		// Setting input: i118
		setInput (2131165268, "writeText", "85");
		// Setting input: i119
		setInput (2131165286, "writeText", "45");
		// Firing event: e103
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a10
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i141
		setInput (2131165236, "writeText", "90");
		// Setting input: i142
		setInput (2131165268, "writeText", "85");
		// Setting input: i143
		setInput (2131165286, "writeText", "45");
		// Firing event: e114
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a11
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i180
		setInput (2131165236, "writeText", "90");
		// Setting input: i181
		setInput (2131165268, "writeText", "85");
		// Setting input: i182
		setInput (2131165286, "writeText", "45");
		// Firing event: e130
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a12
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i213
		setInput (2131165236, "writeText", "90");
		// Setting input: i214
		setInput (2131165268, "writeText", "85");
		// Setting input: i215
		setInput (2131165286, "writeText", "45");
		// Firing event: e144
		fireEvent (2131165269, 14, "Select Categories", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a13
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e161
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a14
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e166
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a15
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e167
		fireEvent (1, "Refresh Categories", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a16
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e173
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a17
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e175
		fireEvent (16908298, 3, "", "multiChoiceList", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a18
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e189
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a19
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e208
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a20
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i321
		setInput (2131165236, "writeText", "90");
		// Setting input: i322
		setInput (2131165268, "writeText", "85");
		// Setting input: i323
		setInput (2131165286, "writeText", "45");
		// Firing event: e218
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a21
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i351
		setInput (2131165236, "writeText", "90");
		// Setting input: i352
		setInput (2131165268, "writeText", "85");
		// Setting input: i353
		setInput (2131165286, "writeText", "45");
		// Firing event: e231
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a22
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e258
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a23
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e275
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a24
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i489
		setInput (2131165236, "writeText", "90");
		// Setting input: i490
		setInput (2131165268, "writeText", "85");
		// Setting input: i491
		setInput (2131165286, "writeText", "45");
		// Firing event: e286
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a25
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i522
		setInput (2131165236, "writeText", "90");
		// Setting input: i523
		setInput (2131165268, "writeText", "85");
		// Setting input: i524
		setInput (2131165286, "writeText", "45");
		// Firing event: e300
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a26
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e325
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a27
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e328
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a28
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e340
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a29
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e351
		fireEvent (8, "", "listView", "longClickListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a30
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e356
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a31
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e360
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a32
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e363
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a33
		solo.assertCurrentActivity("", "ChooserActivity");

		// Testing transition 
		// Firing event: e367
		fireEvent (8, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a34
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e372
		fireEvent (8, "", "listView", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a35
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i606
		setInput (2131165236, "writeText", "90");
		// Setting input: i607
		setInput (2131165268, "writeText", "85");
		// Setting input: i608
		setInput (2131165286, "writeText", "45");
		// Firing event: e384
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a36
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i648
		setInput (2131165236, "writeText", "90");
		// Setting input: i649
		setInput (2131165268, "writeText", "85");
		// Setting input: i650
		setInput (2131165286, "writeText", "45");
		// Firing event: e401
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a37
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i687
		setInput (2131165236, "writeText", "90");
		// Setting input: i688
		setInput (2131165268, "writeText", "85");
		// Setting input: i689
		setInput (2131165286, "writeText", "45");
		// Firing event: e417
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a38
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i747
		setInput (2131165236, "writeText", "90");
		// Setting input: i748
		setInput (2131165268, "writeText", "85");
		// Setting input: i749
		setInput (2131165286, "writeText", "45");
		// Firing event: e440
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a39
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i762
		setInput (2131165236, "writeText", "90");
		// Setting input: i763
		setInput (2131165268, "writeText", "85");
		// Setting input: i764
		setInput (2131165286, "writeText", "45");
		// Firing event: e448
		fireEvent (2131165283, 28, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a40
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e470
		fireEvent (16908795, 23, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a41
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e487
		fireEvent (16908314, 31, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a42
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i801
		setInput (2131165236, "writeText", "90");
		// Setting input: i802
		setInput (2131165268, "writeText", "85");
		// Setting input: i803
		setInput (2131165286, "writeText", "45");
		// Firing event: e492
		fireEvent (2131165269, 14, "Select Categories", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a43
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e510
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a44
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e514
		fireEvent (16908298, 3, "", "multiChoiceList", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a45
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e524
		fireEvent (2131165344, 7, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a46
		solo.assertCurrentActivity("", "AddCategory");

		// Testing transition 
		// Firing event: e536
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a47
		solo.assertCurrentActivity("", "AddCategory");

		// Testing transition 
		// Setting input: i867
		setInput (2131165228, "writeText", "61");
		// Setting input: i868
		setInput (2131165230, "writeText", "84");
		// Setting input: i869
		setInput (2131165232, "writeText", "86");
		// Firing event: e541
		fireEvent (2131165220, 16, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a48
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e551
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a49
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e568
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a50
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e575
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a51
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e580
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a52
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e585
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a53
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e586
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a54
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e598
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a55
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e610
		fireEvent (16908298, 6, "", "listView", "selectListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a56
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e644
		fireEvent (2131165201, 51, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a57
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e662
		fireEvent (2131165200, 49, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a58
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e678
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a59
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e706
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a60
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e716
		fireEvent (8, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a61
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e721
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a62
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e727
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a63
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e730
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a64
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e734
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a65
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e739
		fireEvent (16908298, 6, "", "listView", "selectListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a66
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e755
		fireEvent (2131165388, 43, "", "webPage", "longClick");

		retrieveWidgets();
		// Testing current activity: should be a67
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e767
		fireEvent (2131165201, 54, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a68
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e780
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a69
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e781
		fireEvent (2131165384, 12, "", "button", "click");

		// This event leads to crash
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 967
	public void testTrace00001 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e792
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a70
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e804
		fireEvent (2131165263, 53, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a71
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e810
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a72
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e825
		fireEvent (2131165264, 56, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a73
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e833
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a74
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e834
		fireEvent (2131165200, 27, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a75
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e851
		fireEvent (2131165264, 72, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a76
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e861
		fireEvent (2131165370, 7, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a77
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e876
		fireEvent (2131165369, 5, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a78
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e903
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a79
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e906
		fireEvent (2131165200, 11, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a80
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e925
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a81
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e927
		fireEvent (1, "Add Account", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a82
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e942
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a83
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e946
		fireEvent (2131165201, 13, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a84
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e967
		fireEvent (2131165254, 31, "", "linearLayout", "click");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 788
	public void testTrace00002 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e0
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a2
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2
		fireEvent (1, "Add Account", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a3
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e15
		fireEvent (23, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a4
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e27
		fireEvent (2131165255, 36, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a5
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e41
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a6
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e49
		fireEvent (8, "", "listView", "selectListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a7
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i27
		setInput (2131165236, "writeText", "90");
		// Setting input: i28
		setInput (2131165268, "writeText", "85");
		// Setting input: i29
		setInput (2131165286, "writeText", "45");
		// Firing event: e67
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a8
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i51
		setInput (2131165236, "writeText", "90");
		// Setting input: i52
		setInput (2131165268, "writeText", "85");
		// Setting input: i53
		setInput (2131165286, "writeText", "45");
		// Firing event: e78
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a9
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i117
		setInput (2131165236, "writeText", "90");
		// Setting input: i118
		setInput (2131165268, "writeText", "85");
		// Setting input: i119
		setInput (2131165286, "writeText", "45");
		// Firing event: e103
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a10
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i141
		setInput (2131165236, "writeText", "90");
		// Setting input: i142
		setInput (2131165268, "writeText", "85");
		// Setting input: i143
		setInput (2131165286, "writeText", "45");
		// Firing event: e114
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a11
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i180
		setInput (2131165236, "writeText", "90");
		// Setting input: i181
		setInput (2131165268, "writeText", "85");
		// Setting input: i182
		setInput (2131165286, "writeText", "45");
		// Firing event: e130
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a12
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i213
		setInput (2131165236, "writeText", "90");
		// Setting input: i214
		setInput (2131165268, "writeText", "85");
		// Setting input: i215
		setInput (2131165286, "writeText", "45");
		// Firing event: e144
		fireEvent (2131165269, 14, "Select Categories", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a13
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e161
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a14
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e166
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a15
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e167
		fireEvent (1, "Refresh Categories", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a16
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e173
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a17
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e175
		fireEvent (16908298, 3, "", "multiChoiceList", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a18
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e189
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a19
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e208
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a20
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i321
		setInput (2131165236, "writeText", "90");
		// Setting input: i322
		setInput (2131165268, "writeText", "85");
		// Setting input: i323
		setInput (2131165286, "writeText", "45");
		// Firing event: e218
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a21
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i351
		setInput (2131165236, "writeText", "90");
		// Setting input: i352
		setInput (2131165268, "writeText", "85");
		// Setting input: i353
		setInput (2131165286, "writeText", "45");
		// Firing event: e231
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a22
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e258
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a23
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e275
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a24
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i489
		setInput (2131165236, "writeText", "90");
		// Setting input: i490
		setInput (2131165268, "writeText", "85");
		// Setting input: i491
		setInput (2131165286, "writeText", "45");
		// Firing event: e286
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a25
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i522
		setInput (2131165236, "writeText", "90");
		// Setting input: i523
		setInput (2131165268, "writeText", "85");
		// Setting input: i524
		setInput (2131165286, "writeText", "45");
		// Firing event: e300
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a26
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e325
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a27
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e328
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a28
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e340
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a29
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e351
		fireEvent (8, "", "listView", "longClickListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a30
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e356
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a31
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e360
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a32
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e363
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a33
		solo.assertCurrentActivity("", "ChooserActivity");

		// Testing transition 
		// Firing event: e367
		fireEvent (8, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a34
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e372
		fireEvent (8, "", "listView", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a35
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i606
		setInput (2131165236, "writeText", "90");
		// Setting input: i607
		setInput (2131165268, "writeText", "85");
		// Setting input: i608
		setInput (2131165286, "writeText", "45");
		// Firing event: e384
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a36
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i648
		setInput (2131165236, "writeText", "90");
		// Setting input: i649
		setInput (2131165268, "writeText", "85");
		// Setting input: i650
		setInput (2131165286, "writeText", "45");
		// Firing event: e401
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a37
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i687
		setInput (2131165236, "writeText", "90");
		// Setting input: i688
		setInput (2131165268, "writeText", "85");
		// Setting input: i689
		setInput (2131165286, "writeText", "45");
		// Firing event: e417
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a38
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i747
		setInput (2131165236, "writeText", "90");
		// Setting input: i748
		setInput (2131165268, "writeText", "85");
		// Setting input: i749
		setInput (2131165286, "writeText", "45");
		// Firing event: e440
		fireEvent (2131165285, 30, "", "spinner", "selectSpinnerItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a39
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i762
		setInput (2131165236, "writeText", "90");
		// Setting input: i763
		setInput (2131165268, "writeText", "85");
		// Setting input: i764
		setInput (2131165286, "writeText", "45");
		// Firing event: e448
		fireEvent (2131165283, 28, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a40
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e470
		fireEvent (16908795, 23, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a41
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e487
		fireEvent (16908314, 31, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a42
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i801
		setInput (2131165236, "writeText", "90");
		// Setting input: i802
		setInput (2131165268, "writeText", "85");
		// Setting input: i803
		setInput (2131165286, "writeText", "45");
		// Firing event: e492
		fireEvent (2131165269, 14, "Select Categories", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a43
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e510
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a44
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e514
		fireEvent (16908298, 3, "", "multiChoiceList", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a45
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e524
		fireEvent (2131165344, 7, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a46
		solo.assertCurrentActivity("", "AddCategory");

		// Testing transition 
		// Firing event: e536
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a47
		solo.assertCurrentActivity("", "AddCategory");

		// Testing transition 
		// Setting input: i867
		setInput (2131165228, "writeText", "61");
		// Setting input: i868
		setInput (2131165230, "writeText", "84");
		// Setting input: i869
		setInput (2131165232, "writeText", "86");
		// Firing event: e541
		fireEvent (2131165220, 16, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a48
		solo.assertCurrentActivity("", "SelectCategories");

		// Testing transition 
		// Firing event: e551
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a49
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e568
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a50
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e575
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a51
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e580
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a52
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e585
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a53
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e586
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a54
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e598
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a55
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e610
		fireEvent (16908298, 6, "", "listView", "selectListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a56
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e644
		fireEvent (2131165201, 51, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a57
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e662
		fireEvent (2131165200, 49, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a58
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e678
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a59
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e706
		fireEvent (16908298, 6, "", "listView", "longClickListItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a60
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e716
		fireEvent (8, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a61
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e721
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a62
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e727
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a63
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e730
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a64
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e734
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a65
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e739
		fireEvent (16908298, 6, "", "listView", "selectListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a66
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e755
		fireEvent (2131165388, 43, "", "webPage", "longClick");

		retrieveWidgets();
		// Testing current activity: should be a67
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e767
		fireEvent (2131165201, 54, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a68
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e780
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a69
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e781
		fireEvent (2131165384, 12, "", "button", "click");

		// This event leads to crash
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 967
	public void testTrace00003 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e792
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a70
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e804
		fireEvent (2131165263, 53, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a71
		solo.assertCurrentActivity("", "Read");

		// Testing transition 
		// Firing event: e810
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a72
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e825
		fireEvent (2131165264, 56, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a73
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e833
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a74
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e834
		fireEvent (2131165200, 27, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a75
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e851
		fireEvent (2131165264, 72, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a76
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e861
		fireEvent (2131165370, 7, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a77
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e876
		fireEvent (2131165369, 5, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a78
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e903
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a79
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e906
		fireEvent (2131165200, 11, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a80
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e925
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a81
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e927
		fireEvent (1, "Add Account", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a82
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e942
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a83
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e946
		fireEvent (2131165201, 13, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a84
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e967
		fireEvent (2131165254, 31, "", "linearLayout", "click");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 969
	public void testTrace00004 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e977
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 971
	public void testTrace00005 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e980
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 973
	public void testTrace00006 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e982
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 975
	public void testTrace00007 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e984
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 975
	public void testTrace00008 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e984
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 977
	public void testTrace00009 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e986
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 979
	public void testTrace00010 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e987
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 981
	public void testTrace00011 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e989
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 981
	public void testTrace00012 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e989
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 983
	public void testTrace00013 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e991
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 985
	public void testTrace00014 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e993
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1021
	public void testTrace00015 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1007
		fireEvent (2131165264, 56, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a90
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e1010
		fireEvent (2131165200, 27, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a91
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e1020
		fireEvent (2131165252, 44, "", "linearLayout", "click");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1021
	public void testTrace00016 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1007
		fireEvent (2131165264, 56, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a90
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e1010
		fireEvent (2131165200, 27, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a91
		solo.assertCurrentActivity("", "ViewStats");

		// Testing transition 
		// Firing event: e1020
		fireEvent (2131165252, 44, "", "linearLayout", "click");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1023
	public void testTrace00017 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1031
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1025
	public void testTrace00018 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1033
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1027
	public void testTrace00019 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1035
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1029
	public void testTrace00020 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1037
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1029
	public void testTrace00021 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1037
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1031
	public void testTrace00022 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1040
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1033
	public void testTrace00023 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1042
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1035
	public void testTrace00024 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1043
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1037
	public void testTrace00025 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1045
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1037
	public void testTrace00026 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1045
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1039
	public void testTrace00027 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1048
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1041
	public void testTrace00028 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1049
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1043
	public void testTrace00029 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1051
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1045
	public void testTrace00030 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1054
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1045
	public void testTrace00031 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1054
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1047
	public void testTrace00032 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1055
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1049
	public void testTrace00033 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1057
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1051
	public void testTrace00034 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1059
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1053
	public void testTrace00035 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1062
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1053
	public void testTrace00036 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1062
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1055
	public void testTrace00037 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1064
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1057
	public void testTrace00038 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1065
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1059
	public void testTrace00039 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1067
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1059
	public void testTrace00040 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1067
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1061
	public void testTrace00041 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1069
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1063
	public void testTrace00042 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1071
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1065
	public void testTrace00043 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1073
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1067
	public void testTrace00044 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1076
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1069
	public void testTrace00045 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1078
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1071
	public void testTrace00046 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1080
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
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

