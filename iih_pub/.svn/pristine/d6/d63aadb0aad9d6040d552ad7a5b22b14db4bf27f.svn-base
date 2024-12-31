package iih.hp.cp.appele.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.hp.cp.appele.d.desc.HpcpappeleAggDODesc;



/**
 * 诊疗计划应用_元素
 */
public class HpcpappeleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HpCpAppElemDO getParentDO() {
		return ((HpCpAppElemDO) super.getParentDO());
	}

	public void setParentDO(HpCpAppElemDO headDO) {
		setParent(headDO);
	}

	public HpCpAppElemStageDO[] getHpCpAppElemStageDO() {
		IBaseDO[] dos = getChildren(HpCpAppElemStageDO.class);
		if(dos==null) return null;
		HpCpAppElemStageDO[] result=new HpCpAppElemStageDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpAppElemStageDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpAppElemStageDO(HpCpAppElemStageDO[] dos) {
		setChildren(HpCpAppElemStageDO.class, dos);
	}
	public HpCpAppDiagRuleDO[] getHpCpAppDiagRuleDO() {
		IBaseDO[] dos = getChildren(HpCpAppDiagRuleDO.class);
		if(dos==null) return null;
		HpCpAppDiagRuleDO[] result=new HpCpAppDiagRuleDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpAppDiagRuleDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpAppDiagRuleDO(HpCpAppDiagRuleDO[] dos) {
		setChildren(HpCpAppDiagRuleDO.class, dos);
	}
	public HpCpAppElemOrderPkgDO[] getHpCpAppElemOrderPkgDO() {
		IBaseDO[] dos = getChildren(HpCpAppElemOrderPkgDO.class);
		if(dos==null) return null;
		HpCpAppElemOrderPkgDO[] result=new HpCpAppElemOrderPkgDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpAppElemOrderPkgDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpAppElemOrderPkgDO(HpCpAppElemOrderPkgDO[] dos) {
		setChildren(HpCpAppElemOrderPkgDO.class, dos);
	}
	public HpCpAppElemOrderDO[] getHpCpAppElemOrderDO() {
		IBaseDO[] dos = getChildren(HpCpAppElemOrderDO.class);
		if(dos==null) return null;
		HpCpAppElemOrderDO[] result=new HpCpAppElemOrderDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpAppElemOrderDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpAppElemOrderDO(HpCpAppElemOrderDO[] dos) {
		setChildren(HpCpAppElemOrderDO.class, dos);
	}
	public HpCpAppElemMrDO[] getHpCpAppElemMrDO() {
		IBaseDO[] dos = getChildren(HpCpAppElemMrDO.class);
		if(dos==null) return null;
		HpCpAppElemMrDO[] result=new HpCpAppElemMrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpCpAppElemMrDO)dos[i];
		}
		return result;
	}
	
	public void setHpCpAppElemMrDO(HpCpAppElemMrDO[] dos) {
		setChildren(HpCpAppElemMrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HpcpappeleAggDODesc desc = new HpcpappeleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HpCpAppElemDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.hp.cp.appele.d.HpCpAppElemStageDO")) {
             return new HpCpAppElemStageDO();
         }
	    else if (clzName.equals("iih.hp.cp.appele.d.HpCpAppDiagRuleDO")) {
             return new HpCpAppDiagRuleDO();
         }
	    else if (clzName.equals("iih.hp.cp.appele.d.HpCpAppElemOrderPkgDO")) {
             return new HpCpAppElemOrderPkgDO();
         }
	    else if (clzName.equals("iih.hp.cp.appele.d.HpCpAppElemOrderDO")) {
             return new HpCpAppElemOrderDO();
         }
	    else if (clzName.equals("iih.hp.cp.appele.d.HpCpAppElemMrDO")) {
             return new HpCpAppElemMrDO();
         }
         return null;
     }
}