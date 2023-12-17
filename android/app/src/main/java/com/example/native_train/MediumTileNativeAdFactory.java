package com.example.native_train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.Map;

import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin;

class MediumTileNativeAdFactory implements GoogleMobileAdsPlugin.NativeAdFactory {
    private final Context context;

    MediumTileNativeAdFactory(Context context) {
        this.context = context;
    }

    @Override
    public NativeAdView createNativeAd(NativeAd nativeAd, Map<String, Object> customOptions) {

        NativeAdView nativeAdView = (NativeAdView) LayoutInflater.from(context).inflate(R.layout.medium_tile_native_ad, null);

        TextView adMark = nativeAdView.findViewById(R.id.ad_mark);
        adMark.setVisibility(View.VISIBLE);


        ImageView imageView = nativeAdView.findViewById(R.id.native_ad_Image);
        NativeAd.Image image = nativeAd.getImages().get(0);
        Glide.with(context).load(image.getUri()).into(imageView);


        nativeAdView.setNativeAd(nativeAd);


        return nativeAdView;
    }
}
