package iih.nm.net.examappqu.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.net.examappqu.d.NmExamAppQuDO;
import iih.nm.net.examappqu.d.NmExamAppQuAnsDO;
import iih.nm.net.examappqu.d.desc.NmExamAppQuAnsDODesc;

/**
 * 人员考试题目
 * @author
 *
 */
public class ExamappquAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ExamappquAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmExamAppQuDO.class);
        addChildren(NmExamAppQuAnsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmExamAppQuAnsDODesc.class).getFKAttrDesc());        
	  }	  
}