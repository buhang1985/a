package iih.ci.mr.nu.obstetrics.criticallyill.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.criticallyill.d.desc.CriticallyillAggDODesc;



/**
 * 患者就诊护理记录单
 */
public class CriticallyillAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CriticallyCustDO getParentDO() {
		return ((CriticallyCustDO) super.getParentDO());
	}

	public void setParentDO(CriticallyCustDO headDO) {
		setParent(headDO);
	}

	public CriticallyIllDO[] getCriticallyIllDO() {
		IBaseDO[] dos = getChildren(CriticallyIllDO.class);
		if(dos==null) return null;
		CriticallyIllDO[] result=new CriticallyIllDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CriticallyIllDO)dos[i];
		}
		return result;
	}
	
	public void setCriticallyIllDO(CriticallyIllDO[] dos) {
		setChildren(CriticallyIllDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CriticallyillAggDODesc desc = new CriticallyillAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CriticallyCustDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.criticallyill.d.CriticallyIllDO")) {
             return new CriticallyIllDO();
         }
         return null;
     }
}