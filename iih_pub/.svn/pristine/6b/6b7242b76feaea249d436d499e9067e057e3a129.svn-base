package iih.mkr.std.deset.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mkr.std.deset.d.desc.DesetAggDODesc;



/**
 * 数据集
 */
public class DesetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DeDataSetDO getParentDO() {
		return ((DeDataSetDO) super.getParentDO());
	}

	public void setParentDO(DeDataSetDO headDO) {
		setParent(headDO);
	}

	public SetDgDO[] getSetDgDO() {
		IBaseDO[] dos = getChildren(SetDgDO.class);
		if(dos==null) return null;
		SetDgDO[] result=new SetDgDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SetDgDO)dos[i];
		}
		return result;
	}
	
	public void setSetDgDO(SetDgDO[] dos) {
		setChildren(SetDgDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DesetAggDODesc desc = new DesetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DeDataSetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mkr.std.deset.d.SetDgDO")) {
             return new SetDgDO();
         }
         return null;
     }
}