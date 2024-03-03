package org.example.mapper;

import org.example.entity.JobDataEntity;
import org.example.model.JobDataResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobDataMapper {

    public Page<JobDataResponse> toResponse(Page<JobDataEntity> entities, List<String> fields) {
        return new PageImpl<JobDataResponse>(
                toResponse(entities.getContent(), fields),
                entities.getPageable(),
                entities.getNumberOfElements());
    }

    public List<JobDataResponse> toResponse(List<JobDataEntity> entities, List<String> fields) {
        return entities.stream().map(item -> toResponse(item, fields)).collect(Collectors.toList());
    }

    public List<JobDataResponse> toResponse(List<JobDataEntity> entities) {
        return toResponse(entities, null);
    }

    public JobDataResponse toResponse(JobDataEntity jobDataEntity, List<String> fields) {
        JobDataResponse rs = new JobDataResponse();
        if (fields == null || fields.contains("timestamp")) {
            rs.setTimestamp(jobDataEntity.getTimestamp());
        }
        if (fields == null || fields.contains("employer")) {
            rs.setEmployer(jobDataEntity.getEmployer());
        }
        if (fields == null || fields.contains("location")) {
            rs.setLocation(jobDataEntity.getLocation());
        }
        if (fields == null || fields.contains("job_title")) {
            rs.setJobTitle(jobDataEntity.getJobTitle());
        }
        if (fields == null || fields.contains("years_at_employer")) {
            rs.setYearsAtEmployer(jobDataEntity.getYearsAtEmployer());
        }
        if (fields == null || fields.contains("years_of_experience")) {
            rs.setYearsOfExperience(jobDataEntity.getYearsOfExperience());
        }
        if (fields == null || fields.contains("salary")) {
            rs.setSalary(jobDataEntity.getSalary());
        }
        if (fields == null || fields.contains("signing_bonus")) {
            rs.setSigningBonus(jobDataEntity.getSigningBonus());
        }
        if (fields == null || fields.contains("annual_stock_value_bonus")) {
            rs.setAnnualStockValueBonus(jobDataEntity.getAnnualStockValueBonus());
        }
        if (fields == null || fields.contains("gender")) {
            rs.setGender(jobDataEntity.getGender());
        }
        if (fields == null || fields.contains("additional_comments")) {
            rs.setAdditionalComments(jobDataEntity.getAdditionalComments());
        }
        return rs;
    }

}
