package iih.bl.st.blpaypatoep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.st.blpaypatoep.d.desc.BlpaypatoepAggDODesc;



/**
 * 组件
 */
public class BlpaypatoepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlPayPatOepDO getParentDO() {
		return ((BlPayPatOepDO) super.getParentDO());
	}

	public void setParentDO(BlPayPatOepDO headDO) {
		setParent(headDO);
	}

	public BlPayItmPatOepDO[] getBlPayItmPatOepDO() {
		IBaseDO[] dos = getChildren(BlPayItmPatOepDO.class);
		if(dos==null) return null;
		BlPayItmPatOepDO[] result=new BlPayItmPatOepDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlPayItmPatOepDO)dos[i];
		}
		return result;
	}
	
	public void setBlPayItmPatOepDO(BlPayItmPatOepDO[] dos) {
		setChildren(BlPayItmPatOepDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlpaypatoepAggDODesc desc = new BlpaypatoepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlPayPatOepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO")) {
             return new BlPayItmPatOepDO();
         }
         return null;
     }
}