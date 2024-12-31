package iih.mi.biz.mihptransact.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mi.biz.mihptransact.d.MiHpTransActDO;
import iih.mi.biz.mihptransact.d.MiHpTransActItmDO;
import iih.mi.biz.mihptransact.d.desc.MiHpTransActItmDODesc;

/**
 * 安徽医保交易记录
 * @author
 *
 */
public class MihptransactAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MihptransactAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MiHpTransActDO.class);
        addChildren(MiHpTransActItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MiHpTransActItmDODesc.class).getFKAttrDesc());        
	  }	  
}