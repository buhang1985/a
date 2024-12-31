package iih.pe.pds.pedsdeptime.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pds.pedsdeptime.d.PeDsDeptimeDO;
import iih.pe.pds.pedsdeptime.d.PeDsDeptimeChkDO;
import iih.pe.pds.pedsdeptime.d.desc.PeDsDeptimeChkDODesc;

/**
 * 体检科室检查时间优化
 * @author
 *
 */
public class PedsdeptimeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PedsdeptimeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDsDeptimeDO.class);
        addChildren(PeDsDeptimeChkDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDsDeptimeChkDODesc.class).getFKAttrDesc());        
	  }	  
}