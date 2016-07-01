package com.example.recyclercards;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ViewHeroesActivity extends AppCompatActivity {
    Context context;
    ProgressDialog pd;

    private class loaderTask extends AsyncTask<URL, Void, ArrayList> {

        protected void onPreExecute() {
            pd.show();
        }

        @Override
        protected ArrayList doInBackground(URL... myURL) {
            HelperHero help = new HelperHero();
            //ArrayList heroes = help.fillMyArray();
            //ArrayList heroes = help.getJsonFromString();
            ArrayList heroes = help.getJsonFromURL(myURL);
            return heroes;
        }

        protected void onPostExecute(ArrayList heroes) {
            RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
            LinearLayoutManager llm = new LinearLayoutManager(context);
            rv.setLayoutManager(llm);

            RVAdapter adapter = new RVAdapter(heroes);
            rv.setAdapter(adapter);
            pd.dismiss();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_heroes);

        context = this;
        if (context != null) {
            pd = new ProgressDialog(context);
        }

        //depending on the user
        URL myURL = null;

        try {
            myURL = new URL("http://despdb.esy.es/jsonstaticheroes.json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        new loaderTask().execute(myURL);
    }
}
