package iih.ci.mr.nu.medicrecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.medicrecord.d.desc.MedicrecordAggDODesc;



/**
 * 医疗记录数据集
 */
public class MedicrecordAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MedicalRecordSetDO getParentDO() {
		return ((MedicalRecordSetDO) super.getParentDO());
	}

	public void setParentDO(MedicalRecordSetDO headDO) {
		setParent(headDO);
	}

	public MedicalRecordSetCollDO[] getMedicalRecordSetCollDO() {
		IBaseDO[] dos = getChildren(MedicalRecordSetCollDO.class);
		if(dos==null) return null;
		MedicalRecordSetCollDO[] result=new MedicalRecordSetCollDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MedicalRecordSetCollDO)dos[i];
		}
		return result;
	}
	
	public void setMedicalRecordSetCollDO(MedicalRecordSetCollDO[] dos) {
		setChildren(MedicalRecordSetCollDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MedicrecordAggDODesc desc = new MedicrecordAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MedicalRecordSetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.medicrecord.d.MedicalRecordSetCollDO")) {
             return new MedicalRecordSetCollDO();
         }
         return null;
     }
}