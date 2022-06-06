package com.example.godjunpyo_recent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class PopUpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Remove Title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Set content view
        setContentView(R.layout.pop_up_activity);

        // Get Intent
        LinearLayout linearLayout = findViewById(R.id.pop_up_usage);
        linearLayout.setBackground(new ColorDrawable(Color.WHITE));
    }
}
