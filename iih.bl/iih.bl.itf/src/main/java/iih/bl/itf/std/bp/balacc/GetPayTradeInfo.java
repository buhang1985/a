package iih.bl.itf.std.bp.balacc;

import java.util.ArrayList;
import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.balacc.WsParamPayTrade;
import iih.bl.itf.std.bean.input.balacc.sub.WsParamPayTerminalInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.balacc.WsResultInfoPayTrade;
import iih.bl.itf.std.bean.output.balacc.WsResultOrderPayInfo;
import iih.bl.itf.std.bean.output.balacc.WsResultPayTrade;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamPayTradeValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询对账信息(收付款)
 * 
 * @author shaokx 2019/07/04
 *
 */
public class GetPayTradeInfo extends BlItfBaseBP<WsParamPayTrade, WsResultPayTrade>{

	private static String NOTE_SUCCESS = "对账成功";
	private static String NOTE_FAIL = "对账失败";
	
	@Override
	protected String getBusiness() {
		
		return "查询对账信息(收付款)";
	}

	@Override
	protected void checkParam(WsParamPayTrade param) throws BizException {
		WsParamPayTradeValidator validator = new WsParamPayTradeValidator();
		validator.validate(param);
		
		// 设置人员上下文
		WsParamPayTerminalInfo terInfo = param.getTerminalInfo();
		if(!StringUtil.isEmpty(terInfo.getOperaCode())){
			PsnDocDO psndocDO = super.getPsnInfo(terInfo.getOperaCode());
			if (psndocDO == null) {
				throw new BizException("查询对账信息:未查询到人员信息");
			}
			Context.get().setStuffId(psndocDO.getId_psndoc());
		}
	}
	
