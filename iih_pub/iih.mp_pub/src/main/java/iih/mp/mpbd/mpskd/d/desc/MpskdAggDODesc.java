package iih.mp.mpbd.mpskd.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mpbd.mpskd.d.MpSkdDO;
import iih.mp.mpbd.mpskd.d.MpSkdOrDO;
import iih.mp.mpbd.mpskd.d.desc.MpSkdOrDODesc;
import iih.mp.mpbd.mpskd.d.MpSkdEntstaDO;
import iih.mp.mpbd.mpskd.d.desc.MpSkdEntstaDODesc;
import iih.mp.mpbd.mpskd.d.MpSkdNmrDO;
import iih.mp.mpbd.mpskd.d.desc.MpSkdNmrDODesc;
import iih.mp.mpbd.mpskd.d.MpSkdVsDO;
import iih.mp.mpbd.mpskd.d.desc.MpSkdVsDODesc;

/**
 * 护理任务定义
 * @author
 *
 */
public class MpskdAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MpskdAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpSkdDO.class);
        addChildren(MpSkdOrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpSkdOrDODesc.class).getFKAttrDesc());        
        addChildren(MpSkdEntstaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpSkdEntstaDODesc.class).getFKAttrDesc());        
        addChildren(MpSkdNmrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpSkdNmrDODesc.class).getFKAttrDesc());        
        addChildren(MpSkdVsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpSkdVsDODesc.class).getFKAttrDesc());        
	  }	  
}