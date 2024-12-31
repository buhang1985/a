package iih.ci.mr.nu.childhealthedu.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.childhealthedu.d.desc.ChildhealtheduAggDODesc;



/**
 * 儿科住院健康教育评价单
 */
public class ChildhealtheduAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ChildHealthEduDO getParentDO() {
		return ((ChildHealthEduDO) super.getParentDO());
	}

	public void setParentDO(ChildHealthEduDO headDO) {
		setParent(headDO);
	}

	public ChildHealthEduItmDO[] getChildHealthEduItmDO() {
		IBaseDO[] dos = getChildren(ChildHealthEduItmDO.class);
		if(dos==null) return null;
		ChildHealthEduItmDO[] result=new ChildHealthEduItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ChildHealthEduItmDO)dos[i];
		}
		return result;
	}
	
	public void setChildHealthEduItmDO(ChildHealthEduItmDO[] dos) {
		setChildren(ChildHealthEduItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ChildhealtheduAggDODesc desc = new ChildhealtheduAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ChildHealthEduDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.childhealthedu.d.ChildHealthEduItmDO")) {
             return new ChildHealthEduItmDO();
         }
         return null;
     }
}