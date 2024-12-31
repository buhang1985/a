package iih.ci.ord.s.bp.iemsg;

import iih.bd.base.utils.StringUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOthOrDTO;
import iih.ci.ord.iemsg.d.IEOthOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiOthOrCItmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOthOrConfirmQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * BS305：其它医嘱信息服务</br>
 * 生成集成平台其它医嘱服务数据信息操作BP
 */
public class GetIEMsgInfo4OthBP {
	/**
	 * 生成集成平台其它医嘱服务数据信息
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOthOrEnDTO[] exec(String id_ors) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_ors))
			return null;

		//查询并获得就诊及确认数据信息
		IEOthOrEnDTO[] rtn = getIEOthOrEnDTOs(id_ors);
		if (CiOrdUtils.isEmpty(rtn))
			return null;

		//查询并设置确认数据对应的  其它医嘱数据信息集合
		setCiOthOrCItms4Confirm(id_ors, rtn[0]);

		//返回
		return rtn;
	}

	/**
	 * 查询并设置确认数据对应的 其它医嘱数据信息集合
	 * 
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private void setCiOthOrCItms4Confirm(String id_ors, IEOthOrEnDTO rtn) throws BizException {
		CiOthOrCItmQry qry1 = new CiOthOrCItmQry(id_ors);
		IEOthOrDTO[] itms = (IEOthOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOthOrDTO.class);
		if (CiOrdUtils.isEmpty(itms))
			return;
		if(!CiOrdUtils.isEmpty(itms)) {
			for(IEOthOrDTO ieOthOrDTO:itms) {
				//收费状态标识
				String code_or = ieOthOrDTO.getYz_code();
				if(StringUtils.isNotEmpty(code_or)) {
					OrdSrvDO[] ordSrvDOs;
					try {
						ordSrvDOs = GetPayFlagHelper.getOrdSrvDO(CiOrderDO.CODE_OR, code_or);
						if(!CiOrdUtils.isEmpty(ordSrvDOs)) {
							ieOthOrDTO.setFybj_code(ordSrvDOs[0].getSd_su_bl());
						}
					} catch (BizException e) {
						ieOthOrDTO.setFybj_code("");
						e.printStackTrace();
					}
				}
			}
		}
		rtn.setIeothors(CiOrdUtils.array2FArrayList2(itms));
	}

	/**
	 * 查询并获得就诊及确认数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOthOrEnDTO[] getIEOthOrEnDTOs(String id_ors) throws BizException {
		CiOthOrConfirmQry qry = new CiOthOrConfirmQry(getIdOr(id_ors));
		IEOthOrEnDTO[] rtn = (IEOthOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOthOrEnDTO.class);
		return rtn;
	}

	/**
	 * 获得一个医嘱id
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getIdOr(String id_ors) {
		return (id_ors.split(CiOrdUtils.COMMA_STR))[0];
	}
}
