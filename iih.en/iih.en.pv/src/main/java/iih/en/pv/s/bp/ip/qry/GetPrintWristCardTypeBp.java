package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.IEnRuleConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.WristCardTypeDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.HashMap;
import java.util.Map;

import xap.lui.system.rulemgr.XapRuleAPI;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 查打印腕带的方式
 * @author lilei
 *
 */

public class GetPrintWristCardTypeBp {
	private static String KEY_WRISTCARDTYPEDTO = "wristCardTypeDTO";
	
	public String getPrintWristCardType(String idEnt,String funCode) throws BizException{
		if(EnValidator.isEmpty(idEnt) || EnValidator.isEmpty(funCode))
			return null;
		//查就诊记录
		PvEP pvEp = new PvEP();
		PatiVisitDO pvDo = pvEp.getPvById(idEnt);
		if(pvDo == null){
			return null;
		}
		//按年龄判断是不是儿童
		int days = FDateTime.getDaysBetween(pvDo.getDt_birth_pat(), EnAppUtils.getServerDate());
		int maxDays = EnParamUtils.getMaxNewbbDays();
		FBoolean isChild = new FBoolean(days <= maxDays);
		//按Fg_newborn判断是不是儿童
		IpEP ipEP = new IpEP();
		InpatientDO ipDo = ipEP.getIpByEntId(idEnt);
		if(ipDo ==null){
			ipDo = new InpatientDO();
		}
		FBoolean isNb = ipDo.getFg_newborn();
		
		Map<String, Object> varies = new HashMap<String, Object>();
		WristCardTypeDTO wristCardTypeDTO = new WristCardTypeDTO();
		wristCardTypeDTO.setId_ent(idEnt);
		wristCardTypeDTO.setFun_code(funCode);
		wristCardTypeDTO.setIs_child(isChild);
		wristCardTypeDTO.setIs_nb(isNb);
		varies.put(KEY_WRISTCARDTYPEDTO, wristCardTypeDTO);
		Map<String, Object> results = XapRuleAPI.exeRule(IEnRuleConst.EN_IP_PRINTWRISTCARDTYPE, varies);
		if(results == null){
			return null;
		}
		return (String) results.get(funCode);
	}
}
