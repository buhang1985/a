package iih.bl.comm.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 费用域数据处理工具
 * @author ly 2019/07/25
 *
 */
public class BlDataUtil {

	/**
	 * 门诊费用明细数据转agg数据
	 * @param cgItms
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlcgoepAggDO[] getOepCgAggDataByItm(BlCgItmOepDO[] cgItms) throws BizException{
		
		if(ArrayUtil.isEmpty(cgItms))
			return null;
		
		Set<String> cgIdSet = new HashSet<String>();
		for (BlCgItmOepDO cgItm : cgItms) {
			cgIdSet.add(cgItm.getId_cgoep());
		}
		DAFacade daf = new DAFacade();
		List<BlCgOepDO> cgHdDoList = (List<BlCgOepDO>)daf.findByPKs(BlCgOepDO.class, cgIdSet.toArray(new String[0]));
		List<BlcgoepAggDO> cgAggList = new ArrayList<BlcgoepAggDO>();
		for (BlCgOepDO cgOepDO : cgHdDoList) {
			
			BlcgoepAggDO aggDO = new BlcgoepAggDO();
			aggDO.setParentDO(cgOepDO);
			List<BlCgItmOepDO> itmList = new ArrayList<BlCgItmOepDO>();
			for (BlCgItmOepDO itmOepDO : cgItms) {
				if(cgOepDO.getId_cgoep().equals(itmOepDO.getId_cgoep())){
					itmList.add(itmOepDO);
				}
			}
			aggDO.setBlCgItmOepDO(itmList.toArray(new BlCgItmOepDO[0]));
			cgAggList.add(aggDO);
		}
		
		return cgAggList.toArray(new BlcgoepAggDO[0]);
	}
	
	/**
	 * 判断记账数据中是否存在挂号费
	 * @param blCgItmOepDOArr
	 * @return
	 */
	public static FBoolean bExistEntRegist(BlCgItmOepDO[] blCgItmOepDOArr ){
		FBoolean bExist=FBoolean.FALSE;
		if(ArrayUtils.isEmpty(blCgItmOepDOArr))
			return bExist;
		
		for(BlCgItmOepDO cgitmDo:blCgItmOepDOArr)
		{
			if(FeeOriginEnum.ENCOUNTER_FEE==cgitmDo.getEu_srctp())
			{
				bExist=FBoolean.TRUE;
				break;
			}
		}
		return bExist;
	}
}
