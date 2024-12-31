package iih.mp.orm.surgappconfirm.i;

import iih.mp.orm.sugfeeitem.d.SugFeeItemDTO;
import iih.mp.orm.surgappconfirm.d.SurgMmConfDO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;

public interface ISurgafconfirmExtService {

	/**
	 * 术后确认从医技补录取手术耗材
	 * @param id_or
	 * @param fg_pat_out
	 * @return
	 * @throws DAException 
	 */
	public abstract SurgMmConfDO[] getMmFromAddRecord(String id_or, FBoolean fg_pat_out) throws DAException;
	
	/**
	 * 获取手术已记账的金额
	 * @param id_or
	 * @param fg_pat_out
	 * @return
	 * @throws DAException 
	 */
	public abstract FDouble getSugAmt(String id_or, FBoolean fg_pat_out) throws DAException;
	
	/**
	 * 获取手术费用明细
	 * @param id_or
	 * @param fg_pat_out
	 * @return
	 * @throws DAException
	 */
	public abstract SugFeeItemDTO[] getAmtItem(String id_or, FBoolean fg_pat_out) throws DAException;
	
	/**
	 * 校验是否存在以保存未记账的费用
	 * @param id_or
	 * @param fg_pat_out
	 * @return
	 * @throws DAException
	 */
	public abstract FBoolean checkFee(String id_or, FBoolean fg_pat_out) throws DAException;

}
