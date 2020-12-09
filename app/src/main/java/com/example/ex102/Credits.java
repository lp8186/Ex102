package com.example.ex102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * @author Liad Peretz
 * @version 1.0
 * @since 8/12/20
 * Short description- Credits.
 */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }
    /**
     * OnCreateOptionsMenu
     * Short descriptions- Creates an options menu.
     * <p>
     *    Menu menu
     * @param menu the menu
     * @return true if it worked.
     */
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        menu.add(0,0,100,"Back");
        return true;
    }

    /**
     * OnOptionsItemSelected
     * Short description- Finishes the activity and returns to the main activity.
     * @param item the selected item
     * @return true if it worked.
     */
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}