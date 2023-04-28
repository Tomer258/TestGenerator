package View;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import controller.Project_Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import listeners.uiEventsListener;
import javafx.scene.control.TextField;

public class ProjectView {
	private ArrayList<uiEventsListener> allListeners = new ArrayList<uiEventsListener>();
	private int last_shown_layer = 0;
	protected String typeof;
	private Label updateStockLabel;

	@SuppressWarnings("static-access")
	public ProjectView(Stage primaryStage) {
		// Menu buttons
		Label mainLabel = new Label("Please choose one of the following commands:");
		Button displayAllQuestions = new Button("1) Display questions stock");
		Button addQuestionsAndAnswers = new Button("2) Add question and answers");
		Button updateQuestionText = new Button("3) Update question");
		Button updateAnswer = new Button("4) Update answer");
		Button removeAnswer = new Button("5) Delete answer");
		Button manualTest = new Button("6) Manual Test insert");
		Button automaticTest = new Button("7) Automatic Test insert");
		Button displayAllTests = new Button("8) Display all Tests in system");
		Button cloneExistingTest = new Button("9) Clone an existing test");
		Button addPremadeQuestion = new Button("10) Add 5 premade Questions");
		Button deleteAllQuestionInStock = new Button("11) Delete all Questions in stock");
		Button exitAndSave = new Button("12) Exit and save program");

		// Left Vbox -> menu buttons
		VBox vbox_main_left = new VBox(mainLabel, displayAllQuestions, addQuestionsAndAnswers, updateQuestionText,
				updateAnswer, removeAnswer, manualTest, automaticTest, displayAllTests, cloneExistingTest,
				addPremadeQuestion, deleteAllQuestionInStock, exitAndSave);
		for (int i = 1; i < vbox_main_left.getChildren().size(); i++) {
			((Button) vbox_main_left.getChildren().get(i)).setPrefWidth(200);
			((Button) vbox_main_left.getChildren().get(i)).setAlignment(Pos.BASELINE_LEFT);
		}
		vbox_main_left.setSpacing(10);
		vbox_main_left.setAlignment(Pos.BASELINE_LEFT);
		vbox_main_left.setPadding(new Insets(15));

		// Stack pane -> contains Data UI
		StackPane layers = new StackPane();
		layers.setAlignment(Pos.CENTER);
		layers.setPadding(new Insets(15));
		layers.setPrefWidth(800);
		// declaring vbox layers in stack pane
		ScrollPane layer_DisplayQuestionBox = new ScrollPane();
		VBox layer_AddQuestionsBox = new VBox();
		HBox layer_UpdateQuestionBox = new HBox();
		VBox layer_UpdateAnswerBox = new VBox();
		VBox layer_DeleteQuestionBox = new VBox();
		VBox layer_ManualTestInsertBox = new VBox();
		VBox layer_RandomTestBox = new VBox();
		ScrollPane layer_DisplayTestsBox = new ScrollPane();
		VBox layer_CloneTestBox = new VBox();
		layers.getChildren().addAll(layer_AddQuestionsBox, layer_UpdateQuestionBox, layer_UpdateAnswerBox,
				layer_DeleteQuestionBox, layer_ManualTestInsertBox, layer_RandomTestBox, layer_DisplayTestsBox,
				layer_CloneTestBox, layer_DisplayQuestionBox);

		// Building each layer
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		// layer 2: AddQuestinsBox
		layer_AddQuestionsBox.setSpacing(10);
		layer_AddQuestionsBox.setPadding(new Insets(15));
		Label question_type_insert = new Label("Please choose the type of question you would like to add: ");
		HBox hbox_radio_typeBox = new HBox();
		hbox_radio_typeBox.setSpacing(10);
		ToggleGroup type_Group = new ToggleGroup();
		RadioButton type_open = new RadioButton("Open Question");
		RadioButton type_american = new RadioButton("American Question");
		type_open.setToggleGroup(type_Group);
		type_american.setToggleGroup(type_Group);
		hbox_radio_typeBox.getChildren().addAll(type_open, type_american);
		layer_AddQuestionsBox.getChildren().addAll(question_type_insert, hbox_radio_typeBox);
		GridPane openQuestion_Box = new GridPane();
		GridPane americanQuestion_Box = new GridPane();
		openQuestion_Box.setVisible(false);
		americanQuestion_Box.setVisible(false);
		StackPane radioStackPane = new StackPane();
		Label enter_open_questionLabel = new Label("Please enter question text: ");
		TextField questionText_field = new TextField();
		openQuestion_Box.add(enter_open_questionLabel, 0, 0);
		openQuestion_Box.add(questionText_field, 0, 1);
		questionText_field.setPrefWidth(100);
		Label enter_open_answerLabel = new Label("Please enter answer text: ");
		TextField answerText_field = new TextField();
		Button submit_new_open_questionButton = new Button("Add Question");
		openQuestion_Box.add(enter_open_answerLabel, 0, 2);
		openQuestion_Box.setVgap(5);
		answerText_field.setPrefWidth(300);
		openQuestion_Box.add(answerText_field, 0, 3);
		openQuestion_Box.add(submit_new_open_questionButton, 0, 4);
		openQuestion_Box.setHalignment(submit_new_open_questionButton, HPos.CENTER);
		Label enter_american_questionLabel = new Label("Please enter question text: ");
		TextField answerText_field2 = new TextField();
		answerText_field2.setPrefWidth(300);
		americanQuestion_Box.add(enter_american_questionLabel, 0, 0);
		americanQuestion_Box.add(answerText_field2, 0, 1);
		radioStackPane.getChildren().addAll(openQuestion_Box, americanQuestion_Box);
		layer_AddQuestionsBox.getChildren().add(radioStackPane);
		Button submit_new_american_questionButton = new Button("Add Question");
		Label Answer_american_questionLabel = new Label("Please enter 10 answers for your question");
		TextField americanAnswerText_field1 = new TextField("");
		TextField americanAnswerText_field2 = new TextField("");
		TextField americanAnswerText_field3 = new TextField("");
		TextField americanAnswerText_field4 = new TextField("");
		TextField americanAnswerText_field5 = new TextField("");
		TextField americanAnswerText_field6 = new TextField("");
		TextField americanAnswerText_field7 = new TextField("");
		TextField americanAnswerText_field8 = new TextField("");
		TextField americanAnswerText_field9 = new TextField("");
		TextField americanAnswerText_field10 = new TextField("");
		americanQuestion_Box.add(Answer_american_questionLabel, 0, 4);
		americanQuestion_Box.add(americanAnswerText_field1, 0, 5);
		americanQuestion_Box.add(americanAnswerText_field2, 0, 6);
		americanQuestion_Box.add(americanAnswerText_field3, 0, 7);
		americanQuestion_Box.add(americanAnswerText_field4, 0, 8);
		americanQuestion_Box.add(americanAnswerText_field5, 0, 9);
		americanQuestion_Box.add(americanAnswerText_field6, 0, 10);
		americanQuestion_Box.add(americanAnswerText_field7, 0, 11);
		americanQuestion_Box.add(americanAnswerText_field8, 0, 12);
		americanQuestion_Box.add(americanAnswerText_field9, 0, 13);
		americanQuestion_Box.add(americanAnswerText_field10, 0, 14);
		americanQuestion_Box.setHalignment(submit_new_american_questionButton, HPos.CENTER);
		Label rightAnswer_american_questionLabel = new Label("Please select the right answer");
		ComboBox<String> rightAnswerIndex = new ComboBox<String>();
		rightAnswerIndex.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "No answers are correct");
		americanQuestion_Box.add(rightAnswer_american_questionLabel, 0, 15);
		americanQuestion_Box.add(rightAnswerIndex, 0, 16);
		americanQuestion_Box.add(submit_new_american_questionButton, 0, 17);
		americanQuestion_Box.setVgap(5);

