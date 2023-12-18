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
    private final LayoutInflater layoutInflater;
    private final Context context;

    MediumTileNativeAdFactory(LayoutInflater layoutInflater, Context context) {
        this.layoutInflater = layoutInflater;
        this.context = context;
    }


    @Override
    public NativeAdView createNativeAd(NativeAd nativeAd, Map<String, Object> customOptions) {

        NativeAdView nativeAdView = (NativeAdView) layoutInflater.inflate(R.layout.medium_tile_native_ad, null);

        ImageView imageView = nativeAdView.findViewById(R.id.native_ad_Image);
        NativeAd.Image image = nativeAd.getImages().get(0);
        Glide.with(context).load(image.getUri()).into(imageView);

        ImageView iconView = nativeAdView.findViewById(R.id.ad_icon);
        nativeAdView.setIconView(iconView);
        NativeAd.Image icon = nativeAd.getIcon();
        if (icon == null) {
            nativeAdView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(View.VISIBLE);
        }


        TextView headlineView = nativeAdView.findViewById(R.id.headline);
        headlineView.setText(nativeAd.getHeadline());

        TextView bodyView = nativeAdView.findViewById(R.id.list_body);
        bodyView.setText(nativeAd.getBody());


        nativeAdView.setIconView(iconView);
        nativeAdView.setNativeAd(nativeAd);


        return nativeAdView;
    }
}
