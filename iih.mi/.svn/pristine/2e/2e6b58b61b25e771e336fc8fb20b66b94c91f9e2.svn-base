package iih.mi.biz.service.s.bp;

import iih.mi.biz.mirecordstrecord.d.MiOrderStRecordDO;
import iih.mi.biz.service.s.bp.qry.FindMiOrderSTForReFundQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据结算号查询退费医技重收的结算日志记录
 * @author liming06
 * @since 2019-11-11
 */
public class FindMiOrderSTForReFund {
	/**
	 * 根据结算号查询退费重收的结算交易记录
	 * @param code_st
	 * @param bCharge  查询收退方式
	 * @return
	 * @throws BizException
	 */
	public MiOrderStRecordDO[] exec(String code_st,FBoolean bCharge) throws BizException  {
		MiOrderStRecordDO[] miOrderStRecordDTOArr = (MiOrderStRecordDO[]) AppFwUtil.getDORstWithDao(new FindMiOrderSTForReFundQry(code_st,bCharge), MiOrderStRecordDO.class);
		return miOrderStRecordDTOArr;
	}
}
