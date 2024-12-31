package iih.pe.phm.persticvd.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.persticvd.d.PeRstIcvdDO;
import iih.pe.phm.persticvd.d.PeRstIcvdRiskDO;
import iih.pe.phm.persticvd.d.desc.PeRstIcvdRiskDODesc;

/**
 * 健康管理_缺血性冠心病评估结果
 * @author
 *
 */
public class PersticvdAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PersticvdAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstIcvdDO.class);
        addChildren(PeRstIcvdRiskDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstIcvdRiskDODesc.class).getFKAttrDesc());        
	  }	  
}