package com.matib05.android.justsignup.view.list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.matib05.android.justsignup.R;

import java.util.ArrayList;

public class PickActivity extends AppCompatActivity {
    /*private static final String TAG = "PickActivity";

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);
        Log.d(TAG, "onCreate: created");
        // instantiate List Item data
        String[] values = new String[] {
            "Quranstuff"
        };

        ArrayList<String> list = new ArrayList<>();
        for (String item: values) {
            list.add(item);
        }
        Log.d(TAG, "onCreate: data initialized");


        mListView = (ListView) findViewById(R.id.listview);
        Log.d(TAG, "onCreate: listview created");
        QuranActivityAdapter quranActivityAdapter = new QuranActivityAdapter(getApplicationContext(), list);
        mListView.setAdapter(quranActivityAdapter);

        Log.d(TAG, "onCreate: adapter set");
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: " + adapterView.getItemAtPosition(i));
                Toast.makeText(PickActivity.this, "test" + i, Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                switch (i) {
                    case 1:
                        //ACTION_PICK_ACTIVITY - study this
                        break;
                }


            }
        });
    }

    private class QuranActivityAdapter extends ArrayAdapter<String> {

        private QuranActivityAdapter(Context context, ArrayList<String> list) {
            super(context, 0, list);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            String item = getItem(position);

            if (convertView == null) {
                getLayoutInflater();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView fl = (TextView) convertView.findViewById(R.id.firstLine);
            TextView sl = (TextView) convertView.findViewById(R.id.secondLine);

            fl.setText(item);
            sl.setText("read description later");

            return convertView;
        }
    }*/

}
