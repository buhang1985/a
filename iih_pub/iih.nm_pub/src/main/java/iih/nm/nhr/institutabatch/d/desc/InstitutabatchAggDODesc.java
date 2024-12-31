package iih.nm.nhr.institutabatch.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.institutabatch.d.NmStuOrgDO;
import iih.nm.nhr.institutabatch.d.NmBatchDO;
import iih.nm.nhr.institutabatch.d.desc.NmBatchDODesc;

/**
 * 院校批次管理
 * @author
 *
 */
public class InstitutabatchAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public InstitutabatchAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmStuOrgDO.class);
        addChildren(NmBatchDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmBatchDODesc.class).getFKAttrDesc());        
	  }	  
}