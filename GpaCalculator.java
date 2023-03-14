package application;


import java.io.File;


import java.io.FileNotFoundException;


import java.io.FileWriter;


import java.io.IOException;


//import java.io.File;


import java.util.ArrayList;


import java.util.Scanner;


/*


* Authors: Paul Tuccinardi, John DeAngelis and Brandon Cornejo


* Date: Fall 2020


* Course: COMSC 330


* Description: This class takes a GRP file as the input from the GUI and calculates the letter grades


* and GPA of each CSV file in the GRP file. Gets the students, average GPA, z test and letter grades from


* course


*/



public class GpaCalculator {


	static ArrayList<Double> grades = new ArrayList<Double>(); //array list of the letter grades converted to GPA values


	static int [] students = new int[12]; //count for each letter grade in a course


	static int [] total = new int[12];  //total count of each letter grade


	 double populationMean = 0; //mean of the group file


	 static double overallGPA =0;


	int sectionNumberOfStudents=0; //number of students in each section


	int counter=0;


	ArrayList<String> uniqueStudents = new ArrayList<String>();


public static ArrayList<Double> GPAList;


	/*


	 * Calculates the overall GPA of a course


	 */


	public static double overallGPA(ArrayList<Double> GPAList) {


		double totalGPA = 0;


		for(int i = 0; i < GPAList.size(); i++) { //go through the list and add it to total GPA


			totalGPA += GPAList.get(i);


		}


		int sections = GPAList.size();


		


		double overallGPA = totalGPA/sections;


		return overallGPA;


		


	}


	/*


	 * Calculate GPA for a 1 credit course


	 * the calculateGPA methods are the same


	 * but they are here if someone wants to change the values


	 */


	public static ArrayList<Double> calculateGPA1(ArrayList<String> finalGrades) {


		GPAList = new ArrayList<Double>();


		for(int i = 0; i < finalGrades.size(); i++) { // go through final grades


			//if it's an A add the value of 4.0 and increment the letter grade in the arrays


			//each if statement follows the same pattern just a different letter grade and GPA value


			if(finalGrades.get(i).contains("A") && !finalGrades.get(i).contains("-")) {


				GPAList.add(4.0);


				grades.add(4.0);


				students[0]++;


				total[0]++;


			}


			else if(finalGrades.get(i).contains("A") && finalGrades.get(i).contains("-")) {


				GPAList.add(3.7);


				grades.add(3.7);


				students[1]++;


				total[1]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("+")) {


				GPAList.add(3.3);


				grades.add(3.3);


				students[2]++;


				total[2]++;


			}


			else if(finalGrades.get(i).contains("B") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(3.0);


				grades.add(3.0);


				students[3]++;


				total[3]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("-")) {


				GPAList.add(2.7);


				grades.add(2.7);


				students[4]++;


				total[4]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("+")) {


				GPAList.add(2.3);


				grades.add(2.3);


				students[5]++;


				total[5]++;


			}


			else if(finalGrades.get(i).contains("C") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(2.0);


				grades.add(2.0);


				students[6]++;


				total[6]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("-")) {


				GPAList.add(1.7);


				grades.add(1.7);


				students[7]++;


				total[7]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("+")) {


				GPAList.add(1.3);


				grades.add(1.3);


				students[8]++;


				total[8]++;


			}


			else if(finalGrades.get(i).contains("D") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(1.0);


				grades.add(1.0);


				students[9]++;


				total[9]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("-")) {


				GPAList.add(0.7);


				grades.add(0.7);


				students[10]++;


				total[10]++;


			}


			else if(finalGrades.get(i).contains("F")) {


				GPAList.add(0.0);


				grades.add(0.0);


				students[11]++;


				total[11]++;


			}


			


			


		}


		return GPAList;


	}


	/*


	 * Calculates GPA for a 2 credit course


	 */


