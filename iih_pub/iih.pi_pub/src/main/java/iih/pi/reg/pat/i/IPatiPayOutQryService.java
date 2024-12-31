package iih.pi.reg.pat.i;

import iih.pi.reg.d.PiSpclPatAmtDTO;
import xap.mw.core.data.BizException;

/**
 * @author dj.zhang
 *
 */
public interface IPatiPayOutQryService {

	/**
	 * 查询患者卡交费押金
	 * 
	 * @param patcardIds
	 * @param euCardCgMod
	 * @return
	 * @throws BizException
	 */
	public abstract PiSpclPatAmtDTO[] getPatCardAmt(String[] patcardIds, String euCardCgMod) throws BizException;
}
