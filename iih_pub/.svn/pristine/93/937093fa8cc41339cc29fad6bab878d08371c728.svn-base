package iih.nmr.pkuf.healthedu.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.healthedu.d.desc.Healthedu1AggDODesc;



/**
 * 健康教育计划执行单
 */
public class Healthedu1AggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HealtheduDO getParentDO() {
		return ((HealtheduDO) super.getParentDO());
	}

	public void setParentDO(HealtheduDO headDO) {
		setParent(headDO);
	}

	public HealtheduItmDO[] getHealtheduItmDO() {
		IBaseDO[] dos = getChildren(HealtheduItmDO.class);
		if(dos==null) return null;
		HealtheduItmDO[] result=new HealtheduItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HealtheduItmDO)dos[i];
		}
		return result;
	}
	
	public void setHealtheduItmDO(HealtheduItmDO[] dos) {
		setChildren(HealtheduItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		Healthedu1AggDODesc desc = new Healthedu1AggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HealtheduDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.healthedu.d.HealtheduItmDO")) {
             return new HealtheduItmDO();
         }
         return null;
     }
}