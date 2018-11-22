package com.example.samrans.mithileshpracticedemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    int fragAdd = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frameLayout = findViewById(R.id.framContainer);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final EditText edtJumpTO =  findViewById(R.id.edtJumpTO);
        final FloatingActionButton fabJumpTo = (FloatingActionButton) findViewById(R.id.fabJumpTo);
        fabJumpTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edtJumpTO.getText())){
                   Fragment fragment= getSupportFragmentManager().findFragmentByTag("Frag"+edtJumpTO.getText().toString());
                 /* int backID= getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getFragments().indexOf(fragment)).getId();
                    getSupportFragmentManager().popBackStack(backID
                            ,FragmentManager.POP_BACK_STACK_INCLUSIVE);*/
                    int backID= getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getFragments().indexOf(fragment)).getId();
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
//                    getSupportFragmentManager().popBackStack(backID,0);
                 getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.framContainer,fragment).commit();

                }
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++fragAdd;
                switch (fragAdd) {
                    case 1:
                        placeFragment(Color.RED);
                        break;
                    case 2:
                        placeFragment(Color.BLUE);
                        break;
                    case 3:
                        placeFragment(Color.YELLOW);
                        break;
                    case 4:
                        placeFragment(Color.GREEN);
                        break;
                    default:
                        placeFragment(Color.MAGENTA);
                        break;
                }

            }
        });
    }

    private void placeFragment(int color) {
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("data", color);
        bundle.putInt("dataVal", fragAdd);
        blankFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.framContainer, blankFragment, "Frag"+fragAdd)
                .addToBackStack(blankFragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        --fragAdd;
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
