package iih.bl.hp.hptransactahip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bl.hp.hptransactahip.d.desc.HptransactahipAggDODesc;



/**
 * 安徽医保住院
 */
public class HptransactahipAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HpTransActAhIpDO getParentDO() {
		return ((HpTransActAhIpDO) super.getParentDO());
	}

	public void setParentDO(HpTransActAhIpDO headDO) {
		setParent(headDO);
	}

	public HpTransActItmAhIpDO[] getHpTransActItmAhIpDO() {
		IBaseDO[] dos = getChildren(HpTransActItmAhIpDO.class);
		if(dos==null) return null;
		HpTransActItmAhIpDO[] result=new HpTransActItmAhIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HpTransActItmAhIpDO)dos[i];
		}
		return result;
	}
	
	public void setHpTransActItmAhIpDO(HpTransActItmAhIpDO[] dos) {
		setChildren(HpTransActItmAhIpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HptransactahipAggDODesc desc = new HptransactahipAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HpTransActAhIpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.hp.hptransactahip.d.HpTransActItmAhIpDO")) {
             return new HpTransActItmAhIpDO();
         }
         return null;
     }
}