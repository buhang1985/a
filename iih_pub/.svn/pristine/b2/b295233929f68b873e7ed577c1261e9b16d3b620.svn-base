package iih.ci.mrqc.mrconnotationqc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcDO;
import iih.ci.mrqc.mrconnotationqc.d.MrConnotationQcItmDO;
import iih.ci.mrqc.mrconnotationqc.d.desc.MrConnotationQcItmDODesc;

/**
 * mrconnotationqcdo
 * @author
 *
 */
public class MrconnotationqcAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrconnotationqcAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrConnotationQcDO.class);
        addChildren(MrConnotationQcItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrConnotationQcItmDODesc.class).getFKAttrDesc());        
	  }	  
}