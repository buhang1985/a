package iih.pe.phm.petcmhealth.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.petcmhealth.d.desc.PetcmhealthAggDODesc;



/**
 * 体检中医养生
 */
public class PetcmhealthAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeTCMHealthTpDO getParentDO() {
		return ((PeTCMHealthTpDO) super.getParentDO());
	}

	public void setParentDO(PeTCMHealthTpDO headDO) {
		setParent(headDO);
	}

	public PeTCMHealthDO[] getPeTCMHealthDO() {
		IBaseDO[] dos = getChildren(PeTCMHealthDO.class);
		if(dos==null) return null;
		PeTCMHealthDO[] result=new PeTCMHealthDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeTCMHealthDO)dos[i];
		}
		return result;
	}
	
	public void setPeTCMHealthDO(PeTCMHealthDO[] dos) {
		setChildren(PeTCMHealthDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PetcmhealthAggDODesc desc = new PetcmhealthAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeTCMHealthTpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.petcmhealth.d.PeTCMHealthDO")) {
             return new PeTCMHealthDO();
         }
         return null;
     }
}