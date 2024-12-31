package iih.mp.dg.manuprep.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.dg.manuprep.d.desc.ManuprepAggDODesc;



/**
 * 门诊后台摆药
 */
public class ManuprepAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MpDgPrepDO getParentDO() {
		return ((MpDgPrepDO) super.getParentDO());
	}

	public void setParentDO(MpDgPrepDO headDO) {
		setParent(headDO);
	}

	public MpDgPrepItemDO[] getMpDgPrepItemDO() {
		IBaseDO[] dos = getChildren(MpDgPrepItemDO.class);
		if(dos==null) return null;
		MpDgPrepItemDO[] result=new MpDgPrepItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MpDgPrepItemDO)dos[i];
		}
		return result;
	}
	
	public void setMpDgPrepItemDO(MpDgPrepItemDO[] dos) {
		setChildren(MpDgPrepItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ManuprepAggDODesc desc = new ManuprepAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MpDgPrepDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.dg.manuprep.d.MpDgPrepItemDO")) {
             return new MpDgPrepItemDO();
         }
         return null;
     }
}