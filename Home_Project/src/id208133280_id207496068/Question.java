package id208133280_id207496068;

public abstract class Question {
	protected int id;
	private static int counter = 1;
	protected String qText;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Question(String qText) {
		this.qText = qText;
		this.id = counter++;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Question() {
		this.qText = "";
		this.id = -1;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Question text: " + qText);
		return sb.toString();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int getId() {
		return id;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getqText() {
		return qText;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void setqText(String qText) {
		this.qText = qText;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean Equals(Question other) {
		if (other.id == this.id) {
			return true;
		} else if (other.qText.equals(this.qText)) {
			return true;
		} else {
			return false;
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
}
