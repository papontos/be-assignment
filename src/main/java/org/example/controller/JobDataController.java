package org.example.controller;

import org.example.entity.JobDataEntity;
import org.example.mapper.JobDataMapper;
import org.example.model.Comparator;
import org.example.model.JobDataResponse;
import org.example.model.SearchColumn;
import org.example.model.SearchCriteria;
import org.example.repository.JobDataRepository;
import org.example.specification.JobDataSpecification;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/job_data")
public class JobDataController {

    private final JobDataRepository jobDataRepository;
    private final JobDataMapper jobDataMapper;

    public JobDataController(JobDataRepository jobDataRepository, JobDataMapper jobDataMapper) {
        this.jobDataRepository = jobDataRepository;
        this.jobDataMapper = jobDataMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<JobDataResponse>> getJobData(@RequestParam Map<String, String> searchParams) {
        List<SearchCriteria> searchCriteria;
        Pageable pageable;
        try {
            searchCriteria = extractSearchCriteria(searchParams);
            pageable = extractPageable(searchParams);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }

        Specification<JobDataEntity> spec = JobDataSpecification.getSpec(searchCriteria);
        Page<JobDataEntity> jobDataEntities = jobDataRepository.findAll(spec, pageable);

        List<String> fields= null;
        if(searchParams.get("fields")!=null) {
            fields = List.of(searchParams.get("fields").split(","));
        }
        return ResponseEntity.ok(jobDataMapper.toResponse(jobDataEntities.getContent(), fields));
    }

    private static List<SearchCriteria> extractSearchCriteria(Map<String, String> searchParams){
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        Pageable pageable;
        String regex = "^(.*?)\\[(.*?)\\]$";
        Pattern pattern = Pattern.compile(regex);
        searchParams.keySet().stream().filter(item->{
            return item.contains("[")&&item.contains("]");
        }).forEach(item -> {
            Matcher matcher = pattern.matcher(item);
            if (matcher.find()) {
                var criteria = new SearchCriteria();
                String columnStr = matcher.group(1);
                String comparatorStr = matcher.group(2);
                criteria.setComparator(Comparator.fromString(comparatorStr));
                criteria.setSearchColumn(SearchColumn.fromString(columnStr));
                criteria.setValue(searchParams.get(item));
                searchCriteria.add(criteria);
            }
        });
        return searchCriteria;
    }

    private static Pageable extractPageable(Map<String, String> searchParams){
        Pageable pageable;
        var sortColumn = searchParams.get("sort");
        if(StringUtils.hasText(sortColumn)){
            int _idx = sortColumn.indexOf("_");
            sortColumn = convertToCamelCase(sortColumn);
            var sortType = searchParams.get("sort_type");
            Sort.Direction direction = StringUtils.hasText(sortType)?Sort.Direction.fromString(sortType): Sort.Direction.ASC;

            pageable = PageRequest.of(0,
                    999999,
                    direction,
                    sortColumn
            );
        }else{
            pageable = Pageable.unpaged();
        }
        return pageable;
    }

    private static String convertToCamelCase(String input) {
        StringBuilder result = new StringBuilder();

        boolean capitalizeNext = false;

        for (char c : input.toCharArray()) {
            if (c == '_') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

}
