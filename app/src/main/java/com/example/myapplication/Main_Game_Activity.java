
	 
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

	import com.example.myapplication.GameMech.Event;
	import com.example.myapplication.GameMech.GameMechs;
	import com.example.myapplication.GameMech.Inventory;
	import com.example.myapplication.GameMech.Location;
	import com.example.myapplication.GameMech.Map;
	import com.example.myapplication.GameMech.Person;
	import com.example.myapplication.GameMech.Store;

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


			//Import Settings from windows before this one
			GameMechs gameMechs = new GameMechs();
			//custom code goes here
			inventory = new Inventory(gameMechs.getMoney(), gameMechs.getParty());
			day = gameMechs.getDay();





			playGame();

		}


		public void openActivity(Class classToOpen){
			Intent intent = new Intent(this, classToOpen);
			startActivity(intent);
		}

		private void playGame(){
			if(oregonTrail.closestloc().hasStore()){
				gameMechs.setInventory(inventory);
				gameMechs.setStore(oregonTrail.closestloc().getStore());
				openActivity(Store_Activity.class);
			}
		}

		private void setLocations(){
			//region Location Declaration

			//Declare location runner
			runnerLocations = new ArrayList<Location>();

			//Independence information
			runnerLocations.add(new Location(0,"Independence",new Store("Independence Wholesale", inventory,0), 1));

			//KR crossing information
			Event krCrossing = new Event(Event.EventType.RIVERCROSSING,1450.848,true);
			runnerLocations.add(new Location(102, "Kansas River crossing",krCrossing));

			//BBR crossing information
			Event bbrCrossing = new Event(Event.EventType.RIVERCROSSING,2072.64,false);
			runnerLocations.add(new Location(184,"Big Blue River Crossing",bbrCrossing));

			//Fort Kearny information
			runnerLocations.add(new Location(319,"Fort Kearny",new Store("Koo Koo Kearney's", inventory), 1.25));

			//Ash Hallow information
			runnerLocations.add(new Location(504,"Ash Hallow"));

			//Chimney rock information
			runnerLocations.add(new Location(554,"Chimney Rock"));

			//Scotts Bluff
			runnerLocations.add(new Location(596,"Scotts Bluff"));

			//Registar Cliff
			runnerLocations.add(new Location(658,"Register Cliff"));

			//Fort Laramie
			runnerLocations.add(new Location(750,"Fort Laramie",new Store("Laramie's Store", inventory), 1.5));

			//Independence Rock
			runnerLocations.add(new Location(815,"Independence Rock"));

			//South Pass
			Event split1=new Event(Event.EventType.SPLIT1);
			runnerLocations.add(new Location(914,"South Pass",split1));


			setLocations();
			oregonTrail = new Map(runnerLocations, inventory, day);
		}

}
	
	