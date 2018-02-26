package com.example.ambikesh.menuoption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b;
    ImageView iv;
    ActionMode am;
    ActionMode.Callback amc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.iv);
        b=findViewById(R.id.bt1);
        registerForContextMenu(iv);

        amc=new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.my_menu,menu);
                mode.setTitle("Demo of");
                
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        };


        b.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                am=startActionMode(amc);
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem m1= menu.add(0,1,5,"About Us");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        SubMenu sb=menu.addSubMenu("SubMenu");//Menu inside menu
        sb.add(0,2,0,"Submenu1");
        sb.add(0,3,0,"Submenu2");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int k=item.getItemId();
        switch (k)
        {
            case R.id.id1:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.id2:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Ifo Cliked", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(this, "Ifo Cliked", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, " Cliked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       menu.add(0,1,0,"New Tab");
        menu.add(0,2,0,"Save As");
        menu.add(0,3,0,"Download");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int k=item.getItemId();
        switch (k) {
            case 1:
                Toast.makeText(this, "Ifo Cliked", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(this, "Ifo Cliked", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, " Cliked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
