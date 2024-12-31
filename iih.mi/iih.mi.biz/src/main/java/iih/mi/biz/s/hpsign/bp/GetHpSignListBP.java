package iih.mi.biz.s.hpsign.bp;

import iih.bl.hp.hpsignin.d.HpSignInDO;
import iih.mi.biz.hpsignin.d.MiHpSignInDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
/**
 * 获取操作员签到记录
 * 
 * @author 杨扬
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
	public PagingRtnData<MiHpSignInDO> exec(PaginationInfo pg, String whereCond) throws BizException {

		if (StringUtil.isEmpty(whereCond))
			return null;

		PagingRtnData<MiHpSignInDO> pageBedDTO = new PagingRtnData<MiHpSignInDO>();

		PagingServiceImpl<MiHpSignInDO> service = new PagingServiceImpl<MiHpSignInDO>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PSN.NAME PSN_NAME,PSN.CODE PSN_CODE, BDHP.NAME AS NAME_HP,SIGNIN.* ");
		sql.append(" FROM MI_HP_SIGN_IN SIGNIN LEFT JOIN BD_PSNDOC PSN ON SIGNIN.ID_EMP = PSN.ID_PSNDOC ");
		sql.append(" INNER JOIN BD_HP BDHP ON SIGNIN.ID_HP=BDHP.ID_HP");
		sql.append(" where 1=1 ").append(whereCond);

		pageBedDTO = service.findByPageInfo(new MiHpSignInDO(), pg, sql.toString(), "SignIn.fg_active desc,SIGNIN.DT_B DESC", null);

		return pageBedDTO;
	}
}
