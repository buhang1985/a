package iih.sfda.aer.sfdaaerevissu.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.sfda.aer.sfdaaerevissu.d.SfdaAerEvIssuDO;
import iih.sfda.aer.sfdaaerevissu.d.SfdaAerEvIssuMsDO;
import iih.sfda.aer.sfdaaerevissu.d.desc.SfdaAerEvIssuMsDODesc;

/**
 * 不良报告_整改问题
 * @author
 *
 */
public class SfdaaerevissuAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SfdaaerevissuAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SfdaAerEvIssuDO.class);
        addChildren(SfdaAerEvIssuMsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SfdaAerEvIssuMsDODesc.class).getFKAttrDesc());        
	  }	  
}