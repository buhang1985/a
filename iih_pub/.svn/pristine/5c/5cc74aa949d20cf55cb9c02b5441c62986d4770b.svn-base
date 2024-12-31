package iih.pe.pqn.peevalnutrition.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pqn.peevalnutrition.d.desc.PeevalnutritionAggDODesc;



/**
 * 健康评估-营养评估定义
 */
public class PeevalnutritionAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEvalNutritionDO getParentDO() {
		return ((PeEvalNutritionDO) super.getParentDO());
	}

	public void setParentDO(PeEvalNutritionDO headDO) {
		setParent(headDO);
	}

	public PeEvalNutritionClsDO[] getPeEvalNutritionClsDO() {
		IBaseDO[] dos = getChildren(PeEvalNutritionClsDO.class);
		if(dos==null) return null;
		PeEvalNutritionClsDO[] result=new PeEvalNutritionClsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalNutritionClsDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalNutritionClsDO(PeEvalNutritionClsDO[] dos) {
		setChildren(PeEvalNutritionClsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevalnutritionAggDODesc desc = new PeevalnutritionAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEvalNutritionDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pqn.peevalnutrition.d.PeEvalNutritionClsDO")) {
             return new PeEvalNutritionClsDO();
         }
         return null;
     }
}