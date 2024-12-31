package iih.bd.srv.mrtaskrule.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrtaskrule.d.desc.MrtaskruleAggDODesc;



/**
 * 病历书写任务配置
 */
public class MrtaskruleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrTaskRuleDO getParentDO() {
		return ((MrTaskRuleDO) super.getParentDO());
	}

	public void setParentDO(MrTaskRuleDO headDO) {
		setParent(headDO);
	}

	public MrTaskRuleSupportDO[] getMrTaskRuleSupportDO() {
		IBaseDO[] dos = getChildren(MrTaskRuleSupportDO.class);
		if(dos==null) return null;
		MrTaskRuleSupportDO[] result=new MrTaskRuleSupportDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrTaskRuleSupportDO)dos[i];
		}
		return result;
	}
	
	public void setMrTaskRuleSupportDO(MrTaskRuleSupportDO[] dos) {
		setChildren(MrTaskRuleSupportDO.class, dos);
	}
	public MrTaskRuleExcludeDO[] getMrTaskRuleExcludeDO() {
		IBaseDO[] dos = getChildren(MrTaskRuleExcludeDO.class);
		if(dos==null) return null;
		MrTaskRuleExcludeDO[] result=new MrTaskRuleExcludeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrTaskRuleExcludeDO)dos[i];
		}
		return result;
	}
	
	public void setMrTaskRuleExcludeDO(MrTaskRuleExcludeDO[] dos) {
		setChildren(MrTaskRuleExcludeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrtaskruleAggDODesc desc = new MrtaskruleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrTaskRuleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrtaskrule.d.MrTaskRuleSupportDO")) {
             return new MrTaskRuleSupportDO();
         }
	    else if (clzName.equals("iih.bd.srv.mrtaskrule.d.MrTaskRuleExcludeDO")) {
             return new MrTaskRuleExcludeDO();
         }
         return null;
     }
}