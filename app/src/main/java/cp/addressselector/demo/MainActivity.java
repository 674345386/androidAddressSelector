package cp.addressselector.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import cp.addressselector.AddressSelector;
import cp.addressselector.BottomDialog;
import cp.addressselector.OnAddressSelectedListener;
import cp.addressselector.model.City;
import cp.addressselector.model.County;
import cp.addressselector.model.Province;
import cp.addressselector.model.Street;
import mlxy.utils.T;

public class MainActivity extends AppCompatActivity implements OnAddressSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        AddressSelector selector = new AddressSelector(this);
        selector.setOnAddressSelectedListener(this);
//        selector.setAddressProvider(new TestAddressProvider());

        assert frameLayout != null;
        frameLayout.addView(selector.getView());

        Button buttonBottomDialog = (Button) findViewById(R.id.buttonBottomDialog);
        Button jumpBtn = (Button) findViewById(R.id.jumpBtn);
        assert buttonBottomDialog != null;
        buttonBottomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                BottomDialog.show(MainActivity.this, MainActivity.this);
                BottomDialog dialog = new BottomDialog(MainActivity.this);
                dialog.setOnAddressSelectedListener(MainActivity.this);
                dialog.show();
            }
        });

        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {
        String s =
                (province == null ? "" : province.name) +
                (city == null ? "" : "\n" + city.name) +
                (county == null ? "" : "\n" + county.name) +
                (street == null ? "" : "\n" + street.name);
        T.showShort(this, s);
    }
}
