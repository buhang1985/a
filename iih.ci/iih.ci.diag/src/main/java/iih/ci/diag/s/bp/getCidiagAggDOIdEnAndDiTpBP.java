package iih.ci.diag.s.bp;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.s.CiDiUtils;
import iih.ci.diag.s.bp.qry.getCidiagAggDOIdEnAndDiTpQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据 就诊和就诊类型 查询当前诊断
 * @return
 * @throws BizException
 */
public class getCidiagAggDOIdEnAndDiTpBP {
	
	 /**
	  * 根据 就诊和就诊类型 查询当前诊断
	  * @return
	  * @throws BizException
	  */
	public  CidiagAggDO getCidiagAggDOIdEnAndDiTp(String id_en,String id_ditp) throws BizException{
		
		getCidiagAggDOIdEnAndDiTpQry qry = new getCidiagAggDOIdEnAndDiTpQry(id_en,id_ditp);
		CiDiagDO[] codiag = (CiDiagDO[])AppFwUtil.getDORstWithDao(qry, CiDiagDO.class);
	     if(codiag == null) return  new CidiagAggDO();
	     return  CiDiUtils.getICidiagRService().findById(codiag[0].getId_di());
	}

}
