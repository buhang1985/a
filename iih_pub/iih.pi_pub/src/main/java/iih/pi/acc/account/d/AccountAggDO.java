package iih.pi.acc.account.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pi.acc.account.d.desc.AccountAggDODesc;



/**
 * 患者账户
 */
public class AccountAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PiPatAccDO getParentDO() {
		return ((PiPatAccDO) super.getParentDO());
	}

	public void setParentDO(PiPatAccDO headDO) {
		setParent(headDO);
	}

	public PiPatAccActDO[] getPiPatAccActDO() {
		IBaseDO[] dos = getChildren(PiPatAccActDO.class);
		if(dos==null) return null;
		PiPatAccActDO[] result=new PiPatAccActDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PiPatAccActDO)dos[i];
		}
		return result;
	}
	
	public void setPiPatAccActDO(PiPatAccActDO[] dos) {
		setChildren(PiPatAccActDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AccountAggDODesc desc = new AccountAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PiPatAccDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pi.acc.account.d.PiPatAccActDO")) {
             return new PiPatAccActDO();
         }
         return null;
     }
}