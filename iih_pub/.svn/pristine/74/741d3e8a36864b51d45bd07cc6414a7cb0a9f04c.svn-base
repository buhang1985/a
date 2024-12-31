package iih.mp.mpbd.kb.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.kb.d.desc.KbAggDODesc;



/**
 * 移动键盘
 */
public class KbAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public KbDO getParentDO() {
		return ((KbDO) super.getParentDO());
	}

	public void setParentDO(KbDO headDO) {
		setParent(headDO);
	}

	public KbItemDO[] getKbItemDO() {
		IBaseDO[] dos = getChildren(KbItemDO.class);
		if(dos==null) return null;
		KbItemDO[] result=new KbItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(KbItemDO)dos[i];
		}
		return result;
	}
	
	public void setKbItemDO(KbItemDO[] dos) {
		setChildren(KbItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		KbAggDODesc desc = new KbAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new KbDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.kb.d.KbItemDO")) {
             return new KbItemDO();
         }
         return null;
     }
}