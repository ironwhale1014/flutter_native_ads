import 'package:flutter/material.dart';
import 'package:native_train/native_ads.dart';

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Native ads train"),
      ),
      body: SafeArea(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text("ggg"),
          Container(color: Colors.red, height: 60),
          NativeAds(),
          Text("ggg"),
        ],
      )),
    );
  }
}
