package iih.mi.mc.mimctactics.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mi.mc.mimctactics.d.desc.MimctacticsAggDODesc;



/**
 * 医保策略库
 */
public class MimctacticsAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MiMcTacticsDO getParentDO() {
		return ((MiMcTacticsDO) super.getParentDO());
	}

	public void setParentDO(MiMcTacticsDO headDO) {
		setParent(headDO);
	}

	public MiMcTacticsPara[] getMiMcTacticsPara() {
		IBaseDO[] dos = getChildren(MiMcTacticsPara.class);
		if(dos==null) return null;
		MiMcTacticsPara[] result=new MiMcTacticsPara[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MiMcTacticsPara)dos[i];
		}
		return result;
	}
	
	public void setMiMcTacticsPara(MiMcTacticsPara[] dos) {
		setChildren(MiMcTacticsPara.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MimctacticsAggDODesc desc = new MimctacticsAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MiMcTacticsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mi.mc.mimctactics.d.MiMcTacticsPara")) {
             return new MiMcTacticsPara();
         }
         return null;
     }
}