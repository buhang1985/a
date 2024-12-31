package iih.pmp.pay.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class AlipayRefundTradeCreateBP {

	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	public OrdRstDTO exec(OrdReqDTO dto) throws BizException {

		String tradeNo;
		TradeDO trade, trade_rel;

		dto.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		dto.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));

		OrdDO o = findOrd(dto);

		// 校验退款目标订单是否符合退款条件
		OrdRstDTO rst = new OrdRstDTO();
		if (o == null) {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("退款拒绝： 原订单不存在");
			return rst;
		} else if (o.getOrd_status() != OrdStatusEnum.PAID) {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("退款拒绝： 原订单状态错误");
			return rst;
		}

		// 校验退款金额是否超过目标订单金额
		if (verifyAmount(dto)) {

			// 校验退款请求本身是否处理过
			int reqstatus = verifyReqStatus(dto);

			if (reqstatus == PmpPayConst.REQ_STATUS_CODE_REFUNDDONE) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("退款拒绝： 此次退款已成功，请使用新的退款单号重试");
			} else if (reqstatus == PmpPayConst.REQ_STATUS_CODE_REFUNDUNKNOWN) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("退款拒绝： 此次退款目前状态未知");
			} else if (reqstatus == PmpPayConst.REQ_STATUS_CODE_REFUNDFAIL) {
				trade_rel = findPayTrade(dto);
				TradeDO trade_old = findOldTrades(dto)[0];
				tradeNo = trade_old.getTrade_no();
				trade = insertTrade(dto, tradeNo, trade_rel);
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("退款交易创建成功");
				rst.setTrade_no(trade.getTrade_no());
				rst.setTradetime(trade.getDt_req());
				rst.setSv(trade.getSv());
			} else {
				tradeNo = PmpPayAppUtils.getTradeCode();
				trade_rel = findPayTrade(dto);
				trade = insertTrade(dto, tradeNo, trade_rel);
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("退款交易创建成功");
				rst.setTrade_no(trade.getTrade_no());
				rst.setTradetime(trade.getDt_req());
				rst.setSv(trade.getSv());
			}
		} else {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("退款拒绝： 退款请求金额大于订单可退金额");
		}

		return rst;
	}

	private OrdDO findOrd(OrdReqDTO dto) throws BizException {
		IOrdRService service = ServiceFinder.find(IOrdRService.class);

		OrdDO[] rst = service.findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		if (ArrayUtil.isEmpty(rst))
			return null;
		else
			return rst[0];
	}

	private boolean verifyAmount(OrdReqDTO dto) throws BizException {
		OrdDO o = findOrd(dto);
		return dto.getAmount().getDouble() <= o.getAmount_bk().getDouble();
	}

	private int verifyReqStatus(OrdReqDTO dto) throws BizException {
		TradeDO[] rst = findOldTrades(dto);

		if (ArrayUtil.isEmpty(rst))
			return PmpPayConst.REQ_STATUS_CODE_REFUNDNEW;

		for (int i = 0; i < rst.length; i++) {
			if (rst[i].getTrade_status() == TradeStatusEnum.REFUND_SUCCESS) {
				return PmpPayConst.REQ_STATUS_CODE_REFUNDDONE;
			} else if (rst[i].getTrade_status() == TradeStatusEnum.REFUND_FAIL) {
				if (i == rst.length - 1)
					return PmpPayConst.REQ_STATUS_CODE_REFUNDFAIL;
			} else if (rst[i].getTrade_status() == TradeStatusEnum.TRADE_UNKNOWN) {
				return PmpPayConst.REQ_STATUS_CODE_REFUNDUNKNOWN;
			}
		}

		return PmpPayConst.REQ_STATUS_CODE_REFUNDUNKNOWN;
	}

	@SuppressWarnings("unchecked")
	private TradeDO[] findOldTrades(OrdReqDTO dto) throws BizException {
		DAFacade daf = new DAFacade();
		// 按订单号和退款申请号获取历史退款交易记录，同一订单号退款号的交易记录可以有多条，因为退款允许失败后重复尝试
		String sql = "select t.* from pmp_ord o inner join pmp_trade t on o.id_ord = t.id_ord where o.ord_no = ? and o.id_emp_op = ? and t.refund_req_no = ? and t.eu_direct = "
				+ PmpPayConst.TRADE_DIRECT_REFUND + ";";
		SqlParam sp = new SqlParam();
		sp.addParam(dto.getOrd_no());
		sp.addParam(dto.getId_user_req());
		sp.addParam(dto.getRefund_req_no());
		TradeDO[] rst = ((ArrayList<TradeDO>) daf.execQuery(sql, sp, new BeanListHandler(TradeDO.class)))
				.toArray(new TradeDO[0]);
		return rst;
	}

	@SuppressWarnings("unchecked")
	private TradeDO findPayTrade(OrdReqDTO dto) throws BizException {
		DAFacade daf = new DAFacade();
		// 获取退款目标订单的成功支付交易记录，此记录每个订单只会有一条
		String sql = "select t.* from pmp_ord o inner join pmp_trade t on o.id_ord = t.id_ord where o.ord_no = ? and o.id_emp_op = ? and t.eu_direct = "
				+ PmpPayConst.TRADE_DIRECT_PAY + " and t.trade_status = " + TradeStatusEnum.PAY_SUCCESS + ";";
		SqlParam sp = new SqlParam();
		sp.addParam(dto.getOrd_no());
		sp.addParam(dto.getId_user_req());
		TradeDO[] rst = ((ArrayList<TradeDO>) daf.execQuery(sql, sp, new BeanListHandler(TradeDO.class)))
				.toArray(new TradeDO[0]);
		return rst[0];
	}

	private TradeDO insertTrade(OrdReqDTO dto, String tradeNo, TradeDO t_rel) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);

		TradeDO trade = new TradeDO();
		trade.setTrade_no(tradeNo);
		trade.setTrade_no_rel(t_rel.getTrade_no());
		trade.setRefund_req_no(dto.getRefund_req_no());
		trade.setId_ord(t_rel.getId_ord());
		trade.setSubject(dto.getSubject());
		trade.setBody(dto.getBody());
		trade.setAmount(dto.getAmount());
		trade.setDt_req(pmputils.getServerDateTime());
		trade.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
		trade.setId_org(pmputils.getEnvContext().getOrgId());
		trade.setId_grp(pmputils.getEnvContext().getGroupId());
		trade.setId_emp_op(dto.getId_user_req());
		trade.setId_refund_user(dto.getId_user_req());
		trade.setEu_direct(PmpPayConst.TRADE_DIRECT_REFUND);
		trade.setSd_chl(dto.getSd_chl());
		trade.setId_chl(dto.getId_chl());
		trade.setOrd_no(dto.getOrd_no());
		trade.setSd_scene(dto.getSd_chl());
		trade.setId_scene(dto.getId_scene());
		trade.setCheck_rst(BillChekRst.UNCHECK);
		trade.setStatus(DOStatus.NEW);

		return service.save(new TradeDO[] { trade })[0];
	}
}