	@Override
	protected WsResultPayTrade doWork(WsParamPayTrade param) throws BizException {
		WsParamPayTerminalInfo terInfo = param.getTerminalInfo();
		
		//1、查询收付款数据(门诊+住院)
		WsResultOrderPayInfo[] payInfo =  this.getPayInfo(terInfo);
		
		//2、新增对账明细
		int count = 0;
		FDouble amt = FDouble.ZERO_DBL;
		List<WsResultOrderPayInfo> orders = this.setPayTradeItem(payInfo,count,amt);
		
		//3、通过账单号或者流水凭证号查询该号是否存在
		WsResultOrderPayInfo isExitDO = this.isOrAndDocu(terInfo);
		
		//4、组装出参
		WsResultPayTrade rlt = new WsResultPayTrade();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("成功");
		
		WsResultInfoPayTrade rltInfo = new WsResultInfoPayTrade();
		rltInfo.setOperaCode(terInfo.getOperaCode());
		rltInfo.setTradeCount(Integer.toString(count));
		rltInfo.setTerminaTotal(terInfo.getTerminaTotal());
		rltInfo.setChargeTotal(BlAmtConverUtil.toXmlString(amt));	
		rltInfo.setIsoranddocu(isExitDO == null ? "1" : "0");// 0存在，1不存在
		
		//如果订单号存在，则获取该订单号所在DO的各个信息
		if(isExitDO != null){
			rltInfo.setOrPayTime(isExitDO.getPayTime());
			rltInfo.setOrPaymentMethod(isExitDO.getPaymentMethod());
			rltInfo.setOrOrderNumber(isExitDO.getOrderNumber());
			rltInfo.setOrDocumentNumber(isExitDO.getDocumentNumber());
			rltInfo.setOrStCode(isExitDO.getStCode());
			rltInfo.setOrPayMoney(BlAmtConverUtil.toXmlString(new FDouble(isExitDO.getPayMoney())));
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
	 * 判断订单号和流水凭证号是否存在
	 * @throws DAException 
	 */
	private WsResultOrderPayInfo isOrAndDocu(WsParamPayTerminalInfo terInfo) throws DAException{
		
		if(StringUtil.isEmpty(terInfo.getOrderNumber()) && StringUtil.isEmpty(terInfo.getDocumentNumber())){
			return null;
		}
		StringBuilder sql=new StringBuilder();
		sql.append(" select * from ( ");
		sql.append(" select  ");
		sql.append(" pay.id_emp_pay, ");
		sql.append(" pay.sd_pttp, ");
		sql.append(" pay.dt_pay payTime, ");
		sql.append(" payitm.sd_pm paymentMethod, ");
		sql.append(" payitm.paymodenode orderNumber, ");
		sql.append(" payitm.bankno documentNumber, ");
		sql.append(" st.code_st stCode, ");
		sql.append(" payitm.amt*payitm.eu_direct payMoney ");
		sql.append(" from bl_pay_pat_oep pay ");
		sql.append(" inner join bl_pay_itm_pat_oep payitm on pay.id_paypatoep = payitm.id_paypatoep ");
		sql.append(" inner join bl_st_oep st on st.id_paypatoep = pay.id_paypatoep ");
		sql.append(" union all ");
		sql.append(" select ");
		sql.append(" pay.id_emp_pay, ");
		sql.append(" pay.sd_pttp, ");
		sql.append(" pay.dt_pay payTime, ");
		sql.append(" payitm.sd_pm paymentMethod, ");
		sql.append(" payitm.paymodenode orderNumber, ");
		sql.append(" payitm.bankno documentNumber, ");
		sql.append(" st.code_st stCode, ");
		sql.append(" payitm.amt*payitm.eu_direct payMoney ");
		sql.append(" from bl_pay_pat_ip pay ");
		sql.append(" inner join bl_pay_itm_pat_ip payitm on pay.id_paypatip = payitm.id_paypatip ");
		sql.append(" inner join bl_st_ip st on st.id_stip = pay.id_stip ");
		sql.append(" ) pay ");
		sql.append(" where 1=1 ");

		if (!StringUtil.isEmpty(terInfo.getOrderNumber())) {
			sql.append(" and pay.orderNumber = ?");
		}
		if (!StringUtil.isEmpty(terInfo.getDocumentNumber())) {
			sql.append(" and pay.documentNumber = ? ");
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
		List<WsResultOrderPayInfo> list = (List<WsResultOrderPayInfo>) new DAFacade().execQuery(sql.toString(), sp,
						new BeanListHandler(WsResultOrderPayInfo.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 新增对账明细
	 */
	private List<WsResultOrderPayInfo> setPayTradeItem(WsResultOrderPayInfo[] payInfo,int count,FDouble amt){
		List<WsResultOrderPayInfo> orders = new ArrayList<WsResultOrderPayInfo>();
		if(!ArrayUtil.isEmpty(payInfo)){
			count = payInfo.length;
			for (WsResultOrderPayInfo itm : payInfo) {
				amt = amt.add(new FDouble(itm.getPayMoney()));
				itm.setPayMoney(BlAmtConverUtil.toXmlString(new FDouble(itm.getPayMoney())));
				orders.add(itm);
			}
		}
		return orders;
	}
	
	/**
	 * 查询收付款数据
	 * @throws BizException 
	 */
	private WsResultOrderPayInfo[] getPayInfo(WsParamPayTerminalInfo terInfo) throws BizException{
		StringBuilder sql=new StringBuilder();
		sql.append(" select * from ( ");
		sql.append(" select  ");
		sql.append(" pay.id_emp_pay, ");
		sql.append(" pay.sd_pttp, ");
		sql.append(" pay.dt_pay payTime, ");
		sql.append(" payitm.sd_pm paymentMethod, ");
		sql.append(" payitm.paymodenode orderNumber, ");
		sql.append(" payitm.bankno documentNumber, ");
		sql.append(" st.code_st stCode, ");
		sql.append(" payitm.amt*payitm.eu_direct payMoney ");
		sql.append(" from bl_pay_pat_oep pay ");
		sql.append(" inner join bl_pay_itm_pat_oep payitm on pay.id_paypatoep = payitm.id_paypatoep ");
		sql.append(" inner join bl_st_oep st on st.id_paypatoep = pay.id_paypatoep ");
		sql.append(" union all ");
		sql.append(" select ");
		sql.append(" pay.id_emp_pay, ");
		sql.append(" pay.sd_pttp, ");
		sql.append(" pay.dt_pay payTime, ");
		sql.append(" payitm.sd_pm paymentMethod, ");
		sql.append(" payitm.paymodenode orderNumber, ");
		sql.append(" payitm.bankno documentNumber, ");
		sql.append(" st.code_st stCode, ");
		sql.append(" payitm.amt*payitm.eu_direct payMoney ");
		sql.append(" from bl_pay_pat_ip pay ");
		sql.append(" inner join bl_pay_itm_pat_ip payitm on pay.id_paypatip = payitm.id_paypatip ");
		sql.append(" inner join bl_st_ip st on st.id_stip = pay.id_stip ");
		sql.append(" ) pay ");
		sql.append(" where pay.id_emp_pay = ? ");
		sql.append(" and pay.sd_pttp = ? ");

		if (!StringUtil.isEmpty(terInfo.getStartDate())) {
			sql .append(" and pay.payTime >= '" + terInfo.getStartDate() + "'") ;
		}

		if (!StringUtil.isEmpty(terInfo.getEndDate())) {
			sql .append( " and pay.payTime <= '" + terInfo.getEndDate() + "'");
		}
		
		SqlParam sqlParam=new SqlParam();
		sqlParam.addParam(Context.get().getStuffId());
		sqlParam.addParam(terInfo.getTerminalType());
		
		List<WsResultOrderPayInfo> list =(List<WsResultOrderPayInfo>) new DAFacade().execQuery(sql.toString(), sqlParam, new BeanListHandler(WsResultOrderPayInfo.class));
		
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new WsResultOrderPayInfo[0]);
	}
}
