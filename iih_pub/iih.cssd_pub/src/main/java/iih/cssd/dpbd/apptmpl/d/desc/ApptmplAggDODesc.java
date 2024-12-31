package iih.cssd.dpbd.apptmpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpbd.apptmpl.d.DfpAppTmplDO;
import iih.cssd.dpbd.apptmpl.d.DfpAppTmplItmDO;
import iih.cssd.dpbd.apptmpl.d.desc.DfpAppTmplItmDODesc;

/**
 * 消毒包科室请领模板
 * @author
 *
 */
public class ApptmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ApptmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DfpAppTmplDO.class);
        addChildren(DfpAppTmplItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DfpAppTmplItmDODesc.class).getFKAttrDesc());        
	  }	  
}