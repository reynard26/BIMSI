package projectc1.com.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import projectc1.com.R;

public class StudentNote {
    private long _id;
    private String _namaPengingat;
    private String _pengingat;

    public StudentNote(){

    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_namaPengingat() {
        return _namaPengingat;
    }

    public void set_namaPengingat(String _namaPengingat) {
        this._namaPengingat = _namaPengingat;
    }

    public String get_pengingat() {
        return _pengingat;
    }

    public void set_pengingat(String _pengingat) {
        this._pengingat = _pengingat;
    }

    @Override
    public String toString() {
        return "Nama Pengingat\t: " + _namaPengingat + "\nNotes\t: " + _pengingat ;
    }

}