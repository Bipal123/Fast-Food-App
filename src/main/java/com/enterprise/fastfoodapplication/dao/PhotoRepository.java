package com.enterprise.fastfoodapplication.dao;

import com.enterprise.fastfoodapplication.dto.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}