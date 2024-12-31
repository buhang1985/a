package iih.pe.pbd.pedeptset.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pbd.pedeptset.d.PeDeptSetDO;
import iih.pe.pbd.pedeptset.d.PeDeptSetSrvCaDO;
import iih.pe.pbd.pedeptset.d.desc.PeDeptSetSrvCaDODesc;

/**
 * 体检科室设置
 * @author
 *
 */
public class PedeptsetAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PedeptsetAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDeptSetDO.class);
        addChildren(PeDeptSetSrvCaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDeptSetSrvCaDODesc.class).getFKAttrDesc());        
	  }	  
}