		class MyRadioEventHandler implements EventHandler<ActionEvent> {

			@Override
			public void handle(ActionEvent ae) {
				String typeof = ((RadioButton) type_Group.getSelectedToggle()).getText();
				System.out.println(typeof);
				if (typeof == "Open Question") {
					openQuestion_Box.setVisible(true);
					americanQuestion_Box.setVisible(false);
				} else {
					americanQuestion_Box.setVisible(true);
					openQuestion_Box.setVisible(false);
				}
			}
		}
		submit_new_open_questionButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				allListeners.get(0).addOpenQuestion(questionText_field.getText(), answerText_field.getText());
			}
		});
		submit_new_american_questionButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				String[] arr = { americanAnswerText_field1.getText(), americanAnswerText_field2.getText(),
						americanAnswerText_field3.getText(), americanAnswerText_field4.getText(),
						americanAnswerText_field5.getText(), americanAnswerText_field6.getText(),
						americanAnswerText_field7.getText(), americanAnswerText_field8.getText(),
						americanAnswerText_field9.getText(), americanAnswerText_field10.getText(),
						"No answers are correct" };
				int rightIndex = 11;
				for (int i = 0; i < arr.length; i++) {
					if (rightAnswerIndex.getValue().equals("" + i)) {
						rightIndex = i;

					}
				}
				allListeners.get(0).addAmericanQuestion(arr, answerText_field2.getText(), arr[rightIndex - 1]);
			}
		});
		MyRadioEventHandler myRadioEvent = new MyRadioEventHandler();
		type_american.setOnAction(myRadioEvent);
		type_open.setOnAction(myRadioEvent);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		// layer 3: updateQuestinsBox
		ScrollPane allQuestions = new ScrollPane();
		allQuestions.setPadding(new Insets(15));
		allQuestions.setPrefSize(500, 700);
		VBox chooseWhatToUpdate = new VBox();
		Label inputQuestionNum = new Label("Please enter which question's index");
		Label inputQuestionText = new Label("Please enter new Question Text:");
		ComboBox<Integer> QuestionNum = new ComboBox<Integer>();
		TextField QuestionText = new TextField("");
		Button submitQuestionUpdate = new Button("Update");
		chooseWhatToUpdate.getChildren().addAll(inputQuestionNum, QuestionNum, inputQuestionText, QuestionText,
				submitQuestionUpdate);
		chooseWhatToUpdate.setPadding(new Insets(15));
		chooseWhatToUpdate.setSpacing(15);
		layer_UpdateQuestionBox.getChildren().addAll(allQuestions, chooseWhatToUpdate);
		submitQuestionUpdate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				if (allListeners.get(0).getQuestionLength() == 0) {
					JOptionPane.showMessageDialog(null, "There are no question in stock to update");
				} else if (QuestionNum.getValue() == null) {
					JOptionPane.showMessageDialog(null, "No question index was selected");
				} else {
					allListeners.get(0).updateQuestionText(QuestionText.getText(), (QuestionNum.getValue() - 1));
					updateStockLabel = getQuestionStockAsLabel();
					allQuestions.setContent(updateStockLabel);
				}

			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
