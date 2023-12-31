import 'package:flutter/material.dart';
import 'package:native_train/native_ads.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  UniqueKey myKey1 = UniqueKey();
  UniqueKey myKey2 = UniqueKey();
  UniqueKey myKey3 = UniqueKey();

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: const Text("Native ads train"),
      ),
      body: SafeArea(
          child: SingleChildScrollView(
        child: SizedBox(
          width: size.width,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              NativeAds(
                color: Colors.red,
                key: myKey1,
                factoryId: "listTile",
                height: 60,
                mode: NativeAdsMode.banner,
              ),
              const SizedBox(height: 16),
              NativeAds(
                color: Colors.blue,
                key: myKey2,
                factoryId: "mediumTile",
                height: 200,
                mode: NativeAdsMode.medium,
              ),
              NativeAds(
                color: Colors.brown,
                key: myKey3,
                factoryId: "example",
                height: 310,
                mode: NativeAdsMode.medium,
              ),
              ElevatedButton(
                  onPressed: () {
                    setState(() {});
                    myKey1 = UniqueKey();
                    myKey2 = UniqueKey();
                    myKey3 = UniqueKey();
                  },
                  child: const Text("refresh"))
            ],
          ),
        ),
      )),
    );
  }
}
