package iih.ci.ord.s.ems.op.fee;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.FeeListCrtDTO;
import iih.ci.ord.i.meta.FeeListRstDTO;
import iih.ci.ord.s.ems.itf.bp.IFeeListCreateBP;
import xap.mw.core.data.BizException;

/**
 * 费用清单创建服务
 * 
 * @author wangqingzhu
 *
 */
public class FeeListCreateAction implements IFeeListCreateBP {

	/**
	 * 费用清单项目创建业务逻辑接口
	 */
	private IFeeListCreateBP feeListCreateBP;

	/**
	 * 构建方法
	 * 
	 * @param feeListCreateBP
	 */
	public FeeListCreateAction(IFeeListCreateBP feeListCreateBP) {
		this.feeListCreateBP = feeListCreateBP;
	}

	@Override
	public FeeListRstDTO create(CiEnContextDTO ctx, FeeListCrtDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return feeListCreateBP.create(ctx,ems);
	}

}
