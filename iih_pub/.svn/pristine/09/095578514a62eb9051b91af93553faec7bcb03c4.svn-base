package iih.ci.ord.app.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.d.desc.CiAppRisSheetOrDODesc;

/**
 * 检查打印申请单
 * @author
 *
 */
public class CiapprissheetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiapprissheetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiAppRisSheetDO.class);
        addChildren(CiAppRisSheetOrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiAppRisSheetOrDODesc.class).getFKAttrDesc());        
	  }	  
}