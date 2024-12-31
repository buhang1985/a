package iih.pe.pds.pedsdiag.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pds.pedsdiag.d.PeDsDiagDefDO;
import iih.pe.pds.pedsdiag.d.PeDsDiagDO;
import iih.pe.pds.pedsdiag.d.desc.PeDsDiagDODesc;

/**
 * 体检诊断决策支持
 * @author
 *
 */
public class PedsdiagAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PedsdiagAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDsDiagDefDO.class);
        addChildren(PeDsDiagDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDsDiagDODesc.class).getFKAttrDesc());        
	  }	  
}