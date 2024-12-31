package iih.bd.fc.wf.s.bp;

import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.i.IWfRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据医嘱流向id获取AggDo业务逻辑
 * 
 * @author hao_wu
 *
 */
public class getWfAggDoBp {

	/**
	 * 根据医嘱流向id获取AggDo
	 * 
	 * @param wfId
	 * @return
	 * @throws BizException
	 */
	public WfAggDO exec(String wfId) throws BizException {
		// 1、检索数据
		WfAggDO aggDO = getAggDOById(wfId);

		// 2、组装数据
		packageAggDO(aggDO);

		return aggDO;
	}

	/**
	 * 根据医嘱流向id获取AggDo
	 * 
	 * @param wfId
	 * @return
	 * @throws BizException
	 */
	private WfAggDO getAggDOById(String wfId) throws BizException {
		IWfRService wfRService = ServiceFinder.find(IWfRService.class);

		String whereStr = String.format("id_grp = '%s' and id_org = '%s' and ds = 0 and id_wf = '%s' ",
				Context.get().getGroupId(), Context.get().getOrgId(), wfId);
		WfAggDO[] result = wfRService.find(whereStr, "", FBoolean.FALSE);
		if (result == null)
			return null;
		return result[0];
	}

	/**
	 * 包装医嘱流向_设置主DO服务类型
	 * 
	 * @param aggDO
	 * @throws BizException
	 */
	private void packageAggDO(WfAggDO aggDO) throws BizException {
		packageWfAggBp bp = new packageWfAggBp();
		bp.exec(new WfAggDO[] { aggDO });
	}
}
