package iih.ci.mr.nu.perioperativenurrec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.perioperativenurrec.d.desc.PerioperativenurrecAggDODesc;



/**
 * 围手术期护理记录单
 */
public class PerioperativenurrecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PpNurDO getParentDO() {
		return ((PpNurDO) super.getParentDO());
	}

	public void setParentDO(PpNurDO headDO) {
		setParent(headDO);
	}

	public PpNurRecDO[] getPpNurRecDO() {
		IBaseDO[] dos = getChildren(PpNurRecDO.class);
		if(dos==null) return null;
		PpNurRecDO[] result=new PpNurRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PpNurRecDO)dos[i];
		}
		return result;
	}
	
	public void setPpNurRecDO(PpNurRecDO[] dos) {
		setChildren(PpNurRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerioperativenurrecAggDODesc desc = new PerioperativenurrecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PpNurDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.perioperativenurrec.d.PpNurRecDO")) {
             return new PpNurRecDO();
         }
         return null;
     }
}