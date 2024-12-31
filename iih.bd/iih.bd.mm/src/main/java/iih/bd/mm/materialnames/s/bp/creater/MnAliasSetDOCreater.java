package iih.bd.mm.materialnames.s.bp.creater;

import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.mm.materialnames.d.adapter.MnAliasSetDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvAliasDO;

/**
 * 药品通用名别名集创建器
 * 
 * @author hao_wu
 *
 */
public class MnAliasSetDOCreater {
	/**
	 * 创建药品通用名别名集
	 * 
	 * @param medSrvAliasDOs
	 * @return
	 */
	public static MnAliasSetDO[] createMnAliasSetDOs(MedSrvAliasDO[] medSrvAliasDOs) {
		MnAliasSetDOAdapter adapter = new MnAliasSetDOAdapter();
		MnAliasSetDO[] aliasSets = adapter.getMnAliasSetDOs(medSrvAliasDOs);
		return aliasSets;
	}
}
