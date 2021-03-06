package com.bolnizar.itfest.di;

import com.bolnizar.itfest.BaseApp;
import com.bolnizar.itfest.MainActivity;
import com.bolnizar.itfest.activities.EventsActivity;
import com.bolnizar.itfest.activities.HomeActivity;
import com.bolnizar.itfest.activities.LoginActivity;
import com.bolnizar.itfest.api.ApiModule;
import com.bolnizar.itfest.classes.AddClassPresenter;
import com.bolnizar.itfest.classes.ClassesPresenter;
import com.bolnizar.itfest.classes.SubscriptionsPresenter;
import com.bolnizar.itfest.comments.CommentsPresenter;
import com.bolnizar.itfest.data.DebugDataModule;
import com.bolnizar.itfest.di.scopes.ApplicationScope;
import com.bolnizar.itfest.events.AddEventPresenter;
import com.bolnizar.itfest.events.EventsAdapter;
import com.bolnizar.itfest.events.EventsPresenter;
import com.bolnizar.itfest.loginregister.LoginRegisterPresenter;
import com.bolnizar.itfest.modpanel.ModeratorPanelPresenter;
import com.bolnizar.itfest.subscriptionnextevent.NextEventPresenter;
import com.bolnizar.itfest.test.TestPresenter;

import javax.inject.Named;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Rares on 12/09/16.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class, AppPrefsModule.class, DebugDataModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(BaseApp app);

    Retrofit provideRetrofit();

    void inject(MainActivity mainActivity);

    void inject(TestPresenter testPresenter);

    void inject(LoginRegisterPresenter loginRegisterPresenter);

    void inject(HomeActivity homeActivity);

    void inject(ModeratorPanelPresenter moderatorPanelPresenter);

    void inject(ClassesPresenter classesPresenter);

    void inject(SubscriptionsPresenter subscriptionsPresenter);

    void inject(EventsPresenter eventsPresenter);

    void inject(AddClassPresenter addClassPresenter);

    void inject(AddEventPresenter addEventPresenter);

    void inject(EventsActivity eventsActivity);

    void inject(LoginActivity loginActivity);

    void inject(EventsAdapter eventsAdapter);

    void inject(NextEventPresenter nextEventPresenter);

    void inject(CommentsPresenter commentsPresenter);
}