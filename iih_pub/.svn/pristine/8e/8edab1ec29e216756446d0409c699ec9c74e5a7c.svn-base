package iih.pe.pps.pecohort.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pps.pecohort.d.PeCohortDO;
import iih.pe.pps.pecohort.d.PeCohortPsnDO;
import iih.pe.pps.pecohort.d.desc.PeCohortPsnDODesc;

/**
 * 体检人群队列管理
 * @author
 *
 */
public class PecohortAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PecohortAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeCohortDO.class);
        addChildren(PeCohortPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeCohortPsnDODesc.class).getFKAttrDesc());        
	  }	  
}