package iih.pe.pitm.pesrvbcatlog.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogDO;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvbCatlogItmDO;
import iih.pe.pitm.pesrvbcatlog.d.desc.PeSrvbCatlogItmDODesc;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvCastChargeDO;
import iih.pe.pitm.pesrvbcatlog.d.desc.PeSrvCastChargeDODesc;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvCastApplyDO;
import iih.pe.pitm.pesrvbcatlog.d.desc.PeSrvCastApplyDODesc;

/**
 * 体检项目基本目录
 * @author
 *
 */
public class PesrvbcatlogAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PesrvbcatlogAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeSrvbCatlogDO.class);
        addChildren(PeSrvbCatlogItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvbCatlogItmDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvCastChargeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvCastChargeDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvCastApplyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvCastApplyDODesc.class).getFKAttrDesc());        
	  }	  
}