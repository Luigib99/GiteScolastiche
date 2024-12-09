package Service;
import Entity.*;
import Repository.ViaggioRepository;

import java.util.List;

public class ViaggioService {
    ViaggioRepository viaggioRepository = new ViaggioRepository();
    public void createViaggio(int idGita, int idClasse)
    {
        Viaggio viaggio = new Viaggio();

        viaggio.setIdGita(idGita);
        viaggio.setIdClasse(idClasse);

        viaggioRepository.createViaggio(viaggio);
    }

    public void updateViaggio(int id, int idGita, int idClasse)
    {
        Viaggio viaggio = new Viaggio();

        viaggio.setId(id);
        viaggio.setIdGita(idGita);
        viaggio.setIdClasse(idClasse);

        viaggioRepository.updateViaggio(viaggio);
    }

    public List<Viaggio> readViaggio()
    {
        return viaggioRepository.readViaggio();
    }

    public void deleteViaggio(int id)
    {
        Viaggio viaggio = new Viaggio();
        viaggio.setId(id);
        viaggioRepository.deleteViaggio(viaggio);
    }
}
