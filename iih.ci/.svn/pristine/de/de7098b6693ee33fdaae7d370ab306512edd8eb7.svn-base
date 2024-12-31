package iih.ci.diag.s.ip.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.bizgrp.d.BizGrpEmpsDO;
import iih.ci.diag.pub.CiDiagConstant;
import iih.ci.diag.pub.CommonUtil;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 增加【住院诊断作废模式】参数。
       参数级别：组织 
       参数命名：IpDiCancModel
       参数值：01不允许作废、11任意医生可作废、12本人及上级医生可作废、13本人可作废 
       默认值：01 不允许作废
 * @author li_zheng
 *
 */
public class IpDiCancelModeSetBP {
	 /**
	    * 
	    * @param parameter  组织
	    * @param Id_wg_phy  诊疗组
	    * @param id_emp_sign 签署人
	    * @param id_psn    当前操作人
	    * @return
	    * @throws BizException
	    */
		public String getIpDiCancelModeSet(String parameter,String Id_wg_phy,String id_emp_sign,String id_psn) throws BizException{
			 String validateMeag = ValidateParamater(id_emp_sign,id_psn);
			 if(!StringUtils.isBlank(validateMeag)) return validateMeag;
			 String param = CommonUtil.getIpDiCancelModeSet(parameter);
			 if(CiDiagConstant.sys_IpDiCancelModeSet_01.equals(param)){
				 //01不允许作废
				 return "签署的诊断的不允许撤回!";
			 }else {
				 //11任意医生可作废、12本人及上级医生可作废、13本人可作废 
				 if(CiDiagConstant.sys_IpDiCancelModeSet_11.equals(param)){
					 return ""; 
				  }
				 if(CiDiagConstant.sys_IpDiCancelModeSet_12.equals(param)){
					 if(id_emp_sign.equals(id_psn)){
						  return ""; 
					  }else{
					    return JudgeSignEmp(Id_wg_phy,id_emp_sign,id_psn); 
					  }	 
				  }
				 if(CiDiagConstant.sys_IpDiCancelModeSet_13.equals(param)){
					  if(id_emp_sign.equals(id_psn)){
						  return ""; 
					  }else{
						 return "只有本人可以作废 ";	 
					  }
				  }
				 return "住院诊断维护作废参数异常"; 
			 }
		}
		/**
		 * 判断签署人和当前人是否在一个诊疗组合 
		 * 或者是上级医生
		 * @param Id_wg_phy
		 * @param id_emp_sign
		 * @param id_psn
		 * @return
		 */
		private String JudgeSignEmp(String Id_wg_phy,String id_emp_sign,String id_psn)throws BizException{
			//Id_wg_phy ="1001Z71000000002N3MY";//测试数据
			StringBuffer sb =  new StringBuffer();
			sb.append(" select wg.sd_signlevel,wg.id_wg,wg.id_emp from bd_emp_wg  wg ");
			sb.append("  where  id_wg='");
			sb.append(Id_wg_phy);
			sb.append("'  and id_emp in ('");
			sb.append(id_emp_sign+"','"+id_psn+"')");
	        DAFacade dafacade = new DAFacade();
	        List<BizGrpEmpsDO> list = (List<BizGrpEmpsDO>) dafacade.execQuery(sb.toString(), new BeanListHandler(BizGrpEmpsDO.class));	
	        if(list != null && list.size()==1){
				return "不在一个诊疗组,不能撤回";
			}
	        if(list != null && list.size()==2){
	        	BizGrpEmpsDO empdo = list.get(0);
	        	BizGrpEmpsDO empdo2 = list.get(1);
	        	if(StringUtils.isBlank(empdo.getSd_signlevel())|| StringUtils.isBlank(empdo2.getSd_signlevel())){
	        		return "审签级别为空，请维护业务组的审签级别";
	        	}
	        	if(empdo.getId_emp().equals(id_psn) && empdo.getSd_signlevel().compareTo(empdo2.getSd_signlevel()) >0){
	        		return "";
	        	}else if(empdo2.getId_emp().equals(id_psn) && empdo2.getSd_signlevel().compareTo(empdo.getSd_signlevel()) >0){
	        		return "";
	        	}else{
	        		return "你的审签级别小于签署人的审签级别，不能撤回";
	        	}
	        } 
	        return "当前操作医生和诊断的签署医生不在一个诊疗组";
		}
		/**
		 * 
		 * @param Id_wg_phy
		 * @param id_emp_sign
		 * @param id_psn
		 * @return
		 */
		private String ValidateParamater(String id_emp_sign,String id_psn){
			if(StringUtils.isBlank(id_emp_sign)
				||StringUtils.isBlank(id_psn))
				return " 参数   签署人 和当前操作人  为空";
			return "";
		}
	}

