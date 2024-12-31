package iih.pe.pqry.penhcposirpt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pqry.penhcposirpt.d.PeNhcPosiRptDO;
import iih.pe.pqry.penhcposirpt.d.PeNhcPosiListDO;
import iih.pe.pqry.penhcposirpt.d.desc.PeNhcPosiListDODesc;

/**
 * 体检上报报表_卫生局阳性统计
 * @author
 *
 */
public class PenhcposirptAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PenhcposirptAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeNhcPosiRptDO.class);
        addChildren(PeNhcPosiListDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeNhcPosiListDODesc.class).getFKAttrDesc());        
	  }	  
}