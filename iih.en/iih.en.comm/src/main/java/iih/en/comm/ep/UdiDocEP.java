package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidocServiceExt;
import xap.sys.xbd.udi.i.IUdidoclistRService;

/**
 * 基础数据 - 自定义档案EP
 * 
 * @author zhengcm
 * @date 2016-07-07 14:33:50
 *
 */
public class UdiDocEP {
	public UdiDocEP() {

	}

	/**
	 * 根据主键查询自定义档案DO
	 * 
	 * @param udidocId
	 *            自定义档案主键
	 * @return 自定义档案DO
	 * @throws BizException
	 */
	public UdidocDO getUdiDocById(String udidocId) throws BizException {
		EnValidator.validateParam("自定义档案ID", udidocId);
		// 自定义档案查询服务
		IUdidocRService qryService = ServiceFinder.find(IUdidocRService.class);
		return qryService.findById(udidocId);
	}
	
	/**
	 * 根据主键查询自定义档案DO
	 * 
	 * @param udidocIds
	 *            自定义档案主键
	 * @return 自定义档案DO
	 * @throws BizException
	 */
	public UdidocDO[] getUdiDocByIds(String[] udidocIds) throws BizException {
		if(EnValidator.isEmpty(udidocIds)) 
			return null;
		// 自定义档案查询服务
		IUdidocRService qryService = ServiceFinder.find(IUdidocRService.class);
		return qryService.findByIds(udidocIds, FBoolean.FALSE);
	}
	
	/**
	 * 根据主键查询自定义档案DO
	 * 
	 * @param udidocId
	 *            自定义档案主键
	 * @return 自定义档案DO
	 * @throws BizException
	 */
	public Map<String,UdidocDO> getUdiDocsByCode(String udidocCode) throws BizException {
		EnValidator.validateParam("自定义档案ID", udidocCode);
		// 自定义档案查询服务
		IUdidoclistRService qryService = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] udidoclist =qryService.findByAttrValString(UdidoclistDO.CODE, udidocCode);
		if(EnValidator.isEmpty(udidoclist))
			return null;
		IUdidocRService rService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] udidos = rService.findByAttrValString(UdidocDO.ID_UDIDOCLIST, udidoclist[0].getId_udidoclist());
		if(EnValidator.isEmpty(udidos))
			return null;
		 Map<String, UdidocDO> udiMap = new HashMap<String,UdidocDO>();
		for(UdidocDO udido:udidos){
			 if(udiMap.containsKey(udido.getId_udidoc()))
				 continue;
			 udiMap.put(udido.getCode(), udido);
		}
		return udiMap;
	}
	
	/**
	 * 根据自定义档案类型集合查询自定义档案，返回map zhangpp
	 * @param udidocCodeList 自定义档案类型集合
	 * @return
	 * @throws BizException
	 */
	public Map<String,Map<String,UdidocDO>> getUdiDocsMapByCodes(String[] udidocCodes) throws BizException {
		EnValidator.validateParam("自定义档案类型编码为空", udidocCodes);
		IUdidoclistRService iUdidoclistRService = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] udidoLists = iUdidoclistRService.findByAttrValStrings(UdidoclistDO.CODE, udidocCodes);
		ArrayList<String> udiListIdList = new ArrayList<String>();
		for (UdidoclistDO udidoList : udidoLists) {
			if (udiListIdList.contains(udidoList.getId_udidoclist())) {
				continue;
			}
			udiListIdList.add(udidoList.getId_udidoclist());
		}
		IUdidocRService iUdidocRService = ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] udidos =iUdidocRService.findByAttrValStrings(UdidocDO.ID_UDIDOCLIST, udiListIdList.toArray(new String[0]));
		if(EnValidator.isEmpty(udidos)){
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
	
	/**
	 * 根据主键查询自定义档案DO
	 * 
	 * @param udidocId
	 *            自定义档案主键
	 * @return 自定义档案DO
	 * @throws BizException
	 */
	public Map<String,UdidocDO> getUdiDocsByCodes(FArrayList udidocCodeList) throws BizException {
		EnValidator.validateParam("自定义档案集合", udidocCodeList);
		IUdidocServiceExt qryService = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidos = qryService.findByUdidoclistCodes(udidocCodeList);
		if(EnValidator.isEmpty(udidos))
			return null;
		 Map<String, UdidocDO> udiMap = new HashMap<String,UdidocDO>();
		for(UdidocDO udido:udidos){
			 if(udiMap.containsKey(udido.getId_udidoc()))
				 continue;
			 udiMap.put(udido.getId_udidoc(), udido);
		}
		return udiMap;
	}
	/**
	 * 根据自定义档案的udidoclist code 和 udidoc 的code 返回需要的自定义档案
	 * @param udidocCode
	 * @param value
	 * @return
	 * @throws BizException 
	 */
	public UdidocDO getUdidocByCodeAndValue(String udidocCode,String value) throws BizException{
		IUdidocServiceExt qryService = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidos = qryService.findByUdidoclistCode(udidocCode);
		if(EnValidator.isEmpty(udidos))
			return null;
		for(UdidocDO udido:udidos){
			if(udido.getCode().equals(value))
				return udido;
		}
		return null;
	}
}
