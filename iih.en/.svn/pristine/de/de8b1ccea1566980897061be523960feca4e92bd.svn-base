package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.i.IEnfixedfeeMDOCudService;
import iih.en.pv.enfee.i.IEnfixedfeeMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 固定费用EP
 * @author renying
 *
 */
public class EnDcgEP {
	
	public void insertEnDcg(String entId,FDateTime dt_entry) throws BizException{
		if (EnValidator.isEmpty(entId)) {
			return;
		}
		EnFixedFeeDO fixDO = new EnFixedFeeDO();
		IEnfixedfeeMDORService rService = ServiceFinder.find(IEnfixedfeeMDORService.class);
		IEnfixedfeeMDOCudService cudService = ServiceFinder.find(IEnfixedfeeMDOCudService.class);
		EnFixedFeeDO[] fixDOs = rService.findByAttrValString(EnFixedFeeDO.ID_ENT, entId);
		if (fixDOs != null && fixDOs.length > 0) {
			fixDO = fixDOs[0];
			fixDO.setStatus(DOStatus.UPDATED);
		}else{
			fixDO.setStatus(DOStatus.NEW);
			fixDO.setId_ent(entId);
			fixDO.setSd_dcg_mode(IBlDictCodeConst.BD_DCG_MODE_SD);
			fixDO.setId_dcg_mode(IBlDictCodeConst.BD_DCG_MODE_ID);
			fixDO.setId_org(EnContextUtils.getOrgId());
			fixDO.setId_grp(EnContextUtils.getGrpId());
		}
		fixDO.setDt_dcg_bill(dt_entry);
		cudService.save(new EnFixedFeeDO[]{fixDO});
	}
	
}
