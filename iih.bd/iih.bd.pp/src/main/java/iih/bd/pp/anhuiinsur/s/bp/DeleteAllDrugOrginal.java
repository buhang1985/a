package iih.bd.pp.anhuiinsur.s.bp;

import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 安徽东软医保删除所有药品目录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteAllDrugOrginal {

	public void exec() throws BizException {
		String wherePart = BdEnvContextUtil.processEnvContext(new BdHpDrugOrginalDO(), false);
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpDrugOrginalDO.class, wherePart);
	}
}
