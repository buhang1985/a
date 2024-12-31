package iih.ci.ord.s.ems.op.fee;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.FeeListRstDTO;
import iih.ci.ord.i.meta.FeeListSaveDTO;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.itf.bp.IFeeListSaveBP;
import xap.mw.core.data.BizException;

/**
 * 保存费用清单数据
 * 
 * @author wangqingzhu
 *
 */
public class FeeListSaveBP extends ContextCache implements IFeeListSaveBP {

	/**
	 * 费用清单保存逻辑校验接口
	 */
	private IEmsValidate feeListValidate;

	public FeeListSaveBP(IEmsValidate feeListValidate) {
		this.feeListValidate = feeListValidate;
	}

	@Override
	public FeeListRstDTO save(CiEnContextDTO ctx, FeeListSaveDTO ems) throws BizException {
		// 解析参数 FeeListSaveDTO 并转化为内部保存逻辑使用参数（注意参数的生命周期）

		// 分拣出需要保存的费用数据，并进行数据校验

		// 将保存数据转化为DO对象，并进行数据库保存前数据校验

		// 执行数据库保存

		// 处理返回值结果或者错误信息
		FeeListRstDTO feeListRstDTO = new FeeListRstDTO();
		return feeListRstDTO;
	}

}
