package iih.ci.mr.nu.ccupatcarerec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.ccupatcarerec.d.desc.CcupatcarerecAggDODesc;



/**
 * 组件
 */
public class CcupatcarerecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CcuPatrecDO getParentDO() {
		return ((CcuPatrecDO) super.getParentDO());
	}

	public void setParentDO(CcuPatrecDO headDO) {
		setParent(headDO);
	}

	public CcupatcarerecDO[] getCcupatcarerecDO() {
		IBaseDO[] dos = getChildren(CcupatcarerecDO.class);
		if(dos==null) return null;
		CcupatcarerecDO[] result=new CcupatcarerecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CcupatcarerecDO)dos[i];
		}
		return result;
	}
	
	public void setCcupatcarerecDO(CcupatcarerecDO[] dos) {
		setChildren(CcupatcarerecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CcupatcarerecAggDODesc desc = new CcupatcarerecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CcuPatrecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.ccupatcarerec.d.CcupatcarerecDO")) {
             return new CcupatcarerecDO();
         }
         return null;
     }
}