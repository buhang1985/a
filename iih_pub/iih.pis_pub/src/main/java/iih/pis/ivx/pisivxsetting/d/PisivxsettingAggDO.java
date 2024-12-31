package iih.pis.ivx.pisivxsetting.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pis.ivx.pisivxsetting.d.desc.PisivxsettingAggDODesc;



/**
 * 微信服务-微信服务号配置
 */
public class PisivxsettingAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PisIvxSettingDO getParentDO() {
		return ((PisIvxSettingDO) super.getParentDO());
	}

	public void setParentDO(PisIvxSettingDO headDO) {
		setParent(headDO);
	}

	public PisIvxSettingTemplateDO[] getPisIvxSettingTemplateDO() {
		IBaseDO[] dos = getChildren(PisIvxSettingTemplateDO.class);
		if(dos==null) return null;
		PisIvxSettingTemplateDO[] result=new PisIvxSettingTemplateDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisIvxSettingTemplateDO)dos[i];
		}
		return result;
	}
	
	public void setPisIvxSettingTemplateDO(PisIvxSettingTemplateDO[] dos) {
		setChildren(PisIvxSettingTemplateDO.class, dos);
	}
	public PisIvxSettingLocationDO[] getPisIvxSettingLocationDO() {
		IBaseDO[] dos = getChildren(PisIvxSettingLocationDO.class);
		if(dos==null) return null;
		PisIvxSettingLocationDO[] result=new PisIvxSettingLocationDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisIvxSettingLocationDO)dos[i];
		}
		return result;
	}
	
	public void setPisIvxSettingLocationDO(PisIvxSettingLocationDO[] dos) {
		setChildren(PisIvxSettingLocationDO.class, dos);
	}
	public PisivxTagsDO[] getPisivxTagsDO() {
		IBaseDO[] dos = getChildren(PisivxTagsDO.class);
		if(dos==null) return null;
		PisivxTagsDO[] result=new PisivxTagsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PisivxTagsDO)dos[i];
		}
		return result;
	}
	
	public void setPisivxTagsDO(PisivxTagsDO[] dos) {
		setChildren(PisivxTagsDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PisivxsettingAggDODesc desc = new PisivxsettingAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PisIvxSettingDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pis.ivx.pisivxsetting.d.PisIvxSettingTemplateDO")) {
             return new PisIvxSettingTemplateDO();
         }
	    else if (clzName.equals("iih.pis.ivx.pisivxsetting.d.PisIvxSettingLocationDO")) {
             return new PisIvxSettingLocationDO();
         }
	    else if (clzName.equals("iih.pis.ivx.pisivxsetting.d.PisivxTagsDO")) {
             return new PisivxTagsDO();
         }
         return null;
     }
}