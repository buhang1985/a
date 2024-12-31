package iih.pi.reg.s.bp.listener;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.uniquemanage.d.PiPatDealRltDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatRegistRltDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueDeleteCondDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.i.IPiPatUniqueManageService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

/**
 * 患者第三方平台唯一性管理监听
 * @author ly 2019/02/18
 *
 */
public class PiPatUniqueManageListener implements IBusinessListener {

	private IPiPatUniqueManageService uniqueService;
	
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		
		BDCommonEvent bdcEvent = (BDCommonEvent) event;
		if (!PatiAggDO.class.getName().equals(bdcEvent.getSourceID())) {
			return;
		}
		if (StringUtils.isEmpty(bdcEvent.getEventType())) {
			return;
		}
		
		PiParams piParams = new PiParams();
		if(FBoolean.FALSE.equals(piParams.PIPAT0021()))
			return;
	
		this.uniqueService = ServiceFinder.find(IPiPatUniqueManageService.class);
		if(this.uniqueService == null)
			return;

		PatiAggDO[] newPatAggs = getPatAggs(bdcEvent.getNewObjs());
		PatiAggDO[] oldPatAggs = getPatAggs(bdcEvent.getOldObjs());

		if (ArrayUtil.isEmpty(newPatAggs)) {
			return;
		}

		for (int i = 0; i < newPatAggs.length; i++) {
			
			PatiAggDO newPatAgg = newPatAggs[i];
			PatiAggDO oldPatAgg = (oldPatAggs != null && oldPatAggs.length > i) ? oldPatAggs[i] : null;

			if(IPiPatConst.PAT_THIRD_PLATFORM.equals(newPatAgg.getParentDO().getOrigin()))
				continue;
			
			switch (event.getEventType()) {
			case IEventType.TYPE_INSERT_AFTER:
				this.invokeInsert(newPatAgg);
				break;
			case IEventType.TYPE_UPDATE_AFTER:
				this.invokeUpdate(newPatAgg, oldPatAgg);
				break;
			case IEventType.TYPE_DELETE_AFTER:
				this.invokeDelete(newPatAgg);
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * 将Obj数组转换为患者Agg集合
	 * 
	 * @param objs
	 * @return
	 */
	private PatiAggDO[] getPatAggs(Object[] objs) {
		if (objs == null || objs.length <= 0) {
			return null;
		}

		ArrayList<PatiAggDO> patiAggList = new ArrayList<PatiAggDO>();
		for (Object obj : objs) {
			if (obj instanceof PatiAggDO) {
				patiAggList.add((PatiAggDO) obj);
			}
		}
		return patiAggList.toArray(new PatiAggDO[0]);
	}

	/**
	 * 插入处理
	 * @param newPatAgg
	 * @throws BizException
	 */
	private void invokeInsert(PatiAggDO newPatAgg) throws BizException{
	
		PiPatRegistRltDTO rltDto = this.uniqueService.registerPatient(newPatAgg);
		//添加返回值为null 处理 zx
		if(rltDto==null){
			return;
		}
		if(FBoolean.FALSE.equals(rltDto.getFg_result())){
			throw new BizException(rltDto.getError_msg());
		}
		//回写id及编码
		PatDO patDO = newPatAgg.getParentDO();
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		if(StringUtils.isNotEmpty(rltDto.getId_third())){
			patDO.setId_third(rltDto.getId_third());
			daf.updateDO(patDO, new String[] { PatDO.ID_THIRD });
		}
		//电子健康卡 改为存 pi_pat_card 
		PiPatCardDO patCardData = this.assemblePatCardData(patDO,rltDto);
		daf.insertDO(patCardData);
	}
	/**
	 * 组装患者卡数据
	 * @param patDO
	 * @param rltDto
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO assemblePatCardData(PatDO patDO, PiPatRegistRltDTO rltDto) throws BizException {
		PiPatCardDO patCardDO = new PiPatCardDO();
		DAFacade daf = new DAFacade();
		patCardDO.setId_pat(patDO.getId_pat());
		// 患者卡类型编码
		patCardDO.setSd_patcardtp(IPiDictCodeConst.SD_CARD_TYPE_HEALTH);
		String sql2 = String.format("select * from pi_pat_cardtp where code = '%s' ",
				IPiDictCodeConst.SD_CARD_TYPE_HEALTH);
		PiPatCardTpDO patCardTpDO = (PiPatCardTpDO) daf.execQuery(sql2, new BeanHandler(PiPatCardTpDO.class));
		// 患者卡类型id
		patCardDO.setId_patcardtp(patCardTpDO.getId_cardtp());
		patCardDO.setCode(rltDto.getCode_third());
		patCardDO.setFg_def(FBoolean.FALSE);
		patCardDO.setDt_b(new FDateTime());
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setFg_act(FBoolean.TRUE);
		patCardDO.setStatus(DOStatus.NEW);
		PiPatCardDO[] haveOtherCard = getPiPatCard(patDO.getId_pat());
		// 已经有的卡数量+1
		patCardDO.setSortno(haveOtherCard.length + 1);

		return patCardDO;
	}
	/**
	 * 校验患者否有其他的卡
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO[] getPiPatCard(String patId) throws BizException {
		if (patId == null) {
			// 患者无档案
			return new PiPatCardDO[0];
		} else {
			IPiPatCardDORService piPatCardDORService = ServiceFinder.find(IPiPatCardDORService.class);
			PiPatCardDO[] patCardDOs = piPatCardDORService.findByAttrValString("Id_pat", patId);
			if (ArrayUtils.isEmpty(patCardDOs)) {
				// 患者有档案，但没有就诊卡
				return new PiPatCardDO[0];
			}
			// 患者有档案，已有就诊卡，说明该患者有其他卡
			return patCardDOs;
		}
	}
	/**
	 * 更新处理
	 * @param newPatAgg
	 * @param oldPatAgg
	 * @throws BizException
	 */
	private void invokeUpdate(PatiAggDO newPatAgg, PatiAggDO oldPatAgg) throws BizException{
			
		PiPatDealRltDTO rltDto = this.uniqueService.updatePatient(newPatAgg, oldPatAgg);
		//添加返回值为null 处理 zx
		if(rltDto==null){
			return;
		}
		if(FBoolean.FALSE.equals(rltDto.getFg_result())){
			throw new BizException(rltDto.getError_msg());
		}
	}

	/**
	 * 删除处理
	 * @param newPatAgg
	 * @throws BizException
	 */
	private void invokeDelete(PatiAggDO newPatAgg) throws BizException{
		
		PiPatUniqueDeleteCondDTO delCondDto = new PiPatUniqueDeleteCondDTO();
		PatDO patDO = newPatAgg.getParentDO();
		delCondDto.setId_third(patDO.getId_third());
		delCondDto.setCode_third(patDO.getBarcode_chis());
		delCondDto.setId_idtp(patDO.getId_idtp());
		delCondDto.setSd_idtp(patDO.getSd_idtp());
		delCondDto.setId_code(patDO.getId_code());
		
		PiPatDealRltDTO rltDto = this.uniqueService.deletePatient(delCondDto);
		//添加返回值为null 处理 zx
		if(rltDto==null){
			return;
		}
		if(FBoolean.FALSE.equals(rltDto.getFg_result())){
			throw new BizException(rltDto.getError_msg());
		}
	}
}
