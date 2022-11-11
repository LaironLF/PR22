package com.example.pr22;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CatFragment extends Fragment {

    private TextView TV_number;
    private TextView TV_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.cat_info_fragment, container, false);
        TV_number = (TextView) view.findViewById(R.id.catInt);
        TV_text = (TextView) view.findViewById(R.id.textokote);

        int integer = getArguments().getInt("someInt", 0);
        String str = getArguments().getString("SomeString", "");

        TV_number.setText(Integer.toString(integer));
        TV_text.setText(str);

        return view;
    }

    public static CatFragment newInstance(int someInt, String someString) {
        CatFragment catFragment = new CatFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("SomeString", someString);
        catFragment.setArguments(args);
        return catFragment;
    }
}