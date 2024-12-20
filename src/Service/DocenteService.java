package Service;
import Entity.Docente;
import Repository.DocenteRepository;
import java.util.List;

public class DocenteService {
    DocenteRepository docenteRepository = new DocenteRepository();

    public void createDocente(String nome, String cognome)
    {
        Docente docente = new Docente();
        docente.setNome(nome);
        docente.setCognome(cognome);
        docenteRepository.createDocente(docente);
    }

    public void updateDocente(int id, String nome, String cognome)
    {
        Docente docente = new Docente();
        docente.setId(id);
        docente.setNome(nome);
        docente.setCognome(cognome);
        docenteRepository.updateDocente(docente);
    }

    public List<Docente> readDocente()
    {
        return docenteRepository.readDocente();
    }

    public void deleteDocente(int id)
    {
        Docente docente = new Docente();
        docente.setId(id);
        docenteRepository.deleteDocente(docente);
    }
}
