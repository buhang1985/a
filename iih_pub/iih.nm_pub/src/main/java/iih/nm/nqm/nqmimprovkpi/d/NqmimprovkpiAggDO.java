package iih.nm.nqm.nqmimprovkpi.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nqmimprovkpi.d.desc.NqmimprovkpiAggDODesc;



/**
 * 护理管理_持续改进项目
 */
public class NqmimprovkpiAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NqmImprovKpiDO getParentDO() {
		return ((NqmImprovKpiDO) super.getParentDO());
	}

	public void setParentDO(NqmImprovKpiDO headDO) {
		setParent(headDO);
	}

	public NqmImprovKpiItmDO[] getNqmImprovKpiItmDO() {
		IBaseDO[] dos = getChildren(NqmImprovKpiItmDO.class);
		if(dos==null) return null;
		NqmImprovKpiItmDO[] result=new NqmImprovKpiItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NqmImprovKpiItmDO)dos[i];
		}
		return result;
	}
	
	public void setNqmImprovKpiItmDO(NqmImprovKpiItmDO[] dos) {
		setChildren(NqmImprovKpiItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NqmimprovkpiAggDODesc desc = new NqmimprovkpiAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NqmImprovKpiDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nqmimprovkpi.d.NqmImprovKpiItmDO")) {
             return new NqmImprovKpiItmDO();
         }
         return null;
     }
}