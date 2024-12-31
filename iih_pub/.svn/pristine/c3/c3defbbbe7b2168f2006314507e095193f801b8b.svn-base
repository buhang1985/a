package iih.pe.pds.i;

import iih.pe.pds.pedsdeptime.d.PeDsDeptimeChkDO;
import xap.mw.core.data.BizException;

public interface IPeDsDeptimeMaintainService {
	
	//计算科室平均检查时间
	public PeDsDeptimeChkDO[] computeDeptTime(String dt_begin,String dt_end,PeDsDeptimeChkDO[] timeChkDos) throws BizException;

	//优化科室检查时间
	 public void optimizeDpetTime(PeDsDeptimeChkDO[] chkDos) throws BizException;
}
