package iih.nmr.pkuf.heduplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.heduplan.d.desc.HeduplanAggDODesc;



/**
 * 健康教育计划
 */
public class HeduplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HeduPlanDO getParentDO() {
		return ((HeduPlanDO) super.getParentDO());
	}

	public void setParentDO(HeduPlanDO headDO) {
		setParent(headDO);
	}

	public HeduPlanItemDO[] getHeduPlanItemDO() {
		IBaseDO[] dos = getChildren(HeduPlanItemDO.class);
		if(dos==null) return null;
		HeduPlanItemDO[] result=new HeduPlanItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HeduPlanItemDO)dos[i];
		}
		return result;
	}
	
	public void setHeduPlanItemDO(HeduPlanItemDO[] dos) {
		setChildren(HeduPlanItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HeduplanAggDODesc desc = new HeduplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HeduPlanDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.heduplan.d.HeduPlanItemDO")) {
             return new HeduPlanItemDO();
         }
         return null;
     }
}