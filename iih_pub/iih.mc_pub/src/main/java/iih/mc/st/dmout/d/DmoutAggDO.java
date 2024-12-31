package iih.mc.st.dmout.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.st.dmout.d.desc.DmoutAggDODesc;



/**
 * 高值耗材报损
 */
public class DmoutAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McDamageOutDO getParentDO() {
		return ((McDamageOutDO) super.getParentDO());
	}

	public void setParentDO(McDamageOutDO headDO) {
		setParent(headDO);
	}

	public McDamageOutItmDO[] getMcDamageOutItmDO() {
		IBaseDO[] dos = getChildren(McDamageOutItmDO.class);
		if(dos==null) return null;
		McDamageOutItmDO[] result=new McDamageOutItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McDamageOutItmDO)dos[i];
		}
		return result;
	}
	
	public void setMcDamageOutItmDO(McDamageOutItmDO[] dos) {
		setChildren(McDamageOutItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DmoutAggDODesc desc = new DmoutAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McDamageOutDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.st.dmout.d.McDamageOutItmDO")) {
             return new McDamageOutItmDO();
         }
         return null;
     }
}