package iih.pe.pwf.dto.pereportinfodto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 体检报告信息
 */
public class PereportinfodtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeBriDiagnosisDTO getParentDO() {
		return ((PeBriDiagnosisDTO) super.getParentDO());
	}

	public void setParentDO(PeBriDiagnosisDTO headDO) {
		setParent(headDO);
	}

	public PeBriDiagnosisMemoDTO[] getPeBriDiagnosisMemoDTO() {
		return ((PeBriDiagnosisMemoDTO[]) getChildren(PeBriDiagnosisMemoDTO.class));
	}
	
	public void setPeBriDiagnosisMemoDTO(PeBriDiagnosisMemoDTO[] dos) {
		setChildren(PeBriDiagnosisMemoDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new PeBriDiagnosisDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.dto.pereportinfodto.d.PeBriDiagnosisMemoDTO")) {
             return new PeBriDiagnosisMemoDTO();
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