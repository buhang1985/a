package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.mm.materialnames.d.adapter.MnAliasSetDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import iih.bd.srv.medsrv.i.IMedSrvAliasDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存药品通用名别名集业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveAliasSetDOsBp {

	public MnAliasSetDO[] exec(MnAliasSetDO[] mnAliasSetDOArray) throws BizException {
		if (null == mnAliasSetDOArray || mnAliasSetDOArray.length <= 0) {
			return null;
		}
		ArrayList<MedSrvAliasDO> list = new ArrayList<MedSrvAliasDO>();
		MnAliasSetDOAdapter adapter = new MnAliasSetDOAdapter();
		for (MnAliasSetDO mnAliasSetDO : mnAliasSetDOArray) {
			MedSrvAliasDO medSrvAliasDO = adapter.getMedSrvAliasDO(mnAliasSetDO);
			list.add(medSrvAliasDO);
		}

		IMedSrvAliasDOCudService medSrvAliasDOCudService = ServiceFinder.find(IMedSrvAliasDOCudService.class);
		MedSrvAliasDO[] rtn = medSrvAliasDOCudService.save(list.toArray(new MedSrvAliasDO[0]));

		MnAliasSetDO[] mnAliasSetDOList = adapter.getMnAliasSetDOs(rtn);
		return mnAliasSetDOList;
	}

}
