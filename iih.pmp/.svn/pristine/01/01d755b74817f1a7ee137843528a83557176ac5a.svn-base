package iih.pmp.pay.s;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import iih.pmp.pay.bill.d.WXBillDTO;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.cmbc.bill.bp.CmbcBillCheckBP2;
import iih.pmp.pay.cmbc.s.bp.CmbcBarcodePayBP;
import iih.pmp.pay.cmbc.s.bp.CmbcCreateTradeBP;
import iih.pmp.pay.cmbc.s.bp.CmbcFileDownLoadBP;
import iih.pmp.pay.cmbc.s.bp.CmbcQuery4Biz;
import iih.pmp.pay.cmbc.s.bp.CmbcQueryBP;
import iih.pmp.pay.cmbc.s.bp.CmbcQueryBP2;
import iih.pmp.pay.cmbc.s.bp.CmbcRefundBP;
import iih.pmp.pay.cmbc.s.bp.CmbcRefundQueryBP;
import iih.pmp.pay.cmbc.s.bp.CmbcRefundTradeCreateBP;
import iih.pmp.pay.custom.bp.PmpBarcodePayBP;
import iih.pmp.pay.custom.bp.PmpCreateTradeBP;
import iih.pmp.pay.custom.bp.PmpPreQrCodePayBP;
import iih.pmp.pay.custom.bp.PmpQueryBP;
import iih.pmp.pay.custom.bp.PmpQueryBP2;
import iih.pmp.pay.custom.bp.PmpRefundBP;
import iih.pmp.pay.custom.bp.PmpRefundQueryBP;
import iih.pmp.pay.custom.bp.PmpRefundTradeCreateBP;
import iih.pmp.pay.i.IPmpPayService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.s.bp.AlipayBarcodePayBP;
import iih.pmp.pay.s.bp.AlipayCancelBP;
import iih.pmp.pay.s.bp.AlipayPayCreateBP;
import iih.pmp.pay.s.bp.AlipayQuery2BP;
import iih.pmp.pay.s.bp.AlipayQueryBP;
import iih.pmp.pay.s.bp.AlipayRefundBP;
import iih.pmp.pay.s.bp.AlipayRefundTradeCreateBP;
import iih.pmp.pay.s.bp.AlipayTradeCreateBP;
import iih.pmp.pay.s.bp.PmpRefund4TaskBP;
import iih.pmp.pay.s.bp.WXBarcodePayBP;
import iih.pmp.pay.s.bp.WXDownLoadBillBP;
import iih.pmp.pay.s.bp.WXQueryBP;
import iih.pmp.pay.s.bp.WXQueryBP2;
import iih.pmp.pay.s.bp.WXReFundBP;
import iih.pmp.pay.s.bp.WXRePayTradeCreateBP;
import iih.pmp.pay.s.bp.WXRefundQueryBP;
import iih.pmp.pay.s.bp.WXRefundTradeCreateBP;
import iih.pmp.pay.s.bp.WXScanpayBP;
import iih.pmp.pay.s.bp.WXTradeCreateBP;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.udi.PmpPayConst;

public class PmpPayServiceImpl implements IPmpPayService {
	

	@Override
	public OrdRstDTO barcodePay(OrdReqDTO dto) throws BizException {
		AlipayBarcodePayBP bp = new AlipayBarcodePayBP();
		return bp.exec(dto);
	}

	@Override
	public OrdRstDTO payCreate(OrdReqDTO dto) throws BizException {
		AlipayPayCreateBP bp = new AlipayPayCreateBP();
		return bp.exec(dto);
	}
	
	@Override
	public OrdRstDTO refund(OrdReqDTO dto) throws BizException {
		AlipayRefundBP bp = new AlipayRefundBP();
		return bp.exec(dto);
	}
	
	@Override
	public OrdRstDTO cancel(OrdReqDTO dto) throws BizException {
		AlipayCancelBP bp = new AlipayCancelBP();
		return bp.exec(dto);
	}
	
	@Override
	public OrdDO[] query(OrdReqDTO dto) throws BizException {
		AlipayQueryBP bp = new AlipayQueryBP();
		return bp.exec(dto);
	}

