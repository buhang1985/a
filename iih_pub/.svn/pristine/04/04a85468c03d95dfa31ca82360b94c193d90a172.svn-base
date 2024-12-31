package iih.bd.srv.mrfpbltype.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeDO;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeProDO;
import iih.bd.srv.mrfpbltype.d.desc.MrFpBlTypeProDODesc;

/**
 * 病案首页费用分类
 * @author
 *
 */
public class MrfpbltypeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrfpbltypeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrFpBlTypeDO.class);
        addChildren(MrFpBlTypeProDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrFpBlTypeProDODesc.class).getFKAttrDesc());        
	  }	  
}