package iih.cssd.dpbd.apptmpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.cssd.dpbd.apptmpl.d.desc.ApptmplAggDODesc;



/**
 * 消毒包科室请领模板
 */
public class ApptmplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DfpAppTmplDO getParentDO() {
		return ((DfpAppTmplDO) super.getParentDO());
	}

	public void setParentDO(DfpAppTmplDO headDO) {
		setParent(headDO);
	}

	public DfpAppTmplItmDO[] getDfpAppTmplItmDO() {
		IBaseDO[] dos = getChildren(DfpAppTmplItmDO.class);
		if(dos==null) return null;
		DfpAppTmplItmDO[] result=new DfpAppTmplItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DfpAppTmplItmDO)dos[i];
		}
		return result;
	}
	
	public void setDfpAppTmplItmDO(DfpAppTmplItmDO[] dos) {
		setChildren(DfpAppTmplItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ApptmplAggDODesc desc = new ApptmplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DfpAppTmplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.cssd.dpbd.apptmpl.d.DfpAppTmplItmDO")) {
             return new DfpAppTmplItmDO();
         }
         return null;
     }
}