package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.pv.inpatient.d.desc.EnipntAggDODesc;



/**
 * 入院通知单
 */
public class EnipntAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EntIpntDO getParentDO() {
		return ((EntIpntDO) super.getParentDO());
	}

	public void setParentDO(EntIpntDO headDO) {
		setParent(headDO);
	}

	public EntIpntSrvDO[] getEntIpntSrvDO() {
		IBaseDO[] dos = getChildren(EntIpntSrvDO.class);
		if(dos==null) return null;
		EntIpntSrvDO[] result=new EntIpntSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EntIpntSrvDO)dos[i];
		}
		return result;
	}
	
	public void setEntIpntSrvDO(EntIpntSrvDO[] dos) {
		setChildren(EntIpntSrvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EnipntAggDODesc desc = new EnipntAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EntIpntDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.pv.inpatient.d.EntIpntSrvDO")) {
             return new EntIpntSrvDO();
         }
         return null;
     }
}