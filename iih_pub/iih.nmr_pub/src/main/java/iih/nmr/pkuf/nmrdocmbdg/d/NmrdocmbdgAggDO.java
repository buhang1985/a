package iih.nmr.pkuf.nmrdocmbdg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.nmrdocmbdg.d.desc.NmrdocmbdgAggDODesc;



/**
 * 文书_移动_数据组
 */
public class NmrdocmbdgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmrDocMbdgDO getParentDO() {
		return ((NmrDocMbdgDO) super.getParentDO());
	}

	public void setParentDO(NmrDocMbdgDO headDO) {
		setParent(headDO);
	}

	public NmrDocMbdeDO[] getNmrDocMbdeDO() {
		IBaseDO[] dos = getChildren(NmrDocMbdeDO.class);
		if(dos==null) return null;
		NmrDocMbdeDO[] result=new NmrDocMbdeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrDocMbdeDO)dos[i];
		}
		return result;
	}
	
	public void setNmrDocMbdeDO(NmrDocMbdeDO[] dos) {
		setChildren(NmrDocMbdeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmrdocmbdgAggDODesc desc = new NmrdocmbdgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmrDocMbdgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.nmrdocmbdg.d.NmrDocMbdeDO")) {
             return new NmrDocMbdeDO();
         }
         return null;
     }
}