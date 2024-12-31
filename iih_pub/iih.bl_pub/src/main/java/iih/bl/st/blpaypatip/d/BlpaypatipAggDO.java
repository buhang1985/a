package iih.bl.st.blpaypatip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.st.blpaypatip.d.desc.BlpaypatipAggDODesc;



/**
 * 住院患者结算收付款
 */
public class BlpaypatipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlPayPatIpDO getParentDO() {
		return ((BlPayPatIpDO) super.getParentDO());
	}

	public void setParentDO(BlPayPatIpDO headDO) {
		setParent(headDO);
	}

	public BlPayItmPatIpDO[] getBlPayItmPatIpDO() {
		IBaseDO[] dos = getChildren(BlPayItmPatIpDO.class);
		if(dos==null) return null;
		BlPayItmPatIpDO[] result=new BlPayItmPatIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlPayItmPatIpDO)dos[i];
		}
		return result;
	}
	
	public void setBlPayItmPatIpDO(BlPayItmPatIpDO[] dos) {
		setChildren(BlPayItmPatIpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlpaypatipAggDODesc desc = new BlpaypatipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlPayPatIpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.st.blpaypatip.d.BlPayItmPatIpDO")) {
             return new BlPayItmPatIpDO();
         }
         return null;
     }
}