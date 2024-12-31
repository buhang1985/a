package iih.bd.pp.medinsurrecdiff.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.medinsurrecdiff.d.desc.MedinsurrecdiffAggDODesc;



/**
 * 医保记录差异
 */
public class MedinsurrecdiffAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MedInsurRecDiffDO getParentDO() {
		return ((MedInsurRecDiffDO) super.getParentDO());
	}

	public void setParentDO(MedInsurRecDiffDO headDO) {
		setParent(headDO);
	}

	public MedInsurDrugRecDiffDO[] getMedInsurDrugRecDiffDO() {
		IBaseDO[] dos = getChildren(MedInsurDrugRecDiffDO.class);
		if(dos==null) return null;
		MedInsurDrugRecDiffDO[] result=new MedInsurDrugRecDiffDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MedInsurDrugRecDiffDO)dos[i];
		}
		return result;
	}
	
	public void setMedInsurDrugRecDiffDO(MedInsurDrugRecDiffDO[] dos) {
		setChildren(MedInsurDrugRecDiffDO.class, dos);
	}
	public MedInsurTreatRecDiffDO[] getMedInsurTreatRecDiffDO() {
		IBaseDO[] dos = getChildren(MedInsurTreatRecDiffDO.class);
		if(dos==null) return null;
		MedInsurTreatRecDiffDO[] result=new MedInsurTreatRecDiffDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MedInsurTreatRecDiffDO)dos[i];
		}
		return result;
	}
	
	public void setMedInsurTreatRecDiffDO(MedInsurTreatRecDiffDO[] dos) {
		setChildren(MedInsurTreatRecDiffDO.class, dos);
	}
	public MedInsurSrvFacRecDiffDO[] getMedInsurSrvFacRecDiffDO() {
		IBaseDO[] dos = getChildren(MedInsurSrvFacRecDiffDO.class);
		if(dos==null) return null;
		MedInsurSrvFacRecDiffDO[] result=new MedInsurSrvFacRecDiffDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MedInsurSrvFacRecDiffDO)dos[i];
		}
		return result;
	}
	
	public void setMedInsurSrvFacRecDiffDO(MedInsurSrvFacRecDiffDO[] dos) {
		setChildren(MedInsurSrvFacRecDiffDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MedinsurrecdiffAggDODesc desc = new MedinsurrecdiffAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MedInsurRecDiffDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.medinsurrecdiff.d.MedInsurDrugRecDiffDO")) {
             return new MedInsurDrugRecDiffDO();
         }
	    else if (clzName.equals("iih.bd.pp.medinsurrecdiff.d.MedInsurTreatRecDiffDO")) {
             return new MedInsurTreatRecDiffDO();
         }
	    else if (clzName.equals("iih.bd.pp.medinsurrecdiff.d.MedInsurSrvFacRecDiffDO")) {
             return new MedInsurSrvFacRecDiffDO();
         }
         return null;
     }
}