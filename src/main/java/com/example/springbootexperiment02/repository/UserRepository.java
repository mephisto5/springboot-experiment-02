package com.example.springbootexperiment02.repository;
import com.example.springbootexperiment02.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Repository
@Transactional
@Slf4j
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    /**
     * 添加用户，并返回包括数据库时间戳的用户对象
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        em.persist(user);
        return user;
    }

    /**
     * 添加地址，并指定地址对应的用户
     *
     * @param address
     * @param uid
     * @return
     */
    public Address addAddress(Address address, int uid) {
        User u = em.find(User.class, uid);
        address.setUser(u);
        em.persist(address);
        return address;
    }
    /**
     * 更新指定ID用户的姓名
     * @param uid
     * @param newName
     * @return
     */
    public User updateUser(int uid, String newName) {
        User u1 = new User();
        u1.setId(uid);
        User u2 = em.merge(u1);
        u2.setName(newName);
        return u2;
        /*find方法实现
        User u=em.find(User.class, uid);
        em.persist(u);
        u.setName(newName);
        return u;*/
    }
    /**
     * 尝试使用merge()，以及find()2种方法分别实现
     * 更新指定地址为指定用户
     * @param aid
     * @param uid
     * @return
     */
    public Address updateAddress(int aid, int uid) {
        Address address = new Address();
        address.setId(aid);
        Address address1 = em.merge(address);
        em.refresh(address1);
        //System.out.println("地址数据:"address1.getAd() + " " + address1.getId());
        User user1 = new User();
        user1.setId(uid);
        User user2 = em.merge(user1);
        em.refresh(user2);
        address1.setUser(user2);
        return address1;
        /*find方法实现
        Address address=em.find(Address.class, aid);
        User user=em.find(User.class, uid);
        address.setUser(user);
        return address;*/
    }
    /**
     * 返回指定用户的全部地址，没有返回空集合，而非null
     * @param uid
     * @return
     */
    public List<Address> listAddresses(int uid) {
        List<Address> list= em.find(User.class, uid).getAddresses();
        /*for(Address address:list){
            System.out.println("address:"+address.getAd());
        }*/
        List.of(list);
        return list;
    }

    public void removeAddress(int aid) {
        Address address=em.find(Address.class, aid);
        em.remove(address);
    }

    /**
     * 删除用户，设置级联操作或手动删除相关地址
     * @param uid
     */
    public void removeUser(int uid) {
        User user=em.find(User.class, uid);
        em.remove(user);
    }

}
