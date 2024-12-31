package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.bps.sign.ip.query.IpOtherSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpOtherSignOrdInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventHelper;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOthOrDTO;
import iih.ci.ord.iemsg.d.IEOthOrEnDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 住院签署 其他逻辑处理BS305
 * @author F
 *
 * @date 2019年8月27日下午3:47:24
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpOtherSignLogicDealWithBP
 */
public class IpOtherSignLogicDealWithBP extends CommonParamBP{
	
	/**
	 * 生成集成平台其它医嘱服务数据信息
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOthOrEnDTO[] exec(OrdEventFireDTO firedto) throws BizException {
		//有效性校验
		if (OrdEventUtil.isEmpty(firedto.getIdors()))
			return null;

		//查询并获得就诊及确认数据信息
		IEOthOrEnDTO[] rtn = getIEOthOrEnDTOs(firedto.getIdors());
		if (OrdEventUtil.isEmpty(rtn))
			return null;

		//查询并设置确认数据对应的  其它医嘱数据信息集合
		setCiOthOrCItms4Confirm(firedto.getIdors(), rtn[0]);

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
		IpOtherSignOrdInfoQuery qry1 = new IpOtherSignOrdInfoQuery(id_ors);
		IEOthOrDTO[] itms = (IEOthOrDTO[]) AppFwUtil.getDORstWithDao(qry1, IEOthOrDTO.class);
		if (OrdEventUtil.isEmpty(itms))
			return;
		if(!OrdEventUtil.isEmpty(itms)) {
			for(IEOthOrDTO ieOthOrDTO:itms) {
				//收费状态标识
				String id_or = ieOthOrDTO.getId_ieothor();
				if(StringUtils.isNotEmpty(id_or)) {
					OrdSrvDO[] ordSrvDOs;
					try {
						ordSrvDOs = OrdEventHelper.getOrdSrvDO(id_or);
						if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
							ieOthOrDTO.setFybj_code(ordSrvDOs[0].getSd_su_bl());
						}
					} catch (BizException e) {
						ieOthOrDTO.setFybj_code("");
						e.printStackTrace();
					}
				}
			}
		}
		rtn.setIeothors(OrdEventUtil.array2FArrayList2(itms));
	}

	/**
	 * 查询并获得就诊及确认数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEOthOrEnDTO[] getIEOthOrEnDTOs(String id_ors) throws BizException {
		IpOtherSignEntInfoQuery qry = new IpOtherSignEntInfoQuery(getIdOr(id_ors));
		IEOthOrEnDTO[] rtn = (IEOthOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOthOrEnDTO.class);
		//设置值
		setValue(rtn);
		return rtn;
	}
	/**
	 * 设置值
	 * @param rtn
	 */
	private void setValue(IEOthOrEnDTO[] rtn) {
		if(OrdEventUtil.isEmpty(rtn)) {
			return;
		}
		for(IEOthOrEnDTO dto:rtn) {
			//就诊次数
			if(OrdEventUtil.isEmpty(dto.getAdmiss_times())) {
				dto.setAdmiss_times("0");
			}
			//就诊类别
			dto.setVisit_type_code(getParamCodeEntp(dto.getVisit_type_code()));
			//年龄
			if(!OrdEventUtil.isEmpty(dto.getBirthdaydate())) {
				dto.setAge(AgeCalcUtil.getAge(new FDate(dto.getBirthdaydate().toString())));
			}
		}
	}
	/**
	 * 获得一个医嘱id
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getIdOr(String id_ors) {
		return (id_ors.split(OrdEventUtil.COMMA_STR))[0];
	}
}
