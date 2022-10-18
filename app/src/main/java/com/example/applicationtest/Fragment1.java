package com.example.applicationtest;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.applicationtest.other.TwoActivity;


public class Fragment1 extends Fragment {
    private TextView text1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab01, container, false);


    }



    @Override
    public void onStart() {
        super.onStart();
        Button button01 = (Button) getActivity().findViewById(R.id.button_tab01);
        Button button02 = (Button) getActivity().findViewById(R.id.button_tab02);
        text1=(TextView) getActivity().findViewById(R.id.textView_tab01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ss", "1->2ok");
                Intent intent = new Intent(getActivity(), TwoActivity.class);
                startActivity(intent);
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ss", "1->3ok");
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("msg","hello");
                startActivity(intent);
                test.launch(intent);
            }
        });
    }
    public ActivityResultLauncher<Intent> test= registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result ) {
                    text1.setText("1");
                    if(result.getResultCode()==2){
                        text1.setText(result.getData().getStringExtra("msg"));
                    }
                }
            }
    );


}