package com.bolnizar.itfest.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bolnizar.itfest.R;
import com.bolnizar.itfest.data.BooleanPreference;
import com.bolnizar.itfest.di.InjectionHelper;
import com.bolnizar.itfest.utils.Constants;

import javax.inject.Inject;
import javax.inject.Named;

import timber.log.Timber;

public class HomeActivity extends AppCompatActivity {

    @Inject
    @Named(Constants.PREF_USER_MODERATOR)
    BooleanPreference mUserModerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectionHelper.getApplicationComponent(this).inject(this);
        Timber.d("User is moderator ? " + mUserModerator.get());
        setContentView(R.layout.activity_home);
        setTitle(R.string.app_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (mUserModerator.get()) {
            getMenuInflater().inflate(R.menu.home_moderator, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_start_moderator_panel) {
            startActivity(new Intent(this, ModeratorPanelActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}