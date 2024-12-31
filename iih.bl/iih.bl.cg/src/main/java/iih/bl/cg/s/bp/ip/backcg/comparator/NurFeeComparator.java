package iih.bl.cg.s.bp.ip.backcg.comparator;

import iih.bl.cg.s.bp.ip.backcg.DayFeeParam;
import iih.bl.params.BlParamValueConst;

import java.util.Comparator;

/**
 * 护理费比较器
 * @author ly 2018/09/10
 *
 */
public class NurFeeComparator implements Comparator<DayFeeParam>{

	private String mode;
	public NurFeeComparator(String mode){
		this.mode = mode;
	}

	@Override
	public int compare(DayFeeParam o1, DayFeeParam o2) {
		
		switch (mode) {
		case BlParamValueConst.BLCG0001_DAY_BEF:
			return o1.getDt_b().compareTo(o2.getDt_b());
		case BlParamValueConst.BLCG0001_DAY_AFT:
			return o2.getDt_b().compareTo(o1.getDt_b());
		case BlParamValueConst.BLCG0001_DAY_HIGN:
			if(o2.getPrice().compareTo(o1.getPrice()) == 0){
				return o2.getDt_b().compareTo(o1.getDt_b());
			}else{
				return o2.getPrice().compareTo(o1.getPrice());
			}
		case BlParamValueConst.BLCG0001_DAY_LOW:
			return o1.getPrice().compareTo(o2.getPrice());
		}
		
		return 0;
	}
}
