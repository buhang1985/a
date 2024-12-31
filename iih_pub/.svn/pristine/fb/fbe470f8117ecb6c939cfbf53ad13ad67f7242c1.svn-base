package iih.cssd.dpp.dfpcln.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpp.dfpcln.d.desc.DfpclnAggDODesc;



/**
 * 消毒包清洗
 */
public class DfpclnAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CssdDfpClnDO getParentDO() {
		return ((CssdDfpClnDO) super.getParentDO());
	}

	public void setParentDO(CssdDfpClnDO headDO) {
		setParent(headDO);
	}

	public CssdDfpClnItmDO[] getCssdDfpClnItmDO() {
		IBaseDO[] dos = getChildren(CssdDfpClnItmDO.class);
		if(dos==null) return null;
		CssdDfpClnItmDO[] result=new CssdDfpClnItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CssdDfpClnItmDO)dos[i];
		}
		return result;
	}
	
	public void setCssdDfpClnItmDO(CssdDfpClnItmDO[] dos) {
		setChildren(CssdDfpClnItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DfpclnAggDODesc desc = new DfpclnAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CssdDfpClnDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpp.dfpcln.d.CssdDfpClnItmDO")) {
             return new CssdDfpClnItmDO();
         }
         return null;
     }
}