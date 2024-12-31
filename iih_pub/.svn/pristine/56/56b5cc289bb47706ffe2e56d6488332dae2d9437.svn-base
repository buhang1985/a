package iih.bd.srv.usageselfcaitm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.usageselfcaitm.d.desc.UsageselfcaitmAggDODesc;



/**
 * 用法自定义分类项目
 */
public class UsageselfcaitmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public UsageSelfCaItemDO getParentDO() {
		return ((UsageSelfCaItemDO) super.getParentDO());
	}

	public void setParentDO(UsageSelfCaItemDO headDO) {
		setParent(headDO);
	}

	public UsageSelfCaItmRelDO[] getUsageSelfCaItmRelDO() {
		IBaseDO[] dos = getChildren(UsageSelfCaItmRelDO.class);
		if(dos==null) return null;
		UsageSelfCaItmRelDO[] result=new UsageSelfCaItmRelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(UsageSelfCaItmRelDO)dos[i];
		}
		return result;
	}
	
	public void setUsageSelfCaItmRelDO(UsageSelfCaItmRelDO[] dos) {
		setChildren(UsageSelfCaItmRelDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		UsageselfcaitmAggDODesc desc = new UsageselfcaitmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new UsageSelfCaItemDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.usageselfcaitm.d.UsageSelfCaItmRelDO")) {
             return new UsageSelfCaItmRelDO();
         }
         return null;
     }
}