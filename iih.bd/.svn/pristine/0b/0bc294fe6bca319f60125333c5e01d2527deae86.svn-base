package iih.bd.mm.supplier.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolMDORService;
import iih.mm.pl.stockplan.d.StockPlanItmDO;
import iih.mm.pl.stockplan.i.IStockPlanItmDORService;
import iih.mm.po.purchase.d.PurchaseOrderDO;
import iih.mm.po.purchase.i.IPurchaseMDORService;
import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.i.IStockinMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class IsSupplierRefedBp {
	
    public void isRefAsSupplier(SupplierDO supplierDO) throws BizException {
		
		IStockinMDORService stockInRSrv = ServiceFinder.find(IStockinMDORService.class);
		IPurchaseMDORService purchaseRSrv = ServiceFinder.find(IPurchaseMDORService.class);
		IStockPlanItmDORService planItemRSrv = ServiceFinder.find(IStockPlanItmDORService.class);
		ISupplierprotocolMDORService supproRSrv = ServiceFinder.find(ISupplierprotocolMDORService.class);
		
		//供应商协议是否引用
		String whrStr = String.format("id_sup = '%s'", supplierDO.getId_sup());
		SuppierProtocolDO[] supproDOS = supproRSrv.find(whrStr, "", FBoolean.TRUE);
		if(supproDOS != null && supproDOS.length > 0) {
			
			throw new BizException(String.format("【%s】已作为供应商被供应商物品协议使用，不能修改供应商标志。", supplierDO.getName()));
		}
		
		//采购计划是否引用
		StockPlanItmDO[] planItemDOS = planItemRSrv.find(whrStr, "", FBoolean.TRUE);
		if(planItemDOS != null && planItemDOS.length > 0) {
			
			throw new BizException(String.format("【%s】已作为供应商被采购计划单使用，不能修改供应商标志。", supplierDO.getName()));
		}
		
		//采购单是否引用
		PurchaseOrderDO[] purOrderDOS = purchaseRSrv.find(whrStr, "", FBoolean.TRUE);
		if(purOrderDOS != null && purOrderDOS.length > 0) {
			
			throw new BizException(String.format("【%s】已作为供应商被采购单使用，不能修改供应商标志。", supplierDO.getName()));
		}
		
		//入库单是否引用
		StockInDO[] stockInDOS = stockInRSrv.find(whrStr, "", FBoolean.TRUE);
		if(stockInDOS != null && stockInDOS.length > 0) {
			
			throw new BizException(String.format("【%s】已作为供应商被入库单使用，不能修改供应商标志。", supplierDO.getName()));
		}
	}
	
    public void isRefAsFactory(SupplierDO supplierDO) throws BizException {
		
		IMeterialMDORService mmRSrv = ServiceFinder.find(IMeterialMDORService.class);
		
		//物品基本信息是否引用
		String whrStr = String.format("id_sup = '%s'", supplierDO.getId_sup());
		MeterialDO[] mmDOS = mmRSrv.find(whrStr, "", FBoolean.TRUE);
		if(mmDOS != null && mmDOS.length > 0) {
			
			throw new BizException(String.format("【%s】已作为生产厂商被物品基本信息使用，不能修改生产厂商标志。", supplierDO.getName()));
		}
	}
}
