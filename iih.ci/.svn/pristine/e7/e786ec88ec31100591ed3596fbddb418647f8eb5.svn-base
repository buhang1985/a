package iih.ci.diag.s.ip.bp;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.pub.CiDiAppUtils;
import iih.ci.diag.s.CiDiUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

public class CancelCiDiagBP {
     /**
      * 作废住院诊断
      * @param id_ent
      * @return
      * @throws BizException
      */
	public CiDiagDO[] CancelCiDiagDO(String id_di,String id_emp)throws BizException{
		CiDiagDO cidiagDO = CiDiUtils.getICidiagMDORService().findById(id_di);
		cidiagDO.setFg_cancel(FBoolean.TRUE);
		cidiagDO.setId_emp_cancel(id_emp);
		cidiagDO.setDt_cancel(CiDiUtils.getSystemDateTime());
		cidiagDO.setStatus(DOStatus.UPDATED);
		CiDiagDO[] ciaiag = CiDiAppUtils.getICidiagMDOCudService().save(new CiDiagDO[]{cidiagDO});
		CogradientCiDiagToEnDiagBP cogradient = new CogradientCiDiagToEnDiagBP();
		cogradient.CogradientCiDiagToEnDiag(cidiagDO.getId_en());
		return ciaiag;
	}
}
