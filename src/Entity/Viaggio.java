package Entity;

import java.util.ArrayList;
import java.util.List;

public class Viaggio {
    private int id;
    private int gitaId;
    private int classeId;
    private List <Classe> classi = new ArrayList<>();
    private List <Gita> gite = new ArrayList<>();
    private List <Docente> docenti = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setIdGita(int gitaId)
    {
        this.gitaId = gitaId;
    }
    public int getIdGita()
    {
        return gitaId;
    }

    public void setIdClasse(int classeId)
    {
        this.classeId = classeId;
    }
    public int getIdClasse()
    {
        return classeId;
    }

    public void addClasse(Classe classe)
    {
        classi.add(classe);
    }
    public void addGita(Gita gita)
    {
        gite.add(gita);
    }
    public void addDocente(Docente docente)
    {
        docenti.add(docente);
    }

    public List<Classe> getClassi()
    {
        return classi;
    }
    public List<Gita> getGite()
    {
        return gite;
    }
    public List <Docente> getDocenti()
    {
        return docenti;
    }
}
