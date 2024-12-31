package iih.mm.st.settlement.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.st.settlement.d.desc.SettlementAggDODesc;



/**
 * 采购结算
 */
public class SettlementAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SettlementDO getParentDO() {
		return ((SettlementDO) super.getParentDO());
	}

	public void setParentDO(SettlementDO headDO) {
		setParent(headDO);
	}

	public SettlementItmDO[] getSettlementItmDO() {
		IBaseDO[] dos = getChildren(SettlementItmDO.class);
		if(dos==null) return null;
		SettlementItmDO[] result=new SettlementItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SettlementItmDO)dos[i];
		}
		return result;
	}
	
	public void setSettlementItmDO(SettlementItmDO[] dos) {
		setChildren(SettlementItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SettlementAggDODesc desc = new SettlementAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SettlementDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.st.settlement.d.SettlementItmDO")) {
             return new SettlementItmDO();
         }
         return null;
     }
}