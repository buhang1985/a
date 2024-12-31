package iih.mi.biz.mihptransact.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mi.biz.mihptransact.d.desc.MihptransactAggDODesc;



/**
 * 安徽医保交易记录
 */
public class MihptransactAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MiHpTransActDO getParentDO() {
		return ((MiHpTransActDO) super.getParentDO());
	}

	public void setParentDO(MiHpTransActDO headDO) {
		setParent(headDO);
	}

	public MiHpTransActItmDO[] getMiHpTransActItmDO() {
		IBaseDO[] dos = getChildren(MiHpTransActItmDO.class);
		if(dos==null) return null;
		MiHpTransActItmDO[] result=new MiHpTransActItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MiHpTransActItmDO)dos[i];
		}
		return result;
	}
	
	public void setMiHpTransActItmDO(MiHpTransActItmDO[] dos) {
		setChildren(MiHpTransActItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MihptransactAggDODesc desc = new MihptransactAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MiHpTransActDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mi.biz.mihptransact.d.MiHpTransActItmDO")) {
             return new MiHpTransActItmDO();
         }
         return null;
     }
}