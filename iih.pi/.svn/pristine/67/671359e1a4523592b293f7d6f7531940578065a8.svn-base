package iih.pi.reg.pat.s.bp;

import iih.pi.reg.pat.d.PatiAddrDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;

/**
 * 检索时设置患者区县码全称
 * @author ly
 *
 */
public class PiPatSetAdmdivFullNameBP {

	//直辖市区县码 TODO
	private final String[] DERECTLYCITY = new String[]{"110000","120000","310000","500000"};
	
	/**
	 * 设置患者区县码全称
	 * @param dos
	 * @throws BizException
	 */
	public void exec(PatiAddrDO... dos) throws BizException {
		
		List<String> admdivList = new ArrayList<String>();
		for (PatiAddrDO patiAddrDO : dos) {
			if(!StringUtil.isEmpty(patiAddrDO.getSd_admdiv())){
				
				if(admdivList.contains(patiAddrDO.getSd_admdiv()))
					continue;
				
				admdivList.add(patiAddrDO.getSd_admdiv());
			}
		}
		
		Map<String,String> admdivMap = this.getAdmdivMap(admdivList.toArray(new String[admdivList.size()]));
		for (PatiAddrDO patiAddrDO : dos) {
			//patiAddrDO.setFull_name_admdiv(admdivMap.get(patiAddrDO.getSd_admdiv()));
		}
	}
	
	/**
	 * 获得区县码对应名称
	 * @param admdivSds
	 * @return
	 * @throws BizException
	 */
	private Map<String,String> getAdmdivMap(String[] admdivSds) throws BizException {
		
		Map<String,String> result = new HashMap<String,String>();
		
		//省编码list
		List<String> proviceList = new ArrayList<String>();
		for (String admdiv : admdivSds) {
			if(proviceList.contains(admdiv.substring(0, 2)))
				continue;
			
			proviceList.add(admdiv.substring(0, 2));
		}
		
		//查询条件
		String whereSql = "";
		for (String provice : proviceList) {
			
			if(!"".equals(whereSql)){
				whereSql += " or ";
			}
			whereSql += AdminAreaDODesc.TABLE_ALIAS_NAME + ".code like '" + provice + "%'";
		}
		
		String orderSql =  AdminAreaDODesc.TABLE_ALIAS_NAME + ".code";
		IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] areas = areaService.find(whereSql, orderSql, FBoolean.FALSE);
		
		//未检索到数据时
		if(areas == null){
			for (String admdiv : admdivSds) {
				if(result.containsKey(admdiv))
					continue;
				
				result.put(admdiv, "");
			}
			
			return result;
		}
		
		for (String admdiv : admdivSds) {
			if(result.containsKey(admdiv))
				continue;
			
			result.put(admdiv, this.getRegionName(admdiv, areas));
		}
		
		return result;
	}
	
	/**
	 * 获取区县全名称
	 * @param admdiv
	 * @param areas
	 * @return
	 */
	private String getRegionName(String admdiv,AdminAreaDO[] areas){
		
		String region = admdiv; //区
		String provice = region.substring(0, 2); //省
		String city = region.substring(0, 4);//市
		
		String regionName = "";//全名称
		//补全编码
		provice += "0000";
		city += "00";
		
		//按照编码排序
		for (AdminAreaDO area : areas) {
			if(provice.equals(area.getCode())){
				regionName += area.getName();
				
				if(provice.equals(region))
					break;
			}
			
			if(city.equals(area.getCode())){
				
				//直辖市时不拼市名字
				if(!this.isDerectlyCity(provice)){
					regionName += area.getName();
				}
				
				if(city.equals(region))
					break;
			}
			
			if(region.equals(area.getCode())){
				regionName += area.getName();
				break;
			}
		}
		
		return regionName;
	}
	
	
	/**
	 * 直辖市判断
	 * @param code
	 * @return
	 */
	private boolean isDerectlyCity(String code){
		
		for (String str : DERECTLYCITY) {
			
			if(str.equals(code))
				return true;
		}
		
		return false;
	}
}
