package iih.sc.sch.scsch.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.desc.ScSchEmpDODesc;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.desc.ScSchEnDODesc;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.desc.ScSchChlDODesc;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.d.desc.ScSchOptsrvDODesc;

/**
 * 计划排班_排班
 * @author
 *
 */
public class ScschAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public ScschAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(ScSchDO.class);
        addChildren(ScSchEmpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScSchEmpDODesc.class).getFKAttrDesc());        
        addChildren(ScSchEnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScSchEnDODesc.class).getFKAttrDesc());        
        addChildren(ScSchChlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScSchChlDODesc.class).getFKAttrDesc());        
        addChildren(ScSchOptsrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(ScSchOptsrvDODesc.class).getFKAttrDesc());        
	  }	  
}