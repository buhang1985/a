package iih.sc.sch.s.bp;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;

/**排班获取计划根据排班
 * @author ccj
 *
 */
public class GetScplanBySchBp {
	/**排班获取计划根据排班
	 * @param schDO  排班do
	 * @return	计划do
	 * @throws BizException
	 */
	public ScPlanDO exec(ScSchDO schDO)throws BizException{
		if(schDO == null || StringUtils.isEmpty(schDO.getId_scpl())) return null;
		String id_scpl = schDO.getId_scpl(); //计划id
		IScplanRService iScplanRService = ServiceFinder.find(IScplanRService.class);
		ScPlanDO planDO = iScplanRService.findById(id_scpl);
		return planDO;
	}
}
