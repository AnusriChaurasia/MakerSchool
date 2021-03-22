import 'package:MakerSchool/components/horizontal_listview.dart';
import 'package:flutter/material.dart';
import 'package:carousel_pro/carousel_pro.dart';
import 'package:MakerSchool/components/products.dart';
//import 'package:MakerSchool/pages/product_details.dart';

void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: HomePage(),
  ));
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    Widget imageCarousel = new Container(
      height: 200.0,
      child: Carousel(
        boxFit: BoxFit.cover,
        images: [
          AssetImage('assets/images/ms1.jpg'),
          AssetImage('assets/images/ms2.png'),
          AssetImage('assets/images/ms3.jpg'),
          AssetImage('assets/images/ms4.jpg'),
          AssetImage('assets/images/ms5.jpg'),
        ],
        autoplay: true,
        animationCurve: Curves.fastOutSlowIn,
        animationDuration: Duration(milliseconds: 1000),
        dotSize: 2.0,
        indicatorBgPadding: 1.0,
        dotColor: Colors.yellowAccent[400],
      ),
    );
    return Scaffold(
      appBar: new AppBar(
        //remove the shadow below nav bar
        elevation: 0.0,
        backgroundColor: Colors.yellowAccent[400],
        title: Text(
          'MakerSchool',
          style: TextStyle(
            color: Colors.black,
          ),
        ),
        actions: <Widget>[
          new IconButton(
              icon: Icon(Icons.search, color: Colors.black), onPressed: () {}),
          new IconButton(
              icon: Icon(Icons.more_vert, color: Colors.black),
              onPressed: () {}),
        ],
      ),
      drawer: new Drawer(
          child: new ListView(
        children: <Widget>[
          //head
          new UserAccountsDrawerHeader(
              accountName: Text('Anusri Chaurasia',
                  style: TextStyle(
                    color: Colors.black,
                  )),
              accountEmail: Text('anusricc8@gmail.com',
                  style: TextStyle(
                    color: Colors.black,
                  )),
              currentAccountPicture: GestureDetector(
                child: new CircleAvatar(
                    backgroundColor: Colors.grey,
                    child: Icon(
                      Icons.person,
                      color: Colors.black,
                    )),
              ),
              decoration: new BoxDecoration(
                color: Colors.yellowAccent[400],
              )),

          //body

          InkWell(
            onTap: () {},
            child: ListTile(
              title: Text('Home Page'),
              leading: Icon(
                Icons.home,
                color: Colors.black,
              ),
            ),
          ),
          InkWell(
            onTap: () {},
            child: ListTile(
              title: Text('Profile'),
              leading: Icon(
                Icons.account_circle,
                color: Colors.black,
              ),
            ),
          ),
          InkWell(
            onTap: () {},
            child: ListTile(
              title: Text('My Projects'),
              leading: Icon(Icons.archive, color: Colors.black),
            ),
          ),
          InkWell(
            onTap: () {},
            child: ListTile(
                title: Text('Create Space'),
                leading: Icon(
                  Icons.card_travel,
                  color: Colors.black,
                )),
          ),

          Divider(),

          InkWell(
            onTap: () {},
            child: ListTile(
              title: Text('Settings'),
              leading: Icon(Icons.settings),
            ),
          ),
          InkWell(
            onTap: () {},
            child: ListTile(
                title: Text('About'),
                leading: Icon(
                  Icons.info,
                  color: Colors.blue,
                )),
          ),
        ],
      )),
      body: new ListView(
        children: <Widget>[
          //image Carousel begins here
          imageCarousel,
          //padding widget
          new Padding(
            padding: const EdgeInsets.all(15.0),
            child: new Text(
              'Categories',
              style: TextStyle(
                fontSize: 20.0,
              )
            ),
          ),
          
          //horizontal list view begins here
          HorizontalList(),

           //padding widget
          new Padding(
            padding: const EdgeInsets.all(15.0),
            child: new Text(
              'Ongoing Projects',
              style: TextStyle(
                fontSize: 20.0,
              )
            ),
          ),

          //grid view
          Container(
            height: 320.0,
            child: Products(),
          ),
        ],
      ),
    );
  }
}
