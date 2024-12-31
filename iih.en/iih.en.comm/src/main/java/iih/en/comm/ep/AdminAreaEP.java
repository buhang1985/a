package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;

/***
 * 基础数据-行政区划EP
 * @author zhangpp
 *
 */
public class AdminAreaEP {

	/**
	 * 根据id获取行政区划
	 * @param adminAreaId
	 * @return
	 * @throws BizException
	 */
	public AdminAreaDO getAdminAreaById(String adminAreaId) throws BizException{
		if(EnValidator.isEmpty(adminAreaId)){
			return null;
		}
		IAdminareaRService iAdminareaRService = ServiceFinder.find(IAdminareaRService.class);
		return iAdminareaRService.findById(adminAreaId);
	}
	
	/**
	 * 根据code获取行政区划
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public AdminAreaDO getAdminAreaByCode(String code) throws BizException{
		if(EnValidator.isEmpty(code)){
			return null;
		}
		IAdminareaRService iAdminareaRService = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] AdminAreas = iAdminareaRService.findByAttrValString(AdminAreaDO.CODE, code);
		return EnValidator.isEmpty(AdminAreas) ? null : AdminAreas[0];
	}
	
	/**
	 * 根据codes获取行政区划Map
	 * @param codes
	 * @return
	 * @throws BizException
	 */
	public Map<String, AdminAreaDO> getAdminAreasByCodeList(String[] codes) throws BizException{
		if(EnValidator.isEmpty(codes)){
			return null;
		}
		IAdminareaRService iAdminareaRService = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] adminAreas = iAdminareaRService.findByAttrValStrings(AdminAreaDO.CODE, codes);
		if (adminAreas == null) {
			return null;
		}
		Map<String, AdminAreaDO> map = new HashMap<String, AdminAreaDO>();
		for (AdminAreaDO adminAreaDO : adminAreas) {
			if (map.containsKey(adminAreaDO.getCode())) {
				continue;
			}
			map.put(adminAreaDO.getCode(), adminAreaDO);
		}
		return map;
	}
}
