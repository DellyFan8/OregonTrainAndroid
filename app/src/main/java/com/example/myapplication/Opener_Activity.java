
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		slide_16_9___1
	 *	@date 		Wednesday 19th of April 2023 01:35:48 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

	public class Opener_Activity extends Activity {
	
	private View _bg__slide_16_9___1_ek2;
	private ImageView oregon_trail_opener_1;
	private TextView text;
	private TextView text_ek1;
	private TextView text_ek2;


	SoundPool sounds;
	int soundID;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.opener_page);

		
		_bg__slide_16_9___1_ek2 = (View) findViewById(R.id._bg__slide_16_9___1_ek2);
		oregon_trail_opener_1 = (ImageView) findViewById(R.id.oregon_trail_opener_1);
		text = (TextView) findViewById(R.id.text);
		text_ek1 = (TextView) findViewById(R.id.text_ek1);
		text_ek2 = (TextView) findViewById(R.id.text_ek2);



		AudioAttributes attributes = new AudioAttributes.Builder()
				.setUsage(AudioAttributes.USAGE_GAME)
				.setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
				.build();
		sounds = new SoundPool.Builder()
				.setMaxStreams(10)
				.setAudioAttributes(attributes)
				.build();
		soundID = sounds.load(this, R.raw.button,1);


		
		//custom code goes here

		text.setOnClickListener(v -> play());
		text_ek2.setOnClickListener(v-> credit());
		text_ek1.setOnClickListener(v-> about());

	}

	public void about(){
		buttonSound();
		openActivity(aboutActivity.class);
	}

	public void play(){
		buttonSound();
		openActivity(Game_Mode_Activity.class);
	}

	public void credit(){
		buttonSound();
		openActivity(creditActivity.class);
	}

	public void buttonSound(){
		sounds.play(soundID, 50, 50, 1, 0,1);
	}

	public void openActivity(Class classToOpen){
		Intent intent = new Intent(this, classToOpen);
		startActivity(intent);
	}

	}
	
	