package com.maximopol.driveopol.service;

import com.maximopol.driveopol.entity.Client;
import com.maximopol.driveopol.entity.test.Role;
import com.maximopol.driveopol.repository.ClientRepository;
import com.maximopol.driveopol.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    ClientRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client user = userRepository.findClientByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        else{
            System.out.println("нашли");
        }

        return user;
    }

    public Client findUserById(Long userId) {
        Optional<Client> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new Client());
    }

    public Client findClientByNameAndSurname(String name, String surname) {
        return userRepository.findClientByNameAndSurname(name, surname);
    }

    public List<Client> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(Client user) {
        Client userFromDB = userRepository.findClientByEmail(user.getEmail());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<Client> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM Client u WHERE u.id > :paramId", Client.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
