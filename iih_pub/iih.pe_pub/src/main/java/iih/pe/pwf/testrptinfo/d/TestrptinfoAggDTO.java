package iih.pe.pwf.testrptinfo.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 体检检验报告信息服务
 */
public class TestrptinfoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SampleDTO getParentDO() {
		return ((SampleDTO) super.getParentDO());
	}

	public void setParentDO(SampleDTO headDO) {
		setParent(headDO);
	}

	public ImageContentDTO[] getImageContentDTO() {
		return ((ImageContentDTO[]) getChildren(ImageContentDTO.class));
	}
	
	public void setImageContentDTO(ImageContentDTO[] dos) {
		setChildren(ImageContentDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new SampleDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pwf.testrptinfo.d.ImageContentDTO")) {
             return new ImageContentDTO();
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