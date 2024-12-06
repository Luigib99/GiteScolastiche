package Service;

import Entity.Classe;
import Repository.ClasseRepository;
import java.util.List;

public class ClasseService {

    ClasseRepository classeRepository = new ClasseRepository();

    public void createClasse(String sezione, int idDocente)
    {
        Classe classe = new Classe();
        classe.setIdDocente(idDocente);
        classe.setSezione(sezione);
        classeRepository.createClasse(classe);
    }

    public void updateClasse(int id, String sezione, int idDocente)
    {
        Classe classe = new Classe();
        classe.setId(id);
        classe.setIdDocente(idDocente);
        classe.setSezione(sezione);
        classeRepository.updateClasse(classe);
    }

    public List<Classe> readClasse()
    {
        return classeRepository.readClasse();
    }

    public void deleteClasse(int id)
    {
        Classe classe = new Classe();
        classe.setId(id);

        classeRepository.deleteClasse(classe);
    }
}
