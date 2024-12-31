package iih.ci.mb.dcmo.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mb.dcmo.d.DoctorMemoDO;
import iih.ci.mb.dcmo.d.DoctorMemoFileDO;
import iih.ci.mb.dcmo.d.desc.DoctorMemoFileDODesc;

/**
 * 医生备忘录
 * @author
 *
 */
public class DoctormemoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DoctormemoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(DoctorMemoDO.class);
        addChildren(DoctorMemoFileDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(DoctorMemoFileDODesc.class).getFKAttrDesc());        
	  }	  
}