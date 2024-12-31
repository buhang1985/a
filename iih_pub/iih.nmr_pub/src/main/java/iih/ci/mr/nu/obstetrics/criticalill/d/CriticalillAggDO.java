package iih.ci.mr.nu.obstetrics.criticalill.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.criticalill.d.desc.CriticalillAggDODesc;



/**
 * 患者急诊就诊护理记录单
 */
public class CriticalillAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CriticalCustDO getParentDO() {
		return ((CriticalCustDO) super.getParentDO());
	}

	public void setParentDO(CriticalCustDO headDO) {
		setParent(headDO);
	}

	public CriticalillDO[] getCriticalillDO() {
		IBaseDO[] dos = getChildren(CriticalillDO.class);
		if(dos==null) return null;
		CriticalillDO[] result=new CriticalillDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CriticalillDO)dos[i];
		}
		return result;
	}
	
	public void setCriticalillDO(CriticalillDO[] dos) {
		setChildren(CriticalillDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CriticalillAggDODesc desc = new CriticalillAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CriticalCustDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.criticalill.d.CriticalillDO")) {
             return new CriticalillDO();
         }
         return null;
     }
}