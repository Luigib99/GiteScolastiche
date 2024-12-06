package Service;

import Entity.Gita;
import Repository.QueryRepository;
import java.util.List;

public class QueryService {

    QueryRepository queryRepository = new QueryRepository();
    public List<Gita> query1(int idGita)
    {
        return queryRepository.query1(idGita);
    }
}
