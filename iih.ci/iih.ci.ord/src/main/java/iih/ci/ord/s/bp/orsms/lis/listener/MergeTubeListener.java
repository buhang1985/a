package iih.ci.ord.s.bp.orsms.lis.listener;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.mergetube.BaseMergeTubeListener;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.s.bp.orsms.lis.CiLisOrSmsRuleDefaultArrangeBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
/**
 * 药品医嘱内容拼接基类监听，所有客开医嘱内容，都需要继承这个基类
 * @author zhangwq
 *
 */
public class MergeTubeListener extends BaseMergeTubeListener  {
	/**
	 * 处理自己的业务
	 * @param event
	 * @throws BizException
	 */
	@Override
	public void doYourAction(CiEnContextDTO ctx, List<CiLisOrSmsIoDTO> orsmsiolists,FMap2 fmap2) throws BizException {
		CiLisOrSmsRuleDefaultArrangeBP bp = new CiLisOrSmsRuleDefaultArrangeBP();
		orsmsiolists = bp.exec(ctx, orsmsiolists);
		fmap2.put("MergeTube", orsmsiolists);
	}
}
