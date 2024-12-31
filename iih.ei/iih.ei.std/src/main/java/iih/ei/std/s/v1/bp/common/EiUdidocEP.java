package iih.ei.std.s.v1.bp.common;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iih.ei.std.d.v1.utils.EiValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;
/**
 * 基础数据 - 自定义档案EP
 * 
 * @author li.wm
 * @date 2019-11-29
 *
 */
public class EiUdidocEP {

	/**
	 * 根据自定义档案类型集合查询自定义档案，返回map zhangpp
	 * @param udidocCodeList 自定义档案类型集合
	 * @return
	 * @throws BizException
	 */
	public Map<String,Map<String,UdidocDO>> getUdiDocsMapByCodes(String[] udidocCodes) throws BizException {
		EiValidator.validateParam("自定义档案类型编码为空", udidocCodes);
		IUdidoclistRService iUdidoclistRService = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] udidoLists = iUdidoclistRService.findByAttrValStrings("Code", udidocCodes);
		ArrayList<String> udiListIdList = new ArrayList<String>();
		for (UdidoclistDO udidoList : udidoLists) {
			if (udiListIdList.contains(udidoList.getId_udidoclist())) {
				continue;
			}
			udiListIdList.add(udidoList.getId_udidoclist());
		}
		IUdidocRService iUdidocRService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] udidos =iUdidocRService.findByAttrValStrings("Id_udidoclist", udiListIdList.toArray(new String[0]));
		if(ArrayUtil.isEmpty(udidos)){
			return null;
		}
		Map<String, Map<String, UdidocDO>> map = new HashMap<String, Map<String,UdidocDO>>();
		for(UdidocDO udido:udidos){
			 if(map.containsKey(udido.getUdi_code())){
				 map.get(udido.getUdi_code()).put(udido.getCode(), udido);
			 }else {
				 Map<String, UdidocDO> udiMap = new HashMap<String, UdidocDO>();
				 udiMap.put(udido.getCode(), udido);
				 map.put(udido.getUdi_code(), udiMap);
			}
		}
		return map;
	}
	
}
