package com.abhi.censusanalyser;

/**
 * StateCensusAnalyserException --  Defining Custom Exception
 *
 * @author Abhishek Shigavan
 */
public class StateCensusAnalyserException extends Exception {
    public ExceptionType exceptionType;

    enum ExceptionType {
        CSV_FILE_PROBLEM, DATA_FORMAT_PROBLEM
    }

    public StateCensusAnalyserException(String message, ExceptionType exceptionType){
        super(message);
        this.exceptionType = exceptionType;
    }
}
