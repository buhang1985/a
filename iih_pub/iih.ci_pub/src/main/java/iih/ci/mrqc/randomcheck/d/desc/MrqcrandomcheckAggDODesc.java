package iih.ci.mrqc.randomcheck.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordItmDO;
import iih.ci.mrqc.randomcheck.d.desc.CiMrQcRandomRecordItmDODesc;

/**
 * 门诊病历抽查
 * @author
 *
 */
public class MrqcrandomcheckAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrqcrandomcheckAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrQcRandomRecordDO.class);
        addChildren(CiMrQcRandomRecordItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrQcRandomRecordItmDODesc.class).getFKAttrDesc());        
	  }	  
}