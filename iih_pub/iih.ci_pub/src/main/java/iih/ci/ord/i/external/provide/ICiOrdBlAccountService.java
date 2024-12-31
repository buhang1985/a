package iih.ci.ord.i.external.provide;

import java.util.Map;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAException;

public interface ICiOrdBlAccountService {

	/**
	 * 是否允许使用记账、销账功能
	 * 
	 * @param ctx
	 * @return
	 */
	public abstract FMap isAllowedUseAccout(CiEnContextDTO ctx);

	/**
	 * 判断当前医嘱是否允许进行记账
	 * 
	 * @param ctx 当前就诊环境
	 * @param id_ors 待校验的医嘱id集合
	 * @return
	 */
	//public abstract OrderRstDTO filterAllowedAccountOrders(CiEnContextDTO ctx, String[] id_ors);

	/**
	 * 根据就诊信息对医嘱进行记账操作
	 * 
	 * @param ctx 就诊环境信息
	 * @param id_ors 当前待记账的医嘱集合
	 * @return
	 * @throws BizException 
	 */
	//public abstract OrderRstDTO keepAccountOrders(CiEnContextDTO ctx, String[] id_ors) throws BizException;
	
	/**
	 * 根据就诊信息对医嘱进行记账操作
	 * 
	 * @param ctx 就诊环境信息
	 * @param id_ors 当前待记账的医嘱集合
	 * @return
	 * @throws DAException 
	 * @throws BizException 
	 */
	public abstract OrderRstDTO keepAccountOrders(CiEnContextDTO ctx, OrderOperateDTO arg) throws DAException, BizException;

	/**
	 * 根据医嘱id集合销账
	 * 
	 * @param ctx 当前就诊环境
	 * @param id_ors 待销账的医嘱集合
	 * @return
	 * @throws BizException 
	 */
	public abstract OrderRstDTO cancelAccoutOrders(CiEnContextDTO ctx, String[] id_ors) throws BizException;

	/**
	 * 更新医嘱收费时医嘱状态
	 * 
	 * @param id_en 根据就诊id
	 * @param id_ors 医嘱记账状态集合
	 * @return
	 */
	public abstract OrderRstDTO updateOrdersAccountSdSuBl(String id_en, Map<String,String> sdSuBlMap);
}
