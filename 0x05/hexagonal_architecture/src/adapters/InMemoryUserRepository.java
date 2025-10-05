package adapters;

import domain.User;
import ports.UserRepository;
import java.util.*;


public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> database = new HashMap<>();


    public void save(User user)
    {
        this.database.merge(user.getId(), user, (oldUser, newUser) -> newUser);
    }

    public User findById(String id)
    {
        return this.database.get(id);
    }

    public List<User> findAll()
    {
        return this.database.values().stream().toList();
    }
}
