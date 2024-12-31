package iih.bd.srv.mrelement.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrelement.d.desc.BdmrdeAggDODesc;



/**
 * 病历元素
 */
public class BdmrdeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrElementDO getParentDO() {
		return ((MrElementDO) super.getParentDO());
	}

	public void setParentDO(MrElementDO headDO) {
		setParent(headDO);
	}

	public MrEleValDO[] getMrEleValDO() {
		IBaseDO[] dos = getChildren(MrEleValDO.class);
		if(dos==null) return null;
		MrEleValDO[] result=new MrEleValDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrEleValDO)dos[i];
		}
		return result;
	}
	
	public void setMrEleValDO(MrEleValDO[] dos) {
		setChildren(MrEleValDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BdmrdeAggDODesc desc = new BdmrdeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrElementDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrelement.d.MrEleValDO")) {
             return new MrEleValDO();
         }
         return null;
     }
}