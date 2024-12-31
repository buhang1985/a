package iih.pe.pwf.dto.checkreportinfodto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 检查报告信息
 */
public class CheckreportinfodtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CvisDTO getParentDO() {
		return ((CvisDTO) super.getParentDO());
	}

	public void setParentDO(CvisDTO headDO) {
		setParent(headDO);
	}

	public OperatorDTO[] getOperatorDTO() {
		return ((OperatorDTO[]) getChildren(OperatorDTO.class));
	}
	
	public void setOperatorDTO(OperatorDTO[] dos) {
		setChildren(OperatorDTO.class, dos);
	}
	public AssistantDTO[] getAssistantDTO() {
		return ((AssistantDTO[]) getChildren(AssistantDTO.class));
	}
	
	public void setAssistantDTO(AssistantDTO[] dos) {
		setChildren(AssistantDTO.class, dos);
	}
	public ReportItemDTO[] getReportItemDTO() {
		return ((ReportItemDTO[]) getChildren(ReportItemDTO.class));
	}
	
	public void setReportItemDTO(ReportItemDTO[] dos) {
		setChildren(ReportItemDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new CvisDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.dto.checkreportinfodto.d.OperatorDTO")) {
             return new OperatorDTO();
         }
	    else if (clzName.equals("iih.pe.pwf.dto.checkreportinfodto.d.AssistantDTO")) {
             return new AssistantDTO();
         }
	    else if (clzName.equals("iih.pe.pwf.dto.checkreportinfodto.d.ReportItemDTO")) {
             return new ReportItemDTO();
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