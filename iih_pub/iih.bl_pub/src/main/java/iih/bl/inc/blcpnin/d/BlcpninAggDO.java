package iih.bl.inc.blcpnin.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.inc.blcpnin.d.desc.BlcpninAggDODesc;



/**
 * 组件
 */
public class BlcpninAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlCpnInDO getParentDO() {
		return ((BlCpnInDO) super.getParentDO());
	}

	public void setParentDO(BlCpnInDO headDO) {
		setParent(headDO);
	}

	public BlCpnDO[] getBlCpnDO() {
		IBaseDO[] dos = getChildren(BlCpnDO.class);
		if(dos==null) return null;
		BlCpnDO[] result=new BlCpnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlCpnDO)dos[i];
		}
		return result;
	}
	
	public void setBlCpnDO(BlCpnDO[] dos) {
		setChildren(BlCpnDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlcpninAggDODesc desc = new BlcpninAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlCpnInDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.inc.blcpnin.d.BlCpnDO")) {
             return new BlCpnDO();
         }
         return null;
     }
}