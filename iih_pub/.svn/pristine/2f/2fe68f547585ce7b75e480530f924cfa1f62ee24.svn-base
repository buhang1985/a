package iih.cssd.dpp.dfp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpp.dfp.d.CssdDfpDO;
import iih.cssd.dpp.dfp.d.CssdDfpMmDO;
import iih.cssd.dpp.dfp.d.desc.CssdDfpMmDODesc;
import iih.cssd.dpp.dfp.d.CssdDepstaDO;
import iih.cssd.dpp.dfp.d.desc.CssdDepstaDODesc;

/**
 * 消毒包生产
 * @author
 *
 */
public class DfpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DfpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CssdDfpDO.class);
        addChildren(CssdDfpMmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CssdDfpMmDODesc.class).getFKAttrDesc());        
        addChildren(CssdDepstaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CssdDepstaDODesc.class).getFKAttrDesc());        
	  }	  
}