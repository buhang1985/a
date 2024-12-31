package iih.nm.nqm.nmnqmtask.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmtask.d.NmNqmTaskDO;
import iih.nm.nqm.nmnqmtask.d.NmNqmTaskActorDO;
import iih.nm.nqm.nmnqmtask.d.desc.NmNqmTaskActorDODesc;
import iih.nm.nqm.nmnqmtask.d.NqmTaskDetDO;
import iih.nm.nqm.nmnqmtask.d.desc.NqmTaskDetDODesc;

/**
 * 护理管理_检查任务
 * @author
 *
 */
public class NqmtaskAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmtaskAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmTaskDO.class);
        addChildren(NmNqmTaskActorDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmTaskActorDODesc.class).getFKAttrDesc());        
        addChildren(NqmTaskDetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmTaskDetDODesc.class).getFKAttrDesc());        
	  }	  
}