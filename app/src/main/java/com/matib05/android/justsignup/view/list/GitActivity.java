package com.matib05.android.justsignup.view.list;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.matib05.android.justsignup.R;
import com.matib05.android.justsignup.adapter.GitHubRepoAdapter;
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

    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git);
        mListView = (ListView) findViewById(R.id.pagination_list);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit  = builder.build();
        GithubClient client = retrofit.create(GithubClient.class);
        Intent intent  = getIntent();
        String username = intent.getStringExtra("username");
        Call<List<GithubRepo>> call = client.reposForUser(username);

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(@NonNull Call<List<GithubRepo>> call, @NonNull Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();

                if (repos != null) {
                    mListView.setAdapter(new GitHubRepoAdapter(GitActivity.this, repos));
                }

            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(GitActivity.this, "error", Toast.LENGTH_LONG).show();
                t.fillInStackTrace();
            }
        });
    }
}
