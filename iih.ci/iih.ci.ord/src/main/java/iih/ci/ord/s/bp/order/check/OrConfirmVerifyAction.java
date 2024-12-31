package iih.ci.ord.s.bp.order.check;

import iih.ci.ord.dto.confirm.OrConfirmRstDTO;
import iih.ci.ord.dto.confirm.OrConfirmVerifyParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 医嘱确认校验操作
 * @author zhangwq
 *
 */
public class OrConfirmVerifyAction {
	private OrConfirmVerifyParamDTO verifyParam;
	public OrConfirmVerifyAction(OrConfirmVerifyParamDTO verifyParam){
		this.verifyParam = verifyParam;
	}
	public OrConfirmRstDTO exec() throws BizException {
		FArrayList id_ors_chk = verifyParam.getId_ors_chk();
		if(id_ors_chk != null){
			OrConfirmVerifyChkAction chkAction = new OrConfirmVerifyChkAction(this.verifyParam);
			OrConfirmRstDTO rst = chkAction.exec();
			return rst;
		}
//		verifyParam.getId_ors_chk();
//		verifyParam.getId_ors_stop_canc();
		return null;
	}
	public OrConfirmVerifyParamDTO getVerifyParam() {
		return verifyParam;
	}
	public void setVerifyParam(OrConfirmVerifyParamDTO verifyParam) {
		this.verifyParam = verifyParam;
	}
	
}
