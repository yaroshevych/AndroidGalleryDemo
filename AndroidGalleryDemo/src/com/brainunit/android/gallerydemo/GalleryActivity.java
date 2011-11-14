package com.brainunit.android.gallerydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GalleryActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);

		GridView gridview = (GridView) findViewById(R.id.gallery);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Intent myIntent = new Intent(v.getContext(), ViewActivity.class);
				startActivityForResult(myIntent, 0);
				overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			}
		});
	}
}