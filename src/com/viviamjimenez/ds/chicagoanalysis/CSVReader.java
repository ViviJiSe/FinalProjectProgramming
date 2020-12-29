package com.viviamjimenez.ds.chicagoanalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.viviamjimenez.ds.chicagoanalysis.model.ElasticWorkerArray;
import com.viviamjimenez.ds.chicagoanalysis.model.Person;
import com.viviamjimenez.ds.chicagoanalysis.model.Worker;


public class CSVReader {

    /**
     *
     * @param args
     */

    public static void main(String[] args) {

        String dataCsvFileLocation = "C:\\Users\\default.LAPTOP-P5L9CHB3\\OneDrive - LEAD University\\3er Cuatri 2020\\Progra\\ProyectoFinal\\data.csv";
        String csvSeparator =",";
        String line = "";

        ElasticWorkerArray workers = new ElasticWorkerArray();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataCsvFileLocation))){
            // Aca va a estar el código que lee el archivo y puede fallar

            while ((line = bufferedReader.readLine()) != null){
                line +=" ";
                String[] person = line.split(csvSeparator);
                Worker personObj = new Worker(
                        person[1],
                        person[0],
                        person[2],
                        person[3],
                        person[4],
                        person[5],
                        person[6],
                        person[7],
                        person[8]
                );
             workers.addWorker(personObj);
            }

            Facts fact = new Facts(workers.getWorkerArray());


        } //TRY ENDS

        catch (FileNotFoundException fileNotFoundException){
            System.out.println("The file provided is not valid");
        }

        catch (IOException ioException){
            // Acá vamos a poner el código que se ejecuta si al leer el archivo falla

            ioException.printStackTrace();
        } //CATCH ENDS


    }//MAIN METHOD ENDS -------------------------------------------------------




}// CLASS CSV READER ENDS -----------------------------------------------------
