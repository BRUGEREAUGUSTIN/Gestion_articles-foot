package com.example.gestion_articles_foot;

import java.io.Serializable;

public class Article implements Serializable {

    private String nom;
    private String description;
    private double prix;
    private int qte;

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public int getQte() {
        return qte;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Article(String nom, String description, double prix, int qte) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.qte = qte;
    }

}
