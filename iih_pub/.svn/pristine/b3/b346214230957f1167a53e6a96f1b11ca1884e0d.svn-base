package iih.bl.prop.blproparoep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.prop.blproparoep.d.desc.BlproparoepAggDODesc;



/**
 * 组件
 */
public class BlproparoepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlPropArOepDO getParentDO() {
		return ((BlPropArOepDO) super.getParentDO());
	}

	public void setParentDO(BlPropArOepDO headDO) {
		setParent(headDO);
	}

	public BlPropArItmOepDO[] getBlPropArItmOepDO() {
		IBaseDO[] dos = getChildren(BlPropArItmOepDO.class);
		if(dos==null) return null;
		BlPropArItmOepDO[] result=new BlPropArItmOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlPropArItmOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlPropArItmOepDO(BlPropArItmOepDO[] dos) {
		setChildren(BlPropArItmOepDO.class, dos);
	}
	public BlPropArSegOepDO[] getBlPropArSegOepDO() {
		IBaseDO[] dos = getChildren(BlPropArSegOepDO.class);
		if(dos==null) return null;
		BlPropArSegOepDO[] result=new BlPropArSegOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlPropArSegOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlPropArSegOepDO(BlPropArSegOepDO[] dos) {
		setChildren(BlPropArSegOepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlproparoepAggDODesc desc = new BlproparoepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlPropArOepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.prop.blproparoep.d.BlPropArItmOepDO")) {
             return new BlPropArItmOepDO();
         }
	    else if (clzName.equals("iih.bl.prop.blproparoep.d.BlPropArSegOepDO")) {
             return new BlPropArSegOepDO();
         }
         return null;
     }
}