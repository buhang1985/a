package iih.pe.phm.persthra.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.persthra.d.PeRstHraDO;
import iih.pe.phm.persthra.d.PeRstHraRiskDO;
import iih.pe.phm.persthra.d.desc.PeRstHraRiskDODesc;

/**
 * 健康评估结果-单因素
 * @author
 *
 */
public class PersthraAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PersthraAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstHraDO.class);
        addChildren(PeRstHraRiskDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstHraRiskDODesc.class).getFKAttrDesc());        
	  }	  
}