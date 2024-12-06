package Entity;

public class Viaggio {
    private int id;
    private int gitaId;
    private int classeId;

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
}
