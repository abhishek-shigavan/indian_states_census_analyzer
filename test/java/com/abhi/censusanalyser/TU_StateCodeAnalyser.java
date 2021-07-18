package com.abhi.censusanalyser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static com.abhi.censusanalyser.StateCodeAnalyserException.ErrorType.DATA_FORMAT_PROBLEM;
import static com.abhi.censusanalyser.StateCodeAnalyserException.ErrorType.CSV_FILE_PROBLEM;
/**
 * TU_StateCodeAnalyser -- Defining test methods for all the operations performed
 *                         to check all operations works correct / not
 *
 * @author Abhishek Shigavan
 */
public class TU_StateCodeAnalyser {
    //Defining files path
    private static final String STATE_CENSUS_CSV_FILE_PATH = "./src/test/resources/StateCode.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/StateCensusData.csv";
    private static final String WRONG_FILE_EXTENSION = "./src/test/resources/StateCode.txt";
    private static final String WRONG_DELIMITER_IN_DATA = "./src/test/resources/StateCodeWrongDelimeter.csv";
    private static final String WRONG_HEADER_IN_DATA = "./src/test/resources/StateCodeWrongHeader.csv";
    /**
     * This method checks the no of records return after reading csv file are matches with
     * expected no of records / not
     */
    @Test
    void whenCorrectCSVFileIsGiven_ShouldReturnNoOfRecords() {
        try {
            StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
            int count = stateCodeAnalyser.loadStatesCodeData(STATE_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(37,count);
        }catch (StateCodeAnalyserException e){
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file of incorrect path of file is given
     */
    @Test
    void whenIncorrectPathOfCSVFileIsGiven_ShouldReturn_CustomException() {
        try {
            StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
            int count = stateCodeAnalyser.loadStatesCodeData(WRONG_CSV_FILE_PATH);
        }catch (StateCodeAnalyserException e){
            Assert.assertEquals(CSV_FILE_PROBLEM,e.errorType);
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file of incorrect type is given
     */
    @Test
    void whenCSVFileOfIncorrectTypeIsGiven_ShouldReturn_CustomException() {
        try {
            StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
            int count = stateCodeAnalyser.loadStatesCodeData(WRONG_FILE_EXTENSION);
        }catch (StateCodeAnalyserException e){
            Assert.assertEquals(CSV_FILE_PROBLEM,e.errorType);
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file with wrong delimiter is given
     */
    @Test
    void whenCSVFileWithWrongDelimiterIsGiven_ShouldReturn_CustomException() {
        try {
            StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
            int count = stateCodeAnalyser.loadStatesCodeData(WRONG_DELIMITER_IN_DATA);
        }catch (StateCodeAnalyserException e){
            Assert.assertEquals(DATA_FORMAT_PROBLEM,e.errorType);
        }
    }
    /**
     * This method checks thrown exception matches with expected custom exception or / not
     * when file with wrong header is given
     */
    @Test
    void whenCSVFileWithWrongHeaderIsGiven_ShouldReturn_CustomException() {
        try {
            StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
            int count = stateCodeAnalyser.loadStatesCodeData(WRONG_HEADER_IN_DATA);
        }catch (StateCodeAnalyserException e){
            Assert.assertEquals(DATA_FORMAT_PROBLEM,e.errorType);
        }
    }
}
