package com.wura.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wura.dojoOverflow.models.Question;
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
