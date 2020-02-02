package com.elmaghraby.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/******************************************************************************
 Copyright (c) 2020, Created By Ahmed Alaa Elmaghraby.                        *
 ******************************************************************************/

public class ProfitActivity extends BaseActivity {
    private TextView individualCTextView;
    private TextView companyCTextView;
    private static int selectedFragment = 0;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit);
        setStatusBarGradiant(this, R.color.md_teal_600);
        forceLocale(this, "en");
        individualCTextView = findViewById(R.id.individual_tv_id);
        companyCTextView = findViewById(R.id.company_tv_id);


        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_fl_id, IndividualFragment.newInstance()).commit();


        individualCTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedFragment != 1) {
                    selectedFragment = 1;
                    individualCTextView.setBackground(getResources().getDrawable(R.color.md_teal_A700));
                    companyCTextView.setBackground(getResources().getDrawable(R.color.md_teal_600));
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_fl_id, IndividualFragment.newInstance()).commit();
                }
            }
        });

        companyCTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedFragment != 2) {
                    selectedFragment = 2;
                    companyCTextView.setBackground(getResources().getDrawable(R.color.md_teal_A700));
                    individualCTextView.setBackground(getResources().getDrawable(R.color.md_teal_600));
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_fl_id, CompanyFragment.newInstance()).commit();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = new Bundle();
        Fragment fragment;
        if (requestCode == 1 && resultCode == RESULT_OK) {
            bundle.putString("VALUE", data.getExtras().getString("RESPONSE"));
            fragment = IndividualFragment.newInstance();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_fl_id, fragment).commitAllowingStateLoss();
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            bundle.putString("VALUE", data.getExtras().getString("RESPONSE"));
            fragment = CompanyFragment.newInstance();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_fl_id, fragment).commitAllowingStateLoss();
        }
    }

}
