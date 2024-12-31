package iih.bd.srv.s.bp;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.SrvRtCtl8EmpInfoQry;
import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 获得医生的医嘱开立服务权限集合信息操作BP
 */
public class GetSrvRtCtlInfo4EmpBP {
	/**
	 * 获得医生的医嘱开立服务权限集合信息
	 * @param id_org
	 * @param id_emp
	 * @param id_entp
	 * @return
	 * @throws BizException
	 */
	public String exec(String id_org,String id_emp,String id_entp)throws BizException {
		if(BdSrvUtils.isEmpty(id_org) || BdSrvUtils.isEmpty(id_emp) || BdSrvUtils.isEmpty(id_entp))return null;
		SrvRtCtl8EmpInfoQry qry = new SrvRtCtl8EmpInfoQry(id_org,id_emp,id_entp);
		SrvRtEmpRefDO[] rtn = (SrvRtEmpRefDO[])AppFwUtil.getDORstWithDao(qry, SrvRtEmpRefDO.class);
		return getSrvRtIDs(rtn);
		
	}
	
	/**
	 * 获得有效服务开立权限数据信息
	 * @param rtn
	 * @param id_entp
	 * @return
	 */
	private String getSrvRtIDs(SrvRtEmpRefDO[] rtn){
		//有效性校验
		if(BdSrvUtils.isEmpty(rtn))return null;
		
		//参数设置
		String rtnstr="";
		
		//遍历
		for(int i=0;i<rtn.length;i++){
			rtnstr+=BdSrvUtils.COMMA_STR+rtn[i].getId_srvrt();  
		}
		
		return rtnstr.substring(1);
	}
}
