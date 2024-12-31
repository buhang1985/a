package iih.ei.bl.ecinc.bosssoft.v2.s.data.manage;

import java.io.Serializable;
import java.util.List;

/**
 * 获取纸质票据有效票据代码出参
 * @author ly 2020/01/02
 *
 */
public class EcManagePaperActOutParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<EcManageIncTypeParam> billCodeList;//票据种类列表

	public List<EcManageIncTypeParam> getBillCodeList() {
		return billCodeList;
	}

	public void setBillCodeList(List<EcManageIncTypeParam> billCodeList) {
		this.billCodeList = billCodeList;
	}
}
