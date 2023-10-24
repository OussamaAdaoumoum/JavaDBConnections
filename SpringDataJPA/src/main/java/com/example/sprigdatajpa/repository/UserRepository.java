package com.example.sprigdatajpa.repository;

import com.example.sprigdatajpa.model.UserRecord;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserRecord, String> {

}
