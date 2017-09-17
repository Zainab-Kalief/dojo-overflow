package com.wura.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wura.dojoOverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
