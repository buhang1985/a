package iih.mp.ot.deptmp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.ot.deptmp.d.MpOrPrTmpDO;
import iih.mp.ot.deptmp.d.MpOrPrTmpDtDO;
import iih.mp.ot.deptmp.d.desc.MpOrPrTmpDtDODesc;

/**
 * 通用医技科室模板
 * @author
 *
 */
public class DeptmpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DeptmpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpOrPrTmpDO.class);
        addChildren(MpOrPrTmpDtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpOrPrTmpDtDODesc.class).getFKAttrDesc());        
	  }	  
}