package iih.en.comm.ep;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.op.i.IEnentoperCudService;
import iih.en.er.op.i.IEnentoperRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * (EN_ENT_OP_ER)EP
 * 
 * @author liubin
 *
 */
public class EntOpErEP {
	/**
	 * 批量查询急诊挂号信息（就诊id）
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnEntOpErDO[] getEntOpErDOsByEntId(ArrayList<String> entList) throws BizException{
		if(EnValidator.isEmpty(entList))
			return null;
		EnEntOpErDO[] entOpErs = getEntOpErRServ().findByAttrValStrings(EnEntOpErDO.ID_ENT, entList.toArray(new String[0]));
		if(EnValidator.isEmpty(entOpErs))
			return null;
		return entOpErs;
	}
	/**
	 * 获取急诊挂号信息（就诊id）
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnEntOpErDO getByEntId(String entId) throws BizException{
		if(EnValidator.isEmpty(entId))
			return null;
		EnEntOpErDO[] entOpErs = getEntOpErRServ().findByAttrValString(EnEntOpErDO.ID_ENT, entId);
		if(EnValidator.isEmpty(entOpErs))
			return null;
		return entOpErs[0];
	}
	/**
	 * 获取急诊挂号信息（就诊id）(无关联信息)
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnEntOpErDO getByEntIdWithOutRef(String entId) throws BizException{
		if (EnValidator.isEmpty(entId))
			return null;
		List<EnEntOpErDO> list = (List<EnEntOpErDO>) new DAFacade().findByAttrValString(EnEntOpErDO.class, EnEntOpErDO.ID_ENT, entId, null);
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}
	/**
	 * 获取急诊挂号信息（预检id）
	 * 
	 * @param erPreId
	 * @return
	 * @throws BizException
	 */
	public EnEntOpErDO[] getByErPreId(String erPreId) throws BizException{
		if(EnValidator.isEmpty(erPreId))
			return null;
		EnEntOpErDO[] entOpErs = getEntOpErRServ().findByAttrValString(EnEntOpErDO.ID_ERPRE, erPreId);
		if(EnValidator.isEmpty(entOpErs))
			return null;
		return entOpErs;
	}
	/**
	 * 保存
	 * 
	 * @param entOpErs
	 * @return
	 * @throws BizException
	 */
	public EnEntOpErDO[] save(EnEntOpErDO[] entOpErs) throws BizException{
		return getEntOpErCudServ().save(entOpErs);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IEnentoperRService getEntOpErRServ(){
		return ServiceFinder.find(IEnentoperRService.class);
	}
	/**
	 * 获取Cud服务
	 * 
	 * @return
	 */
	public IEnentoperCudService getEntOpErCudServ(){
		return ServiceFinder.find(IEnentoperCudService.class);
	}
	/**
	 * 批量更新entoper表的床位信息 
	 * @param entList
	 * @throws BizException 
	 */
	public void updateOpBedInfo(ArrayList<String> entList,String nameBed,String idBed) throws BizException{
		if(EnValidator.isEmpty(entList)){
			return;
		}
		EnEntOpErDO[] inpatientDOs = this.getEntOpErDOsByEntId(entList);
		if(EnValidator.isEmpty(inpatientDOs)){
			throw new BizException("就诊对应的预检信息不存在！");
		}
		for(EnEntOpErDO ipDO :inpatientDOs){
			ipDO.setStatus(DOStatus.UPDATED); 
			ipDO.setId_bed(idBed); 
			ipDO.setName_bed(nameBed);	
		}
		getEntOpErCudServ().update(inpatientDOs);
	}
	/***
	 * 急诊抢救校验
	 * 
	 * @param id_ent
	 * @throws BizException 
	 */
	public void validateEnOpErDOByEntId(String id_ent) throws BizException{
		EnEntOpErDO entOpErDO = this.getByEntId(id_ent);
		if(entOpErDO == null){
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_STATUS);
		}
	}
}
