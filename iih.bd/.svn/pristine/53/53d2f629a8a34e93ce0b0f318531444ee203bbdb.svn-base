package iih.bd.mm.materialnames.s.bp.findbp;

import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 通过服务id查询药品属性
 * 
 * @author hao_wu
 *
 */
public class findMedSrvDrugDOByIdBp {

	public MedSrvDrugDO exec(String srvId) throws BizException {
		if (null == srvId) {
			return new MedSrvDrugDO();
		}
		IMedSrvDrugDORService medSrvDrugDORService = ServiceFinder.find(IMedSrvDrugDORService.class);
		MedSrvDrugDO[] rtn = medSrvDrugDORService.findByAttrValString(MedSrvDrugDO.ID_SRV, srvId);
		if (rtn != null && rtn.length >= 1) {
			return rtn[0];
		}
		return null;
	}
}
