import 'package:flutter/material.dart';
import 'package:google_mobile_ads/google_mobile_ads.dart';
import 'package:logger/logger.dart';
import 'package:native_train/const.dart';

enum NativeAdsMode { banner, medium }

class NativeAds extends StatefulWidget {
  const NativeAds(
      {Key? key,
      required this.factoryId,
      required this.height,
      required this.mode,
      this.color = Colors.greenAccent})
      : super(key: key);

  final Color color;
  final String factoryId;
  final double height;
  final NativeAdsMode mode;

  @override
  State<NativeAds> createState() => _NativeAdsState();
}

class _NativeAdsState extends State<NativeAds> {
  late NativeAd _ad;
  TargetPlatform? os;
  bool isLoaded = false;
  final Logger logger = Logger();

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
      factoryId: widget.factoryId,
      request: const AdRequest(),
      listener: NativeAdListener(onAdLoaded: (ad) {
        setState(() {
          _ad = ad as NativeAd;
          isLoaded = true;
          logger.d("onAdLoaded");
        });
      }, onAdFailedToLoad: (ad, error) {
        ad.dispose();
        logger.d("onAdFailedToLoad");
      }),
    );
    _ad.load();
  }

  @override
  Widget build(BuildContext context) {
    if (isLoaded == true) {
      return (widget.mode == NativeAdsMode.banner)
          ? SizedBox(height: 60, child: AdWidget(ad: _ad))
          : Container(
              color: widget.color,
              constraints: BoxConstraints(
                maxHeight: widget.height,
                maxWidth: double.infinity,
              ),
              child: AdWidget(
                ad: _ad,
              ),
            );
    } else {
      return const SizedBox(height: 0);
    }
  }
}
