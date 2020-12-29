package com.viviamjimenez.ds.chicagoanalysis;

import com.viviamjimenez.ds.chicagoanalysis.model.Worker;

public class Facts {

    private Worker[] workers;


    public Facts(Worker[] workers) {
        this.workers = workers;
//        this.getHigherPaidWorker();
//        this.getHigherPaidPartTimePosition();
//        this.getAverageSalaryForPartTimeWorkers();
        this.getDepartmentWithHigherSalary();
        this.getFiveHigherPaidWorker();
        this.getJobTitleAnnualSalaryAverage();
        this.getHigherPaidPartTimeJobTitle();
        this.getDepartmentWithLowerSalary();
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

    public void getFiveHigherPaidWorker(){
        Worker higherPaid1 = workers[0]; Worker higherPaid2 = workers[0]; Worker higherPaid3 = workers[0];
        Worker higherPaid4 = workers[0]; Worker higherPaid5 = workers[0];
        for(int index = 0; index < this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() > higherPaid1.getAnnualSalary()){
                higherPaid1 = this.workers[index];
            }else if(this.workers[index].getAnnualSalary() > higherPaid2.getAnnualSalary()){
                higherPaid2 = this.workers[index];
            }else if(this.workers[index].getAnnualSalary() > higherPaid3.getAnnualSalary()){
                higherPaid3 = this.workers[index];
            }else if(this.workers[index].getAnnualSalary() > higherPaid4.getAnnualSalary()){
                higherPaid4 = this.workers[index];
            }else if(this.workers[index].getAnnualSalary() > higherPaid5.getAnnualSalary()){
                higherPaid5 = this.workers[index];
            }
        }
        System.out.println('\n'+"The top 5 employees with the highest annual salary are:");
        System.out.println(higherPaid1.getName()+" " +higherPaid1.getLastname());
        System.out.println(higherPaid2.getName()+" " +higherPaid2.getLastname());
        System.out.println(higherPaid3.getName()+" " +higherPaid3.getLastname());
        System.out.println(higherPaid4.getName()+" " +higherPaid4.getLastname());
        System.out.println(higherPaid5.getName()+" " +higherPaid5.getLastname());
    }



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

        Worker higherPaidJobTitle = workers[0];
        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() > higherPaidJobTitle.getAnnualSalary()){
                higherPaidJobTitle = this.workers[index];
            }
        }

        System.out.println('\n'+"The average annual salary for the city of Chicago is:");
        System.out.println(+totalAnnualSalaries/amountOfWorkers);

        System.out.println("The jobtitle with the higher salary per year is");
        System.out.println(higherPaidJobTitle.getJobTitle());
    }

    /**
     * 4. ¿Cuál puesto con jornada de medio tiempo gana más dinero al año?
     */

    public void getHigherPaidPartTimeJobTitle(){
        Worker higherPaidPartTimeJobTitle = null;

        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].isPartTime() && (higherPaidPartTimeJobTitle==null || this.workers[index].getAnnualSalary() >
                    higherPaidPartTimeJobTitle.getAnnualSalary())){
                higherPaidPartTimeJobTitle = this.workers[index];
            }
        }
        System.out.println('\n'+"The part time job title with the higher annual salary is");
        System.out.println(higherPaidPartTimeJobTitle.getJobTitle());
    }

    /**
     * 5. ¿Cuáles son los 5 departamentos con menor gasto por año?
     */

    public void getDepartmentWithLowerSalary(){
        Worker lowerPaidDept = workers[0];
        int index1=0;

        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() < lowerPaidDept.getAnnualSalary()){
                lowerPaidDept = this.workers[index];
                index1 = index;
            }
        }

        Worker lowerPaidDept2 = workers[0];
        int index2=0;

        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() < lowerPaidDept2.getAnnualSalary()
                   && (index != index1)){
                lowerPaidDept2 = this.workers[index];
                index2 = index;
            }
        }

        Worker lowerPaidDept3 = workers[0];
        int index3=0;

        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() < lowerPaidDept3.getAnnualSalary()
                    && this.workers[index].getAnnualSalary() != lowerPaidDept2.getAnnualSalary()
                    && index != index1 && index != index2 ){
                lowerPaidDept3 = this.workers[index];
                index3 = index;
            }
        }

        Worker lowerPaidDept4 = workers[0];
        int index4=0;

        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() < lowerPaidDept4.getAnnualSalary()
                    && this.workers[index].getAnnualSalary() != lowerPaidDept3.getAnnualSalary()
                    && this.workers[index].getAnnualSalary() != lowerPaidDept2.getAnnualSalary()
                    && index != index1 && index != index2 && index != index3 ){
                lowerPaidDept4 = this.workers[index];
                index4 = index;
            }
        }

        Worker lowerPaidDept5 = workers[0];
        int index5=0;

        for (int index=0; index<this.workers.length; ++index){
            if(this.workers[index].getAnnualSalary() < lowerPaidDept5.getAnnualSalary()
                    && this.workers[index].getAnnualSalary() != lowerPaidDept4.getAnnualSalary()
                    && this.workers[index].getAnnualSalary() != lowerPaidDept3.getAnnualSalary()
                    && this.workers[index].getAnnualSalary() != lowerPaidDept2.getAnnualSalary()
                    && index != index1 && index != index2 && index != index3 && index != index4 ){
                lowerPaidDept5 = this.workers[index];
                index5 = index;
            }
        }

        System.out.println('\n'+"The departments with the lower salary per year is");
        System.out.println(lowerPaidDept.getDepartment());
        System.out.println(lowerPaidDept2.getDepartment());
        System.out.println(lowerPaidDept3.getDepartment());
        System.out.println(lowerPaidDept4.getDepartment());
        System.out.println(lowerPaidDept5.getDepartment());

    }


}
