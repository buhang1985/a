package iih.ci.mrfp.cimrfpdto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 病案首页
 */
public class CimrfpdtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrFpDTO getParentDO() {
		return ((CiMrFpDTO) super.getParentDO());
	}

	public void setParentDO(CiMrFpDTO headDO) {
		setParent(headDO);
	}

	public CiMrFpXYDIDTO[] getCiMrFpXYDIDTO() {
		return ((CiMrFpXYDIDTO[]) getChildren(CiMrFpXYDIDTO.class));
	}
	
	public void setCiMrFpXYDIDTO(CiMrFpXYDIDTO[] dos) {
		setChildren(CiMrFpXYDIDTO.class, dos);
	}
	public CiMrFpZYDiDTO[] getCiMrFpZYDiDTO() {
		return ((CiMrFpZYDiDTO[]) getChildren(CiMrFpZYDiDTO.class));
	}
	
	public void setCiMrFpZYDiDTO(CiMrFpZYDiDTO[] dos) {
		setChildren(CiMrFpZYDiDTO.class, dos);
	}
	public CiMrFpSugDTO[] getCiMrFpSugDTO() {
		return ((CiMrFpSugDTO[]) getChildren(CiMrFpSugDTO.class));
	}
	
	public void setCiMrFpSugDTO(CiMrFpSugDTO[] dos) {
		setChildren(CiMrFpSugDTO.class, dos);
	}
	public CiMrfpIntenCareDTO[] getCiMrfpIntenCareDTO() {
		return ((CiMrfpIntenCareDTO[]) getChildren(CiMrfpIntenCareDTO.class));
	}
	
	public void setCiMrfpIntenCareDTO(CiMrfpIntenCareDTO[] dos) {
		setChildren(CiMrfpIntenCareDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new CiMrFpDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrfp.cimrfpdto.d.CiMrFpXYDIDTO")) {
             return new CiMrFpXYDIDTO();
         }
	    else if (clzName.equals("iih.ci.mrfp.cimrfpdto.d.CiMrFpZYDiDTO")) {
             return new CiMrFpZYDiDTO();
         }
	    else if (clzName.equals("iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO")) {
             return new CiMrFpSugDTO();
         }
	    else if (clzName.equals("iih.ci.mrfp.cimrfpdto.d.CiMrfpIntenCareDTO")) {
             return new CiMrfpIntenCareDTO();
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