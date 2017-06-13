package com.tim11.pma.ftn.pmaprojekat;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.tim11.pma.ftn.pmaprojekat.model.FBUser;
import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.service.UserService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@EActivity
public class WelcomeActivity extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;

    @Bean
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        try {
            getSupportActionBar().hide();
        }catch (Exception e){

        }
        generateKey();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile", "user_friends");

        callbackManager = CallbackManager.Factory.create();

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                System.out.println(">>>>>SUCCESS!");
                saveUserIfNotExists();
                storeProfilePictureLocally();
                goToMain();
                //Profile.getCurrentProfile().geti
            }

            @Override
            public void onCancel() {
                // App code
                System.out.println(">>>>>CANCEL!");
                Toast.makeText(getApplicationContext(), "Login canceled.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                System.out.println(">>>>>ERROR!");
                Toast.makeText(getApplicationContext(), "An error occurred.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Background
    public void saveUserIfNotExists() {
        final Profile fbProfile = Profile.getCurrentProfile();
        // TODO: We should first check local database if there is user for this FB profile
        // Then get user with that id and put it in SharedPreferences or whatever
        User relatedUser = null;
        if (fbProfile != null &&
                (relatedUser = userService.getUserByFbProfileId(fbProfile.getId())) == null) {
            final FBUser fbUser = new FBUser();
            fbUser.setFirstname(fbProfile.getFirstName());
            fbUser.setLastname(fbProfile.getLastName());
            fbUser.setFbProfileId(fbProfile.getId());
            fbUser.setMiddlename(fbProfile.getMiddleName());
            fbUser.setProfilePictureUri(fbProfile.getProfilePictureUri(200, 200).toString());
            fbUser.setProfileUri(fbProfile.getLinkUri().toString());

            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject user, GraphResponse graphResponse) {
                    User newUser = new User();
                    newUser.setFbUser(fbUser);
                    newUser.setFirstname(fbProfile.getFirstName());
                    newUser.setLastname(fbProfile.getLastName());
                    newUser.setEmail(user.optString("email"));
                    User resultUser = null;
                    AsyncTask<User, Object, User> createUserTask = new AsyncTask<User, Object, User>() {
                        @Override
                        protected User doInBackground(User[] params) {
                            return userService.create(params[0]);
                        }
                    }.execute(newUser);
                    try {
                        resultUser = createUserTask.get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    PreferenceManager
                            .getDefaultSharedPreferences(getApplicationContext())
                            .edit()
                            .putString("loggedUser", new Gson().toJson(resultUser))
                            .apply();

                }
            });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,email");
            request.setParameters(parameters);
            request.executeAsync();
        } else {
            PreferenceManager
                    .getDefaultSharedPreferences(getApplicationContext())
                    .edit()
                    .putString("loggedUser",new Gson().toJson(relatedUser))
                    .apply();
        }
    }

    @Background
    public void storeProfilePictureLocally() {
        try {
            Bitmap bitmapImage = BitmapFactory
                    .decodeStream(new URL(Profile.getCurrentProfile().getProfilePictureUri(200, 200).toString())
                            .openConnection().getInputStream());
            ContextWrapper cw = new ContextWrapper(getApplicationContext());

            File directory = cw.getDir("images", Context.MODE_PRIVATE);

            File mypath = new File(directory,"profile.jpg");

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(mypath);
                // Use the compress method on the BitMap object to write image to the OutputStream
                bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load profile picture from Facebook!");
            e.printStackTrace();
        }
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    public void generateKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.tim11.pma.ftn.pmaprojekat",
                    PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                System.out.println("KeyHash:" + Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }

}
