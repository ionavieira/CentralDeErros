package br.com.codenation.service;

import br.com.codenation.model.User;
import br.com.codenation.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(UUID id){
        return userRepository.findById(id);
    }

    public void delete(UUID id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setActive(false);
            save(user.get());
        }
    }
}
