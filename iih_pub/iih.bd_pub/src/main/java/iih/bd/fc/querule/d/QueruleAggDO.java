package iih.bd.fc.querule.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.fc.querule.d.desc.QueruleAggDODesc;



/**
 * 队列规则
 */
public class QueruleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public QueRuleDO getParentDO() {
		return ((QueRuleDO) super.getParentDO());
	}

	public void setParentDO(QueRuleDO headDO) {
		setParent(headDO);
	}

	public QueRuleItmDO[] getQueRuleItmDO() {
		IBaseDO[] dos = getChildren(QueRuleItmDO.class);
		if(dos==null) return null;
		QueRuleItmDO[] result=new QueRuleItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(QueRuleItmDO)dos[i];
		}
		return result;
	}
	
	public void setQueRuleItmDO(QueRuleItmDO[] dos) {
		setChildren(QueRuleItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		QueruleAggDODesc desc = new QueruleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new QueRuleDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.fc.querule.d.QueRuleItmDO")) {
             return new QueRuleItmDO();
         }
         return null;
     }
}