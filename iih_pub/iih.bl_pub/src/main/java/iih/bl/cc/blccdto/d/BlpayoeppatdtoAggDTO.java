package iih.bl.cc.blccdto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 组件
 */
public class BlpayoeppatdtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BlpayOepPatDTO getParentDO() {
		return ((BlpayOepPatDTO) super.getParentDO());
	}

	public void setParentDO(BlpayOepPatDTO headDO) {
		setParent(headDO);
	}

	public BlPayItmPatOepDTO[] getBlPayItmPatOepDTO() {
		return ((BlPayItmPatOepDTO[]) getChildren(BlPayItmPatOepDTO.class));
	}
	
	public void setBlPayItmPatOepDTO(BlPayItmPatOepDTO[] dos) {
		setChildren(BlPayItmPatOepDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new BlpayOepPatDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bl.cc.blccdto.d.BlPayItmPatOepDTO")) {
             return new BlPayItmPatOepDTO();
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