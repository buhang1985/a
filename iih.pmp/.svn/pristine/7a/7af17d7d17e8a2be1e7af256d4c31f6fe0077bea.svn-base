package iih.pmp.pay.s.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.demo.trade.model.TradeStatus;
import com.alipay.demo.trade.model.builder.AlipayTradeQueryRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FQueryResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;
import com.alipay.demo.trade.utils.AlipayConfigInitUtil;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ord.i.IOrdCudService;
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
import iih.pmp.pay.utils.PmpAliPayLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class AlipayTradeCreateBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	public OrdRstDTO exec(OrdReqDTO dto) throws BizException {
		if (!AlipayConfigInitUtil.LoadConfig())
			throw new BizException("支付宝环境配置文件加载失败");

		AlipayTradeService service = new AlipayTradeServiceImpl.ClientBuilder().build();

		String tradeNo;
		OrdDO ord;
		TradeDO trade;

		dto.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		dto.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));

		OrdRstDTO rst = new OrdRstDTO();
		if (PmpPayConst.BARCODEPAY_SCENE_CODE.equals(dto.getSd_scene())) {

			// 确定外部传入订单支付请求是否处理过
			int reqstatus = verifyReqStatusBarcodepay(dto, service);

			if (reqstatus == PmpPayConst.REQ_STATUS_CODE_ORDPAID) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("支付拒绝： 此订单已被支付过");
			} else if (reqstatus == PmpPayConst.REQ_STATUS_CODE_ORDUNKNOWN) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("支付拒绝： 此订单支付状态未知");
			} else if (reqstatus == PmpPayConst.REQ_STATUS_CODE_ORDFAIL) {
				tradeNo = PmpPayAppUtils.getTradeCode();
				ord = findOrd(dto);
				// 覆盖原订单信息
				updateOrd(dto, ord);
				// 新增交易数据
				trade = insertTrade(dto, tradeNo, pmputils.getServerDateTime(), ord.getPkVal());
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("交易创建成功");
				rst.setTrade_no(tradeNo);
				rst.setTradetime(trade.getDt_req());
				rst.setSv(trade.getSv());
			} else {
				tradeNo = PmpPayAppUtils.getTradeCode();
				FDateTime dt = pmputils.getServerDateTime();
				// 新增订单数据
//				ord = insertOrd(dto, dt);
				// 找到已新建的订单数据
				ord = findOrd(dto);
				if (ord == null) {
					rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
					rst.setMsg("系统错误：订单数据未找到");
					return rst;
				}
				// 新增交易数据
				trade = insertTrade(dto, tradeNo, dt, ord.getPkVal());
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("交易创建成功");
				rst.setTrade_no(tradeNo);
				rst.setTradetime(trade.getDt_req());
				rst.setSv(trade.getSv());
			}
		} else if (PmpPayConst.SCANPAY_SCENE_CODE.equals(dto.getSd_scene())) {
			// 确定外部传入订单支付请求是否处理过
			int reqstatus = verifyReqStatusScanpay(dto);

			if (reqstatus == PmpPayConst.REQ_STATUS_CODE_ORDPAID) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("处理拒绝： 此订单已被支付过");
			} else if (reqstatus == PmpPayConst.REQ_STATUS_CODE_ORDWAIT) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setMsg("处理拒绝： 此订单正在等待支付");
			} else if (reqstatus == PmpPayConst.REQ_STATUS_CODE_ORDFAIL) {
				tradeNo = PmpPayAppUtils.getTradeCode();
				ord = findOrd(dto);
				// 覆盖原订单信息
				updateOrd(dto, ord);
				// 新增交易数据
				trade = insertTrade(dto, tradeNo, pmputils.getServerDateTime(), ord.getPkVal());
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("交易创建成功");
				rst.setTrade_no(tradeNo);
				rst.setTradetime(trade.getDt_req());
				rst.setSv(trade.getSv());
			} else {
				tradeNo = PmpPayAppUtils.getTradeCode();
				FDateTime dt = pmputils.getServerDateTime();
				// 新增订单数据
				ord = insertOrd(dto, dt);
				// 新增交易数据
				trade = insertTrade(dto, tradeNo, dt, ord.getPkVal());
				rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
				rst.setMsg("交易创建成功");
				rst.setTrade_no(tradeNo);
				rst.setTradetime(trade.getDt_req());
				rst.setSv(trade.getSv());
			}
		} else {
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setMsg("支付场景错误");
		}

		return rst;
	}

	@SuppressWarnings("unchecked")
	private int verifyReqStatusBarcodepay(OrdReqDTO dto, AlipayTradeService service) throws BizException {
		DAFacade daf = new DAFacade();
		// 获取与此订单相关的所有支付历史交易数据
		String sql = "select t.* from pmp_ord o inner join pmp_trade t on o.id_ord = t.id_ord where o.ord_no = ? and o.id_emp_op = ? and t.eu_direct = "
				+ PmpPayConst.TRADE_DIRECT_PAY + ";";
		SqlParam sp = new SqlParam();
		sp.addParam(dto.getOrd_no());
		sp.addParam(dto.getId_user_req());
		TradeDO[] rst = ((ArrayList<TradeDO>) daf.execQuery(sql, sp, new BeanListHandler(TradeDO.class)))
				.toArray(new TradeDO[0]);

		if (ArrayUtil.isEmpty(rst))
			return PmpPayConst.REQ_STATUS_CODE_ORDNEW;

		for (int i = 0; i < rst.length; i++) {
			// 如果历史纪录中有一笔支付成功，则判定此订单已支付
			if (rst[i].getTrade_status() == TradeStatusEnum.PAY_SUCCESS) {
				return PmpPayConst.REQ_STATUS_CODE_ORDPAID;
			}
			// 如果历史纪录中全部支付失败，则判定此订单支付失败
			else if (rst[i].getTrade_status() == TradeStatusEnum.PAY_FAIL) {
				if (i == rst.length - 1)
					return PmpPayConst.REQ_STATUS_CODE_ORDFAIL;
			}
			// 如果历史纪录中有一笔支付结果未知，则调用一次查询接口尝试确定支付结果，如果返回确定结果（成功或失败），则回写数据，并对订单状态进行相应判定
			else if (rst[i].getTrade_status() == TradeStatusEnum.TRADE_UNKNOWN) {
				AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder()
						.setOutTradeNo(rst[i].getTrade_no());

				AlipayF2FQueryResult result;
				try {
					result = service.queryTradeResult(builder);
				} catch (AlipayApiException e) {
					PmpAliPayLogUtils.logExAndTitle(e, "支付宝交易查询异常");
					String msg = String.format("支付宝交易查询异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
					throw new BizException(msg);
				}
				writeBackTradeWhenVerify(result, rst[i]);
				OrdDO o = findOrd(rst[i]);
				writeBackOrdWhenVerify(result, o);
				switch (result.getTradeStatus()) {
				case SUCCESS:
					return PmpPayConst.REQ_STATUS_CODE_ORDPAID;

				case FAILED:
					return PmpPayConst.REQ_STATUS_CODE_ORDFAIL;

				case UNKNOWN:
					return PmpPayConst.REQ_STATUS_CODE_ORDUNKNOWN;
				}

			}
		}

		return PmpPayConst.REQ_STATUS_CODE_ORDUNKNOWN;
	}

	@SuppressWarnings("unchecked")
	private int verifyReqStatusScanpay(OrdReqDTO dto) throws BizException {
		DAFacade daf = new DAFacade();
		// 获取与此订单相关的所有支付历史交易数据
		String sql = "select t.* from pmp_ord o inner join pmp_trade t on o.id_ord = t.id_ord where o.ord_no = ? and o.id_emp_op = ? and t.eu_direct = "
				+ PmpPayConst.TRADE_DIRECT_PAY + ";";
		SqlParam sp = new SqlParam();
		sp.addParam(dto.getOrd_no());
		sp.addParam(dto.getId_user_req());
		TradeDO[] rst = ((ArrayList<TradeDO>) daf.execQuery(sql, sp, new BeanListHandler(TradeDO.class)))
				.toArray(new TradeDO[0]);

		if (ArrayUtil.isEmpty(rst))
			return PmpPayConst.REQ_STATUS_CODE_ORDNEW;

		for (int i = 0; i < rst.length; i++) {
			// 如果历史纪录中有一笔支付成功，则判定此订单已支付
			if (rst[i].getTrade_status() == TradeStatusEnum.PAY_SUCCESS) {
				return PmpPayConst.REQ_STATUS_CODE_ORDPAID;
			}
			// 如果历史纪录中全部支付失败，则判定此订单支付失败
			else if (rst[i].getTrade_status() == TradeStatusEnum.PAY_FAIL) {
				if (i == rst.length - 1)
					return PmpPayConst.REQ_STATUS_CODE_ORDFAIL;
			}
			// 如果历史纪录中有一笔正在等待支付，则判定此订单正在等待支付
			else if (rst[i].getTrade_status() == TradeStatusEnum.PAY_WAIT) {
				return PmpPayConst.REQ_STATUS_CODE_ORDWAIT;
			}
		}

		return PmpPayConst.REQ_STATUS_CODE_ORDUNKNOWN;
	}

	private OrdDO insertOrd(OrdReqDTO dto, FDateTime dt) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		OrdDO ord = new OrdDO();
		ord.setOrd_no(dto.getOrd_no());
		ord.setOrd_status(OrdStatusEnum.UNKNOWN);
		ord.setDt_ord(dt);
		ord.setAmount(dto.getAmount());
		ord.setAmount_bk(dto.getAmount());
		ord.setId_chl(dto.getId_chl());
		ord.setSd_chl(dto.getSd_chl());
		ord.setId_scene(dto.getId_scene());
		ord.setSd_scene(dto.getSd_scene());
		ord.setSubject(dto.getSubject());
		ord.setBody(dto.getBody());
		ord.setId_org(pmputils.getEnvContext().getOrgId());
		ord.setId_grp(pmputils.getEnvContext().getGroupId());
		ord.setId_emp_op(dto.getId_user_req());
		ord.setCheck_rst(BillChekRst.UNCHECK);
		ord.setStatus(DOStatus.NEW);

		return service.save(new OrdDO[] { ord })[0];
	}

	private void updateOrd(OrdReqDTO dto, OrdDO o) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);

		o.setOrd_status(OrdStatusEnum.UNKNOWN);
		o.setSubject(dto.getSubject());
		o.setBody(dto.getBody());
		o.setAmount(dto.getAmount());
		o.setAmount_bk(dto.getAmount());
		o.setId_org(pmputils.getEnvContext().getOrgId());
		o.setId_grp(pmputils.getEnvContext().getGroupId());
		o.setId_emp_op(dto.getId_user_req());
		o.setId_chl(dto.getId_chl());
		o.setSd_chl(dto.getSd_chl());
		o.setId_scene(dto.getId_scene());
		o.setSd_scene(dto.getSd_scene());
		o.setStatus(DOStatus.UPDATED);

		service.save(new OrdDO[] { o });
	}

	private TradeDO insertTrade(OrdReqDTO dto, String tradeNo, FDateTime dt, String ordpk) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);

		TradeDO trade = new TradeDO();
		trade.setTrade_no(tradeNo);
		trade.setId_ord(ordpk);
		trade.setSubject(dto.getSubject());
		trade.setBody(dto.getBody());
		trade.setAmount(dto.getAmount());
		trade.setDt_req(dt);
		trade.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
		trade.setId_org(pmputils.getEnvContext().getOrgId());
		trade.setId_grp(pmputils.getEnvContext().getGroupId());
		trade.setId_emp_op(dto.getId_user_req());
		trade.setEu_direct(PmpPayConst.TRADE_DIRECT_PAY);
		trade.setFg_precreate(dto.getFg_precreate());
		trade.setSd_chl(dto.getSd_chl());
		trade.setId_chl(dto.getId_chl());
		trade.setOrd_no(dto.getOrd_no());
		trade.setSd_scene(dto.getSd_scene());
		trade.setId_scene(dto.getId_scene());
		trade.setCheck_rst(BillChekRst.UNCHECK);
		trade.setStatus(DOStatus.NEW);

		return service.save(new TradeDO[] { trade })[0];
	}

	private OrdDO findOrd(OrdReqDTO dto) throws BizException {
		IOrdRService service = ServiceFinder.find(IOrdRService.class);
		OrdDO[] rst = service.findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		if (ArrayUtil.isEmpty(rst))
			return null;
		else
			return rst[0];
	}

	private OrdDO findOrd(TradeDO t) throws BizException {
		IOrdRService service = ServiceFinder.find(IOrdRService.class);

		return service.findById(t.getId_ord());
	}

	private void writeBackTradeWhenVerify(AlipayF2FQueryResult rst, TradeDO t) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (rst.getTradeStatus() == TradeStatus.SUCCESS) {
			t.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
			t.setTrade_no_chl(rst.getResponse().getTradeNo());
			t.setDt_finish(new FDateTime(sdf.format(rst.getResponse().getSendPayDate())));
			t.setBuyer_user_id(rst.getResponse().getBuyerUserId());
			t.setBuyer_logon_id(rst.getResponse().getBuyerLogonId());
			t.setStatus(DOStatus.UPDATED);
		} else if (TradeStatus.FAILED == rst.getTradeStatus()) {
			t.setTrade_status(TradeStatusEnum.PAY_FAIL);
			t.setDt_finish(pmputils.getServerDateTime());
			t.setStatus(DOStatus.UPDATED);
		}

		service.save(new TradeDO[] { t });
	}

	private void writeBackOrdWhenVerify(AlipayF2FQueryResult rst, OrdDO o) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (TradeStatus.SUCCESS == rst.getTradeStatus()) {
			o.setOrd_status(OrdStatusEnum.PAID);
			o.setDt_pay(new FDateTime(sdf.format(rst.getResponse().getSendPayDate())));
			o.setStatus(DOStatus.UPDATED);
		} else if (TradeStatus.FAILED == rst.getTradeStatus()) {
			o.setOrd_status(OrdStatusEnum.FAIL);
			o.setStatus(DOStatus.UPDATED);
		}

		service.save(new OrdDO[] { o });
	}
}
