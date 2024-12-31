package iih.bd.pp.baseprisrv.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.baseprisrv.d.desc.BaseprisrvAggDODesc;



/**
 * 价格服务
 */
public class BaseprisrvAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PriSrvDO getParentDO() {
		return ((PriSrvDO) super.getParentDO());
	}

	public void setParentDO(PriSrvDO headDO) {
		setParent(headDO);
	}

	public SrvPriDO[] getSrvPriDO() {
		IBaseDO[] dos = getChildren(SrvPriDO.class);
		if(dos==null) return null;
		SrvPriDO[] result=new SrvPriDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SrvPriDO)dos[i];
		}
		return result;
	}
	
	public void setSrvPriDO(SrvPriDO[] dos) {
		setChildren(SrvPriDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BaseprisrvAggDODesc desc = new BaseprisrvAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PriSrvDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.baseprisrv.d.SrvPriDO")) {
             return new SrvPriDO();
         }
         return null;
     }
}