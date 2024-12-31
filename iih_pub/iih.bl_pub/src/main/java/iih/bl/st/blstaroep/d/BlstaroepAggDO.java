package iih.bl.st.blstaroep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.st.blstaroep.d.desc.BlstaroepAggDODesc;



/**
 * 结算应收_门急体
 */
public class BlstaroepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlStArOepDO getParentDO() {
		return ((BlStArOepDO) super.getParentDO());
	}

	public void setParentDO(BlStArOepDO headDO) {
		setParent(headDO);
	}

	public BlStArItmOepDO[] getBlStArItmOepDO() {
		IBaseDO[] dos = getChildren(BlStArItmOepDO.class);
		if(dos==null) return null;
		BlStArItmOepDO[] result=new BlStArItmOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlStArItmOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlStArItmOepDO(BlStArItmOepDO[] dos) {
		setChildren(BlStArItmOepDO.class, dos);
	}
	public BlStArSegOepDO[] getBlStArSegOepDO() {
		IBaseDO[] dos = getChildren(BlStArSegOepDO.class);
		if(dos==null) return null;
		BlStArSegOepDO[] result=new BlStArSegOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlStArSegOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlStArSegOepDO(BlStArSegOepDO[] dos) {
		setChildren(BlStArSegOepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlstaroepAggDODesc desc = new BlstaroepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlStArOepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.st.blstaroep.d.BlStArItmOepDO")) {
             return new BlStArItmOepDO();
         }
	    else if (clzName.equals("iih.bl.st.blstaroep.d.BlStArSegOepDO")) {
             return new BlStArSegOepDO();
         }
         return null;
     }
}