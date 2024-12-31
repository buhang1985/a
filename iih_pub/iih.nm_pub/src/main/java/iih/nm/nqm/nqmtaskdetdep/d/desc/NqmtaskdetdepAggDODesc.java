package iih.nm.nqm.nqmtaskdetdep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nqmtaskdetdep.d.NqmTaskDetDepDO;
import iih.nm.nqm.nqmtaskdetdep.d.NqmTaskDetDepTmplDO;
import iih.nm.nqm.nqmtaskdetdep.d.desc.NqmTaskDetDepTmplDODesc;

/**
 * 质控任务明细科室
 * @author
 *
 */
public class NqmtaskdetdepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmtaskdetdepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NqmTaskDetDepDO.class);
        addChildren(NqmTaskDetDepTmplDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NqmTaskDetDepTmplDODesc.class).getFKAttrDesc());        
	  }	  
}