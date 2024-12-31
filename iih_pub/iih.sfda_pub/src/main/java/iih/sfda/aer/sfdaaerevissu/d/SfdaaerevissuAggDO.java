package iih.sfda.aer.sfdaaerevissu.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.sfda.aer.sfdaaerevissu.d.desc.SfdaaerevissuAggDODesc;



/**
 * 不良报告_整改问题
 */
public class SfdaaerevissuAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SfdaAerEvIssuDO getParentDO() {
		return ((SfdaAerEvIssuDO) super.getParentDO());
	}

	public void setParentDO(SfdaAerEvIssuDO headDO) {
		setParent(headDO);
	}

	public SfdaAerEvIssuMsDO[] getSfdaAerEvIssuMsDO() {
		IBaseDO[] dos = getChildren(SfdaAerEvIssuMsDO.class);
		if(dos==null) return null;
		SfdaAerEvIssuMsDO[] result=new SfdaAerEvIssuMsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SfdaAerEvIssuMsDO)dos[i];
		}
		return result;
	}
	
	public void setSfdaAerEvIssuMsDO(SfdaAerEvIssuMsDO[] dos) {
		setChildren(SfdaAerEvIssuMsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SfdaaerevissuAggDODesc desc = new SfdaaerevissuAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SfdaAerEvIssuDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.sfda.aer.sfdaaerevissu.d.SfdaAerEvIssuMsDO")) {
             return new SfdaAerEvIssuMsDO();
         }
         return null;
     }
}