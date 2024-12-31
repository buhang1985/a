package iih.mm.st.stockinvoice.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.st.stockinvoice.d.desc.StockinvoiceAggDODesc;



/**
 * 采购发票
 */
public class StockinvoiceAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public StockInvoiceDO getParentDO() {
		return ((StockInvoiceDO) super.getParentDO());
	}

	public void setParentDO(StockInvoiceDO headDO) {
		setParent(headDO);
	}

	public StockInvItemDO[] getStockInvItemDO() {
		IBaseDO[] dos = getChildren(StockInvItemDO.class);
		if(dos==null) return null;
		StockInvItemDO[] result=new StockInvItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(StockInvItemDO)dos[i];
		}
		return result;
	}
	
	public void setStockInvItemDO(StockInvItemDO[] dos) {
		setChildren(StockInvItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockinvoiceAggDODesc desc = new StockinvoiceAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new StockInvoiceDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.st.stockinvoice.d.StockInvItemDO")) {
             return new StockInvItemDO();
         }
         return null;
     }
}