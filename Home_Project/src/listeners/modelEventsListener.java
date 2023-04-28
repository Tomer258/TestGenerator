package listeners;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface modelEventsListener {

	void modelRemoveAllQuestions();

	String getTestText();

	void addOpenQuestion(String text, String text2);

	void fireQuestionAddedSuccessfully();

	void addAmericanQuestion(String[] arr, String qText, String rightAnswer);

	int getQuestionLength();

	void updateQuestionText(String text, Integer value);

	void fireQuestionTextUpdated();

	void fireRandomTestGeneratesSuccessfully();

	int getAllTestsLength();

	void fireClonedTestGeneratesSuccessfully();

	boolean checkTypeAmerican(int value);

	void updateQuestionAnswer(String text, int value, int i);

	void fireAnswerUpdateSuccessfully();

	int getAnswerNum(int questionNum);

	void fireAnswerDeletedSuccessFully();

	void fireManualTestGeneratesSuccessfully();

	void addManualTest(LinkedHashMap<Integer, ArrayList<Integer>> k);

	void fireQuestionWasRemoved();

}
