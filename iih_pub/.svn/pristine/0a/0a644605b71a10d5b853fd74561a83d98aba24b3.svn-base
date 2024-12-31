package iih.bd.pp.dto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 定价计算DTO
 */
public class PricaldtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PriCalDTO getParentDO() {
		return ((PriCalDTO) super.getParentDO());
	}

	public void setParentDO(PriCalDTO headDO) {
		setParent(headDO);
	}

	public SrvSetAddDTO[] getSrvSetAddDTO() {
		return ((SrvSetAddDTO[]) getChildren(SrvSetAddDTO.class));
	}
	
	public void setSrvSetAddDTO(SrvSetAddDTO[] dos) {
		setChildren(SrvSetAddDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new PriCalDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.dto.d.SrvSetAddDTO")) {
             return new SrvSetAddDTO();
         }
         return null;
     }

	@Override
	public IAggDesc getAggDesc() {
		// TODO Auto-generated method stub
		return null;
	}
}