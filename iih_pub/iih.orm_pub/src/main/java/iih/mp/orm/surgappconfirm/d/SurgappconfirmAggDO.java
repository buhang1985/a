package iih.mp.orm.surgappconfirm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.orm.surgappconfirm.d.desc.SurgappconfirmAggDODesc;



/**
 * 手术申请单确认
 */
public class SurgappconfirmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SurgAppConfirmDO getParentDO() {
		return ((SurgAppConfirmDO) super.getParentDO());
	}

	public void setParentDO(SurgAppConfirmDO headDO) {
		setParent(headDO);
	}

	public SurgAppEmpConfDO[] getSurgAppEmpConfDO() {
		IBaseDO[] dos = getChildren(SurgAppEmpConfDO.class);
		if(dos==null) return null;
		SurgAppEmpConfDO[] result=new SurgAppEmpConfDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SurgAppEmpConfDO)dos[i];
		}
		return result;
	}
	
	public void setSurgAppEmpConfDO(SurgAppEmpConfDO[] dos) {
		setChildren(SurgAppEmpConfDO.class, dos);
	}
	public SurgMmConfDO[] getSurgMmConfDO() {
		IBaseDO[] dos = getChildren(SurgMmConfDO.class);
		if(dos==null) return null;
		SurgMmConfDO[] result=new SurgMmConfDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SurgMmConfDO)dos[i];
		}
		return result;
	}
	
	public void setSurgMmConfDO(SurgMmConfDO[] dos) {
		setChildren(SurgMmConfDO.class, dos);
	}
	public SurgSrvConfDO[] getSurgSrvConfDO() {
		IBaseDO[] dos = getChildren(SurgSrvConfDO.class);
		if(dos==null) return null;
		SurgSrvConfDO[] result=new SurgSrvConfDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SurgSrvConfDO)dos[i];
		}
		return result;
	}
	
	public void setSurgSrvConfDO(SurgSrvConfDO[] dos) {
		setChildren(SurgSrvConfDO.class, dos);
	}
	public SurgImConfDO[] getSurgImConfDO() {
		IBaseDO[] dos = getChildren(SurgImConfDO.class);
		if(dos==null) return null;
		SurgImConfDO[] result=new SurgImConfDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SurgImConfDO)dos[i];
		}
		return result;
	}
	
	public void setSurgImConfDO(SurgImConfDO[] dos) {
		setChildren(SurgImConfDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SurgappconfirmAggDODesc desc = new SurgappconfirmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SurgAppConfirmDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.orm.surgappconfirm.d.SurgAppEmpConfDO")) {
             return new SurgAppEmpConfDO();
         }
	    else if (clzName.equals("iih.mp.orm.surgappconfirm.d.SurgMmConfDO")) {
             return new SurgMmConfDO();
         }
	    else if (clzName.equals("iih.mp.orm.surgappconfirm.d.SurgSrvConfDO")) {
             return new SurgSrvConfDO();
         }
	    else if (clzName.equals("iih.mp.orm.surgappconfirm.d.SurgImConfDO")) {
             return new SurgImConfDO();
         }
         return null;
     }
}