package iih.mkr.ms.mkrms.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mkr.ms.mkrms.d.MkrMsDO;
import iih.mkr.ms.mkrms.d.MkrMsSrvDO;
import iih.mkr.ms.mkrms.d.desc.MkrMsSrvDODesc;
import iih.mkr.ms.mkrms.d.MkrMsOrtpl;
import iih.mkr.ms.mkrms.d.desc.MkrMsOrtplDesc;
import iih.mkr.ms.mkrms.d.MkrMsMrtplDO;
import iih.mkr.ms.mkrms.d.desc.MkrMsMrtplDODesc;
import iih.mkr.ms.mkrms.d.MkrMsDiDO;
import iih.mkr.ms.mkrms.d.desc.MkrMsDiDODesc;
import iih.mkr.ms.mkrms.d.MkrMsEnblDeptDO;
import iih.mkr.ms.mkrms.d.desc.MkrMsEnblDeptDODesc;
import iih.mkr.ms.mkrms.d.MkrMsEnblEntpDO;
import iih.mkr.ms.mkrms.d.desc.MkrMsEnblEntpDODesc;

/**
 * 组套定义
 * @author
 *
 */
public class MkrmsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MkrmsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MkrMsDO.class);
        addChildren(MkrMsSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MkrMsSrvDODesc.class).getFKAttrDesc());        
        addChildren(MkrMsOrtpl.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MkrMsOrtplDesc.class).getFKAttrDesc());        
        addChildren(MkrMsMrtplDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MkrMsMrtplDODesc.class).getFKAttrDesc());        
        addChildren(MkrMsDiDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MkrMsDiDODesc.class).getFKAttrDesc());        
        addChildren(MkrMsEnblDeptDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MkrMsEnblDeptDODesc.class).getFKAttrDesc());        
        addChildren(MkrMsEnblEntpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MkrMsEnblEntpDODesc.class).getFKAttrDesc());        
	  }	  
}