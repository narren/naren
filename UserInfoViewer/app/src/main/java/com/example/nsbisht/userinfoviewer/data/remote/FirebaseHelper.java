package com.example.nsbisht.userinfoviewer.data.remote;

import io.reactivex.Single;

/**
 * Created by naren on 2/4/18.
 */

public interface FirebaseHelper {

    Single<UserInfo> getUserInfo(String user);

    Single<Void> createUserInfo(UserInfo userInfo);
}
