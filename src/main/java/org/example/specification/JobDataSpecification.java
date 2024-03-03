package org.example.specification;

import org.example.entity.JobDataEntity;
import org.example.model.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

public class JobDataSpecification {
    public static Specification<JobDataEntity> getSpec(List<SearchCriteria> searchCriteriaList){
        Specification<JobDataEntity> specification = Specification.where(null);
        for(var criteria: searchCriteriaList){
            String columnName = criteria.getSearchColumn().getColumn();
            Object value = criteria.getValue();
            switch (criteria.getComparator()){
                case EQ:
                    specification = specification.and(eq(columnName, value));
                    break;
                case LT:
                    specification = specification.and(lt(columnName, value));
                    break;
                case LTE:
                    specification = specification.and(lte(columnName, value));
                    break;
                case GT:
                    specification = specification.and(gt(columnName, value));
                    break;
                case GTE:
                    specification = specification.and(gte(columnName, value));
                    break;

            }
        }
        return specification;
    }

    private static Specification<JobDataEntity> gt(String column, Object value) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get(column), (Comparable) value);
    }

    private static Specification<JobDataEntity> gte(String column, Object value) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get(column), (Comparable) value);
    }

    private static Specification<JobDataEntity> lt(String column, Object value) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThan(root.get(column), (Comparable) value);
    }

    private static Specification<JobDataEntity> lte(String column, Object value) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get(column), (Comparable) value);
    }

    private static Specification<JobDataEntity> eq(String column, Object value) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(column), value);
    }

}
