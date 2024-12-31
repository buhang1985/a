package iih.bd.srv.s.bp;

import java.lang.reflect.Array;
import java.util.ArrayList;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import xap.mw.core.data.BizException;

/*
 * 医嘱开立服务开立权限有效性判断操作BP
 * （获得未授权的服务列表）
 * （已经废弃不用了）
 */
public class SrvRtCtlValidateInfoBP {
	/**
	 * 医嘱开立服务开立权限有效性判断
	 * 获得未授权的服务列表
	 * @param rtctlparam
	 * @return 返回没有权限的服务
	 * @throws BizException
	 */
	public SrvRtCtlDTO[] exec(SrvRtCtlParam rtctlparam)throws BizException {
		if(BdSrvUtils.isEmpty(rtctlparam))return null;
		
		//获得受权限控制的服务数据集合信息
		GetSrvRtCtlInfosBP bp=new GetSrvRtCtlInfosBP();
		SrvRtCtlDTO[] srvrtctls=bp.exec(rtctlparam);
		
		//是否有权限控制服务判断
		if(BdSrvUtils.isEmpty(srvrtctls))return null;
		
		//获得医生服务开立权限集合信息
		GetSrvRtCtlInfo4EmpBP bp1=new GetSrvRtCtlInfo4EmpBP();
		String emprtctl=bp1.exec(rtctlparam.getId_org(), rtctlparam.getId_emp_doctor(),rtctlparam.getId_entp());
		
		//权限判断
		if(BdSrvUtils.isEmpty(emprtctl))return srvrtctls;
		
		//获得未授权的服务信息
		return getUnRtCtInfos(srvrtctls,emprtctl);
	}
	
	/**
	 * 获得未授权的服务列表
	 * @param srvrtctls
	 * @param emprtctl
	 * @return
	 */
	private SrvRtCtlDTO[] getUnRtCtInfos(SrvRtCtlDTO[] srvrtctls,String emprtctl){
		ArrayList<SrvRtCtlDTO> list=new ArrayList<SrvRtCtlDTO>();
		String id_srvrt=null;
		for(int i=0;i<srvrtctls.length;i++){
			id_srvrt=srvrtctls[i].getId_srvrt();
			if(!BdSrvUtils.isInStr(id_srvrt, emprtctl)){
				list.add(srvrtctls[i]);
			}
		}
		if(BdSrvUtils.isEmpty(list))return null;
		return (SrvRtCtlDTO[]) list.toArray((SrvRtCtlDTO[]) Array.newInstance(SrvRtCtlDTO.class, 0));
	}

}
