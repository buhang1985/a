package iih.pe.por.pepsnbinfo.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoPriDO;
import iih.pe.por.pepsnbinfo.d.desc.PePsnBInfoPriDODesc;
import iih.pe.por.pepsnbinfo.d.PePsnPhyDO;
import iih.pe.por.pepsnbinfo.d.desc.PePsnPhyDODesc;

/**
 * 体检客户基本资料
 * @author
 *
 */
public class PepsnbinfoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PepsnbinfoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PePsnBInfoDO.class);
        addChildren(PePsnBInfoPriDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePsnBInfoPriDODesc.class).getFKAttrDesc());        
        addChildren(PePsnPhyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePsnPhyDODesc.class).getFKAttrDesc());        
	  }	  
}