package iih.sc.apt.aptip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sc.apt.aptip.d.desc.AptipAggDODesc;



/**
 * 住院预约
 */
public class AptipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AptIpDO getParentDO() {
		return ((AptIpDO) super.getParentDO());
	}

	public void setParentDO(AptIpDO headDO) {
		setParent(headDO);
	}

	public AptIpAttrDO[] getAptIpAttrDO() {
		IBaseDO[] dos = getChildren(AptIpAttrDO.class);
		if(dos==null) return null;
		AptIpAttrDO[] result=new AptIpAttrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AptIpAttrDO)dos[i];
		}
		return result;
	}
	
	public void setAptIpAttrDO(AptIpAttrDO[] dos) {
		setChildren(AptIpAttrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AptipAggDODesc desc = new AptipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AptIpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sc.apt.aptip.d.AptIpAttrDO")) {
             return new AptIpAttrDO();
         }
         return null;
     }
}