package Controller;
import Service.QueryService;
import Entity.Gita;
import java.util.List;

public class QueryController {
    QueryService queryService = new queryService();

    private void query1()
    {
        List<Gita> listaGite = queryService.query1();
    }
}
