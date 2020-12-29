package com.viviamjimenez.ds.chicagoanalysis.model;

public class Worker extends Person {

    protected String jobTitle;
    protected String department;
    protected boolean isPartTime;
    protected boolean isHourly;
    protected int typicalAmountOfHours;
    protected double annualSalary;
    protected double hourlyRate;

    public Worker(final String name,
                  final String lastname,
                  final String jobTitle,
                  final String department,
                  final String isPartTime,
                  final String isHourly,
                  final String typicalAmountOfHours,
                  final String annualSalary,
                  final String hourlyRate) {
        super(name, lastname);
        this.jobTitle = jobTitle;
        this.department = department;
        this.isPartTime = this.parsePartTimeInput(isPartTime);
        this.isHourly = this.parseIsHourlyInput(isHourly);
        this.typicalAmountOfHours = this.parseTypicalAmountOfHoursInput(typicalAmountOfHours);
        this.annualSalary = this.parseAnnualSalaryInput(annualSalary);
        this.hourlyRate = this.parseHourlyRateInput(hourlyRate);
        this.computeAnnualSalaryForHourlyRate();
    }

    private void computeAnnualSalaryForHourlyRate(){
        if(this.isHourly){
            this.annualSalary=this.typicalAmountOfHours*52*this.hourlyRate;
        }
    }

    /**
     * @param name
     * @param lastname
     */

    public Worker(String name, String lastname) {
        super(name, lastname);
    }

    private boolean parsePartTimeInput(String partTimeColumnData){
        boolean isPartTime = false;
        if (partTimeColumnData.compareTo("P") == 0){
            isPartTime = true;
        }
        return isPartTime;
    }

    private boolean parseIsHourlyInput(String isHourlyColumnData){
        boolean isHourly = false;
        if (isHourlyColumnData.compareTo("Hourly")==0){
            isHourly = true;
        }
        return isHourly;
    }

    private int parseTypicalAmountOfHoursInput(String typicalAmountOfHoursColumnData) {
        int typicalAmountOfHours = 52;
        if (!typicalAmountOfHoursColumnData.isEmpty()) {
            try {
                typicalAmountOfHours = Integer.parseInt(typicalAmountOfHoursColumnData);
            } catch (NumberFormatException exc) {
//                exc.printStackTrace();
            }
        }
        return typicalAmountOfHours;
    }

    private double parseAnnualSalaryInput(String annualSalaryColumnData){
        double annualSalary = 0;
        if (!annualSalaryColumnData.isEmpty()){
            try {
                annualSalary= Double.parseDouble(annualSalaryColumnData);
            }
            catch (NumberFormatException exc){
//                exc.printStackTrace();
            }
        }
        return annualSalary;
    }

    private double parseHourlyRateInput(String hourlyRateColumnData){
        double hourlyRate = 0;
        if (hourlyRateColumnData.compareTo(" ") !=0){
            try{
                hourlyRate = Double.parseDouble(hourlyRateColumnData);
            }
            catch (NumberFormatException exc){
//                exc.printStackTrace();
            }
        }
        return hourlyRate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", isPartTime=" + isPartTime +
                ", isHourly=" + isHourly +
                ", typicalAmountOfHours=" + typicalAmountOfHours +
                ", annualSalary=" + annualSalary +
                ", hourlyRate=" + hourlyRate +

                '}';
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isPartTime() {
        return isPartTime;
    }

    public boolean isHourly() {
        return isHourly;
    }

    public int getTypicalAmountOfHours() {
        return typicalAmountOfHours;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }
}
