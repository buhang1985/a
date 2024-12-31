package iih.nmr.pkuf.nmrdoc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.nmrdoc.d.desc.NmrdocAggDODesc;



/**
 * 文书基本信息
 */
public class NmrdocAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmrDocDO getParentDO() {
		return ((NmrDocDO) super.getParentDO());
	}

	public void setParentDO(NmrDocDO headDO) {
		setParent(headDO);
	}

	public NmrDocAttrDO[] getNmrDocAttrDO() {
		IBaseDO[] dos = getChildren(NmrDocAttrDO.class);
		if(dos==null) return null;
		NmrDocAttrDO[] result=new NmrDocAttrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrDocAttrDO)dos[i];
		}
		return result;
	}
	
	public void setNmrDocAttrDO(NmrDocAttrDO[] dos) {
		setChildren(NmrDocAttrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmrdocAggDODesc desc = new NmrdocAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmrDocDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.nmrdoc.d.NmrDocAttrDO")) {
             return new NmrDocAttrDO();
         }
         return null;
     }
}