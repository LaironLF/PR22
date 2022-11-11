package com.example.pr22;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ListFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        LinearLayout cat_1 = (LinearLayout) view.findViewById(R.id.Cat_1);
        LinearLayout cat_2 = (LinearLayout) view.findViewById(R.id.Cat_2);

        cat_1.setOnClickListener(this);
        cat_2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Cat_1: transaction(1, "это Васька, он крутой кот"); break;
            case R.id.Cat_2: transaction(2, "Это Петька, этот кот мне нравится меньше.");break;
        }
    }

    public void transaction(int SomeInt, String str){
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        CatFragment catFragment = CatFragment.newInstance(SomeInt, str);
        ft.replace(R.id.fragments_field, catFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
