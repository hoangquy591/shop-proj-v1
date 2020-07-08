package com.cp14.core.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICatalogRepository extends JpaRepository<Catalog, Long>, JpaSpecificationExecutor<Catalog>{

}
