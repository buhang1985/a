package iih.bd.srv.mrmtype.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.d.MrmTypeMrtpDO;
import iih.bd.srv.mrmtype.d.desc.MrmTypeMrtpDODesc;

/**
 * 病案分类
 * @author
 *
 */
public class MrmtypeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrmtypeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrmTypeDO.class);
        addChildren(MrmTypeMrtpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrmTypeMrtpDODesc.class).getFKAttrDesc());        
	  }	  
}