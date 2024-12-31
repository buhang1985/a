package iih.ci.ord.s.external.thirdws.operation;

import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BizException;

public class CancelOrdManageBp {

	public String exec(String xmlparam){
		ThirdCancelOrdBP bp=new ThirdCancelOrdBP();
		//第三方入参校验并保存
		try {
			return bp.parseXml(xmlparam);
		} catch (BizException e) {
			return RstMsgBP.getRstMsg("1", e.getMessage());
		}
		
		
	}

}
