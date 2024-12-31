package iih.nm.nqm.qctplelemaintenance.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.qctplelemaintenance.d.NmQctplEleDO;
import iih.nm.nqm.qctplelemaintenance.d.NmQctplEleItmDO;
import iih.nm.nqm.qctplelemaintenance.d.desc.NmQctplEleItmDODesc;
import iih.nm.nqm.qctplelemaintenance.d.NmQctplEleGrpDO;
import iih.nm.nqm.qctplelemaintenance.d.desc.NmQctplEleGrpDODesc;

/**
 * 质量模板元素
 * @author
 *
 */
public class QctplelemaintenanceAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public QctplelemaintenanceAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmQctplEleDO.class);
        addChildren(NmQctplEleItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmQctplEleItmDODesc.class).getFKAttrDesc());        
        addChildren(NmQctplEleGrpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmQctplEleGrpDODesc.class).getFKAttrDesc());        
	  }	  
}