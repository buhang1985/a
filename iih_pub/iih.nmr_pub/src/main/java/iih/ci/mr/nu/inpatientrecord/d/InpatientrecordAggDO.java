package iih.ci.mr.nu.inpatientrecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.inpatientrecord.d.desc.InpatientrecordAggDODesc;



/**
 * 内科住院患者护理记录单
 */
public class InpatientrecordAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public InPatientInfoDO getParentDO() {
		return ((InPatientInfoDO) super.getParentDO());
	}

	public void setParentDO(InPatientInfoDO headDO) {
		setParent(headDO);
	}

	public InPatientRecordDO[] getInPatientRecordDO() {
		IBaseDO[] dos = getChildren(InPatientRecordDO.class);
		if(dos==null) return null;
		InPatientRecordDO[] result=new InPatientRecordDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InPatientRecordDO)dos[i];
		}
		return result;
	}
	
	public void setInPatientRecordDO(InPatientRecordDO[] dos) {
		setChildren(InPatientRecordDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		InpatientrecordAggDODesc desc = new InpatientrecordAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new InPatientInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.inpatientrecord.d.InPatientRecordDO")) {
             return new InPatientRecordDO();
         }
         return null;
     }
}