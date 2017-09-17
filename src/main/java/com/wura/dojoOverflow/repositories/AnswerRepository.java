package com.wura.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wura.dojoOverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

}
