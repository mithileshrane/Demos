package com.example.samrans.mithileshpracticedemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private int valData;

    public BlankFragment() {
        // Required empty public constructor
    }
    int val;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        RelativeLayout frameLayout=view.findViewById(R.id.framBack);
        TextView textView=view.findViewById(R.id.tv_name);

        Bundle bundle=getArguments();
        if (bundle!=null){
            val =bundle.getInt("data");
            valData =bundle.getInt("dataVal");
        }
//        frameLayout.setBackgroundColor(val);
        textView.setText(""+valData);
        frameLayout.setBackgroundColor(val);

        return view;
    }

}
