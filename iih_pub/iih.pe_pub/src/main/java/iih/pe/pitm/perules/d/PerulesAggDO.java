package iih.pe.pitm.perules.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.perules.d.desc.PerulesAggDODesc;



/**
 * 异常结果判定规则
 */
public class PerulesAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRuleDefDO getParentDO() {
		return ((PeRuleDefDO) super.getParentDO());
	}

	public void setParentDO(PeRuleDefDO headDO) {
		setParent(headDO);
	}

	public PeRuleItemDO[] getPeRuleItemDO() {
		IBaseDO[] dos = getChildren(PeRuleItemDO.class);
		if(dos==null) return null;
		PeRuleItemDO[] result=new PeRuleItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRuleItemDO)dos[i];
		}
		return result;
	}
	
	public void setPeRuleItemDO(PeRuleItemDO[] dos) {
		setChildren(PeRuleItemDO.class, dos);
	}
	public PeRuleDtlDO[] getPeRuleDtlDO() {
		IBaseDO[] dos = getChildren(PeRuleDtlDO.class);
		if(dos==null) return null;
		PeRuleDtlDO[] result=new PeRuleDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRuleDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeRuleDtlDO(PeRuleDtlDO[] dos) {
		setChildren(PeRuleDtlDO.class, dos);
	}
	public PeRuleDiagDO[] getPeRuleDiagDO() {
		IBaseDO[] dos = getChildren(PeRuleDiagDO.class);
		if(dos==null) return null;
		PeRuleDiagDO[] result=new PeRuleDiagDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRuleDiagDO)dos[i];
		}
		return result;
	}
	
	public void setPeRuleDiagDO(PeRuleDiagDO[] dos) {
		setChildren(PeRuleDiagDO.class, dos);
	}
	public PeRuleExclusiveDO[] getPeRuleExclusiveDO() {
		IBaseDO[] dos = getChildren(PeRuleExclusiveDO.class);
		if(dos==null) return null;
		PeRuleExclusiveDO[] result=new PeRuleExclusiveDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRuleExclusiveDO)dos[i];
		}
		return result;
	}
	
	public void setPeRuleExclusiveDO(PeRuleExclusiveDO[] dos) {
		setChildren(PeRuleExclusiveDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerulesAggDODesc desc = new PerulesAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRuleDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.perules.d.PeRuleItemDO")) {
             return new PeRuleItemDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perules.d.PeRuleDtlDO")) {
             return new PeRuleDtlDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perules.d.PeRuleDiagDO")) {
             return new PeRuleDiagDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perules.d.PeRuleExclusiveDO")) {
             return new PeRuleExclusiveDO();
         }
         return null;
     }
}