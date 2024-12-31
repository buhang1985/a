package iih.ci.mr.cimracrecords.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.cimracrecords.d.desc.CimracrecordsAggDODesc;



/**
 * 产程数据记录
 */
public class CimracrecordsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrACBaseDO getParentDO() {
		return ((CiMrACBaseDO) super.getParentDO());
	}

	public void setParentDO(CiMrACBaseDO headDO) {
		setParent(headDO);
	}

	public CiMrACUCDO[] getCiMrACUCDO() {
		IBaseDO[] dos = getChildren(CiMrACUCDO.class);
		if(dos==null) return null;
		CiMrACUCDO[] result=new CiMrACUCDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrACUCDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrACUCDO(CiMrACUCDO[] dos) {
		setChildren(CiMrACUCDO.class, dos);
	}
	public CiMrACOtherDO[] getCiMrACOtherDO() {
		IBaseDO[] dos = getChildren(CiMrACOtherDO.class);
		if(dos==null) return null;
		CiMrACOtherDO[] result=new CiMrACOtherDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrACOtherDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrACOtherDO(CiMrACOtherDO[] dos) {
		setChildren(CiMrACOtherDO.class, dos);
	}
	public CiMrACFetus[] getCiMrACFetus() {
		IBaseDO[] dos = getChildren(CiMrACFetus.class);
		if(dos==null) return null;
		CiMrACFetus[] result=new CiMrACFetus[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrACFetus)dos[i];
		}
		return result;
	}
	
	public void setCiMrACFetus(CiMrACFetus[] dos) {
		setChildren(CiMrACFetus.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CimracrecordsAggDODesc desc = new CimracrecordsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrACBaseDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.cimracrecords.d.CiMrACUCDO")) {
             return new CiMrACUCDO();
         }
	    else if (clzName.equals("iih.ci.mr.cimracrecords.d.CiMrACOtherDO")) {
             return new CiMrACOtherDO();
         }
	    else if (clzName.equals("iih.ci.mr.cimracrecords.d.CiMrACFetus")) {
             return new CiMrACFetus();
         }
         return null;
     }
}