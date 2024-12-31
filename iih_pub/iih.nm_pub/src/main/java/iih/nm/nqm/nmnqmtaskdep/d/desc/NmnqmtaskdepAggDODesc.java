package iih.nm.nqm.nmnqmtaskdep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmtaskdep.d.NmNqmTaskDepDO;
import iih.nm.nqm.nmnqmtaskdep.d.NmNqmTaskDepmtplDO;
import iih.nm.nqm.nmnqmtaskdep.d.desc.NmNqmTaskDepmtplDODesc;
import iih.nm.nqm.nmnqmtaskdep.d.NmNqmTaskPsnDO;
import iih.nm.nqm.nmnqmtaskdep.d.desc.NmNqmTaskPsnDODesc;

/**
 * 护理管理_检查任务明细
 * @author
 *
 */
public class NmnqmtaskdepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmtaskdepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmTaskDepDO.class);
        addChildren(NmNqmTaskDepmtplDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmTaskDepmtplDODesc.class).getFKAttrDesc());        
        addChildren(NmNqmTaskPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmTaskPsnDODesc.class).getFKAttrDesc());        
	  }	  
}