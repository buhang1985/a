package iih.mp.mpbd.mprscarditm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.mprscarditm.d.MpRsCardItmDO;
import iih.mp.mpbd.mprscarditm.d.MpRsCardItmPsnDO;
import iih.mp.mpbd.mprscarditm.d.desc.MpRsCardItmPsnDODesc;
import iih.mp.mpbd.mprscarditm.d.MpRsCardItmSrvDO;
import iih.mp.mpbd.mprscarditm.d.desc.MpRsCardItmSrvDODesc;

/**
 * 护士站滚屏卡信息明细
 * @author
 *
 */
public class MprscarditmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MprscarditmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpRsCardItmDO.class);
        addChildren(MpRsCardItmPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpRsCardItmPsnDODesc.class).getFKAttrDesc());        
        addChildren(MpRsCardItmSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpRsCardItmSrvDODesc.class).getFKAttrDesc());        
	  }	  
}