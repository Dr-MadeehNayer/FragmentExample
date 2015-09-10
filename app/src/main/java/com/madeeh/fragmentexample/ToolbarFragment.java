package com.madeeh.fragmentexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ToolbarFragment extends Fragment {

    private static int seekvalue = 10;
    private static EditText edittext;

    IToolbarListener activityCallback;

    public interface IToolbarListener {
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (IToolbarListener) activity;
        } catch (Exception e) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.toolbar_fragment,container, false);

        edittext = (EditText) view.findViewById(R.id.editText1);
        final SeekBar seekbar =(SeekBar) view.findViewById(R.id.seekBar1);
        final Button button =(Button) view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                seekvalue=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        return view;
    }

    public void buttonClicked (View view) {
        activityCallback.onButtonClick(seekvalue,edittext.getText().toString());
    }


}
