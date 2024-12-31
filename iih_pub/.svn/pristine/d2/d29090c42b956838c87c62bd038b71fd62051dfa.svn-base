package iih.bd.srv.deptsrvlimit.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.deptsrvlimit.d.desc.DeptsrvlimitAggDODesc;



/**
 * 科室服务白黑名单
 */
public class DeptsrvlimitAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DeptSrvLimitDO getParentDO() {
		return ((DeptSrvLimitDO) super.getParentDO());
	}

	public void setParentDO(DeptSrvLimitDO headDO) {
		setParent(headDO);
	}

	public DeptSrvLimitItemDO[] getDeptSrvLimitItemDO() {
		IBaseDO[] dos = getChildren(DeptSrvLimitItemDO.class);
		if(dos==null) return null;
		DeptSrvLimitItemDO[] result=new DeptSrvLimitItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DeptSrvLimitItemDO)dos[i];
		}
		return result;
	}
	
	public void setDeptSrvLimitItemDO(DeptSrvLimitItemDO[] dos) {
		setChildren(DeptSrvLimitItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DeptsrvlimitAggDODesc desc = new DeptsrvlimitAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DeptSrvLimitDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.deptsrvlimit.d.DeptSrvLimitItemDO")) {
             return new DeptSrvLimitItemDO();
         }
         return null;
     }
}