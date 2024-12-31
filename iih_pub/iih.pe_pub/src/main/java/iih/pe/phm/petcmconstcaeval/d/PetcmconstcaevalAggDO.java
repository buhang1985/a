package iih.pe.phm.petcmconstcaeval.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.petcmconstcaeval.d.desc.PetcmconstcaevalAggDODesc;



/**
 * 体检中医体质评估
 */
public class PetcmconstcaevalAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeTCMConDO getParentDO() {
		return ((PeTCMConDO) super.getParentDO());
	}

	public void setParentDO(PeTCMConDO headDO) {
		setParent(headDO);
	}

	public PeTCMAsseDO[] getPeTCMAsseDO() {
		IBaseDO[] dos = getChildren(PeTCMAsseDO.class);
		if(dos==null) return null;
		PeTCMAsseDO[] result=new PeTCMAsseDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeTCMAsseDO)dos[i];
		}
		return result;
	}
	
	public void setPeTCMAsseDO(PeTCMAsseDO[] dos) {
		setChildren(PeTCMAsseDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PetcmconstcaevalAggDODesc desc = new PetcmconstcaevalAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeTCMConDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.petcmconstcaeval.d.PeTCMAsseDO")) {
             return new PeTCMAsseDO();
         }
         return null;
     }
}