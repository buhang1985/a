package iih.mc.pl.mcstockplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.pl.mcstockplan.d.desc.McstockplanAggDODesc;



/**
 * 耗材库存计划
 */
public class McstockplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McStockPlanDO getParentDO() {
		return ((McStockPlanDO) super.getParentDO());
	}

	public void setParentDO(McStockPlanDO headDO) {
		setParent(headDO);
	}

	public McStockPlanItmDO[] getMcStockPlanItmDO() {
		IBaseDO[] dos = getChildren(McStockPlanItmDO.class);
		if(dos==null) return null;
		McStockPlanItmDO[] result=new McStockPlanItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McStockPlanItmDO)dos[i];
		}
		return result;
	}
	
	public void setMcStockPlanItmDO(McStockPlanItmDO[] dos) {
		setChildren(McStockPlanItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		McstockplanAggDODesc desc = new McstockplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McStockPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.pl.mcstockplan.d.McStockPlanItmDO")) {
             return new McStockPlanItmDO();
         }
         return null;
     }
}