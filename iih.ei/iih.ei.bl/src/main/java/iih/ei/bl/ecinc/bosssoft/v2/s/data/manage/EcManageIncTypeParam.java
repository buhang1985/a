package iih.ei.bl.ecinc.bosssoft.v2.s.data.manage;

import java.io.Serializable;
import java.util.List;

/**
 * 票据种类
 * @author ly 2020/01/02
 *
 */
public class EcManageIncTypeParam implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	private String billCode;//票据种类编码
	private List<EcManageIncCodeParam> billBatchCodeList;//票据代码列表
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public List<EcManageIncCodeParam> getBillBatchCodeList() {
		return billBatchCodeList;
	}
	public void setBillBatchCodeList(List<EcManageIncCodeParam> billBatchCodeList) {
		this.billBatchCodeList = billBatchCodeList;
	}
}
