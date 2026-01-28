import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Demonstrates reading data from a CSV file using Scanner
 * Creates an ArrayList of Country objects
 * Week 4: ArrayList + Scanner + File I/O
 */
public class LifeExpectancyAnalyzer {
    private ArrayList<Country> countries;

    /**
     * Constructor initializes an empty ArrayList
     */
    public LifeExpectancyAnalyzer() {
        countries = new ArrayList<Country>();
    }

    /**
     * Reads country data from a CSV file and populates the ArrayList
     * CSV format: country,region,population,income_group,life_expectancy_2010,life_expectancy_2015,life_expectancy_2020
     * 
     * @param filename path to the CSV file
     * @throws IOFoundException if the file is not found
     */
    public void readFromFile(String filename) throws IOException{
        Scanner scanner = new Scanner(new File(filename));
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] items = line.split(",");
            Country temp = new Country(items[0], 
                items[1], 
                Integer.parseInt(items[2]), 
                items[3], 
                Double.parseDouble(items[4]), 
                Double.parseDouble(items[5]), 
                Double.parseDouble(items[6]));
                countries.add(temp);
        }
        
        System.out.println(countries.size());
        scanner.close();
    }

    /**
     * Display all countries in the list
     */
    public void displayAllCountries() {
        for(Country c: countries){
            System.out.println(c.getName());
        }
    }

    /**
     * Display countries from a specific region
     * @param region the region to filter by
     */
    public void displayByRegion(String region) {
        for(Country c: countries){
            if(c.getRegion().equals(region)){
                System.out.println(c.getName());
            }
        }
    }

    /**
     * Find the country with the highest life expectancy in 2020
     * @return the Country with the highest life expectancy, or null if list is empty
     */
    public Country findHighestLifeExpectancy() {
    if(countries.size() != 0){
    Country max = countries.get(0);
       for(Country c: countries){
        if(c.getLifeExpectancy2020() > max.getLifeExpectancy2020());
        max = c;
       }
       return max;
    }
    return null;
}

    /**
     * Find the country with the lowest life expectancy in 2020
     * @return the Country with the lowest life expectancy, or null if list is empty
     */
    public Country findLowestLifeExpectancy() {
        if(countries.size() != 0){
        Country min = countries.get(0);
       for(Country c: countries){
        if(c.getLifeExpectancy2020() < min.getLifeExpectancy2020());
        min = c;
       }
       return min;
    }
    return null;
}

    /**
     * Calculate the average life expectancy across all countries
     * @return average life expectancy in 2020, or 0 if list is empty
     */
    public double calculateAverageLifeExpectancy() {
        double totalLifeExpectancy = 0;
        if(countries.size() != 0){
            for(Country c: countries){
                totalLifeExpectancy += c.getLifeExpectancy2020();
            }
            return totalLifeExpectancy/countries.size();
        }
        return 0;
    }

    /**
     * Count how many countries are in a specific income group
     * @param incomeGroup the income group to count
     * @return number of countries in that income group
     */
    public int countByIncomeGroup(String incomeGroup) {
        int count = 0;
        for(Country c: countries){
            if(c.getIncomeGroup().equals(incomeGroup)){
                count++;
            }
        }
        return count;
    }

    /**
     * Find the country with the most improvement in life expectancy (2010 to 2020)
     * @return the Country with the largest improvement, or null if list is empty
     */
    public Country findMostImprovement() {
        if(countries.size() != 0){
        Country most = countries.get(0);
        for(Country c: countries){
            if(c.getChange2010To2020() > most.getChange2010To2020());
            most = c;
        }
        return most;
    }
    return null;
    }

    /**
     * Display summary statistics
     */
    public void displayStatistics() {
        for(Country c: countries){
            System.out.println(c);
        }
    }

}
