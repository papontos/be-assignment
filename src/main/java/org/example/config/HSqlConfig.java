package org.example.config;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.entity.JobDataEntity;
import org.example.repository.JobDataRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.util.StringUtils;

import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Configuration
public class HSqlConfig {

    private final JobDataRepository jobDataRepository;

    public HSqlConfig(JobDataRepository jobDataRepository) {
        this.jobDataRepository = jobDataRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void prepareData() throws Exception {
        var file = HSqlConfig.class.getResourceAsStream("/data/salary_survey-3.csv");
        try (Reader reader = new InputStreamReader(file)) {
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); // Skip header line

            // Process each row and save to the database
            List<String[]> rows = csvReader.readAll();
            List<JobDataEntity> jobDataEntities = new ArrayList<>();
            for (String[] row : rows) {
                JobDataEntity jobDataEntity = new JobDataEntity();
                // Assuming the order of columns in the CSV matches the order in JobDataEntity
                jobDataEntity.setTimestamp(parseTimestamp(row[0]));  // You need to implement parseTimestamp
                jobDataEntity.setEmployer(row[1]);
                jobDataEntity.setLocation(row[2]);
                jobDataEntity.setJobTitle(row[3]);
                jobDataEntity.setYearsAtEmployer(row[4]);
                jobDataEntity.setYearsOfExperience(row[5]);
                jobDataEntity.setSalary(row[6]);
                jobDataEntity.setSigningBonus(row[7]);
                jobDataEntity.setAnnualBonus(row[8]);
                jobDataEntity.setAnnualStockValueBonus(row[9]);
                jobDataEntity.setGender(row[10]);
                jobDataEntity.setAdditionalComments(row[11]);
                jobDataEntities.add(jobDataEntity);
            }
            jobDataRepository.saveAll(jobDataEntities);
        }
    }

    private Date parseTimestamp(String timeString) throws ParseException {
        if(hasText(timeString)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/DD/YY HH:mm");
            return simpleDateFormat.parse(timeString);
        }
        return null;
    }
}
