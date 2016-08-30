package com.example.tiyu.activity;

import com.example.tiyu.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		TextView lg = (TextView) findViewById(R.id.login_fm);
		TextView qt = (TextView) findViewById(R.id.quit_fm);

		lg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Login.this, Main.class);
				startActivity(i);
			}
		});

		qt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				System.exit(0);
			}
		});

	}

}
