package iih.en.pv.s.bp;

import iih.en.comm.ep.EntFlwEP;
import xap.mw.core.data.BizException;

/**
 * 用户取消关注
 * 
 * @author liubin
 *
 */
public class CancMarkPatBP {
	/**
     * 用户取消关注
     * 
     * @param entId
     * @param empId
     * @throws BizException
     */
	public void exec(String entId, String empId) throws BizException {
		EntFlwEP ep = new EntFlwEP();
		ep.cancEnFlw(entId, empId);
	}
}
