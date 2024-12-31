package iih.ci.mr.nu.babycare.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.babycare.d.desc.BabycareAggDODesc;



/**
 * 新生儿护理记录单
 */
public class BabycareAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BabyInfoDO getParentDO() {
		return ((BabyInfoDO) super.getParentDO());
	}

	public void setParentDO(BabyInfoDO headDO) {
		setParent(headDO);
	}

	public BabyNurRecDO[] getBabyNurRecDO() {
		IBaseDO[] dos = getChildren(BabyNurRecDO.class);
		if(dos==null) return null;
		BabyNurRecDO[] result=new BabyNurRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BabyNurRecDO)dos[i];
		}
		return result;
	}
	
	public void setBabyNurRecDO(BabyNurRecDO[] dos) {
		setChildren(BabyNurRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BabycareAggDODesc desc = new BabycareAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BabyInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.babycare.d.BabyNurRecDO")) {
             return new BabyNurRecDO();
         }
         return null;
     }
}