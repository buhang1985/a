package iih.pe.phm.pehmlifestyle.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.pehmlifestyle.d.PeHmLifestyleDO;
import iih.pe.phm.pehmlifestyle.d.PeHmLifestyleDtlDO;
import iih.pe.phm.pehmlifestyle.d.desc.PeHmLifestyleDtlDODesc;

/**
 * 健康生活方式评估
 * @author
 *
 */
public class PehmlifestyleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PehmlifestyleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeHmLifestyleDO.class);
        addChildren(PeHmLifestyleDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeHmLifestyleDtlDODesc.class).getFKAttrDesc());        
	  }	  
}