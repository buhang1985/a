package iih.bl.inc.blincoep.s.rule;

import iih.bl.inc.blincoep.d.BlincoepAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 门诊发票表插入前规则
 * 1.重新设置票据类型id
 * @author ly 2019/11/01
 *
 */
public class BlIncOepInsertBeforeRule implements IRule<BlincoepAggDO>{

	@Override
	public void process(BlincoepAggDO... aggDos) throws BizException {
		
		/*for (BlincoepAggDO blincoepAggDO : aggDos) {
			// 红冲时使用原票据类型
			if(BookRtnDirectEnum.RETURNS.equals(blincoepAggDO.getParentDO().getEu_direct()))
				continue;
			
			String inccaId = OpInccaJudgeUtil.getInvoiceTp(blincoepAggDO.getParentDO().getId_stoep());
			blincoepAggDO.getParentDO().setId_incca(inccaId);
		}*/
	}
}