	public static ArrayList<Double> calculateGPA2(ArrayList<String> finalGrades) {


		GPAList = new ArrayList<Double>();


		for(int i = 0; i < finalGrades.size(); i++) {


			if(finalGrades.get(i).contains("A") && !finalGrades.get(i).contains("-")) {


				GPAList.add(4.0);


				grades.add(4.0);


				students[0]++;


				total[0]++;


			}


			else if(finalGrades.get(i).contains("A") && finalGrades.get(i).contains("-")) {


				GPAList.add(3.7);


				grades.add(3.7);


				students[1]++;


				total[1]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("+")) {


				GPAList.add(3.3);


				grades.add(3.3);


				students[2]++;


				total[2]++;


			}


			else if(finalGrades.get(i).contains("B") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(3.0);


				grades.add(3.0);


				students[3]++;


				total[3]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("-")) {


				GPAList.add(2.7);


				grades.add(2.7);


				students[4]++;


				total[4]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("+")) {


				GPAList.add(2.3);


				grades.add(2.3);


				students[5]++;


				total[5]++;


			}


			else if(finalGrades.get(i).contains("C") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(2.0);


				grades.add(2.0);


				students[6]++;


				total[6]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("-")) {


				GPAList.add(1.7);


				grades.add(1.7);


				students[7]++;


				total[7]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("+")) {


				GPAList.add(1.3);


				grades.add(1.3);


				students[8]++;


				total[8]++;


			}


			else if(finalGrades.get(i).contains("D") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(1.0);


				grades.add(1.0);


				students[9]++;


				total[9]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("-")) {


				GPAList.add(0.7);


				grades.add(0.7);


				students[10]++;


				total[10]++;


			}


			else if(finalGrades.get(i).contains("F")) {


				GPAList.add(0.0);


				grades.add(0.0);


				students[11]++;


				total[11]++;


			}


			


			


		}


		return GPAList;


	}


	


	/*


	 * Calculates GPA for a 3 credit course


	 */


	public static ArrayList<Double> calculateGPA3(ArrayList<String> finalGrades) {


		GPAList = new ArrayList<Double>();


		for(int i = 0; i < finalGrades.size(); i++) {


			if(finalGrades.get(i).contains("A") && !finalGrades.get(i).contains("-")) {


				GPAList.add(4.0);


				grades.add(4.0);


				students[0]++;


				total[0]++;


			}


			else if(finalGrades.get(i).contains("A") && finalGrades.get(i).contains("-")) {


				GPAList.add(3.7);


				grades.add(3.7);


				students[1]++;


				total[1]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("+")) {


				GPAList.add(3.3);


				grades.add(3.3);


				students[2]++;


				total[2]++;


			}


			else if(finalGrades.get(i).contains("B") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(3.0);


				grades.add(3.0);


				students[3]++;


				total[3]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("-")) {


				GPAList.add(2.7);


				grades.add(2.7);


				students[4]++;


				total[4]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("+")) {


				GPAList.add(2.3);


				grades.add(2.3);


				students[5]++;


				total[5]++;


			}


			else if(finalGrades.get(i).contains("C") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(2.0);


				grades.add(2.0);


				students[6]++;


				total[6]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("-")) {


				GPAList.add(1.7);


				grades.add(1.7);


				students[7]++;


				total[7]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("+")) {


				GPAList.add(1.3);


				grades.add(1.3);


				students[8]++;


				total[8]++;


			}


			else if(finalGrades.get(i).contains("D") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(1.0);


				grades.add(1.0);


				students[9]++;


				total[9]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("-")) {


				GPAList.add(0.7);


				grades.add(0.7);


				students[10]++;


				total[10]++;


			}


			else if(finalGrades.get(i).contains("F")) {


				GPAList.add(0.0);


				grades.add(0.0);


				students[11]++;


				total[11]++;


			}


			


			


		}


		return GPAList;


	}


	/*


	 * Calculates the GPA for a 4 credit course


	 */


