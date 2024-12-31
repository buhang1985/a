package iih.mkr.ms.mkrms.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mkr.ms.mkrms.d.desc.MkrmsAggDODesc;



/**
 * 组套定义
 */
public class MkrmsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MkrMsDO getParentDO() {
		return ((MkrMsDO) super.getParentDO());
	}

	public void setParentDO(MkrMsDO headDO) {
		setParent(headDO);
	}

	public MkrMsSrvDO[] getMkrMsSrvDO() {
		IBaseDO[] dos = getChildren(MkrMsSrvDO.class);
		if(dos==null) return null;
		MkrMsSrvDO[] result=new MkrMsSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MkrMsSrvDO)dos[i];
		}
		return result;
	}
	
	public void setMkrMsSrvDO(MkrMsSrvDO[] dos) {
		setChildren(MkrMsSrvDO.class, dos);
	}
	public MkrMsOrtpl[] getMkrMsOrtpl() {
		IBaseDO[] dos = getChildren(MkrMsOrtpl.class);
		if(dos==null) return null;
		MkrMsOrtpl[] result=new MkrMsOrtpl[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MkrMsOrtpl)dos[i];
		}
		return result;
	}
	
	public void setMkrMsOrtpl(MkrMsOrtpl[] dos) {
		setChildren(MkrMsOrtpl.class, dos);
	}
	public MkrMsMrtplDO[] getMkrMsMrtplDO() {
		IBaseDO[] dos = getChildren(MkrMsMrtplDO.class);
		if(dos==null) return null;
		MkrMsMrtplDO[] result=new MkrMsMrtplDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MkrMsMrtplDO)dos[i];
		}
		return result;
	}
	
	public void setMkrMsMrtplDO(MkrMsMrtplDO[] dos) {
		setChildren(MkrMsMrtplDO.class, dos);
	}
	public MkrMsDiDO[] getMkrMsDiDO() {
		IBaseDO[] dos = getChildren(MkrMsDiDO.class);
		if(dos==null) return null;
		MkrMsDiDO[] result=new MkrMsDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MkrMsDiDO)dos[i];
		}
		return result;
	}
	
	public void setMkrMsDiDO(MkrMsDiDO[] dos) {
		setChildren(MkrMsDiDO.class, dos);
	}
	public MkrMsEnblDeptDO[] getMkrMsEnblDeptDO() {
		IBaseDO[] dos = getChildren(MkrMsEnblDeptDO.class);
		if(dos==null) return null;
		MkrMsEnblDeptDO[] result=new MkrMsEnblDeptDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MkrMsEnblDeptDO)dos[i];
		}
		return result;
	}
	
	public void setMkrMsEnblDeptDO(MkrMsEnblDeptDO[] dos) {
		setChildren(MkrMsEnblDeptDO.class, dos);
	}
	public MkrMsEnblEntpDO[] getMkrMsEnblEntpDO() {
		IBaseDO[] dos = getChildren(MkrMsEnblEntpDO.class);
		if(dos==null) return null;
		MkrMsEnblEntpDO[] result=new MkrMsEnblEntpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MkrMsEnblEntpDO)dos[i];
		}
		return result;
	}
	
	public void setMkrMsEnblEntpDO(MkrMsEnblEntpDO[] dos) {
		setChildren(MkrMsEnblEntpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MkrmsAggDODesc desc = new MkrmsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MkrMsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mkr.ms.mkrms.d.MkrMsSrvDO")) {
             return new MkrMsSrvDO();
         }
	    else if (clzName.equals("iih.mkr.ms.mkrms.d.MkrMsOrtpl")) {
             return new MkrMsOrtpl();
         }
	    else if (clzName.equals("iih.mkr.ms.mkrms.d.MkrMsMrtplDO")) {
             return new MkrMsMrtplDO();
         }
	    else if (clzName.equals("iih.mkr.ms.mkrms.d.MkrMsDiDO")) {
             return new MkrMsDiDO();
         }
	    else if (clzName.equals("iih.mkr.ms.mkrms.d.MkrMsEnblDeptDO")) {
             return new MkrMsEnblDeptDO();
         }
	    else if (clzName.equals("iih.mkr.ms.mkrms.d.MkrMsEnblEntpDO")) {
             return new MkrMsEnblEntpDO();
         }
         return null;
     }
}