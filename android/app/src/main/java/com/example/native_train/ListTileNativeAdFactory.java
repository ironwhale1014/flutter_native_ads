package com.example.native_train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;


import java.util.Map;

import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin;

class ListTileNativeAdFactory implements GoogleMobileAdsPlugin.NativeAdFactory {

    private final Context context;

    ListTileNativeAdFactory(Context context) {
        this.context = context;
    }


    @Override
    public NativeAdView createNativeAd(NativeAd nativeAd, Map<String, Object> customOptions) {

        NativeAdView nativeAdView = (NativeAdView) LayoutInflater.from(context).inflate(R.layout.list_tile_native_ad, null);


        TextView adMark = nativeAdView.findViewById(R.id.ad_mark);


        NativeAd.Image icon = nativeAd.getIcon();
        if(icon != null){
         adMark.setVisibility(View.VISIBLE);
        }else {
            adMark.setVisibility(View.INVISIBLE);
        }


        nativeAdView.setNativeAd(nativeAd);
        return nativeAdView;
    }
}
