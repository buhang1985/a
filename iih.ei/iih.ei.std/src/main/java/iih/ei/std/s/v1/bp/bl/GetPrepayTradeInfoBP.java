package iih.ei.std.s.v1.bp.bl;

import java.util.List;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.ei.std.d.v1.bl.prepaytradedto.d.OrderInfo;
import iih.ei.std.d.v1.bl.prepaytradedto.d.PrepayTradeParamDTO;
import iih.ei.std.d.v1.bl.prepaytradedto.d.PrepayTradeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
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

/***
 * 查询对账信息(预交金)
 * 
 * @author shaokx
 * @date: 2019.10.15
 */
public class GetPrepayTradeInfoBP extends IIHServiceBaseBP<PrepayTradeParamDTO, PrepayTradeResultDTO> {

	private static String NOTE_SUCCESS = "对账成功";
	private static String NOTE_FAIL = "对账失败";
	
	@Override
	protected void checkParam(PrepayTradeParamDTO param) throws BizException {

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
		PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_opera());
		if (psndocDO == null) {
			throw new BizException("查询对账信息:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());

	}

	@Override
	protected PrepayTradeResultDTO process(PrepayTradeParamDTO param) throws BizException {
		// 查询预交金充值退充值数据
		IBlpaypatRService rService = ServiceFinder.find(IBlpaypatRService.class);
		String whereSql = "id_emp_pay = '" + Context.get().getStuffId() + "' and sd_pttp = '"
				+ param.getSd_pttp() + "' and sd_paytp in ('11','12')";

		if (!StringUtil.isEmpty(param.getDt_start())) {
			whereSql += " and dt_pay >= '" + param.getDt_start() + "'";
		}

		if (!StringUtil.isEmpty(param.getDt_end())) {
			whereSql += " and dt_pay <= '" + param.getDt_end() + "'";
		}

		int count = 0;
		FDouble amt = FDouble.ZERO_DBL;
		BlPrePayPatDO[] prepayDos = rService.find(whereSql, " dt_pay ", FBoolean.FALSE);

		// 新增对账明细
		FArrayList orders = new FArrayList();

		if (!ArrayUtil.isEmpty(prepayDos)) {
			count = prepayDos.length;
			for (BlPrePayPatDO prepayDO : prepayDos) {
				amt = amt.add(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setDt_pay(prepayDO.getDt_pay().toString());
				orderInfo.setCode_pm(prepayDO.getSd_pm());
				orderInfo.setPaymodenode(prepayDO.getPaymodenode());
				orderInfo.setBankno(prepayDO.getBankno());
				orderInfo.setCode_rep(prepayDO.getCode_rep());
				orderInfo.setAmt(BlAmtConverUtil.toXmlString(prepayDO.getAmt().multiply(prepayDO.getEu_direct())));
				orders.add(orderInfo);
			}
		}

//		// 查询门诊收付款数据
//		WsResultOrderInfo[] payInfo = this.findpayItmInfo(param);
//		if (!ArrayUtil.isEmpty(payInfo)) {
//			for (WsResultOrderInfo wsResultOrderInfo : payInfo) {
//				amt = amt.add(new FDouble(wsResultOrderInfo.getPayMoney()));
//				wsResultOrderInfo
//						.setPayMoney(BlAmtConverUtil.toXmlString(new FDouble(wsResultOrderInfo.getPayMoney())));
//				orders.add(wsResultOrderInfo);
//			}
//		}

		// 通过账单号或者流水凭证号查询该号是否存在
		BlPrePayPatDO blPrepayPatDO = this.isOrAndDocu(param);

		String isOrAndDocu = null;

		if (blPrepayPatDO == null) {
			isOrAndDocu = "1";
		} else {
			isOrAndDocu = "0";
		}

		//出参赋值
		PrepayTradeResultDTO rltInfo = new PrepayTradeResultDTO();
		rltInfo.setCode_opera(param.getCode_opera());
		rltInfo.setCount_trade(Integer.toString(count));
		rltInfo.setAmt_third(param.getAmt());
		rltInfo.setAmt_iih(BlAmtConverUtil.toXmlString(amt));
		// 0存在，1不存在
		rltInfo.setFg_exitno(isOrAndDocu);

		// 如果订单号存在，则获取该订单号所在DO的各个信息
		if ("0".equals(isOrAndDocu)) {
			rltInfo.setOr_dt_pay(blPrepayPatDO.getDt_pay().toString());
			rltInfo.setOr_code_pm(blPrepayPatDO.getSd_pm());
			rltInfo.setOr_paymodenode(blPrepayPatDO.getPaymodenode());
			rltInfo.setOr_bankno(blPrepayPatDO.getBankno());
			rltInfo.setOr_code_rep(blPrepayPatDO.getCode_rep());
			rltInfo.setOr_amt(
					BlAmtConverUtil.toXmlString(blPrepayPatDO.getAmt().multiply(blPrepayPatDO.getEu_direct())));
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

//	/**
//	 * 查询收付款信息
//	 * 
//	 * @throws BizException
//	 */
//	private WsResultOrderInfo[] findpayItmInfo(PrepayTradeParamDTO param) throws BizException {
//		StringBuilder sql = new StringBuilder();
//		sql.append(" select                                                                       ");
//		sql.append(" pay.dt_pay payTime,                                                          ");
//		sql.append(" payitm.sd_pm paymentMethod,                                                  ");
//		sql.append(" payitm.paymodenode orderNumber,                                              ");
//		sql.append(" payitm.bankno documentNumber,                                                ");
//		sql.append(" payitm.amt *payitm.eu_direct payMoney                                        ");
//		sql.append("  from bl_pay_pat_oep pay                                                     ");
//		sql.append(" inner join bl_pay_itm_pat_oep payitm on payitm.id_paypatoep=pay.id_paypatoep   ");
//		sql.append(" where pay.id_emp_pay=? ");
//		sql.append(" and pay.sd_pttp = ? ");
//		if (!StringUtil.isEmpty(param.getDt_start())) {
//			sql.append(" and dt_pay >= '" + param.getDt_start() + "'");
//		}
//
//		if (!StringUtil.isEmpty(param.getDt_end())) {
//			sql.append(" and dt_pay <= '" + param.getDt_end() + "'");
//		}
//
//		SqlParam sqlParam = new SqlParam();
//		sqlParam.addParam(Context.get().getStuffId());
//		sqlParam.addParam(param.getSd_pttp());
//		List<WsResultOrderInfo> list = (List<WsResultOrderInfo>) new DAFacade().execQuery(sql.toString(), sqlParam,
//				new BeanListHandler(WsResultOrderInfo.class));
//
//		return list.toArray(new WsResultOrderInfo[0]);
//	}

	/**
	 * 判断订单号和流水凭证号是否存在
	 * 
	 * @return
	 * @throws DAException
	 */
	private BlPrePayPatDO isOrAndDocu(PrepayTradeParamDTO param) throws BizException {

		if (StringUtil.isEmpty(param.getPaymodenode()) && StringUtil.isEmpty(param.getBankno())) {
			return null;
		}

		// 查询预交金表
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		sb.append(" dt_pay,sd_pm,code_rep,amt,eu_direct,id_paypat,paymodenode,bankno ");
		sb.append(" from ");
		sb.append(" bl_prepay_pat ");
		sb.append(" where 1=1 ");
		if (!StringUtil.isEmpty(param.getPaymodenode())) {
			sb.append("   and paymodenode = ?");
		}
		if (!StringUtil.isEmpty(param.getBankno())) {
			sb.append(" and bankno = ? ");
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
		List<BlPrePayPatDO> list = (List<BlPrePayPatDO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(BlPrePayPatDO.class));

		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

}
