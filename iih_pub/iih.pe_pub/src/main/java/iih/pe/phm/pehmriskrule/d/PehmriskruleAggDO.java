package iih.pe.phm.pehmriskrule.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.pehmriskrule.d.desc.PehmriskruleAggDODesc;



/**
 * 健康危险因素规则定义
 */
public class PehmriskruleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeHmRiskRuleDO getParentDO() {
		return ((PeHmRiskRuleDO) super.getParentDO());
	}

	public void setParentDO(PeHmRiskRuleDO headDO) {
		setParent(headDO);
	}

	public PeHmRiskRuleItemDO[] getPeHmRiskRuleItemDO() {
		IBaseDO[] dos = getChildren(PeHmRiskRuleItemDO.class);
		if(dos==null) return null;
		PeHmRiskRuleItemDO[] result=new PeHmRiskRuleItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeHmRiskRuleItemDO)dos[i];
		}
		return result;
	}
	
	public void setPeHmRiskRuleItemDO(PeHmRiskRuleItemDO[] dos) {
		setChildren(PeHmRiskRuleItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PehmriskruleAggDODesc desc = new PehmriskruleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeHmRiskRuleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.pehmriskrule.d.PeHmRiskRuleItemDO")) {
             return new PeHmRiskRuleItemDO();
         }
         return null;
     }
}