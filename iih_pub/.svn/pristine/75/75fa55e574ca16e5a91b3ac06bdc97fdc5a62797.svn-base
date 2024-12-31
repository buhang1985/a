package iih.sfda.adbd.abdbconfig.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sfda.adbd.abdbconfig.d.desc.AbdbconfigAggDODesc;



/**
 * 事件处理流程配置
 */
public class AbdbconfigAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AdbdConfigDO getParentDO() {
		return ((AdbdConfigDO) super.getParentDO());
	}

	public void setParentDO(AdbdConfigDO headDO) {
		setParent(headDO);
	}

	public AdbdConfigItmDO[] getAdbdConfigItmDO() {
		IBaseDO[] dos = getChildren(AdbdConfigItmDO.class);
		if(dos==null) return null;
		AdbdConfigItmDO[] result=new AdbdConfigItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AdbdConfigItmDO)dos[i];
		}
		return result;
	}
	
	public void setAdbdConfigItmDO(AdbdConfigItmDO[] dos) {
		setChildren(AdbdConfigItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AbdbconfigAggDODesc desc = new AbdbconfigAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AdbdConfigDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sfda.adbd.abdbconfig.d.AdbdConfigItmDO")) {
             return new AdbdConfigItmDO();
         }
         return null;
     }
}