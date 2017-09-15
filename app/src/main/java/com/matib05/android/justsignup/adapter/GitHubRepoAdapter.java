package com.matib05.android.justsignup.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.matib05.android.justsignup.R;
import com.matib05.android.justsignup.model.GithubRepo;

import java.util.List;

/**
 * Created by matib05 on 9/14/2017.
 */

public class GitHubRepoAdapter  extends ArrayAdapter<GithubRepo> {
    private Context mContext;
    private List<GithubRepo> values;

    public GitHubRepoAdapter(@NonNull Context context, @NonNull List<GithubRepo> values) {
        super(context, R.layout.list_item_pagination, values);


        this.mContext = context;
        this.values = values;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_pagination, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.list_item_pagination_text);

        tv.setText(values.get(position).getName());

        return convertView;
    }
}