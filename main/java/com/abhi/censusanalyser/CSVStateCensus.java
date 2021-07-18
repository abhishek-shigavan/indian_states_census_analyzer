package com.abhi.censusanalyser;

import com.opencsv.bean.CsvBindByName;
/**
 * CSVStateCensus  -  Creating binding between a column name of the CSV input and a field in a bean
 *
 * @author Abhishek Shigavan
 */
public class CSVStateCensus {
        @CsvBindByName(column = "State", required = true)
        public String state;

        @CsvBindByName(column = "Population", required = true)
        public int population;

        @CsvBindByName(column = "AreaInSqKm", required = true)
        public int areaInSqKm;

        @CsvBindByName(column = "DensityPerSqKm", required = true)
        public int densityPerSqKm;

        @Override
        public String toString() {
                return "CSVStateCensus{" +
                        "state='" + state + '\'' +
                        ", population=" + population +
                        ", areaInSqKm=" + areaInSqKm +
                        ", densityPerSqKm=" + densityPerSqKm +
                        '}';
        }
}
