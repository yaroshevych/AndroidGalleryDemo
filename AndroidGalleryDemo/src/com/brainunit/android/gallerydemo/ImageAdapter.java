package com.brainunit.android.gallerydemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	int mGalleryItemBackground;
	private Context mContext;

	private Integer[] mImageIds = { R.drawable.image1, R.drawable.image2,
			R.drawable.image3 };

	public ImageAdapter(Context c) {
		mContext = c;
		TypedArray attr = mContext
				.obtainStyledAttributes(R.styleable.GalleryDemo);
		mGalleryItemBackground = attr.getResourceId(
				R.styleable.GalleryDemo_android_galleryItemBackground, 0);
		attr.recycle();
	}

	public int getCount() {
		return mImageIds.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView = new ImageView(mContext);

		imageView.setImageResource(mImageIds[position]);

		if (mContext instanceof ViewActivity) {
			imageView.setLayoutParams(new Gallery.LayoutParams(400, 300));
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		} else {
			imageView.setLayoutParams(new AbsListView.LayoutParams(200, 150));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		}

		imageView.setBackgroundResource(mGalleryItemBackground);

		return imageView;
	}
}
