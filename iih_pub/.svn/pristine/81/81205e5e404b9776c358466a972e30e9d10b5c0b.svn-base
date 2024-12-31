package iih.sfda.adbd.adbditmdoc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sfda.adbd.adbditmdoc.d.desc.AdbditmdocAggDODesc;



/**
 * 属性项目档案
 */
public class AdbditmdocAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AdbdItmdoclistDO getParentDO() {
		return ((AdbdItmdoclistDO) super.getParentDO());
	}

	public void setParentDO(AdbdItmdoclistDO headDO) {
		setParent(headDO);
	}

	public AdbdItmdocDO[] getAdbdItmdocDO() {
		IBaseDO[] dos = getChildren(AdbdItmdocDO.class);
		if(dos==null) return null;
		AdbdItmdocDO[] result=new AdbdItmdocDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AdbdItmdocDO)dos[i];
		}
		return result;
	}
	
	public void setAdbdItmdocDO(AdbdItmdocDO[] dos) {
		setChildren(AdbdItmdocDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AdbditmdocAggDODesc desc = new AdbditmdocAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AdbdItmdoclistDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sfda.adbd.adbditmdoc.d.AdbdItmdocDO")) {
             return new AdbdItmdocDO();
         }
         return null;
     }
}