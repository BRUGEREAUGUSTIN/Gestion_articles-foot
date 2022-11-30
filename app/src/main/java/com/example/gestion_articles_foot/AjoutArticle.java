package com.example.gestion_articles_foot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AjoutArticle extends AppCompatActivity {

    //Attributs de l'activité lié à la fenêtre
    ArrayList<Article> mesArticles=new ArrayList<Article>();

    // variable qui permet de gérer la récupération des données des composants

    //Création de la collection mesArticles

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_article);
        initialisation();
    }

    public void initialisation() {

        // récupération des composants grâce à leur ID
        Button buttonRetour = findViewById(R.id.buttonAddRetour);
        Button buttonAjouter=findViewById(R.id.buttonAddAjouter);
        EditText editTextnom=findViewById(R.id.editViewAddNom);
        EditText editTextdesc=findViewById(R.id.editViewDescAddArticle);
        EditText editTextprix=findViewById(R.id.editViewPrixAddArticle);
        EditText editTextquantite=findViewById(R.id.editViewQteAddArticle);

        //Récupération de l'intent qui contient la collection
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        mesArticles = (ArrayList<Article>) getIntent().getSerializableExtra("MesArticles");
        //Action sur le bouton "retour", permet juste de renvoyer la collection

        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjoutArticle.this,
                        MainActivity.class);
                intent.putExtra("MesArticles", mesArticles);
                startActivity(intent);
            }
        });
        //Action sur le bouton "ajouter un article"

        buttonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on récupère les données des EditText
                String nom = editTextnom.getText().toString();
                String desc = editTextdesc.getText().toString();
                double prix =Double.parseDouble(editTextprix.getText().toString());
                int quantite=Integer.parseInt(editTextquantite.getText().toString());
                Article article=new Article(nom,desc,prix,quantite);
                //ajout de l'article à la collection
                 mesArticles.add(article);
                //Création de l'intent d'ajout
                Intent intent = new Intent(AjoutArticle.this,
                        MainActivity.class);
                intent.putExtra("MesArticles", mesArticles);
                startActivity(intent);
            }
        });
    }
}


