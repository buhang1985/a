package iih.bl.itf.std.bp.balacc;

import java.util.ArrayList;
import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.balacc.WsParamTrade;
import iih.bl.itf.std.bean.input.balacc.sub.WsParamTerminalInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.balacc.WsResultInfoTrade;
import iih.bl.itf.std.bean.output.balacc.WsResultOrderInfo;
import iih.bl.itf.std.bean.output.balacc.WsResultTrade;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamTradeValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询对账信息(预交金)
 * 
 * @author ly 2018/07/29
 *
 */
public class GetTradeInfoBP extends BlItfBaseBP<WsParamTrade, WsResultTrade> {

	private static String NOTE_SUCCESS = "对账成功";
	private static String NOTE_FAIL = "对账失败";

	@Override
	protected String getBusiness() {
		return "查询对账信息";
	}

	@Override
	protected void checkParam(WsParamTrade param) throws BizException {
		WsParamTradeValidator validator = new WsParamTradeValidator();
		validator.validate(param);
	}

	@Override
	protected WsResultTrade doWork(WsParamTrade param) throws BizException {

		WsParamTerminalInfo terInfo = param.getTerminalInfo();

		// 设置人员上下文
		PsnDocDO psndocDO = super.getPsnInfo(terInfo.getOperaCode());
		if (psndocDO == null) {
			throw new BizException("查询对账信息:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());

		// 查询预交金充值退充值数据
		IBlpaypatRService rService = ServiceFinder.find(IBlpaypatRService.class);
		String whereSql = "id_emp_pay = '" + Context.get().getStuffId() + "' and sd_pttp = '"
				+ terInfo.getTerminalType() + "' and sd_paytp in ('11','12')";

		if (!StringUtil.isEmpty(terInfo.getStartDate())) {
			whereSql += " and dt_pay >= '" + terInfo.getStartDate() + "'";
		}

		if (!StringUtil.isEmpty(terInfo.getEndDate())) {
			whereSql += " and dt_pay <= '" + terInfo.getEndDate() + "'";
		}

		int count = 0;
		FDouble amt = FDouble.ZERO_DBL;
		BlPrePayPatDO[] prepayDos = rService.find(whereSql, " dt_pay ", FBoolean.FALSE);

		// 新增对账明细
		List<WsResultOrderInfo> orders = new ArrayList<WsResultOrderInfo>();

		if (!ArrayUtil.isEmpty(prepayDos)) {
			count = prepayDos.length;
			for (BlPrePayPatDO prepayDO : prepayDos) {
				amt = amt.add(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
				WsResultOrderInfo orderInfo = new WsResultOrderInfo();
				orderInfo.setPayTime(prepayDO.getDt_pay().toString());
				orderInfo.setPaymentMethod(prepayDO.getSd_pm());
				orderInfo.setOrderNumber(prepayDO.getPaymodenode());
				orderInfo.setDocumentNumber(prepayDO.getBankno());
				orderInfo.setIncCode(prepayDO.getCode_rep());
				orderInfo.setPayMoney(BlAmtConverUtil.toXmlString(prepayDO.getAmt().multiply(prepayDO.getEu_direct())));
				orders.add(orderInfo);
			}
		}
		
		//查询门诊收付款数据
		WsResultOrderInfo[] payInfo=this.findpayItmInfo(terInfo);
		if(!ArrayUtil.isEmpty(payInfo)){
			for (WsResultOrderInfo wsResultOrderInfo : payInfo) {
				amt=amt.add(new FDouble(wsResultOrderInfo.getPayMoney()));
				wsResultOrderInfo.setPayMoney(BlAmtConverUtil.toXmlString(new FDouble(wsResultOrderInfo.getPayMoney())));
				orders.add(wsResultOrderInfo);
			}
		}

		WsResultTrade rlt = new WsResultTrade();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		
		//通过账单号或者流水凭证号查询该号是否存在
		BlPrePayPatDO blPrepayPatDO = this.isOrAndDocu(terInfo);
		
		String isOrAndDocu = null;
		
		if(blPrepayPatDO == null){
			isOrAndDocu = "1";
		}else{
			isOrAndDocu = "0";
		}
		
		WsResultInfoTrade rltInfo = new WsResultInfoTrade();
		rltInfo.setOperaCode(terInfo.getOperaCode());
		rltInfo.setTradeCount(Integer.toString(count));
		rltInfo.setTerminaTotal(terInfo.getTerminaTotal());
		rltInfo.setChargeTotal(BlAmtConverUtil.toXmlString(amt));
		// 0存在，1不存在
		rltInfo.setIsoranddocu(isOrAndDocu);
		
		//如果订单号存在，则获取该订单号所在DO的各个信息
		if("0".equals(isOrAndDocu)){
			rltInfo.setOrPayTime(blPrepayPatDO.getDt_pay().toString());
			rltInfo.setOrPaymentMethod(blPrepayPatDO.getSd_pm());
			rltInfo.setOrOrderNumber(blPrepayPatDO.getPaymodenode());
			rltInfo.setOrDocumentNumber(blPrepayPatDO.getBankno());
			rltInfo.setOrIncCode(blPrepayPatDO.getCode_rep());
			rltInfo.setOrPayMoney(BlAmtConverUtil.toXmlString(blPrepayPatDO.getAmt().multiply(blPrepayPatDO.getEu_direct())));
		}
		
		

		if (rltInfo.getTerminaTotal().equals(rltInfo.getChargeTotal())) {
			rltInfo.setChargeStatus(IBlWsConst.TRUE);
			rltInfo.setNote(NOTE_SUCCESS);
		} else {
			rltInfo.setChargeStatus(IBlWsConst.FALSE);
			rltInfo.setNote(NOTE_FAIL);
		}

		rlt.setRltMsg(rltMsg);
		rlt.setRltInfo(rltInfo);
		rlt.setOrders(orders);
		return rlt;
	}

	/**
	 * 查询收付款信息
	 * @throws BizException 
	 */
	private WsResultOrderInfo[] findpayItmInfo(WsParamTerminalInfo param) throws BizException{
		StringBuilder sql=new StringBuilder();
		sql.append(" select                                                                       ");
		sql.append(" pay.dt_pay payTime,                                                          ");
		sql.append(" payitm.sd_pm paymentMethod,                                                  ");
		sql.append(" payitm.paymodenode orderNumber,                                              ");
		sql.append(" payitm.bankno documentNumber,                                                ");
		sql.append(" payitm.amt *payitm.eu_direct payMoney                                        ");
		sql.append("  from bl_pay_pat_oep pay                                                     ");
		sql.append(" inner join bl_pay_itm_pat_oep payitm on payitm.id_paypatoep=pay.id_paypatoep   ");
		sql.append(" where pay.id_emp_pay=? ");
		sql.append(" and pay.sd_pttp = ? ");
		if (!StringUtil.isEmpty(param.getStartDate())) {
			sql .append(" and dt_pay >= '" + param.getStartDate() + "'") ;
		}

		if (!StringUtil.isEmpty(param.getEndDate())) {
			sql .append( " and dt_pay <= '" + param.getEndDate() + "'");
		}
		
		SqlParam sqlParam=new SqlParam();
		sqlParam.addParam(Context.get().getStuffId());
		sqlParam.addParam(param.getTerminalType());
		List<WsResultOrderInfo> list =(List<WsResultOrderInfo>) new DAFacade().execQuery(sql.toString(), sqlParam, new BeanListHandler(WsResultOrderInfo.class));
		
		return list.toArray(new WsResultOrderInfo[0]);
	}
	
	/**
	 * 判断订单号和流水凭证号是否存在
	 * 
	 * @return
	 * @throws DAException
	 */
	private BlPrePayPatDO isOrAndDocu(WsParamTerminalInfo terInfo) throws BizException {

		if(StringUtil.isEmpty(terInfo.getOrderNumber()) && StringUtil.isEmpty(terInfo.getDocumentNumber())){
			return null;
		}

		// 查询预交金表
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" dt_pay,sd_pm,code_rep,amt,eu_direct,id_paypat,paymodenode,bankno ");
		sb.append(" from ");
		sb.append(" bl_prepay_pat ");
		sb.append(" where 1=1 ");
		if (!StringUtil.isEmpty(terInfo.getOrderNumber())) {
			sb.append("   and paymodenode = ?");
		}
		if (!StringUtil.isEmpty(terInfo.getDocumentNumber())) {
			sb.append(" and bankno = ? ");
		}

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (!StringUtil.isEmpty(terInfo.getOrderNumber())) {
			sp.addParam(terInfo.getOrderNumber());
		}
		if (!StringUtil.isEmpty(terInfo.getDocumentNumber())) {
			sp.addParam(terInfo.getDocumentNumber());
		}

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<BlPrePayPatDO> list = (List<BlPrePayPatDO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(BlPrePayPatDO.class));

		if(list.size() != 0){
			return list.get(0);
		}else{
			return null;
		}
		
		
//		if (ListUtil.isEmpty(list)) {
//			return "1";
//		} else {
//			return "0";
//		}
	}

}
