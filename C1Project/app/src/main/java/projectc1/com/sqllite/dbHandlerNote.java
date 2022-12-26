package projectc1.com.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class dbHandlerNote extends SQLiteOpenHelper {

    //Deklarasi variabel  untuk pembuatan database, dengan memuat tabel dan kolom yang diperlukan
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentNote.db";
    private static final String TABLE_NAME = "studentNote";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAMAPENGINGAT = "_namaPengingat";
    private static final String COLUMN_PENGINGAT = "_pengingat";

    public dbHandlerNote(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Method untuk Create Database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_STUDENTNOTE = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAMAPENGINGAT + " VARCHAR(50) NOT NULL, " +
                COLUMN_PENGINGAT + " VARCHAR(500) NOT NULL)";

        sqLiteDatabase.execSQL(CREATE_TABLE_STUDENTNOTE);
    }

    //Method yang dipakai untuk upgrade tabel
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //Insert, Select, Update, Delete //

    private SQLiteDatabase database;

    //Method untuk open database connection
    public void open() throws SQLException {
        database = this.getWritableDatabase();
    }

    //Inisialisasi semua kolom di tabel database
    private String[] allColumns =
            {COLUMN_ID, COLUMN_NAMAPENGINGAT, COLUMN_PENGINGAT};

    //Method untuk memindahkan isi cursor ke database sql lite
    private StudentNote cursorToNote(Cursor cursor) {
        StudentNote studentNote = new StudentNote();

        studentNote.set_id(cursor.getLong(0));
        studentNote.set_namaPengingat(cursor.getString(1));
        studentNote.set_pengingat(cursor.getString(2));

        return studentNote;
    }

    //Method untuk menambahkan Student Note baru
    public void createNote(String namaPengingat, String pengingat) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMAPENGINGAT, namaPengingat);
        values.put(COLUMN_PENGINGAT, pengingat);

        database.insert(TABLE_NAME, null, values);
    }

    //Method untuk mendapatkan detail Mengenai pengingat yang ditambahkan
    public StudentNote getNote(long id) {
        StudentNote studentNote = new StudentNote();

        Cursor cursor =
                database.query(TABLE_NAME, allColumns, "_id=" + id, null, null, null, null);
        cursor.moveToFirst();
        studentNote = cursorToNote(cursor);
        cursor.close();

        return studentNote;
    }

    //Method untuk mendapatkan data - data yang diinput kedalam database sql lite
    public ArrayList<StudentNote> getStudentNote() {
        ArrayList<StudentNote> daftarNote = new ArrayList<StudentNote>();

        Cursor cursor =
                database.query(TABLE_NAME, allColumns, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            StudentNote Notes = cursorToNote(cursor);
            daftarNote.add(Notes);
            cursor.moveToNext();
        }

        cursor.close();
        return daftarNote;
    }

    //Method untuk melakukan update pada data student note
    public void updatePengingat(StudentNote Notes) {
        String filter = "_id=" + Notes.get_id();
        ContentValues args = new ContentValues();
        args.put(COLUMN_NAMAPENGINGAT, Notes.get_namaPengingat());
        args.put(COLUMN_PENGINGAT, Notes.get_pengingat());

        database.update(TABLE_NAME, args, filter, null);
    }

    //Method untuk menghapus data pada baris yang diinput pada student note
    public void deleteNote(long id) {
        String filter = "_id=" + id;

        database.delete(TABLE_NAME, filter, null);
    }
}
