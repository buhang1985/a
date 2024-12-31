package iih.pmp.yxpaySDK.bp;

import java.util.Random;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ord.d.desc.OrdDODesc;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.d.desc.TradeDODesc;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class YxWritePublicPayDataBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	/**
	 * 回写已支付订单数据
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdDO CreateOrd(OrdReqDTO dto) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}
		
		OrdDO ord = new OrdDO();
		String code = getOrderCode();
		if (code == null)
			return null;
		ord.setCode(code);
		ord.setBody(dto.getBody());
		ord.setSubject(dto.getSubject());
		ord.setAmount(dto.getAmount());
		ord.setAmount_bk(dto.getAmount());
		ord.setOrd_no(dto.getOrd_no());
		ord.setDt_ord(pmputils.getServerDateTime());
		ord.setOrd_status(OrdStatusEnum.PAID);
		ord.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));
		ord.setSd_chl(dto.getSd_chl());
		ord.setSd_scene(dto.getSd_scene());
		ord.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		ord.setSpbill_create_ip(dto.getSpbill_create_ip());
		ord.setId_emp_op(dto.getId_user_req());
//		ord.setId_emp_op(pmputils.getId_Stuff(null));// ????自助机或his是否也能获取
		ord.setId_org(pmputils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		ord.setId_grp(pmputils.getEnvContext().getGroupId());
		ord.setStatus(DOStatus.NEW);
		ord.setId_pat(dto.getId_pat());
		ord.setCheck_rst(BillChekRst.UNCHECK);
		ord.setDeviceinfo(dto.getDeviceinfo());
		ord.setTradetype(dto.getTradetype());
		ord.setSd_bizscene(dto.getBiz_scene());
		ord.setId_bizscene(PmpPayConst.getUdiID(dto.getBiz_scene(), PmpPayConst.BIZ_SCENE_DOCLIST_ID));
		ord.setId_pri_pm(dto.getId_pri_pm());
		OrdDO[] ordarr = pmputils.getOrdCudService().save(new OrdDO[] { ord });
		if (ordarr != null && ordarr.length > 0)
			return ordarr[0];
		return null;
	}

	public TradeDO createPayTrade(OrdReqDTO dto, OrdDO ord, OrdQryRstDTO rst) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		TradeDO tra = new TradeDO();
		tra.setAmount(dto.getAmount());
		String code = getTradeCode();
		if (code == null)
			return null;
		tra.setTrade_no(code);
		tra.setSd_ord(ord.getCode());
		tra.setId_emp_op(dto.getId_user_req());
//		tra.setId_emp_op(pmputils.getId_Stuff(null));// ????自助机或his是否也能获取
		tra.setId_org(pmputils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		tra.setId_grp(pmputils.getEnvContext().getGroupId());
		tra.setBody(dto.getBody());
		tra.setDt_req(pmputils.getServerDateTime());
		tra.setId_ord(ord.getId_ord());
		tra.setEu_direct(PmpPayConst.TRADE_DIRECT_PAY);
		tra.setSubject(dto.getSubject());
		tra.setTrade_status(TradeStatusEnum.PAY_SUCCESS);
		tra.setFg_precreate(dto.getFg_precreate());
		tra.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(dto.getSd_chl());
		tra.setOrd_no(dto.getOrd_no());
		tra.setSd_scene(dto.getSd_scene());
		tra.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setDeviceinfo(dto.getDeviceinfo());
		tra.setTradetype(dto.getTradetype());
		tra.setBankorderno(rst.getBankorderno());
		tra.setBanktradeno(rst.getBanktradeno());
		tra.setTrade_no_chl(rst.getTrade_no_chl());
		tra.setStatus(DOStatus.NEW);
//		TradeDO[] tras=pmputils.getTradeRService().find(" Trade_no='"+code+"'", "", FBoolean.FALSE);
//		if(tras!=null&&tras.length>0)return null;
		TradeDO[] trs = pmputils.getTradeCUDService().save(new TradeDO[] { tra });
		if (trs != null && trs.length > 0)
			return trs[0];
		return null;
	}

	public TradeDO createRefundTrade(OrdReqDTO dto, OrdDO ord, TradeDO reltrade, OrdQryRstDTO rst) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		TradeDO tra = new TradeDO();
		String code = getTradeCode();
		if (code == null)
			return null;
		tra.setTrade_no(code);
		tra.setSd_ord(ord.getCode());
		tra.setAmount(dto.getAmount());
		tra.setRefund_req_no(dto.getRefund_req_no());

		tra.setId_emp_op(dto.getId_user_req());
		tra.setId_refund_user(dto.getId_user_req());
//		tra.setId_emp_op(pmputils.getId_Stuff(dto.getId_user_req()));
//		tra.setId_refund_user(pmputils.getId_Stuff(null));// ????自助机或his是否也能获取
		tra.setId_org(pmputils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		tra.setId_grp(pmputils.getEnvContext().getGroupId());
		tra.setDt_req(pmputils.getServerDateTime());
		tra.setId_ord(ord.getId_ord());
		tra.setEu_direct(PmpPayConst.TRADE_DIRECT_REFUND);
		tra.setTrade_status(TradeStatusEnum.REFUND_SUCCESS);
		tra.setTrade_no_rel(reltrade.getTrade_no());
		tra.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(dto.getSd_chl());
		tra.setOrd_no(dto.getOrd_no());
		tra.setId_scene(PmpPayConst.getUdiID(reltrade.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setSd_scene(reltrade.getSd_scene());
		tra.setBody(reltrade.getBody());
		tra.setSubject(reltrade.getSubject());
		tra.setDeviceinfo(dto.getDeviceinfo());
		tra.setTradetype(reltrade.getTradetype());
		tra.setBankorderno(rst.getBankorderno());
		tra.setBanktradeno(rst.getBanktradeno());
		tra.setTrade_no_chl(rst.getTrade_no_chl());
		tra.setStatus(DOStatus.NEW);

		TradeDO[] trs = pmputils.getTradeCUDService().save(new TradeDO[] { tra });
		if (trs != null && trs.length > 0)
			return trs[0];
		return null;
	}

	/**
	 * 获取交易号(流水号+时间戳)
	 * 
	 * @return
	 * @throws BizException
	 */
	public String getTradeCode() throws BizException {
		String code = ServiceFinder.find(IBillcodeManage.class).getPreBillCode_RequiresNew(TradeDODesc.CLASS_FULLNAME);
		FDateTime dt = pmputils.getServerDateTime();
		String transdate = pmputils.getTransDate(dt, "yyyyMMddHHmmss");
		String random = getRandomInt() + "";
		return transdate + "" + random + code;
	}

	public String getOrderCode() throws BizException {
		String code = ServiceFinder.find(IBillcodeManage.class).getPreBillCode_RequiresNew(OrdDODesc.CLASS_FULLNAME);
		FDateTime dt = pmputils.getServerDateTime();
		String transdate = pmputils.getTransDate(dt, "yyyyMMddHHmmss");
		String random = getRandomInt() + "";
		return transdate + "" + random + code;
	}

	private int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10);
	}

}
