package iih.ci.mb.dcmo.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mb.dcmo.d.desc.DoctormemoAggDODesc;



/**
 * 医生备忘录
 */
public class DoctormemoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DoctorMemoDO getParentDO() {
		return ((DoctorMemoDO) super.getParentDO());
	}

	public void setParentDO(DoctorMemoDO headDO) {
		setParent(headDO);
	}

	public DoctorMemoFileDO[] getDoctorMemoFileDO() {
		IBaseDO[] dos = getChildren(DoctorMemoFileDO.class);
		if(dos==null) return null;
		DoctorMemoFileDO[] result=new DoctorMemoFileDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DoctorMemoFileDO)dos[i];
		}
		return result;
	}
	
	public void setDoctorMemoFileDO(DoctorMemoFileDO[] dos) {
		setChildren(DoctorMemoFileDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DoctormemoAggDODesc desc = new DoctormemoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DoctorMemoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mb.dcmo.d.DoctorMemoFileDO")) {
             return new DoctorMemoFileDO();
         }
         return null;
     }
}