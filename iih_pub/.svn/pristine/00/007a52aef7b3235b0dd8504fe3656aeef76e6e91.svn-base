package iih.ci.ord.cirptlabhis.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.cirptlabhis.d.CiRptLabHISDO;
import iih.ci.ord.cirptlabhis.d.CiRptLabItmHISDO;
import iih.ci.ord.cirptlabhis.d.desc.CiRptLabItmHISDODesc;

/**
 * 检验报告单历史
 * @author
 *
 */
public class CirptlabhisAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public CirptlabhisAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiRptLabHISDO.class);
        addChildren(CiRptLabItmHISDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiRptLabItmHISDODesc.class).getFKAttrDesc());        
	  }	  
}