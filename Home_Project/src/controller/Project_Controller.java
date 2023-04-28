package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import View.ProjectView;
import id208133280_id207496068.AmericanQuestion;
import id208133280_id207496068.OpenQuestion;
import id208133280_id207496068.QuestionStock;
import id208133280_id207496068.Test;
import listeners.modelEventsListener;
import listeners.uiEventsListener;

public class Project_Controller implements modelEventsListener, uiEventsListener {
	QuestionStock model;
	ProjectView view;

	public Project_Controller(ProjectView view, QuestionStock stock) {
		model = stock;
		this.view = view;

		view.registerListener(this);
		model.registerListener(this);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//Controller main function with model

	@Override
	public String getQuestionStockText() {
		return model.printAllQuestions();
	}

	@Override
	public void modelAddPremadeQuestions() {
		model.addHardCodedQuestions();
	}

	@Override
	public void modelRemoveAllQuestions() {
		model.deleteAllQuestions();
	}

	@Override
	public String getTestText() {
		return model.printAllTests();
	}

	@Override
	public void saveStockToTxt() {
		model.removeAllListeners();
		try {
			FileOutputStream os = new FileOutputStream("QuestionStockSave(DO NOT TOUCH)");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(model);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found Exception");
		} catch (IOException e) {
			System.out.println("IO exception");
		}
	}

	@Override
	public void addOpenQuestion(String qText, String answerText) {
		OpenQuestion Oq = new OpenQuestion(qText, answerText);
		model.addQuestionAndAnswers(Oq);
	}

	@Override
	public void addAmericanQuestion(String[] arr, String qText, String rightAnswer) {
		AmericanQuestion Aq = new AmericanQuestion(qText);
		Aq.setRightAnswer(rightAnswer);
		System.out.println(Aq.getRightAnswer());
		for (int i = 0; i < arr.length - 1; i++) {
			if (!(arr[i] == "")) {
				Aq.addAnswers(arr[i]);
			}
		}
		if (rightAnswer == "") {
			view.fireUnsupportedAnswerMessage();
		} else if (rightAnswer.equals("No answers are correct")) {
			Aq.addNoAnswersAreCorrect();
			model.addQuestionAndAnswers(Aq);
		} else {
			model.addQuestionAndAnswers(Aq);
		}
	}

	@Override
	public int getQuestionLength() {
		return model.allQuestions.size();
	}

	@Override
	public void updateQuestionText(String text, Integer value) {
		model.updateQuestion(text, value);
	}

	@Override
	public void generateRandomTest(int num) {
		int[] randomQuestionArray = randomNumberArray(num, model.allQuestions.size());
		Test randomTest = new Test();
		for (int i = 0; i < num; i++) {
			int randomQuestionIndex = randomQuestionArray[i];
			if (model.allQuestions.get(randomQuestionIndex - 1) instanceof AmericanQuestion) {
				AmericanQuestion Aq = new AmericanQuestion(
						((AmericanQuestion) model.allQuestions.get(randomQuestionIndex - 1)).getqText(),
						((AmericanQuestion) model.allQuestions.get(randomQuestionIndex - 1)).getRightAnswer());
				int[] randomAnswerArray = randomNumberArray(findIfTooSmall(model, randomQuestionIndex - 1),
						(((AmericanQuestion) model.allQuestions.get(randomQuestionIndex - 1)).getArraySize()));
				for (int j = 0; j < findIfTooSmall(model, randomQuestionIndex - 1); j++) {
					int randomAnswerIndex = randomAnswerArray[j];
					Aq.getAnswersSet().add(((AmericanQuestion) model.allQuestions.get(randomQuestionIndex - 1))
							.getAnswersSet().get(randomAnswerIndex - 1));
				}
				Aq.addNoAnswersAreCorrect();
				randomTest.addTestQuestion(Aq);
			} else {
				OpenQuestion Oq = new OpenQuestion((OpenQuestion) model.allQuestions.get(randomQuestionIndex - 1));
				randomTest.addTestQuestion(Oq);
			}
		}
		randomTest.sortTest();
		model.addNewRandomTest(randomTest);
		randomTest.saveTestInTxt();
	}

	public int[] randomNumberArray(int num, int max) {
		int[] randomNumbers = new int[num];
		for (int i = 0; i < num;) {
			int randomNum = (int) (Math.random() * (max + 1));
			if (doesentExist(randomNumbers, randomNum)) {
				randomNumbers[i] = randomNum;
				i++;
			}
		}
		return randomNumbers;
	}

	public boolean doesentExist(int[] randomNumbers, int num) {
		for (int i = 0; i < randomNumbers.length; i++) {
			if (randomNumbers[i] == num) {
				return false;
			}
		}
		return true;
	}

	public int findIfTooSmall(QuestionStock Stock, int ind) {
		if (((AmericanQuestion) Stock.allQuestions.get(ind)).getArraySize() < 4) {
			return ((AmericanQuestion) Stock.allQuestions.get(ind)).getArraySize();
		} else {
			return 4;
		}
	}

	@Override
	public int getAllTestsLength() {
		return model.allTests.size();
	}

	@Override
	public void cloneExistingTest(int i) {
		try {
			model.addNewClonedTest((Test) model.allTests.get(i).clone());
		} catch (CloneNotSupportedException e) {
			System.out.println("Cannot Clone Given Test");
		}
	}

	@Override
	public boolean checkTypeAmerican(int value) {
		return (model.allQuestions.get(value) instanceof AmericanQuestion);
	}

	@Override
	public void updateQuestionAnswer(String text, int value, int i) {
		model.updateAnswer(text, value, i);
	}

	@Override
	public int getAnswerNum(int questionNum) {
		return ((AmericanQuestion) model.allQuestions.get(questionNum)).getArraySize();
	}

	@Override
	public void deleteAnswer(int i, int j) {
		model.deleteAnswer(i, j);
	}

	public void addManualTest(LinkedHashMap<Integer, ArrayList<Integer>> k) {
		Test t = new Test();
		for (Map.Entry<Integer, ArrayList<Integer>> e : k.entrySet()) {
			if (e.getValue() == null) {
				OpenQuestion Oq = new OpenQuestion(((OpenQuestion) model.allQuestions.get(e.getKey())).getqText(),
						((OpenQuestion) model.allQuestions.get(e.getKey())).getRightAnswer());
				t.addTestQuestion(Oq);
			} else {
				AmericanQuestion Aq = new AmericanQuestion(
						((AmericanQuestion) model.allQuestions.get(e.getKey())).getqText());
				for (int i = 0; i < e.getValue().size(); i++) {
					Aq.addAnswers(
							((AmericanQuestion) model.allQuestions.get(e.getKey())).getAnswer(e.getValue().get(i)));
					Aq.setRightAnswer(((AmericanQuestion) model.allQuestions.get(e.getKey())).getRightAnswer());
					Aq.addNoAnswersAreCorrect();
				}
				t.addTestQuestion(Aq);
			}
		}
		model.addManualTest(t);
		t.saveTestInTxt();
	}

	@Override
	public String getQuestionText(int i) {
		return model.allQuestions.get(i).getqText();
	}

	@Override
	public String getAnswer(int i, int j) {
		return ((AmericanQuestion) model.allQuestions.get(i)).getAnswer(j);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//Controller fire to UI functions
	@Override
	public void fireQuestionWasRemoved() {
		view.fireQuestionWasRemovedToUI();
	}

	@Override
	public void fireManualTestGeneratesSuccessfully() {
		view.fireManualTestGeneratesSuccessfullyToUI();
	}

	@Override
	public void fireAnswerDeletedSuccessFully() {
		view.fireAnswerDeletedSuccessFullyToUI();
	}

	@Override
	public void fireQuestionAddedSuccessfully() {
		view.fireQuestionAddedSuccessfullyToUI();
	}

	@Override
	public void fireAnswerUpdateSuccessfully() {
		view.fireAnswerUpdateSuccessfullyToUI();
	}

	@Override
	public void fireClonedTestGeneratesSuccessfully() {
		view.fireClonedTestGeneratesSuccessfullyToUI();
	}

	@Override
	public void fireRandomTestGeneratesSuccessfully() {
		view.fireRandomTestGeneratesSuccessfullyToUI();
	}

	@Override
	public void fireQuestionTextUpdated() {
		view.fireQuestionTextUpdatedToUI();
	}
}
