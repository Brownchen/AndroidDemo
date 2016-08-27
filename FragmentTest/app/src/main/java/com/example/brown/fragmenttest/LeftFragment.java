package com.example.brown.fragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by brown on 2016/8/27.
 */
public class LeftFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       View view = inflater.inflate(R.layout.left_fragment,container,false);
        return view;
    }
}
