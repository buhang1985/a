package iih.pe.phm.penutrition.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.penutrition.d.desc.PenutritionAggDODesc;



/**
 * 健康营养评估结果
 */
public class PenutritionAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeNutritionDO getParentDO() {
		return ((PeNutritionDO) super.getParentDO());
	}

	public void setParentDO(PeNutritionDO headDO) {
		setParent(headDO);
	}

	public PeNutritionDtlDO[] getPeNutritionDtlDO() {
		IBaseDO[] dos = getChildren(PeNutritionDtlDO.class);
		if(dos==null) return null;
		PeNutritionDtlDO[] result=new PeNutritionDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeNutritionDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeNutritionDtlDO(PeNutritionDtlDO[] dos) {
		setChildren(PeNutritionDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PenutritionAggDODesc desc = new PenutritionAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeNutritionDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.penutrition.d.PeNutritionDtlDO")) {
             return new PeNutritionDtlDO();
         }
         return null;
     }
}