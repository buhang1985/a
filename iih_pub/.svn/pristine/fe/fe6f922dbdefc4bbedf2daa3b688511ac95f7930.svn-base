package iih.nmr.pkuf.carecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.carecord.d.CarecorDO;
import iih.nmr.pkuf.carecord.d.OutputDO;
import iih.nmr.pkuf.carecord.d.desc.OutputDODesc;
import iih.nmr.pkuf.carecord.d.InputDO;
import iih.nmr.pkuf.carecord.d.desc.InputDODesc;

/**
 * 护理记录单
 * @author
 *
 */
public class Carecord1AggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public Carecord1AggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CarecorDO.class);
        addChildren(OutputDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OutputDODesc.class).getFKAttrDesc());        
        addChildren(InputDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InputDODesc.class).getFKAttrDesc());        
	  }	  
}