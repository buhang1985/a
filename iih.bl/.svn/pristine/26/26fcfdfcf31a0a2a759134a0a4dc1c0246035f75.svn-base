package iih.bl.cc.service.s;

import iih.bl.cc.blcc.bp.BlccOperactionBp;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blfi.d.BlFiDO;
import iih.bl.cc.dto.d.BlCcInParamDTO;
import iih.bl.cc.dto.d.BlCcOutParamDTO;
import iih.bl.cc.s.bp.DoBlccCheckoutBP;
import iih.bl.cc.s.bp.DoCancelCheckoutBP;
import iih.bl.cc.s.bp.DoCheckoutChangeBP;
import iih.bl.cc.s.bp.DoGRPLeaderCheckoutBP;
import iih.bl.cc.service.i.IBLCcMaintainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

@Service(serviceInterfaces = {IBLCcMaintainService.class }, binding = Binding.JSONRPC)
public class IBLCcMaintainServiceImpl implements IBLCcMaintainService {

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
		DoCheckoutChangeBP blccBP = new DoCheckoutChangeBP();
		return blccBP.exec(blccAggArr, sd_cctp, end_time);
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
	public BlccAggDO[] doCancelCheckout(String id_user, String id_org, BlccAggDO[] blccAggDOArr)
			throws BizException {
		DoCancelCheckoutBP bp= new DoCancelCheckoutBP();
		return bp.exec(id_user, id_org, blccAggDOArr);
//		BlccOperactionBp blccBp = new BlccOperactionBp();
//		return blccBp.setCancelCheckout(id_user, id_org, blccAggDOArr);
	}
	/**
	 * 判断是否可以取消结账
	 */
	@Override
	public FBoolean checkBlccCancel(BlCcDO blccDO) throws BizException {
		BlccOperactionBp blccBp = new BlccOperactionBp();
		return blccBp.checkBlccDOCancel(blccDO);
	}
	/**
	 * 小组长结账-hanJQ
	 * @param fiDo :财务交割数据
	 * @param blCcDos :结账数据
	 * @param code_fi : 本次结账财务凭证号
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCcDO[] doGRPLeaderCheckout(BlFiDO fiDo , BlCcDO[] blCcDos) throws BizException {
		DoGRPLeaderCheckoutBP bp = new DoGRPLeaderCheckoutBP();		
		return bp.doGRPLeaderCheckout(fiDo , blCcDos);
	}
	
	/**
	 * 小组长取消结账
	 * @param fiDos
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlFiDO[] doGRPLeaderCancelCheckout(BlFiDO[] fiDos) throws BizException {
		DoGRPLeaderCheckoutBP bp = new DoGRPLeaderCheckoutBP();		
		return bp.doGRPLeaderCancelCheckout(fiDos);
	}
	
	/**
	 * 结账（对外接口）
	 * @param BlCcInparamDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlCcOutParamDTO[] doBlccCheckout(BlCcInParamDTO blCcInparamDTO) throws BizException {
		DoBlccCheckoutBP bp= new DoBlccCheckoutBP();
		return bp.exec(blCcInparamDTO);
	}

}
