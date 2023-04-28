package application;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import View.ProjectView;
import controller.Project_Controller;
import id208133280_id207496068.QuestionStock;
import javafx.application.Application;
import javafx.stage.Stage;


//Names: Daniel_Shvartsman id_208133280
//Names: Tomer_Guzikov id_207496068
public class Main extends Application {	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			QuestionStock stock=readStock();
			ProjectView theView=new ProjectView(primaryStage);
			@SuppressWarnings("unused")
			Project_Controller ctrl=new Project_Controller(theView,stock);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public QuestionStock readStock() {
		try {
			FileInputStream fis = new FileInputStream("QuestionStockSave(DO NOT TOUCH)");
			ObjectInputStream ois = new ObjectInputStream(fis);
			QuestionStock s = (QuestionStock) ois.readObject();
			ois.close();
			return s;
		}
		catch(Exception e) {
		QuestionStock scQuestionStock=new QuestionStock();
		return scQuestionStock;
		}
	}
}