	public static ArrayList<Double> calculateGPA4(ArrayList<String> finalGrades) {


		GPAList = new ArrayList<Double>();


		for(int i = 0; i < finalGrades.size(); i++) {


			if(finalGrades.get(i).contains("A") && !finalGrades.get(i).contains("-")) {


				GPAList.add(4.0);


				grades.add(4.0);


				students[0]++;


				total[0]++;


			}


			else if(finalGrades.get(i).contains("A") && finalGrades.get(i).contains("-")) {


				GPAList.add(3.7);


				grades.add(3.7);


				students[1]++;


				total[1]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("+")) {


				GPAList.add(3.3);


				grades.add(3.3);


				students[2]++;


				total[2]++;


			}


			else if(finalGrades.get(i).contains("B") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(3.0);


				grades.add(3.0);


				students[3]++;


				total[3]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("-")) {


				GPAList.add(2.7);


				grades.add(2.7);


				students[4]++;


				total[4]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("+")) {


				GPAList.add(2.3);


				grades.add(2.3);


				students[5]++;


				total[5]++;


			}


			else if(finalGrades.get(i).contains("C") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(2.0);


				grades.add(2.0);


				students[6]++;


				total[6]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("-")) {


				GPAList.add(1.7);


				grades.add(1.7);


				students[7]++;


				total[7]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("+")) {


				GPAList.add(1.3);


				grades.add(1.3);


				students[8]++;


				total[8]++;


			}


			else if(finalGrades.get(i).contains("D") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(1.0);


				grades.add(1.0);


				students[9]++;


				total[9]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("-")) {


				GPAList.add(0.7);


				grades.add(0.7);


				students[10]++;


				total[10]++;


			}


			else if(finalGrades.get(i).contains("F")) {


				GPAList.add(0.0);


				grades.add(0.0);


				students[11]++;


				total[11]++;


			}


			


			


		}


		return GPAList;


	}


	/*


	 * Calculates GPA for a 5 credit course


	 */


	public static ArrayList<Double> calculateGPA5(ArrayList<String> finalGrades) {


		GPAList = new ArrayList<Double>();


		for(int i = 0; i < finalGrades.size(); i++) {


			if(finalGrades.get(i).contains("A") && !finalGrades.get(i).contains("-")) {


				GPAList.add(4.0);


				grades.add(4.0);


				students[0]++;


				total[0]++;


			}


			else if(finalGrades.get(i).contains("A") && finalGrades.get(i).contains("-")) {


				GPAList.add(3.7);


				grades.add(3.7);


				students[1]++;


				total[1]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("+")) {


				GPAList.add(3.3);


				grades.add(3.3);


				students[2]++;


				total[2]++;


			}


			else if(finalGrades.get(i).contains("B") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(3.0);


				grades.add(3.0);


				students[3]++;


				total[3]++;


			}


			else if(finalGrades.get(i).contains("B") && finalGrades.get(i).contains("-")) {


				GPAList.add(2.7);


				grades.add(2.7);


				students[4]++;


				total[4]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("+")) {


				GPAList.add(2.3);


				grades.add(2.3);


				students[5]++;


				total[5]++;


			}


			else if(finalGrades.get(i).contains("C") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(2.0);


				grades.add(2.0);


				students[6]++;


				total[6]++;


			}


			else if(finalGrades.get(i).contains("C") && finalGrades.get(i).contains("-")) {


				GPAList.add(1.7);


				grades.add(1.7);


				students[7]++;


				total[7]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("+")) {


				GPAList.add(1.3);


				grades.add(1.3);


				students[8]++;


				total[8]++;


			}


			else if(finalGrades.get(i).contains("D") && !finalGrades.get(i).contains("-") && !finalGrades.get(i).contains("+")) {


				GPAList.add(1.0);


				grades.add(1.0);


				students[9]++;


				total[9]++;


			}


			else if(finalGrades.get(i).contains("D") && finalGrades.get(i).contains("-")) {


				GPAList.add(0.7);


				grades.add(0.7);


				students[10]++;


				total[10]++;


			}


			else if(finalGrades.get(i).contains("F")) {


				GPAList.add(0.0);


				grades.add(0.0);


				students[11]++;


				total[11]++;


			}


			


			


		}


		return GPAList;


	}


	/*


	 * Reads the file entered in the GUI


	 */


