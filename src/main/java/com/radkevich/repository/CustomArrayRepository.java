package com.radkevich.repository;

import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.RepositoryException;
import com.radkevich.specification.CustomArraySpecification;


import java.util.List;
import java.util.Optional;

public interface CustomArrayRepository {
    List<CustomArray> query(CustomArraySpecification specification);
    Optional<CustomArray> get(Long id);

    void add(CustomArray array) throws RepositoryException;


    void update(CustomArray array) throws RepositoryException;


    void remove(Long id) throws RepositoryException;

    boolean isPresent(Long id);


}
