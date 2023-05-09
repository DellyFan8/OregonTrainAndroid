
	 
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

    public class Month_Activity extends Activity {


        private Button march;
        private Button april;
        private Button may;
        private Button june;
        private Button july;

        @Override
        public void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.month_page);

            march = findViewById(R.id.march_button);
            april = findViewById(R.id.april_button);
            may = findViewById(R.id.may_button);
            june = findViewById(R.id.june_button);
            july = findViewById(R.id.july_button);


            //custom code goes here

            march.setOnClickListener(v -> profession(1));
            april.setOnClickListener(v -> profession(2));
            may.setOnClickListener(v -> profession(3));
            june.setOnClickListener(v -> profession(4));
            july.setOnClickListener(v -> profession(5));
        }

        private void profession(int input){
            GameMechs gameMechs = new GameMechs();
            int day = 0;

            //Calculating what day to set calendar to
            switch (input){
                case 5:
                    day+=30;
                case 4:
                    day += 31;
                case 3:
                    day+=30;
                case 2:
                    day+= 31;
                case 1:
                    day+=0;
                    break;
            }
            gameMechs.setDay(day);
            openActivity(Main_Game_Activity.class);
        }

        public void openActivity(Class classToOpen){
            Intent intent = new Intent(this, classToOpen);
            startActivity(intent);
        }

    }
	
	