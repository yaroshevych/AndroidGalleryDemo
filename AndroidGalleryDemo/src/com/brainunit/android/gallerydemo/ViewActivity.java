package com.brainunit.android.gallerydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

public class ViewActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preview);

		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));

		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(ViewActivity.this, "" + position,
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void onButtonGalleryClick(View view) {
		Intent myIntent = new Intent(view.getContext(), GalleryActivity.class);
		startActivityForResult(myIntent, 0);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	public void onButtonRandomClick(View view) {
		Toast.makeText(ViewActivity.this, "Random", Toast.LENGTH_SHORT).show();
	}
}
