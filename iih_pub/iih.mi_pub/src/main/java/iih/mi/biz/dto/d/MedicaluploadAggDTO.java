package iih.mi.biz.dto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 病案首页上传
 */
public class MedicaluploadAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MedicaluploadTcmDTO getParentDO() {
		return ((MedicaluploadTcmDTO) super.getParentDO());
	}

	public void setParentDO(MedicaluploadTcmDTO headDO) {
		setParent(headDO);
	}

	public DischargeDiagnosisTcmDTO[] getDischargeDiagnosisTcmDTO() {
		return ((DischargeDiagnosisTcmDTO[]) getChildren(DischargeDiagnosisTcmDTO.class));
	}
	
	public void setDischargeDiagnosisTcmDTO(DischargeDiagnosisTcmDTO[] dos) {
		setChildren(DischargeDiagnosisTcmDTO.class, dos);
	}
	public OperationTcmDTO[] getOperationTcmDTO() {
		return ((OperationTcmDTO[]) getChildren(OperationTcmDTO.class));
	}
	
	public void setOperationTcmDTO(OperationTcmDTO[] dos) {
		setChildren(OperationTcmDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new MedicaluploadTcmDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mi.biz.dto.d.DischargeDiagnosisTcmDTO")) {
             return new DischargeDiagnosisTcmDTO();
         }
	    else if (clzName.equals("iih.mi.biz.dto.d.OperationTcmDTO")) {
             return new OperationTcmDTO();
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