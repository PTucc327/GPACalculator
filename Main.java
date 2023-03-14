package application;




	












import java.io.File;


import java.io.FileNotFoundException;


import javafx.application.Application;


import javafx.event.ActionEvent;


import javafx.event.EventHandler;


import javafx.geometry.Pos;


import javafx.scene.Scene;


import javafx.scene.control.Button;


import javafx.scene.control.Label;


import javafx.scene.control.TextField;


import javafx.scene.layout.HBox;


import javafx.scene.layout.VBox;


import javafx.scene.text.Font;


import javafx.scene.text.FontPosture;


import javafx.scene.text.FontWeight;


import javafx.stage.FileChooser;


import javafx.stage.Stage;


import javafx.stage.Window;


/*


* Authors: Paul Tuccinardi, John DeAngelis and Brandon Cornejo


* Date: Fall 2020


* Course: COMSC 330


* Description: GUI for the client to use the GPACalculator class


* It takes everything from the GPACalulator class and makes it easier and nicer for the client to view


* This also allows the information from GPACalculator to be saved to a file


*/







public class Main extends Application {


	@Override


	public void start(Stage primaryStage) {


		try {


			//set title


			primaryStage.setTitle("COMSC330 Semester Project");


			Window stage = null;


			//creates a button to select the GRP file


			Button select = new Button("Select");


			


			//title at the top


			Label title = new Label("Welcome to the GPA Calculator");


			//instructions to user/client


			Label instructions = new Label("Please select GRP file and then write the desired file name in text field below then click calculate,\n otherwise the file will be saved as output");


			


			//button to calculate information


			Button calculate = new Button("Calculate GPA");


			TextField saveOutput = new TextField("");


			FileChooser fileChooser = new FileChooser();


			Label files = new Label();


			Label output = new Label();


			


			// action event


	        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {


	            public void handle(ActionEvent e)


	            {


	            	


	    			fileChooser.setTitle("Open Resource File");


	    			File fileList = fileChooser.showOpenDialog(stage);


	    			String list = new String();


	    			while(fileList == null) {


	    				fileList = fileChooser.showOpenDialog(stage);


	    			}


	    		


	    			list = fileList.getPath();


	    			


	    			files.setText(list);


	    	


	            }


	        };


	 


	        // when button is pressed create GpaCalculator and get the text from the file


	        select.setOnAction(event);


			


	        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {


	            public void handle(ActionEvent e)


	            {


	            	try {


	            		String filepath;


	            		GpaCalculator calc;


	            		String temp;


	            		if(!files.getText().isEmpty()) {//new


	            		


	            		 temp= files.getText().replaceAll("\n", "");


	            		temp = temp.replace("\\", "\\\\");


	            		


	            		calc= new GpaCalculator(temp);


	            		if(saveOutput.getText().isEmpty()) {


	            			filepath= "output.txt";


	            		}else {


	            		 filepath =  saveOutput.getText() + ".txt";


	            		}


						output.setText(calc.readFile(temp, filepath));


	            		} else {


	            			


	            		}


	            		


						


						


					} catch (FileNotFoundException e1) {


						// TODO Auto-generated catch block


						output.setText("Error has occurred please select file and try again");//new


					}


	    			


	    		


	    			


	            }


	        };


	     


	       


	       


	        calculate.setOnAction(event2);


			


			files.setAlignment(Pos.CENTER);


			select.setAlignment(Pos.CENTER);


			saveOutput.setAlignment(Pos.CENTER);


			


			select.setMaxWidth(100);


			select.setMaxHeight(200);


			


			//groups the different elements of application		


			HBox hbox4 = new HBox(output);


			HBox hbox2 = new HBox( title);


			HBox hbox3 = new HBox(files);


			HBox hbox5 = new HBox(saveOutput);


			HBox hbox6 = new HBox(instructions);


			hbox2.setSpacing(100.0);


			hbox2.setAlignment(Pos.CENTER);


			hbox3.setAlignment(Pos.CENTER);


			HBox hbox = new HBox( select, calculate);


			hbox.setSpacing(100.0);


			hbox.setAlignment(Pos.CENTER);


			hbox5.setAlignment(Pos.CENTER);


			hbox6.setAlignment(Pos.CENTER);


			VBox vbox = new VBox(hbox2, hbox,hbox3, hbox6, hbox5, hbox4);


			


			


			//sets styles and puts together application


			 Scene scene = new Scene(vbox, 1000, 1000);


			 scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


			 select.getStyleClass().add("button1");


			 select.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));


			calculate.getStyleClass().add("button2");


			calculate.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));


			saveOutput.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 20));


			title.getStyleClass().add("title");


			title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));


			vbox.getStyleClass().add("pane");


			files.getStyleClass().add("file");


			output.getStyleClass().add("output1");


			instructions.getStyleClass().add("instructions");


			instructions.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 18));


			saveOutput.getStyleClass().add("button3");


			output.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));


			primaryStage.setScene(scene);


			primaryStage.show();


		} catch(Exception e) {


			e.printStackTrace();


		}


	}


	


	public static void main(String[] args) {


		launch(args);


	}


}

Application.css

/* JavaFX CSS - Leave this comment until you have at least create one rule which uses -fx-Property */




.button1{


   -fx-text-fill: black ;


   -fx-background-color: white;


   -fx-border-radius: 20;


   -fx-background-radius: 20;


   -fx-border-color: black;


   -fx-padding: 5;


  


}


.title{


	 -fx-text-fill: white;


	


}


.file{


	-fx-text-fill: white;


}


.instructions{


	-fx-text-fill: white;


}


.button2{


   -fx-text-fill: black;


   -fx-background-color: white;


   -fx-border-radius: 20;


   -fx-border-color: black;


   -fx-background-radius: 20;


   -fx-padding: 5;


}


.button3{


   -fx-text-fill: black;


   -fx-background-color: white;


   -fx-border-radius: 20;


   -fx-border-color: black;


   -fx-background-radius: 20;


   -fx-padding: 5;


}


.output1{


	-fx-text-fill: white;


	


	


}


.pane{


   -fx-background-color: rgb(0,128,192);


   -fx-background-repeat: stretch;  


   -fx-background-size: 1000 1000;


   -fx-background-position: center center;






}

