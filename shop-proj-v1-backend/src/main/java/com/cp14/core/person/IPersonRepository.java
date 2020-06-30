package com.cp14.core.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IPersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person>{

}
