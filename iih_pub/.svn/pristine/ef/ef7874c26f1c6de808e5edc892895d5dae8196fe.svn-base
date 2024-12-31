package iih.bd.pp.cust.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.cust.d.desc.CustAggDODesc;



/**
 * 付款客户
 */
public class CustAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CustCaDO getParentDO() {
		return ((CustCaDO) super.getParentDO());
	}

	public void setParentDO(CustCaDO headDO) {
		setParent(headDO);
	}

	public CustDO[] getCustDO() {
		IBaseDO[] dos = getChildren(CustDO.class);
		if(dos==null) return null;
		CustDO[] result=new CustDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CustDO)dos[i];
		}
		return result;
	}
	
	public void setCustDO(CustDO[] dos) {
		setChildren(CustDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CustAggDODesc desc = new CustAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CustCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.cust.d.CustDO")) {
             return new CustDO();
         }
         return null;
     }
}