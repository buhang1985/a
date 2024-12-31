package iih.bl.inc.blincoep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.inc.blincoep.d.desc.BlincoepAggDODesc;



/**
 * 组件
 */
public class BlincoepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlIncOepDO getParentDO() {
		return ((BlIncOepDO) super.getParentDO());
	}

	public void setParentDO(BlIncOepDO headDO) {
		setParent(headDO);
	}

	public BlStIncOepDO[] getBlStIncOepDO() {
		IBaseDO[] dos = getChildren(BlStIncOepDO.class);
		if(dos==null) return null;
		BlStIncOepDO[] result=new BlStIncOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlStIncOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlStIncOepDO(BlStIncOepDO[] dos) {
		setChildren(BlStIncOepDO.class, dos);
	}
	public BlIncCgItmOep[] getBlIncCgItmOep() {
		IBaseDO[] dos = getChildren(BlIncCgItmOep.class);
		if(dos==null) return null;
		BlIncCgItmOep[] result=new BlIncCgItmOep[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlIncCgItmOep)dos[i];
		}
		return result;
	}
	
	public void setBlIncCgItmOep(BlIncCgItmOep[] dos) {
		setChildren(BlIncCgItmOep.class, dos);
	}
	public BlIncItmOepDO[] getBlIncItmOepDO() {
		IBaseDO[] dos = getChildren(BlIncItmOepDO.class);
		if(dos==null) return null;
		BlIncItmOepDO[] result=new BlIncItmOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlIncItmOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlIncItmOepDO(BlIncItmOepDO[] dos) {
		setChildren(BlIncItmOepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlincoepAggDODesc desc = new BlincoepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlIncOepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.inc.blincoep.d.BlStIncOepDO")) {
             return new BlStIncOepDO();
         }
	    else if (clzName.equals("iih.bl.inc.blincoep.d.BlIncCgItmOep")) {
             return new BlIncCgItmOep();
         }
	    else if (clzName.equals("iih.bl.inc.blincoep.d.BlIncItmOepDO")) {
             return new BlIncItmOepDO();
         }
         return null;
     }
}