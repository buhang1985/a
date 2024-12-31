package iih.en.pv.s.bp.op.ws;

import iih.en.comm.validator.EnValidator;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取服务价格
 * 
 * @author liubin
 *
 */
public class LoadSrvPriceBP {
	/**
	 * 获取服务价格
	 * 
	 * @param scSrvId 排班服务
	 * @return 价格
	 * @throws BizException
	 */
	public FDouble getPrice(String scSrvId) throws BizException{
		Map<String, FDouble> map = getPrice(new String[] {scSrvId});
		if(map!=null){
			return map.get(scSrvId);
		}
		return null;
	}
	/**
	 * 获取服务价格
	 * 
	 * @param scSrvIds 排班服务集合
	 * @return Map<br/>  
	 * 		key : 排班服务id<br/>
	 * 		value : 价格
	 * @throws BizException 
	 */
	public Map<String, FDouble> getPrice(String[] scSrvIds) throws BizException{
		List<String> list = new LinkedList<String>();
		Collections.addAll(list, scSrvIds);
		return getPrice(list);
	}
	/**
	 * 获取服务价格
	 * 
	 * @param scSrvIds 排班服务集合
	 * @return Map<br/>  
	 * 		key : 排班服务id<br/>
	 * 		value : 价格
	 * @throws BizException
	 */
	public Map<String, FDouble> getPrice(List<String> scSrvIds) throws BizException{
		if(EnValidator.isEmpty(scSrvIds))
			return null;
		//去重
		Set<String> set = new HashSet<>();
		set.addAll(scSrvIds);
		//构造资源信息
		List<RegResDTO> list = new LinkedList<RegResDTO>();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			RegResDTO regRes = new RegResDTO();
			regRes.setId_scsrv(it.next());
			list.add(regRes);
		}	
		
		IScSchOutQryService scSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] resResult = scSchOutQryService.loadResPri(list.toArray(new RegResDTO[0]));
		
		Map<String, FDouble> regResMap = new HashMap<String, FDouble>();
		for (RegResDTO regResDTO : resResult) {
			regResMap.put(regResDTO.getId_scsrv(), regResDTO.getAmt_st());
		}
		return regResMap;
	}
}
