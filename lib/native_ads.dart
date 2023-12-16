import 'package:flutter/material.dart';
import 'package:google_mobile_ads/google_mobile_ads.dart';
import 'package:native_train/const.dart';

class NativeAds extends StatefulWidget {
  const NativeAds({Key? key}) : super(key: key);

  @override
  State<NativeAds> createState() => _NativeAdsState();
}

class _NativeAdsState extends State<NativeAds> {
  late NativeAd _ad;
  TargetPlatform? os;
  bool isLoaded = false;

  @override
  void didChangeDependencies() {
    // TODO: implement didChangeDependencies
    super.didChangeDependencies();
    os = Theme.of(context).platform;
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
    _ad.dispose();
  }

  @override
  void initState() {
    super.initState();

    _ad = NativeAd(
      adUnitId: NATIVE_ID[os == TargetPlatform.iOS ? 'ios' : 'android']!,
      factoryId: "listTile",
      request: const AdRequest(),
      listener: NativeAdListener(onAdLoaded: (ad) {
        setState(() {
          _ad = ad as NativeAd;
          isLoaded = true;
        });
      }, onAdFailedToLoad: (ad, error) {
        ad.dispose();
      }),
    );
    _ad.load();
  }

  @override
  Widget build(BuildContext context) {
    if (isLoaded == true) {
      return SizedBox(height: 60, child: AdWidget(ad: _ad));
    } else {
      return const SizedBox(height: 0);
    }
  }
}
