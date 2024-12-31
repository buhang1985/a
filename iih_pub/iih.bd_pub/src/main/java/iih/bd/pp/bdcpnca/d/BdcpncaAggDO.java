package iih.bd.pp.bdcpnca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.bdcpnca.d.desc.BdcpncaAggDODesc;



/**
 * 优惠劵_基础数据
 */
public class BdcpncaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BdCpncaDO getParentDO() {
		return ((BdCpncaDO) super.getParentDO());
	}

	public void setParentDO(BdCpncaDO headDO) {
		setParent(headDO);
	}

	public BdCpncaSrvDO[] getBdCpncaSrvDO() {
		IBaseDO[] dos = getChildren(BdCpncaSrvDO.class);
		if(dos==null) return null;
		BdCpncaSrvDO[] result=new BdCpncaSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdCpncaSrvDO)dos[i];
		}
		return result;
	}
	
	public void setBdCpncaSrvDO(BdCpncaSrvDO[] dos) {
		setChildren(BdCpncaSrvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BdcpncaAggDODesc desc = new BdcpncaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BdCpncaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.bdcpnca.d.BdCpncaSrvDO")) {
             return new BdCpncaSrvDO();
         }
         return null;
     }
}