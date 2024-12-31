package iih.nm.nqm.nmnqmspcs.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nqm.nmnqmspcs.d.desc.NmnqmspcsAggDODesc;



/**
 * 护理管理_专科护理质量
 */
public class NmnqmspcsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmNqmSpcsDo getParentDO() {
		return ((NmNqmSpcsDo) super.getParentDO());
	}

	public void setParentDO(NmNqmSpcsDo headDO) {
		setParent(headDO);
	}

	public NmNqmSpcsKpiDo[] getNmNqmSpcsKpiDo() {
		IBaseDO[] dos = getChildren(NmNqmSpcsKpiDo.class);
		if(dos==null) return null;
		NmNqmSpcsKpiDo[] result=new NmNqmSpcsKpiDo[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmNqmSpcsKpiDo)dos[i];
		}
		return result;
	}
	
	public void setNmNqmSpcsKpiDo(NmNqmSpcsKpiDo[] dos) {
		setChildren(NmNqmSpcsKpiDo.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmnqmspcsAggDODesc desc = new NmnqmspcsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmNqmSpcsDo();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nqm.nmnqmspcs.d.NmNqmSpcsKpiDo")) {
             return new NmNqmSpcsKpiDo();
         }
         return null;
     }
}