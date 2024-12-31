package iih.ci.ord.s.bp.orsms.lis.ip;

import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.orsms.lis.CiLisOrSmsHandlerBP;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeBP;
import xap.mw.core.data.BizException;
/**
 * 住院检验合单逻辑
 * @author zhangwq
 *
 */
public class IpCiLisOrSmsHandlerBP extends CiLisOrSmsHandlerBP {
	@Override
	protected MergeTubeRstDTO mergeTubeContpAndSampcolOrds(CiEnContextDTO ctx, CiapplissheetAggDO[] lissheets,
			CiOrderDO[] ciors) throws BizException {
		MergeTubeBP mergeTubeBP = new IpMergeTubeBP(ctx);
		return mergeTubeBP.exec(lissheets);
	}

	@Override
	public MergeTubeBP getMergeTubeBP(CiEnContextDTO ctx) {
		return new IpMergeTubeBP(ctx);
	}
	
}
