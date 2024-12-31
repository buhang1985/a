package iih.bd.srv.s.bp;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.SrvRtCtl8EmpInfoNQry;
import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 获得医生的医嘱开立服务权限集合信息操作BP
 */
public class GetSrvRtCtlInfo4EmpNBP {
	/**
	 * 获得医生的医嘱开立服务权限集合信息
	 * @param id_org
	 * @param id_emp
	 * @param id_entp
	 * @return
	 * @throws BizException
	 */
	public SrvRtEmpRefDO[] exec(String id_org,String id_emp,String id_entp)throws BizException {
		//有效性判断
		if (BdSrvUtils.isEmpty(id_org) || BdSrvUtils.isEmpty(id_emp)
				|| BdSrvUtils.isEmpty(id_entp))
			return null;
		
		//创建查询sql
		SrvRtCtl8EmpInfoNQry qry = new SrvRtCtl8EmpInfoNQry(id_org,id_emp,id_entp);
		
		//返回结果值
		SrvRtEmpRefDO[] rtn = (SrvRtEmpRefDO[])AppFwUtil.getDORstWithDao(qry, SrvRtEmpRefDO.class);
		return rtn;//getSrvRtIDs(rtn);
		
	}

}
