package Entity;

import java.time.LocalDate;

public class Gita {
    private int id;
    private int idDocente;
    private String luogo;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }

    public void setIdDocente(int idDocente)
    {
        this.idDocente = idDocente;
    }
    public int getIdDocente()
    {
        return idDocente;
    }

    public void setLuogo(String luogo)
    {
        this.luogo = luogo;
    }
    public String getLuogo()
    {
        return luogo;
    }

    public void setDataInizio(LocalDate dataInizio)
    {
        this.dataInizio = dataInizio;
    }
    public LocalDate getDataInizio()
    {
        return dataInizio;
    }

    public void setDataFine(LocalDate dataFine)
    {
        this.dataFine = dataFine;
    }
    public LocalDate getDataFine()
    {
        return dataFine;
    }

}
