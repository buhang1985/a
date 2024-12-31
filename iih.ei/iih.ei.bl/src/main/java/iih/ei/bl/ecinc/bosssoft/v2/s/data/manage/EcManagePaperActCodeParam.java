package iih.ei.bl.ecinc.bosssoft.v2.s.data.manage;

import java.io.Serializable;

/**
 * 获取纸质票据有效票据代码参数
 * @author ly 2020/01/02
 *
 */
public class EcManagePaperActCodeParam implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String placeCode;//开票点编码

	public String getPlaceCode() {
		return placeCode;
	}

	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
}
