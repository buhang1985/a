package iih.bl.inc.blincquerydto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 组件
 */
public class BlincquerydtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlincQueryDTO getParentDO() {
		return ((BlincQueryDTO) super.getParentDO());
	}

	public void setParentDO(BlincQueryDTO headDO) {
		setParent(headDO);
	}

	public BlincitmIpDTO[] getBlincitmIpDTO() {
		return ((BlincitmIpDTO[]) getChildren(BlincitmIpDTO.class));
	}
	
	public void setBlincitmIpDTO(BlincitmIpDTO[] dos) {
		setChildren(BlincitmIpDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new BlincQueryDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.inc.blincquerydto.d.BlincitmIpDTO")) {
             return new BlincitmIpDTO();
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