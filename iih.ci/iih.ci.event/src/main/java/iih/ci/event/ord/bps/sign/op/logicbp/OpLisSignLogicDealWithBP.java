package iih.ci.event.ord.bps.sign.op.logicbp;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.bps.sign.op.query.OpLisSignApplyInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpLisSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.op.query.OpLisSignOrdItmInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventHelper;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊签署 检验处理逻辑BS006
 * @author F
 *
 * @date 2019年8月27日下午3:52:33
 *
 * @classpath iih.ci.event.ord.bps.sign.op.logicbp.OpLisSignLogicDealWithBP
 */
public class OpLisSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 门诊 检验 签署 数据组装 通过id_or医嘱id  一致时拼接
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public IEOpLisOrEnDTO[] exec(OrdEventFireDTO fireDTO)throws BizException{
		if(OrdEventUtil.isEmpty(fireDTO.getIdors())) {
			return null;
		}
		//就诊信息
		OpLisSignEntInfoQuery entInfoQuery=new OpLisSignEntInfoQuery(fireDTO.getIdors());
		IEOpLisOrEnDTO[] entDtos = (IEOpLisOrEnDTO[])AppFwUtil.getDORstWithDao(entInfoQuery, IEOpLisOrEnDTO.class);
		//申请单信息
		OpLisSignApplyInfoQuery applyInfoQuery =new OpLisSignApplyInfoQuery(fireDTO.getIdors());
		IEOpLisOrDTO[] applyDtos=(IEOpLisOrDTO[])AppFwUtil.getDORstWithDao(applyInfoQuery, IEOpLisOrDTO.class);
		//医嘱项目信息
		OpLisSignOrdItmInfoQuery orderInfoQuery=new OpLisSignOrdItmInfoQuery(fireDTO.getIdors());
		IEOpLisOrItmDTO[] orderItmDtos=(IEOpLisOrItmDTO[])AppFwUtil.getDORstWithDao(orderInfoQuery, IEOpLisOrItmDTO.class);
		//拼装就诊 申请单 医嘱项目信息
		if(!OrdEventUtil.isEmpty(entDtos)) {
			for(IEOpLisOrEnDTO enDTO:entDtos) {
				//设置值
				setValue(enDTO);
				//将申请信息赋给就诊信息
				setApplyInfoToEntInfo(applyDtos,enDTO,orderItmDtos);
			}
		}
		return entDtos;
	}
	/**
	 * 设置值
	 * @param enDTO
	 */
	private void setValue(IEOpLisOrEnDTO enDTO) {
		if(OrdEventUtil.isEmpty(enDTO))return;
		//计算年龄
		if(!OrdEventUtil.isEmpty(enDTO.getBirthday())) {
			enDTO.setAge(AgeCalcUtil.getAge(enDTO.getBirthday().getDate()));
		}
		//就诊次数
		if(OrdEventUtil.isEmpty(enDTO.getTimes())) {
			enDTO.setTimes("0");
		}
		//就诊类别
		enDTO.setVisittype(getParamCodeEntp(enDTO.getVisittype()));
	}
	/**
	 * 将申请信息赋给就诊信息
	 * @param applyDtos
	 * @param enDTO
	 * @param orderItmDtos
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void setApplyInfoToEntInfo(IEOpLisOrDTO[] applyDtos,IEOpLisOrEnDTO enDTO,IEOpLisOrItmDTO[] orderItmDtos) throws BizException {
		if(!OrdEventUtil.isEmpty(applyDtos)) {
			FArrayList2 applyDtoLists=new FArrayList2();
			for(IEOpLisOrDTO applyDto:applyDtos) {
				if(!OrdEventUtil.isEmpty(enDTO.getId_or())&&!OrdEventUtil.isEmpty(applyDto.getId_or())&&enDTO.getId_or().equals(applyDto.getId_or())) {
					applyDtoLists.add(applyDto);
					//将医嘱项目信息赋给申请信息
					setOrdItemInfoToApplyInfo(orderItmDtos,applyDto);
				}
			}
			enDTO.setId_ielisors(applyDtoLists);
		}
	}
	/**
	 * 将医嘱项目信息赋给申请信息
	 * @param orderItmDtos
	 * @param applyDto
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void setOrdItemInfoToApplyInfo(IEOpLisOrItmDTO[] orderItmDtos,IEOpLisOrDTO applyDto) throws BizException {
		if(!OrdEventUtil.isEmpty(orderItmDtos)) {
			FArrayList2 orderItmDtoLists=new FArrayList2();
			for(IEOpLisOrItmDTO orItmDTO:orderItmDtos) {
				if(!OrdEventUtil.isEmpty(orItmDTO.getId_or())&&!OrdEventUtil.isEmpty(applyDto.getId_or())&&orItmDTO.getId_or().equals(applyDto.getId_or())) {
					String id_en = applyDto.getId_ielisoren();
					if(!OrdEventUtil.isEmpty(id_en)) {
						//根据就诊id 获取vip状态
						selectVip(orItmDTO,id_en);
						//身高体重
						selectHeightAndWeigt(orItmDTO, id_en);
						//收费状态标识
						selectPayFlag(orItmDTO);
					}
					orderItmDtoLists.add(orItmDTO);
				}
			}
			applyDto.setId_ielisoritms(orderItmDtoLists);
		}
	}
	/**
	 * 查询vip状态
	 * @param orItmDTO
	 * @param id_en
	 * @throws BizException
	 */
	private void selectVip(IEOpLisOrItmDTO orItmDTO,String id_en) throws BizException{
		IEnOutQryService enOutQryService = (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class.getName());
		try {
			String vip  = enOutQryService.getGcVipTp(id_en);
			orItmDTO.setEu_vip(vip);
		} catch (BizException e) {
			orItmDTO.setEu_vip("");
		}
	}
	/**
	 * 查询身高体重
	 * @param orItmDTO
	 * @param id_en
	 * @throws BizException
	 */
	private void selectHeightAndWeigt(IEOpLisOrItmDTO orItmDTO,String id_en)throws BizException{
		IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
		try {
			String[] arrStrings=id_en.split(",");
			EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
			if(!OrdEventUtil.isEmpty(dto)) {
				//体重
				if(!OrdEventUtil.isEmpty(dto[0].getWeight())) {
					orItmDTO.setWeight(dto[0].getWeight().toString());
				}
				//体重单位
				if(!OrdEventUtil.isEmpty(dto[0].getName_unit_weight())) {
					orItmDTO.setWeilght_unit(dto[0].getName_unit_weight());
				}
				//身高
				if(!OrdEventUtil.isEmpty(dto[0].getHeight())) {
					orItmDTO.setHeight(dto[0].getHeight().toString());
				}
				//身高单位
				if(!OrdEventUtil.isEmpty(dto[0].getName_unit_height())) {
					orItmDTO.setHeight_unit(dto[0].getName_unit_height());
				}
			}
		} catch (Exception e) {
			orItmDTO.setWeight("");
			orItmDTO.setWeilght_unit("");
			orItmDTO.setHeight("");
			orItmDTO.setHeight_unit("");
		}
	}
	/**
	 * 查询收费状态标识
	 * @param orItmDTO
	 * @throws BizException
	 */
	private void selectPayFlag(IEOpLisOrItmDTO orItmDTO) throws BizException{
		String code_or = orItmDTO.getYz_no();
		if(StringUtils.isNotEmpty(code_or)) {
			OrdSrvDO[] ordSrvDOs;
			try {
				ordSrvDOs = OrdEventHelper.getOrdSrvDO(orItmDTO.getId_or());
				if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
					orItmDTO.setPayflag(ordSrvDOs[0].getSd_su_bl());
				}
			} catch (BizException e) {
				orItmDTO.setPayflag("");
			}
		}
	}
}
