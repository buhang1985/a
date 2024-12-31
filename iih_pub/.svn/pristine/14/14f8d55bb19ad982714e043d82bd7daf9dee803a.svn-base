package iih.sc.scp.aidset.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scp.aidset.d.ScPlanAidSetDO;
import iih.sc.scp.aidset.d.ScPlanAidSetDtlDO;
import iih.sc.scp.aidset.d.desc.ScPlanAidSetDtlDODesc;

/**
 * 辅助样本设置
 * @author
 *
 */
public class ScplanaidsetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScplanaidsetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScPlanAidSetDO.class);
        addChildren(ScPlanAidSetDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScPlanAidSetDtlDODesc.class).getFKAttrDesc());        
	  }	  
}