package iih.bd.fc.quesite.s.rule;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.mp.dg.i.IMpDgOutService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 队列工作点删除检查规则
 * 
 * @author hao_wu
 *
 */
public class QueSiteDelteCheckRule implements IRule<QueSiteDO> {

	@Override
	public void process(QueSiteDO... queSiteArray) throws BizException {
		if (queSiteArray == null || queSiteArray.length <= 0) {
			return;
		}

		CheckHasUnDispPres(queSiteArray);
	}

	/**
	 * 检查是否有未发药处方
	 * 
	 * @param queSiteArray
	 * @throws BizException
	 */
	private void CheckHasUnDispPres(QueSiteDO[] queSiteArray) throws BizException {
		IMpDgOutService mpDgOutService = ServiceFinder.find(IMpDgOutService.class);
		for (QueSiteDO queSiteDO : queSiteArray) {
			FBoolean hasUnDispPres = mpDgOutService.ifSiteHasUnDispPres(queSiteDO.getId_quesite());
			if (hasUnDispPres != null && hasUnDispPres.equals(FBoolean.TRUE)) {
				String msg = String.format("发药窗口\"%s\"有未发药处方，不允许删除。", queSiteDO.getName());
				throw new BizException(msg);
			}
		}
	}

}
