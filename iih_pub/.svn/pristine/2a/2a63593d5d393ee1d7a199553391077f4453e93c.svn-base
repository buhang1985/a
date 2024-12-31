package iih.nmr.ha.tcho.bgm.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.ha.tcho.bgm.d.desc.BgmAggDODesc;



/**
 * 血糖监测表
 */
public class BgmAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TchoBgmPatInfoDO getParentDO() {
		return ((TchoBgmPatInfoDO) super.getParentDO());
	}

	public void setParentDO(TchoBgmPatInfoDO headDO) {
		setParent(headDO);
	}

	public TchoBgmRecDO[] getTchoBgmRecDO() {
		IBaseDO[] dos = getChildren(TchoBgmRecDO.class);
		if(dos==null) return null;
		TchoBgmRecDO[] result=new TchoBgmRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TchoBgmRecDO)dos[i];
		}
		return result;
	}
	
	public void setTchoBgmRecDO(TchoBgmRecDO[] dos) {
		setChildren(TchoBgmRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BgmAggDODesc desc = new BgmAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TchoBgmPatInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.ha.tcho.bgm.d.TchoBgmRecDO")) {
             return new TchoBgmRecDO();
         }
         return null;
     }
}