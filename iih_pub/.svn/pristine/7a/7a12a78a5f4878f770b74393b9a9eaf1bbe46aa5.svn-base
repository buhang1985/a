package iih.mc.st.stockin.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.st.stockin.d.desc.StockinAggDODesc;



/**
 * 耗材入库单
 */
public class StockinAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McStockInDO getParentDO() {
		return ((McStockInDO) super.getParentDO());
	}

	public void setParentDO(McStockInDO headDO) {
		setParent(headDO);
	}

	public McStockInSumItemDO[] getMcStockInSumItemDO() {
		IBaseDO[] dos = getChildren(McStockInSumItemDO.class);
		if(dos==null) return null;
		McStockInSumItemDO[] result=new McStockInSumItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockInSumItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockInSumItemDO(McStockInSumItemDO[] dos) {
		setChildren(McStockInSumItemDO.class, dos);
	}
	public McStockInItemDO[] getMcStockInItemDO() {
		IBaseDO[] dos = getChildren(McStockInItemDO.class);
		if(dos==null) return null;
		McStockInItemDO[] result=new McStockInItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockInItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockInItemDO(McStockInItemDO[] dos) {
		setChildren(McStockInItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StockinAggDODesc desc = new StockinAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McStockInDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.st.stockin.d.McStockInSumItemDO")) {
             return new McStockInSumItemDO();
         }
	    else if (clzName.equals("iih.mc.st.stockin.d.McStockInItemDO")) {
             return new McStockInItemDO();
         }
         return null;
     }
}