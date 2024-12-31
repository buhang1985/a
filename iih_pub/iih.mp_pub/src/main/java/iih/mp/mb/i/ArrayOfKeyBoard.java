package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfKeyBoard {
	@JsonProperty(value = "KeyBoard")
	private KeyBoard[] KeyBoard;

	public void setKeyBoard(KeyBoard[] KeyBoard) {
		this.KeyBoard = KeyBoard;
	}

	public KeyBoard[] getKeyBoard() {
		return this.KeyBoard;
	}
}
