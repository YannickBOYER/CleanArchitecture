package fr.esgi.avis.business;

public class Classification {
    private Long id;
    private String nom;
    private String couleurRGB;

    public Classification() {
    }
    public Classification(Long id, String nom, String couleurRGB) {
        this.id = id;
        this.nom = nom;
        this.couleurRGB = couleurRGB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleurRGB() {
        return couleurRGB;
    }

    public void setCouleurRGB(String couleurRGB) {
        this.couleurRGB = couleurRGB;
    }
}
