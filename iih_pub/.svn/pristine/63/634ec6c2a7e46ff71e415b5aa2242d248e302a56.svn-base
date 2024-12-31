package iih.bd.fc.mdwfconfig.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.fc.mdwfconfig.d.desc.MdwfconfigAggDODesc;



/**
 * 组件
 */
public class MdwfconfigAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MdWfCaDO getParentDO() {
		return ((MdWfCaDO) super.getParentDO());
	}

	public void setParentDO(MdWfCaDO headDO) {
		setParent(headDO);
	}

	public MdWfDO[] getMdWfDO() {
		IBaseDO[] dos = getChildren(MdWfDO.class);
		if(dos==null) return null;
		MdWfDO[] result=new MdWfDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MdWfDO)dos[i];
		}
		return result;
	}
	
	public void setMdWfDO(MdWfDO[] dos) {
		setChildren(MdWfDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MdwfconfigAggDODesc desc = new MdwfconfigAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MdWfCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.fc.mdwfconfig.d.MdWfDO")) {
             return new MdWfDO();
         }
         return null;
     }
}