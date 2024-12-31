package iih.nm.nqm.nmnqmkpi.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmkpi.d.desc.NmnqmkpiAggDODesc;



/**
 * 标准指标
 */
public class NmnqmkpiAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmKpiDO getParentDO() {
		return ((NmNqmKpiDO) super.getParentDO());
	}

	public void setParentDO(NmNqmKpiDO headDO) {
		setParent(headDO);
	}

	public NmNqmKpiItmDO[] getNmNqmKpiItmDO() {
		IBaseDO[] dos = getChildren(NmNqmKpiItmDO.class);
		if(dos==null) return null;
		NmNqmKpiItmDO[] result=new NmNqmKpiItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmKpiItmDO)dos[i];
		}
		return result;
	}
	
	public void setNmNqmKpiItmDO(NmNqmKpiItmDO[] dos) {
		setChildren(NmNqmKpiItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmkpiAggDODesc desc = new NmnqmkpiAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmKpiDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmkpi.d.NmNqmKpiItmDO")) {
             return new NmNqmKpiItmDO();
         }
         return null;
     }
}