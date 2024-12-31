package iih.bd.srv.srvdc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.srvdc.d.desc.SrvdcAggDODesc;



/**
 * 医疗服务固定收费包
 */
public class SrvdcAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public FixedChargePkgDO getParentDO() {
		return ((FixedChargePkgDO) super.getParentDO());
	}

	public void setParentDO(FixedChargePkgDO headDO) {
		setParent(headDO);
	}

	public FixedChargePkgItmDO[] getFixedChargePkgItmDO() {
		IBaseDO[] dos = getChildren(FixedChargePkgItmDO.class);
		if(dos==null) return null;
		FixedChargePkgItmDO[] result=new FixedChargePkgItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(FixedChargePkgItmDO)dos[i];
		}
		return result;
	}
	
	public void setFixedChargePkgItmDO(FixedChargePkgItmDO[] dos) {
		setChildren(FixedChargePkgItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SrvdcAggDODesc desc = new SrvdcAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new FixedChargePkgDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.srvdc.d.FixedChargePkgItmDO")) {
             return new FixedChargePkgItmDO();
         }
         return null;
     }
}