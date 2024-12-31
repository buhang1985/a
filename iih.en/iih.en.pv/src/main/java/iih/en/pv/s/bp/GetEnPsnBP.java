package iih.en.pv.s.bp;

import iih.en.comm.ep.EntEmpEP;
import iih.en.pv.enres.d.EnPsnDO;
import xap.mw.core.data.BizException;

/**
 * 获取就诊医护人员BP
 * @author renying
 *
 */
public class GetEnPsnBP {
	/**
	 * 获取医护人员信息
	 * @param entId 就诊id
	 * @param empRole 人员角色
	 * @return
	 * @throws BizException
	 */
	public EnPsnDO exec(String entId,String empRole) throws BizException{
		EntEmpEP entEmpEp = new EntEmpEP();
		EnPsnDO enpsnDo = entEmpEp.getEnEmpByRole(entId, empRole);
		return enpsnDo;
	}
}
