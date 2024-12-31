package iih.nm.net.examchkpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.net.examchkpl.d.ExamChkPlDO;
import iih.nm.net.examchkpl.d.ExamChkPlPsnDO;
import iih.nm.net.examchkpl.d.desc.ExamChkPlPsnDODesc;

/**
 * 考核计划
 * @author
 *
 */
public class ExamchkplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ExamchkplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExamChkPlDO.class);
        addChildren(ExamChkPlPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamChkPlPsnDODesc.class).getFKAttrDesc());        
	  }	  
}