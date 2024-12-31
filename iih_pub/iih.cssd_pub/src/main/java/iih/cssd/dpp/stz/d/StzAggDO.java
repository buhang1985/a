package iih.cssd.dpp.stz.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpp.stz.d.desc.StzAggDODesc;



/**
 * 包灭菌
 */
public class StzAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CssddfpstzDO getParentDO() {
		return ((CssddfpstzDO) super.getParentDO());
	}

	public void setParentDO(CssddfpstzDO headDO) {
		setParent(headDO);
	}

	public CssdDfpStzItmDO[] getCssdDfpStzItmDO() {
		IBaseDO[] dos = getChildren(CssdDfpStzItmDO.class);
		if(dos==null) return null;
		CssdDfpStzItmDO[] result=new CssdDfpStzItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CssdDfpStzItmDO)dos[i];
		}
		return result;
	}
	
	public void setCssdDfpStzItmDO(CssdDfpStzItmDO[] dos) {
		setChildren(CssdDfpStzItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		StzAggDODesc desc = new StzAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CssddfpstzDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpp.stz.d.CssdDfpStzItmDO")) {
             return new CssdDfpStzItmDO();
         }
         return null;
     }
}