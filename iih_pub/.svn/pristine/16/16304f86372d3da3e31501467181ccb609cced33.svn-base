package iih.ci.ord.app.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.app.d.CiAppBtSheetDO;
import iih.ci.ord.app.d.CiAppBtItemSheetDO;
import iih.ci.ord.app.d.desc.CiAppBtItemSheetDODesc;

/**
 * 备血打印申请单
 * @author
 *
 */
public class CiappbtsheetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CiappbtsheetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiAppBtSheetDO.class);
        addChildren(CiAppBtItemSheetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiAppBtItemSheetDODesc.class).getFKAttrDesc());        
	  }	  
}