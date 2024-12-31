package iih.ci.mr.nu.icupatientcare.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.icupatientcare.d.desc.IcupatientcareAggDODesc;



/**
 * ICU患者护理记录单
 */
public class IcupatientcareAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PatientInfoDO getParentDO() {
		return ((PatientInfoDO) super.getParentDO());
	}

	public void setParentDO(PatientInfoDO headDO) {
		setParent(headDO);
	}

	public IcuPatientCareDO[] getIcuPatientCareDO() {
		IBaseDO[] dos = getChildren(IcuPatientCareDO.class);
		if(dos==null) return null;
		IcuPatientCareDO[] result=new IcuPatientCareDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(IcuPatientCareDO)dos[i];
		}
		return result;
	}
	
	public void setIcuPatientCareDO(IcuPatientCareDO[] dos) {
		setChildren(IcuPatientCareDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		IcupatientcareAggDODesc desc = new IcupatientcareAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PatientInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.icupatientcare.d.IcuPatientCareDO")) {
             return new IcuPatientCareDO();
         }
         return null;
     }
}