package iih.bd.pp.hp.bp;

import java.util.List;

import iih.bd.pp.mpayratiodf.d.MPayRatioDfDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取所有多支付比例集合
 * 
 * @author yankan
 * @since 2017-11-17
 *
 */
public class GetAllMutiPayRatioListBP {
	/**
	 * 获取所有多支付比例集合
	 * 
	 * @return
	 * @author yankan
	 */
	public MPayRatioDfDO[] exec() throws BizException {
		String[] selectedFields = new String[] { MPayRatioDfDO.ID_HPMPAYRATIODF, MPayRatioDfDO.CODE,
				MPayRatioDfDO.ID_HP, MPayRatioDfDO.NAME, MPayRatioDfDO.NOTE };
		@SuppressWarnings("unchecked")
		List<MPayRatioDfDO> ratioList = (List<MPayRatioDfDO>) new DAFacade().findByCond(MPayRatioDfDO.class, "1=1",
				selectedFields);
		if (!ListUtil.isEmpty(ratioList)) {
			return ratioList.toArray(new MPayRatioDfDO[0]);
		}
		return null;
	}
}