// layer 5: randomTest		

		Label randomTestLabel = new Label(
				"Please choose the amount of questions\n you want your randomized test to have");
		ComboBox<Integer> randomTestComboBox = new ComboBox<Integer>();
		Button submitRandomTestNumber = new Button("Generate random test");
		layer_RandomTestBox.setPadding(new Insets(15));
		layer_RandomTestBox.setSpacing(15);
		layer_RandomTestBox.getChildren().addAll(randomTestLabel, randomTestComboBox, submitRandomTestNumber);
		submitRandomTestNumber.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				if (randomTestComboBox.getValue() != null) {
					allListeners.get(0).generateRandomTest(randomTestComboBox.getValue());
				} else {
					JOptionPane.showMessageDialog(null, "No amount of questions were selected");
				}
			}

		});

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//layer 8: Clone Test
		HBox cloneTest = new HBox();
		VBox chooseWhatToClone = new VBox();
		ScrollPane currentTests = new ScrollPane();
		currentTests.setPadding(new Insets(15));
		Label chooseWhichToClone = new Label("Please choose which test you would like to clone");
		ComboBox<Integer> whichToClone = new ComboBox<Integer>();
		Button submitCloning = new Button("Clone");
		chooseWhatToClone.getChildren().addAll(chooseWhichToClone, whichToClone, submitCloning);
		layer_CloneTestBox.getChildren().add(cloneTest);
		cloneTest.getChildren().addAll(currentTests, chooseWhatToClone);
		layer_CloneTestBox.setPadding(new Insets(15));
		layer_CloneTestBox.setSpacing(15);
		chooseWhatToClone.setPadding(new Insets(15));
		chooseWhatToClone.setSpacing(15);
		currentTests.setPrefSize(500, 700);
		submitCloning.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				if (whichToClone.getValue() == null) {
					fireNoTestsInSystemToUI();
				} else {
					allListeners.get(0).cloneExistingTest((whichToClone.getValue() - 1));
				}
			}
		});

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//layer 2: UpdateAnswer
		HBox UpdateAnswer = new HBox();
		VBox chooseWhichAnswer = new VBox();
		ScrollPane stockText = new ScrollPane();
		stockText.setPadding(new Insets(15));
		UpdateAnswer.getChildren().addAll(stockText, chooseWhichAnswer);
		layer_UpdateAnswerBox.getChildren().add(UpdateAnswer);
		stockText.setPrefSize(500, 700);
		chooseWhichAnswer.setPadding(new Insets(15));
		chooseWhichAnswer.setSpacing(15);
		Label chooseWhichQuestionToUpdate = new Label("Please choose which question you would\n like to update");
		ComboBox<Integer> chosenQuestionToUpdateAnswer = new ComboBox<Integer>();

		StackPane chooseAnswerPane = new StackPane();
		VBox chosenAmericanQuestion = new VBox();
		VBox chosenOpenQuestion = new VBox();
		Label openQuestionLabel = new Label("Please enter new answer");
		TextField openQuestionTextField = new TextField();
		Button UpdateOpenQuestionAnswer = new Button("Update answer");
		chosenOpenQuestion.getChildren().addAll(openQuestionLabel, openQuestionTextField, UpdateOpenQuestionAnswer);
		chosenOpenQuestion.setPadding(new Insets(15));
		chosenOpenQuestion.setSpacing(15);
		Label americanQuestionAnswerIndexLabel = new Label("Please choose answer index you\n would like to change");
		ComboBox<Integer> americanQuestionAnswerIndex = new ComboBox<Integer>();
		Label americanQuestionLabel = new Label("Please enter new answer");
		TextField americanAnswer = new TextField();
		Button UpdateAmericanQuestionAnswer = new Button("Update answer");
		chosenAmericanQuestion.getChildren().addAll(americanQuestionAnswerIndexLabel, americanQuestionAnswerIndex,
				americanQuestionLabel, americanAnswer, UpdateAmericanQuestionAnswer);
		chosenAmericanQuestion.setPadding(new Insets(15));
		chosenAmericanQuestion.setSpacing(15);

		chosenAmericanQuestion.setVisible(false);
		chosenOpenQuestion.setVisible(false);
		chooseAnswerPane.getChildren().addAll(chosenAmericanQuestion, chosenOpenQuestion);
		chooseWhichAnswer.getChildren().addAll(chooseWhichQuestionToUpdate, chosenQuestionToUpdateAnswer,
				chooseAnswerPane);

		chosenQuestionToUpdateAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				if (chosenQuestionToUpdateAnswer.getValue() != null) {
					if (allListeners.get(0).checkTypeAmerican(chosenQuestionToUpdateAnswer.getValue() - 1)) {
						chosenOpenQuestion.setVisible(false);
						chosenAmericanQuestion.setVisible(true);
						updateComboBoxNumbersForAnswers(americanQuestionAnswerIndex,
								(chosenQuestionToUpdateAnswer.getValue() - 1));
					} else {
						chosenAmericanQuestion.setVisible(false);
						chosenOpenQuestion.setVisible(true);
					}
				}
			}

		});
		UpdateOpenQuestionAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				allListeners.get(0).updateQuestionAnswer(openQuestionTextField.getText(),
						(chosenQuestionToUpdateAnswer.getValue() - 1), 0);
				chosenOpenQuestion.setVisible(false);
				chosenAmericanQuestion.setVisible(false);
				chosenQuestionToUpdateAnswer.getSelectionModel().clearSelection();
			}

		});
		UpdateAmericanQuestionAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				allListeners.get(0).updateQuestionAnswer(americanAnswer.getText(),
						(chosenQuestionToUpdateAnswer.getValue() - 1), (americanQuestionAnswerIndex.getValue() - 1));
				chosenOpenQuestion.setVisible(false);
				chosenAmericanQuestion.setVisible(false);
				chosenQuestionToUpdateAnswer.getSelectionModel().clearSelection();
			}
		});

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//layer 3:Delete Answer
		HBox deleteAnswer = new HBox();
		VBox chooseWhichAnswerToDelete = new VBox();
		ScrollPane stockTextToDelete = new ScrollPane();
		stockTextToDelete.setPadding(new Insets(15));
		layer_DeleteQuestionBox.getChildren().add(deleteAnswer);
		deleteAnswer.getChildren().addAll(stockTextToDelete, chooseWhichAnswerToDelete);
		stockTextToDelete.setPrefSize(500, 700);
		chooseWhichAnswerToDelete.setPadding(new Insets(15));
		chooseWhichAnswerToDelete.setSpacing(15);
		Label chooseWhichQuestionToDelete = new Label("Please choose which question you would\n like to delete");
		ComboBox<Integer> chosenQuestionToDeleteAnswer = new ComboBox<Integer>();
		StackPane chooseAnswerToDeletePane = new StackPane();
		VBox deleteChosenAmericanQuestionAnswer = new VBox();
		VBox deleteChosenOpenQuestionAnswer = new VBox();
		Button deleteOpenQuestionAnswer = new Button("delete answer");
		deleteChosenOpenQuestionAnswer.getChildren().addAll(deleteOpenQuestionAnswer);
		deleteChosenOpenQuestionAnswer.setPadding(new Insets(15));
		deleteChosenOpenQuestionAnswer.setSpacing(15);
		Label americanQuestionAnswerIndexLabelDelete = new Label(
				"Please choose answer index you\n would like to delete");
		ComboBox<Integer> americanQuestionAnswerIndexToDelete = new ComboBox<Integer>();
		Button deleteAmericanQuestionAnswer = new Button("delete answer");
		deleteChosenAmericanQuestionAnswer.getChildren().addAll(americanQuestionAnswerIndexLabelDelete,
				americanQuestionAnswerIndexToDelete, deleteAmericanQuestionAnswer);
		deleteChosenAmericanQuestionAnswer.setPadding(new Insets(15));
		deleteChosenAmericanQuestionAnswer.setSpacing(15);
		deleteChosenAmericanQuestionAnswer.setVisible(false);
		deleteChosenOpenQuestionAnswer.setVisible(false);
		chooseAnswerToDeletePane.getChildren().addAll(deleteChosenAmericanQuestionAnswer,
				deleteChosenOpenQuestionAnswer);
		chooseWhichAnswerToDelete.getChildren().addAll(chooseWhichQuestionToDelete, chosenQuestionToDeleteAnswer,
				chooseAnswerToDeletePane);

		chosenQuestionToDeleteAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				if (chosenQuestionToDeleteAnswer.getValue() != null) {
					if (allListeners.get(0).checkTypeAmerican(chosenQuestionToDeleteAnswer.getValue() - 1)) {
						deleteChosenOpenQuestionAnswer.setVisible(false);
						deleteChosenAmericanQuestionAnswer.setVisible(true);
						updateComboBoxNumbersForAnswers(americanQuestionAnswerIndexToDelete,
								(chosenQuestionToDeleteAnswer.getValue() - 1));
					} else {
						deleteChosenAmericanQuestionAnswer.setVisible(false);
						deleteChosenOpenQuestionAnswer.setVisible(true);
					}
				}
			}

		});
		deleteOpenQuestionAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				allListeners.get(0).deleteAnswer(chosenQuestionToDeleteAnswer.getValue() - 1, 0);
				deleteChosenAmericanQuestionAnswer.setVisible(false);
				deleteChosenOpenQuestionAnswer.setVisible(false);
				chosenQuestionToDeleteAnswer.getSelectionModel().clearSelection();
			}

		});
		deleteAmericanQuestionAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				if(americanQuestionAnswerIndexToDelete.getValue()==null) {
					JOptionPane.showMessageDialog(null, "No answer was selected");
				}
				else {
				allListeners.get(0).deleteAnswer((chosenQuestionToDeleteAnswer.getValue() - 1),
						(americanQuestionAnswerIndexToDelete.getValue() - 1));
				deleteChosenAmericanQuestionAnswer.setVisible(false);
				deleteChosenOpenQuestionAnswer.setVisible(false);
				chosenQuestionToDeleteAnswer.getSelectionModel().clearSelection();
				americanQuestionAnswerIndexToDelete.getSelectionModel().clearSelection();
				}
			}

		});

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//layer 4:ManualTest
		HBox insertManualTest = new HBox();
		insertManualTest.setSpacing(15);
		VBox manulTestInsert = new VBox();
		ScrollPane sp = new ScrollPane(manulTestInsert);
		sp.setPrefWidth(800);
		insertManualTest.getChildren().add(sp);
		layer_ManualTestInsertBox.getChildren().add(insertManualTest);
		manulTestInsert.setPadding(new Insets(15));
		manulTestInsert.setSpacing(15);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
		// Main Hbox -> contains all
		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox_main_left);
		hbox.getChildren().addAll(layers);
		hbox.setSpacing(10);
		Scene primaryScene = new Scene(hbox, 1200, 600);
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("Home project");
		for (int i = 0; i < 9; i++) {
			layers.getChildren().get(i).setVisible(false);
		}
		primaryStage.show();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
