package iih.bl.pay.blspclpat.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.pay.blspclpat.d.desc.BlspclpatAggDODesc;



/**
 * 患者专用款
 */
public class BlspclpatAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlSpclPatDO getParentDO() {
		return ((BlSpclPatDO) super.getParentDO());
	}

	public void setParentDO(BlSpclPatDO headDO) {
		setParent(headDO);
	}

	public BlSpclItmPatDO[] getBlSpclItmPatDO() {
		IBaseDO[] dos = getChildren(BlSpclItmPatDO.class);
		if(dos==null) return null;
		BlSpclItmPatDO[] result=new BlSpclItmPatDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BlSpclItmPatDO)dos[i];
		}
		return result;
	}
	
	public void setBlSpclItmPatDO(BlSpclItmPatDO[] dos) {
		setChildren(BlSpclItmPatDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BlspclpatAggDODesc desc = new BlspclpatAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BlSpclPatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.pay.blspclpat.d.BlSpclItmPatDO")) {
             return new BlSpclItmPatDO();
         }
         return null;
     }
}