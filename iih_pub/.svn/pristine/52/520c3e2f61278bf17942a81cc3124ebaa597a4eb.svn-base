package iih.nmr.ha.tcho.sugeryip.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.ha.tcho.sugeryip.d.TchoSurgeryPatInfoDO;
import iih.nmr.ha.tcho.sugeryip.d.TchoSurgeryIpDO;
import iih.nmr.ha.tcho.sugeryip.d.desc.TchoSurgeryIpDODesc;

/**
 * 外科住院患者护理记录单
 * @author
 *
 */
public class Surgeryip1AggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public Surgeryip1AggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TchoSurgeryPatInfoDO.class);
        addChildren(TchoSurgeryIpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TchoSurgeryIpDODesc.class).getFKAttrDesc());        
	  }	  
}