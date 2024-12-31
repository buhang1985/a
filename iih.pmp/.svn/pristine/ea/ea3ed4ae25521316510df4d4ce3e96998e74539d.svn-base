package iih.pmp.pay.custom.bp;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.s.bp.CreateOrderBP;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import xap.mw.core.data.BizException;

public class PmpCreateTradeBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	public OrdRstDTO exec(OrdReqDTO dto) throws BizException {
		
        OrdRstDTO rnt1=validateReq( dto);
        if(rnt1.getBiz_status().equals(BizStatusEnum.BIZ_FAIL)) {
        	return rnt1;
        }
		PmpPayUtils utils = new PmpPayUtils();
		OrdRstDTO rnt = null;
		IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
		IPmpSdk pay=PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
		PmpValidateBP validatebp = new PmpValidateBP(pay,dataconvert);
		OrdQryRstDTO rst = new OrdQryRstDTO();
		rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		Map<String, Object> resultmap = validatebp.isOrdcanPay(dto, rst);
		boolean flag = (boolean) resultmap.get(PmpPayBaseCost.PMP_FLAG);
		if (flag) {
			// todo
			// 如果订单不存在,则创建订单
			OrdDO ord = null;
			if (resultmap.containsKey(PmpPayBaseCost.PMP_ORD)) {
				ord = (OrdDO) resultmap.get(PmpPayBaseCost.PMP_ORD);
			} else {
				ord = new CreateOrderBP().createOrd(dto);
			}
			TradeDO tra = null;
			if (ord != null) {
				tra = utils.createPayTradeDo(ord,  dto);
			}

			if (tra == null) {
				rnt = getFailRst(dto, rst);
				rnt.setMsg("交易创建失败");
				rnt.setTrade_status(TradeStatusEnum.PAY_FAIL);
				return rnt;
			}
			

			if (rnt == null)
				rnt = new OrdRstDTO();
			rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
			rnt.setTrade_no(tra.getTrade_no());
			rnt.setTradetime(tra.getDt_req());
			rnt.setSv(tra.getSv());
		} else {
//			String err = rst.getErr_code_des();
			// throw new BizException(err);
			if (rnt == null)
				rnt = getFailRst(dto, rst);
//			rnt.setMsg(err);
		}
		return rnt;
	}

	private OrdRstDTO getFailRst(OrdReqDTO dto, OrdQryRstDTO rst) {

		OrdRstDTO rnt = new OrdRstDTO();
		rnt.setTrade_no(rst.getTrade_no());
		rnt.setTradetime(rst.getTradetime());
		rnt.setAmount(rst.getAmount());
		rnt.setSv(dto.getSv());
		rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
		rnt.setAmount_bk(rst.getAmount_bk());

		rnt.setBankorderno(rst.getBankorderno());
		rnt.setTrade_no_chl(rst.getTrade_no_chl());
		rnt.setBanktradeno(rst.getBanktradeno());
		rnt.setMch_order_no(rst.getMch_order_no());
		rnt.setTradetype(rst.getTradetype());
		rnt.setTrade_status(rst.getTrade_status());        
		rnt.setOrd_no(dto.getOrd_no());
		rnt.setMsg(rst.getErr_code_des());
		
		rnt.setResult_code(null);
		//如果查询失败,设置result_code query_fail
		if(rst.getBiz_status()!=BizStatusEnum.BIZ_SUCCESS) {
			rnt.setResult_code("查询失败");
		}
		if(rst.getAmount_bk()!=null&&rst.getAmount()!=null&&rst.getAmount_bk().getDouble()<rst.getAmount().getDouble()&&rst.getOrd_status().equals(OrdStatusEnum.PAID)) {
			rnt.setResult_code("订单转入退款！");
			rnt.setMsg("订单转入退款！");
		}
		return rnt;
	}
	private OrdRstDTO validateReq(OrdReqDTO dto) {
		OrdRstDTO rst=new OrdRstDTO();
		rst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		if (dto == null || pmputils.isStrEmpty(dto.getOrd_no()))
		{
			rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rst.setTrade_status(TradeStatusEnum.PAY_FAIL);
			rst.setMsg("传入的外部订单号为空");
			return rst;
		}
        if(pmputils.isStrEmpty(dto.getTradetype()))
        	dto.setTradetype(null);
        if(dto.getTradetype()==null) {
			String tradetype=pmputils.getCmbcSence8Authorcode(dto.getAuth_code());
			if(tradetype==null) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setTrade_status(TradeStatusEnum.PAY_FAIL);
				rst.setMsg("没有交易类型，请选择交易类型");
				return rst;
			}
		}else if(dto.getTradetype().equals(CmbcSceneEnum.WXSCAN)||dto.getTradetype().equals(CmbcSceneEnum.ZFBSCAN)) {
			String tradetype=pmputils.getCmbcSence8Authorcode(dto.getAuth_code());	
			if(tradetype==null||!tradetype.equals(dto.getTradetype())) {
				rst.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rst.setTrade_status(TradeStatusEnum.PAY_FAIL);
				rst.setMsg(pmputils.getTradeTypeErrMsg(dto.getTradetype()));
				return rst;
			}
		}
		
		return rst;
	}

}
