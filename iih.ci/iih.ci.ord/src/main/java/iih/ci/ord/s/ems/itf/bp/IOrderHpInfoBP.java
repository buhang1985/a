package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.CiErrorDTO;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import xap.mw.core.data.BizException;

/**
 * 处理医保信息
 * @author wangqingzhu
 *
 */
public interface IOrderHpInfoBP extends IOrderConstString {
	
	/**
	 * 处理医嘱层面的医保信息
	 * @param ctx
	 * @param orderInfo
	 * @return
	 */
	public abstract boolean handleOrderHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo);
	
	/**
	 * 处理服务层面的医保信息
	 * @param ctx
	 * @param szSrvInfo
	 * @return
	 */
	public abstract boolean handleSrvHpInfo(CiEnContextDTO ctx, OrderSrvMmList szSrvInfo);
	
	/**
	 * 医保信息处理完成之后，其他处理
	 * @param ctx
	 * @param szSrvInfo
	 * @return
	 */
	public abstract boolean afterHandleHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] szSrvInfo);
	
	/**
	 * 处理医嘱层面的医保信息
	 * @param ctx
	 * @param orderInfo
	 * @return
	 */
	public abstract CiErrorDTO handleOrderHpInfo(CiEnContextDTO ctx, OrderPackageInfo orderPackageInfo) throws BizException;

	// -----------------------------------------------------以下是国际的---------------------------------------
	
	/**
	 * 处理服务层面的医保信息
	 * @param ctx
	 * @param szSrvInfo
	 * @return
	 */
	//public abstract boolean handleSrvHpInfo(CiEnContextDTO ctx, OrderSrvMmList szSrvInfo);
	
	/**
	 * 医保信息处理完成之后，其他处理
	 * @param ctx
	 * @param szSrvInfo
	 * @return
	 */
	//public abstract boolean afterHandleHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] szSrvInfo);
	
	/**
	 * 医嘱数据组装完毕后进行医保细则校验
	 * @param ctx
	 * @param orderSavedRstInfo
	 * @return
	 */
	public abstract CiErrorDTO handleHpVerfyInfo(CiEnContextDTO enContextInfo, OrderPackageInfo orderPakageInfo) throws BizException;
	//public abstract boolean handleHpValidateInfo(CiEnContextDTO ctx,CiOrderDO ciOrderDO,OrderSrvMmList orderSrvMmList,CiErrorDTO err) throws BizException;
	
	/**
	 * 医嘱数据组装完毕后进行医保适应症校验
	 * @param ctx
	 * @param orderSavedRstInfo
	 * @return
	 */
	public abstract CiErrorDTO handleVerfyHpIndic(CiEnContextDTO ctx, OrderPackageInfo orderPackageInfo) throws BizException;
	//public abstract boolean handleValidateHpIndic(CiEnContextDTO ctx, CiOrderDO ciOrderDO,OrderSrvMmList orderSrvMmList,CiErrorDTO err) throws BizException;
}
