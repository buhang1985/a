package iih.ci.ord.s.ems.op.pres;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.PresLoadDTO;
import iih.ci.ord.i.meta.PresRstDTO;
import iih.ci.ord.i.meta.PresSplDTO;
import iih.ci.ord.s.ems.itf.bp.IPresLoadBP;
import iih.ci.ord.s.ems.itf.bp.IPresSeparateBP;
import xap.mw.core.data.BizException;

/**
 * 
 * @author wangqingzhu
 *
 */
public class PresListAction implements IPresLoadBP,IPresSeparateBP {
	@Override
	public PresRstDTO load(CiEnContextDTO ctx, PresLoadDTO ld) throws BizException {
		// 调用代理业务实现，获取处方数据信息
		return new PresLoadBP().load(ctx,ld);
	}

	@Override
	public PresRstDTO reSeparate(CiEnContextDTO ctx, PresSplDTO ld) throws BizException {
		// 调用重新分方代理实现，进行重新分方操作
		return new PresSeparateBP().reSeparate(ctx,ld);
	}

}
