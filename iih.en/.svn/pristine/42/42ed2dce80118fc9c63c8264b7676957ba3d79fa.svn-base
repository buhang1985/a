package iih.en.comm.ep;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnExtDO;
import iih.en.pv.enres.i.IEnextCudService;
import iih.en.pv.enres.i.IEnextRService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * EN_ENT_EXT表EP
 * 
 * @author liubin
 *
 */
public class EnExtEP {
	
	/**
	 * 新增EN_ENT_EXT记录
	 * 
	 * @param pvs
	 * @return
	 * @throws BizException
	 */
	public EnExtDO[] insertExt(PatiVisitDO[] pvs) throws BizException{
		if(EnValidator.isEmpty(pvs))
			return null;
		List<EnExtDO> dos = new ArrayList<>();
		for(PatiVisitDO pv : pvs){
			EnExtDO ext = new EnExtDO();
			ext.setStatus(DOStatus.NEW);
			ext.setId_ent(pv.getId_ent());
			ext.setId_pat(pv.getId_pat());
			dos.add(ext);
		}
		return save(dos.toArray(new EnExtDO[0]));
	}
	/**
	 * 批量修改EnExtDO字段，无EN_ENT_EXT,则新增
	 * 
	 * @param map  <K,V>-<Id_ent,字段值>
	 * @return
	 * @throws BizException
	 */
	public EnExtDO[] updateAttrVals(Map<String, Object> map, String attrVal) throws BizException {
		if (map == null || map.isEmpty())
			return null;
		Map<String, EnExtDO> extMap = getExtMap(map.keySet().toArray(new String[0]));
		if(extMap == null || extMap.isEmpty())
			return null;
		for(String key : map.keySet()){
			if(extMap.containsKey(key)){
				EnExtDO ext = extMap.get(key);
				ext.setStatus(EnValidator.isEmpty(ext.getId_entext()) ? DOStatus.NEW : DOStatus.UPDATED);
				ext.setAttrVal(attrVal, map.get(key));
			}
		}
		return save(extMap.values().toArray(new EnExtDO[0]));
	}
	/**
	 * 修改身高体重记录记录
	 * 
	 * @param newBorns 新生儿
	 * @return
	 * @throws BizException
	 */
	public EnExtDO[] updateWeightAndHeight(NewbornDO[] newBorns) throws BizException{
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO(NewbornDO.ID_ENT_BB, newBorns);
		EnExtDO[] exts = getByEntIds(entIds);
		if(EnValidator.isEmpty(exts))
			return null;
		Map<String, EnExtDO> map = EnFMapUtils.getMap(EnExtDO.ID_ENT, exts);
		for(NewbornDO newBorn : newBorns){
			FDouble weight = newBorn.getWeight_reg() != null ? newBorn.getWeight_reg() : newBorn.getWeight();
			if(map.containsKey(newBorn.getId_ent_bb())){
				EnExtDO ext = map.get(newBorn.getId_ent_bb());
				ext.setStatus(DOStatus.UPDATED);
				ext.setWeight(weight);
				ext.setHeight(newBorn.getHeight());
			}else{
				EnExtDO ext = new EnExtDO();
				ext.setStatus(DOStatus.NEW);
				ext.setId_ent(newBorn.getId_ent_bb());
				ext.setId_pat(newBorn.getId_pat_bb());
				ext.setWeight(weight);
				ext.setHeight(newBorn.getHeight());
				map.put(newBorn.getId_ent_bb(), ext);
			}
		}
		return save(map.values().toArray(new EnExtDO[0]));
	}
	/**
	 * 获取就诊扩展记录
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public EnExtDO[] getByEntIds(String[] entIds)throws BizException{
		if(EnValidator.isEmpty(entIds))
			return null;
		return getRServ().findByAttrValStrings(EnExtDO.ID_ENT, entIds);
	}
	/**
	 * 保存
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	public EnExtDO[] save(EnExtDO[] dos) throws BizException{
		return getCudServ().save(dos);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnextRService getRServ(){
		return ServiceFinder.find(IEnextRService.class);
	}
	
	/**
	 * 获取Cud服务
	 * 
	 * @return
	 */
	public IEnextCudService getCudServ(){
		return ServiceFinder.find(IEnextCudService.class);
	}
	/**
	 * 获取EnExtDOs
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, EnExtDO> getExtMap(String[] entIds) throws BizException{
		EnExtDO[] exts = getRServ().findByAttrValStrings(EnExtDO.ID_ENT, entIds);
		Map<String, EnExtDO> map = EnFMapUtils.getMap(EnExtDO.ID_ENT, exts);
		if(map == null)
			map = new HashMap<String, EnExtDO>();
		List<PatiVisitDO> pvs = (List<PatiVisitDO>) new DAFacade().findByPKs(
				PatiVisitDO.class, entIds,
				new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT });
		if(EnValidator.isEmpty(pvs))
			return null;
		Map<String, PatiVisitDO> pvMap = EnFMapUtils.getMap(PatiVisitDO.ID_ENT, pvs.toArray(new PatiVisitDO[0]));
		for(String entId : entIds){
			if(map.containsKey(entId))
				continue;
			if(!pvMap.containsKey(entId))
				continue;
			PatiVisitDO pv = pvMap.get(entId);
			EnExtDO ext = new EnExtDO();
			ext.setStatus(DOStatus.NEW);
			ext.setId_ent(pv.getId_ent());
			ext.setId_pat(pv.getId_pat());
			map.put(entId, ext);
		}
		return map;
	}
}
