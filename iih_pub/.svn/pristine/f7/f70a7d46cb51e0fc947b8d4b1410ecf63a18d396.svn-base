package iih.en.pv.enfee.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.en.pv.enfee.d.desc.EnaccountAggDODesc;



/**
 * 患者就诊_就诊账户
 */
public class EnaccountAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EnAccountDO getParentDO() {
		return ((EnAccountDO) super.getParentDO());
	}

	public void setParentDO(EnAccountDO headDO) {
		setParent(headDO);
	}

	public EntAccActDO[] getEntAccActDO() {
		IBaseDO[] dos = getChildren(EntAccActDO.class);
		if(dos==null) return null;
		EntAccActDO[] result=new EntAccActDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(EntAccActDO)dos[i];
		}
		return result;
	}
	
	public void setEntAccActDO(EntAccActDO[] dos) {
		setChildren(EntAccActDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EnaccountAggDODesc desc = new EnaccountAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EnAccountDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.en.pv.enfee.d.EntAccActDO")) {
             return new EntAccActDO();
         }
         return null;
     }
}