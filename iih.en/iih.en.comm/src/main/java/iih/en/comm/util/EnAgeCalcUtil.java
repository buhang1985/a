package iih.en.comm.util;

import iih.en.comm.bp.EnAgeCalcBP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnAgeCalcDTO;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.util.AgeCalcUtil;

/**
 * 就诊年龄计算帮助类
 * 
 * @author liubin
 *
 */
public class EnAgeCalcUtil {
	/**
	 * 获取就诊年龄Map
	 * 
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	public static Map<String, String> getAgeMap(String[] entIds) throws BizException{
		if(EnValidator.isEmpty(entIds))
			return null;
		Map<String, String> map = new HashMap<>();
		for(String entId : entIds)
			map.put(entId, "不详");
		EnAgeCalcDTO[] enCalcDTOs = new EnAgeCalcBP().exec(entIds);
		FDateTime curTime = EnAppUtils.getServerDateTime();
		if(!EnValidator.isEmpty(enCalcDTOs)){
			for(EnAgeCalcDTO enCalcDTO : enCalcDTOs){
				if(!EnValidator.isEmpty(enCalcDTO.getId_ent()) && map.containsKey(enCalcDTO.getId_ent())){
					FDateTime endTime = null;
					if(FBoolean.TRUE.equals(enCalcDTO.getFg_ip()) && FBoolean.TRUE.equals(enCalcDTO.getFg_newborn())){
						endTime = curTime;
					}else{
						endTime = enCalcDTO.getDt_acpt() != null ? enCalcDTO.getDt_acpt() : enCalcDTO.getDt_entry();
					}
					if(enCalcDTO.getDt_birth_hms()!=null)
						map.put(enCalcDTO.getId_ent(), AgeCalcUtil.getAge(enCalcDTO.getDt_birth_hms(), endTime));
					else
						map.put(enCalcDTO.getId_ent(), AgeCalcUtil.getAge(enCalcDTO.getDt_birth(), endTime));
				}
			}
		}
		return map;
	}
	/**
	 * 对DO或DTO集合中年龄字段赋值
	 * 
	 * @param dos 
	 * 		DO或DTO集合
	 * @param entIdkeyPropName 
	 * 		DO或DTO中Id_ent字段名
	 * @param agekeyPropName
	 * 		DO或DTO中年龄字段名
	 * @throws BizException 
	 */
	public static <T extends BaseDO> void setDoAges(T[] dos, String entIdkeyPropName, String agekeyPropName) throws BizException {
		if(dos == null || EnValidator.isEmpty(entIdkeyPropName) || EnValidator.isEmpty(agekeyPropName))
			return;
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO(entIdkeyPropName, dos);
		if(EnValidator.isEmpty(entIds))
			return;
		Map<String, String> map = getAgeMap(entIds);
		if(map == null || map.size() <=0)
			return;
		for(T d : dos){
			BaseDO baseDo = (BaseDO)d;
			if(baseDo == null)
				continue;
			Object val = baseDo.getAttrVal(entIdkeyPropName);
			if(val == null)
				continue;
			String key = (String)val;
			if(map.containsKey(key))
				baseDo.setAttrVal(agekeyPropName, map.get(key));
		}
	}
}
