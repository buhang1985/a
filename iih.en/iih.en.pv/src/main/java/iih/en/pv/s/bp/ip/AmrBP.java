package iih.en.pv.s.bp.ip;

import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.en.comm.validator.EnValidator;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病案操作BP 所有的病案相关的操作，集中在这里进行处理
 * 
 * @author Administrator
 *
 */
public class AmrBP {
	/**
	 * 获取就诊病案
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public AMrDO getAmrDO(String entId) throws BizException {
		ICiamrRService amrRService = ServiceFinder.find(ICiamrRService.class);
		String whereStr = String.format("Id_ent='%s'", entId);
		AMrDO[] amrDOs = amrRService.find(whereStr, null, FBoolean.FALSE);

		AMrDO amrDO = null;
		if (!EnValidator.isEmpty(amrDOs)) {
			amrDO = amrDOs[0];
		}

		return amrDO;
	}
	/**
	 * 获取就诊病案
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public AMrDO[] getAmrDOs(String[] entIds)throws BizException {
		if(EnValidator.isEmpty(entIds))
			return null;
		ICiamrRService amrRService = ServiceFinder.find(ICiamrRService.class);
		return amrRService.findByAttrValStrings(AMrDO.ID_ENT, entIds);
	}

	/**
	 * 保存就诊病案
	 * 
	 * @param amrDO 病案
	 * @throws BizException
	 */
	public void saveAmr(AMrDO amrDO) throws BizException {
		ICiamrCudService amrCudservice = ServiceFinder.find(ICiamrCudService.class);
		amrCudservice.save(new AMrDO[] { amrDO });
	}
	/**
	 * 批量保存
	 * @param amrDO
	 * @throws BizException
	 */
	public void saveAmr(AMrDO[] amrDOs) throws BizException {
		ICiamrCudService amrCudservice = ServiceFinder.find(ICiamrCudService.class);
		amrCudservice.save(amrDOs);
	}
	/**
	 * 批量查询
	 * @param entIdList
	 * @return
	 * @throws BizException
	 */
	public AMrDO[] getAmrDO(ArrayList<String> entIdList) throws BizException {
		if(EnValidator.isEmpty(entIdList))
			return null;
		ICiamrRService amrRService = ServiceFinder.find(ICiamrRService.class);
		AMrDO[] amrDOs = amrRService.findByAttrValStrings(AMrDO.ID_ENT, entIdList.toArray(new String[0]));
		return amrDOs;
	}

}
