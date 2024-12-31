package iih.hp.cp.sdele.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.hp.cp.sdele.d.HpCpSdElemDO;
import iih.hp.cp.sdele.d.HpCpSdElemRulePkgDO;
import iih.hp.cp.sdele.d.desc.HpCpSdElemRulePkgDODesc;

/**
 * 诊疗计划标准元素
 * @author
 *
 */
public class HpcpsdeleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public HpcpsdeleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HpCpSdElemDO.class);
        addChildren(HpCpSdElemRulePkgDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HpCpSdElemRulePkgDODesc.class).getFKAttrDesc());        
	  }	  
}