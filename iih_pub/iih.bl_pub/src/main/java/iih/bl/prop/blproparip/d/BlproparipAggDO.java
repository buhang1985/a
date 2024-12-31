package iih.bl.prop.blproparip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.prop.blproparip.d.desc.BlproparipAggDODesc;



/**
 * 组件
 */
public class BlproparipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlPropArIpDO getParentDO() {
		return ((BlPropArIpDO) super.getParentDO());
	}

	public void setParentDO(BlPropArIpDO headDO) {
		setParent(headDO);
	}

	public BlPropArSegIpDO[] getBlPropArSegIpDO() {
		IBaseDO[] dos = getChildren(BlPropArSegIpDO.class);
		if(dos==null) return null;
		BlPropArSegIpDO[] result=new BlPropArSegIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlPropArSegIpDO)dos[i];
		}
		return result;
	}
	
	public void setBlPropArSegIpDO(BlPropArSegIpDO[] dos) {
		setChildren(BlPropArSegIpDO.class, dos);
	}
	public BlStarItmIpDO[] getBlStarItmIpDO() {
		IBaseDO[] dos = getChildren(BlStarItmIpDO.class);
		if(dos==null) return null;
		BlStarItmIpDO[] result=new BlStarItmIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlStarItmIpDO)dos[i];
		}
		return result;
	}
	
	public void setBlStarItmIpDO(BlStarItmIpDO[] dos) {
		setChildren(BlStarItmIpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlproparipAggDODesc desc = new BlproparipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlPropArIpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.prop.blproparip.d.BlPropArSegIpDO")) {
             return new BlPropArSegIpDO();
         }
	    else if (clzName.equals("iih.bl.prop.blproparip.d.BlStarItmIpDO")) {
             return new BlStarItmIpDO();
         }
         return null;
     }
}