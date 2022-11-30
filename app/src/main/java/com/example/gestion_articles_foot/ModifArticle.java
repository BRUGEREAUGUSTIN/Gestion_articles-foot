package com.example.gestion_articles_foot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class ModifArticle extends AppCompatActivity {
    //Attributs de l'activité lié à la fenêtre
    ArrayList<Article> mesArticles = new ArrayList<Article>();

    // variable qui permet de gérer la récupération des données des composants

    //Création de la collection mesArticles

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modif_article);
        initialisation();
    }

    public void initialisation() {

        // récupération des composants grâce à leur ID
        Button buttonRetour = findViewById(R.id.buttonMajRetour);
        Button buttonModifier = findViewById(R.id.buttonMajMaj);
        EditText editTextnom = findViewById(R.id.editViewMajNomArticle);
        EditText editTextdesc = findViewById(R.id.editViewMajDescArticle);
        EditText editTextprix = findViewById(R.id.EditViewMajPrixArticle);
        EditText editTextquantite = findViewById(R.id.editViewMajQteArticle);

        //Récupération de l'intent qui contient la collection
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        mesArticles = (ArrayList<Article>) getIntent().getSerializableExtra("MesArticles");
        //Action sur le bouton "retour", permet juste de renvoyer la collection

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifArticle.this,
                        MainActivity.class);
                intent.putExtra("MesArticles", mesArticles);
                startActivity(intent);
            }
        });
        //Action sur le bouton "modifier un article"

        buttonModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on récupère les données des EditText
                String nom = editTextnom.getText().toString();
                String desc = editTextdesc.getText().toString();
                double prix = Double.parseDouble(editTextprix.getText().toString());
                int quantite = Integer.parseInt(editTextquantite.getText().toString());
                for (Article monarticle : mesArticles
                ) {
                    if (Objects.equals(monarticle.getNom(), nom)) {
                        monarticle.setDescription(desc);
                        monarticle.setPrix(prix);
                        monarticle.setQte(quantite);
                    }
                }

                //Création de l'intent d'ajout
                Intent intent = new Intent(ModifArticle.this,
                        MainActivity.class);
                intent.putExtra("MesArticles", mesArticles);
                startActivity(intent);
            }
        });

    }
}