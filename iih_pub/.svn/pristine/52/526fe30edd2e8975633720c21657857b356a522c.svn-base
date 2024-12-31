package iih.bd.pp.feeprojectrejectplan.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.feeprojectrejectplan.d.desc.FeeprojectrejectplanAggDODesc;



/**
 * 收费项目排斥方案
 */
public class FeeprojectrejectplanAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ExclusiveMasterDO getParentDO() {
		return ((ExclusiveMasterDO) super.getParentDO());
	}

	public void setParentDO(ExclusiveMasterDO headDO) {
		setParent(headDO);
	}

	public ExclusiveDetailDO[] getExclusiveDetailDO() {
		IBaseDO[] dos = getChildren(ExclusiveDetailDO.class);
		if(dos==null) return null;
		ExclusiveDetailDO[] result=new ExclusiveDetailDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ExclusiveDetailDO)dos[i];
		}
		return result;
	}
	
	public void setExclusiveDetailDO(ExclusiveDetailDO[] dos) {
		setChildren(ExclusiveDetailDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		FeeprojectrejectplanAggDODesc desc = new FeeprojectrejectplanAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ExclusiveMasterDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.feeprojectrejectplan.d.ExclusiveDetailDO")) {
             return new ExclusiveDetailDO();
         }
         return null;
     }
}