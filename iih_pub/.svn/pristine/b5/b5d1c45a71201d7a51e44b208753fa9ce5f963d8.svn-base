package iih.ci.mr.nu.bgm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.bgm.d.desc.BgmAggDODesc;



/**
 * 血糖监测表
 */
public class BgmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BgmPatInfoDO getParentDO() {
		return ((BgmPatInfoDO) super.getParentDO());
	}

	public void setParentDO(BgmPatInfoDO headDO) {
		setParent(headDO);
	}

	public BgmRecDO[] getBgmRecDO() {
		IBaseDO[] dos = getChildren(BgmRecDO.class);
		if(dos==null) return null;
		BgmRecDO[] result=new BgmRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BgmRecDO)dos[i];
		}
		return result;
	}
	
	public void setBgmRecDO(BgmRecDO[] dos) {
		setChildren(BgmRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BgmAggDODesc desc = new BgmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BgmPatInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.bgm.d.BgmRecDO")) {
             return new BgmRecDO();
         }
         return null;
     }
}