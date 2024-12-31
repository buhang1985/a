package iih.en.comm.ep;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.en.comm.validator.EnValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 基础数据--医保EP
 * 
 * @author renying
 * @since 2017-4-7
 *
 */
public class HpEP {

	/**
	 * 基础数据--部门EP
	 * 
	 * @author renying
	 * @since 2017-4-7
	 *
	 */
	public Map<String,HPDO > getHpDOs(List<String> hpIdList)  throws BizException{
		if (EnValidator.isEmpty(hpIdList))
			return new HashMap<String, HPDO>();
		IHpMDORService rservice = ServiceFinder.find(IHpMDORService.class);
		HPDO[] hpdo = rservice.findByIds(hpIdList.toArray(new String[0]), FBoolean.FALSE);
		
		 Map<String, HPDO> hpMap = new HashMap<String,HPDO>();
		 for(HPDO hppt:hpdo){
			 if(hpMap.containsKey(hppt.getId_hp()))
				 continue;
			 hpMap.put(hppt.getId_hp(), hppt);
		 }
		 return hpMap;
	}
	/**
	 * 获取医保信息
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public HPDO getHpByCode(String code) throws BizException{
		if(EnValidator.isEmpty(code))
			return null;
		IHpMDORService serv = ServiceFinder.find(IHpMDORService.class);
		HPDO[] hpdos = serv.find(String.format(" Code = '%s' and Fg_active = '%s' ", code, FBoolean.TRUE), null, FBoolean.FALSE);
		return EnValidator.isEmpty(hpdos) ? null : hpdos[0];
	}
}
