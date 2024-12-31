package iih.nmr.ha.tcho.ipevalsigle.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.ha.tcho.ipevalsigle.d.TchoEvaluateDO;
import iih.nmr.ha.tcho.ipevalsigle.d.TchoEvaluateItmDO;
import iih.nmr.ha.tcho.ipevalsigle.d.desc.TchoEvaluateItmDODesc;

/**
 * 住院患者评价单
 * @author
 *
 */
public class TchoipevalsigleAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TchoipevalsigleAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TchoEvaluateDO.class);
        addChildren(TchoEvaluateItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TchoEvaluateItmDODesc.class).getFKAttrDesc());        
	  }	  
}