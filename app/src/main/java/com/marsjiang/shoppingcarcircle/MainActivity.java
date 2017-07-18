package com.marsjiang.shoppingcarcircle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ShoppingCarLayout shoppingCarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shoppingCarLayout = (ShoppingCarLayout) findViewById(R.id.shoppingCarLayout);
        shoppingCarLayout.setNumber(20);
    }
}
