import 'package:flutter/material.dart';
//import 'package:carousel_pro/carousel_pro.dart';

class HorizontalList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 100.0,
      child: ListView(
        scrollDirection: Axis.horizontal,
        children: <Widget>[
          Category(
            imageLocation: 'assets/images/c1.jpg',
            imageCaption: 'Idea',
          ),
          Category(
            imageLocation: 'assets/images/c2.png',
            imageCaption: 'Research',
          ),
          Category(
            imageLocation: 'assets/images/c3.jpg',
            imageCaption: 'Implement',
          ),
          Category(
            imageLocation: 'assets/images/c4.jpg',
            imageCaption: 'Space',
          ),
          Category(
            imageLocation: 'assets/images/c5.png',
            imageCaption: 'Publish',
          ),
        ],
      ),
    );
  }
}

class Category extends StatelessWidget {
  final String imageLocation;
  final String imageCaption;

  Category({this.imageLocation, this.imageCaption});
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(5.0),
      child: InkWell(
        onTap: (){},
        child: Container(
          width: 120.0,
          child: ListTile(
            title: Image.asset(imageLocation),
            subtitle: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text(
                imageCaption,
                textAlign: TextAlign.center,
              ),
            ),
          ),
        ),
      ),
    );
  }
}
