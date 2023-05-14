
	 
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
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;

    import com.example.myapplication.GameMech.GameMechs;
    import com.example.myapplication.GameMech.Inventory;
    import com.example.myapplication.GameMech.Item;
    import com.example.myapplication.GameMech.Person;

    import java.util.ArrayList;

    public class menuActivity extends Activity {

        private Button inventory;
        private Button history;
        private Button party;

        private View exit;

        private TextView name;
        private TextView age;
        private TextView health;
        private TextView effects;

        private TextView historyBox;

        private TextView rations;
        private Button rationsDown;
        private Button rationsUp;



        GameMechs gameMechs = new GameMechs();
        Inventory inventoryObj;


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.inventory_page);

            inventoryObj = gameMechs.getInventory();


            inventory = findViewById(R.id.inventory);
            history = findViewById(R.id.history);
            party = findViewById(R.id.party);
            exit = findViewById(R.id.exit);
            name = findViewById(R.id.party_name);
            age = findViewById(R.id.party_age);
            health = findViewById(R.id.party_health);
            effects = findViewById(R.id.party_effects);
            historyBox = findViewById(R.id.history_box);

            rations = findViewById(R.id.rations);
            rationsUp = findViewById(R.id.rationsUp);
            rationsDown = findViewById(R.id.rationsDown);



            party.setOnClickListener(v->setPartyMode());
            history.setOnClickListener(v->setHistoryMode());
            exit.setOnClickListener(v->openActivity(Main_Game_Activity.class));
            rationsUp.setOnClickListener(v->rations(true));
            rationsDown.setOnClickListener(v->rations(false));
            inventory.setOnClickListener(v->setInventoryMode());

            rations.setText("Rations:\n"+gameMechs.getMap().getRations());
        }

        private void rations(boolean i) {
            if(i==true&&gameMechs.getMap().getRations()<5){
                gameMechs.getMap().setRations(1+gameMechs.getMap().getRations());
                rations.setText("Rations:\n"+gameMechs.getMap().getRations());
            }
            if(i==false&&gameMechs.getMap().getRations()>1){
                gameMechs.getMap().setRations(gameMechs.getMap().getRations()-1);
                rations.setText("Rations:\n"+gameMechs.getMap().getRations());
            }

        }

        public void openActivity(Class classToOpen){
            Intent intent = new Intent(this, classToOpen);
            startActivity(intent);
        }

        private void setPartyMode(){
            clear();
            name.setText("Name");
            name.setTextSize(30);
            age.setTextSize(30);
            age.setText("Age");
            health.setText("Health");
            effects.setText("Conditions");

            ArrayList<Person> party = inventoryObj.getPeopleinparty();
            for(Person person:party){
                name.setText(name.getText()+"\n"+person.getName());
                age.setText(age.getText()+"\n"+person.getAge());
                health.setText(health.getText()+"\n"+person.getHealth());
                effects.setText(effects.getText()+"\n"+person.getEffectString());
            }
        }

        private void setInventoryMode(){
            clear();
            name.setText("Item");
            name.setTextSize(24);
            age.setText("Amount");
            age.setTextSize(24);
//            health.setText("Health");
//            effects.setText("Conditions");

            ArrayList<Item> party = inventoryObj.getItems();
            for(Item person:party){
                name.setText(name.getText()+"\n"+person.getName());
                age.setText(age.getText()+"\n"+person.getQuantity());
//                health.setText(health.getText()+"\n"+person.getHealth());
//                effects.setText(effects.getText()+"\n"+person.getEffectString());
            }
        }

        private void setHistoryMode(){
            clear();
            historyBox.setText("History Goes Here");
        }

        private void clear() {
            name.setText("");
            age.setText("");
            health.setText("");
            effects.setText("");
            historyBox.setText("");
        }

    }
	
	