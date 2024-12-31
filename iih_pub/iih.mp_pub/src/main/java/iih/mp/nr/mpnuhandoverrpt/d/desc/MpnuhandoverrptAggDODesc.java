package iih.mp.nr.mpnuhandoverrpt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.nr.mpnuhandoverrpt.d.MpNuHsDO;
import iih.mp.nr.mpnuhandoverrpt.d.MpNuHsWardDO;
import iih.mp.nr.mpnuhandoverrpt.d.desc.MpNuHsWardDODesc;
import iih.mp.nr.mpnuhandoverrpt.d.MpNuHsPatDO;
import iih.mp.nr.mpnuhandoverrpt.d.desc.MpNuHsPatDODesc;

/**
 * 护理交接班
 * @author
 *
 */
public class MpnuhandoverrptAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MpnuhandoverrptAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpNuHsDO.class);
        addChildren(MpNuHsWardDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpNuHsWardDODesc.class).getFKAttrDesc());        
        addChildren(MpNuHsPatDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpNuHsPatDODesc.class).getFKAttrDesc());        
	  }	  
}