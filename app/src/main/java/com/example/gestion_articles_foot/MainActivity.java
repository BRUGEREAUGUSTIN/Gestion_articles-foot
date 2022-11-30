package com.example.gestion_articles_foot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Attributs de la première activité lié à la fenêtre
    //Déclaration de votre collection
    ArrayList<Article> mesArticles;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Appel de la fonction d'initialisation
        initialisation();
    }

    public void initialisation(){
        // récupération des Buttons grâce à leur ID
        Button buttonAjouter = findViewById(R.id.buttonAjouter);
        Button buttonListe = findViewById(R.id.buttonListe);
        Button buttonMaj = findViewById(R.id.buttonMaj);
        //Si on a un intent et que j'ai pas d'article!!!
        if (getIntent().getSerializableExtra("MesArticles")==null) {
            // Instanciation de la liste d’article
            mesArticles=new ArrayList<Article>();
            Article article =new Article("test","test",1,2);
            Article article1 =new Article("test1","test1",11,21);
            mesArticles.add(article);
            mesArticles.add(article1);

        }
        else{
            mesArticles = (ArrayList<Article>) getIntent().getSerializableExtra("MesArticles");
        }
        //Action sur le bouton "ajouter un article"
        buttonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        AjoutArticle.class);
                intent.putExtra("MesArticles", mesArticles);
                startActivity(intent);
            }
        });

        //Action sur le bouton "liste des articles"
        buttonListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        ListeArticle.class);
                intent.putExtra("MesArticles", mesArticles);
                startActivity(intent);
            }
        });

        //Action sur le "bouton maj"
        buttonMaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        ModifArticle.class);
                intent.putExtra("MesArticles", mesArticles);
                startActivity(intent);
            }
        });
    }


  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case(R.id.menuAjout) :
                Intent ajoutArticle = new Intent(MainActivity.this,
                        AjoutArticle.class);
                ajoutArticle.putExtra("MesArticles",mesArticles);
                startActivity(ajoutArticle);
                return true;
            case (R.id.menuListe) :
                Intent listeArticle = new Intent(MainActivity.this,
                        ListeArticle.class);
                listeArticle.putExtra("MesArticles",mesArticles);
                startActivity(listeArticle);
                return true;
            case (R.id.menuModif):
                Intent majArticle = new Intent(MainActivity.this,
                        ModifArticle.class);
                startActivity(majArticle);
                majArticle.putExtra("MesArticles",mesArticles);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }*/
}

