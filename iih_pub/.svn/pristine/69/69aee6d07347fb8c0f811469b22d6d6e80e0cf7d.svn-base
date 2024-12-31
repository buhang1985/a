package iih.mi.mc.mimcpatspec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mi.mc.mimcpatspec.d.desc.MimcpatspecdiAggDODesc;



/**
 * 医保特殊病患者维护
 */
public class MimcpatspecdiAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MiMcPatSpecDO getParentDO() {
		return ((MiMcPatSpecDO) super.getParentDO());
	}

	public void setParentDO(MiMcPatSpecDO headDO) {
		setParent(headDO);
	}

	public MiMcPatSpecDiDO[] getMiMcPatSpecDiDO() {
		IBaseDO[] dos = getChildren(MiMcPatSpecDiDO.class);
		if(dos==null) return null;
		MiMcPatSpecDiDO[] result=new MiMcPatSpecDiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MiMcPatSpecDiDO)dos[i];
		}
		return result;
	}
	
	public void setMiMcPatSpecDiDO(MiMcPatSpecDiDO[] dos) {
		setChildren(MiMcPatSpecDiDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MimcpatspecdiAggDODesc desc = new MimcpatspecdiAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MiMcPatSpecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO")) {
             return new MiMcPatSpecDiDO();
         }
         return null;
     }
}