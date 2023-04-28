package id208133280_id207496068;
import java.io.Serializable;
import java.util.ArrayList;
import controller.Project_Controller;
import listeners.modelEventsListener;

public class QuestionStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Question> allQuestions;
	public ArrayList<modelEventsListener> listeners;
	public ArrayList<Test> allTests;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public QuestionStock() {
		allQuestions = new ArrayList<Question>();
		listeners=new ArrayList<modelEventsListener>();
		allTests=new ArrayList<Test>();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateQuestion(String text, int qNum) {
		allQuestions.get(qNum).qText = text;
		listeners.get(0).fireQuestionTextUpdated();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String printAllQuestions() {
		if (allQuestions.size() == 0) {
			return "";
		}
		StringBuffer scBuffer = new StringBuffer("all current Questions and answers in Stock:\n");
		scBuffer.append("\n");
		for (int i = 0; i < allQuestions.size(); i++) {
			scBuffer.append("Question " + (i + 1) + ":\n");
			scBuffer.append("------------\n");
			scBuffer.append(allQuestions.get(i).toString());
			scBuffer.append("\n");
			scBuffer.append("\n");
		}
		return scBuffer.toString();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addQuestionAndAnswers(Question q) {
		if (q instanceof AmericanQuestion) {
			allQuestions.add((AmericanQuestion) q);
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).fireQuestionAddedSuccessfully();
			}
		} else if (q instanceof OpenQuestion) {
			allQuestions.add((OpenQuestion) q);
			for (int i = 0; i < listeners.size(); i++) {
				listeners.get(i).fireQuestionAddedSuccessfully();
			}
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void deleteAnswer(int qNum, int aNum) {
		if (allQuestions.get(qNum) instanceof AmericanQuestion) {
			if(((AmericanQuestion)allQuestions.get(qNum)).getArraySize()==1){
				allQuestions.remove(qNum);
				listeners.get(0).fireQuestionWasRemoved();
			}
			else {
			((AmericanQuestion) allQuestions.get(qNum)).allAnswers.remove(aNum);
			listeners.get(0).fireAnswerDeletedSuccessFully();
			}
		} else if (allQuestions.get(qNum) instanceof OpenQuestion) {
			((OpenQuestion) allQuestions.get(qNum)).setAnswer("No answer (Please update answer)");
			listeners.get(0).fireAnswerDeletedSuccessFully();
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void updateAnswer(String text, int questionNum, int answerNum) {
		if (allQuestions.get(questionNum) instanceof AmericanQuestion) {
			((AmericanQuestion) allQuestions.get(questionNum)).changeAnswer(text, answerNum);
			listeners.get(0).fireAnswerUpdateSuccessfully();
		} else {
			((OpenQuestion) allQuestions.get(questionNum)).setAnswer(text);
			listeners.get(0).fireAnswerUpdateSuccessfully();
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void deleteAllQuestions() {
		for (int i = (allQuestions.size() - 1); i >= 0; i--) {
			allQuestions.remove(i);
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String printAllTests() {
		if (allTests.size() == 0) {
			return "";
		}
		StringBuffer scBuffer = new StringBuffer("all current Tests:\n");
		scBuffer.append("\n");
		for (int i = 0; i < allTests.size(); i++) {
			scBuffer.append("#############################################################################################\n");
			scBuffer.append("Test " + (i + 1) + ":\n");
			scBuffer.append("------------\n");
			scBuffer.append(allTests.get(i).printAll());
			scBuffer.append("#############################################################################################\n");
			scBuffer.append("\n");
			scBuffer.append("\n");
		}
		return scBuffer.toString();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//hard coded Questions
	public void addHardCodedQuestions() {
// Question 1
		AmericanQuestion Aq1 = new AmericanQuestion("Between which years did WWII last?");
		Aq1.addAnswers("1912-1913");
		Aq1.addAnswers("1939-1945");
		Aq1.addAnswers("1956-1999");
		Aq1.addAnswers("1234-1256");
		Aq1.addAnswers("1876-1900");
		Aq1.setRightAnswer("1939-1945");
		allQuestions.add(Aq1);

// Question 2
		AmericanQuestion Aq2 = new AmericanQuestion("How many chromosomes does a human have?");
		Aq2.addAnswers("46");
		Aq2.addAnswers("12");
		Aq2.addAnswers("69");
		Aq2.addAnswers("420");
		Aq2.addAnswers("9999999");
		Aq2.setRightAnswer("46");
		allQuestions.add(Aq2);

// Question 3
		AmericanQuestion Aq3 = new AmericanQuestion(
				"What type of material kills werewolves(according to the mythology)?");
		Aq3.addAnswers("Iron");
		Aq3.addAnswers("Star of david shaped boomerang blessed by a rabbi");
		Aq3.addAnswers("Blessed wood");
		Aq3.addAnswers("Holy water");
		Aq3.addAnswers("Silver");
		Aq3.setRightAnswer("Silver");
		allQuestions.add(Aq3);

// Question 4
		OpenQuestion Oq1 = new OpenQuestion("What is the speed of light", "299,792,458 m/s");
		allQuestions.add(Oq1);

// Question 5
		OpenQuestion Oq2 = new OpenQuestion("What is the Speed of a standart low orbit satelite?", "about 7,000 mph");
		allQuestions.add(Oq2);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void registerListener(Project_Controller project_Controller) {
		listeners.add(project_Controller);
		
	}

	public void removeAllListeners() {
		for (int i = (listeners.size()-1); i >=0; i--) {
			listeners.remove(i);
		}
	}
	public void addNewRandomTest(Test t) {
		allTests.add(t);
		listeners.get(0).fireRandomTestGeneratesSuccessfully();
	}
	public void addNewClonedTest(Test t) {
		allTests.add(t);
		listeners.get(0).fireClonedTestGeneratesSuccessfully();
	}
	public void addManualTest(Test t) {
		allTests.add(t);
		listeners.get(0).fireManualTestGeneratesSuccessfully();
	}
}
