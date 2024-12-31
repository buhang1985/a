package iih.pe.pitm.peitflisitm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.peitflisitm.d.PeItfLisPartDO;
import iih.pe.pitm.peitflisitm.d.PeItfLisItmDO;
import iih.pe.pitm.peitflisitm.d.desc.PeItfLisItmDODesc;

/**
 * 体检接口_LIS明细
 * @author
 *
 */
public class PeitflisitmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeitflisitmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeItfLisPartDO.class);
        addChildren(PeItfLisItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeItfLisItmDODesc.class).getFKAttrDesc());        
	  }	  
}