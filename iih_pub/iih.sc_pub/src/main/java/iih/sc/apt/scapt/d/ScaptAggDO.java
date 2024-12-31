package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.apt.scapt.d.desc.ScaptAggDODesc;



/**
 * 计划排班_预约
 */
public class ScaptAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ScAptDO getParentDO() {
		return ((ScAptDO) super.getParentDO());
	}

	public void setParentDO(ScAptDO headDO) {
		setParent(headDO);
	}

	public ScAptMtDO[] getScAptMtDO() {
		IBaseDO[] dos = getChildren(ScAptMtDO.class);
		if(dos==null) return null;
		ScAptMtDO[] result=new ScAptMtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScAptMtDO)dos[i];
		}
		return result;
	}
	
	public void setScAptMtDO(ScAptMtDO[] dos) {
		setChildren(ScAptMtDO.class, dos);
	}
	public ScAptOpDO[] getScAptOpDO() {
		IBaseDO[] dos = getChildren(ScAptOpDO.class);
		if(dos==null) return null;
		ScAptOpDO[] result=new ScAptOpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScAptOpDO)dos[i];
		}
		return result;
	}
	
	public void setScAptOpDO(ScAptOpDO[] dos) {
		setChildren(ScAptOpDO.class, dos);
	}
	public ScAptOptDO[] getScAptOptDO() {
		IBaseDO[] dos = getChildren(ScAptOptDO.class);
		if(dos==null) return null;
		ScAptOptDO[] result=new ScAptOptDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ScAptOptDO)dos[i];
		}
		return result;
	}
	
	public void setScAptOptDO(ScAptOptDO[] dos) {
		setChildren(ScAptOptDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ScaptAggDODesc desc = new ScaptAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ScAptDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.apt.scapt.d.ScAptMtDO")) {
             return new ScAptMtDO();
         }
	    else if (clzName.equals("iih.sc.apt.scapt.d.ScAptOpDO")) {
             return new ScAptOpDO();
         }
	    else if (clzName.equals("iih.sc.apt.scapt.d.ScAptOptDO")) {
             return new ScAptOptDO();
         }
         return null;
     }
}