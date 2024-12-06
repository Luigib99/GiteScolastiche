package Service;
import Entity.Gita;
import Repository.GitaRepository;

import java.time.LocalDate;
import java.util.List;

public class GitaService {
    GitaRepository gitaRepository=new GitaRepository();

    public void createGita(int idDocente, String luogo, LocalDate dataInizio, LocalDate dataFine)
    {
        Gita gita = new Gita();
        gita.setIdDocente(idDocente);
        gita.setLuogo(luogo);
        gita.setDataInizio(dataInizio);
        gita.setDataFine(dataFine);

        gitaRepository.createGita(gita);
    }

    public void updateGita(int id, int idDocente, String luogo, LocalDate dataInizio, LocalDate dataFine)
    {
        Gita gita = new Gita();
        gita.setId(id);
        gita.setIdDocente(idDocente);
        gita.setLuogo(luogo);
        gita.setDataInizio(dataInizio);
        gita.setDataFine(dataFine);

        gitaRepository.createGita(gita);
    }

    public List<Gita> readGita()
    {
        return gitaRepository.readGita();
    }

    public void deleteGita(int id)
    {
        Gita gita = new Gita();
        gita.setId(id);

        gitaRepository.deleteGita(gita);
    }
}
