
	 
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
	import android.widget.ImageView;
	import android.widget.TextView;

	import com.example.myapplication.GameMech.GameMechs;
	import com.example.myapplication.GameMech.Inventory;
	import com.example.myapplication.GameMech.Map;
	import com.example.myapplication.GameMech.Person;

	import java.util.ArrayList;

	public class Main_Game_Activity extends Activity {


		static Inventory inventory;
		static ArrayList<Person> party;
		static Map oregonTrail;

		private View _bg__slide_16_9___2_ek2;
		private ImageView landscape7_1;
		private View date_box;
		private TextView date_message;
		private TextView date_;
		private TextView weather_message;
		private TextView weather_;
		private View locaton_box;
		private TextView city_message;
		private TextView location_;
		private TextView distance_message;
		private Button advance_button;
		private Button menu_button;

		@Override
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.main_game_page);


			_bg__slide_16_9___2_ek2 = (View) findViewById(R.id._bg__slide_16_9___2_ek2);
			landscape7_1 = (ImageView) findViewById(R.id.landscape7_1);
			date_box = (View) findViewById(R.id.date_box);
			date_message = (TextView) findViewById(R.id.date_message);
			date_ = (TextView) findViewById(R.id.date_);
			weather_message = (TextView) findViewById(R.id.weather_message);
			weather_ = (TextView) findViewById(R.id.weather_);
			locaton_box = (View) findViewById(R.id.locaton_box);
			city_message = (TextView) findViewById(R.id.city_message);
			location_ = (TextView) findViewById(R.id.location_);
			distance_message = (TextView) findViewById(R.id.distance_message);
			advance_button = findViewById(R.id.advance_button);
			menu_button = findViewById(R.id.menu_button);

			GameMechs gameMechs = new GameMechs();
			//custom code goes here
			inventory = new Inventory(gameMechs.getMoney(), gameMechs.getParty());
			System.out.println(gameMechs.getMoney()+"\t"+gameMechs.getParty().toString());
			playGame();

		}


		public void openActivity(Class classToOpen){
			Intent intent = new Intent(this, classToOpen);
			startActivity(intent);
		}

		private void playGame(){

		}

}
	
	