import 'package:flutter/material.dart';
import 'package:native_train/native_ads.dart';

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: const Text("Native ads train"),
      ),
      body: const SafeArea(
          child: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            NativeAds(
              factoryId: "listTile",
              height: 60,
              mode: NativeAdsMode.banner,
            ),
            SizedBox(height: 30),
            NativeAds(
              factoryId: "mediumTile",
              height: 400,
              mode: NativeAdsMode.medium,
            ),
            Text("ggg"),
          ],
        ),
      )),
    );
  }
}
