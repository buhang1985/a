package iih.ci.diag.dto.s.bp;

import iih.ci.diag.dto.d.IpViewDiagDTO;
import iih.ci.diag.dto.s.qry.getCiDiagItemDOlistQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getCiDiagItemDOlistBP {
  
	/**
    * 诊断明细信息
    * @param id_ent
    * @return
    * @throws BizException
    */
	public IpViewDiagDTO[]  exec(String id_ent)throws BizException{
		getCiDiagItemDOlistQry qry = new getCiDiagItemDOlistQry(id_ent);
		IpViewDiagDTO [] rtn=(IpViewDiagDTO[])AppFwUtil.getDORstWithDao(qry, IpViewDiagDTO.class);
		return rtn;
	}
	
}
