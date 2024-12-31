package iih.bl.inc.dto.eincoutparamdto.d;

import java.io.Serializable;

/**
 * 电子票据开具接口入参其它扩展信息列表
 * 
 * @author shaokx 2019.12.14
 *
 */
public class BlEIncOutOtherInfoParam implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String infoName;//扩展信息名称
	private String infoValue;//扩展信息值

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public String getInfoValue() {
		return infoValue;
	}

	public void setInfoValue(String infoValue) {
		this.infoValue = infoValue;
	}
	
	
}
