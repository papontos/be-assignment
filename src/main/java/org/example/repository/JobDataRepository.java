package org.example.repository;

import org.example.entity.JobDataEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface JobDataRepository extends PagingAndSortingRepository<JobDataEntity, Long>, JpaSpecificationExecutor {
}
