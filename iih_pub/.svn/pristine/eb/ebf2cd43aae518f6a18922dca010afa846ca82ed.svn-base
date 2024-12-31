package iih.mm.pl.departrequest.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mm.pl.departrequest.d.desc.DepartrequestAggDODesc;



/**
 * 部门领用申请
 */
public class DepartrequestAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DepartReqOrderDO getParentDO() {
		return ((DepartReqOrderDO) super.getParentDO());
	}

	public void setParentDO(DepartReqOrderDO headDO) {
		setParent(headDO);
	}

	public DepartReqItemDO[] getDepartReqItemDO() {
		IBaseDO[] dos = getChildren(DepartReqItemDO.class);
		if(dos==null) return null;
		DepartReqItemDO[] result=new DepartReqItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DepartReqItemDO)dos[i];
		}
		return result;
	}
	
	public void setDepartReqItemDO(DepartReqItemDO[] dos) {
		setChildren(DepartReqItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DepartrequestAggDODesc desc = new DepartrequestAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DepartReqOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mm.pl.departrequest.d.DepartReqItemDO")) {
             return new DepartReqItemDO();
         }
         return null;
     }
}