package iih.bd.pp.anhuiinsur.s.bp;

import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 安徽东软医保删除所有服务设施目录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteAllFwssOrginal {

	public void exec() throws BizException {
		String wherePart = BdEnvContextUtil.processEnvContext(new BdHpFwssOrginalDO(), false);
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpFwssOrginalDO.class, wherePart);
	}
}
