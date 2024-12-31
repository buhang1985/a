package iih.nm.net.examtrapl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.net.examtrapl.d.ExamtraplDO;
import iih.nm.net.examtrapl.d.ExamtraplfileDo;
import iih.nm.net.examtrapl.d.desc.ExamtraplfileDoDesc;
import iih.nm.net.examtrapl.d.ExamtraplpsnDO;
import iih.nm.net.examtrapl.d.desc.ExamtraplpsnDODesc;

/**
 * 培训计划
 * @author
 *
 */
public class ExamtraplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ExamtraplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExamtraplDO.class);
        addChildren(ExamtraplfileDo.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamtraplfileDoDesc.class).getFKAttrDesc());        
        addChildren(ExamtraplpsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamtraplpsnDODesc.class).getFKAttrDesc());        
	  }	  
}