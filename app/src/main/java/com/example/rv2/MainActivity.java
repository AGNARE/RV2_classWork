package com.example.rv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rv2.databinding.ActivityMainBinding;
import com.example.rv2.recycler.Car;
import com.example.rv2.recycler.CarClick;
import com.example.rv2.recycler.CarsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CarClick {

	ArrayList<Car> arrayList;
	RecyclerView recyclerView;
	CarsAdapter adapter;
	ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		fillList();
		conected();
	}

	private void conected() {
		adapter = new CarsAdapter(arrayList, this);
		recyclerView.setAdapter(adapter);
	}

	private void fillList () {
		arrayList = new ArrayList<>();
		arrayList.add(new Car("LEXUS", "JAPAN CAR-LEXUS", R.drawable.lexus));
		arrayList.add(new Car("TOYOTA", "JAPAN CAR-TOYOTA", R.drawable.toyota));
		arrayList.add(new Car("BMW", "GERMANY CAR", R.drawable.bmw));
		arrayList.add(new Car("HONDA", "JAPAN CAR-HONDA", R.drawable.honda));
	}

	@Override
	public void onClick(Car car) {
		Intent intent = new Intent(MainActivity.this, DetailActivity.class);
		intent.putExtra("text", car.getName());
		intent.putExtra("image", car.getImage());
		startActivity(intent);
	}
}
