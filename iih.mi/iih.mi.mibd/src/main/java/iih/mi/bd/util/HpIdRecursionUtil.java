package iih.mi.bd.util;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

public class HpIdRecursionUtil {

	/**
	 * 递归获取复用医保计划id
	 * @param hpId
	 * @return
	 */
	public static String getHpIdRecursion(String hpId) throws BizException {
		String idPar = getIdRef(hpId);
		if (!StringUtil.isEmpty(idPar)) {
			return getHpIdRecursion(idPar);
		}
		return hpId;
	}
	
	/**
	 * 获取复用医保主键
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	public static String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);

		return hpdo.getId_refhp();
	}
}
