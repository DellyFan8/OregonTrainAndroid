
	 
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

import com.example.myapplication.GameMech.GameMechs;
import com.example.myapplication.GameMech.Person;

import java.util.ArrayList;
import java.util.Random;

	public class Game_Mode_Activity extends Activity {

	
	private Button freePlay;
	private Button storyPlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_mode_page);

		freePlay = findViewById(R.id.free_mode_button);
		storyPlay = findViewById(R.id.story_mode_button);

	
		
		//custom code goes here

		freePlay.setOnClickListener(v -> openActivity(name_pick_page_activity.class));
		storyPlay.setOnClickListener(v -> storySet());


	}

	public void openActivity(Class classToOpen){
		Intent intent = new Intent(this, classToOpen);
		startActivity(intent);
	}

	public void storySet(){
		ArrayList<Person> party = new ArrayList<Person>();
		Random random = new Random();

		//Declaring Father Figure
		String names = "Charles";
		int age = random.nextInt(25) + 15;
		party.add(new Person(age, names, 40, Person.Gender.MALE));

		//Declaring Mother
		names = "Augusta";
		age = random.nextInt(25) + 15;
		party.add(new Person(age, names, 40, Person.Gender.FEMALE));

		//declaring Hattie
		names = "Hattie";
		age = 13;
		party.add(new Person(age, names, 40, Person.Gender.FEMALE));

		//Oh brother.
		names = "Ben";
		age = random.nextInt(10)+1;
		party.add(new Person(age, names, 40, Person.Gender.MALE));
		//Oh bother2.
		names = "Jake";
		age = random.nextInt(10)+1;
		party.add(new Person(age, names, 40, Person.Gender.MALE));
		GameMechs gameMechs = new GameMechs();
		gameMechs.setParty(party);
		gameMechs.setMoney(865);
		gameMechs.setDay(0);
		openActivity(Main_Game_Activity.class);
	}
}
	
	