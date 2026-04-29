package com.radkevich.repository.impl;

import com.radkevich.entity.CustomArray;
import com.radkevich.exeption.RepositoryException;
import com.radkevich.obsrver.CustomArrayObserver;
import com.radkevich.obsrver.impl.CustomArrayObserverImpl;
import com.radkevich.repository.CustomArrayRepository;
import com.radkevich.specification.CustomArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;


public class CustomArrayRepositoryImpl implements CustomArrayRepository {
    private static final Logger log = LogManager.getLogger(CustomArrayRepositoryImpl.class);
    private static CustomArrayRepositoryImpl instance;
    private final Map<Long, CustomArray> storage = new HashMap<>();
    private final List<CustomArray> result = new ArrayList<>();
    private final CustomArrayObserver observer = new CustomArrayObserverImpl();

    private CustomArrayRepositoryImpl() {
    }

    public static CustomArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }


    @Override
    public Optional<CustomArray> get(Long id) {
// Returns the statistics for the given ID If the ID is not found or is null, returns Optional.empty
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void add(CustomArray array) throws RepositoryException {
        long id = array.getId();
        if (array == null) {
            throw new RepositoryException("CustomArray array object cannot be null");
        }

        if (isPresent(array.getId())) {
            throw new RepositoryException("CustomArray array for ID " + id + " already exists");
        }
        storage.put(id, array);
        array.attach(observer);
        log.info("Array with ID {} added to repository", id);

    }


    @Override
    public void update(CustomArray array) throws RepositoryException {
        long id = array.getId();
        if (array == null) {
            throw new RepositoryException("Statistics object cannot be null");
        }

        if (!storage.containsKey(id)) {
            throw new RepositoryException("Statistics for ID " + id + " does not exist");
        }
        storage.put(id, array);
        array.attach(observer);
        log.info("Updated in repository: ID={}", array.getId());
    }


    @Override
    public void remove(Long id) throws RepositoryException {
        if (!isPresent(id)) {
            throw new RepositoryException("ID " + id + " does not exist");
        }
        CustomArray array = storage.remove(id);
        array.detach(observer);
        log.info("Removed from repository: ID={}", id);

    }

    @Override
    public boolean isPresent(Long id) {
        return storage.containsKey(id);
    }

    @Override
    public List<CustomArray> query(CustomArraySpecification specification) {
        return storage.values().stream().filter(specification::specify).collect(Collectors.toList());
    }
}



