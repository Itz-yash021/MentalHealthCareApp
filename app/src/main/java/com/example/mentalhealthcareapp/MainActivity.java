package com.example.mentalhealthcareapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private int slideCounter = 0;
    private String [] headings = new String[3];
    private String [] contents = new String[3];

    public MainActivity() {
        headings[0] = "Feeling Stressed ?";
        headings[1] = "Healthy body, Healthy mind";
        headings[2] = "Psychotherapy";

        contents[0] = "Everyone feel stressed from time to time and don't know how to deal with it. We have curated many different ways to help you cope up with stress. Find people with whom you can talk, experts to assist you and meditation tricks to ease up your mind";
        contents[1] = "A balance between body and mind is the key of the happy life. Take some moment to meditate or to self evaluate your mental health with the resources curated by us";
        contents[2] = "Psychotherapy is teaching new ways of thinking and behaving. It aims at changing habits that may cause depression. Connect with the experts to clear out your mind and get the right advices.";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View sheetView = findViewById(R.id.standard_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(sheetView);
        int initState = BottomSheetBehavior.STATE_EXPANDED;

        sheetView.post(new Runnable() {
            @Override
            public void run() {
                behavior.setState(initState);
            }
        });

        TextView heading = (TextView) findViewById(R.id.bottomsheet_heading);
        heading.setText(headings[0]);

        TextView content = (TextView) findViewById(R.id.bottomsheet_content);
        content.setText(contents[0]);

        Button button = (Button) findViewById(R.id.bottomsheet_button);
        button.setVisibility(View.INVISIBLE);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_action_button);
        floatingActionButton.setVisibility(View.VISIBLE);

        ImageView imageView = (ImageView) findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideCounter = (slideCounter + 1) % 3;
                heading.setText(headings[slideCounter]);
                content.setText(contents[slideCounter]);

                floatingActionButton.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);

                if (slideCounter == 0) {
                    imageView.setImageResource(R.drawable.picture_0);
                } else if (slideCounter == 1) {
                    imageView.setImageResource(R.drawable.picture_1);
                } else {
                    imageView.setImageResource(R.drawable.picture_2);
                }
            }});

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideCounter = (slideCounter + 1) % 3;
                heading.setText(headings[slideCounter]);
                content.setText(contents[slideCounter]);

                if (slideCounter == 2) {
                    button.setVisibility(View.VISIBLE);
                    floatingActionButton.setVisibility(View.INVISIBLE);
                }

                if (slideCounter == 0) {
                    imageView.setImageResource(R.drawable.picture_0);
                } else if (slideCounter == 1) {
                    imageView.setImageResource(R.drawable.picture_1);
                } else {
                    imageView.setImageResource(R.drawable.picture_2);
                }
            }});
    }
}