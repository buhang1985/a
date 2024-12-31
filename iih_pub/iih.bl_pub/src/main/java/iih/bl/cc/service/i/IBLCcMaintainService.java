package iih.bl.cc.service.i;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blfi.d.BlFiDO;
import iih.bl.cc.dto.d.BlCcInParamDTO;
import iih.bl.cc.dto.d.BlCcOutParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public interface IBLCcMaintainService {
	
	/**
	 * 结账
	 * */
	public abstract BlccAggDO[] doCheckoutChange(BlccAggDO[] blccAggArr, String sd_cctp, FDateTime end_time) throws BizException;
	
	/**
	 * 判断是否可以取消结账
	 **/
	public FBoolean checkBlccCancel(BlCcDO blccDO) throws BizException;
	
	/**
	 * 取消结账
	 **/
	public abstract BlccAggDO[] doCancelCheckout(String id_user,String id_org,BlccAggDO[] blccAggDOArr) throws BizException;
	
	/**
	 * 小组长结账-hanJQ
	 * @param fiDo :财务交割数据
	 * @param blCcDos :结账数据
	 * @param code_fi : 本次结账财务凭证号
	 * @return
	 * @throws BizException
	 */
	public abstract BlCcDO [] doGRPLeaderCheckout(BlFiDO fiDo , BlCcDO [] blCcDos) throws BizException;
	
	/**
	 * 小组长取消结账
	 * @param fiDos
	 * @return
	 * @throws BizException
	 */
	public abstract BlFiDO[] doGRPLeaderCancelCheckout(BlFiDO[] fiDos) throws BizException;
	
	/**
	 * 结账（对外接口）
	 * @param BlCcInparamDTO
	 * @return
	 * @throws BizException
	 */
	public abstract BlCcOutParamDTO[] doBlccCheckout(BlCcInParamDTO BlCcInparamDTO) throws BizException;
	
}
