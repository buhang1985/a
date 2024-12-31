package iih.cssd.dpp.dfpcln.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.cssd.dpp.dfpcln.d.CssdDfpClnDO;
import iih.cssd.dpp.dfpcln.d.CssdDfpClnItmDO;
import iih.cssd.dpp.dfpcln.d.desc.CssdDfpClnItmDODesc;

/**
 * 消毒包清洗
 * @author
 *
 */
public class DfpclnAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DfpclnAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CssdDfpClnDO.class);
        addChildren(CssdDfpClnItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CssdDfpClnItmDODesc.class).getFKAttrDesc());        
	  }	  
}