
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc
	 *	@file 		slide_16_9___2
	 *	@date 		Friday 21st of April 2023 04:09:34 AM
	 *	@title 		Page 1
	 *	@author
	 *	@keywords
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */


package com.example.myapplication;

	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc
	 *	@file 		slide_16_9___2
	 *	@date 		Thursday 04th of May 2023 08:00:56 PM
	 *	@title 		Page 1
	 *	@author
	 *	@keywords
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */

	import android.app.Activity;
	import android.content.Intent;
	import android.os.Bundle;


	import android.view.View;
	import android.widget.Button;
	import android.widget.TextView;

	import com.example.myapplication.GameMech.Event;
	import com.example.myapplication.GameMech.GameMechs;
	import com.example.myapplication.GameMech.Inventory;
	import com.example.myapplication.GameMech.Location;
	import com.example.myapplication.GameMech.Map;
	import com.example.myapplication.GameMech.Person;

	import java.util.ArrayList;

	public class Main_Game_Activity extends Activity {

		static Inventory inventory;
		static ArrayList<Person> party;
		static Map oregonTrail;
		static int day;

		private TextView date_message;
		private TextView weather_message;
		private TextView city_message;
		private TextView distance_message;
		private Button advance_button;
		private Button menu_button;

		private Button acc_button;

		private TextView notis;
		ArrayList<Location> runnerLocations;
		GameMechs gameMechs = new GameMechs();

		@Override
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.main_game_page);

			date_message = (TextView) findViewById(R.id.date_message);
			weather_message = (TextView) findViewById(R.id.weather_message);
			city_message = (TextView) findViewById(R.id.city_message);
			distance_message = (TextView) findViewById(R.id.distance_message);
			advance_button = findViewById(R.id.advance_button);
			menu_button = findViewById(R.id.menu_button);
			acc_button = findViewById(R.id.accessory_button);

			notis = findViewById(R.id.notifs);
			//Import Settings from windows before this one
			GameMechs gameMechs = new GameMechs();
			//custom code goes here
			inventory = gameMechs.getInventory();
			day = gameMechs.getDay();
			oregonTrail = gameMechs.getMap();

			advance_button.setOnClickListener(v->nextDay());
			menu_button.setOnClickListener(v->openActivity(menuActivity.class));


			date_message.setText(oregonTrail.datedisplay());
			if(inventory.personcount()==0){
				notis.setText("Everyone is dead\nYou lose!");
				advance_button.setVisibility(View.GONE);
				accButtonSet();
			}

			if(oregonTrail.closestloc().hasEvent()&&oregonTrail.distanceto(oregonTrail.closestloc())==0){
				if(oregonTrail.closestloc().getEvent().eventType== Event.EventType.END){
					notis.setText("You Made It!!!\n The End");
					advance_button.setVisibility(View.GONE);
				}
				accButtonSet();

			}
			else if(oregonTrail.closestloc().hasStore()&&oregonTrail.distanceto(oregonTrail.closestloc())==0){
				accButtonSet(1);
			}
			else{
				accButtonSet(3);
			}

			if(!gameMechs.getHaveStareted()){
				notis.setText("You should go shopping first to buy supplies");
			}

			setBars();
			playGame();

		}


		public void openActivity(Class classToOpen){
			Intent intent = new Intent(this, classToOpen);
			startActivity(intent);
		}

		private void playGame(){

			//oregonTrail.addnoti("Today we left "+oregonTrail.closestloc().getLocationName()+".");
			//oregonTrail.addnoti("We bought "+inventory.getNumItems()+" items while there.");
			//endregion

			// Play game
			//
			 //oregonTrail.setRainandTemp();

		}

		private void nextDay() {
			gameMechs.setHaveStareted(true);
			notis.setText(oregonTrail.dayDisplay(oregonTrail.advanceDay()));

			setBars();

			if(inventory.personcount()==0){
				notis.setText("Everyone is dead\nYou lose!");
				advance_button.setVisibility(View.GONE);
				accButtonSet();
			}
			accButtonSet();
			if(oregonTrail.closestloc().hasEvent()&&oregonTrail.distanceto(oregonTrail.closestloc())==0){
				if(oregonTrail.closestloc().getEvent().eventType== Event.EventType.END){
					notis.setText("You Made It To OREGON!!!\n The End");
					advance_button.setVisibility(View.GONE);
					accButtonSet();
				}
				accButtonSet();
			}
			else if(oregonTrail.closestloc().hasStore()&&oregonTrail.distanceto(oregonTrail.closestloc())==0){
				accButtonSet(1);
			}
			else{
				accButtonSet(3);
			}
		}

		//mode- 1=Store, 2=River, 3=Hunt
		private void accButtonSet(int mode){
				acc_button.setVisibility(View.VISIBLE);
				if(mode == 3){
					acc_button.setOnClickListener(v->hunt());
					acc_button.setText("Hunt");
				}
				if(mode == 2){
					acc_button.setOnClickListener(v->river());
					acc_button.setText("Cross");
				}
				if(mode == 1){
					acc_button.setOnClickListener(v->shop());
					acc_button.setText("Shop");
				}
			}
		private void accButtonSet(){
				acc_button.setVisibility(View.GONE);
				acc_button.setOnClickListener(null);
			}

		private void shop() {
			gameMechs.setHaveStareted(true);
			gameMechs.setStore(oregonTrail.closestloc().getStore());
			openActivity(Store_Activity.class);
		}

		private void river() {
		}

		private void hunt() {
			oregonTrail.hunt();

		}


		private void setBars(){

			date_message.setText(oregonTrail.datedisplay());
			weather_message.setText(oregonTrail.weatherString());
			if (oregonTrail.distanceto()== 0)
			{
				city_message.setText(oregonTrail.closestloc().getLocationName());
				distance_message.setText("");
			}
			else {
				city_message.setText("On the trail");
				distance_message.setText(""+oregonTrail.distanceto()+" miles from "+oregonTrail.closestloc().getLocationName());
			}

		}


	}
	
	