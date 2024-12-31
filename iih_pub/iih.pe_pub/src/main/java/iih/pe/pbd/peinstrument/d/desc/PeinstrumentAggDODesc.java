package iih.pe.pbd.peinstrument.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pbd.peinstrument.d.PeInstrumentDO;
import iih.pe.pbd.peinstrument.d.PeInstItmRelDefDO;
import iih.pe.pbd.peinstrument.d.desc.PeInstItmRelDefDODesc;

/**
 * 仪器设备定义
 * @author
 *
 */
public class PeinstrumentAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeinstrumentAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeInstrumentDO.class);
        addChildren(PeInstItmRelDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeInstItmRelDefDODesc.class).getFKAttrDesc());        
	  }	  
}