package com.klosowsky;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

//test
public class App 
{
    public static void main( String[] args )
    {
        try {
            File inputFile = new File("resources/input.json");
            JsonElement jsonElement = JsonParser.parseReader(new FileReader(inputFile));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            Gson gson = new Gson();
            Set<String> keys = jsonObject.keySet();
            HashMap<String,Double> operationMap = new HashMap<>();

            for (String key : keys) {
                MathOperation mathOperation = gson.fromJson(jsonObject.getAsJsonObject(key).toString(),MathOperation.class);
                operationMap.put(key,mathOperation.computeResult());
            }
            HashMap<String, Double> resultMap = sortMap(operationMap);
            FileWriter fileWriter = new FileWriter("resources/result.txt");
            for (String key : resultMap.keySet()) {
                fileWriter.write(key+": " +resultMap.get(key)+"\n");
            }
            fileWriter.close();

        }catch(FileNotFoundException fileException){
            System.out.println(fileException.getMessage());
            System.exit(-1);
        }
        catch (UnsupportedOperationException unsupportedOperationException){
            System.out.println(unsupportedOperationException.getMessage());
            System.exit(-1);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
            System.exit(-1);
        }


    }
    public static HashMap<String, Double> sortMap(HashMap<String, Double> hm)
    {
        List<Map.Entry<String, Double> > list = new LinkedList<Map.Entry<String, Double> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<String, Double> tmpList = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            tmpList.put(aa.getKey(), aa.getValue());
        }
        return tmpList;
    }

}
