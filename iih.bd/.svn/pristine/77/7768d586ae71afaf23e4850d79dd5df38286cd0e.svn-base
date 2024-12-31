package iih.bd.srv.s.bp;

import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.bd.srv.s.bp.qry.SrvReactInfoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 根据服务条件串获得服务互斥信息数据集合操作BP
 */
public class GetSrvReactInfosBP {
	/**
	 * 根据服务条件串获得服务互斥信息数据集合
	 * @param srvcondstr
	 * @return
	 * @throws BizException
	 */
	public SrvReactDTO[] exec(String srvcondstr)throws BizException {
		SrvReactInfoQry qry = new SrvReactInfoQry(srvcondstr);
		SrvReactDTO[] rtn = (SrvReactDTO[])AppFwUtil.getDORstWithDao(qry, SrvReactDTO.class);
		return rtn;
	}
}
