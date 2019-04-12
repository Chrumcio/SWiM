package com.example.zadanie3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContextModeActivity extends AppCompatActivity {
    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> Fruits = new ArrayList<>();
    private List<String> UserSelection = new ArrayList<>();
    private String text;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_mode);

        getFruits();

        listView = findViewById(R.id.mListView);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(modeListener);
        adapter = new ListViewAdapter(Fruits,this);
        listView.setAdapter(adapter);

    }

    private void getFruits(){
        String [] items = getResources().getStringArray(R.array.fruits);

        for (String item : items){
            Fruits.add(item);
        }
    }

    AbsListView.MultiChoiceModeListener modeListener = new AbsListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            if(UserSelection.contains(Fruits.get(position))){
                UserSelection.remove(Fruits.get(position));
            }else{
                UserSelection.add(Fruits.get(position));
            }
            mode.setTitle(UserSelection.size()+" items selected...");
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_context_mode,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_delete:
                    adapter.removeItems(UserSelection);
                    mode.finish();
                    return true;
                case R.id.action_share:
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"));
                    intent.putExtra("sms_body",text);
                    startActivity(intent);
                    mode.finish();
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            UserSelection.clear();
        }
    };
}
