package iih.pe.pwf.perstdiagsugg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pwf.perstdiagsugg.d.desc.PerstdiagsuggAggDODesc;



/**
 * 体检结果诊断建议
 */
public class PerstdiagsuggAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstDiagSuggDO getParentDO() {
		return ((PeRstDiagSuggDO) super.getParentDO());
	}

	public void setParentDO(PeRstDiagSuggDO headDO) {
		setParent(headDO);
	}

	public PeRstDiDO[] getPeRstDiDO() {
		IBaseDO[] dos = getChildren(PeRstDiDO.class);
		if(dos==null) return null;
		PeRstDiDO[] result=new PeRstDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstDiDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstDiDO(PeRstDiDO[] dos) {
		setChildren(PeRstDiDO.class, dos);
	}
	public PeRstSuggDO[] getPeRstSuggDO() {
		IBaseDO[] dos = getChildren(PeRstSuggDO.class);
		if(dos==null) return null;
		PeRstSuggDO[] result=new PeRstSuggDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeRstSuggDO)dos[i];
		}
		return result;
	}
	
	public void setPeRstSuggDO(PeRstSuggDO[] dos) {
		setChildren(PeRstSuggDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstdiagsuggAggDODesc desc = new PerstdiagsuggAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstDiagSuggDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.perstdiagsugg.d.PeRstDiDO")) {
             return new PeRstDiDO();
         }
	    else if (clzName.equals("iih.pe.pwf.perstdiagsugg.d.PeRstSuggDO")) {
             return new PeRstSuggDO();
         }
         return null;
     }
}