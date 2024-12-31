package iih.bd.srv.diagdef.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.diagdef.d.desc.DiagdefAggDODesc;



/**
 * 医疗服务_疾病诊断定义
 */
public class DiagdefAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DiagDefDO getParentDO() {
		return ((DiagDefDO) super.getParentDO());
	}

	public void setParentDO(DiagDefDO headDO) {
		setParent(headDO);
	}

	public DiagIndDO[] getDiagIndDO() {
		IBaseDO[] dos = getChildren(DiagIndDO.class);
		if(dos==null) return null;
		DiagIndDO[] result=new DiagIndDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DiagIndDO)dos[i];
		}
		return result;
	}
	
	public void setDiagIndDO(DiagIndDO[] dos) {
		setChildren(DiagIndDO.class, dos);
	}
	public DiagAliasDO[] getDiagAliasDO() {
		IBaseDO[] dos = getChildren(DiagAliasDO.class);
		if(dos==null) return null;
		DiagAliasDO[] result=new DiagAliasDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DiagAliasDO)dos[i];
		}
		return result;
	}
	
	public void setDiagAliasDO(DiagAliasDO[] dos) {
		setChildren(DiagAliasDO.class, dos);
	}
	public DiagCompDO[] getDiagCompDO() {
		IBaseDO[] dos = getChildren(DiagCompDO.class);
		if(dos==null) return null;
		DiagCompDO[] result=new DiagCompDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DiagCompDO)dos[i];
		}
		return result;
	}
	
	public void setDiagCompDO(DiagCompDO[] dos) {
		setChildren(DiagCompDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DiagdefAggDODesc desc = new DiagdefAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DiagDefDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.diagdef.d.DiagIndDO")) {
             return new DiagIndDO();
         }
	    else if (clzName.equals("iih.bd.srv.diagdef.d.DiagAliasDO")) {
             return new DiagAliasDO();
         }
	    else if (clzName.equals("iih.bd.srv.diagdef.d.DiagCompDO")) {
             return new DiagCompDO();
         }
         return null;
     }
}