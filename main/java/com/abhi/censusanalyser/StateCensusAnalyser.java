package com.abhi.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * StateCensusAnalyser  --  Reading the Indian states census data
 *
 * @author Abhishek Shigavan
 */
public class StateCensusAnalyser {
    /**
     * This method reads the given csv file & return no of records csv file contains
     *
     * @param csvFilePath -- path of csv file
     * @return numOfEntries -- no of records of csv file
     * @throws StateCensusAnalyserException
     */
    public int loadIndianCensusData(String csvFilePath) throws StateCensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVStateCensus.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
            Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                censusCSVIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            throw new StateCensusAnalyserException(e.getMessage(),
                    StateCensusAnalyserException.ExceptionType.CSV_FILE_PROBLEM);
        } catch (RuntimeException e){
            throw new StateCensusAnalyserException(e.getMessage(),
                    StateCensusAnalyserException.ExceptionType.DATA_FORMAT_PROBLEM);
        }
    }
}
