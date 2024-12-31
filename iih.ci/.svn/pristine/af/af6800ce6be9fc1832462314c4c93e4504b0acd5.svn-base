package iih.ci.ord.s.external.bp.bl.account;

import iih.bl.params.BlParamConst;
import iih.bl.params.BlParamValueConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.external.bp.bl.refund.ExecRefundAccountOrders;
import iih.ci.ord.s.external.bp.bl.refund.OpeningRefundAccountOrders;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 医嘱记账根据记账模式，选择对应的记账操作
 * @author zhangwq
 *
 */
public class KeepAccountOrdersFacotory {
	private String ErrorMsg="医院预交金收费流程模式【BLCG0002】，获取失败！";
	//记账模式
	private String keepAccountMode;
	public KeepAccountOrdersFacotory() throws BizException{
		this.keepAccountMode = getKeepAccountMode();
	}
	public AbstractCiOrdBlAccount createExecInstance() throws BizException{
		if(CiOrdUtils.isEmpty(this.keepAccountMode)){
			throw new BizException(ErrorMsg);
		}
		if(BlParamValueConst.BLCG0002_OPEN.equals(keepAccountMode)){
			return new OpeningKeepAccountOrders();
		}else if(BlParamValueConst.BLCG0002_EXEC.equals(keepAccountMode)){
			return new ExecKeepAccountOrders();
		}else if(BlParamValueConst.BLCG0002_ST.equals(keepAccountMode)){
			return new SettleKeepAccountOrders();
		}else if(BlParamValueConst.BLCG0002_CLINIC.equals(keepAccountMode)){
			return new DiagTreatKeepAccountOrders();
		}
		return null;
	}
	public AbstractCiOrdBlAccount createRefundInstance() throws BizException{
		if(CiOrdUtils.isEmpty(this.keepAccountMode)){
			throw new BizException(ErrorMsg);
		}
		if(BlParamValueConst.BLCG0002_OPEN.equals(keepAccountMode)){
			return new OpeningRefundAccountOrders();
		}else if(BlParamValueConst.BLCG0002_EXEC.equals(keepAccountMode)){
			return new ExecRefundAccountOrders();
		}else {
			throw new BizException("非开立记账或执行记账，无法进行销账操作！");
		}
	}
	/**
	 * 获取记账模式
	 * @return
	 * @throws BizException
	 */
	private String getKeepAccountMode() throws BizException{
		return ParamsetQryUtil.getParaString(CiOrdAppUtils.getEnvContext().getOrgId(), BlParamConst.BLCG0002);
	}
}
