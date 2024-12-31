package iih.pi.reg.s.wsstd.bp.elehealcard;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bl.itf.std.bean.input.charge.sub.WsParamSelfHelpPricingInfo;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDOCudService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import iih.pi.reg.s.wsstd.bp.PiItfBaseBP;
import iih.pi.reg.s.wsstd.bp.validator.WsParamUpdateEleHealCardValidator;
import iih.pi.reg.wsstd.bean.input.elehealcard.WsParamUpdateEleHealCard;
import iih.pi.reg.wsstd.bean.input.elehealcard.sub.WsParamUpdateEleHealCardInfo;
import iih.pi.reg.wsstd.bean.input.patreg.WsParamPatRegAndDistCard;
import iih.pi.reg.wsstd.bean.output.WsResultMsg;
import iih.pi.reg.wsstd.bean.output.elehealcard.WsResultUpdateEleHealCard;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 更新电子健康卡(该接口的基础是患者已建档)
 * 
 * @author shaokx 2019/06/13
 *
 */
public class UpdateEleHealCardBp extends PiItfBaseBP<WsParamUpdateEleHealCard> {

	@Override
	protected String getBusiness() {
		
		return "更新电子健康卡";
	}

	@Override
	protected void checkParam(WsParamUpdateEleHealCard param) throws BizException {
		WsParamUpdateEleHealCardValidator validator = new WsParamUpdateEleHealCardValidator();
		validator.validate(param);
		
		WsParamUpdateEleHealCardInfo prepayInfo = param.getPrepay();
		if(!StringUtil.isEmpty(prepayInfo.getOperaCode())){
			// 设置人员上下文
			PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCode());
			if (psndocDO == null) {
				throw new BizException("更新电子健康卡:未查询到人员信息");
			}
			Context.get().setStuffId(psndocDO.getId_psndoc());
		}
	}

	@Override
	protected String doWork(WsParamUpdateEleHealCard param) throws BizException {
		WsParamUpdateEleHealCardInfo prepayInfo = param.getPrepay();
		// 患者信息 基础服务
		IPiPatCardDOCudService CardCud = ServiceFinder.find(IPiPatCardDOCudService.class);
		
		// 查询患者信息
		String patId = this.findPat(prepayInfo);
		
		if("01".equals(prepayInfo.getDoType())){
			// 校验电子健康卡在iih数据库中是否存在（存在则返回异常，不存在则继续流程）
			this.checkIsExistEcode(prepayInfo);
			
			// 01 根据建档患者绑定ecode
			PiPatCardDO piPatCardDo = this.assemblePatCardData(patId,prepayInfo);//组装患者电子卡数据源
			PiPatCardDO[] piPatCardDOs = CardCud.save(new PiPatCardDO[] { piPatCardDo });
			if(!ArrayUtil.isEmpty(piPatCardDOs)){
				// 出参
				WsResultUpdateEleHealCard outputParam = new WsResultUpdateEleHealCard();//出参
				WsResultMsg resultMsg = new WsResultMsg();
				resultMsg.setCode("0");
				resultMsg.setMessage("绑卡成功");
				outputParam.setRltMsg(resultMsg);
				return outputParam.serialize();
			}else{
				throw new BizException("绑卡失败");
			}
		}else if("02".equals(prepayInfo.getDoType())){
			// 02 解除绑定ecode
			//根据电子健康卡号和患者id_pat查询出pi_pat_card的一条数据然后删除
			String sql = String.format(" select * from pi_pat_card where id_pat = '%s' and code = '%s' ", patId,prepayInfo.geteCode());
			PiPatCardDO patCardDO = (PiPatCardDO) new DAFacade().execQuery(sql, new BeanHandler(PiPatCardDO.class));
			if(patCardDO == null){
				throw new BizException("未查询到该患者的电子健康卡");
			}
			patCardDO.setStatus(DOStatus.DELETED);
			PiPatCardDO[] delePatCardDos = CardCud.save(new PiPatCardDO[] { patCardDO });
			
			// 出参
			WsResultUpdateEleHealCard outputParam = new WsResultUpdateEleHealCard();//出参
			WsResultMsg resultMsg = new WsResultMsg();
			resultMsg.setCode("0");
			resultMsg.setMessage("解绑成功");
			outputParam.setRltMsg(resultMsg);
			return outputParam.serialize();
			
		}else{
			throw new BizException("入参操作动作值不正确");
		}
		
	}

	/**
	 * 组装患者电子卡数据源
	 * @throws BizException 
	 */
	private PiPatCardDO assemblePatCardData(String patId,WsParamUpdateEleHealCardInfo prepayInfo) throws BizException{
		PiPatCardDO patCardDO = new PiPatCardDO();
		patCardDO.setId_pat(patId);
		// 患者卡类型编码
		patCardDO.setSd_patcardtp(IPiDictCodeConst.SD_CARD_TYPE_HEALTH);
		String sql = String.format(" select * from pi_pat_cardtp where code = '%s' ", IPiDictCodeConst.SD_CARD_TYPE_HEALTH);
		PiPatCardTpDO patCardTpDO = (PiPatCardTpDO) new DAFacade().execQuery(sql, new BeanHandler(PiPatCardTpDO.class));
		// 患者卡类型id
		patCardDO.setId_patcardtp(patCardTpDO == null ? null : patCardTpDO.getId_cardtp());
		patCardDO.setCode(prepayInfo.geteCode());
		patCardDO.setFg_def(FBoolean.FALSE);
		patCardDO.setDt_b(new FDateTime());
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setFg_act(FBoolean.TRUE);
		patCardDO.setStatus(DOStatus.NEW);
		PiPatCardDO[] haveOtherCard = getPiPatCard(patId);
		// 已经有的卡数量+1
		patCardDO.setSortno(haveOtherCard.length + 1);
		
		return patCardDO;
	}
	
	/**
	 * 获取患者其他的卡
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO[] getPiPatCard(String patId) throws BizException{
		IPiPatCardDORService piPatCardDORService = ServiceFinder.find(IPiPatCardDORService.class);
		PiPatCardDO[] patCardDOs = piPatCardDORService.findByAttrValString("Id_pat", patId);
		if (ArrayUtils.isEmpty(patCardDOs)) {
			// 患者有档案，但没有就诊卡
			return new PiPatCardDO[0];
		}
		// 患者有档案，已有就诊卡，说明该患者有其他卡
		return patCardDOs;
	}
	
	/**
	 * 校验电子健康卡在iih数据库中是否存在（存在则返回异常，不存在则继续流程）
	 * @param patId
	 * @param prepayInfo
	 * @throws BizException 
	 */
	private void checkIsExistEcode(WsParamUpdateEleHealCardInfo prepayInfo) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" id_pat,id_patcardtp,sd_patcardtp,code,fg_act ");
		sql.append(" from pi_pat_card ");
		sql.append(" where sd_patcardtp = ? ");
		sql.append(" and code = ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(IPiDictCodeConst.SD_CARD_TYPE_HEALTH);
		param.addParam(prepayInfo.geteCode());
		
		List<PiPatCardDO> list = (List<PiPatCardDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(PiPatCardDO.class));
		

		if(!ListUtil.isEmpty(list)){
			throw new BizException("该电子健康卡号已存在");
		}
	}
	
	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamUpdateEleHealCardInfo prepayInfo) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(prepayInfo.getPatCode());
		condDto.setId_code(prepayInfo.getSdCode());
		condDto.setCard_code(prepayInfo.getCardCode());
		condDto.setCode_amr_ip(prepayInfo.getIPCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}
}
