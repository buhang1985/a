package iih.ci.mr.nu.intervopre.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.intervopre.d.desc.IntervopreAggDODesc;



/**
 * 介入手术护理记录单
 */
public class IntervopreAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public InterPatInfoDO getParentDO() {
		return ((InterPatInfoDO) super.getParentDO());
	}

	public void setParentDO(InterPatInfoDO headDO) {
		setParent(headDO);
	}

	public InterObjPreDO[] getInterObjPreDO() {
		IBaseDO[] dos = getChildren(InterObjPreDO.class);
		if(dos==null) return null;
		InterObjPreDO[] result=new InterObjPreDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InterObjPreDO)dos[i];
		}
		return result;
	}
	
	public void setInterObjPreDO(InterObjPreDO[] dos) {
		setChildren(InterObjPreDO.class, dos);
	}
	public InterOperInfoDO[] getInterOperInfoDO() {
		IBaseDO[] dos = getChildren(InterOperInfoDO.class);
		if(dos==null) return null;
		InterOperInfoDO[] result=new InterOperInfoDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(InterOperInfoDO)dos[i];
		}
		return result;
	}
	
	public void setInterOperInfoDO(InterOperInfoDO[] dos) {
		setChildren(InterOperInfoDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		IntervopreAggDODesc desc = new IntervopreAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new InterPatInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.intervopre.d.InterObjPreDO")) {
             return new InterObjPreDO();
         }
	    else if (clzName.equals("iih.ci.mr.nu.intervopre.d.InterOperInfoDO")) {
             return new InterOperInfoDO();
         }
         return null;
     }
}