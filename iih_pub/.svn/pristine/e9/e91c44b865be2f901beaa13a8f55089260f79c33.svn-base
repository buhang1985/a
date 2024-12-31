package iih.bl.cc.i;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 结账命令服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlCcCmdService {
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
	public abstract BlccAggDO[] doCheckoutChange(BlccAggDO[] blccAggArr, String sd_cctp, FDateTime end_time) throws BizException;

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
	public abstract BlccAggDO[] doCancelCheckout(String id_user,String id_org,BlccAggDO[] blccAggDOArr) throws BizException;
	/**
	 * 判断是否可以取消结账
	 * */
	public FBoolean checkBlccCancel(BlCcDO blccDO) throws BizException;
}
