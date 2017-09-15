package com.matib05.android.justsignup.view.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.matib05.android.justsignup.R;
import com.matib05.android.justsignup.model.GithubRepo;
import com.matib05.android.justsignup.view.GithubClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matib05 on 9/13/2017.
 */

public class GitActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_git);
        final ListView mListView = (ListView) findViewById(R.id.git_list_view);

        //Intent intent = getIntent();
        //String username = intent.getStringExtra("username");

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.gitbub.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit  = builder.build();
        GithubClient client = retrofit.create(GithubClient.class);
        Call<List<GithubRepo>> call = client.reposForUser("matib05");

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();

                mListView.setAdapter(new GithubRepoAdapter(GitActivity.this, R.layout.list_item, repos));
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(GitActivity.this, "error", Toast.LENGTH_LONG).show();
            }
        });
    }

    private class GithubRepoAdapter extends ArrayAdapter<GithubRepo> {
        private Context mContext;
        private List<GithubRepo> list;

        public GithubRepoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<GithubRepo> values) {
            super(context, resource, values);

            this.mContext = context;
            this.list = values;

        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                getLayoutInflater();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView fl = (TextView) convertView.findViewById(R.id.firstLine);

            fl.setText(list.get(position).getName());

            return convertView;
        }
    }
}
