package org.wordpress.android.test;

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
	public final static int SLEEP_AFTER_EVENT = 1000;
	public final static int SLEEP_AFTER_RESTART = 1000;
	public final static int SLEEP_ON_THROBBER = 1000;
	public final static int SLEEP_AFTER_TASK = 1000;
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

	// Generated from trace 223
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
		// Firing event: e4
		fireEvent (2131165318, 7, "Add self-hosted WordPress blog", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a3
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i9
		setInput (2131165213, "writeText", "25");
		// Setting input: i10
		setInput (2131165215, "writeText", "27");
		// Setting input: i11
		setInput (2131165217, "writeText", "29");
		// Firing event: e11
		fireEvent (2131165222, 17, "Get a free blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a4
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e16
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a5
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e20
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a6
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e22
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a7
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e24
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a8
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e32
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a9
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e40
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a10
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i45
		setInput (2131165213, "writeText", "25");
		// Setting input: i46
		setInput (2131165215, "writeText", "27");
		// Setting input: i47
		setInput (2131165217, "writeText", "29");
		// Firing event: e44
		fireEvent (2131165222, 17, "Get a free blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a11
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e48
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a12
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e55
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a13
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e60
		fireEvent (2131165318, 7, "Add self-hosted WordPress blog", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a14
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i66
		setInput (2131165213, "writeText", "25");
		// Setting input: i67
		setInput (2131165215, "writeText", "27");
		// Setting input: i68
		setInput (2131165217, "writeText", "29");
		// Firing event: e66
		fireEvent (2131165220, 15, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a15
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e72
		fireEvent (2131165317, 6, "Add blog hosted at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a16
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i72
		setInput (2131165215, "writeText", "27");
		// Setting input: i73
		setInput (2131165217, "writeText", "29");
		// Firing event: e77
		fireEvent (2131165219, 14, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a17
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i82
		setInput (2131165215, "writeText", "27");
		// Setting input: i83
		setInput (2131165217, "writeText", "29");
		// Firing event: e85
		fireEvent (2131165222, 19, "Get a free blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a18
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e89
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a19
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e97
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a20
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e101
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a21
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e106
		fireEvent (2131165318, 7, "Add self-hosted WordPress blog", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a22
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e115
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a23
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e123
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a24
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e130
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a25
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i135
		setInput (2131165213, "writeText", "25");
		// Setting input: i136
		setInput (2131165215, "writeText", "27");
		// Setting input: i137
		setInput (2131165217, "writeText", "29");
		// Firing event: e132
		fireEvent (2131165219, 14, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a26
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e140
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a27
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e143
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a28
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e150
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a29
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e155
		fireEvent (2131165318, 7, "Add self-hosted WordPress blog", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a30
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e164
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a31
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e172
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a32
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e178
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a33
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i201
		setInput (2131165213, "writeText", "25");
		// Setting input: i202
		setInput (2131165215, "writeText", "27");
		// Setting input: i203
		setInput (2131165217, "writeText", "29");
		// Firing event: e183
		fireEvent (2131165222, 17, "Get a free blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a34
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e189
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a35
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e191
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a36
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e194
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a37
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e198
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a38
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e200
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a39
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e202
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a40
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e211
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a41
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e216
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a42
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e222
		fireEvent (0, "", "null", "back");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 225
	public void testTrace00001 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e225
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 227
	public void testTrace00002 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e227
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 229
	public void testTrace00003 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e230
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 231
	public void testTrace00004 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e232
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 233
	public void testTrace00005 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e234
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 235
	public void testTrace00006 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e235
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 237
	public void testTrace00007 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e237
		fireEvent (0, "", "null", "openMenu");

		// This event leads to fail
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 239
	public void testTrace00008 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e240
		fireEvent (0, "", "null", "changeOrientation");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 428
	public void testTrace00009 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e242
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a48
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e247
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a49
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e249
		fireEvent (2131165316, 5, "Start a new blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a50
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e257
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a51
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e258
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a52
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e261
		fireEvent (2131165316, 5, "Start a new blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a53
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e269
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a54
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e271
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a55
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e273
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a56
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e280
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a57
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e282
		fireEvent (2131165316, 5, "Start a new blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a58
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e289
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a59
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e291
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a60
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e298
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a61
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e301
		fireEvent (2131165317, 6, "Add blog hosted at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a62
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i228
		setInput (2131165215, "writeText", "27");
		// Setting input: i229
		setInput (2131165217, "writeText", "29");
		// Firing event: e306
		fireEvent (2131165219, 14, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a63
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i236
		setInput (2131165215, "writeText", "27");
		// Setting input: i237
		setInput (2131165217, "writeText", "29");
		// Firing event: e313
		fireEvent (2131165220, 17, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a64
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e319
		fireEvent (2131165317, 6, "Add blog hosted at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a65
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i244
		setInput (2131165215, "writeText", "27");
		// Setting input: i245
		setInput (2131165217, "writeText", "29");
		// Firing event: e326
		fireEvent (2131165222, 17, "Get a free blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a66
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e331
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a67
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e335
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a68
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e337
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a69
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e340
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a70
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e343
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a71
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e346
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a72
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e349
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a73
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e352
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a74
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e355
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a75
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e357
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a76
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i246
		setInput (2131165215, "writeText", "27");
		// Setting input: i247
		setInput (2131165217, "writeText", "29");
		// Firing event: e360
		fireEvent (2131165219, 14, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a77
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i254
		setInput (2131165215, "writeText", "27");
		// Setting input: i255
		setInput (2131165217, "writeText", "29");
		// Firing event: e367
		fireEvent (2131165220, 17, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a78
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e376
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a79
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e378
		fireEvent (2131165316, 5, "Start a new blog at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a80
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e386
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a81
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e388
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a82
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e392
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a83
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e394
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a84
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e398
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a85
		solo.assertCurrentActivity("", "Signup");

		// Testing transition 
		// Firing event: e399
		fireEvent (0, "", "null", "back");

		retrieveWidgets();
		// Testing current activity: should be a86
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e407
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a87
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e409
		fireEvent (2131165317, 6, "Add blog hosted at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a88
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Firing event: e419
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a89
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i266
		setInput (2131165215, "writeText", "27");
		// Setting input: i267
		setInput (2131165217, "writeText", "29");
		// Firing event: e421
		fireEvent (2131165220, 15, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a90
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e429
		fireEvent (0, "", "null", "back");

		// This event leads to WordPress
		solo.sleep (SLEEP_AFTER_TASK);
	}

	// Generated from trace 485
	public void testTrace00010 () {

		// Testing base activity
		// This event leads to WordPress
		// Testing transition 
		// Firing event: e435
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a92
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e441
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a93
		solo.assertCurrentActivity("", "Dashboard");

		// Testing transition 
		// Firing event: e444
		fireEvent (2131165317, 6, "Add blog hosted at WordPress.com", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a94
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i270
		setInput (2131165215, "writeText", "27");
		// Setting input: i271
		setInput (2131165217, "writeText", "29");
		// Firing event: e449
		fireEvent (2131165219, 14, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a95
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i276
		setInput (2131165215, "writeText", "27");
		// Setting input: i277
		setInput (2131165217, "writeText", "29");
		// Firing event: e455
		fireEvent (2131165219, 16, "Save", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a96
		solo.assertCurrentActivity("", "AddAccount");

		// Testing transition 
		// Setting input: i284
		setInput (2131165215, "writeText", "27");
		// Setting input: i285
		setInput (2131165217, "writeText", "29");
		// Firing event: e462
		fireEvent (2131165220, 17, "Cancel", "button", "click");

		retrieveWidgets();
		// Testing current activity: should be a97
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e471
		fireEvent (0, "", "null", "openMenu");

		retrieveWidgets();
		// Testing current activity: should be a98
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e478
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a99
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e484
		fireEvent (0, "", "null", "changeOrientation");

		retrieveWidgets();
		// Testing current activity: should be a100
		solo.assertCurrentActivity("", "NewAccount");

		// Testing transition 
		// Firing event: e488
		fireEvent (0, "", "null", "back");

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

