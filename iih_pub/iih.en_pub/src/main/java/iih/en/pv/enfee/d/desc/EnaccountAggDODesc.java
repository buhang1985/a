package iih.en.pv.enfee.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.d.desc.EntAccActDODesc;

/**
 * 患者就诊_就诊账户
 * @author
 *
 */
public class EnaccountAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EnaccountAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EnAccountDO.class);
        addChildren(EntAccActDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EntAccActDODesc.class).getFKAttrDesc());        
	  }	  
}