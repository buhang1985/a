package iih.en.pv.s.bp;

import iih.pi.reg.i.IPiRegValidateService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查患者是否为医保患者
 * @author yank
 *
 */
public class CheckIsHpPatBP {
	/**
	 * 是否是医保患者
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public FBoolean isHpPat(String patId) throws BizException{
		IPiRegValidateService piValidateService = ServiceFinder.find(IPiRegValidateService.class);
		return piValidateService.hasSocialMedIns(patId);
	}
}
