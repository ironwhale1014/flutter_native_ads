package com.example.native_train;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.Map;

import io.flutter.plugins.googlemobileads.GoogleMobileAdsPlugin.NativeAdFactory;


class ListTileNativeAdFactory implements NativeAdFactory {

    private final LayoutInflater layoutInflater;

    ListTileNativeAdFactory(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    @Override
    public NativeAdView createNativeAd(NativeAd nativeAd, Map<String, Object> customOptions) {

        final NativeAdView adView = (NativeAdView) layoutInflater.inflate(R.layout.list_tile_native_ad, null);

        adView.setHeadlineView(adView.findViewById(R.id.headline));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());

        adView.setIconView(adView.findViewById(R.id.ad_icon));
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        adView.setBodyView(adView.findViewById(R.id.list_body));
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }


        adView.setNativeAd(nativeAd);

        return adView;
    }
}
