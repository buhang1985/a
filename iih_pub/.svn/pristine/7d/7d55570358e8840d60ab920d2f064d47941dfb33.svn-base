package iih.bd.srv.outputtemplate.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.outputtemplate.d.OutputTemplateDO;
import iih.bd.srv.outputtemplate.d.OutputTemplateMedRedTypeDO;
import iih.bd.srv.outputtemplate.d.desc.OutputTemplateMedRedTypeDODesc;

/**
 * 输出模板
 * @author
 *
 */
public class OutputtemplateAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OutputtemplateAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OutputTemplateDO.class);
        addChildren(OutputTemplateMedRedTypeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OutputTemplateMedRedTypeDODesc.class).getFKAttrDesc());        
	  }	  
}