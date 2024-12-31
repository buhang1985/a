package iih.pe.pwf.dto.peitflisdto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 体检接口_LIS结果回传查询
 */
public class PeitflisdtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeItfLisDTO getParentDO() {
		return ((PeItfLisDTO) super.getParentDO());
	}

	public void setParentDO(PeItfLisDTO headDO) {
		setParent(headDO);
	}

	public PeItfLisDtlDTO[] getPeItfLisDtlDTO() {
		return ((PeItfLisDtlDTO[]) getChildren(PeItfLisDtlDTO.class));
	}
	
	public void setPeItfLisDtlDTO(PeItfLisDtlDTO[] dos) {
		setChildren(PeItfLisDtlDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new PeItfLisDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.dto.peitflisdto.d.PeItfLisDtlDTO")) {
             return new PeItfLisDtlDTO();
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