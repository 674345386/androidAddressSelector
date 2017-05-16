package cp.addressselector.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cp.addressselector.BottomDialog;
import cp.addressselector.OnAddressSelectedListener;
import cp.addressselector.edittext.EditTextWithDel;
import cp.addressselector.model.City;
import cp.addressselector.model.County;
import cp.addressselector.model.Province;
import cp.addressselector.model.Street;
import mlxy.utils.T;

/**
 * Created by CP on 2017/5/11. 13:13.
 */

public class SecondActivity extends AppCompatActivity implements OnAddressSelectedListener {

    TextView tvEchoRegion;
    TextView tv_address_new_region;
    TextView save;
    BottomDialog dialog;
    LinearLayout mConfirm_add_address_btn;
    //
    private EditTextWithDel editName;
    private EditTextWithDel editPhone;
    private EditTextWithDel editDetail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_content);
        findView();
        setListener();
    }

    void findView() {
        dialog = new BottomDialog(SecondActivity.this);
        tvEchoRegion = (TextView) findViewById(R.id.tv_address_new_region);
        tv_address_new_region = (TextView) findViewById(R.id.tv_address_new_region);
//        save = (TextView) findViewById(R.id.save);
        editName = (EditTextWithDel) findViewById(R.id.edit_address_new_name);
        editPhone = (EditTextWithDel) findViewById(R.id.edit_address_new_phone);
        editDetail = (EditTextWithDel) findViewById(R.id.edit_address_new_detail);

        mConfirm_add_address_btn = (LinearLayout) findViewById(R.id.confirm_add_address_btn);

    }

    void setListener() {
        tvEchoRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new BottomDialog(SecondActivity.this);
                dialog.setOnAddressSelectedListener(SecondActivity.this);
                dialog.show();
            }
        });
        //
        mConfirm_add_address_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkWhetherCanBeSaved()) {
                    trySetSaveTextButtonEnable();
                    T.showLong(SecondActivity.this, allDetail);

                } else {
                    T.showLong(SecondActivity.this, "please complete all contents");
                    //save
                }
            }
        });
    }

    private String allDetail;
    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {
        String s =
                (province == null ? "" : province.name) +
                        (city == null ? "" : city.name) +
                        (county == null ? "" : county.name) +
                        (street == null ? "" : street.name);
        T.showShort(this, s);
        allDetail=s;
        tv_address_new_region.setText(s);
        dialog.dismissBottomDialog();
    }

    private boolean checkWhetherCanBeSaved() {
        TextView[] views = {editName, editPhone, editDetail, tvEchoRegion};
        return Tools.isHaveAllContent(views);
    }

    /**
     * 设置保存按钮是否可用
     * 文本发生变化的时候均要调用{TextView echo change and EditText text change}
     */
    private void trySetSaveTextButtonEnable() {
        boolean f = checkWhetherCanBeSaved();
        mConfirm_add_address_btn.setEnabled(f);
    }
}
