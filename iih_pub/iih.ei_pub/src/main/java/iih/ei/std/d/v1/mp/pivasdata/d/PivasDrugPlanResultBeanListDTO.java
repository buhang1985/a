package iih.ei.std.d.v1.mp.pivasdata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Pivas药品药单集合 DTO数据 
 * 
 */
public class PivasDrugPlanResultBeanListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药品药单集合
	 * @return String
	 */
	public FArrayList getDrugplanitems() {
		return ((FArrayList) getAttrVal("Drugplanitems"));
	}	
	/**
	 * 药品药单集合
	 * @param Drugplanitems
	 */
	public void setDrugplanitems(FArrayList Drugplanitems) {
		setAttrVal("Drugplanitems", Drugplanitems);
	}
}