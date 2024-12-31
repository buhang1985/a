package iih.ei.bl.ecinc.bosssoft.v2.s.data.manage;

import java.io.Serializable;

/**
 * 票据代码
 * @author ly 2020/01/02
 *
 */
public class EcManageIncCodeParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String billBatchCode;//票据代码

	public String getBillBatchCode() {
		return billBatchCode;
	}

	public void setBillBatchCode(String billBatchCode) {
		this.billBatchCode = billBatchCode;
	}
}
