package iih.nmr.pkuf.regformfordeliver.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.pkuf.regformfordeliver.d.desc.RegformfordeliverAggDODesc;



/**
 * 分娩登记表
 */
public class RegformfordeliverAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public RegformDO getParentDO() {
		return ((RegformDO) super.getParentDO());
	}

	public void setParentDO(RegformDO headDO) {
		setParent(headDO);
	}

	public RegmaterDO[] getRegmaterDO() {
		IBaseDO[] dos = getChildren(RegmaterDO.class);
		if(dos==null) return null;
		RegmaterDO[] result=new RegmaterDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(RegmaterDO)dos[i];
		}
		return result;
	}
	
	public void setRegmaterDO(RegmaterDO[] dos) {
		setChildren(RegmaterDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		RegformfordeliverAggDODesc desc = new RegformfordeliverAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new RegformDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.pkuf.regformfordeliver.d.RegmaterDO")) {
             return new RegmaterDO();
         }
         return null;
     }
}