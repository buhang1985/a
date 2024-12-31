package iih.mc.st.trreqapimpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.st.trreqapimpl.d.McTrReqApImplDO;
import iih.mc.st.trreqapimpl.d.McTrReqApImplSumItemDO;
import iih.mc.st.trreqapimpl.d.desc.McTrReqApImplSumItemDODesc;
import iih.mc.st.trreqapimpl.d.McTrReqApImplItemDO;
import iih.mc.st.trreqapimpl.d.desc.McTrReqApImplItemDODesc;

/**
 * 调拨单
 * @author
 *
 */
public class TrreqapimplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TrreqapimplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McTrReqApImplDO.class);
        addChildren(McTrReqApImplSumItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McTrReqApImplSumItemDODesc.class).getFKAttrDesc());        
        addChildren(McTrReqApImplItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McTrReqApImplItemDODesc.class).getFKAttrDesc());        
	  }	  
}