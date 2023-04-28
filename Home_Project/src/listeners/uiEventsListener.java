package listeners;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface uiEventsListener {

	public String getQuestionStockText();

	public void modelAddPremadeQuestions();

	public void modelRemoveAllQuestions();

	public String getTestText();

	public void saveStockToTxt();
	
	public void addAmericanQuestion(String [] arr,String qText,String rightAnswer);

	void addOpenQuestion(String qText, String answerText);

	public int getQuestionLength();

	public void updateQuestionText(String text, Integer value);

	public void generateRandomTest(int value);

	public int getAllTestsLength();

	public void cloneExistingTest(int i);

	public boolean checkTypeAmerican(int value);

	public void updateQuestionAnswer(String text, int value, int i);

	public int getAnswerNum(int questionNum);

	public void deleteAnswer(int i, int j);

	public void addManualTest(LinkedHashMap<Integer, ArrayList<Integer>> allIndices);

	public String getAnswer(int i, int j);

	public String getQuestionText(int i);


}
