package test.nik.notesresolvertest;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContacts();
    }

    public void getContacts() {
        List<Note> contacts = readContacts(Uri.parse("content://test.nik.notes.provider/notes_table"));
        if(contacts != null)
            System.out.println(contacts.size());
    }

    public List<Note> readContacts(Uri uri ) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor == null) {
            return null;
        }
        return parseContacts(cursor);
    }

    private List<Note> parseContacts(Cursor cursor) {
        ArrayList<Note> contacts = new ArrayList<>();
        while (cursor.moveToNext()) {
            String text = cursor.getString(cursor.getColumnIndex("noteText"));
            contacts.add(new Note(text));
        }
        cursor.close();
        return contacts;
    }
}




