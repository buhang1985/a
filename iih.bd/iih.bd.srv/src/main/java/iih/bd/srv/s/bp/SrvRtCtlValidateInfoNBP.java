package iih.bd.srv.s.bp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.CiOrdUtils;
import iih.bd.srv.srvrtctl.d.SrvRtCtlDTO;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import iih.bd.srv.srvrtempref.d.SrvRtEmpRefDO;
import xap.mw.core.data.BizException;

/*
 * 医嘱开立服务开立权限有效性判断操作BP
 * （获得未授权的服务列表）
 */
public class SrvRtCtlValidateInfoNBP {
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
		GetSrvRtCtlInfosNBP bp=new GetSrvRtCtlInfosNBP();
		SrvRtCtlDTO[] srvrtctls=bp.exec(rtctlparam);
		
		//是否有权限控制服务判断
		if(BdSrvUtils.isEmpty(srvrtctls))return null;
		
		//判断物品是否限制的物品
		srvrtctls = IdMmJudge(srvrtctls,rtctlparam);
		if(BdSrvUtils.isEmpty(srvrtctls))return null;
		//获得医生服务开立权限集合信息
		GetSrvRtCtlInfo4EmpNBP bp1=new GetSrvRtCtlInfo4EmpNBP();
		//String emprtctl=null;
		SrvRtEmpRefDO[] emprtdo=bp1.exec(rtctlparam.getId_org(), rtctlparam.getId_emp_doctor(),rtctlparam.getId_entp());

		//权限判断
		if(BdSrvUtils.isEmpty(emprtdo))return delDuplRtca(srvrtctls);
		
