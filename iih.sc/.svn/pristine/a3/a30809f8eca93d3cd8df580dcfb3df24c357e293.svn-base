package iih.sc.apt.s.bp;

import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.ScValidator;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scploptsrv.i.IScploptsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取排班计划号别(包括备选)BP
 * 
 * @author zhengcm
 * @date 2018-01-17 09:56:42
 *
 */
public class GetPlanScsrvBP {

	/**
	 * 获取排班计划号别(包括备选)
	 * 
	 * @author zhengcm
	 *
	 * @param id_scpl
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FArrayList exec(String id_scpl) throws BizException {
		// 校验参数
		ScValidator.validateParam("id_scpl", id_scpl);

		// 排班计划
		ScPlanDO planDO = new OralAptEP().getScPlan(id_scpl);

		// 备选服务
		IScploptsrvRService optQryService = ServiceFinder.find(IScploptsrvRService.class);
		ScPlOptSrvDO[] optSrvs = optQryService.find(String.format("id_scpl = '%s'", id_scpl), null, FBoolean.FALSE);

		FArrayList flist = new FArrayList();
		if (null != planDO) {
			if (!flist.contains(planDO.getId_scsrv())) {
				flist.add(planDO.getId_scsrv());
			}
		}
		if (!ArrayUtil.isEmpty(optSrvs)) {
			for (ScPlOptSrvDO optDO : optSrvs) {
				if (flist.contains(optDO.getId_scsrv())) {
					continue;
				}
				flist.add(optDO.getId_scsrv());
			}
		}

		return flist;
	}
}
