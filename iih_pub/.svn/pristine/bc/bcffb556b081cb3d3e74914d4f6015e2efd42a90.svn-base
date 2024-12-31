package iih.ci.mr.nu.hemodialycare.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.hemodialycare.d.desc.HemodialycaredoAggDODesc;



/**
 * 血液透析护理记录单
 */
public class HemodialycaredoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HemodialycareinfoDO getParentDO() {
		return ((HemodialycareinfoDO) super.getParentDO());
	}

	public void setParentDO(HemodialycareinfoDO headDO) {
		setParent(headDO);
	}

	public HemodialycareitmDO[] getHemodialycareitmDO() {
		IBaseDO[] dos = getChildren(HemodialycareitmDO.class);
		if(dos==null) return null;
		HemodialycareitmDO[] result=new HemodialycareitmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HemodialycareitmDO)dos[i];
		}
		return result;
	}
	
	public void setHemodialycareitmDO(HemodialycareitmDO[] dos) {
		setChildren(HemodialycareitmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HemodialycaredoAggDODesc desc = new HemodialycaredoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HemodialycareinfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.hemodialycare.d.HemodialycareitmDO")) {
             return new HemodialycareitmDO();
         }
         return null;
     }
}