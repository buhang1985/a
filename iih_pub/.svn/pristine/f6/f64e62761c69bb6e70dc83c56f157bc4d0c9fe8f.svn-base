package iih.nmr.pkuf.nmrdocmobdg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.nmrdocmobdg.d.desc.NmrdocmobdgAggDODesc;



/**
 * 移动数据集新版
 */
public class NmrdocmobdgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmrDocMobdgDO getParentDO() {
		return ((NmrDocMobdgDO) super.getParentDO());
	}

	public void setParentDO(NmrDocMobdgDO headDO) {
		setParent(headDO);
	}

	public NmrDocMobdeDO[] getNmrDocMobdeDO() {
		IBaseDO[] dos = getChildren(NmrDocMobdeDO.class);
		if(dos==null) return null;
		NmrDocMobdeDO[] result=new NmrDocMobdeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrDocMobdeDO)dos[i];
		}
		return result;
	}
	
	public void setNmrDocMobdeDO(NmrDocMobdeDO[] dos) {
		setChildren(NmrDocMobdeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmrdocmobdgAggDODesc desc = new NmrdocmobdgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmrDocMobdgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.nmrdocmobdg.d.NmrDocMobdeDO")) {
             return new NmrDocMobdeDO();
         }
         return null;
     }
}