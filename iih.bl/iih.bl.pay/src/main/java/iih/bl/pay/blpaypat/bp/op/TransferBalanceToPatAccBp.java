package iih.bl.pay.blpaypat.bp.op;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import xap.mw.core.data.BizException;

public class TransferBalanceToPatAccBp {
	/**
	 * 门诊零钱转预交金
	 * */
	public BlPrePayPatDO[] transferBalanceToPatAcc(BlPayItmPatOepDO blPayPatItmDo,String id_pat,OperatorInfoDTO operatorInfoDTO,String entType,String note)
	throws BizException{
		//整合到一个方法里
		//return saveBlPayPatInfoRefund(blPayPatItmDo.getAmt(),id_pat,operatorInfoDTO,1,entType,IBlDictCodeConst.SD_PAYTP_CODE_HZYJ,IBlDictCodeConst.SD_PAYTP_ID_HZYJ,note);
		PrepayPatOpBp  prepaybp =new PrepayPatOpBp();
		BlPrePayPatDO[] doArr=	prepaybp.saveBlPayPatInfoRefund(blPayPatItmDo.getAmt(),id_pat,operatorInfoDTO,1,entType,IBlDictCodeConst.SD_PAYTP_OPPREPAY,IBlDictCodeConst.ID_PAYTP_OPPREPAY,note);
		return doArr;
	}
	
}
