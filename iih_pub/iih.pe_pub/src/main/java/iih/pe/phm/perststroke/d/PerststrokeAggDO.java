package iih.pe.phm.perststroke.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.perststroke.d.desc.PerststrokeAggDODesc;



/**
 * 健康管理_脑卒中评估结果
 */
public class PerststrokeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstStrokeDO getParentDO() {
		return ((PeRstStrokeDO) super.getParentDO());
	}

	public void setParentDO(PeRstStrokeDO headDO) {
		setParent(headDO);
	}

	public PeRstStrokeRiskDO[] getPeRstStrokeRiskDO() {
		IBaseDO[] dos = getChildren(PeRstStrokeRiskDO.class);
		if(dos==null) return null;
		PeRstStrokeRiskDO[] result=new PeRstStrokeRiskDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstStrokeRiskDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstStrokeRiskDO(PeRstStrokeRiskDO[] dos) {
		setChildren(PeRstStrokeRiskDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerststrokeAggDODesc desc = new PerststrokeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstStrokeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.perststroke.d.PeRstStrokeRiskDO")) {
             return new PeRstStrokeRiskDO();
         }
         return null;
     }
}