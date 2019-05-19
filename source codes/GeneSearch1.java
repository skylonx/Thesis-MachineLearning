/**
 * 
 * 
 * @author Skylon 22nd November,2017
 * Second version of the genesearch class 
 *
 */

import java.io.*;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class GeneSearch1 {
/**************************************************************************/

		
		/**
		 * Java Program to parse and read CSV file using traditional BufferedReader
		 * approach and by using more functional CSV parser from Apache Commons CSV
		 * library. Apache Commons CSV support different CSV format including default
		 * one, with or without header, reading EXCEL or XLS CSV file etc.
		 *
		 * @author
		 */
			public static List<Object> countries = new ArrayList<>(); 
		    public static  List <String> pool    = new ArrayList <> () ; 
			public static  String [] spool = {"SCGB2A2","ANKRD30A","SCGB1D2",
						"SCGB2A1",
						"PIP",
						"TFF3",
						"KRT81",
						"CSN3",
						"KLK5",
						"C4ORF7",
						"TAT",
						"BEX1",
						"UGT2B11",
						"UGT2B7",
						"LTF",
						"UGT2B28",
						"LOC338579",
						"PROM1",
						"BAMBI",
						"VTCN1",
						"KRT7",
						"DQ893812",
						"HLA-DRB1",
						"DB005376",
						"SERPINA6",
						"PXDNL",
						"CPB1",
						"DIO1",
						"HSPB8",
						"RAMP1",
						"CST1",
						"FLJ23152",
						"CYP4X1",
						"HMGCS2",
						"CYP4Z1",
						"TFAP2B",
						"PPP1R1B",
						"TFF1",
						"GRIA2",
						"EEF1A2",
						"BMPR1B",
						"CLIC6",
						"TCN1",
						"MYBPC1",
						"CNTNAP2",
						"S100A9",
						"S100A8",
						"S100P",
						"SLC27A2",
						"PHGR1",
						"SYT13",
						"SERPINA5",
						"TUBA3D"};     
		    
		    
		    /*
		     * Java program to read CSV file using BufferedReader and String split()
		     * method
		     */
		    public static List readCSV() throws FileNotFoundException, IOException {
		       
		    	//List<Object> countries = new ArrayList<>();  -> This part works that we know of
		        //BufferedReader br = new BufferedReader(new FileReader("countries.csv"));
		    	
		        //BufferedReader br = new BufferedReader(new FileReader("data.csv"));
		       BufferedReader reader = new BufferedReader(new FileReader("testdata105.csv"));
		        
		    	
		    	//BufferedReader reader = new BufferedReader(new FileReader("CurData.csv"));
		        String line = reader.readLine(); // Reading header, Ignoring

		        while ((line = reader.readLine()) != null && !line.isEmpty()) {
		            String[] fields = line.split(",");
		            String name = fields[0];
		            String tier = fields[1];
		            String type = fields[2];
		            
		            Process record = new Process(name, tier, type);
		            countries.add(record); //
		        }
		        reader.close();
		        return countries;
		    }//readCSV
		    
		    
		    
		    /***
		     * Method search() searches the entire Arraylist created from the initial dataset ,find just one gene
			 * Search with key method
		    ***/
		    public static void search(List n, String key) {
		    	
		    	// bunch of objects 
		    	String key2Search = key;
		    	GeneSearch1 eex = new GeneSearch1();
		    	Process xx  = new Process(null, null, null);
		    	
		    	
		    	
		    	for (int x=0; x< n.size(); x++) {
		    		xx = (Process) n.get(x);
		    		String temp = xx.name();
		    	   ////System.out.println(n.get(x)); this line prints the whole Obj and works
		    		
		    
		    		if( temp.equalsIgnoreCase(key2Search)) {
		    			System.out.println(temp+" Found as::  "+"\n");
		    	    	System.out.println(xx);}
		    	   
		    	  }//end for 	   
		    	
		    	}//search the ArrayList to find the key we are looking for.
		    
		    
		    
		    
		    /***
		     * Method searchEntireList() searches the entire Arraylist created from dataset .csv file ,find all genes , contained in the array 
		     * Which is passed to it.
			 *
		    ***/
		    public static void searchEntireList(List n, String []key) {
		    	
		    	// bunch of objects 
		    	String [] passed = key; // passed array to search through each individually ,
		    							// reference of which we have saving in local array list 
		    	//String key2Search = key;
		    	GeneSearch1 eex = new GeneSearch1();
		    	Process xx  = new Process(null, null, null);
		    	
		    	
		    	//outer for loop should loop through the 
		    	// passed array ,
		    	// reference of which we have saved in local array list
		    	// Fix this part
		    	for(int i =0; i <passed.length;i++) {
		    	
		    		for (int x =0; x< n.size(); x++) {
		    			xx = (Process) n.get(x);
		    			String temp = xx.name();
		    			////System.out.println(n.get(x)); this line prints the whole Obj and works
		    		
		    
		    			if( temp.equalsIgnoreCase(passed[i])) {
		    				System.out.println(temp+" Found as::  "+"\n");
		    				System.out.println(xx);} //end if 
		    	   
		    		}//end for 	   
		    	}//end outer for
		    	
		    }//end searchEntireList()
		    
		    
		    
		    
		    
		    
		    
		    
	
		    public static void print(List<Object> countries) {
		        System.out.println("========================");
		        for (Object country : countries) {
		            System.out.println(country);
		        }
		        System.out.println("========================");
		    }
	    	   

	
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException ********************************************************************/
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String xgene ="ABI1"; //Test known Oncogene
		String ygene = "MUTYH";
		String zgene ="GRIA2";
		String kgene = "MET";
		
		String test [] = {"ABI1","ABL1","ABL2","ACKR3","ACSL3","ACVR1","ACVR2A","AFF1","AFF3","AFF4"};
		
		
		GeneSearch1 genie = new GeneSearch1();
		System.out.println("Test Drive Girl.");
				
		
		
		
		//testing phase
		System.out.println("Reading from CSV file using BufferedReader and String Split");
        List nations = readCSV();
        ///print(nations);
        
        System.out.println("**********Search by one key *******************" );
        search(nations,xgene);
        search(nations,ygene);
        search(nations,zgene);
        search(nations,kgene);
        //System.out.println("Parsing CSV file using CSVParser of Apache commons CSV");
        //parseCSV();
        
        
        
        System.out.println("**************Search for each elements of the array*******************************");
        searchEntireList(nations,test);
        System.out.println("Search complete for the test array containing known genes.");
        
        System.out.println("**************Search for each elements of the array Given Naveen Dataset*******************************");
        searchEntireList(nations,spool); 
        
        System.out.println("***Ten Tigers***");
		
	}//end main body
	
	
}//end class body
