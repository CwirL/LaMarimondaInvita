package com.example.lamarimondainvita;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class eventActivity extends AppCompatActivity {

    private TextView title, locat, dat, val,ret;
    private ImageView thumb;
    private Button btn;
    private boolean btnState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        title = (TextView) findViewById(R.id.txtTitle);
        locat = (TextView) findViewById(R.id.txtLocation);
        dat = (TextView) findViewById(R.id.txtDate);
        val = (TextView) findViewById(R.id.txtValor);
        thumb = (ImageView) findViewById(R.id.eventThumbnail);
        ret = (TextView) findViewById(R.id.txtReto);


        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Location = intent.getExtras().getString("Location");
        String Date = intent.getExtras().getString("Date");
        String Valor = intent.getExtras().getString("Valor");
        int img = intent.getExtras().getInt("Thumbnail");
        String Reto = intent.getExtras().getString("Reto");

        title.setText(Title);
        locat.setText(Location);
        dat.setText(Date);
        val.setText(Valor);
        thumb.setImageResource(img);
        thumb.setAdjustViewBounds(true);
        ret.setText(Reto);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnState = !btnState;
                if (btnState) {
                    v.setBackground(getResources().getDrawable(R.drawable.button2));
                } else {
                    v.setBackground(getResources().getDrawable(R.drawable.button));
                }
            }
        });
    }
}
