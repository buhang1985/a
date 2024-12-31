package iih.ci.mr.nu.critillpatcare.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.critillpatcare.d.desc.CritillpatcareAggDODesc;



/**
 * 患者病危护理记录
 */
public class CritillpatcareAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public IllPatientDO getParentDO() {
		return ((IllPatientDO) super.getParentDO());
	}

	public void setParentDO(IllPatientDO headDO) {
		setParent(headDO);
	}

	public IllPatientCareDO[] getIllPatientCareDO() {
		IBaseDO[] dos = getChildren(IllPatientCareDO.class);
		if(dos==null) return null;
		IllPatientCareDO[] result=new IllPatientCareDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(IllPatientCareDO)dos[i];
		}
		return result;
	}
	
	public void setIllPatientCareDO(IllPatientCareDO[] dos) {
		setChildren(IllPatientCareDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CritillpatcareAggDODesc desc = new CritillpatcareAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new IllPatientDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.critillpatcare.d.IllPatientCareDO")) {
             return new IllPatientCareDO();
         }
         return null;
     }
}