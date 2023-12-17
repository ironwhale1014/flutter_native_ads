package com.example.native_train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
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


        ImageView iconView = nativeAdView.findViewById(R.id.ad_icon);


        NativeAd.Image icon = nativeAd.getIcon();
        if (icon != null) {
            adMark.setVisibility(View.VISIBLE);
            iconView.setImageDrawable(icon.getDrawable());

        } else {
            adMark.setVisibility(View.INVISIBLE);
        }

        TextView headlineView=nativeAdView.findViewById(R.id.headline);
        headlineView.setText(nativeAd.getHeadline());

        TextView bodyView = nativeAdView.findViewById(R.id.list_body);
        bodyView.setText(nativeAd.getBody());

//      이게 멀까???
        nativeAdView.setIconView(iconView);
        nativeAdView.setNativeAd(nativeAd);
        return nativeAdView;
    }
}
