package iih.bd.srv.emrimg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.emrimg.d.EmrImageDO;
import iih.bd.srv.emrimg.d.EmrImgAliasDO;
import iih.bd.srv.emrimg.d.desc.EmrImgAliasDODesc;

/**
 * 医疗记录图片库管理
 * @author
 *
 */
public class EmrimgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmrimgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmrImageDO.class);
        addChildren(EmrImgAliasDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmrImgAliasDODesc.class).getFKAttrDesc());        
	  }	  
}