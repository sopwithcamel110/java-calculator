import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.*;


public class calculator extends Application{
	//Global Vars
	String result;
	double num = 0;
	Text output;
	int currentOp = -1;//-1 for none, 0 for add, 1 for sub, 2 for mult, 3 for div
	//Main Method
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Donovan's Calculator");
    	
    	result = "";
    	
    	Text signature = new Text("Donovan's Calculator");
    	signature.setLayoutY(240);
    	signature.setLayoutX(35);
    	signature.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.REGULAR, 10));
    	signature.setTextAlignment(TextAlignment.LEFT);
    	
    	Text equation = new Text("");
    	equation.setLayoutY(20);
    	equation.setLayoutX(0);
    	equation.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.REGULAR, 15));
    	equation.setTextAlignment(TextAlignment.LEFT);
    	
    	output = new Text("0");
    	output.setLayoutY(40);
    	output.setLayoutX(0);
    	output.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    	output.setTextAlignment(TextAlignment.LEFT);
    	
    	Button n1 = new Button("1");
    	setNumButton(n1, 1);
    	Button n2 = new Button("2");
    	setNumButton(n2, 2);
    	Button n3 = new Button("3");
    	setNumButton(n3, 3);
    	Button n4 = new Button("4");
    	setNumButton(n4, 4);
    	Button n5 = new Button("5");
    	setNumButton(n5, 5);
    	Button n6 = new Button("6");
    	setNumButton(n6, 6);
    	Button n7 = new Button("7");
    	setNumButton(n7, 7);
    	Button n8 = new Button("8");
    	setNumButton(n8, 8);
    	Button n9 = new Button("9");
    	setNumButton(n9, 9);
    	Button n0 = new Button("0");
    	n0.setOnAction(actionEvent -> {
    		if (result != "0")
    		{
    			result = result + "0";
    			output.setText(result);
    		}
    	});
    	
    	Button div = new Button("/");
    	div.setOnAction(actionEvent -> {
    		num = Double.parseDouble(output.getText());
    		currentOp = 3;
    		result = "";
    	});
    	Button mult = new Button("x");
    	mult.setOnAction(actionEvent -> {
    		num = Double.parseDouble(output.getText());
    		currentOp = 2;
    		result = "";
    	});
    	Button plus = new Button("+");
    	plus.setOnAction(actionEvent -> {
    		num = Double.parseDouble(output.getText());
    		currentOp = 0;
    		result = "";
    	});
    	Button minus = new Button("-");
    	minus.setOnAction(actionEvent -> {
    		num = Double.parseDouble(output.getText());
    		currentOp = 1;
    		result = "";
    	});
    	
    	Button clear = new Button("C");
    	clear.setOnAction(actionEvent -> {
    		result = "";
    		output.setText("0");
    	});
    	Button equal = new Button("=");
    	equal.setOnAction(actionEvent -> {
    		switch (currentOp) {
    		case 0:
    			equation.setText(num + " + " + Double.parseDouble(output.getText()) + " =");
    			result = Double.toString(num + Double.parseDouble(output.getText()));
        		output.setText(result);
        		break;
    		case 1:
    			equation.setText(num + " - " + Double.parseDouble(output.getText()) + " =");
    			result = Double.toString(num - Double.parseDouble(output.getText()));
        		output.setText(result);
        		break;
    		case 2:
    			equation.setText(num + " x " + Double.parseDouble(output.getText()) + " =");
    			result = Double.toString(num * Double.parseDouble(output.getText()));
        		output.setText(result);
        		break;
    		case 3:
    			equation.setText(num + " / " + Double.parseDouble(output.getText()) + " =");
    			result = Double.toString(num / Double.parseDouble(output.getText()));
        		output.setText(result);
        		break;
    		}
    	});
    	
    	List<Button> btnList = new ArrayList<Button>() {{
    		add(n7);add(n8);add(n9);add(div);
    		add(n4);add(n5);add(n6);add(mult);
    		add(n1);add(n2);add(n3);add(minus);
    		add(n0);add(clear);add(equal);add(plus);
    	}};
    	for (int i = 0; i < 16; i++)
    	{
    		(btnList.get(i)).setLayoutX((i%4)*50);
    		(btnList.get(i)).setLayoutY(50+((i/4)*50));
    	}
    	
    	Group root = new Group(output,equation,n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,div,mult,minus,clear,equal,plus,signature);
    	
    	primaryStage.setScene(new Scene(root, 180, 250));
        primaryStage.show();
    }
    public void setNumButton(Button btn, int ID)
    {
    	btn.setOnAction(actionEvent -> {
    		result = result + Integer.toString(ID);
    		output.setText(result);
    	});
    }
}
