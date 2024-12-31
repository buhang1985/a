package iih.bd.srv.srvreact.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.srvreact.d.desc.SrvreactAggDODesc;



/**
 * 服务互斥
 */
public class SrvreactAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SrvReactDO getParentDO() {
		return ((SrvReactDO) super.getParentDO());
	}

	public void setParentDO(SrvReactDO headDO) {
		setParent(headDO);
	}

	public SrvReactItemDO[] getSrvReactItemDO() {
		IBaseDO[] dos = getChildren(SrvReactItemDO.class);
		if(dos==null) return null;
		SrvReactItemDO[] result=new SrvReactItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvReactItemDO)dos[i];
		}
		return result;
	}
	
	public void setSrvReactItemDO(SrvReactItemDO[] dos) {
		setChildren(SrvReactItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvreactAggDODesc desc = new SrvreactAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SrvReactDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvreact.d.SrvReactItemDO")) {
             return new SrvReactItemDO();
         }
         return null;
     }
}