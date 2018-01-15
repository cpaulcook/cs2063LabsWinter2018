package mobiledev.unb.ca.trydb2;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private DBHelper mDBHelper;
    private static final String[] ITEM_NUM_COLS = { DBHelper.ITEM, DBHelper.NUM };
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create a new DBHelper object
        mDBHelper = new DBHelper(this);

        mListView = (ListView) findViewById(R.id.listview);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                           long id) {
                String stringId = String.valueOf(id);
                deleteItem(stringId);
                return true;
            }
        });

        setUpListView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.dialog_layout, null);
                builder.setView(dialogView)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText itemEditText =
                                        (EditText) dialogView.findViewById(R.id.item_edit_text);
                                EditText numEditText =
                                        (EditText) dialogView.findViewById(R.id.number_edit_text);
                                String item = itemEditText.getText().toString();
                                String num = numEditText.getText().toString();
                                addItem(item, num);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                alertDialog.show();
            }
        });
    }

    private void setUpListView() {
        // Ideally this would be done in a worker thread because
        // getReadableDatabase() can be long running operation
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        Cursor c = db.query(DBHelper.TABLE_NAME,
                DBHelper.COLUMNS, null, new String[] {}, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MainActivity.this,
                R.layout.list_layout,
                c,
                ITEM_NUM_COLS,
                new int[] { R.id.item_textview, R.id.num_textview},
                0);
        mListView.setAdapter(adapter);
    }

    private void addItem(String item, String num) {
        // Ideally this would be done in a worker thread because
        // getWritableDatabase() can be long running operation
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.ITEM, item);
        values.put(DBHelper.NUM, num);
        db.insert(
                DBHelper.TABLE_NAME,
                null,
                values);
        // Set up the ListView again once we've modified the database
        setUpListView();
    }

    private void deleteItem(String item) {
        // Ideally this would be done in a worker thread because
        // getWritableDatabase() can be long running operation
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME,
                DBHelper._ID + "=?",
                new String[]{item});
        setUpListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
