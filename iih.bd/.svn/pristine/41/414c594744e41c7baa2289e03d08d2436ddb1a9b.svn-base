package iih.bd.mm.materialnames.s.bp.queryer;

import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.mm.materialnames.s.bp.creater.MnAliasSetDOCreater;
import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import xap.mw.core.data.BizException;

/**
 * 药品通用名别名集查询器
 * 
 * @author hao_wu
 *
 */
public class MnAliasSetQueryer {

	public static MnAliasSetDO[] findMnAliasSetBySrvId(String id) throws BizException {
		MedSrvAliasDO[] medSrvAliasDOs = MedSrvQueryer.findMedSrvAliasSetBySrvId(id);
		MnAliasSetDO[] rtn = MnAliasSetDOCreater.createMnAliasSetDOs(medSrvAliasDOs);
		return rtn;
	}
}
