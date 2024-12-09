package Entity;

import java.time.LocalDate;

public class Classe {
    private int id;
    private String sezione;
    private int idDocente;
    private Docente docente;

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }

    public void setSezione(String sezione)
    {
        this.sezione = sezione;
    }
    public String getSezione()
    {
        return sezione;
    }

    public void setIdDocente(int idDocente)
    {
        this.idDocente = idDocente;
    }
    public int getIdDocente()
    {
        return idDocente;
    }

    public void setDocente(Docente docente)
    {
        this.docente = docente;
    }
    public Docente getDocente ()
    {
        return docente;
    }
}
