package org.wordpress.android.test;

/* WordPress 2.1 Original Version Random - WP2.1_3 */

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

	// Generated from trace 49
	public void testTrace00000 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a2
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2
		fireEvent (2131165200, 11, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a3
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e19
		fireEvent (2131165201, 13, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a4
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e26
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a5
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e33
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a6
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e35
		fireEvent (2131165200, 11, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a7
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e46
		fireEvent (2131165255, 31, "", "linearLayout", "click");

		// This event leads to Katie's Sweet Testing Blog - New Post
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 51
	public void testTrace00001 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e57
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 172
	public void testTrace00002 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e67
		fireEvent (2131165258, 43, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a10
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e83
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a11
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e91
		fireEvent (2131165201, 44, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a12
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e105
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a13
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e107
		fireEvent (16908298, 5, "", "singleChoiceList", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a14
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e122
		fireEvent (2131165387, 53, "Spam", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a15
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e131
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a16
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e143
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a17
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e151
		fireEvent (2131165200, 63, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a18
		solo.assertCurrentActivity("", "Comments");

		// Testing transition 
		// Firing event: e160
		fireEvent (2131165386, 52, "Reply", "button", "click");

		// This event leads to crash
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 206
	public void testTrace00003 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e179
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a19
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e182
		fireEvent (2, "Preferences", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a20
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e194
		fireEvent (23, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a21
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e205
		fireEvent (2131165255, 31, "", "linearLayout", "click");

		// This event leads to Katie's Sweet Testing Blog - New Post
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 845
	public void testTrace00004 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e215
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a23
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e223
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a24
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e225
		fireEvent (2, "Preferences", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a25
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e233
		fireEvent (15, "Play notification sound", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a26
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e244
		fireEvent (15, "Play notification sound", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a27
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e254
		fireEvent (2, 10, "My Blog", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a28
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e269
		fireEvent (20, "Add a tagline to new posts", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a29
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e282
		fireEvent (24, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a30
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e287
		fireEvent (2131165201, 13, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a31
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e310
		fireEvent (2131165257, 39, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a32
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e331
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a33
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e342
		fireEvent (8, "", "listView", "longClickListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a34
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e347
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a35
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e350
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a36
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e352
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a37
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e363
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a38
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e378
		fireEvent (8, "", "listView", "longClickListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a39
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e387
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a40
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e392
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a41
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e394
		fireEvent (16908314, 17, "No", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a42
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e401
		fireEvent (16908298, 9, "", "listView", "selectListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a43
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e424
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a44
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e440
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a45
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e453
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a46
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e457
		fireEvent (16908298, 9, "", "listView", "selectListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a47
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e474
		fireEvent (2131165407, 41, "", "webPage", "longClick");

		retrieveWidgets();
		// Testing current activity: should be a48
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e493
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a49
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e494
		fireEvent (2131165407, 41, "", "webPage", "longClick");

		retrieveWidgets();
		// Testing current activity: should be a50
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e508
		fireEvent (2131165413, 48, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a51
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i0
		setInput (2131165236, "writeText", "90");
		// Setting input: i1
		setInput (2131165270, "writeText", "8");
		// Setting input: i2
		setInput (2131165292, "writeText", "72");
		// Firing event: e514
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a52
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i24
		setInput (2131165236, "writeText", "90");
		// Setting input: i25
		setInput (2131165270, "writeText", "8");
		// Setting input: i26
		setInput (2131165292, "writeText", "72");
		// Firing event: e525
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a53
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e541
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a54
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i78
		setInput (2131165236, "writeText", "90");
		// Setting input: i79
		setInput (2131165270, "writeText", "8");
		// Setting input: i80
		setInput (2131165292, "writeText", "72");
		// Firing event: e549
		fireEvent (2131165289, 32, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a55
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e562
		fireEvent (16908796, 24, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a56
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e581
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a57
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e592
		fireEvent (16908314, 30, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a58
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i87
		setInput (2131165236, "writeText", "90");
		// Setting input: i88
		setInput (2131165270, "writeText", "8");
		// Setting input: i89
		setInput (2131165292, "writeText", "72");
		// Firing event: e597
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a59
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e613
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a60
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i126
		setInput (2131165236, "writeText", "90");
		// Setting input: i127
		setInput (2131165270, "writeText", "8");
		// Setting input: i128
		setInput (2131165292, "writeText", "72");
		// Firing event: e616
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a61
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e634
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a62
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e644
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a63
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i195
		setInput (2131165236, "writeText", "90");
		// Setting input: i196
		setInput (2131165270, "writeText", "8");
		// Setting input: i197
		setInput (2131165292, "writeText", "72");
		// Firing event: e648
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a64
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i222
		setInput (2131165236, "writeText", "90");
		// Setting input: i223
		setInput (2131165270, "writeText", "8");
		// Setting input: i224
		setInput (2131165292, "writeText", "72");
		// Firing event: e660
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a65
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e675
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a66
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i258
		setInput (2131165236, "writeText", "90");
		// Setting input: i259
		setInput (2131165270, "writeText", "8");
		// Setting input: i260
		setInput (2131165292, "writeText", "72");
		// Firing event: e678
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a67
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i279
		setInput (2131165236, "writeText", "90");
		// Setting input: i280
		setInput (2131165270, "writeText", "8");
		// Setting input: i281
		setInput (2131165292, "writeText", "72");
		// Firing event: e688
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a68
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i297
		setInput (2131165236, "writeText", "90");
		// Setting input: i298
		setInput (2131165270, "writeText", "8");
		// Setting input: i299
		setInput (2131165292, "writeText", "72");
		// Firing event: e697
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a69
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i327
		setInput (2131165236, "writeText", "90");
		// Setting input: i328
		setInput (2131165270, "writeText", "8");
		// Setting input: i329
		setInput (2131165292, "writeText", "72");
		// Firing event: e710
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a70
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i351
		setInput (2131165236, "writeText", "90");
		// Setting input: i352
		setInput (2131165270, "writeText", "8");
		// Setting input: i353
		setInput (2131165292, "writeText", "72");
		// Firing event: e721
		fireEvent (2131165289, 32, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a71
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e738
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a72
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e749
		fireEvent (16908313, 28, "Set", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a73
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e754
		fireEvent (16908794, 14, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a74
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e774
		fireEvent (16908314, 27, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a75
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i363
		setInput (2131165236, "writeText", "90");
		// Setting input: i364
		setInput (2131165270, "writeText", "8");
		// Setting input: i365
		setInput (2131165292, "writeText", "72");
		// Firing event: e780
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a76
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i390
		setInput (2131165236, "writeText", "90");
		// Setting input: i391
		setInput (2131165270, "writeText", "8");
		// Setting input: i392
		setInput (2131165292, "writeText", "72");
		// Firing event: e792
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a77
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i405
		setInput (2131165236, "writeText", "90");
		// Setting input: i406
		setInput (2131165270, "writeText", "8");
		// Setting input: i407
		setInput (2131165292, "writeText", "72");
		// Firing event: e800
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a78
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i438
		setInput (2131165236, "writeText", "90");
		// Setting input: i439
		setInput (2131165270, "writeText", "8");
		// Setting input: i440
		setInput (2131165292, "writeText", "72");
		// Firing event: e814
		fireEvent (2131165293, 36, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a79
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e823
		fireEvent (2131165200, 31, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a80
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e840
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "6");

		// This event leads to crash
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1076
	public void testTrace00005 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e858
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a81
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e866
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a82
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e868
		fireEvent (2, "Preferences", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a83
		solo.assertCurrentActivity("", "Preferences");

		// Testing transition 
		// Firing event: e881
		fireEvent (24, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a84
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e890
		fireEvent (2131165254, 28, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a85
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i453
		setInput (2131165236, "writeText", "90");
		// Setting input: i454
		setInput (2131165270, "writeText", "8");
		// Setting input: i455
		setInput (2131165292, "writeText", "72");
		// Firing event: e905
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a86
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e918
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a87
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i501
		setInput (2131165236, "writeText", "90");
		// Setting input: i502
		setInput (2131165270, "writeText", "8");
		// Setting input: i503
		setInput (2131165292, "writeText", "72");
		// Firing event: e927
		fireEvent (2131165293, 36, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a88
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e936
		fireEvent (2131165254, 28, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a89
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i513
		setInput (2131165236, "writeText", "90");
		// Setting input: i514
		setInput (2131165270, "writeText", "8");
		// Setting input: i515
		setInput (2131165292, "writeText", "72");
		// Firing event: e950
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a90
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i534
		setInput (2131165236, "writeText", "90");
		// Setting input: i535
		setInput (2131165270, "writeText", "8");
		// Setting input: i536
		setInput (2131165292, "writeText", "72");
		// Firing event: e960
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a91
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i549
		setInput (2131165236, "writeText", "90");
		// Setting input: i550
		setInput (2131165270, "writeText", "8");
		// Setting input: i551
		setInput (2131165292, "writeText", "72");
		// Firing event: e968
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a92
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i576
		setInput (2131165236, "writeText", "90");
		// Setting input: i577
		setInput (2131165270, "writeText", "8");
		// Setting input: i578
		setInput (2131165292, "writeText", "72");
		// Firing event: e980
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a93
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e996
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a94
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i615
		setInput (2131165236, "writeText", "90");
		// Setting input: i616
		setInput (2131165270, "writeText", "8");
		// Setting input: i617
		setInput (2131165292, "writeText", "72");
		// Firing event: e999
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a95
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i636
		setInput (2131165236, "writeText", "90");
		// Setting input: i637
		setInput (2131165270, "writeText", "8");
		// Setting input: i638
		setInput (2131165292, "writeText", "72");
		// Firing event: e1009
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a96
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i660
		setInput (2131165236, "writeText", "90");
		// Setting input: i661
		setInput (2131165270, "writeText", "8");
		// Setting input: i662
		setInput (2131165292, "writeText", "72");
		// Firing event: e1020
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a97
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i672
		setInput (2131165236, "writeText", "90");
		// Setting input: i673
		setInput (2131165270, "writeText", "8");
		// Setting input: i674
		setInput (2131165292, "writeText", "72");
		// Firing event: e1027
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a98
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i711
		setInput (2131165236, "writeText", "90");
		// Setting input: i712
		setInput (2131165270, "writeText", "8");
		// Setting input: i713
		setInput (2131165292, "writeText", "72");
		// Firing event: e1043
		fireEvent (2131165293, 36, "Publish", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a99
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1047
		fireEvent (2131165200, 11, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a100
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1064
		fireEvent (2131165201, 13, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a101
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1072
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a102
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1074
		fireEvent (2131165201, 13, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a103
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1078
		fireEvent (2131165200, 11, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a104
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1088
		fireEvent (2131165253, 28, "", "linearLayout", "click");

		// This event leads to Katie's Sweet Testing Blog - New Post
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1246
	public void testTrace00006 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1109
		fireEvent (2131165262, 50, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a106
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Firing event: e1133
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a107
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i756
		setInput (2131165215, "writeText", "27");
		// Setting input: i757
		setInput (2131165217, "writeText", "29");
		// Firing event: e1138
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a108
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i802
		setInput (2131165215, "writeText", "27");
		// Setting input: i803
		setInput (2131165217, "writeText", "29");
		// Firing event: e1164
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "11");

		retrieveWidgets();
		// Testing current activity: should be a109
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Firing event: e1193
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a110
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Firing event: e1212
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a111
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i902
		setInput (2131165215, "writeText", "27");
		// Setting input: i903
		setInput (2131165217, "writeText", "29");
		// Firing event: e1223
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "10");

		retrieveWidgets();
		// Testing current activity: should be a112
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i948
		setInput (2131165215, "writeText", "27");
		// Setting input: i949
		setInput (2131165217, "writeText", "29");
		// Firing event: e1249
		fireEvent (2131165220, 28, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a113
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1265
		fireEvent (2131165263, 53, "", "linearLayout", "click");

		// This event leads to crash
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 1930
	public void testTrace00007 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1278
		fireEvent (2131165257, 39, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a114
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1290
		fireEvent (16908298, 9, "", "listView", "selectListItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a115
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1316
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a116
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1318
		fireEvent (1, "New Page", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a117
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i958
		setInput (2131165236, "writeText", "90");
		// Setting input: i959
		setInput (2131165270, "writeText", "8");
		// Setting input: i960
		setInput (2131165292, "writeText", "72");
		// Firing event: e1324
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a118
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i985
		setInput (2131165236, "writeText", "90");
		// Setting input: i986
		setInput (2131165270, "writeText", "8");
		// Setting input: i987
		setInput (2131165292, "writeText", "72");
		// Firing event: e1336
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a119
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1006
		setInput (2131165236, "writeText", "90");
		// Setting input: i1007
		setInput (2131165270, "writeText", "8");
		// Setting input: i1008
		setInput (2131165292, "writeText", "72");
		// Firing event: e1346
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a120
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1018
		setInput (2131165236, "writeText", "90");
		// Setting input: i1019
		setInput (2131165270, "writeText", "8");
		// Setting input: i1020
		setInput (2131165292, "writeText", "72");
		// Firing event: e1353
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a121
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1045
		setInput (2131165236, "writeText", "90");
		// Setting input: i1046
		setInput (2131165270, "writeText", "8");
		// Setting input: i1047
		setInput (2131165292, "writeText", "72");
		// Firing event: e1365
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a122
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1075
		setInput (2131165236, "writeText", "90");
		// Setting input: i1076
		setInput (2131165270, "writeText", "8");
		// Setting input: i1077
		setInput (2131165292, "writeText", "72");
		// Firing event: e1378
		fireEvent (2131165293, 36, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a123
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1388
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a124
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1410
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "11");

		retrieveWidgets();
		// Testing current activity: should be a125
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1419
		fireEvent (8, "", "listView", "longClickListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a126
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1434
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a127
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1114
		setInput (2131165236, "writeText", "90");
		// Setting input: i1115
		setInput (2131165270, "writeText", "8");
		// Setting input: i1116
		setInput (2131165292, "writeText", "72");
		// Firing event: e1440
		fireEvent (2131165289, 32, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a128
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1445
		fireEvent (16908794, 14, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a129
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1459
		fireEvent (16908794, 14, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a130
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1478
		fireEvent (16908796, 20, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a131
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1488
		fireEvent (16908795, 15, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a132
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1502
		fireEvent (16908795, 16, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a133
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1522
		fireEvent (16908795, 23, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a134
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1540
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a135
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1552
		fireEvent (16908313, 28, "Set", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a136
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1567
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a137
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1569
		fireEvent (16908794, 14, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a138
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1581
		fireEvent (16908794, 14, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a139
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1603
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a140
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1612
		fireEvent (16908313, 25, "Set", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a141
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1138
		setInput (2131165236, "writeText", "90");
		// Setting input: i1139
		setInput (2131165270, "writeText", "8");
		// Setting input: i1140
		setInput (2131165292, "writeText", "72");
		// Firing event: e1623
		fireEvent (2131165293, 36, "Publish", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a142
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1629
		fireEvent (16908298, 9, "", "listView", "selectListItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a143
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1657
		fireEvent (16908298, 9, "", "listView", "selectListItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a144
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1687
		fireEvent (2131165201, 58, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a145
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1699
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a146
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1704
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a147
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1705
		fireEvent (1, "New Page", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a148
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1147
		setInput (2131165236, "writeText", "90");
		// Setting input: i1148
		setInput (2131165270, "writeText", "8");
		// Setting input: i1149
		setInput (2131165292, "writeText", "72");
		// Firing event: e1711
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a149
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1171
		setInput (2131165236, "writeText", "90");
		// Setting input: i1172
		setInput (2131165270, "writeText", "8");
		// Setting input: i1173
		setInput (2131165292, "writeText", "72");
		// Firing event: e1722
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "4");

		retrieveWidgets();
		// Testing current activity: should be a150
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1186
		setInput (2131165236, "writeText", "90");
		// Setting input: i1187
		setInput (2131165270, "writeText", "8");
		// Setting input: i1188
		setInput (2131165292, "writeText", "72");
		// Firing event: e1730
		fireEvent (2131165286, 28, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a151
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1219
		setInput (2131165236, "writeText", "90");
		// Setting input: i1220
		setInput (2131165270, "writeText", "8");
		// Setting input: i1221
		setInput (2131165292, "writeText", "72");
		// Firing event: e1744
		fireEvent (2131165289, 32, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a152
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e1759
		fireEvent (16908314, 30, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a153
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1243
		setInput (2131165236, "writeText", "90");
		// Setting input: i1244
		setInput (2131165270, "writeText", "8");
		// Setting input: i1245
		setInput (2131165292, "writeText", "72");
		// Firing event: e1769
		fireEvent (2131165293, 36, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a154
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1775
		fireEvent (2131165200, 61, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a155
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1799
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a156
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1840
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "9");

		retrieveWidgets();
		// Testing current activity: should be a157
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1884
		fireEvent (2131165200, 52, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a158
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1901
		fireEvent (16908298, 9, "", "listView", "selectListItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a159
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1931
		fireEvent (2131165200, 71, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a160
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e1943
		fireEvent (2131165253, 88, "", "linearLayout", "click");

		// This event leads to Katie's Sweet Testing Blog - New Post
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 2174
	public void testTrace00008 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e1954
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a162
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1958
		fireEvent (3, "Remove Blog", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a163
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1966
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a164
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1969
		fireEvent (16908314, 17, "No", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a165
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e1983
		fireEvent (2131165262, 50, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a166
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1272
		setInput (2131165215, "writeText", "27");
		// Setting input: i1273
		setInput (2131165217, "writeText", "29");
		// Firing event: e2002
		fireEvent (2131165373, 26, "Geotag Posts", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a167
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1294
		setInput (2131165215, "writeText", "27");
		// Setting input: i1295
		setInput (2131165217, "writeText", "29");
		// Firing event: e2016
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "8");

		retrieveWidgets();
		// Testing current activity: should be a168
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1326
		setInput (2131165215, "writeText", "27");
		// Setting input: i1327
		setInput (2131165217, "writeText", "29");
		// Firing event: e2035
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "7");

		retrieveWidgets();
		// Testing current activity: should be a169
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1378
		setInput (2131165215, "writeText", "27");
		// Setting input: i1379
		setInput (2131165217, "writeText", "29");
		// Firing event: e2064
		fireEvent (2131165220, 28, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a170
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2071
		fireEvent (2131165204, 16, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a171
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e2108
		fireEvent (16908298, 9, "", "listView", "longClickListItem", "12");

		retrieveWidgets();
		// Testing current activity: should be a172
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e2117
		fireEvent (8, "", "listView", "longClickListItem", "1");

		retrieveWidgets();
		// Testing current activity: should be a173
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Setting input: i1397
		setInput (2131165236, "writeText", "90");
		// Setting input: i1398
		setInput (2131165270, "writeText", "8");
		// Setting input: i1399
		setInput (2131165292, "writeText", "72");
		// Firing event: e2128
		fireEvent (2131165289, 32, "Edit", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a174
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e2139
		fireEvent (16908794, 22, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a175
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e2150
		fireEvent (16908794, 18, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a176
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e2166
		fireEvent (16908796, 20, "", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a177
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e2179
		fireEvent (16908795, 19, "", "focusableEditText", "focus");

		retrieveWidgets();
		// Testing current activity: should be a178
		solo.assertCurrentActivity("", "EditPost");

		// Testing transition 
		// Firing event: e2199
		fireEvent (16908314, 31, "Cancel", "button", "click");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 2205
	public void testTrace00009 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e2203
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a179
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2207
		fireEvent (3, "Remove Blog", "menuItem", "click");

		retrieveWidgets();
		// Testing current activity: should be a180
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2215
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a181
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2217
		fireEvent (16908313, 15, "Yes", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a182
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2228
		fireEvent (2131165255, 31, "", "linearLayout", "click");

		// This event leads to My Blog - New Post
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 2207
	public void testTrace00010 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e2239
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 2209
	public void testTrace00011 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e2241
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 2453
	public void testTrace00012 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e2243
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a186
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2254
		fireEvent (2131165262, 50, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a187
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1411
		setInput (2131165215, "writeText", "27");
		// Setting input: i1412
		setInput (2131165217, "writeText", "29");
		// Firing event: e2264
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "5");

		retrieveWidgets();
		// Testing current activity: should be a188
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1441
		setInput (2131165215, "writeText", "27");
		// Setting input: i1442
		setInput (2131165217, "writeText", "29");
		// Firing event: e2282
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "3");

		retrieveWidgets();
		// Testing current activity: should be a189
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1493
		setInput (2131165215, "writeText", "27");
		// Setting input: i1494
		setInput (2131165217, "writeText", "29");
		// Firing event: e2311
		fireEvent (2131165368, 20, "Upload and link to full image", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a190
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1507
		setInput (2131165215, "writeText", "27");
		// Setting input: i1508
		setInput (2131165217, "writeText", "29");
		// Firing event: e2321
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a191
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Firing event: e2359
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a192
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Firing event: e2379
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a193
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1609
		setInput (2131165215, "writeText", "27");
		// Setting input: i1610
		setInput (2131165217, "writeText", "29");
		// Firing event: e2381
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "2");

		retrieveWidgets();
		// Testing current activity: should be a194
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1651
		setInput (2131165215, "writeText", "27");
		// Setting input: i1652
		setInput (2131165217, "writeText", "29");
		// Firing event: e2405
		fireEvent (2131165367, 18, "", "spinner", "selectSpinnerItem", "6");

		retrieveWidgets();
		// Testing current activity: should be a195
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1701
		setInput (2131165215, "writeText", "27");
		// Setting input: i1702
		setInput (2131165217, "writeText", "29");
		// Firing event: e2433
		fireEvent (2131165373, 26, "Geotag Posts", "check", "click");

		retrieveWidgets();
		// Testing current activity: should be a196
		solo.assertCurrentActivity("", "Settings");

		// Testing transition 
		// Setting input: i1737
		setInput (2131165215, "writeText", "27");
		// Setting input: i1738
		setInput (2131165217, "writeText", "29");
		// Firing event: e2454
		fireEvent (2131165219, 27, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a197
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e2467
		fireEvent (2131165256, 36, "", "linearLayout", "click");

		retrieveWidgets();
		// Testing current activity: should be a198
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e2479
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a199
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e2482
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a200
		solo.assertCurrentActivity("", "Posts");

		// Testing transition 
		// Firing event: e2487
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a201
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
