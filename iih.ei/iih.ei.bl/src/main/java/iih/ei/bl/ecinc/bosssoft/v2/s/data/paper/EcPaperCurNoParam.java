package iih.ei.bl.ecinc.bosssoft.v2.s.data.paper;

import java.io.Serializable;

/**
 * 获取纸质票据当前号参数
 * @author ly 2020/01/02
 *
 */
public class EcPaperCurNoParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String placeCode;//开票点编码
	private String pBillBatchCode;//纸质票据代码
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
	public String getpBillBatchCode() {
		return pBillBatchCode;
	}
	public void setpBillBatchCode(String pBillBatchCode) {
		this.pBillBatchCode = pBillBatchCode;
	}
}
