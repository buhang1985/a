package iih.ci.rcm.reportcardremind.bp;

import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 判断是否需要填写统一报卡(住院医生站住院诊断界面诊断签署时CI调用)
 */
public class ReportCardRemindBp {

	public ReportCardTypeDiagDO reportcardremind(String id_ent, String id_di) throws BizException {
		HasDiagPassBp bp = new HasDiagPassBp();
		ReportCardTypeDiagDO diagDo=bp.hasDiagPass(id_di);
		if(null!=diagDo && !StringUtil.isEmpty(diagDo.getId_bd_rcm_tp())){
			HasCiRcmPassBp bp1 = new HasCiRcmPassBp();
			Boolean isFlag=bp1.hasCiRcmPass(id_ent, diagDo.getId_bd_rcm_tp(), id_di);
			if(isFlag){
				return diagDo;
			}
		}

		return null;
	}
}
