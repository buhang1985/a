package iih.bl.cc.s;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.i.IBlCcCmdService;
import iih.bl.cc.s.bp.DoCancelCheckoutBP;
import iih.bl.cc.s.bp.DoCheckoutChangeBP;
import iih.bl.cc.s.bp.GetCheckBlccDOCancelBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 结账命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces={IBlCcCmdService.class}, binding=Binding.JSONRPC)
public class BlCcCmdServiceImpl implements IBlCcCmdService{
	/**
	 * 结账
	 * @param blccAggArr 结账AGGDO
	 * @param sd_cctp 结账类型
	 * @param end_time 结账时间
	 * @return BlccAggDO
	 * @throws BizException
	 * @author LIM
	 * @since 2017-06-23
	 */
	@Override
	public BlccAggDO[] doCheckoutChange(BlccAggDO[] blccAggArr, String sd_cctp,
			FDateTime end_time) throws BizException {
		DoCheckoutChangeBP bp = new DoCheckoutChangeBP();
		return bp.exec(blccAggArr, sd_cctp, end_time);
	}

	/**
	 * 取消结账
	 * @param id_user 用户ID
	 * @param id_org 机构
	 * @param blccAggDOArr 结账AGGDO
	 * @return BlccAggDO
	 * @throws BizException
	 * @author LIM
	 * @since 2017-06-23
	 */
	@Override
	public BlccAggDO[] doCancelCheckout(String id_user, String id_org,
			BlccAggDO[] blccAggDOArr) throws BizException {
		DoCancelCheckoutBP bp = new DoCancelCheckoutBP();
		return bp.exec(id_user, id_org, blccAggDOArr);
	}
	/**
	 * 判断是否可以取消结账
	 * */
	@Override
	public FBoolean checkBlccCancel(BlCcDO blccDO) throws BizException{
		GetCheckBlccDOCancelBP blccCancel = new GetCheckBlccDOCancelBP();
		return blccCancel.exec(blccDO);
	}

}
