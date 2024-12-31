package iih.cssd.dpus.dfpapp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpus.dfpapp.d.desc.DfpappAggDODesc;



/**
 * 请领消毒包
 */
public class DfpappAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DfpAppDO getParentDO() {
		return ((DfpAppDO) super.getParentDO());
	}

	public void setParentDO(DfpAppDO headDO) {
		setParent(headDO);
	}

	public DfpAppItmDO[] getDfpAppItmDO() {
		IBaseDO[] dos = getChildren(DfpAppItmDO.class);
		if(dos==null) return null;
		DfpAppItmDO[] result=new DfpAppItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DfpAppItmDO)dos[i];
		}
		return result;
	}
	
	public void setDfpAppItmDO(DfpAppItmDO[] dos) {
		setChildren(DfpAppItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DfpappAggDODesc desc = new DfpappAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DfpAppDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpus.dfpapp.d.DfpAppItmDO")) {
             return new DfpAppItmDO();
         }
         return null;
     }
}