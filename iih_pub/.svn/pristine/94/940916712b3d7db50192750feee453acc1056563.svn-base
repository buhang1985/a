package iih.pis.ivx.pisivxsetting.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingDO;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingTemplateDO;
import iih.pis.ivx.pisivxsetting.d.desc.PisIvxSettingTemplateDODesc;
import iih.pis.ivx.pisivxsetting.d.PisIvxSettingLocationDO;
import iih.pis.ivx.pisivxsetting.d.desc.PisIvxSettingLocationDODesc;
import iih.pis.ivx.pisivxsetting.d.PisivxTagsDO;
import iih.pis.ivx.pisivxsetting.d.desc.PisivxTagsDODesc;

/**
 * 微信服务-微信服务号配置
 * @author
 *
 */
public class PisivxsettingAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PisivxsettingAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PisIvxSettingDO.class);
        addChildren(PisIvxSettingTemplateDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisIvxSettingTemplateDODesc.class).getFKAttrDesc());        
        addChildren(PisIvxSettingLocationDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisIvxSettingLocationDODesc.class).getFKAttrDesc());        
        addChildren(PisivxTagsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisivxTagsDODesc.class).getFKAttrDesc());        
	  }	  
}