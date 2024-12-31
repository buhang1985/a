package iih.nmr.ha.tcho.tchoillpatientcare.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.ha.tcho.tchoillpatientcare.d.TchoIllPatientDO;
import iih.nmr.ha.tcho.tchoillpatientcare.d.TchoIllPatientCareDO;
import iih.nmr.ha.tcho.tchoillpatientcare.d.desc.TchoIllPatientCareDODesc;

/**
 * 病危(病重)患者护理记录单
 * @author
 *
 */
public class TchoillpatientcareAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TchoillpatientcareAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(TchoIllPatientDO.class);
        addChildren(TchoIllPatientCareDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(TchoIllPatientCareDODesc.class).getFKAttrDesc());        
	  }	  
}