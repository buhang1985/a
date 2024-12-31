package iih.pmp.pay.s;

import iih.bl.st.dto.d.BlReconciliationDifferencerDTO;
import iih.bl.st.dto.d.BlReconciliationQryCondDTO;
import iih.pmp.pay.bill.d.WXBillDTO;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.billcheckrst.d.BillCheckRstDO;
import iih.pmp.pay.blpmp.d.PmpBlReconciliationDifferencerDTO;
import iih.pmp.pay.blpmp.d.PmpBlReconciliationQryCondDTO;
import iih.pmp.pay.custom.bill.bp.PmpBillCheckBP;
import iih.pmp.pay.custom.bill.bp.PmpBillCheckExternalBP;
import iih.pmp.pay.custom.bill.bp.PmpGenBillItemBP;
import iih.pmp.pay.custom.bp.PmpQueryBatchBP;
import iih.pmp.pay.custom.bp.TradeStatisticsBP;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.d.Reconcilldto;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.custom.bill.bp.PmpBillFeeQryBP;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.s.bp.CreateOrderBP;
import iih.pmp.pay.s.bp.PmpQueryStatuseBP;
import iih.pmp.pay.s.bp.RefundTaskQueryBp;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

/**
 * 扫码支付
 *
 */
public class PmpPayOperatorServiceImpl implements IPmpPayOperatorService {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	@Override
	public OrdRstDTO barcodePay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return pmputils.getPmpPayService().pmpbarcodePay(dto);
	}

	@Override
	public OrdRstDTO scanPayPrecreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return pmputils.getPmpPayService().pmpqrcodePay(dto);
	}

	/**
	 * 退款接口
	 * 
	 */
	@Override
	public OrdRstDTO refund(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return pmputils.getPmpPayService().pmprefund(dto);
	}

	@Override
	public OrdDO[] query(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return pmputils.getPmpPayService().pmpQuery(dto);
	}

	@Override
	public WXBillDTO[] downLoadBill(FDate date, String option, String sd_chl) throws BizException {
		// TODO Auto-generated method stub
		if (PmpPayConst.ALIPAY_CHANNEL_CODE.equals(sd_chl)) {
		} else if (PmpPayConst.WXPAY_CHANNEL_CODE.equals(sd_chl)) {
		} else if (PmpPayConst.CMBC_CHANNEL_CODE.equals(sd_chl)) {
			return pmputils.getPmpPayService().cmbcdownloadBill(date, option);
		} else {
			throw new BizException("渠道号不正确，请重新选择渠道号！");
		}

		return null;
	}

	@Override
	public OrdRstDTO tradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return pmputils.getPmpPayService().pmpTradeCreate(dto);
	}

	@Override
	public OrdRstDTO refundtradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return pmputils.getPmpPayService().pmpReFundTradeCreate(dto);
	}

	@Override
	public OrdRstDTO RePayTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		if (PmpPayConst.ALIPAY_CHANNEL_CODE.equals(dto.getSd_chl())) {
			return pmputils.getPmpPayService().AlipayTradeCreate(dto);

		} else if (PmpPayConst.WXPAY_CHANNEL_CODE.equals(dto.getSd_chl())) {
			return pmputils.getPmpPayService().WXRePayTradeCreate(dto);
		} else {
			throw new BizException("渠道号不正确，请重新选择渠道号！");
		}
	}

	/**
	 * 新增查询接口
	 */
	@Override
	public OrdQryRstDTO[] pmpquery(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return pmputils.getPmpPayService().pmpQuery2(dto);
	}

	@Override
	public OrdDO createOrder(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (dto == null)
			return null;
		return new CreateOrderBP().createOrd(dto);
	}

	/**
	 * 对账
	 */
	@Override
	public String billCheck(BillCheckExceptionDO p) throws BizException {
		// TODO Auto-generated method stub
		IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(p.getSd_chl());
		IPmpSdk pay = PmpPayAppUtils.getPmpSdk(p.getSd_chl());
		new PmpGenBillItemBP(pay, dataconvert).GenerateBillItem(p);
		return "Y";
	}

	@Override
	/**
	 * 退款查询
	 * 
	 */
	public OrdQryRstDTO[] refundquery(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return pmputils.getPmpPayService().pmprefundquery(dto);
	}

	/**
	 * 生成对账数据
	 */
	@Override
	public BillCheckRstDO[] getBillCheckRst(BillQryReqDTO[] dtos) throws BizException {
		// TODO Auto-generated method stub
		PmpBillFeeQryBP bp = new PmpBillFeeQryBP();
		return bp.exec(dtos[0]);
	}

	@Override
	public OrdQryRstDTO[] pmpquery4Biz(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if (PmpPayConst.CMBC_CHANNEL_CODE.equals(dto.getSd_chl())) {
			return pmputils.getPmpPayService().cmbcQuery4Biz(dto);
		} else {
			throw new BizException("渠道号不正确，请重新选择渠道号！");
		}
		// return null;
	}

	@Override
	public String getBillCheckRstExp(BillCheckExceptionDO p) throws BizException {
		// TODO Auto-generated method stub
		new PmpBillCheckBP().exec(p);
		return null;
	}

	/**
	 * 退款状况查询
	 * 
	 */
	public String refundqueryStatus(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new PmpQueryStatuseBP().exec(dto);
	}

	@Override
	public OrdQryRstDTO[] PMPQueryBatch(OrdReqDTO[] dtos) throws BizException {
		// TODO Auto-generated method stub
		return new PmpQueryBatchBP().queryrefund(dtos);
	}

	@Override
	public PmpBlReconciliationDifferencerDTO getTraSantis(PmpBlReconciliationQryCondDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new TradeStatisticsBP().exec(dto);
	}

	@Override
	public Reconcilldto[] PmpBillCheckExternal(String startTime, String endTime) throws BizException {
		// TODO Auto-generated method stub
		PmpBillCheckExternalBP Bp = new PmpBillCheckExternalBP();
		return Bp.exec(startTime, endTime);
	}

	@Override
	public String RefundTaskQry(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		RefundTaskQueryBp Bp = new RefundTaskQueryBp();
		return Bp.exec(dto);
	}

}
