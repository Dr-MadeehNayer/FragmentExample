package com.madeeh.fragmentexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class FragmentExampleActivity extends ActionBarActivity implements ToolbarFragment.IToolbarListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);
    }


    @Override
    public void onButtonClick(int position, String text) {
        //position==fontsize

        TextFragment textFragment =(TextFragment) getSupportFragmentManager().findFragmentById(R.id.text_fragment);

        textFragment.changeTextProperties(position, text);
    }


}
