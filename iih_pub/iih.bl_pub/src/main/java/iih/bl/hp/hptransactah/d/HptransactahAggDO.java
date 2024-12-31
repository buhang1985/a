package iih.bl.hp.hptransactah.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.hp.hptransactah.d.desc.HptransactahAggDODesc;



/**
 * 安徽医保交易记录
 */
public class HptransactahAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HpTransActAhDO getParentDO() {
		return ((HpTransActAhDO) super.getParentDO());
	}

	public void setParentDO(HpTransActAhDO headDO) {
		setParent(headDO);
	}

	public HpTransActItmAhDO[] getHpTransActItmAhDO() {
		IBaseDO[] dos = getChildren(HpTransActItmAhDO.class);
		if(dos==null) return null;
		HpTransActItmAhDO[] result=new HpTransActItmAhDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpTransActItmAhDO)dos[i];
		}
		return result;
	}
	
	public void setHpTransActItmAhDO(HpTransActItmAhDO[] dos) {
		setChildren(HpTransActItmAhDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HptransactahAggDODesc desc = new HptransactahAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HpTransActAhDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.hp.hptransactah.d.HpTransActItmAhDO")) {
             return new HpTransActItmAhDO();
         }
         return null;
     }
}