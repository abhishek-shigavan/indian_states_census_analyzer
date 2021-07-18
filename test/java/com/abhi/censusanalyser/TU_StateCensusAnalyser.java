package com.abhi.censusanalyser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static com.abhi.censusanalyser.StateCensusAnalyserException.ExceptionType.CSV_FILE_PROBLEM;
import static com.abhi.censusanalyser.StateCensusAnalyserException.ExceptionType.DATA_FORMAT_PROBLEM;
/**
 * TU_StateCensusAnalyser -- Defining test methods for all the operations performed
 *                           to check all operations works correct / not
 *
 * @author Abhishek Shigavan
 */
public class TU_StateCensusAnalyser {
    //Defining files path
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/StateCensusData.csv";
    private static final String WRONG_FILE_EXTENSION = "./src/test/resources/StateCensusData.txt";
    private static final String WRONG_DELIMITER_IN_DATA = "./src/test/resources/StateCensusDataWrongDelimiter.csv";
    private static final String WRONG_HEADER_IN_DATA = "./src/test/resources/StateCensusDataWrongHeader.csv";
    /**
     * This method checks the no of records return after reading csv file are matches with
     * expected no of records / not
     */
    @Test
    void whenCorrectCSVFileIsGiven_ShouldReturnNoOfRecords() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int count = stateCensusAnalyser.loadIndianCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(27,count);
        }catch (StateCensusAnalyserException e){
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file of incorrect path of file is given
     */
    @Test
    void whenIncorrectPathOfCSVFileIsGiven_ShouldReturn_CustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int count = stateCensusAnalyser.loadIndianCensusData(WRONG_CSV_FILE_PATH);
        }catch (StateCensusAnalyserException e){
            Assert.assertEquals(CSV_FILE_PROBLEM,e.exceptionType);
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file of incorrect type is given
     */
    @Test
    void whenCSVFileOfIncorrectTypeIsGiven_ShouldReturn_CustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int count = stateCensusAnalyser.loadIndianCensusData(WRONG_FILE_EXTENSION);
        }catch (StateCensusAnalyserException e){
            Assert.assertEquals(CSV_FILE_PROBLEM,e.exceptionType);
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file with wrong delimiter is given
     */
    @Test
    void whenCSVFileWithWrongDelimiterIsGiven_ShouldReturn_CustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int count = stateCensusAnalyser.loadIndianCensusData(WRONG_DELIMITER_IN_DATA);
        }catch (StateCensusAnalyserException e){
            Assert.assertEquals(DATA_FORMAT_PROBLEM,e.exceptionType);
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file with wrong header is given
     */
    @Test
    void whenCSVFileWithWrongHeaderIsGiven_ShouldReturn_CustomException() {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            int count = stateCensusAnalyser.loadIndianCensusData(WRONG_HEADER_IN_DATA);
        }catch (StateCensusAnalyserException e){
            Assert.assertEquals(DATA_FORMAT_PROBLEM,e.exceptionType);
        }
    }
}