	@Override
	public OrdRstDTO WXBarcodePay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if(!PmpPayConst.BARCODEPAY_SCENE_CODE.equals(dto.getSd_scene())){
			dto.setSd_scene(PmpPayConst.BARCODEPAY_SCENE_CODE);
			dto.setId_scene(PmpPayConst.getUdiID(PmpPayConst.BARCODEPAY_SCENE_CODE,PmpPayConst.SCENE_DOCLIST_ID));
		}
		return new WXBarcodePayBP().domicroPayWithPos(dto);
	}

	@Override
	public OrdRstDTO WXScanPay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		if(!PmpPayConst.SCANPAY_SCENE_CODE.equals(dto.getSd_scene())){
			dto.setSd_scene(PmpPayConst.SCANPAY_SCENE_CODE);
			dto.setId_scene(PmpPayConst.getUdiID(PmpPayConst.SCANPAY_SCENE_CODE,PmpPayConst.SCENE_DOCLIST_ID));
		}
		return new WXScanpayBP().doScanPay(dto);		
	}


	@Override
	public OrdDO[] WXQuery(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new WXQueryBP().doBarcodeQuery(dto);
	}

	@Override
	public OrdRstDTO dowxrefund(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new WXReFundBP().doRefund(dto);
	}

	@Override
	public WXBillDTO[] downloadBill(FDate date, String option) {
		// TODO Auto-generated method stub
		return new WXDownLoadBillBP().wxdownloadBill(date, option);
	}

	@Override
	public OrdRstDTO WXTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new WXTradeCreateBP().exec(dto);
	}

	@Override
	public OrdRstDTO WXReFundTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new WXRefundTradeCreateBP().exec(dto);
	}

	@Override
	public TradeDO queryrefund(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new WXRefundQueryBP().queryrefund(dto);
	}
	
	@Override
	public OrdRstDTO AlipayTradeCreate(OrdReqDTO dto) throws BizException {
		AlipayTradeCreateBP bp = new AlipayTradeCreateBP();
		return bp.exec(dto);
	}

	@Override
	public OrdRstDTO AlipayRefundTradeCreate(OrdReqDTO dto) throws BizException {
		AlipayRefundTradeCreateBP bp = new AlipayRefundTradeCreateBP();
		return bp.exec(dto);
	}

	@Override
	public OrdRstDTO WXRePayTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		WXRePayTradeCreateBP bp=new WXRePayTradeCreateBP();
		return bp.exec(dto);
	}

	@Override
	public OrdQryRstDTO[] WXQuery2(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		WXQueryBP2 bp=new WXQueryBP2();
		return bp.doBarcodeQuery(dto);
	}

	@Override
	public OrdQryRstDTO[] query2(OrdReqDTO dto) throws BizException {
		AlipayQuery2BP bp = new AlipayQuery2BP();
		return bp.exec(dto);
	}

	@Override
	public OrdRstDTO cmbcbarcodePay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcBarcodePayBP bp=new CmbcBarcodePayBP();
		return bp.doBarcodePay(dto);
	}

	@Override
	public OrdRstDTO cmbcrefund(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcRefundBP bp=new CmbcRefundBP();
		return bp.doRefund(dto);
	}

	@Override
	public OrdQryRstDTO[] cmbcQuery2(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcQueryBP2 bp=new CmbcQueryBP2();
		return bp.doBarcodeQuery(dto);
	}

	@Override
	public OrdRstDTO cmbcTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcCreateTradeBP bp=new CmbcCreateTradeBP();
		return bp.exec(dto);
	}

	@Override
	public OrdRstDTO cmbcReFundTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcRefundTradeCreateBP bp=new CmbcRefundTradeCreateBP();
		return bp.exec(dto);
	}

	@Override
	public OrdDO[] cmbcQuery(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcQueryBP bp=new CmbcQueryBP();		
		return bp.doBarcodeQuery(dto);
	}

	@Override
	public WXBillDTO[] cmbcdownloadBill(FDate date, String option) throws BizException {
		// TODO Auto-generated method stub
//		DownLoadCmbcBillBP bp=new DownLoadCmbcBillBP();
//		 try {
//			bp.exec(date);
//		} catch (BizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 CmbcFileDownLoadBP bp=new CmbcFileDownLoadBP();
//		 CmbcBillCheckBP cbp=new CmbcBillCheckBP();
//		 try {
//			cbp.exec(date);
//		} catch (BizException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 return bp.exec(date);
		 
		 
	}

	@Override
	public void billcheck(BillCheckExceptionDO p) throws BizException {
		// TODO Auto-generated method stub
		 CmbcBillCheckBP2 cbp=new CmbcBillCheckBP2();
			cbp.exec(p);

	}

	@Override
	public OrdQryRstDTO[] cmbcqueryrefund(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcRefundQueryBP bp=new CmbcRefundQueryBP();
		return bp.queryrefund(dto);
	}

	@Override
	public OrdQryRstDTO[] cmbcQuery4Biz(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		CmbcQuery4Biz bp=new CmbcQuery4Biz();
		return bp.doBarcodeQuery(dto);
	}

	@Override
	public OrdRstDTO pmpbarcodePay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpBarcodePayBP bp=new PmpBarcodePayBP();
		return bp.doBarcodePay(dto);
	}

	@Override
	public OrdRstDTO pmprefund(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpRefundBP bp=new PmpRefundBP();
		return bp.doRefund(dto);
	}

	@Override
	public OrdQryRstDTO[] pmpQuery2(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpQueryBP2 bp=new PmpQueryBP2();
		return bp.doBarcodeQuery(dto);
	}

	@Override
	public OrdRstDTO pmpTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpCreateTradeBP bp=new PmpCreateTradeBP();
		return bp.exec(dto);
	}

	@Override
	public OrdRstDTO pmpReFundTradeCreate(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpRefundTradeCreateBP bp=new PmpRefundTradeCreateBP();
		return bp.exec(dto);
	}

	@Override
	public OrdDO[] pmpQuery(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpQueryBP bp=new PmpQueryBP();
		return bp.doBarcodeQuery(dto);
	}

	@Override
	public OrdQryRstDTO[] pmprefundquery(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpRefundQueryBP bp=new PmpRefundQueryBP();
		return bp.queryrefund(dto);
	}

	@Override
	public OrdRstDTO pmpqrcodePay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpPreQrCodePayBP bp=new PmpPreQrCodePayBP();
		return bp.doPrePay(dto);
	}
	@Override
	public OrdRstDTO refund4task(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		PmpRefund4TaskBP bp=new PmpRefund4TaskBP();
		 return bp.doRefund(dto);
	}
}
