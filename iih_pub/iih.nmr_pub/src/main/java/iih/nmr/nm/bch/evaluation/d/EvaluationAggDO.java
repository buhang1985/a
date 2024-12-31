package iih.nmr.nm.bch.evaluation.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.nm.bch.evaluation.d.desc.EvaluationAggDODesc;



/**
 * 患者和家属健康教育计划表
 */
public class EvaluationAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EvaluatDO getParentDO() {
		return ((EvaluatDO) super.getParentDO());
	}

	public void setParentDO(EvaluatDO headDO) {
		setParent(headDO);
	}

	public EvaluateItmDO[] getEvaluateItmDO() {
		IBaseDO[] dos = getChildren(EvaluateItmDO.class);
		if(dos==null) return null;
		EvaluateItmDO[] result=new EvaluateItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EvaluateItmDO)dos[i];
		}
		return result;
	}
	
	public void setEvaluateItmDO(EvaluateItmDO[] dos) {
		setChildren(EvaluateItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EvaluationAggDODesc desc = new EvaluationAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EvaluatDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.nm.bch.evaluation.d.EvaluateItmDO")) {
             return new EvaluateItmDO();
         }
         return null;
     }
}