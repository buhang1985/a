package iih.bl.inc.blincip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.inc.blincip.d.desc.BlincipAggDODesc;



/**
 * 住院发票
 */
public class BlincipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlIncIpDO getParentDO() {
		return ((BlIncIpDO) super.getParentDO());
	}

	public void setParentDO(BlIncIpDO headDO) {
		setParent(headDO);
	}

	public BlStIncIpDO[] getBlStIncIpDO() {
		IBaseDO[] dos = getChildren(BlStIncIpDO.class);
		if(dos==null) return null;
		BlStIncIpDO[] result=new BlStIncIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlStIncIpDO)dos[i];
		}
		return result;
	}
	
	public void setBlStIncIpDO(BlStIncIpDO[] dos) {
		setChildren(BlStIncIpDO.class, dos);
	}
	public BlIncItmIpDO[] getBlIncItmIpDO() {
		IBaseDO[] dos = getChildren(BlIncItmIpDO.class);
		if(dos==null) return null;
		BlIncItmIpDO[] result=new BlIncItmIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlIncItmIpDO)dos[i];
		}
		return result;
	}
	
	public void setBlIncItmIpDO(BlIncItmIpDO[] dos) {
		setChildren(BlIncItmIpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlincipAggDODesc desc = new BlincipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlIncIpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.inc.blincip.d.BlStIncIpDO")) {
             return new BlStIncIpDO();
         }
	    else if (clzName.equals("iih.bl.inc.blincip.d.BlIncItmIpDO")) {
             return new BlIncItmIpDO();
         }
         return null;
     }
}