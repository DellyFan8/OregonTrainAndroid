
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		slide_16_9___2
	 *	@date 		Sunday 30th of April 2023 05:50:19 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game_Mode_Activity extends Activity {

	
	private Button freePlay;
	private Button storyPlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_mode_page);

		freePlay = findViewById(R.id.free_mode_button);

	
		
		//custom code goes here

		freePlay.setOnClickListener(v -> openActivity(name_pick_page_activity.class));
	
	}

	public void openActivity(Class classToOpen){
		Intent intent = new Intent(this, classToOpen);
		startActivity(intent);
	}
}
	
	