package iih.mkr.ms.mscacust.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mkr.ms.mscacust.d.desc.MscacustAggDODesc;



/**
 * 组套自定义分类
 */
public class MscacustAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MkrMscaCtmDO getParentDO() {
		return ((MkrMscaCtmDO) super.getParentDO());
	}

	public void setParentDO(MkrMscaCtmDO headDO) {
		setParent(headDO);
	}

	public MkrMscaCtmMsDO[] getMkrMscaCtmMsDO() {
		IBaseDO[] dos = getChildren(MkrMscaCtmMsDO.class);
		if(dos==null) return null;
		MkrMscaCtmMsDO[] result=new MkrMscaCtmMsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MkrMscaCtmMsDO)dos[i];
		}
		return result;
	}
	
	public void setMkrMscaCtmMsDO(MkrMscaCtmMsDO[] dos) {
		setChildren(MkrMscaCtmMsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MscacustAggDODesc desc = new MscacustAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MkrMscaCtmDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mkr.ms.mscacust.d.MkrMscaCtmMsDO")) {
             return new MkrMscaCtmMsDO();
         }
         return null;
     }
}