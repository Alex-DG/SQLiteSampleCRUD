package com.project.sqlitesample;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		DatabaseHandler db = new DatabaseHandler(this);
	
		db.deleteAllContactFromTable("phone_number");
		
		/*
		 * CRUD Operations
		 */
		//Inserting contacts
		Log.d("Insert:", "Inserting ..");
		db.addContact(new Contact("Alex", "06.87.42.56.87"));   
		db.addContact(new Contact("Jeremy", "06.56.56.56.56"));   
		db.addContact(new Contact("Guillaume", "06.12.12.12.12"));   
		db.addContact(new Contact("Clement", "06.37.37.37.37"));  
		
		//Reading all contacts
		Log.d("Reading:", "Reading all contacts ..");
		List<Contact> contacts = db.getAllContacts();
		
		for(Contact contact : contacts){
			String log = "Id: " + contact.get_id() + ", Name: " + contact.get_name() + ", Phone: " + contact.get_phone_number();
			Log.d("Name: ", log);
		}
		
		// Get contact by Id
		Contact contactById = db.getContactById(2);
		String logById = "Id: " + contactById.get_id() + ", Name: " + contactById.get_name() + ", Phone: " + contactById.get_phone_number();
		Log.d("ContactById:", logById);
		
		// Get contact by name
		Contact contactByName = db.getContactByName("Alex");
		String logByName = "Id: " + contactByName.get_id() + ", Name: " + contactByName.get_name() + ", Phone: " + contactByName.get_phone_number();
		Log.d("ContactByName:", logByName);
		
		// Delete contact
		Contact contactToDelete  = db.getContactByName("Guillaume");
		db.deleteContact(contactToDelete);
		List<Contact> contacts2 = db.getAllContacts();
		for(Contact contact : contacts2){
			String log = "Id: " + contact.get_id() + ", Name: " + contact.get_name() + ", Phone: " + contact.get_phone_number();
			Log.d("Delete: ", log);
		}
 	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
