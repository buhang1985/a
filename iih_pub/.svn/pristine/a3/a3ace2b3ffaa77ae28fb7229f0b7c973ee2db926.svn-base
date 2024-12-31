package iih.nm.net.examchk.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.net.examchk.d.ExamChkDO;
import iih.nm.net.examchk.d.ExamChkPsnDO;
import iih.nm.net.examchk.d.desc.ExamChkPsnDODesc;
import iih.nm.net.examchk.d.ExamChkFlDO;
import iih.nm.net.examchk.d.desc.ExamChkFlDODesc;

/**
 * 护理人员考核
 * @author
 *
 */
public class ExamchkAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ExamchkAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExamChkDO.class);
        addChildren(ExamChkPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamChkPsnDODesc.class).getFKAttrDesc());        
        addChildren(ExamChkFlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamChkFlDODesc.class).getFKAttrDesc());        
	  }	  
}