package com.abhi.censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * StateCodeAnalyser  --   Reading State code information
 *
 * @author Abhishek Shigavan
 */
public class StateCodeAnalyser {
    /**
     * This method reads the given csv file & return no of records csv file contains
     *
     * @param csvFilePath -- path of csv file
     * @return numOfEntries -- no of records of csv file
     * @throws StateCodeAnalyserException
     */
    public int loadStatesCodeData(String csvFilePath) throws StateCodeAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<CSVStates> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVStates.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVStates> csvToBean = csvToBeanBuilder.build();
            Iterator<CSVStates> statesCSVIterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (statesCSVIterator.hasNext()) {
                numOfEntries++;
                statesCSVIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            throw new StateCodeAnalyserException(e.getMessage(),
                    StateCodeAnalyserException.ErrorType.CSV_FILE_PROBLEM);
        } catch (RuntimeException e){
            throw new StateCodeAnalyserException(e.getMessage(),
                    StateCodeAnalyserException.ErrorType.DATA_FORMAT_PROBLEM);
        }
    }
}
