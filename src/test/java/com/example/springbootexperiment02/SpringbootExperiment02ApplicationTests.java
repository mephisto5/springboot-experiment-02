package com.example.springbootexperiment02;

import com.example.springbootexperiment02.entity.Address;
import com.example.springbootexperiment02.entity.User;
import com.example.springbootexperiment02.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootExperiment02ApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void contextLoads() {
        /*User user1=new User("user1");
        userRepository.addUser(user1);
        User user2=new User("user2");
        userRepository.addUser(user2);
        User user3=new User("user3");
        userRepository.addUser(user3);
        Address address1=new Address("001");*/

        /*userRepository.addAddress(address1, 1);
        Address address2=new Address("002");
        userRepository.addAddress(address2, 1);
        Address address3=new Address("003");
        userRepository.addAddress(address3, 2);
        Address address4=new Address("004");
        userRepository.addAddress(address4, 3);
        Address address5=new Address("005");
        userRepository.addAddress(address5, 3);*/

        /*userRepository.updateUser(1, "newuser");*/

        /*userRepository.updateAddress(4, 2);*/

        /*userRepository.removeAddress(4);*/

        userRepository.removeUser(2);
    }

}
