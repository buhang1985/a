package iih.mc.st.stockcheck.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.st.stockcheck.d.desc.StockcheckAggDODesc;



/**
 * 库存盘点
 */
public class StockcheckAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McStockCheckDO getParentDO() {
		return ((McStockCheckDO) super.getParentDO());
	}

	public void setParentDO(McStockCheckDO headDO) {
		setParent(headDO);
	}

	public McStockCheckItmDO[] getMcStockCheckItmDO() {
		IBaseDO[] dos = getChildren(McStockCheckItmDO.class);
		if(dos==null) return null;
		McStockCheckItmDO[] result=new McStockCheckItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockCheckItmDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockCheckItmDO(McStockCheckItmDO[] dos) {
		setChildren(McStockCheckItmDO.class, dos);
	}
	public McStockCaspItemDO[] getMcStockCaspItemDO() {
		IBaseDO[] dos = getChildren(McStockCaspItemDO.class);
		if(dos==null) return null;
		McStockCaspItemDO[] result=new McStockCaspItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockCaspItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockCaspItemDO(McStockCaspItemDO[] dos) {
		setChildren(McStockCaspItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockcheckAggDODesc desc = new StockcheckAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McStockCheckDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.st.stockcheck.d.McStockCheckItmDO")) {
             return new McStockCheckItmDO();
         }
	    else if (clzName.equals("iih.mc.st.stockcheck.d.McStockCaspItemDO")) {
             return new McStockCaspItemDO();
         }
         return null;
     }
}