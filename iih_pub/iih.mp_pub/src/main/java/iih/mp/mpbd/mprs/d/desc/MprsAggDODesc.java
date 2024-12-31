package iih.mp.mpbd.mprs.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.mprs.d.MpRsDO;
import iih.mp.mpbd.mprs.d.MpRsDepDO;
import iih.mp.mpbd.mprs.d.desc.MpRsDepDODesc;

/**
 * 护士站滚屏
 * @author
 *
 */
public class MprsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MprsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpRsDO.class);
        addChildren(MpRsDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpRsDepDODesc.class).getFKAttrDesc());        
	  }	  
}