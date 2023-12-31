package com.example.native_train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.Map;

import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin;
import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin.NativeAdFactory;

class MediumTileNativeAdFactory implements NativeAdFactory {
    private final LayoutInflater layoutInflater;
//    private final Context context;

    MediumTileNativeAdFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }


    @Override
    public NativeAdView createNativeAd(NativeAd nativeAd, Map<String, Object> customOptions) {

        NativeAdView nativeAdView = (NativeAdView) layoutInflater.inflate(R.layout.medium_tile_native_ad, null);

        nativeAdView.setMediaView(nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        nativeAdView.setNativeAd(nativeAd);


        return nativeAdView;
    }
}
