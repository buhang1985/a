package iih.ei.std.s.v1.bp.common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iih.ei.std.d.v1.utils.EiValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;
/***
 * 基础数据-行政区划EP
 * @author li.wm
 *
 */
public class EiAdminAreaEP {

	/**
	 * 根据codes获取行政区划Map
	 * @param codes
	 * @return
	 * @throws BizException
	 */
	public Map<String, AdminAreaDO> getAdminAreasByCodeList(String[] codes) throws BizException{
		if(ArrayUtil.isEmpty(codes)){
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
