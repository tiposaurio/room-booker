package com.tim11.pma.ftn.pmaprojekat;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBar;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.tim11.pma.ftn.pmaprojekat.model.Address;
import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.service.UserService;
import com.tim11.pma.ftn.pmaprojekat.service.UserService_;
import com.tim11.pma.ftn.pmaprojekat.util.PreferenceUtil;

import java.util.List;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsViewActivity extends AppCompatPreferenceActivity {

    /**
     * A preference value change listener that updates the preference's summary
     * to reflect its new value.
     */
    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();

            if (preference instanceof ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                // Set the summary to reflect the new value.
                preference.setSummary(
                        index >= 0
                                ? listPreference.getEntries()[index]
                                : null);

            } else if (preference instanceof RingtonePreference) {
                // For ringtone preferences, look up the correct display value
                // using RingtoneManager.
                if (TextUtils.isEmpty(stringValue)) {
                    // Empty values correspond to 'silent' (no ringtone).
                    preference.setSummary(R.string.pref_ringtone_silent);

                } else {
                    Ringtone ringtone = RingtoneManager.getRingtone(
                            preference.getContext(), Uri.parse(stringValue));

                    if (ringtone == null) {
                        // Clear the summary if there was a lookup error.
                        preference.setSummary(null);
                    } else {
                        // Set the summary to reflect the new ringtone display
                        // name.
                        String name = ringtone.getTitle(preference.getContext());
                        preference.setSummary(name);
                    }
                }

            } else {
                // For all other preferences, set the summary to the value's
                // simple string representation.
                SharedPreferences sharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext().getApplicationContext());
                String loggedUserString = sharedPreferences.getString("loggedUser", null);
                Gson gson = new Gson();
                User loggedUser = (loggedUserString!=null)
                        ? gson.fromJson(loggedUserString, User.class) : null;
                switch (preference.getKey()) {
                    case PersonalInformationPreferenceFragment.FIRST_NAME_PREFERENCE: {
                        //TODO save to local user
                        if (loggedUser != null) {
                            loggedUser.setFirstname(stringValue);
                            sharedPreferences.edit()
                                    .putString("loggedUser", gson.toJson(loggedUser)).apply();
                        }
                        break;
                    }
                    case PersonalInformationPreferenceFragment.LAST_NAME_PREFERENCE: {
                        //TODO save to local user
                        if (loggedUser != null) {
                            loggedUser.setLastname(stringValue);
                            sharedPreferences.edit()
                                    .putString("loggedUser", gson.toJson(loggedUser)).apply();
                        }
                    }
                    // TODO look what to do for the address
                }
                preference.setSummary(stringValue);
            }
            return true;
        }
    };

    /**
     * Helper method to determine if the device has an extra-large screen. For
     * example, 10" tablets are extra-large.
     */
    private static boolean isXLargeTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

    /**
     * Binds a preference's summary to its value. More specifically, when the
     * preference's value is changed, its summary (line of text below the
     * preference title) is updated to reflect the value. The summary is also
     * immediately updated upon calling this method. The exact display format is
     * dependent on the type of preference.
     *
     * @see #sBindPreferenceSummaryToValueListener
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        bindPreferenceSummaryToValue(preference, null);
    }

    private static void bindPreferenceSummaryToValue(Preference preference, String bindNewValue) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's
        // current value or new value if defined.
        if (bindNewValue == null) {
            sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                    PreferenceManager
                            .getDefaultSharedPreferences(preference.getContext())
                            .getString(preference.getKey(), ""));
        } else {
            sBindPreferenceSummaryToValueListener.onPreferenceChange(preference, bindNewValue);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onIsMultiPane() {
        return isXLargeTablet(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_headers, target);
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    protected boolean isValidFragment(String fragmentName) {
        return PreferenceFragment.class.getName().equals(fragmentName)
                || GeneralPreferenceFragment.class.getName().equals(fragmentName)
                || DataSyncPreferenceFragment.class.getName().equals(fragmentName)
                || PersonalInformationPreferenceFragment.class.getName().equals(fragmentName)
                || NotificationPreferenceFragment.class.getName().equals(fragmentName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This fragment shows general preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class GeneralPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            bindPreferenceSummaryToValue(findPreference("example_text"));
            bindPreferenceSummaryToValue(findPreference("example_list"));

            Preference prefTheme = findPreference("sw_theme");
            prefTheme.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object o) {
                    Log.i("PREF",preference.toString());
                    return true;
                }
            });
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsViewActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This fragment shows notification preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class NotificationPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_notification);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsViewActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This fragment shows data and sync preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class DataSyncPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_data_sync);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            bindPreferenceSummaryToValue(findPreference("sync_frequency"));
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsViewActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class PersonalInformationPreferenceFragment extends PreferenceFragment {

        public static final String FIRST_NAME_PREFERENCE = "first_name";
        public static final String LAST_NAME_PREFERENCE = "last_name";
        public static final String ADDRESS_PREFERENCE = "address";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_personal_information);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            setLoggedUserInfo();
            User loggedUser = PreferenceUtil.getLoggedUser(getActivity().getApplicationContext());
            String firstName = "";
            String lastName = "";
            String address = "";
            if (loggedUser != null) {
                firstName = loggedUser.getFirstname();
                lastName = loggedUser.getLastname();
                Address userAddress = loggedUser.getAddress();
                if (userAddress != null) {
                    address = userAddress.toString();
                }
            }
            bindPreferenceSummaryToValue(
                    findPreference(PersonalInformationPreferenceFragment.FIRST_NAME_PREFERENCE), firstName);
            bindPreferenceSummaryToValue(
                    findPreference(PersonalInformationPreferenceFragment.LAST_NAME_PREFERENCE), lastName);
            bindPreferenceSummaryToValue(
                    findPreference(PersonalInformationPreferenceFragment.ADDRESS_PREFERENCE), address);
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            final UserService userService = UserService_.getInstance_(getActivity());
            User loggedUser =
                    new Gson().fromJson(PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext())
                            .getString("loggedUser", null), User.class);
            if (loggedUser == null)
                return;
            AsyncTask<User, Object, User> createUserTask = new AsyncTask<User, Object, User>() {
                @Override
                protected User doInBackground(User[] params) {
                    return userService.create(params[0]);
                }
            }.execute(loggedUser);
        }

        private void setLoggedUserInfo() {
            User loggedUser =
                    new Gson().fromJson(PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext())
                            .getString("loggedUser", null), User.class);
            if (loggedUser == null)
                return;
            Preference firstNamePreference = findPreference(PersonalInformationPreferenceFragment.FIRST_NAME_PREFERENCE);
            firstNamePreference.setSummary(loggedUser.getFirstname());
            Preference lastNamePreference = findPreference(PersonalInformationPreferenceFragment.LAST_NAME_PREFERENCE);
            lastNamePreference.setSummary(loggedUser.getLastname());
            Preference addressPreference = findPreference(PersonalInformationPreferenceFragment.ADDRESS_PREFERENCE);
            Address loggedUsersAddress = loggedUser.getAddress();
            addressPreference.setSummary((loggedUsersAddress==null)?"No address":loggedUsersAddress.toString());
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                startActivity(new Intent(getActivity(), SettingsViewActivity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }
}
