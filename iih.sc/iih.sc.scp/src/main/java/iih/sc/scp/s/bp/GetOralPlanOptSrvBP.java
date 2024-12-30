package iih.sc.scp.s.bp;

import iih.sc.comm.ScValidator;
import iih.sc.scp.s.ep.OralScplEP;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import xap.mw.core.data.BizException;

/**
 * 获取口腔科排班计划备选服务BP
 * 
 * @author zhengcm
 * @date 2016-09-26 10:09:45
 *
 */
public class GetOralPlanOptSrvBP {

	/**
	 * 根据排班计划获取备选服务
	 *
	 * @param id_scpl 排班计划id
	 * @return 排班计划备选服务DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlOptSrvDO[] exec(String id_scpl) throws BizException {
		// 检查参数
		ScValidator.validateParam("id_scpl", id_scpl);
		String where = String.format("id_scpl = '%s'", id_scpl);
		return new OralScplEP().getScplOptSrvByCond(where, null);
	}

}
