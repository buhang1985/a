package iih.ci.ord.s.external.bp.bl.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.provide.ICiOrdBlAccountService;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.OrderAccountDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.op.order.ICiOpOrderMainService;
import iih.ci.ord.s.bp.CiOrSufInfo4ScAptApplBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public abstract class AbstractCiOrdBlAccount implements ICiOrdBlAccountService {

	// 允许记账医嘱key值
	protected final static String ALLOWED_ACCOUNT_ORDERS = "allowedAccountOrders";

	// 允许销账医嘱key值
	protected final static String ALLOWED_CANNCEL_ORDERS = "allowedAccountOrders";

	protected final static String NO_ALLOWED_ACCOUNT_ORDERS = "不存在待记账的医嘱！";
	
	protected final static String NO_ALLOWED_REFUND_ORDERS = "不存在可销账的医嘱！";

	@Override
	public FMap isAllowedUseAccout(CiEnContextDTO ctx) {

		return null;
	}
	/**
	 * 过滤出可以进行记账的医嘱
	 * @param ctx
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	protected OrderRstDTO filterAllowedAccountOrders(CiEnContextDTO ctx, String[] id_ors) throws BizException  {

		OrderRstDTO orderRst = new OrderRstDTO();

		List<CiOrderDO> orderList = this.getAccountOrderList(ctx, id_ors);

		if (orderList == null || orderList.size() == 0) {

			orderRst.setIsSuccess(FBoolean.FALSE);
			orderRst.setMessageInfo(NO_ALLOWED_ACCOUNT_ORDERS);
			return orderRst;
		}

		List<CiOrderDO> allowedAccountList = new ArrayList<CiOrderDO>();
		StringBuffer msgBuffer = new StringBuffer();

		for (CiOrderDO order : orderList) {
			OrderAccountDTO ordAccount = this.isAllowedAccountOrders(ctx, order);
			// 当不符合记账要求时，记录不符合原因
			if (FBoolean.TRUE.equals(ordAccount.getFg_allowed_account())) {
				allowedAccountList.add(order);
			} else {
				msgBuffer.append(ordAccount.getMessageInfo()).append(System.lineSeparator());
			}
		}

		FArrayList orderFList = new FArrayList();
		orderFList.addAll(allowedAccountList);

		orderRst.setMessageInfo(msgBuffer.toString());
		orderRst.setDocument(orderFList);
		return orderRst;
	}
    /**
     * 记账
     */
	@Override
	public OrderRstDTO keepAccountOrders(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {

		StringBuffer msgBuffer = new StringBuffer();
		OrderRstDTO orderRst = new OrderRstDTO();
		orderRst.setIsSuccess(FBoolean.FALSE);
		
		FArrayList idOrFList = arg.getDocument();
		if(idOrFList == null ||idOrFList.size() ==0){
			orderRst.setMessageInfo("请选需要记账的医嘱！");
			return orderRst;
		}
		String[] id_ors = (String[]) idOrFList.toArray(new String[idOrFList.size()]);
		
		orderRst = filterAllowedAccountOrders(ctx, id_ors);
		FArrayList orderFList = orderRst.getDocument();

		if (orderFList == null || orderFList.size() == 0) {
			orderRst.setIsSuccess(FBoolean.FALSE);
			return orderRst;
		}

		// 调用记账 ServiceFinder
		ICiOrdBlService ciOrdBlService = ServiceFinder.find(ICiOrdBlService.class);
		
		OrderRstDTO orderRst2 = ciOrdBlService.keepAccountOrders(ctx, (List) orderFList);
		
		if(StringUtils.isNotEmpty(orderRst2.getMessageInfo())){
			msgBuffer.append(orderRst2.getMessageInfo()).append(System.lineSeparator());
		}
		if(StringUtils.isNotEmpty(orderRst.getMessageInfo())){
			msgBuffer.append(orderRst.getMessageInfo());
		}
		if(StringUtils.isBlank(msgBuffer.toString())) {
			msgBuffer.append("记账成功！");
		} 
		orderRst2.setMessageInfo(msgBuffer.toString());

		return orderRst2;
	}
	/**
	 * 销账
	 */
	@Override
	public OrderRstDTO cancelAccoutOrders(CiEnContextDTO ctx, String[] id_ors) throws BizException {
		StringBuffer msgBuffer = new StringBuffer();
		OrderRstDTO orderRst = new OrderRstDTO();
		orderRst.setIsSuccess(FBoolean.FALSE);
		if(id_ors==null||id_ors.length==0){
			orderRst.setMessageInfo("请选需要销账的医嘱！");
			return orderRst;
		}
		orderRst = filterAllowedFefundOrders(ctx, id_ors);
		FArrayList orderFList = orderRst.getDocument();

		FArrayList idOrs = new FArrayList();
		if (orderFList == null || orderFList.size() == 0) {
			orderRst.setIsSuccess(FBoolean.FALSE);
			return orderRst;
		}else{
			for(Object ordObj : orderFList){
				idOrs.add(((CiOrderDO)ordObj).getId_or());
			}
		}

		// 调用销账 ServiceFinder
		ICiOrdBlService ciOrdBlService = ServiceFinder.find(ICiOrdBlService.class);
		OrderRstDTO orderRst2 = ciOrdBlService.refundAccountOrders(ctx, (List) orderFList);
		//作废医嘱 其中还包含清空处方和打印数据的操作
		ICiOpOrderMainService ciOrderMainService = ServiceFinder.find(ICiOpOrderMainService.class);
		OrderOperateDTO orderOperateDTO = new OrderOperateDTO();
		orderOperateDTO.setEnContext(ctx);
		orderOperateDTO.setExtension(orderRst.getExtension());
		orderOperateDTO.setDocument(idOrs);
		ciOrderMainService.cancel(ctx, orderOperateDTO);
		//
		CiOrSufInfo4ScAptApplBp bp = new CiOrSufInfo4ScAptApplBp();
		//撤回，作废时，调用手术撤回
		CiOrderDO[] ciorders = (CiOrderDO[])orderFList.toArray(new CiOrderDO[0]);
		bp.sendSugInfo4ScAptAppl(ctx,ciorders);
		if(StringUtils.isNotEmpty(orderRst2.getMessageInfo())){
			msgBuffer.append(orderRst2.getMessageInfo()).append(System.lineSeparator());
		}
		if(StringUtils.isNotEmpty(orderRst.getMessageInfo())){
			msgBuffer.append(orderRst.getMessageInfo());
		}
		orderRst2.setMessageInfo(msgBuffer.toString());

		return orderRst2;
	}
	/**
	 * 过滤出可退费的医嘱
	 * @param ctx
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	protected OrderRstDTO filterAllowedFefundOrders(CiEnContextDTO ctx, String[] id_ors) throws BizException  {
		OrderRstDTO orderRst = new OrderRstDTO();

		List<CiOrderDO> orderList = this.getAccountOrderList(ctx, id_ors);

		if (orderList == null || orderList.size() == 0) {

			orderRst.setIsSuccess(FBoolean.FALSE);
			orderRst.setMessageInfo(NO_ALLOWED_REFUND_ORDERS);
			return orderRst;
		}

		List<CiOrderDO> allowedRefundList = new ArrayList<CiOrderDO>();
		FMap2 refundMap2 = new FMap2();
		StringBuffer msgBuffer = new StringBuffer();

		for (CiOrderDO order : orderList) {
			//	0126807: 门急诊医生站，取消预付费，报错   方法调用错误  GH
			//OrderAccountDTO ordAccount = this.isAllowedAccountOrders(ctx, order);
			OrderAccountDTO ordAccount = this.isAllowedRefoundOrders(ctx, order);
			// 当不符合销账要求时，记录不符合原因
			if (FBoolean.TRUE.equals(ordAccount.getFg_allowed_account())) {
				refundMap2.put(order.getId_or(), order.getSd_su_or());
				allowedRefundList.add(order);
			} else {
				msgBuffer.append(ordAccount.getMessageInfo()).append(System.lineSeparator());
			}
		}

		FArrayList orderFList = new FArrayList();
		orderFList.addAll(allowedRefundList);

		orderRst.setMessageInfo(msgBuffer.toString());
		orderRst.setExtension(refundMap2);
		orderRst.setDocument(orderFList);
		return orderRst;
	}
	@Override
	public OrderRstDTO updateOrdersAccountSdSuBl(String id_en, Map<String, String> sdSuBlMap) {

		return null;
	}

	/**
	 * 判断当前医嘱是否允许记账
	 * 
	 * @param order 判断是否允许记账的医嘱
	 * @return 返回判断结果，当不符合记账要求时，必须设置不符合原因
	 */
	protected abstract OrderAccountDTO isAllowedAccountOrders(CiEnContextDTO ctx, CiOrderDO order);
	
	/**
	 * 判断当前医嘱是否允许销账
	 * 
	 * @param order 判断是否允许销账的医嘱
	 * @return 返回判断结果，当不符合销账要求时，必须设置不符合原因
	 */
	protected abstract OrderAccountDTO isAllowedRefoundOrders(CiEnContextDTO ctx, CiOrderDO order);

	/**
	 * 获取待记账的医嘱
	 * 
	 * @param ctx 患者当前就诊环境
	 * @param id_ors 医嘱id集合
	 * @return
	 * @throws BizException 
	 * @throws DAException 
	 */
	protected List<CiOrderDO> getAccountOrderList(CiEnContextDTO ctx, String[] id_ors) throws BizException {

		// 执行记账可以跨就诊
		// 选中的、执行科室为当前科室的，当前医生签署的、非药品、已签署、未作废、未记账、未销账、可退费、未结算的医嘱。
		String sql = "select id_or,code_or,name_or,sd_su_or,sd_srvtp,id_emp_sign,id_dep_sign,id_dep_mp,fg_sign,sd_su_bl,fg_canc,eu_feereversetp,fg_feertnable from ci_order where id_or in (";
		StringBuffer whereBuffer = new StringBuffer();
		SqlParam param = new SqlParam();
		for (String id_or : id_ors) {
			whereBuffer.append(",?");
			param.addParam(id_or);
		}

		List<CiOrderDO> orderList = (List<CiOrderDO>) new DAFacade().execQuery(sql + whereBuffer.substring(1) + ")",
				param, new BeanListHandler(CiOrderDO.class));

		return orderList;
	}

}
