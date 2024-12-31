package iih.bd.pp.anhuiinsur.s.bp;

import iih.bd.pp.anhuiinsur.d.BdHpDiOrginalDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 安徽东软医保删除所有病种目录bp
 * @author guoyang
 *
 */
public class DeleteAllDiOrginalBp {

	public void exec() throws BizException {
		String wherePart = BdEnvContextUtil.processEnvContext(new BdHpDiOrginalDO(), false);
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpDiOrginalDO.class, wherePart);
	}
}
