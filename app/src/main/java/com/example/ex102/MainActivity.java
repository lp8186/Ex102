package com.example.ex102;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Liad Peretz
 * @version 1.0
 * @since  8/12/20
 * Short description- Practice for alert dialog.
 */

public class MainActivity extends AppCompatActivity {


    LinearLayout color;
    final String [] colors1= {"Red","Green","Blue"};
    AlertDialog.Builder adb;
    int [] colors2={0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color = (LinearLayout) findViewById(R.id.color);

    }

    /**
     * One
     * Short description- Alert dialog with setItems.
     * <p>
     *     View view
     * @param view the view
     */
    public void one(View view) {
        colors2= new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Color");
        adb.setItems(colors1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                colors2[which]=225;
                color.setBackgroundColor(Color.rgb(colors2[0],colors2[1],colors2[2]));
            }
        });
        adb.setPositiveButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Two
     * Short description- Alert dialog with setMultiChoiceItems.
     * <p>
     *     View view
     * @param view the view
     */
    public void two(View view) {
        colors2= new int []{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Color");
        adb.setMultiChoiceItems(colors1, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked)
                    colors2[which]=225;
                else if (colors2[which]==225)
                    colors2[which]=0;
                color.setBackgroundColor(Color.rgb(colors2[0],colors2[1],colors2[2]));
            }
        });
        adb.setPositiveButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Three
     * Short description- Button which changes the background color to white.
     * <p>
     *     View view
     * @param view the view
     */
    public void three(View view) {
        color.setBackgroundColor(Color.WHITE);
    }

    /**
     * Four
     * Short description- Alert dialog with editText.
     * <p>
     *     View view
     * @param view the view
     */
    public void four(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message");
        adb.setCancelable(false);
        final EditText ed= new EditText(this);
        ed.setHint("Enter something");
        adb.setView(ed);
        adb.setNeutralButton("Show", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str= ed.getText().toString();
                if (!(str.equals("")))
                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });

        adb.setPositiveButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }



    /**
     * Extra
     * Short description- Alert dialog with two editText.
     * <p>
     *     View view
     * @param view the view
     */
    public void extra(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message");
        adb.setCancelable(false);
        final EditText ed1= new EditText(this);
        final EditText ed2= new EditText(this);
        ed1.setHint("Enter something");
        ed2.setHint("Enter something");
        LinearLayout ll= new LinearLayout(getApplicationContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(ed1);
        ll.addView(ed2);
        adb.setView(ll);

        adb.setNeutralButton("Show", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str= ed1.getText().toString();
                str= str+" "+ed2.getText().toString();
                if (!(str.equals("")))
                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });

        adb.setPositiveButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * OnCreateOptionsMenu
     * Short descriptions- Creates an options menu.
     * <p>
     *    Menu menu
     * @param menu the menu
     * @return true if it worked.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0, 0, 100, "Credits");
        return true;
    }

    /**
     * OnOptionsItemSelected
     * Short description- Starts the credits activity.
     * @param item the selected item
     * @return true if it worked.
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent si = new Intent(this, Credits.class);
        startActivity(si);
        return true;
    }
}