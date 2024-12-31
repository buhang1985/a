package iih.bl.hp.s.bp;

import iih.bd.res.bed.d.BedDTO;
import iih.bl.hp.hpsignin.d.HpSignInDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取操作员签到记录
 * 
 * @author yang.lu 2017年7月13日
 *
 */
public class GetHpSignListBP {
	/**
	 * 获取操作员签到记录
	 * 
	 * @param pg
	 *            分页对象
	 * @param empId
	 *            操作员ID
	 * @return 签到记录集合
	 * @throws BizException
	 */
	public PagingRtnData<HpSignInDO> exec(PaginationInfo pg, String whereCond) throws BizException {

		if (StringUtil.isEmpty(whereCond))
			return null;

		PagingRtnData<HpSignInDO> pageBedDTO = new PagingRtnData<HpSignInDO>();

		PagingServiceImpl<HpSignInDO> service = new PagingServiceImpl<HpSignInDO>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PSN.NAME PSN_NAME,PSN.CODE PSN_CODE, SIGNIN.* ");
		sql.append(" FROM BL_HP_SIGN_IN SIGNIN LEFT JOIN BD_PSNDOC PSN ON SIGNIN.ID_EMP = PSN.ID_PSNDOC ");
		sql.append(" where 1=1 ").append(whereCond);

		pageBedDTO = service.findByPageInfo(new HpSignInDO(), pg, sql.toString(), "SignIn.fg_active desc,SIGNIN.DT_B DESC", null);

		return pageBedDTO;
	}
}
