package iih.ci.ord.s.ems.op.feev1;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.FeeListLoadDTO;
import iih.ci.ord.i.meta.FeeListRstDTO;
import iih.ci.ord.s.ems.itf.bp.IFeeListLoadBP;
import xap.mw.core.data.BizException;

/**
 * 费用清单加载服务
 * 
 * @author wangqingzhu
 *
 */
public class FeeListLoadAction implements IFeeListLoadBP {

	/**
	 * 费用清单数据加载业务逻辑处理接口
	 */
	private IFeeListLoadBP feeListLoadBP;

	/**
	 * 构造方法
	 * 
	 * @param feeListLoadBP
	 */
	public FeeListLoadAction(IFeeListLoadBP feeListLoadBP) {
		this.feeListLoadBP = feeListLoadBP;
	}

	@Override
	public FeeListRstDTO load(CiEnContextDTO ctx, FeeListLoadDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return feeListLoadBP.load(ctx, ems);
	}

}
