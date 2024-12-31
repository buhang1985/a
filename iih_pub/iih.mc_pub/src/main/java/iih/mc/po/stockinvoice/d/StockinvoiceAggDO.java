package iih.mc.po.stockinvoice.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.po.stockinvoice.d.desc.StockinvoiceAggDODesc;



/**
 * 采购发票
 */
public class StockinvoiceAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McStockInvoiceDO getParentDO() {
		return ((McStockInvoiceDO) super.getParentDO());
	}

	public void setParentDO(McStockInvoiceDO headDO) {
		setParent(headDO);
	}

	public McStockInvItemDO[] getMcStockInvItemDO() {
		IBaseDO[] dos = getChildren(McStockInvItemDO.class);
		if(dos==null) return null;
		McStockInvItemDO[] result=new McStockInvItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockInvItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockInvItemDO(McStockInvItemDO[] dos) {
		setChildren(McStockInvItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockinvoiceAggDODesc desc = new StockinvoiceAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McStockInvoiceDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.po.stockinvoice.d.McStockInvItemDO")) {
             return new McStockInvItemDO();
         }
         return null;
     }
}