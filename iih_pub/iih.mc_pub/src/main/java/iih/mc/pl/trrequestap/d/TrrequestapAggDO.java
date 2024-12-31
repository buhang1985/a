package iih.mc.pl.trrequestap.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.pl.trrequestap.d.desc.TrrequestapAggDODesc;



/**
 * 调拨申请单
 */
public class TrrequestapAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McTrReqApOrderDO getParentDO() {
		return ((McTrReqApOrderDO) super.getParentDO());
	}

	public void setParentDO(McTrReqApOrderDO headDO) {
		setParent(headDO);
	}

	public McTrReqApItemDO[] getMcTrReqApItemDO() {
		IBaseDO[] dos = getChildren(McTrReqApItemDO.class);
		if(dos==null) return null;
		McTrReqApItemDO[] result=new McTrReqApItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McTrReqApItemDO)dos[i];
		}
		return result;
	}
	
	public void setMcTrReqApItemDO(McTrReqApItemDO[] dos) {
		setChildren(McTrReqApItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TrrequestapAggDODesc desc = new TrrequestapAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McTrReqApOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.pl.trrequestap.d.McTrReqApItemDO")) {
             return new McTrReqApItemDO();
         }
         return null;
     }
}