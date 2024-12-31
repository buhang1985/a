package iih.pe.pitm.perstdidef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pitm.perstdidef.d.desc.PerstdidefAggDODesc;



/**
 * 体检诊断定义
 */
public class PerstdidefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeRstDiDefDO getParentDO() {
		return ((PeRstDiDefDO) super.getParentDO());
	}

	public void setParentDO(PeRstDiDefDO headDO) {
		setParent(headDO);
	}

	public PeDiagSuggDO[] getPeDiagSuggDO() {
		IBaseDO[] dos = getChildren(PeDiagSuggDO.class);
		if(dos==null) return null;
		PeDiagSuggDO[] result=new PeDiagSuggDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiagSuggDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiagSuggDO(PeDiagSuggDO[] dos) {
		setChildren(PeDiagSuggDO.class, dos);
	}
	public PeDiagSuppDO[] getPeDiagSuppDO() {
		IBaseDO[] dos = getChildren(PeDiagSuppDO.class);
		if(dos==null) return null;
		PeDiagSuppDO[] result=new PeDiagSuppDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiagSuppDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiagSuppDO(PeDiagSuppDO[] dos) {
		setChildren(PeDiagSuppDO.class, dos);
	}
	public PeDiagDocDO[] getPeDiagDocDO() {
		IBaseDO[] dos = getChildren(PeDiagDocDO.class);
		if(dos==null) return null;
		PeDiagDocDO[] result=new PeDiagDocDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDiagDocDO)dos[i];
		}
		return result;
	}
	
	public void setPeDiagDocDO(PeDiagDocDO[] dos) {
		setChildren(PeDiagDocDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerstdidefAggDODesc desc = new PerstdidefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeRstDiDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pitm.perstdidef.d.PeDiagSuggDO")) {
             return new PeDiagSuggDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perstdidef.d.PeDiagSuppDO")) {
             return new PeDiagSuppDO();
         }
	    else if (clzName.equals("iih.pe.pitm.perstdidef.d.PeDiagDocDO")) {
             return new PeDiagDocDO();
         }
         return null;
     }
}