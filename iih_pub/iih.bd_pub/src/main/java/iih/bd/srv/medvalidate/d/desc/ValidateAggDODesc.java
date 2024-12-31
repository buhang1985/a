package iih.bd.srv.medvalidate.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.medvalidate.d.BDErrorInfoDO;
import iih.bd.srv.medvalidate.d.BDErrorInfoItemDO;
import iih.bd.srv.medvalidate.d.desc.BDErrorInfoItemDODesc;

/**
 * 组件
 * @author
 *
 */
public class ValidateAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ValidateAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BDErrorInfoDO.class);
        addChildren(BDErrorInfoItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BDErrorInfoItemDODesc.class).getFKAttrDesc());        
	  }	  
}