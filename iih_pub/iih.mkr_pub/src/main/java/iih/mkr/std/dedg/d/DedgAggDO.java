package iih.mkr.std.dedg.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mkr.std.dedg.d.desc.DedgAggDODesc;



/**
 * 数据组
 */
public class DedgAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DeDataGrpDO getParentDO() {
		return ((DeDataGrpDO) super.getParentDO());
	}

	public void setParentDO(DeDataGrpDO headDO) {
		setParent(headDO);
	}

	public DgDeDO[] getDgDeDO() {
		IBaseDO[] dos = getChildren(DgDeDO.class);
		if(dos==null) return null;
		DgDeDO[] result=new DgDeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DgDeDO)dos[i];
		}
		return result;
	}
	
	public void setDgDeDO(DgDeDO[] dos) {
		setChildren(DgDeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DedgAggDODesc desc = new DedgAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DeDataGrpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mkr.std.dedg.d.DgDeDO")) {
             return new DgDeDO();
         }
         return null;
     }
}