	public String readFile(String file, String name) {


		grades = new ArrayList<Double>();


		


		 //populationMean = 0;


		 sectionNumberOfStudents=0;


		String answer="";


		File open = new File(file);


		int length = file.lastIndexOf("\\\\");


		String path = file.substring(0,length+2);


		Scanner reader;


		Scanner fileReader;


		ArrayList<String> files = new ArrayList<String>();//contain all the files in a grp file


		


		


		


	


		try {


			


		reader = new Scanner(open);


	


		//loop through and go through each file keeping track of each course grades


		while(reader.hasNextLine()) {


			files.add(reader.nextLine());


			


		}


		


		reader.close();


		//go through the file and add anything without a .


		for(int i=0; i<files.size();++i) {


			if(!files.get(i).contains(".") && files.get(i).contains("Program") ) {


				answer+= files.get(i)+ "\n";


				++i;


			}else {


			students = new int[12];


			ArrayList<String> text = new ArrayList<String>();


			ArrayList<String> finalGrades = new ArrayList<String>();


			String newFile = path + files.get(i);


			


			if(newFile.endsWith("GRP")) {//if the grp files has multiple grp files.


				answer+= readFile(newFile, name);


			}else if(!newFile.endsWith("GRP") && !newFile.endsWith("CSV")){//neither csv or grp file


				answer+= "file is not of correct type please make sure appropriate files are selected \n";


			}else {//otherwise this means it's a new CSV file so we need new data structures


				


				open =  new File(newFile);


			


				fileReader= new Scanner(open);


			while(fileReader.hasNext()) {// opens new file and adds all the information to text


				text.add(fileReader.next());


			}


			fileReader.close();


			


			


		


		


		//System.out.println(files);


		String section = text.get(0).substring(0);


		


		answer += section + "\n";


		


		int credits = (int) Integer.valueOf(text.get(1).substring(0, 1));//gets the credit from the first line in the CSV file


		//counts the unique students


		for(int j=2; j<text.size(); j++) {


			if(text.get(j).contains("0") || text.get(j).contains("1")|| text.get(j).contains("2")|| text.get(j).contains("3") || text.get(j).contains("4")|| text.get(j).contains("5")|| text.get(j).contains("6") || text.get(j).contains("7")|| text.get(j).contains("8")|| text.get(j).contains("9")) {


				


				uniqueStudents.add(text.get(j));


			}


		}


		//adds each grade to finalGrades


		for(int i1 = 0; i1 < text.size(); i1++) {


			if(text.get(i1).substring(text.get(i1).length()-2).contains("A") || text.get(i1).substring(text.get(i1).length()-2).contains("B") || text.get(i1).substring(text.get(i1).length()-2).contains("C") || text.get(i1).substring(text.get(i1).length()-2).contains("D") || text.get(i1).substring(text.get(i1).length()-2).contains("F")) {


				finalGrades.add(text.get(i1).substring(text.get(i1).length()-2));


		}


			


		}


		//this switch statement looks at the credits and depending on how many it is, thats the method it will go to


		//Right now the calculateGPA's are the same, but can be changed very easily


		


			switch(credits) {


			case 1:


				 calculateGPA1(finalGrades) ;


				break;


			case 2:


				calculateGPA2(finalGrades);


				break;


			case 3:


				 calculateGPA3(finalGrades);


				break;


			case 4:


				 calculateGPA4(finalGrades);


				break;


			case 5:


				 calculateGPA5(finalGrades);


				break;


				}


			//how the amount of each letter grade is put into the answer


				for(int j=0; j<students.length;++j) {


					sectionNumberOfStudents+=students[j];


				}


				for(int j = 0; j< students.length;++j) {


					if(j==0) {


						answer += "A: " + students[0];


					}


					if(j==1) {


						answer += " A-: " + students[1];


					}


					if(j==2) {


						answer += " B+: " + students[2];


					}


					if(j==3) {


						answer += " B: " + students[3];


					}


					if(j==4) {


						answer += " B-: " + students[4];


					}


					if(j==5) {


						answer += " C+: " + students[5];


					}


					if(j==6) {


						answer += " C: " + students[6];


					}


					if(j==7) {


						answer += " C-: " + students[7];


					}


					if(j==8) {


						answer += " D+: " + students[8];


					}


					if(j==9) {


						answer += " D: " + students[9];


					}


					if(j==10) {


						answer += " D-: " + students[10];


					}


					if(j==11) {


						answer += " F: " + students[11] ;


					}


					


					


				}


				++counter;


				


				//these two lines call methods to get the unique students and z test				


				uniqueStudents = findUniqueStudents(uniqueStudents);


				


				answer += "\n" +calculateZ(GPAList,populationMean, uniqueStudents);


				


				


				


			}


		}


		


	}


		//finds the total grade count


		answer+= "Total grade count:";


		for(int j = 0; j< total.length;++j) {


			if(j==0) {


				answer += "A: " + total[0];


			}


			if(j==1) {


				answer += " A-: " + total[1];


			}


			if(j==2) {


				answer += " B+: " + total[2];


			}


			if(j==3) {


				answer += " B: " + total[3];


			}


			if(j==4) {


				answer += " B-: " + total[4];


			}


			if(j==5) {


				answer += " C+: " + total[5];


			}


			if(j==6) {


				answer += " C: " + total[6];


			}


			if(j==7) {


				answer += " C-: " + total[7];


			}


			if(j==8) {


				answer += " D+: " + total[8];


			}


			if(j==9) {


				answer += " D: " + total[9];


			}


			if(j==10) {


				answer += " D-: " + total[10];


			}


			if(j==11) {


				answer += " F: " + total[11] ;


			}


		}


		answer+= "\nTotal number of Unique Students: " + uniqueStudents.size() + "\n";	


		answer+= "Overall gpa" + overallGPA+ "\n";


		answer+= "Number of sections " + counter+ "\n";


	}


		


		 catch (FileNotFoundException e1) {


				// TODO Auto-generated catch block


			


				answer += "file not found";//new


			}


		


		saveOutput(path, answer, name);


		


		return answer + "\n";


		}	


	


