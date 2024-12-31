package iih.bl.cg.blcgoep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.cg.blcgoep.d.desc.BlcgoepAggDODesc;



/**
 * 组件
 */
public class BlcgoepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlCgOepDO getParentDO() {
		return ((BlCgOepDO) super.getParentDO());
	}

	public void setParentDO(BlCgOepDO headDO) {
		setParent(headDO);
	}

	public BlCgItmOepDO[] getBlCgItmOepDO() {
		IBaseDO[] dos = getChildren(BlCgItmOepDO.class);
		if(dos==null) return null;
		BlCgItmOepDO[] result=new BlCgItmOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlCgItmOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlCgItmOepDO(BlCgItmOepDO[] dos) {
		setChildren(BlCgItmOepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlcgoepAggDODesc desc = new BlcgoepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlCgOepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.cg.blcgoep.d.BlCgItmOepDO")) {
             return new BlCgItmOepDO();
         }
         return null;
     }
}