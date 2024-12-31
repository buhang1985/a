package iih.pe.pqn.petcmconstcadef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.petcmconstcadef.d.desc.PetcmconstcadefAggDODesc;



/**
 * 体检中医体质分型定义
 */
public class PetcmconstcadefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeTCMconstcaDefDO getParentDO() {
		return ((PeTCMconstcaDefDO) super.getParentDO());
	}

	public void setParentDO(PeTCMconstcaDefDO headDO) {
		setParent(headDO);
	}

	public PeTCMJudgeQaDO[] getPeTCMJudgeQaDO() {
		IBaseDO[] dos = getChildren(PeTCMJudgeQaDO.class);
		if(dos==null) return null;
		PeTCMJudgeQaDO[] result=new PeTCMJudgeQaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeTCMJudgeQaDO)dos[i];
		}
		return result;
	}
	
	public void setPeTCMJudgeQaDO(PeTCMJudgeQaDO[] dos) {
		setChildren(PeTCMJudgeQaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PetcmconstcadefAggDODesc desc = new PetcmconstcadefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeTCMconstcaDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.petcmconstcadef.d.PeTCMJudgeQaDO")) {
             return new PeTCMJudgeQaDO();
         }
         return null;
     }
}