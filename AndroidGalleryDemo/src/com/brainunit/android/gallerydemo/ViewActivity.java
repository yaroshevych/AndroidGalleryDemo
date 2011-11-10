package com.brainunit.android.gallerydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Toast;

public class ViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));

        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(ViewActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        }
    
    public void onButtonGalleryClick(View view){
    	Toast.makeText(ViewActivity.this, "Gallery", Toast.LENGTH_SHORT).show();
    }
    
    public void onButtonRandomClick(View view){
    	Toast.makeText(ViewActivity.this, "Random", Toast.LENGTH_SHORT).show();
    }
}
