package iih.bd.srv.mrwp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrwp.d.MrWritePowerDO;
import iih.bd.srv.mrwp.d.MrWritePowerEmpDO;
import iih.bd.srv.mrwp.d.desc.MrWritePowerEmpDODesc;

/**
 * mrwp
 * @author
 *
 */
public class MrwpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrwpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrWritePowerDO.class);
        addChildren(MrWritePowerEmpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrWritePowerEmpDODesc.class).getFKAttrDesc());        
	  }	  
}