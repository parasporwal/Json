package com.qait.JSONPARSING;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingJSON {
	private final static String path="D:\\workspace\\JSONPARSING\\src\\main\\resource\\db.json";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
		
		FileReader reader=new FileReader(path);
		JSONParser parser=new JSONParser();
		JSONObject jsonObj=(JSONObject) parser.parse(reader);
		printJsonObject(jsonObj);
		/*System.out.println(jsonObj);*/
		/*for(Object key: jsonObj.keySet()){
			String obKey=key.toString();
			System.out.print("key : "+obKey);
			Object value=jsonObj.get(obKey);
			System.out.print(" value :"+value);
			System.out.println();
			if(value instanceof JSONArray){
				System.out.print("array : ");
				System.out.print(value);
				System.out.println();
				printJSONArray(value);
			}
			else if(value instanceof Number){
				System.out.print("number : ");
				System.out.print(value);
				System.out.println();
			}
			else 
				System.out.println(value);
		}*/
		
		/*JSONArray jsonArr=(JSONArray) obj.get("languages");
		Iterator<Object> itr=((List) obj).iterator();
		while(itr.hasNext()){
			JSONObject innerObj=(JSONObject) itr.next();
			System.out.println("OBJ"+innerObj);
			System.out.println("---------------------");
			for(Object key:innerObj.keySet() ){
				String obKey=key.toString();
				String obValue=(String) innerObj.get(obKey);
				System.out.println("key: "+obKey+" value: "+obValue);
				
				
			}
		}
		
		String firstName=(String) obj.get("firstname");
		JSONObject jsonObj=(JSONObject) obj.get("job");
		System.out.println(id);
		System.out.println("firstName"+firstName);
		System.out.println(jsonObj);
		System.out.println(jsonObj.get("site"));
		System.out.println(jsonObj.get("name"));*/
		
		
		}
		catch (FileNotFoundException ex) {
			            ex.printStackTrace();

			        } catch (IOException ex) {
//		
			            ex.printStackTrace();
	
			        } catch (ParseException ex) {
			ex.printStackTrace();
			
			        } catch (NullPointerException ex) {
			
			            ex.printStackTrace();
			
			        }
		
			 

		
	}

	private static void printJsonObject(JSONObject jsonObj) {
		System.out.println("printJSONOBJECT()");
		// TODO Auto-generated method stub
		if(jsonObj instanceof JSONObject){
			for(Object key: jsonObj.keySet()){
				
				String obKey=key.toString();
				Object value=jsonObj.get(obKey);
				System.out.println(" key : "+obKey+" value : "+value);
				
			    if(value instanceof JSONObject){
					JSONObject obj=(JSONObject)value;
					printJsonObject(obj);
					
				}
				if(value instanceof JSONArray){
					System.out.println("array");
					JSONArray obj=(JSONArray)value;
					printJSONArray(obj);
				}
				else {
					System.out.println("neither object  nor array 1:"+value);
				}
				
			}
		}
		
	}

	private static void printJSONArray(JSONArray array) {
		System.out.println("printJSONARRAY ()");
		if(array instanceof JSONArray){
			/*System.out.println("() : "+array);*/
			JSONArray jsonArray=(JSONArray)array;
			for(int i=0;i<jsonArray.size();i++){
				System.out.println("iteration :"+i);
				Object object=jsonArray.get(i);
				if(object instanceof JSONObject){
					JSONObject obj=(JSONObject)object;
					printJsonObject(obj);
					
				}
				if(object instanceof JSONArray){
					/*System.out.println(" inside printJSONARRAY()");*/
					JSONArray obj=(JSONArray)object;
					printJSONArray(obj);
				}
				else{
					System.out.println("neither object  nor array 1:"+object);
				}
			}
		}
		
	}

}
