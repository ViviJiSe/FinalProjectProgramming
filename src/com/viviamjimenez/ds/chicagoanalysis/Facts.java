package com.viviamjimenez.ds.chicagoanalysis;

import com.viviamjimenez.ds.chicagoanalysis.model.Worker;

public class Facts {

    private Worker[] workers;


    public Facts(Worker[] workers) {
        this.workers = workers;
//        this.getHigherPaidWorker();
//        this.getHigherPaidPartTimePosition();
//        this.getAverageSalaryForPartTimeWorkers();
//        this.getDepartmentWithHigherSalary();
//        this.getJobTitleAnnualSalaryAverage();
        this.getDepartments();
    }

    public void getHigherPaidWorker(){
        Worker higherPaid = workers[0];
        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() > higherPaid.getAnnualSalary()){
                higherPaid = this.workers[index];
            }
        }
        System.out.println("The employee with the higher salary is");
        System.out.println(higherPaid.toString());
    }

    public void getHigherPaidPartTimePosition(){
        Worker higherPaidPartTime = null;
        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].isPartTime() && (higherPaidPartTime==null || this.workers[index].getAnnualSalary() > higherPaidPartTime.getAnnualSalary())){
                higherPaidPartTime = this.workers[index];
            }
        }
        System.out.println("The part time employee with the higher salary is");
        System.out.println(higherPaidPartTime.toString());
    }

    public void getAverageSalaryForPartTimeWorkers() {
        int amountOfPartTimeWorkers = 0;
        double totalPartTimeSalaries = 0.0;
        for (Worker worker : workers) {
            if (worker.isPartTime()) {
                amountOfPartTimeWorkers++;
                totalPartTimeSalaries += worker.getAnnualSalary();
            }
        }
        System.out.println("The average salary of part time employees for the city of Chicago is:" +totalPartTimeSalaries/amountOfPartTimeWorkers);
    }


    /**
     * 1. ¿Cuál es el departamento más caro por año?
     */
    public void getDepartmentWithHigherSalary(){
        Worker higherPaidDept = workers[0];
        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() > higherPaidDept.getAnnualSalary()){
                higherPaidDept = this.workers[index];
            }
        }
        System.out.println("The department with the higher salary per year is");
        System.out.println(higherPaidDept.getDepartment());
    }

    /**
     * 2. ¿Cuáles son los 5 trabajadores que ganan más dinero por año?
     */

    /**
     * 3. ¿Cuál puesto gana más dinero al año en promedio?
     */

    public void getJobTitleAnnualSalaryAverage() {
        int amountOfWorkers = 0;
        double totalAnnualSalaries = 0.0;
        for (Worker worker : workers) {
                amountOfWorkers++;
                totalAnnualSalaries += worker.getAnnualSalary();
        }
        double salaryAverage = totalAnnualSalaries/amountOfWorkers;
        Worker annualAverageSalary = null;
        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() == totalAnnualSalaries/amountOfWorkers){
                annualAverageSalary = this.workers[index];
            }
        }

        System.out.println("The average annual salary for the city of Chicago is:" +totalAnnualSalaries/amountOfWorkers);
        System.out.println(annualAverageSalary.getJobTitle());
    }

    /**
     * 4. ¿Cuál puesto con jornada de medio tiempo gana más dinero al año?
     */


    /**
     * 5. ¿Cuáles son los 5 departamentos con menor gasto por año?
     */


    public void getDepartments(){
        for(Worker department : workers)
            System.out.println(department.getDepartment());
    }
}
