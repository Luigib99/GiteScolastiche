package Service;

import Entity.*;
import Repository.QueryRepository;
import java.util.List;

public class QueryService {

    QueryRepository queryRepository = new QueryRepository();

    public List<Viaggio> query1(int idGita)
    {
        return queryRepository.query1(idGita);
    }

    public List<Viaggio> query2(int idDocente)
    {
        return queryRepository.query2(idDocente);
    }

    public List<Classe> query3()
    {
        return queryRepository.query3();
    }

    public List<Viaggio> query4()
    {
        return queryRepository.query4();
    }
}