//MainButton Blocks
		
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Display all questions Button
		displayAllQuestions.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				updateStockLabel = getQuestionStockAsLabel();
				layer_DisplayQuestionBox.setContent(updateStockLabel);
				layer_DisplayQuestionBox.setPadding(new Insets(15));
				layer_DisplayQuestionBox.setVisible(true);
				last_shown_layer = 8;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Add questions to stock button
		addQuestionsAndAnswers.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				layers.getChildren().get(0).setVisible(true);
				last_shown_layer = 0;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Update a questions text button
		updateQuestionText.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				updateStockLabel = getQuestionStockAsLabel();
				allQuestions.setContent(updateStockLabel);
				updateComboBoxNumbers(QuestionNum);
				layer_UpdateQuestionBox.setVisible(true);
				last_shown_layer = 1;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//update a certain answer text button
		updateAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				stockText.setContent(getQuestionStockAsLabel());
				updateComboBoxNumbers(chosenQuestionToUpdateAnswer);
				layer_UpdateAnswerBox.setVisible(true);
				last_shown_layer = 2;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//remove a certain answer button
		removeAnswer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				stockTextToDelete.setContent(getQuestionStockAsLabel());
				updateComboBoxNumbers(chosenQuestionToDeleteAnswer);
				layer_DeleteQuestionBox.setVisible(true);
				last_shown_layer = 3;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//insert manual test button
		//little bit ugly i know....
		manualTest.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				layer_ManualTestInsertBox.setVisible(true);
				if (allListeners.get(0).getQuestionLength() != 0) {
					for (int i = (manulTestInsert.getChildren().size() - 1); i >= 0; i--) {
						manulTestInsert.getChildren().remove(i);
					}
					manulTestInsert.getChildren().add(new Label("Please choose the Questions\n you would like to add"));
					for (int i = 0; i < allListeners.get(0).getQuestionLength(); i++) {
						RadioButton r = new RadioButton(allListeners.get(0).getQuestionText(i));
						VBox b = new VBox(r);
						manulTestInsert.getChildren().add(b);
						if (allListeners.get(0).checkTypeAmerican(i)) {
							b.getChildren().add(new Label("--------------"));
							for (int j = 0; j < allListeners.get(0).getAnswerNum(i); j++) {
								b.getChildren().add(new CheckBox(allListeners.get(0).getAnswer(i, j)));
							}
						}

					}
					last_shown_layer = 4;
					Button submitManualTest = new Button("Generate manual test");
					manulTestInsert.getChildren().add(submitManualTest);
					submitManualTest.setOnAction(new EventHandler<ActionEvent>() {
						public void handle(ActionEvent action) {
							LinkedHashMap<Integer, ArrayList<Integer>> allIndices = new LinkedHashMap<Integer, ArrayList<Integer>>();
							for (int i = 1; i < (manulTestInsert.getChildren().size() - 1); i++) {
								if (((RadioButton) ((VBox) manulTestInsert.getChildren().get(i)).getChildren().get(0))
										.isSelected()) {
									if (((VBox) manulTestInsert.getChildren().get(i)).getChildren().size() > 1) {
										ArrayList<Integer> innerIndices = new ArrayList<Integer>();
										for (int j = 2; j < ((VBox) manulTestInsert.getChildren().get(i)).getChildren()
												.size(); j++) {
											if (((CheckBox) ((VBox) manulTestInsert.getChildren().get(i)).getChildren()
													.get(j)).isSelected()) {
												innerIndices.add(j - 2);
											}
											allIndices.put((i - 1), innerIndices);
										}
									} else {
										allIndices.put((i - 1), null);
									}
								}
							}
							if (allIndices.isEmpty()) {
								JOptionPane.showMessageDialog(null, "No questions were selected, please try again");
							} else {
								boolean check = true;
								for (int i = 0; i < allListeners.get(0).getQuestionLength(); i++) {
									if (allIndices.get(i) != null) {
										if (allIndices.get(i).size() == 0) {
											check &= false;
										}
									}
								}
								if (check) {
									allListeners.get(0).addManualTest(allIndices);
								} else {
									JOptionPane.showMessageDialog(null,
											"One of the Questions you selected had no answers selected, please try again");
								}
							}
						}

					});

				} else {
					for (int i = (manulTestInsert.getChildren().size() - 1); i >= 0; i--) {
						manulTestInsert.getChildren().remove(i);
					}
					manulTestInsert.getChildren().add(new Label("There are currently no questions in stock"));
					last_shown_layer = 4;
				}

			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//automatic test insert button
		automaticTest.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				updateComboBoxNumbers(randomTestComboBox);
				layer_RandomTestBox.setVisible(true);
				last_shown_layer = 5;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//exit the program and save it as binary file button
		exitAndSave.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				allListeners.get(0).saveStockToTxt();
				primaryStage.hide();
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//display all tests in system button
		displayAllTests.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				layer_DisplayTestsBox.setContent(testTextLabel());
				layer_DisplayTestsBox.setPadding(new Insets(15));
				layer_DisplayTestsBox.setVisible(true);
				last_shown_layer = 6;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//clone an existing test and add it to the test stock button
		cloneExistingTest.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				layers.getChildren().get(last_shown_layer).setVisible(false);
				Label l = new Label();
				l = testTextLabel();
				currentTests.setContent(l);
				updateComboBoxNumbersForTest(whichToClone);
				layer_CloneTestBox.setVisible(true);
				last_shown_layer = 7;
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//add five premade questions button
		addPremadeQuestion.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				allListeners.get(0).modelAddPremadeQuestions();
				JOptionPane.showMessageDialog(null, "5 premade questions were added successfully");
			}

		});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//delete all existing questions in the stock button
		deleteAllQuestionInStock.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				allListeners.get(0).modelRemoveAllQuestions();
				JOptionPane.showMessageDialog(null, "all questions removed from stock");
			}

		});
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
//getLabel function
	public void registerListener(Project_Controller project_Controller) {
		allListeners.add(project_Controller);

	}

	private Label getQuestionStockAsLabel() {
		Label label = new Label(allListeners.get(0).getQuestionStockText());
		if (label.getText().equals("")) {
			return new Label("There are currently no questions in Stock");
		}
		return label;
	}

	public Label testTextLabel() {
		Label l = new Label(allListeners.get(0).getTestText());
		if (l.getText().equals("")) {
			l.setText("There are currently no Tests in system");
			return l;
		}
		return l;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
//updateComboBoxes block
	private ComboBox<Integer> updateComboBoxNumbers(ComboBox<Integer> b) {
		b.getItems().clear();
		for (int i = 0; i < allListeners.get(0).getQuestionLength(); i++) {
			b.getItems().add((i + 1));
		}
		return b;
	}

	private ComboBox<Integer> updateComboBoxNumbersForTest(ComboBox<Integer> b) {
		if (b.getItems().size() != 0) {
			b.getItems().clear();
		}
		for (int i = 0; i < allListeners.get(0).getAllTestsLength(); i++) {
			b.getItems().add((i + 1));
		}
		return b;
	}

	private ComboBox<Integer> updateComboBoxNumbersForAnswers(ComboBox<Integer> b, int questionNum) {
		b.getItems().clear();
		for (int i = 0; i < allListeners.get(0).getAnswerNum(questionNum); i++) {
			b.getItems().add((i + 1));
		}
		return b;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
//fireFunctions block
	public void fireClonedTestGeneratesSuccessfullyToUI() {
		JOptionPane.showMessageDialog(null, "Cloned test generated successfully");

	}

	private void fireNoTestsInSystemToUI() {
		JOptionPane.showMessageDialog(null, "There are currently no tests in the System");

	}

	public void fireAnswerUpdateSuccessfullyToUI() {
		JOptionPane.showMessageDialog(null, "Answer updated successfully");
	}

	public void fireAnswerDeletedSuccessFullyToUI() {
		JOptionPane.showMessageDialog(null, "Answer deleted successfully");

	}

	public void fireManualTestGeneratesSuccessfullyToUI() {
		JOptionPane.showMessageDialog(null, "Manual test generated Successfully");

	}

	public void fireQuestionTextUpdatedToUI() {
		JOptionPane.showMessageDialog(null, "Question updated successfully");
	}

	public void fireRandomTestGeneratesSuccessfullyToUI() {
		JOptionPane.showMessageDialog(null, "Random test generated successfully");
	}

	public void fireQuestionAddedSuccessfullyToUI() {
		JOptionPane.showMessageDialog(null, "Question added Successfully");
	}

	public void fireUnsupportedAnswerMessage() {
		JOptionPane.showMessageDialog(null, "The right answer doesent correspond to any answer index");

	}

	public void fireQuestionWasRemovedToUI() {
		JOptionPane.showMessageDialog(null, "The question was removed because all answers were removed");
		
	}
}
