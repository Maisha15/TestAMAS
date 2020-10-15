package uabc.ic.maishari.testamas;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CVSFile {

        InputStream inputStream;

        public CVSFile(InputStream inputStream) {
            this.inputStream = inputStream;
        }


        public List read(){
            List resultList = new ArrayList();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String csvLine;
                while ((csvLine = reader.readLine()) != null) {
                    String[] row = csvLine.split(",");
                    resultList.add(row);
                }
            }
            catch (IOException ex) {
                throw new RuntimeException("Error in reading CSV file: "+ex);
            }
            finally {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    throw new RuntimeException("Error while closing input stream: "+e);
                }
            }
            return resultList;
        }


    public List readObjetos(){
        List <ItemAmas>resultList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine=reader.readLine();
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                ItemAmas objeto=parseaArregloString(row);
                resultList.add(objeto);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }

    private ItemAmas parseaArregloString(String [] row){
            ItemAmas obj=new ItemAmas();
        if(row.length!=0){
        for(int i=0;i<row.length;i++)
        {String valor=row[i];

    switch (i) {
        case 0: {
            obj.setId(Integer.parseInt(valor));
        }
        case 1:{
            obj.setItems(valor);
        }
        case 2:{

            obj.setNo(valor);
        }
        case 3:{

            obj.setSi(valor);
        }
        case 4:{
                obj.setInquihiper(valor.equalsIgnoreCase("X")?1:0);

        }
        case 5:{
            obj.setAnsieFisio(valor.equalsIgnoreCase("X")?1:0);

        }
        case 6:{
            obj.setAnsieexam(valor.equalsIgnoreCase("X")?1:0);

        }
        case 7:{
            obj.setAnsieSoc(valor.equalsIgnoreCase("X")?1:0);

        }
        case 8:{
            obj.setInquihiper(valor.equalsIgnoreCase("X")?1:0);

        }
        case 9:{
            obj.setMentira(valor.equalsIgnoreCase("X")?1:0);

        }
        case 10:{
            obj.setAnsiedadTotal(valor.equalsIgnoreCase("X")?1:0);

        }
    }


        }
        }
        else
            Log.e("ERRORPARSEO","No tiene suficientes elementos");

            return obj;
    }


}


