
	 
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
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ImageView;
    import android.widget.TextView;

    public class aboutActivity extends Activity {

        private View _bg__slide_16_9___1_ek2;
        private ImageView oregon_trail_opener_1;
        private TextView text;
        private TextView text_ek1;
        private TextView text_ek2;

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.about_page);


            _bg__slide_16_9___1_ek2 = (View) findViewById(R.id._bg__slide_16_9___1_ek2);
            oregon_trail_opener_1 = (ImageView) findViewById(R.id.oregon_trail_opener_1);
            text = (TextView) findViewById(R.id.text);
            text_ek1 = (TextView) findViewById(R.id.text_ek1);




            //custom code goes here

            text.setOnClickListener(v -> openActivity(Opener_Activity.class));


        }

        public void openActivity(Class classToOpen){
            Intent intent = new Intent(this, classToOpen);
            startActivity(intent);
        }
    }
	
	