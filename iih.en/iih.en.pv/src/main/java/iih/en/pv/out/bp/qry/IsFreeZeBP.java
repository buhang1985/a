package iih.en.pv.out.bp.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊是否封账
 * 
 * @author liubin
 *
 */
public class IsFreeZeBP {
	/**
	 * 就诊是否封账
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return FBoolean.FALSE;
		IEnaccountMDORService serv = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[]  enAccs = serv.findByAttrValString(EnAccountDO.ID_ENT, entId);
		if(EnValidator.isEmpty(enAccs))
			throw new BizException("未找到患者账户信息！");
		return enAccs[0].getFg_freeze();
	}
}
