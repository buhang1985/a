package iih.nm.net.examnurtra.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.net.examnurtra.d.ExamNurtraDO;
import iih.nm.net.examnurtra.d.ExamNurtrPsnDO;
import iih.nm.net.examnurtra.d.desc.ExamNurtrPsnDODesc;

/**
 * 护理人员培训
 * @author
 *
 */
public class ExamnurtraAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ExamnurtraAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExamNurtraDO.class);
        addChildren(ExamNurtrPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExamNurtrPsnDODesc.class).getFKAttrDesc());        
	  }	  
}