package com.project.sqlitesample;

/*
 * Contact
 */
public class Contact {

	// private variables
	private int _id;
	private String _name;
	private String _phone_number;
	
	// empty constructor
	public Contact(){}
	
	// constructor
	public Contact(int id, String name, String phone_number){
		this.set_id(id);
		this.set_name(name);
		this.set_phone_number(phone_number);
	}
	
	// constructor
    public Contact(String name, String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }

	// getting id
	int get_id() {
		return _id;
	}

	// setting id
	void set_id(int _id) {
		this._id = _id;
	}

	// getting name
	String get_name() {
		return _name;
	}

	// setting name
	void set_name(String _name) {
		this._name = _name;
	}

	// getting phone number
	String get_phone_number() {
		return _phone_number;
	}

	// setting phone number
	void set_phone_number(String _phone_number) {
		this._phone_number = _phone_number;
	}
}
