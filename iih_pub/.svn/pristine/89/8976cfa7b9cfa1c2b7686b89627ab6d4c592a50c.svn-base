package iih.nm.net.exampp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.net.exampp.d.ExamppDO;
import iih.nm.net.exampp.d.ExamppSecDO;
import iih.nm.net.exampp.d.desc.ExamppSecDODesc;

/**
 * 试卷
 * @author
 *
 */
public class ExamppAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ExamppAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExamppDO.class);
        addChildren(ExamppSecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamppSecDODesc.class).getFKAttrDesc());        
	  }	  
}