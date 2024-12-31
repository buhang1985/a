package iih.bd.mm.supplierprotocol.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.mm.supplierprotocol.d.desc.SupplierprotocolAggDODesc;



/**
 * 供应商关系及协议
 */
public class SupplierprotocolAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SuppierProtocolDO getParentDO() {
		return ((SuppierProtocolDO) super.getParentDO());
	}

	public void setParentDO(SuppierProtocolDO headDO) {
		setParent(headDO);
	}

	public ProtocolGoodsDO[] getProtocolGoodsDO() {
		IBaseDO[] dos = getChildren(ProtocolGoodsDO.class);
		if(dos==null) return null;
		ProtocolGoodsDO[] result=new ProtocolGoodsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ProtocolGoodsDO)dos[i];
		}
		return result;
	}
	
	public void setProtocolGoodsDO(ProtocolGoodsDO[] dos) {
		setChildren(ProtocolGoodsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SupplierprotocolAggDODesc desc = new SupplierprotocolAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SuppierProtocolDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.mm.supplierprotocol.d.ProtocolGoodsDO")) {
             return new ProtocolGoodsDO();
         }
         return null;
     }
}