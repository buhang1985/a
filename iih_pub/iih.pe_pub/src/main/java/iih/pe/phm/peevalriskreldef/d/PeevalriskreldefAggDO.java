package iih.pe.phm.peevalriskreldef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.phm.peevalriskreldef.d.desc.PeevalriskreldefAggDODesc;



/**
 * 健康评估-危险因素关系定义
 */
public class PeevalriskreldefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeEvalRiskRelDefDO getParentDO() {
		return ((PeEvalRiskRelDefDO) super.getParentDO());
	}

	public void setParentDO(PeEvalRiskRelDefDO headDO) {
		setParent(headDO);
	}

	public PeEvalRiskRelDefItmDO[] getPeEvalRiskRelDefItmDO() {
		IBaseDO[] dos = getChildren(PeEvalRiskRelDefItmDO.class);
		if(dos==null) return null;
		PeEvalRiskRelDefItmDO[] result=new PeEvalRiskRelDefItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeEvalRiskRelDefItmDO)dos[i];
		}
		return result;
	}
	
	public void setPeEvalRiskRelDefItmDO(PeEvalRiskRelDefItmDO[] dos) {
		setChildren(PeEvalRiskRelDefItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PeevalriskreldefAggDODesc desc = new PeevalriskreldefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeEvalRiskRelDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.phm.peevalriskreldef.d.PeEvalRiskRelDefItmDO")) {
             return new PeEvalRiskRelDefItmDO();
         }
         return null;
     }
}