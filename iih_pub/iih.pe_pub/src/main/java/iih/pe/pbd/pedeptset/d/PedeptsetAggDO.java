package iih.pe.pbd.pedeptset.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pbd.pedeptset.d.desc.PedeptsetAggDODesc;



/**
 * 体检科室设置
 */
public class PedeptsetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDeptSetDO getParentDO() {
		return ((PeDeptSetDO) super.getParentDO());
	}

	public void setParentDO(PeDeptSetDO headDO) {
		setParent(headDO);
	}

	public PeDeptSetSrvCaDO[] getPeDeptSetSrvCaDO() {
		IBaseDO[] dos = getChildren(PeDeptSetSrvCaDO.class);
		if(dos==null) return null;
		PeDeptSetSrvCaDO[] result=new PeDeptSetSrvCaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDeptSetSrvCaDO)dos[i];
		}
		return result;
	}
	
	public void setPeDeptSetSrvCaDO(PeDeptSetSrvCaDO[] dos) {
		setChildren(PeDeptSetSrvCaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PedeptsetAggDODesc desc = new PedeptsetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDeptSetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pbd.pedeptset.d.PeDeptSetSrvCaDO")) {
             return new PeDeptSetSrvCaDO();
         }
         return null;
     }
}