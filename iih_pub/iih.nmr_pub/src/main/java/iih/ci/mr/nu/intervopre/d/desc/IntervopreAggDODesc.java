package iih.ci.mr.nu.intervopre.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.nu.intervopre.d.InterPatInfoDO;
import iih.ci.mr.nu.intervopre.d.InterObjPreDO;
import iih.ci.mr.nu.intervopre.d.desc.InterObjPreDODesc;
import iih.ci.mr.nu.intervopre.d.InterOperInfoDO;
import iih.ci.mr.nu.intervopre.d.desc.InterOperInfoDODesc;

/**
 * 介入手术护理记录单
 * @author
 *
 */
public class IntervopreAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public IntervopreAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(InterPatInfoDO.class);
        addChildren(InterObjPreDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InterObjPreDODesc.class).getFKAttrDesc());        
        addChildren(InterOperInfoDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(InterOperInfoDODesc.class).getFKAttrDesc());        
	  }	  
}