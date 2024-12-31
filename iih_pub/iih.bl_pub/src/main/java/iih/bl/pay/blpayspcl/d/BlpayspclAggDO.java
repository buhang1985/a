package iih.bl.pay.blpayspcl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.pay.blpayspcl.d.desc.BlpayspclAggDODesc;



/**
 * 收付款_专用款
 */
public class BlpayspclAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlPaySpclDO getParentDO() {
		return ((BlPaySpclDO) super.getParentDO());
	}

	public void setParentDO(BlPaySpclDO headDO) {
		setParent(headDO);
	}

	public BlPayItmSpclDO[] getBlPayItmSpclDO() {
		IBaseDO[] dos = getChildren(BlPayItmSpclDO.class);
		if(dos==null) return null;
		BlPayItmSpclDO[] result=new BlPayItmSpclDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlPayItmSpclDO)dos[i];
		}
		return result;
	}
	
	public void setBlPayItmSpclDO(BlPayItmSpclDO[] dos) {
		setChildren(BlPayItmSpclDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlpayspclAggDODesc desc = new BlpayspclAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlPaySpclDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.pay.blpayspcl.d.BlPayItmSpclDO")) {
             return new BlPayItmSpclDO();
         }
         return null;
     }
}