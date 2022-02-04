package com.revature.repositories;

import com.revature.models.User;

import java.util.List;

public interface GenericDAO<T> {
//    public E findByName(String name);
//    public E findById(int Id);
//    public void Insert(E entity);
//    public List<E> getAll(int Id);
//    public String getUsernameById(int id);
//    public String getStatusById(int id);
//                                          ask about these in the generic dao if i can change this or if it needs to stay the same
//    public List<E> getAllManager();
//    public void update(int ID,Timestamp resolved,int status,int resolver);
//}
    //Create
    T create(T t);

    //Read
    T getById(Integer id);

    List<T> getAll();

    //Update
    void update(T t);

    //Delete
    void delete(Integer id);

}

