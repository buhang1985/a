package iih.bd.res.mtassist.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.res.mtassist.d.MtAssistDO;
import iih.bd.res.mtassist.d.MtassistFundDO;
import iih.bd.res.mtassist.d.desc.MtassistFundDODesc;

/**
 * 医技辅
 * @author
 *
 */
public class MtassistAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MtassistAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MtAssistDO.class);
        addChildren(MtassistFundDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MtassistFundDODesc.class).getFKAttrDesc());        
	  }	  
}