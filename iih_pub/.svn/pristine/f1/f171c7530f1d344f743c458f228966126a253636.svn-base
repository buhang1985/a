package iih.ems.eass.emshift.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ems.eass.emshift.d.desc.EmshiftAggDODesc;



/**
 * 设备资产保管变更
 */
public class EmshiftAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmsEmShiftDO getParentDO() {
		return ((EmsEmShiftDO) super.getParentDO());
	}

	public void setParentDO(EmsEmShiftDO headDO) {
		setParent(headDO);
	}

	public EmsEmShiftItmDO[] getEmsEmShiftItmDO() {
		IBaseDO[] dos = getChildren(EmsEmShiftItmDO.class);
		if(dos==null) return null;
		EmsEmShiftItmDO[] result=new EmsEmShiftItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EmsEmShiftItmDO)dos[i];
		}
		return result;
	}
	
	public void setEmsEmShiftItmDO(EmsEmShiftItmDO[] dos) {
		setChildren(EmsEmShiftItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmshiftAggDODesc desc = new EmshiftAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmsEmShiftDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ems.eass.emshift.d.EmsEmShiftItmDO")) {
             return new EmsEmShiftItmDO();
         }
         return null;
     }
}