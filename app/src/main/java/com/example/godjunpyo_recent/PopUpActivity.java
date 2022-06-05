package com.example.godjunpyo_recent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

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
        //LinearLayout layout_title = findViewById(R.id.pop_up_title);
        //LinearLayout layout_body  = findViewById(R.id.pop_up_body);

        linearLayout.setBackground(new ColorDrawable(Color.WHITE));
        //layout_title.setBackground(new ColorDrawable(Color.TRANSPARENT));
        //layout_body.setBackground(new ColorDrawable(Color.TRANSPARENT));
    }
}