	/*


	 * Constructs the GpaCalculator for the GUI


	 */


	public GpaCalculator(String string) throws FileNotFoundException {


	


	}


	/*


	 * This method calculates the z test


	 * It takes in the GPA grades, the population mean which we set to 0 at the top


	 * and an Array List of the unique students


	 */


	public static String calculateZ(ArrayList<Double> gpaGrades, double populationMean, ArrayList<String> uniqueStudents) {


		double z = 0;


		String result = "File not a significant difference";


		double sampleMean = 0;


		double populationStandardDev = 0;


		//go through gpaGrades and add it to the sample mean


		for(int i = 0; i < gpaGrades.size(); i++) {


			sampleMean += gpaGrades.get(i);


		}


		//this gets the real value of the sample mean and rounds it to 2 decimal places


		sampleMean = sampleMean/gpaGrades.size();


		sampleMean=Math.round(sampleMean * 100.0) / 100.0;


		//add all of the grades to population mean (this is the mean of the group file)


		for(int j=0; j<grades.size(); ++j) {


			populationMean += grades.get(j);


		}


		


		populationMean = populationMean/grades.size();


		overallGPA = populationMean;


		overallGPA=Math.round(overallGPA * 100.0) / 100.0;


		//get the population standard deviation


		for(double num: gpaGrades) {


			populationStandardDev += Math.pow(num - sampleMean, 2);


		}


		//formula to get the z number


		populationStandardDev = Math.sqrt(populationStandardDev/grades.size());


		z = (sampleMean - populationMean) / populationStandardDev;


		//if z is greater than 2 or less than -2 then there is a significant difference so the string result needs to change


		//result is set to not a significant difference at the beginning


		if(z > 2 || z < -2) {


			result = "File significant difference";


		}


		//add the number of students and average gpa of class to the string result


		result += "\n" + "number of students: " + gpaGrades.size();


		result += "\n" + "average gpa of class: " + sampleMean + "\n";


		


		//output result


		return  result  + "\n" ;


	}


	


	


	/*


	 * this method writes the results to a file that the client can write to in the GUI


	 */


	public static void saveOutput(String path, String answer, String name) {


	String output= path + name;


	


	 


	try {


		  FileWriter fileWriter = new FileWriter(output);


		    fileWriter.write(answer);


		    fileWriter.close();


	} catch ( IOException e) {


		// TODO Auto-generated catch block


		e.printStackTrace();


	


	}


	}


	/*


	 * takes the string array of unique students finds them


	 */


	public static ArrayList<String> findUniqueStudents(ArrayList<String> uniqueStudents) {


		


		for(int i=0; i<uniqueStudents.size()-2;++i) {


			for(int j=i+1; j<uniqueStudents.size()-1;++j) {


				if(uniqueStudents.get(i).contains(uniqueStudents.get(j))){


					uniqueStudents.remove(j);


					--j;


				}


			}


		}


		return uniqueStudents;


	}







}

