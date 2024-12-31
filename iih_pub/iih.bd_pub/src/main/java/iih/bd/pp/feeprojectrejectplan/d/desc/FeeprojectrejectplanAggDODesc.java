package iih.bd.pp.feeprojectrejectplan.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveMasterDO;
import iih.bd.pp.feeprojectrejectplan.d.ExclusiveDetailDO;
import iih.bd.pp.feeprojectrejectplan.d.desc.ExclusiveDetailDODesc;

/**
 * 收费项目排斥方案
 * @author
 *
 */
public class FeeprojectrejectplanAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public FeeprojectrejectplanAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ExclusiveMasterDO.class);
        addChildren(ExclusiveDetailDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ExclusiveDetailDODesc.class).getFKAttrDesc());        
	  }	  
}