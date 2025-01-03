package iih.ci.rcm.reportcardremind.bp;

import iih.bd.srv.reportcardtypediagdo.d.ReportCardTypeDiagDO;
import iih.bd.srv.reportcardtypediagdo.i.IReportcardtypediagdoRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 *  判断当前诊断是否关联报卡类型并且需要提醒填写报卡，如果关联则返回报卡类型主键
 */
public class HasDiagPassBp {

	public ReportCardTypeDiagDO hasDiagPass(String id_di) throws BizException {
		IReportcardtypediagdoRService diagSer=ServiceFinder.find(IReportcardtypediagdoRService.class);
		if (id_di != null) {
			ReportCardTypeDiagDO [] diagDos=diagSer.findByAttrValString("Id_di", id_di);
			if(diagDos!=null && diagDos.length>0){
				if(FBoolean.TRUE==diagDos[0].getFg_remind()){
				return diagDos[0];
				}
			}	
		}
		return null;
	}
}
