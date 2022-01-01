package orm;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {

    private final Connection conn;

    private final UserMapper userMapper;

    private final List<User> newUsers = new ArrayList<>();
    private final List<User> updateUsers = new ArrayList<>();
    private final List<User> deleteUsers = new ArrayList<>();

    public UnitOfWork(Connection conn, UserMapper userMapper) {
        this.conn = conn;
        this.userMapper = userMapper;
    }

    public void registerNew(User user) {
        this.newUsers.add(user);
    }

    public void registerUpdate(User user) {
        this.updateUsers.add(user);
    }

    public void registerDelete(User user) {
        this.deleteUsers.add(user);
    }

    public void commit() {
        insert();
        update();
        delete();
    }

    private void update() {
        for (User user : updateUsers){
            userMapper.updateUser(user);
        }
    }

    private void insert() {
        for (User user : newUsers){
            userMapper.insertUser(user);
        }
    }

    private void delete() {
        for (User user: deleteUsers) {
            userMapper.deleteById(user);
        }
   }
}
