package dal;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<E> {

    public void create(E object) throws SQLException;
    public List<E> findAll();
}
