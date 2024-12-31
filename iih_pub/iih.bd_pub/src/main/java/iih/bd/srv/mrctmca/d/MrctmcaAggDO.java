package iih.bd.srv.mrctmca.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrctmca.d.desc.MrctmcaAggDODesc;



/**
 * 医疗记录类型自定义分类
 */
public class MrctmcaAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrCtmCaDO getParentDO() {
		return ((MrCtmCaDO) super.getParentDO());
	}

	public void setParentDO(MrCtmCaDO headDO) {
		setParent(headDO);
	}

	public MrCaCtmItmDO[] getMrCaCtmItmDO() {
		IBaseDO[] dos = getChildren(MrCaCtmItmDO.class);
		if(dos==null) return null;
		MrCaCtmItmDO[] result=new MrCaCtmItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrCaCtmItmDO)dos[i];
		}
		return result;
	}
	
	public void setMrCaCtmItmDO(MrCaCtmItmDO[] dos) {
		setChildren(MrCaCtmItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrctmcaAggDODesc desc = new MrctmcaAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrCtmCaDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrctmca.d.MrCaCtmItmDO")) {
             return new MrCaCtmItmDO();
         }
         return null;
     }
}