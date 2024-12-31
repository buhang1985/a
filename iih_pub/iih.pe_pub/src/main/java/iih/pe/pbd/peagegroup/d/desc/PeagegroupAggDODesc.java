package iih.pe.pbd.peagegroup.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pbd.peagegroup.d.PeAgeDO;
import iih.pe.pbd.peagegroup.d.PeAgeListDO;
import iih.pe.pbd.peagegroup.d.desc.PeAgeListDODesc;

/**
 * 体检年龄分组
 * @author
 *
 */
public class PeagegroupAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PeagegroupAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeAgeDO.class);
        addChildren(PeAgeListDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeAgeListDODesc.class).getFKAttrDesc());        
	  }	  
}