
	 
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
    import android.widget.Button;

    import com.example.myapplication.GameMech.GameMechs;

    public class FProfession_Activity extends Activity {


        private Button carpenter;
        private Button banker;
        private int money = 0;

        private Button farmer;
        @Override
        public void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.profession_page);

            carpenter = findViewById(R.id.free_mode_button);
            farmer = findViewById(R.id.farmer_button);
            banker = findViewById(R.id.story_mode_button);

            banker.setText("Apothecary");
            carpenter.setText("Blacksmith");
            farmer.setText("Housekeeper");


            //custom code goes here

            carpenter.setOnClickListener(v -> profession(2));
            farmer.setOnClickListener(v -> profession(3));
            banker.setOnClickListener(v -> profession(1));
        }

        private void profession(int number){
            GameMechs gameMechs = new GameMechs();
            if(number == 1){
                gameMechs.addMoney(200);
            }
            else if (number == 2){
                gameMechs.addMoney(100);
            }
            else{
                gameMechs.addMoney(0);
            }
            openActivity(Month_Activity.class);
        }

        public void openActivity(Class classToOpen){
            Intent intent = new Intent(this, classToOpen);
            startActivity(intent);
        }

        public int getMoney(){
            return money;
        }
    }
	
	