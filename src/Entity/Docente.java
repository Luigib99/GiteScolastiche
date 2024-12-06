package Entity;

public class Docente {
    private int id;
    private String nome;
    private String cognome;

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getNome()
    {
        return nome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    public String getCognome()
    {
        return cognome;
    }
}
