package iih.bd.srv.medsrv.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.accountsrv.i.IAccountsrvExtCudService;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 删除医疗服务Agg后删除服务与核算项目关系
 * 
 * @author hao_wu 2018-10-27
 *
 */
public class DelAccSrvRelBeforeDelMedSrvRule implements IRule<MedsrvAggDO> {

	@Override
	public void process(MedsrvAggDO... medSrvAggs) throws BizException {
		if (ArrayUtils.isEmpty(medSrvAggs)) {
			return;
		}

		ArrayList<String> medSrvIdList = new ArrayList<String>();
		for (MedsrvAggDO medSrvAggDo : medSrvAggs) {
			medSrvIdList.add(medSrvAggDo.getParentDO().getId_srv());
		}

		IAccountsrvExtCudService accountsrvExtCudService = ServiceFinder.find(IAccountsrvExtCudService.class);
		accountsrvExtCudService.deleteRelByMedsrvId(medSrvIdList.toArray(new String[0]));
	}
}
