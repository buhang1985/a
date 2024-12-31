package iih.pe.pqn.peevalmeal.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peevalmeal.d.desc.PeevalmealAggDODesc;



/**
 * 体检饮食评估定义
 */
public class PeevalmealAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEvalMealDO getParentDO() {
		return ((PeEvalMealDO) super.getParentDO());
	}

	public void setParentDO(PeEvalMealDO headDO) {
		setParent(headDO);
	}

	public PeEvalMealQaDO[] getPeEvalMealQaDO() {
		IBaseDO[] dos = getChildren(PeEvalMealQaDO.class);
		if(dos==null) return null;
		PeEvalMealQaDO[] result=new PeEvalMealQaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalMealQaDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalMealQaDO(PeEvalMealQaDO[] dos) {
		setChildren(PeEvalMealQaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevalmealAggDODesc desc = new PeevalmealAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEvalMealDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peevalmeal.d.PeEvalMealQaDO")) {
             return new PeEvalMealQaDO();
         }
         return null;
     }
}