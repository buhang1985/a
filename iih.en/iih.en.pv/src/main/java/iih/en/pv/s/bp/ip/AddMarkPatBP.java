package iih.en.pv.s.bp.ip;

import iih.en.comm.ep.EntFlwEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enflw.d.EnFlwDO;
import xap.mw.core.data.BizException;

/**
 * 用户加关注
 * 
 * @author liubin
 *
 */
public class AddMarkPatBP {
	/**
     * 用户加关注
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
	public void exec(String entId, String empId) throws BizException {
		EnValidator.validateParam("Id_ent", entId);
		EnValidator.validateParam("Id_emp", empId);
		EntFlwEP ep = new EntFlwEP();
		EnFlwDO[] enFlws = ep.getEnFlwDO(entId, empId);
		if(!EnValidator.isEmpty(enFlws))
			return;
		ep.addEnFlw(entId, empId);
	}
}
