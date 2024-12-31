package iih.sc.scbd.scdeptparam.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDsDODesc;

/**
 * 排班科室参数
 * @author
 *
 */
public class ScdeptparamAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScdeptparamAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScDeptParamDO.class);
        addChildren(ScDeptParamDsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScDeptParamDsDODesc.class).getFKAttrDesc());        
	  }	  
}