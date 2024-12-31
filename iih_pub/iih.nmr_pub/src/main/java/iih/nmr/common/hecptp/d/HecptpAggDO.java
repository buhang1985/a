package iih.nmr.common.hecptp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.common.hecptp.d.desc.HecptpAggDODesc;



/**
 * 健康教育计划单据类型
 */
public class HecptpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HeduPlanTpDO getParentDO() {
		return ((HeduPlanTpDO) super.getParentDO());
	}

	public void setParentDO(HeduPlanTpDO headDO) {
		setParent(headDO);
	}

	public HeduPlanRelDO[] getHeduPlanRelDO() {
		IBaseDO[] dos = getChildren(HeduPlanRelDO.class);
		if(dos==null) return null;
		HeduPlanRelDO[] result=new HeduPlanRelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HeduPlanRelDO)dos[i];
		}
		return result;
	}
	
	public void setHeduPlanRelDO(HeduPlanRelDO[] dos) {
		setChildren(HeduPlanRelDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HecptpAggDODesc desc = new HecptpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HeduPlanTpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.common.hecptp.d.HeduPlanRelDO")) {
             return new HeduPlanRelDO();
         }
         return null;
     }
}