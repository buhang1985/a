package iih.nm.net.examqu.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.net.examqu.d.ExamQuDO;
import iih.nm.net.examqu.d.ExamQuAnsDO;
import iih.nm.net.examqu.d.desc.ExamQuAnsDODesc;

/**
 * 试题
 * @author
 *
 */
public class ExamquAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ExamquAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExamQuDO.class);
        addChildren(ExamQuAnsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamQuAnsDODesc.class).getFKAttrDesc());        
	  }	  
}