package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {
    private final Map<Integer, T> storage = new HashMap<>();

    @Override
    public void add(T entity){
        if(storage.containsKey(entity.getId())){
            throw new IllegalArgumentException("Entity with the same ID already exists!");
        }
        storage.put(entity.getId(), entity);
    }

    @Override
    public void update(T entity){
        if(!storage.containsKey(entity.getId())){
            throw new IllegalArgumentException("Entity not found!");
        }
        storage.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id){
        if(!storage.containsKey(id)){
            throw new IllegalArgumentException("Entity not found!");
        }
        storage.remove(id);
    }

    @Override
    public T findById(int id){
        if(!storage.containsKey(id)){
            throw new IllegalArgumentException("Entity not found!");
        }
        return storage.get(id);
    }

    @Override
    public List<T> findAll(){
        return new ArrayList<>(storage.values());
    }
}
