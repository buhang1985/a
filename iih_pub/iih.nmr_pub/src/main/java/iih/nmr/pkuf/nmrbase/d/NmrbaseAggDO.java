package iih.nmr.pkuf.nmrbase.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.nmrbase.d.desc.NmrbaseAggDODesc;



/**
 * 文书属性信息
 */
public class NmrbaseAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NmrBaseDO getParentDO() {
		return ((NmrBaseDO) super.getParentDO());
	}

	public void setParentDO(NmrBaseDO headDO) {
		setParent(headDO);
	}

	public NmrBaseAttrDO[] getNmrBaseAttrDO() {
		IBaseDO[] dos = getChildren(NmrBaseAttrDO.class);
		if(dos==null) return null;
		NmrBaseAttrDO[] result=new NmrBaseAttrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NmrBaseAttrDO)dos[i];
		}
		return result;
	}
	
	public void setNmrBaseAttrDO(NmrBaseAttrDO[] dos) {
		setChildren(NmrBaseAttrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NmrbaseAggDODesc desc = new NmrbaseAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NmrBaseDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.nmrbase.d.NmrBaseAttrDO")) {
             return new NmrBaseAttrDO();
         }
         return null;
     }
}