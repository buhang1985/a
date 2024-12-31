package iih.en.pv.shiftturnover.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.pv.shiftturnover.d.desc.ShiftturnoverAggDODesc;



/**
 * 医生交接班
 */
public class ShiftturnoverAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ShiftTurnOverDO getParentDO() {
		return ((ShiftTurnOverDO) super.getParentDO());
	}

	public void setParentDO(ShiftTurnOverDO headDO) {
		setParent(headDO);
	}

	public ShiftTurnOverItemDO[] getShiftTurnOverItemDO() {
		IBaseDO[] dos = getChildren(ShiftTurnOverItemDO.class);
		if(dos==null) return null;
		ShiftTurnOverItemDO[] result=new ShiftTurnOverItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ShiftTurnOverItemDO)dos[i];
		}
		return result;
	}
	
	public void setShiftTurnOverItemDO(ShiftTurnOverItemDO[] dos) {
		setChildren(ShiftTurnOverItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ShiftturnoverAggDODesc desc = new ShiftturnoverAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ShiftTurnOverDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.pv.shiftturnover.d.ShiftTurnOverItemDO")) {
             return new ShiftTurnOverItemDO();
         }
         return null;
     }
}