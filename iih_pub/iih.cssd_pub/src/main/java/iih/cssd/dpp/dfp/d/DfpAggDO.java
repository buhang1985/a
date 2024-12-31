package iih.cssd.dpp.dfp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpp.dfp.d.desc.DfpAggDODesc;



/**
 * 消毒包生产
 */
public class DfpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CssdDfpDO getParentDO() {
		return ((CssdDfpDO) super.getParentDO());
	}

	public void setParentDO(CssdDfpDO headDO) {
		setParent(headDO);
	}

	public CssdDfpMmDO[] getCssdDfpMmDO() {
		IBaseDO[] dos = getChildren(CssdDfpMmDO.class);
		if(dos==null) return null;
		CssdDfpMmDO[] result=new CssdDfpMmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CssdDfpMmDO)dos[i];
		}
		return result;
	}
	
	public void setCssdDfpMmDO(CssdDfpMmDO[] dos) {
		setChildren(CssdDfpMmDO.class, dos);
	}
	public CssdDepstaDO[] getCssdDepstaDO() {
		IBaseDO[] dos = getChildren(CssdDepstaDO.class);
		if(dos==null) return null;
		CssdDepstaDO[] result=new CssdDepstaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CssdDepstaDO)dos[i];
		}
		return result;
	}
	
	public void setCssdDepstaDO(CssdDepstaDO[] dos) {
		setChildren(CssdDepstaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DfpAggDODesc desc = new DfpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CssdDfpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpp.dfp.d.CssdDfpMmDO")) {
             return new CssdDfpMmDO();
         }
	    else if (clzName.equals("iih.cssd.dpp.dfp.d.CssdDepstaDO")) {
             return new CssdDepstaDO();
         }
         return null;
     }
}