package iih.ci.ord.ciaphvconsumables.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.ciaphvconsumables.d.desc.CiaphvconsumablesAggDODesc;



/**
 * 医嘱高值耗材申请 
 */
public class CiaphvconsumablesAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiApHvconsumblesDO getParentDO() {
		return ((CiApHvconsumblesDO) super.getParentDO());
	}

	public void setParentDO(CiApHvconsumblesDO headDO) {
		setParent(headDO);
	}

	public CiApHvconsumablesItmDO[] getCiApHvconsumablesItmDO() {
		IBaseDO[] dos = getChildren(CiApHvconsumablesItmDO.class);
		if(dos==null) return null;
		CiApHvconsumablesItmDO[] result=new CiApHvconsumablesItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiApHvconsumablesItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiApHvconsumablesItmDO(CiApHvconsumablesItmDO[] dos) {
		setChildren(CiApHvconsumablesItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiaphvconsumablesAggDODesc desc = new CiaphvconsumablesAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiApHvconsumblesDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.ciaphvconsumables.d.CiApHvconsumablesItmDO")) {
             return new CiApHvconsumablesItmDO();
         }
         return null;
     }
}