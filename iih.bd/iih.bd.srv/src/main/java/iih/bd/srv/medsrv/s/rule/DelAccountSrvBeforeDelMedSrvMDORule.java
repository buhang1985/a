package iih.bd.srv.medsrv.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.accountsrv.i.IAccountsrvExtCudService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 删除医疗服务前删除核算科目与收费项目的关联关系
 * 
 * @author hao_wu 2018-10-27
 *
 */

public class DelAccountSrvBeforeDelMedSrvMDORule implements IRule<MedSrvDO> {

	@Override
	public void process(MedSrvDO... medSrvDos) throws BizException {
		if (ArrayUtils.isEmpty(medSrvDos)) {
			return;
		}

		ArrayList<String> medSrvIdList = new ArrayList<String>();
		for (MedSrvDO medSrv : medSrvDos) {
			medSrvIdList.add(medSrv.getId_srv());
		}

		IAccountsrvExtCudService accountsrvExtCudService = ServiceFinder.find(IAccountsrvExtCudService.class);
		accountsrvExtCudService.deleteRelByMedsrvId(medSrvIdList.toArray(new String[0]));
	}

}
