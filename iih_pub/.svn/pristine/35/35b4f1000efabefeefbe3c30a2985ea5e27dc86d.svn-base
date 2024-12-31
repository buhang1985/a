package iih.pis.ivx.pisivxsrvact.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pis.ivx.pisivxsrvact.d.PisIvxSrvactDO;
import iih.pis.ivx.pisivxsrvact.d.PisivxTposappDO;
import iih.pis.ivx.pisivxsrvact.d.desc.PisivxTposappDODesc;
import iih.pis.ivx.pisivxsrvact.d.PisIvxSrvactTagDO;
import iih.pis.ivx.pisivxsrvact.d.desc.PisIvxSrvactTagDODesc;

/**
 * 微信服务号
 * @author
 *
 */
public class PisivxsrvactAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PisivxsrvactAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PisIvxSrvactDO.class);
        addChildren(PisivxTposappDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisivxTposappDODesc.class).getFKAttrDesc());        
        addChildren(PisIvxSrvactTagDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisIvxSrvactTagDODesc.class).getFKAttrDesc());        
	  }	  
}