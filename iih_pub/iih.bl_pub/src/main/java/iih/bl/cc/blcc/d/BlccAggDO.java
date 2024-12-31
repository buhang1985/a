package iih.bl.cc.blcc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.cc.blcc.d.desc.BlccAggDODesc;



/**
 * 组件
 */
public class BlccAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlCcDO getParentDO() {
		return ((BlCcDO) super.getParentDO());
	}

	public void setParentDO(BlCcDO headDO) {
		setParent(headDO);
	}

	public BlCcPmDO[] getBlCcPmDO() {
		IBaseDO[] dos = getChildren(BlCcPmDO.class);
		if(dos==null) return null;
		BlCcPmDO[] result=new BlCcPmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlCcPmDO)dos[i];
		}
		return result;
	}
	
	public void setBlCcPmDO(BlCcPmDO[] dos) {
		setChildren(BlCcPmDO.class, dos);
	}
	public BlCcIncDO[] getBlCcIncDO() {
		IBaseDO[] dos = getChildren(BlCcIncDO.class);
		if(dos==null) return null;
		BlCcIncDO[] result=new BlCcIncDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlCcIncDO)dos[i];
		}
		return result;
	}
	
	public void setBlCcIncDO(BlCcIncDO[] dos) {
		setChildren(BlCcIncDO.class, dos);
	}
	public BlCcIncCancDO[] getBlCcIncCancDO() {
		IBaseDO[] dos = getChildren(BlCcIncCancDO.class);
		if(dos==null) return null;
		BlCcIncCancDO[] result=new BlCcIncCancDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlCcIncCancDO)dos[i];
		}
		return result;
	}
	
	public void setBlCcIncCancDO(BlCcIncCancDO[] dos) {
		setChildren(BlCcIncCancDO.class, dos);
	}
	public BlCcIncReDO[] getBlCcIncReDO() {
		IBaseDO[] dos = getChildren(BlCcIncReDO.class);
		if(dos==null) return null;
		BlCcIncReDO[] result=new BlCcIncReDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlCcIncReDO)dos[i];
		}
		return result;
	}
	
	public void setBlCcIncReDO(BlCcIncReDO[] dos) {
		setChildren(BlCcIncReDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlccAggDODesc desc = new BlccAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlCcDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.cc.blcc.d.BlCcPmDO")) {
             return new BlCcPmDO();
         }
	    else if (clzName.equals("iih.bl.cc.blcc.d.BlCcIncDO")) {
             return new BlCcIncDO();
         }
	    else if (clzName.equals("iih.bl.cc.blcc.d.BlCcIncCancDO")) {
             return new BlCcIncCancDO();
         }
	    else if (clzName.equals("iih.bl.cc.blcc.d.BlCcIncReDO")) {
             return new BlCcIncReDO();
         }
         return null;
     }
}