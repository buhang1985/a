package iih.en.comm.ep;

import iih.en.pv.enres.d.EnExtVipDO;
import iih.en.pv.enres.i.IEnvipCudService;
import iih.en.pv.enres.i.IEnvipRService;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊VipEP
 * 
 * @author liubin
 *
 */
public class EnVipEP {
	
	
	/**
	 * 获取就诊是否是VipMap
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public Map<String, FBoolean> getIsExtVipMap(String[] entIds) throws BizException{
		if(ArrayUtil.isEmpty(entIds))
			return null;
		Map<String, FBoolean> map = new HashMap<String, FBoolean>();
		for(String entId : entIds){
			map.put(entId, FBoolean.FALSE);
		}
		EnExtVipDO[] extVips = getRServ().findByAttrValStrings(EnExtVipDO.ID_ENT, entIds);	//此处根据就诊id查不到对象
		if(!ArrayUtil.isEmpty(extVips)){//没有进入此if语句
			for(EnExtVipDO extVip : extVips){
				if(!FBoolean.TRUE.equals(extVip.getFg_valid()))
					continue;
				map.put(extVip.getId_ent(), FBoolean.TRUE);
			}
		}
		return map;
	}
	/**
	 * 获取就诊是否是VipMap
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public Map<String, EnExtVipDO> getIsExtVipDOMap(String[] entIds) throws BizException{
		if(ArrayUtil.isEmpty(entIds))
			return null;
		Map<String, EnExtVipDO> map = new HashMap<String, EnExtVipDO>();
		for(String entId : entIds){
			map.put(entId, null);
		}
		EnExtVipDO[] extVips = getRServ().findByAttrValStrings(EnExtVipDO.ID_ENT, entIds);
		if(!ArrayUtil.isEmpty(extVips)){
			for(EnExtVipDO extVip : extVips){
				if(!FBoolean.TRUE.equals(extVip.getFg_valid()))
					continue;
				map.put(extVip.getId_ent(), extVip);
			}
		}
		return map;	
	}
	/**
	 * 获取有效的Vip记录
	 * 
	 * @param entId
	 * @return
	 */
	public EnExtVipDO[] getValidExiVip(String entId) throws BizException{
		String whereStr = String.format("Id_ent = '%s' and Fg_valid = '%s'", entId, FBoolean.TRUE);
		return getRServ().find(whereStr, null, FBoolean.FALSE);
	}
	/**
	 * 保存vip记录
	 * 
	 * @param extVip
	 * @return
	 * @throws BizException
	 */
	public EnExtVipDO[] save(EnExtVipDO[] extVips) throws BizException{
		return getCudServ().save(extVips);
	}
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnvipRService getRServ(){
		return ServiceFinder.find(IEnvipRService.class);
	}
	/**
	 * 获取操作服务
	 * 
	 * @return
	 */
	public IEnvipCudService getCudServ(){
		return ServiceFinder.find(IEnvipCudService.class);
	}
}
