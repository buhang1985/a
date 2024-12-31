package iih.mp.mpbd.patvstagt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.patvstagt.d.PatVsTagtDO;
import iih.mp.mpbd.patvstagt.d.PatVsTagtValDO;
import iih.mp.mpbd.patvstagt.d.desc.PatVsTagtValDODesc;
import iih.mp.mpbd.patvstagt.d.PatVsTagtTimeDO;
import iih.mp.mpbd.patvstagt.d.desc.PatVsTagtTimeDODesc;

/**
 * 患者体征采集指标
 * @author
 *
 */
public class PatvstagtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PatvstagtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PatVsTagtDO.class);
        addChildren(PatVsTagtValDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PatVsTagtValDODesc.class).getFKAttrDesc());        
        addChildren(PatVsTagtTimeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PatVsTagtTimeDODesc.class).getFKAttrDesc());        
	  }	  
}