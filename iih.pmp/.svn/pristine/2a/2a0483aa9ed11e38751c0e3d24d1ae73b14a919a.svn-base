package iih.pmp.pay.s.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.alipay.api.AlipayApiException;
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
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.utils.PmpAliPayLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class AlipayQueryBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	/**
	 * 支付宝订单查询
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdDO[] exec(OrdReqDTO dto) throws BizException {

		if (!AlipayConfigInitUtil.LoadConfig())
			throw new BizException("支付宝环境配置文件加载失败");

		AlipayTradeService service = new AlipayTradeServiceImpl.ClientBuilder().build();

		OrdDO o = findOrd(dto);

		// 如果数据库内查不出订单则返回空
		if (o == null)
			return null;

		// 如果订单状态为未知则调用查询接口尝试确定结果，如果返回确定结果（成功或失败），则回写数据
		if (o.getOrd_status() == OrdStatusEnum.UNKNOWN) {
			AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder();
			TradeDO t = findUnconfirmPayTrade(o);
			builder.setOutTradeNo(t.getTrade_no());
			AlipayF2FQueryResult result;
			try {
				result = service.queryTradeResult(builder);
			} catch (AlipayApiException e) {
				PmpAliPayLogUtils.logExAndTitle(e, "支付宝查询异常");
				String msg = String.format("支付宝查询异常,异常信息:%s", ExceptionUtils.getFullStackTrace(e));
				throw new BizException(msg);
			}
			writeBackTradeAfterQuery(result, t);
			writeBackOrdAfterQuery(result, o);
		}
		// 其他状态则直接返回数据
		return new OrdDO[] { o };
	}

	@SuppressWarnings("unchecked")
	private OrdDO findOrd(OrdReqDTO dto) throws BizException {

		OrdDO[] rst;
		if (dto.getTrade_no() == null) {
			IOrdRService service = ServiceFinder.find(IOrdRService.class);
			rst = service.findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());
		} else {
			DAFacade daf = new DAFacade();
			String sql = "select o.* from pmp_ord o inner join pmp_trade t on o.id_ord = t.id_ord where t.trade_no = ?;";
			SqlParam sp = new SqlParam();
			sp.addParam(dto.getTrade_no());
			rst = ((ArrayList<OrdDO[]>) daf.execQuery(sql, sp, new BeanListHandler(OrdDO.class))).toArray(new OrdDO[0]);
		}

		return ArrayUtil.isEmpty(rst) ? null : rst[0];
	}

	private TradeDO findUnconfirmPayTrade(OrdDO o) throws BizException {

		ITradeRService service = ServiceFinder.find(ITradeRService.class);
		// 根据订单获取未知状态支付交易记录，此记录每个订单只有一条
		String whereSql = TradeDO.ID_ORD + " = '" + o.getPkVal() + "' and " + TradeDO.EU_DIRECT + " = "
				+ PmpPayConst.TRADE_DIRECT_PAY + " and " + TradeDO.TRADE_STATUS + " = " + TradeStatusEnum.TRADE_UNKNOWN;
		TradeDO[] rst = service.find(whereSql, "", FBoolean.FALSE);
		return ArrayUtil.isEmpty(rst) ? null : rst[0];
	}

	private void writeBackTradeAfterQuery(AlipayF2FQueryResult rst, TradeDO trade) throws BizException {
		ITradeCudService service = ServiceFinder.find(ITradeCudService.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (trade != null) {
			switch (rst.getTradeStatus()) {
			case SUCCESS:
				trade.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
				trade.setTrade_no_chl(rst.getResponse().getTradeNo());
				trade.setDt_finish(new FDateTime(sdf.format(rst.getResponse().getSendPayDate())));
				trade.setBuyer_user_id(rst.getResponse().getBuyerUserId());
				trade.setBuyer_logon_id(rst.getResponse().getBuyerLogonId());
				trade.setStatus(DOStatus.UPDATED);
				break;

			case FAILED:
				trade.setTrade_status(TradeStatusEnum.PAY_FAIL);
				trade.setDt_finish(pmputils.getServerDateTime());
				trade.setStatus(DOStatus.UPDATED);
				break;

			case UNKNOWN:
				trade.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
				trade.setStatus(DOStatus.UPDATED);
				break;
			}

			service.save(new TradeDO[] { trade });
		}
	}

	private void writeBackOrdAfterQuery(AlipayF2FQueryResult rst, OrdDO o) throws BizException {
		IOrdCudService service = ServiceFinder.find(IOrdCudService.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (o != null) {
			switch (rst.getTradeStatus()) {
			case SUCCESS:
				o.setOrd_status(OrdStatusEnum.PAID);
				o.setDt_pay(new FDateTime(sdf.format(rst.getResponse().getSendPayDate())));
				o.setStatus(DOStatus.UPDATED);
				break;

			case FAILED:
				o.setOrd_status(OrdStatusEnum.FAIL);
				o.setStatus(DOStatus.UPDATED);
				break;

			case UNKNOWN:
				o.setOrd_status(OrdStatusEnum.UNKNOWN);
				o.setStatus(DOStatus.UPDATED);
				break;
			}

			service.save(new OrdDO[] { o });
		}
	}

}
