package iih.pis.ivx.pisivxsrvmenu.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pis.ivx.pisivxsrvmenu.d.desc.PisivxsrvmenuAggDODesc;



/**
 * 服务号菜单
 */
public class PisivxsrvmenuAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PisIvxSrvMenuDO getParentDO() {
		return ((PisIvxSrvMenuDO) super.getParentDO());
	}

	public void setParentDO(PisIvxSrvMenuDO headDO) {
		setParent(headDO);
	}

	public PisIvxSrvMenuItmDO[] getPisIvxSrvMenuItmDO() {
		IBaseDO[] dos = getChildren(PisIvxSrvMenuItmDO.class);
		if(dos==null) return null;
		PisIvxSrvMenuItmDO[] result=new PisIvxSrvMenuItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisIvxSrvMenuItmDO)dos[i];
		}
		return result;
	}
	
	public void setPisIvxSrvMenuItmDO(PisIvxSrvMenuItmDO[] dos) {
		setChildren(PisIvxSrvMenuItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PisivxsrvmenuAggDODesc desc = new PisivxsrvmenuAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PisIvxSrvMenuDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pis.ivx.pisivxsrvmenu.d.PisIvxSrvMenuItmDO")) {
             return new PisIvxSrvMenuItmDO();
         }
         return null;
     }
}