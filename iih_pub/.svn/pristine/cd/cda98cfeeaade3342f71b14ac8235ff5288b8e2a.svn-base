package iih.nm.nhr.nhrsched.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nhrsched.d.NhrSchedDO;
import iih.nm.nhr.nhrsched.d.NhrSchedStuDO;
import iih.nm.nhr.nhrsched.d.desc.NhrSchedStuDODesc;
import iih.nm.nhr.nhrsched.d.NhrSchedBedDO;
import iih.nm.nhr.nhrsched.d.desc.NhrSchedBedDODesc;

/**
 * 人员排班
 * @author
 *
 */
public class NhrschedAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NhrschedAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NhrSchedDO.class);
        addChildren(NhrSchedStuDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NhrSchedStuDODesc.class).getFKAttrDesc());        
        addChildren(NhrSchedBedDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NhrSchedBedDODesc.class).getFKAttrDesc());        
	  }	  
}