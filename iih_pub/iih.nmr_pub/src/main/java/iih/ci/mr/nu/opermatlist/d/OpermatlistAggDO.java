package iih.ci.mr.nu.opermatlist.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.opermatlist.d.desc.OpermatlistAggDODesc;



/**
 * 手术患者术中物品清点单
 */
public class OpermatlistAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OpermatDO getParentDO() {
		return ((OpermatDO) super.getParentDO());
	}

	public void setParentDO(OpermatDO headDO) {
		setParent(headDO);
	}

	public OpermatDutyDO[] getOpermatDutyDO() {
		IBaseDO[] dos = getChildren(OpermatDutyDO.class);
		if(dos==null) return null;
		OpermatDutyDO[] result=new OpermatDutyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OpermatDutyDO)dos[i];
		}
		return result;
	}
	
	public void setOpermatDutyDO(OpermatDutyDO[] dos) {
		setChildren(OpermatDutyDO.class, dos);
	}
	public OpermatEquipDO[] getOpermatEquipDO() {
		IBaseDO[] dos = getChildren(OpermatEquipDO.class);
		if(dos==null) return null;
		OpermatEquipDO[] result=new OpermatEquipDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OpermatEquipDO)dos[i];
		}
		return result;
	}
	
	public void setOpermatEquipDO(OpermatEquipDO[] dos) {
		setChildren(OpermatEquipDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OpermatlistAggDODesc desc = new OpermatlistAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OpermatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.opermatlist.d.OpermatDutyDO")) {
             return new OpermatDutyDO();
         }
	    else if (clzName.equals("iih.ci.mr.nu.opermatlist.d.OpermatEquipDO")) {
             return new OpermatEquipDO();
         }
         return null;
     }
}