package iih.nm.nit.nitsro.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nm.nit.nitsro.d.desc.NitsroAggDODesc;



/**
 * 护理管理_实习单位
 */
public class NitsroAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NitSroDO getParentDO() {
		return ((NitSroDO) super.getParentDO());
	}

	public void setParentDO(NitSroDO headDO) {
		setParent(headDO);
	}

	public NitSroBchDO[] getNitSroBchDO() {
		IBaseDO[] dos = getChildren(NitSroBchDO.class);
		if(dos==null) return null;
		NitSroBchDO[] result=new NitSroBchDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NitSroBchDO)dos[i];
		}
		return result;
	}
	
	public void setNitSroBchDO(NitSroBchDO[] dos) {
		setChildren(NitSroBchDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NitsroAggDODesc desc = new NitsroAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NitSroDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nm.nit.nitsro.d.NitSroBchDO")) {
             return new NitSroBchDO();
         }
         return null;
     }
}