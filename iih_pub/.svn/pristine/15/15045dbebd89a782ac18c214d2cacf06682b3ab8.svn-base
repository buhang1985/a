package iih.mm.pl.traprequest.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.pl.traprequest.d.desc.TraprequestAggDODesc;



/**
 * 调拨申请
 */
public class TraprequestAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TrapReqOrderDO getParentDO() {
		return ((TrapReqOrderDO) super.getParentDO());
	}

	public void setParentDO(TrapReqOrderDO headDO) {
		setParent(headDO);
	}

	public TrapReqItemDO[] getTrapReqItemDO() {
		IBaseDO[] dos = getChildren(TrapReqItemDO.class);
		if(dos==null) return null;
		TrapReqItemDO[] result=new TrapReqItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TrapReqItemDO)dos[i];
		}
		return result;
	}
	
	public void setTrapReqItemDO(TrapReqItemDO[] dos) {
		setChildren(TrapReqItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TraprequestAggDODesc desc = new TraprequestAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TrapReqOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.pl.traprequest.d.TrapReqItemDO")) {
             return new TrapReqItemDO();
         }
         return null;
     }
}