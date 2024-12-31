package iih.bd.srv.s.bp;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.GetSrvReactItemDOQry;
import iih.bd.srv.srvreact.d.SrvReactItemDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 服务互斥关系回填服务类型名称
 */
public class GetSrvReactItemDOBP {
	public SrvReactItemDO[] exec(String ids)throws BizException {
		//有效性校验
		if(BdSrvUtils.isEmpty(ids))return null;
		GetSrvReactItemDOQry qry = new GetSrvReactItemDOQry(ids);
		SrvReactItemDO[] rtn = (SrvReactItemDO[])AppFwUtil.getDORstWithDao(qry, SrvReactItemDO.class);
		return rtn;
	}
}