package com.abhi.censusanalyser;
/**
 * StateCodeAnalyserException --  Defining Custom Exception
 *
 * @author Abhishek Shigavan
 */
public class StateCodeAnalyserException extends Exception{
    public ErrorType errorType;

    enum ErrorType{
        CSV_FILE_PROBLEM, DATA_FORMAT_PROBLEM
    }

    public StateCodeAnalyserException(String message, ErrorType errorType){
        super(message);
        this.errorType = errorType;
    }
}
