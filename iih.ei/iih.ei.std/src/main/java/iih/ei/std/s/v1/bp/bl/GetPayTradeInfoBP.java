package iih.ei.std.s.v1.bp.bl;

import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.output.balacc.WsResultOrderPayInfo;
import iih.ei.std.d.v1.bl.paytradedto.d.OrderInfo;
import iih.ei.std.d.v1.bl.paytradedto.d.PayTradeParamDTO;
import iih.ei.std.d.v1.bl.paytradedto.d.PayTradeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 查询对账信息(收付款)
 * 
 * @author shaokx
 * @date: 2019.10.16
 */
public class GetPayTradeInfoBP extends IIHServiceBaseBP<PayTradeParamDTO, PayTradeResultDTO> {

	private static String NOTE_SUCCESS = "对账成功";
	private static String NOTE_FAIL = "对账失败";
	
	@Override
	protected void checkParam(PayTradeParamDTO param) throws BizException {

		if (param == null) {
			throw new BizException("入参为空");
		}

		if (StringUtil.isEmpty(param.getCode_opera())) {
			throw new BizException("对账查询入参操作员编码为空");
		}

		if (StringUtil.isEmpty(param.getSd_pttp())) {
			throw new BizException("对账查询入参终端类型为空");
		}

		if (StringUtil.isEmpty(param.getAmt())) {
			throw new BizException("对账查询入参自助机总金额为空");
		}
		
		if(StringUtil.isEmpty(param.getDt_start())){
			throw new BizException("入参开始时间为空");
		}
		
		if(StringUtil.isEmpty(param.getDt_end())){
			throw new BizException("入参结束时间为空");
		}

		// 设置人员上下文
		if (!StringUtil.isEmpty(param.getCode_opera())) {
			PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_opera());
			if (psndocDO == null) {
				throw new BizException("查询对账信息:未查询到人员信息");
			}
			Context.get().setStuffId(psndocDO.getId_psndoc());
		}

	}

	@Override
	protected PayTradeResultDTO process(PayTradeParamDTO param) throws BizException {
		
		// 1、查询收付款数据(门诊+住院)
		OrderInfo[] payInfo = this.getPayInfo(param);

		// 2、新增对账明细
		int count = 0;
		FDouble amt = FDouble.ZERO_DBL;
		FArrayList orders = this.setPayTradeItem(payInfo, count, amt);

		// 3、通过账单号或者流水凭证号查询该号是否存在
		WsResultOrderPayInfo isExitDO = this.isOrAndDocu(param);

		// 4、组装出参
		PayTradeResultDTO rltInfo = new PayTradeResultDTO();
		rltInfo.setCode_opera(param.getCode_opera());
		rltInfo.setCount_trade(Integer.toString(count));
		rltInfo.setAmt_third(param.getAmt());
		rltInfo.setAmt_iih(BlAmtConverUtil.toXmlString(amt));
		rltInfo.setFg_exitno(isExitDO == null ? "1" : "0");// 0存在，1不存在

		// 如果订单号存在，则获取该订单号所在DO的各个信息
		if (isExitDO != null) {
			rltInfo.setOr_dt_pay(isExitDO.getPayTime());
			rltInfo.setOr_code_pm(isExitDO.getPaymentMethod());
			rltInfo.setOr_paymodenode(isExitDO.getOrderNumber());
			rltInfo.setOr_bankno(isExitDO.getDocumentNumber());
			rltInfo.setOr_code_rep(isExitDO.getStCode());
			rltInfo.setOr_amt(BlAmtConverUtil.toXmlString(new FDouble(isExitDO.getPayMoney())));
		}

		if (rltInfo.getAmt_third().equals(rltInfo.getAmt_iih())) {
			rltInfo.setStatus_trade(IBlWsConst.TRUE);
			rltInfo.setNote(NOTE_SUCCESS);
		} else {
			rltInfo.setStatus_trade(IBlWsConst.FALSE);
			rltInfo.setNote(NOTE_FAIL);
		}

		rltInfo.setOrderinfo(orders);
		return rltInfo;
	}

	/**
	 * 判断订单号和流水凭证号是否存在
	 * 
	 * @throws DAException
	 */
	private WsResultOrderPayInfo isOrAndDocu(PayTradeParamDTO param) throws DAException {

		if (StringUtil.isEmpty(param.getPaymodenode()) && StringUtil.isEmpty(param.getBankno())) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
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

		if (!StringUtil.isEmpty(param.getPaymodenode())) {
			sql.append(" and pay.orderNumber = ?");
		}
		if (!StringUtil.isEmpty(param.getBankno())) {
			sql.append(" and pay.documentNumber = ? ");
		}

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (!StringUtil.isEmpty(param.getPaymodenode())) {
			sp.addParam(param.getPaymodenode());
		}
		if (!StringUtil.isEmpty(param.getBankno())) {
			sp.addParam(param.getBankno());
		}

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<WsResultOrderPayInfo> list = (List<WsResultOrderPayInfo>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(WsResultOrderPayInfo.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 新增对账明细
	 */
	private FArrayList setPayTradeItem(OrderInfo[] payInfo, int count, FDouble amt) {
		FArrayList orders = new FArrayList();
		if (!ArrayUtil.isEmpty(payInfo)) {
			count = payInfo.length;
			for (OrderInfo itm : payInfo) {
				amt = amt.add(new FDouble(itm.getAmt()));
				itm.setAmt(BlAmtConverUtil.toXmlString(new FDouble(itm.getAmt())));
				orders.add(itm);
			}
		}
		return orders;
	}

	/**
	 * 查询收付款数据
	 * 
	 * @throws BizException
	 */
	private OrderInfo[] getPayInfo(PayTradeParamDTO param) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from ( ");
		sql.append(" select  ");
		sql.append(" pay.id_emp_pay, ");
		sql.append(" pay.sd_pttp, ");
		sql.append(" pay.dt_pay, ");
		sql.append(" payitm.sd_pm code_pm, ");
		sql.append(" payitm.paymodenode, ");
		sql.append(" payitm.bankno, ");
		sql.append(" st.code_st code_rep, ");
		sql.append(" payitm.amt*payitm.eu_direct amt ");
		sql.append(" from bl_pay_pat_oep pay ");
		sql.append(" inner join bl_pay_itm_pat_oep payitm on pay.id_paypatoep = payitm.id_paypatoep ");
		sql.append(" inner join bl_st_oep st on st.id_paypatoep = pay.id_paypatoep ");
		sql.append(" union all ");
		sql.append(" select ");
		sql.append(" pay.id_emp_pay, ");
		sql.append(" pay.sd_pttp, ");
		sql.append(" pay.dt_pay, ");
		sql.append(" payitm.sd_pm code_pm, ");
		sql.append(" payitm.paymodenode, ");
		sql.append(" payitm.bankno, ");
		sql.append(" st.code_st code_rep, ");
		sql.append(" payitm.amt*payitm.eu_direct amt ");
		sql.append(" from bl_pay_pat_ip pay ");
		sql.append(" inner join bl_pay_itm_pat_ip payitm on pay.id_paypatip = payitm.id_paypatip ");
		sql.append(" inner join bl_st_ip st on st.id_stip = pay.id_stip ");
		sql.append(" ) pay ");
		sql.append(" where pay.id_emp_pay = ? ");
		sql.append(" and pay.sd_pttp = ? ");

		if (!StringUtil.isEmpty(param.getDt_start())) {
			sql.append(" and pay.dt_pay >= '" + param.getDt_start() + "'");
		}

		if (!StringUtil.isEmpty(param.getDt_end())) {
			sql.append(" and pay.dt_pay <= '" + param.getDt_end() + "'");
		}

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getStuffId());
		sqlParam.addParam(param.getSd_pttp());

		List<OrderInfo> list = (List<OrderInfo>) new DAFacade().execQuery(sql.toString(),
				sqlParam, new BeanListHandler(OrderInfo.class));

		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.toArray(new OrderInfo[0]);
	}

}