		//获得未授权的服务信息
		return getUnRtCtInfos(srvrtctls,emprtdo);
	}
	
	//签署的物品不在限制的物品内则去掉
	private SrvRtCtlDTO[] IdMmJudge(SrvRtCtlDTO[] srvrtctls, SrvRtCtlParam rtctlparam) {
		if(CiOrdUtils.isEmpty(rtctlparam.getId_mms()))return srvrtctls;
		
		List <SrvRtCtlDTO> rtCtlDTOs =  new ArrayList<SrvRtCtlDTO>(srvrtctls.length);
		Collections.addAll(rtCtlDTOs, srvrtctls);
		
		for (SrvRtCtlDTO srvRtCtlDTO : srvrtctls) {
			if(StringUtils.isNotEmpty(srvRtCtlDTO.getId_mm())
					&& rtctlparam.getId_srvs().contains(srvRtCtlDTO.getId_srv()) 
					&& ( !rtctlparam.getId_mms().contains(srvRtCtlDTO.getId_mm()))) {
				rtCtlDTOs.remove(srvRtCtlDTO);
			}
		}
		if(rtCtlDTOs == null || rtCtlDTOs.size()<=0) {
			return null;
		}
		return (rtCtlDTOs.toArray(new SrvRtCtlDTO[rtCtlDTOs.size()]));
	}


	/**
	 * 获得未授权的服务列表
	 * @param srvrtctls
	 * @param emprtctl
	 * @return
	 */
	private SrvRtCtlDTO[] getUnRtCtInfos(SrvRtCtlDTO[] srvrtctls,SrvRtEmpRefDO[] emprtdo){
		//参数定义
		String emprtctl="";
		ArrayList<SrvRtCtlDTO> list=new ArrayList<SrvRtCtlDTO>();
		String id_srvrt=null,id_srvs="",id_srvrtca="",Ctrl5="";
		int ilevel=0;
		boolean isTrue=false;
		//同限制分类下，取第一个就行了
		List<String> hasIdSrvrtcas = new ArrayList<String>();
		//遍历
		for(int i=0;i<srvrtctls.length;i++){
			id_srvrtca=srvrtctls[i].getId_srvrtca();
			if(hasIdSrvrtcas.contains(id_srvrtca)){
				continue;
			}
			id_srvrt=srvrtctls[i].getId_srvrt();
			Ctrl5=srvrtctls[i].getCtrl5();
			ilevel=getLevelV(srvrtctls[i].getCode());
			isTrue=false;
			for(int j=0;j<emprtdo.length;j++){
                if(Ctrl5==null||!Ctrl5.equals("Y")){
                	
                	if(id_srvrt.equals(emprtdo[j].getId_srvrt())){
                		
                		id_srvs+=BdSrvUtils.COMMA_STR+srvrtctls[i].getId_srv();  //有权限
    					isTrue=true;
    					break;
                	}
                	
                }else if(Ctrl5.equals("Y")){
                	
                	if(id_srvrtca.equals(emprtdo[j].getId_srvrtempref()) && 
         				   (ilevel<=emprtdo[j].getDs())){
                		id_srvs+=BdSrvUtils.COMMA_STR+srvrtctls[i].getId_srv();  //有权限
    					isTrue=true;
    					break;
                	}
                	
                }else{
                	
                }
//				if((Ctrl5!=null&&Ctrl5.equals("Y")&&id_srvrtca.equals(emprtdo[j].getId_srvrtempref()) && 
//				   (//id_srvrt.equals(emprtdo[j].getId_srvrt()) &&     //li_cheng  将||改成&& 比较权限级别的前提是 id_srvrt必须一样
//				    ilevel<=emprtdo[j].getDs())
//				  )||((Ctrl5==null||!Ctrl5.equals("Y"))&&id_srvrt.equals(emprtdo[j].getId_srvrt()))){
//					id_srvs+=BdSrvUtils.COMMA_STR+srvrtctls[i].getId_srv();  //有权限
//					isTrue=true;
//					break;
//				}else{}
			}
			if(!isTrue){
				list.add(srvrtctls[i]);
				hasIdSrvrtcas.add(srvrtctls[i].getId_srvrtca());
			}  //没权限的
		}
		
		//返回值判断与处理
		if(BdSrvUtils.isEmpty(list))return null;
		rtnHandle(list,id_srvs);
		if(BdSrvUtils.isEmpty(list))return null;
		return (SrvRtCtlDTO[]) list.toArray((SrvRtCtlDTO[]) Array.newInstance(SrvRtCtlDTO.class, 0));
	}
	
	/**
	 * 返回值处理
	 * @param list
	 * @param id_srvs
	 */
	private void rtnHandle(ArrayList<SrvRtCtlDTO> list,String id_srvs){
		//有效性判断
		if(BdSrvUtils.isEmpty(id_srvs))return;
		
		//参数定义
		int iN=list.size();
		SrvRtCtlDTO rtctldto=null;
		
		//遍历
		for(int i=iN-1;i>=0;i--){
			rtctldto=(SrvRtCtlDTO)list.get(i);
			if(BdSrvUtils.isInStr(rtctldto.getId_srv(), id_srvs)){
				list.remove(i);
			}
		}
	}
	
	/**
	 * 获得级次数   1 2 3 4 5 6
	 * 非级次权限类型 为空  或 0
	 * @param priorityCode
	 * @return
	 */
	private int getLevelV(String priorityCode){
		if(BdSrvUtils.isEmpty(priorityCode)){
			return 0;
		}else{
			try{
				return Integer.valueOf(priorityCode); 
			}catch(Exception e){
				return 0;
			}
		}
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
	/**
	 * 删除开立权限分类，只保留一个
	 * @param srvrtctls
	 * @return
	 */
	private SrvRtCtlDTO[] delDuplRtca(SrvRtCtlDTO[] srvrtctls){
		//同限制分类下，取第一个就行了
		List<String> hasIdSrvrtcas = new ArrayList<String>();
		List<SrvRtCtlDTO> rsts = new ArrayList<SrvRtCtlDTO>();
		for (SrvRtCtlDTO srvRtCtlDTO : srvrtctls) {
			if(hasIdSrvrtcas.contains(srvRtCtlDTO.getId_srvrtca())){
				continue;
			}else{
				hasIdSrvrtcas.add(srvRtCtlDTO.getId_srvrtca());
			}
			rsts.add(srvRtCtlDTO);
		}
		return rsts.toArray(new SrvRtCtlDTO[0]);		
	}
}
