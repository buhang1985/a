package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;

/**
 * 基础数据 - 人员档案EP
 * 
 * @author zhengcm
 * @date 2016-07-07 14:27:25
 *
 */
public class PsnDocEP {
	public PsnDocEP() {

	}

	/**
	 * 根据人员id查询人员
	 * 
	 * @param psnId
	 *            人员id
	 * @return 人员档案DO
	 * @throws BizException
	 */
	public PsnDocDO getPsnById(String psnId) throws BizException {
		EnValidator.validateParam("人员ID", psnId);
		// 人员档案查询服务
		IPsndocMDORService qryService = ServiceFinder.find(IPsndocMDORService.class);
		return qryService.findById(psnId);
	}
	/**
	 * 根据人员编码查询人员
	 * 
	 * @param code
	 *            人员id
	 * @return 人员档案DO
	 * @throws BizException
	 */
	public PsnDocDO getPsnByCode(String code) throws BizException {
		if(EnValidator.isEmpty(code))
			return null;
		// 人员档案查询服务
		IPsndocMDORService qryService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psns = qryService.findByAttrValString(PsnDocDO.CODE, code);
		return EnValidator.isEmpty(psns) ? null : psns[0];
	}
	
	/**
	 * 批量查找人员数据
	 * 
	 * @author renying
	 * @since 2017-4-7
	 *
	 */
	public Map<String, PsnDocDO> getPsnByIdList(List<String> psnIdList)  throws BizException{
		if (EnValidator.isEmpty(psnIdList))
			return new HashMap<String, PsnDocDO>();
		IPsndocMDORService rservice = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndo = rservice.findByIds(psnIdList.toArray(new String[0]), FBoolean.FALSE);
		
		 Map<String, PsnDocDO> depMap = new HashMap<String,PsnDocDO>();
		 for(PsnDocDO psn:psndo){
			 if(depMap.containsKey(psn.getId_psndoc()))
				 continue;
			 depMap.put(psn.getId_psndoc(), psn);
		 }
		 return depMap;
	}
	
	/**
	 * 批量查找人员数据
	 * 
	 * @param psnIdSet
	 * @author ltf
	 * @throws BizException
	 */
	public Map<String, PsnDocDO> getPsnByIdSet(Set<String> psnIdSet) throws BizException{
		if(psnIdSet.size()==0 || psnIdSet.isEmpty())
			return new HashMap<String, PsnDocDO>();
		IPsndocMDORService rservice = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psnDocdo = rservice.findByIds(psnIdSet.toArray(new String[0]), FBoolean.FALSE);
		Map<String, PsnDocDO> psnMap = new HashMap<String,PsnDocDO>();
		 for(PsnDocDO psn:psnDocdo){
			 if(psnMap.containsKey(psn.getId_psndoc()))
				 continue;
			 psnMap.put(psn.getId_psndoc(), psn);
		 }
		 return psnMap;
	}
}
