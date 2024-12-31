package iih.mi.biz.service.s.bp;

import iih.mi.biz.miorderrecord.d.MiOrderrecordDO;
import iih.mi.biz.service.s.bp.qry.FindMiOrderReChargeQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据结算号查询重收数据
 * @author liming06
 *
 */
public class FindMiOrderReCharge {
		/**
		 * 根据订单号查询全退和重收的数据
		 * @param code_st 结算编号
		 * @return
		 * @throws BizException
		 */
		public MiOrderrecordDO[] exec(String code_st) throws BizException  {
			MiOrderrecordDO[] miOrderRecordDTOArr = (MiOrderrecordDO[]) AppFwUtil.getDORstWithDao(new FindMiOrderReChargeQry(code_st), MiOrderrecordDO.class);
			return miOrderRecordDTOArr;
		}
}
