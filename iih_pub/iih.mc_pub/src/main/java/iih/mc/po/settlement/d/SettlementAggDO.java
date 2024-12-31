package iih.mc.po.settlement.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.po.settlement.d.desc.SettlementAggDODesc;



/**
 * 采购发票结算
 */
public class SettlementAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McSettlementDO getParentDO() {
		return ((McSettlementDO) super.getParentDO());
	}

	public void setParentDO(McSettlementDO headDO) {
		setParent(headDO);
	}

	public McSettlementItmDO[] getMcSettlementItmDO() {
		IBaseDO[] dos = getChildren(McSettlementItmDO.class);
		if(dos==null) return null;
		McSettlementItmDO[] result=new McSettlementItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McSettlementItmDO)dos[i];
		}
		return result;
	}
	
	public void setMcSettlementItmDO(McSettlementItmDO[] dos) {
		setChildren(McSettlementItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SettlementAggDODesc desc = new SettlementAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McSettlementDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.po.settlement.d.McSettlementItmDO")) {
             return new McSettlementItmDO();
         }
         return null;
     }
}