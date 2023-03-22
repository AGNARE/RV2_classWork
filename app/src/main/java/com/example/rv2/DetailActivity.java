package com.example.rv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rv2.recycler.Car;

public class DetailActivity extends AppCompatActivity {

	TextView name;
	ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		initID();
		getInformation();
	}

	private void getInformation() {
		String carName = getIntent().getStringExtra("text");
		name.setText(carName);
		image.setImageResource(getIntent().getIntExtra("image",0));
	}

	private void initID() {
		name=findViewById(R.id.tvName);
		image=findViewById(R.id.imageViewNew);
	}
}
