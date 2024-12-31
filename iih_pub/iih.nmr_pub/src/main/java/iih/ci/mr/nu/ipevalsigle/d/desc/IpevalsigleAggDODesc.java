package iih.ci.mr.nu.ipevalsigle.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.ipevalsigle.d.EvaluateDO;
import iih.ci.mr.nu.ipevalsigle.d.EvaluateItmDO;
import iih.ci.mr.nu.ipevalsigle.d.desc.EvaluateItmDODesc;

/**
 * 住院患者评价单
 * @author
 *
 */
public class IpevalsigleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public IpevalsigleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EvaluateDO.class);
        addChildren(EvaluateItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EvaluateItmDODesc.class).getFKAttrDesc());        
	  }	  
}