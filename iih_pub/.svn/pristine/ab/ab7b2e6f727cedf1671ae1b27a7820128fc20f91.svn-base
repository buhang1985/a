package iih.pe.pps.perstslicemng.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pps.perstslicemng.d.PeRstSliceMngDO;
import iih.pe.pps.perstslicemng.d.PeRstSliceMngPsnDO;
import iih.pe.pps.perstslicemng.d.desc.PeRstSliceMngPsnDODesc;

/**
 * 体检重要结果分层管理
 * @author
 *
 */
public class PerstslicemngAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstslicemngAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstSliceMngDO.class);
        addChildren(PeRstSliceMngPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstSliceMngPsnDODesc.class).getFKAttrDesc());        
	  }	  
}