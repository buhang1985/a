package iih.mp.mpbd.patvstagt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.patvstagt.d.desc.PatvstagtAggDODesc;



/**
 * 患者体征采集指标
 */
public class PatvstagtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PatVsTagtDO getParentDO() {
		return ((PatVsTagtDO) super.getParentDO());
	}

	public void setParentDO(PatVsTagtDO headDO) {
		setParent(headDO);
	}

	public PatVsTagtValDO[] getPatVsTagtValDO() {
		IBaseDO[] dos = getChildren(PatVsTagtValDO.class);
		if(dos==null) return null;
		PatVsTagtValDO[] result=new PatVsTagtValDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PatVsTagtValDO)dos[i];
		}
		return result;
	}
	
	public void setPatVsTagtValDO(PatVsTagtValDO[] dos) {
		setChildren(PatVsTagtValDO.class, dos);
	}
	public PatVsTagtTimeDO[] getPatVsTagtTimeDO() {
		IBaseDO[] dos = getChildren(PatVsTagtTimeDO.class);
		if(dos==null) return null;
		PatVsTagtTimeDO[] result=new PatVsTagtTimeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PatVsTagtTimeDO)dos[i];
		}
		return result;
	}
	
	public void setPatVsTagtTimeDO(PatVsTagtTimeDO[] dos) {
		setChildren(PatVsTagtTimeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PatvstagtAggDODesc desc = new PatvstagtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PatVsTagtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.patvstagt.d.PatVsTagtValDO")) {
             return new PatVsTagtValDO();
         }
	    else if (clzName.equals("iih.mp.mpbd.patvstagt.d.PatVsTagtTimeDO")) {
             return new PatVsTagtTimeDO();
         }
         return null;
     }
}