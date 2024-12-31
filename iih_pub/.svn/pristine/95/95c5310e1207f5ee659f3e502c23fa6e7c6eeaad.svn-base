package iih.sc.sch.scsch.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.sch.scsch.d.desc.ScschAggDODesc;



/**
 * 计划排班_排班
 */
public class ScschAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScSchDO getParentDO() {
		return ((ScSchDO) super.getParentDO());
	}

	public void setParentDO(ScSchDO headDO) {
		setParent(headDO);
	}

	public ScSchEmpDO[] getScSchEmpDO() {
		IBaseDO[] dos = getChildren(ScSchEmpDO.class);
		if(dos==null) return null;
		ScSchEmpDO[] result=new ScSchEmpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScSchEmpDO)dos[i];
		}
		return result;
	}
	
	public void setScSchEmpDO(ScSchEmpDO[] dos) {
		setChildren(ScSchEmpDO.class, dos);
	}
	public ScSchEnDO[] getScSchEnDO() {
		IBaseDO[] dos = getChildren(ScSchEnDO.class);
		if(dos==null) return null;
		ScSchEnDO[] result=new ScSchEnDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScSchEnDO)dos[i];
		}
		return result;
	}
	
	public void setScSchEnDO(ScSchEnDO[] dos) {
		setChildren(ScSchEnDO.class, dos);
	}
	public ScSchChlDO[] getScSchChlDO() {
		IBaseDO[] dos = getChildren(ScSchChlDO.class);
		if(dos==null) return null;
		ScSchChlDO[] result=new ScSchChlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScSchChlDO)dos[i];
		}
		return result;
	}
	
	public void setScSchChlDO(ScSchChlDO[] dos) {
		setChildren(ScSchChlDO.class, dos);
	}
	public ScSchOptsrvDO[] getScSchOptsrvDO() {
		IBaseDO[] dos = getChildren(ScSchOptsrvDO.class);
		if(dos==null) return null;
		ScSchOptsrvDO[] result=new ScSchOptsrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScSchOptsrvDO)dos[i];
		}
		return result;
	}
	
	public void setScSchOptsrvDO(ScSchOptsrvDO[] dos) {
		setChildren(ScSchOptsrvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScschAggDODesc desc = new ScschAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScSchDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.sch.scsch.d.ScSchEmpDO")) {
             return new ScSchEmpDO();
         }
	    else if (clzName.equals("iih.sc.sch.scsch.d.ScSchEnDO")) {
             return new ScSchEnDO();
         }
	    else if (clzName.equals("iih.sc.sch.scsch.d.ScSchChlDO")) {
             return new ScSchChlDO();
         }
	    else if (clzName.equals("iih.sc.sch.scsch.d.ScSchOptsrvDO")) {
             return new ScSchOptsrvDO();
         }
         return null;
     }
}