package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpDrugSignEntInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEPharmHerbOrDTO;
import iih.ci.ord.iemsg.d.IEPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEPharmWcOrDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 住院签署 用药 总逻辑处理BS311
 * @author F
 *
 * @date 2019年8月29日下午4:47:02
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpDrugSignLogicDealWithBP
 */
public class IpDrugSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台药品医嘱服务数据信息
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEPharmOrEnDTO[] exec(OrdEventFireDTO firedto)
			throws BizException {
		//有效性校验
		if (OrdEventUtil.isEmpty(firedto.getIdwcors()) && OrdEventUtil.isEmpty(firedto.getIdherbors()))
			return null;
		//获取就诊信息 取其中一个医嘱id去查就诊信息即可
		IEPharmOrEnDTO headdto=getIEPharmOrEnDTO(firedto.getIdor());
		if(OrdEventUtil.isEmpty(headdto)) {
			return null;
		}
		//获得西成药医嘱集合
		IEPharmWcOrDTO[] wcs = getIeDrugwcMsgInfo(firedto.getIdwcors());
		//获得草药医嘱集合
		IEPharmHerbOrDTO[] herbs = getIeDrugHerbMsgInfo(firedto.getIdherbors());
		//合并处理
		setWcHerbFArrayList(headdto, wcs, herbs);
		return new IEPharmOrEnDTO[] { headdto };
	}
	/**
	 * 获取就诊信息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEPharmOrEnDTO getIEPharmOrEnDTO(String id_ors) throws BizException{
		if (OrdEventUtil.isEmpty(id_ors))
			return null;
		//获得药品医嘱确认数据信息
		IpDrugSignEntInfoQuery entInfoQuery=new IpDrugSignEntInfoQuery(id_ors);
		IEPharmOrEnDTO[] entDtos = (IEPharmOrEnDTO[])AppFwUtil.getDORstWithDao(entInfoQuery, IEPharmOrEnDTO.class);
		if(OrdEventUtil.isEmpty(entDtos)) {
			return null;
		}
		IEPharmOrEnDTO headdto = entDtos[0];
		//设置值
		setValue(headdto);
		return headdto;
	}
	/**
	 * 设置值
	 * @param headdto
	 */
	private void setValue(IEPharmOrEnDTO headdto) {
		if(OrdEventUtil.isEmpty(headdto))return;
		//年龄
		if(!OrdEventUtil.isEmpty(headdto.getBirthdaydate_hms())) {
			String ager=AgeCalcUtil.getAge(new FDate(new FDateTime(headdto.getBirthdaydate_hms().toString()).toString()));
			headdto.setAge(ager);
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(headdto.getAdmiss_times())) {
			headdto.setAdmiss_times("0");
		}
		//就诊类别
		headdto.setVisite_type_code(getParamCodeEntp(headdto.getVisite_type_code()));
		
	}
	/**
	 * 设置确认西成药与草药医嘱列表信息
	 * 
	 * @param headdto
	 * @param wcs
	 * @param herbs
	 */
	private void setWcHerbFArrayList(IEPharmOrEnDTO headdto, IEPharmWcOrDTO[] wcs, IEPharmHerbOrDTO[] herbs) {
		if (!OrdEventUtil.isEmpty(wcs)) {//设置西成药医嘱集合信息
			headdto.setId_iepharmwcors(OrdEventUtil.array2FArrayList2(wcs));
		}
		if (!OrdEventUtil.isEmpty(herbs)) {//设置草药药医嘱集合信息
			headdto.setId_iepharmors(OrdEventUtil.array2FArrayList2(herbs));
		}
	}

	/**
	 * 获得集成平台西成药医嘱服务数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEPharmWcOrDTO[] getIeDrugwcMsgInfo(String id_ors) throws BizException {
		IpDrugSignWcLogicDealWithBP bp = new IpDrugSignWcLogicDealWithBP();
		return bp.exec(id_ors);
	}

	/**
	 * 获得集成平台草药医嘱服务数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEPharmHerbOrDTO[] getIeDrugHerbMsgInfo(String id_ors) throws BizException {
		IpDrugSignHerbLogicDealWithBP bp = new IpDrugSignHerbLogicDealWithBP();
		return bp.exec(id_ors);
	}

}
