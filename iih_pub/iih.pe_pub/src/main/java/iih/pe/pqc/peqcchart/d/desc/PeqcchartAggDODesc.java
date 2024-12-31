package iih.pe.pqc.peqcchart.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqc.peqcchart.d.PeQcChartDO;
import iih.pe.pqc.peqcchart.d.PeQcChartItemDO;
import iih.pe.pqc.peqcchart.d.desc.PeQcChartItemDODesc;

/**
 * 体检质控图
 * @author
 *
 */
public class PeqcchartAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeqcchartAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeQcChartDO.class);
        addChildren(PeQcChartItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeQcChartItemDODesc.class).getFKAttrDesc());        
	  }	  
}