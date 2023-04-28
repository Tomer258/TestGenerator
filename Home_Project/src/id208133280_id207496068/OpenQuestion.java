package id208133280_id207496068;

import java.io.Serializable;

public class OpenQuestion extends Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String rightAnswer;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public OpenQuestion(String qText, String rightAnswer) {
		super(qText);
		this.rightAnswer = rightAnswer;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString() + "\n");
		sb.append("The right answer is: " + rightAnswer + "\n");
		return sb.toString();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void setAnswer(String text) {
		rightAnswer = text;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getRightAnswer() {
		return rightAnswer;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public OpenQuestion(OpenQuestion another) {
		this.rightAnswer = another.rightAnswer;
		this.qText = another.qText;
		this.id = another.id;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean equals(OpenQuestion other) {
		if (this.qText.equals(other.qText) == false) {
			return false;
		} else if (this.rightAnswer.equals(other.rightAnswer) == false) {
			return false;
		} else {
			return true;
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
}