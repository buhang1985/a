package iih.bd.pp.hpsrvorca.s.bp;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 清除药品对照
 * 
 * @author hexx
 *
 */
public class DeleteDrugHpSrvorcaBp {

	public void exec() throws BizException {
		deleteBdHpSrvorca();

	}

	private void deleteBdHpSrvorca() throws DAException {
		String wherePart = String.format("id_grp = '%s' and id_org = '%s' and id_mm != '~'", Context.get().getGroupId(),
				Context.get().getOrgId());
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(HPSrvorcaDO.class, wherePart);

	}
}
