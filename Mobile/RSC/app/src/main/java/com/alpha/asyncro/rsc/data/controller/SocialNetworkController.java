package com.alpha.asyncro.rsc.data.controller;

import com.alpha.asyncro.rsc.R;
import com.github.gorbin.asne.core.SocialNetworkManager;
import com.github.gorbin.asne.core.listener.OnLoginCompleteListener;
import com.github.gorbin.asne.core.listener.OnRequestSocialPersonCompleteListener;
import com.github.gorbin.asne.twitter.TwitterSocialNetwork;
import com.lightandroid.navigation.fragment.LightFragment;

/**
 * Created by dmacan on 22.11.2014..
 */
public class SocialNetworkController implements SocialNetworkManager.OnInitializationCompleteListener {

    private LightFragment fragment;
    private SocialNetworkManager manager;
    private TwitterSocialNetwork twitterSocialNetwork;
    private String twitterConsumerKey;
    private String twitterConsumerSecret;

    public SocialNetworkController(LightFragment fragment, String tag) {
        this.fragment = fragment;
        this.manager = (SocialNetworkManager) fragment.getFragmentManager().findFragmentByTag(tag);
        if (manager == null) {
            manager = new SocialNetworkManager();
            twitterSocialNetwork = new TwitterSocialNetwork(fragment, fragment.getLightActivity().getResources().getString(R.string.key_twitter_consumer), fragment.getLightActivity().getResources().getString(R.string.key_twitter_secret), "oauth://ASNE");
            manager.addSocialNetwork(twitterSocialNetwork);
            manager.setOnInitializationCompleteListener(this);
            fragment.getFragmentManager().beginTransaction().add(manager, tag).commit();
        }
    }

    public void twitterLogin(OnLoginCompleteListener onLoginCompleteListener) {
        twitterSocialNetwork.requestLogin(onLoginCompleteListener);
    }

    public void twitterUserDetails(OnRequestSocialPersonCompleteListener onRequestSocialPersonCompleteListener) {
        twitterSocialNetwork.requestCurrentPerson(onRequestSocialPersonCompleteListener);
    }


    @Override
    public void onSocialNetworkManagerInitialized() {

    }
}
