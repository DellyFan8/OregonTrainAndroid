
	 
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
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.LinearLayout;
    import android.widget.PopupWindow;
    import android.widget.RelativeLayout;
    import android.widget.TextView;

    import com.example.myapplication.GameMech.GameMechs;
    import com.example.myapplication.GameMech.Inventory;
    import com.example.myapplication.GameMech.Store;

    public class Store_Activity extends Activity {

        private TextView storeName;

        private TextView item1;
        private EditText item1ET;
        private Button item1B;

        private TextView item2;
        private EditText item2ET;
        private Button item2B;

        private TextView item3;
        private EditText item3ET;
        private Button item3B;

        private TextView item4;
        private EditText item4ET;
        private Button item4B;

        private TextView item5;
        private EditText item5ET;
        private Button item5B;

        private TextView item6;
        private EditText item6ET;
        private Button item6B;

        private View view6;

        LinearLayout layout;
        GameMechs gameMechs = new GameMechs();
        Store store = gameMechs.getStore();
        @Override
        public void onCreate(Bundle savedInstanceState) {



            super.onCreate(savedInstanceState);
            setContentView(R.layout.store_page);



            layout=findViewById(R.id.line);

            storeName= layout.findViewById(R.id.title_textz);


            item1=findViewById(R.id.title_text1);
            item2=findViewById(R.id.title_text2);
            item3=findViewById(R.id.title_text3);
            item4=findViewById(R.id.title_text4);
            item5=findViewById(R.id.title_text5);
            item6=findViewById(R.id.title_text6);

            item1ET=findViewById(R.id.title_editText1);
            item2ET=findViewById(R.id.title_editText2);
            item3ET=findViewById(R.id.title_editText3);
            item4ET=findViewById(R.id.title_editText4);
            item5ET=findViewById(R.id.title_editText5);
            item6ET=findViewById(R.id.title_editText6);

            item1B=findViewById(R.id.title_button1);
            item2B=findViewById(R.id.title_button2);
            item3B=findViewById(R.id.title_button3);
            item4B=findViewById(R.id.title_button4);
            item5B=findViewById(R.id.title_button5);
            item6B=findViewById(R.id.title_button6);

            view6=findViewById(R.id.title_block6);


            setNames();


            item1B.setOnClickListener(v->buyItem(1, Integer.parseInt(item1ET.getText().toString())));
            item2B.setOnClickListener(v->buyItem(2, Integer.parseInt(item2ET.getText().toString())));
            item3B.setOnClickListener(v->buyItem(3, Integer.parseInt(item3ET.getText().toString())));
            item4B.setOnClickListener(v->buyItem(4, Integer.parseInt(item4ET.getText().toString())));
            item5B.setOnClickListener(v->buyItem(5, Integer.parseInt(item5ET.getText().toString())));

            if(store.storeSize()>5){
                item6B.setOnClickListener(v->buyItem(6, Integer.parseInt(item6ET.getText().toString())));
            }



        }
        private void setNames(){
            storeName.setText("Welcome to "+store.getName()+"  ||  You have: $"+store.getInventory().getDollars());
            item1.setText(store.getItemName(0)+"  ||  "+(int)store.getItemNum(0)+" Available- $"+store.getItemPrice(0)+" Each");
            item2.setText(store.getItemName(1)+"  ||  "+(int)store.getItemNum(1)+" Available- $"+store.getItemPrice(1)+" Each");
            item3.setText(store.getItemName(2)+"  ||  "+(int)store.getItemNum(2)+" Available- $"+store.getItemPrice(2)+" Each");
            item4.setText(store.getItemName(3)+"  ||  "+(int)store.getItemNum(3)+" Available- $"+store.getItemPrice(3)+" Each");
            item5.setText(store.getItemName(4)+"  ||  "+(int)store.getItemNum(4)+" Available- $"+store.getItemPrice(4)+" Each");


            if(store.storeSize()>5){
                item6.setText(store.getItemName(5)+"  ||  "+(int)store.getItemNum(5)+" Available- $"+store.getItemPrice(5)+" Each");
            }
            else{
                item6.setVisibility(View.GONE);
                item6ET.setVisibility(View.GONE);
                item6B.setVisibility(View.GONE);
                view6.setVisibility(View.GONE);
            }}


        private void buyItem(int num, int quant){
            if(store.confirmPurchase(num,quant)==1){
                store.purchase(num,quant);
                setNames();
            }
            else{
                System.out.println("You either don't have enough money or tried to order more than what is available\nPlease try again.");
            }
        }

    }
	
	