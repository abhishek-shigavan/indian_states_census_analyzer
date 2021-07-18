package com.abhi.censusanalyser;

import com.opencsv.bean.CsvBindByName;
/**
 * CSVStates  -  Creating binding between a column name of the CSV input and a field in a bean
 *
 * @author Abhishek Shigavan
 */
public class CSVStates {
    @CsvBindByName(column = "SrNo", required = true)
    public int srNo;

    @CsvBindByName(column = "StateName", required = true)
    public String stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    @Override
    public String toString() {
        return "CSVStates{" +
                "SrNo = '" + srNo + '\'' +
                ", State Name = '" + stateName + '\'' +
                ", TIN = " + tin +
                ", State Code = " + stateCode +
                '}';
    }
}
