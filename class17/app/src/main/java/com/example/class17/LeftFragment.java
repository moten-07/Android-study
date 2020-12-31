package com.example.class17;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LeftFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeftFragment newInstance(String param1, String param2) {
        LeftFragment fragment = new LeftFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d("leftFragment","onCreate");
        // 2
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // 3
        Log.d("leftFragment","onCreateView");
        View view=inflater.inflate(R.layout.fragment_left,container,false);

        return view;
    }
    //
    @Override
    public void onAttach(@NonNull Context context) {
        // 1
        super.onAttach(context);
        Log.d("leftFragment","onAttach");
    }

    @Override
    public void onStart() {
        // 4
        super.onStart();
        Log.d("leftFragment","onStrart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("leftFragment","onResume");
        // 5
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("leftFragment","onPause");
        // [6]
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("leftFragment","onStop");
        // [7]
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("leftFragment","onDestroy");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("leftFragment","onDestroyView");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("leftFragment","onDetach");
        // [8]
    }
}
