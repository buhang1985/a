package iih.ci.ord.s.ems.third.pres;

import java.util.List;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitpres.CiOr2CiOrPresSplitListBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitHandleBP;
import iih.ci.ord.s.bp.splitpres.TLCiOr2CiOrPresSplitListBP2;
import xap.mw.core.data.BizException;

public class PatchFeePresSplitBP extends CiOrPresSplitHandleBP {

	@Override
	public List<CiOrPresSplitList> exec(CiEnContextDTO ctx, CiOrderDO[] ciors, CiOrSessionDO session) throws BizException {
		if (CiOrdUtils.isEmpty(ciors))
			return null;

		//分方医嘱到临床医嘱分方数据信息列表集合的转换
		List<CiOrPresSplitList> orpressplitlists = convertCiOr2CiOrPresSplitList(ciors);

		//获得分方规则编排插件并执行插件
		orpressplitlists = ciOrPresSplitRuleArrangePluginExec(orpressplitlists);

		//生成处方并保存处方
		CiPresDO[] cipres = genPresByOrdPresSplit(orpressplitlists, session);

		//临床医嘱处方分方后执行域相关处理
		ciOrPresSplitMpHandle(cipres);

		//返回
		return orpressplitlists;
	}

	@Override
	protected List<CiOrPresSplitList> convertCiOr2CiOrPresSplitList(CiOrderDO[] ciors) throws BizException {
		CiOr2CiOrPresSplitListBP bp=new TLCiOr2CiOrPresSplitListBP2();
		return bp.exec(ciors);
	}
	
}
