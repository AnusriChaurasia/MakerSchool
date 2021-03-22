import 'package:flutter/material.dart';
import 'product_details.dart';
class Products extends StatefulWidget{
  @override
  _ProductsState createState() => _ProductsState();
}

class _ProductsState extends State<Products> {
  var productList = [
    {
      "name": "time inversion",
      "picture": "assets/images/c1.jpg",
      "old": 212,
      "new": 56789,
    },
    {
      "name": "night",
      "picture": "assets/images/c2.png",
      "old": 212,
      "new": 56789,
    },
    {
      "name": "time inversion",
      "picture": "assets/images/c3.jpg",
      "old": 212,
      "new": 56789,
    },
    {
      "name": "time inversion",
      "picture": "assets/images/c4.jpg",
      "old": 212,
      "new": 56789,
    },
    {
      "name": "time inversion",
      "picture": "assets/images/c5.png",
      "old": 212,
      "new": 56789,
    }
  ];
  @override
  Widget build(BuildContext context) {
    return GridView.builder(
      itemCount: productList.length,
      gridDelegate:
          new SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 2),
      itemBuilder: (BuildContext context, int index) {
        return SingleProd(
          prodName: productList[index]['name'],
          prodPicture: productList[index]['picture'],
          prodOldPrice: productList[index]['old'],
          prodPrice: productList[index]['new'],
        );
      },
    );
  }
}

class SingleProd extends StatelessWidget {
  final prodName;
  final prodPicture;
  final prodOldPrice;
  final prodPrice;

  SingleProd({
    this.prodName,
    this.prodPicture,
    this.prodOldPrice,
    this.prodPrice,
  });
  @override
  Widget build(BuildContext context) {
    return Card(
      child: Hero(
        tag: prodName,
        child: Material(
          child: InkWell(
            //today
            onTap: () => Navigator.of(context).push(
              new MaterialPageRoute(
                builder: (context) => new ProductDetails()
              )
            ) ,

            child: GridTile(
              footer: Container(
                color: Colors.white,
                child: ListTile(
                  leading: Text(
                    prodName, 
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  //title: Text("\$$prodPrice"),
                ),
              ),
              child: Image.asset(
                prodPicture,
                fit: BoxFit.cover,
              )
            ),
          ),
        ),
      ),
    );
  }
}
