package com.example.brown.listviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // private String[] data = {"apple","banana","orange","watermelon","pear","grape","pineapple","strawberry","cherry","mango"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.List_view);
        listView.setAdapter(adapter);
    }

    private void initFruits(){
        Fruit apple = new Fruit("apple",R.drawable.apple_pic);
        fruitList.add(apple);
        Fruit banana = new Fruit("banana",R.drawable.banana_pic);
        fruitList.add(banana);
        Fruit orange = new Fruit("orange",R.drawable.orange_pic);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("watermelon",R.drawable.watermelon_pic);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("pear",R.drawable.pear_pic);
        fruitList.add(pear);
        Fruit grape = new Fruit("pear",R.drawable.pear_pic);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("pineapple",R.drawable.pineapple_pic);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("strawberry",R.drawable.strawberry_pic);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("cherry",R.drawable.cherry_pic);
        fruitList.add(cherry);
        Fruit mango = new Fruit("mango",R.drawable.mango_pic);
        fruitList.add(mango);
    }
}
