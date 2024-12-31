package iih.pe.pwf.phyexamrptdto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 体检报告服务信息
 */
public class PhyexamrptdtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public LabInfo getParentDO() {
		return ((LabInfo) super.getParentDO());
	}

	public void setParentDO(LabInfo headDO) {
		setParent(headDO);
	}

	public LabSubItemInfo[] getLabSubItemInfo() {
		return ((LabSubItemInfo[]) getChildren(LabSubItemInfo.class));
	}
	
	public void setLabSubItemInfo(LabSubItemInfo[] dos) {
		setChildren(LabSubItemInfo.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new LabInfo();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.phyexamrptdto.d.LabSubItemInfo")) {
             return new LabSubItemInfo();
         }
         return null;
     }
    
    /**
     * AggDTO 中元数据描述不存在，此方法不应使用 
     */ 
    @Override
	public IAggDesc getAggDesc() {
		return null;
	}

}