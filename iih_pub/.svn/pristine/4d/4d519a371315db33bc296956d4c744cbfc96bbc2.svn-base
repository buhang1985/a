package iih.sc.scbd.screleaserule.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.scbd.screleaserule.d.desc.ScreleaseruleAggDODesc;



/**
 * 排班释放规则
 */
public class ScreleaseruleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScReleaseRuleDO getParentDO() {
		return ((ScReleaseRuleDO) super.getParentDO());
	}

	public void setParentDO(ScReleaseRuleDO headDO) {
		setParent(headDO);
	}

	public ScReleaseRuleItmDO[] getScReleaseRuleItmDO() {
		IBaseDO[] dos = getChildren(ScReleaseRuleItmDO.class);
		if(dos==null) return null;
		ScReleaseRuleItmDO[] result=new ScReleaseRuleItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScReleaseRuleItmDO)dos[i];
		}
		return result;
	}
	
	public void setScReleaseRuleItmDO(ScReleaseRuleItmDO[] dos) {
		setChildren(ScReleaseRuleItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScreleaseruleAggDODesc desc = new ScreleaseruleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScReleaseRuleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.scbd.screleaserule.d.ScReleaseRuleItmDO")) {
             return new ScReleaseRuleItmDO();
         }
         return null;
     }
}