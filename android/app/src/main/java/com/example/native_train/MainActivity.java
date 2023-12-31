package com.example.native_train;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin;

public class MainActivity extends FlutterActivity {

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);


        GoogleMobileAdsPlugin.registerNativeAdFactory(flutterEngine, "listTile", new ListTileNativeAdFactory(getLayoutInflater()));
        GoogleMobileAdsPlugin.registerNativeAdFactory(flutterEngine, "mediumTile", new MediumTileNativeAdFactory(getLayoutInflater()));
        GoogleMobileAdsPlugin.registerNativeAdFactory(flutterEngine, "example", new NativeAdFactoryExample(getLayoutInflater()));


    }

    @Override
    public void cleanUpFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.cleanUpFlutterEngine(flutterEngine);
        GoogleMobileAdsPlugin.unregisterNativeAdFactory(flutterEngine, "listTile");
        GoogleMobileAdsPlugin.unregisterNativeAdFactory(flutterEngine, "mediumTile");
        GoogleMobileAdsPlugin.unregisterNativeAdFactory(flutterEngine, "example");
    }
}
