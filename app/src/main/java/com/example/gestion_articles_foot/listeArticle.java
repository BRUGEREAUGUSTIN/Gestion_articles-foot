package com.example.gestion_articles_foot;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class listeArticle {
    public class ListeArticle extends AppCompatActivity {
        //Attributs de l'activité lié à la fenêtre
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.liste_article);
            initialisation();
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public void initialisation() {
            // récupération des Buttons grâce à leur ID
            //Création d'un intent pour l'affichage dans une liste View des nom des produits
            Intent intent = getIntent();
            Bundle args = intent.getBundleExtra("BUNDLE");
            mesArticles = (ArrayList<Article>)
                    getIntent().getSerializableExtra("MesArticles");
            //Gestion de l'affichage dans le list View
            ArrayAdapter adp = new ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, mesArticles.stream().map(h->h.getNom()).collect(Collectors.toList()));
            listeViewArticles.setAdapter(adp);
            // Action sur le bouton "retour"
            buttonRetour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }


}
