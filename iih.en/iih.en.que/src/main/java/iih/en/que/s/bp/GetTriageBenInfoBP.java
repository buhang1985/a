package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.fc.queben.d.desc.QueBenDODesc;
import iih.bd.fc.queben.i.IQuebenRService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 获取分诊台信息，包括分诊台名称，当前时间分组，当前分诊台所管理的科室
 * 
 * @author Liu Bin
 *
 */
public class GetTriageBenInfoBP {

	public TriageBenInfoDTO exec(String benId, String code_entp) throws BizException{
		//验证benId是否为空
		if(EnValidator.isEmpty(benId)){
			return null;
		}
		String sctp = getScTp(code_entp);
		//得到当前时间分组
		DaysLotDO dayslot = getCurDaysLot(sctp);
		if(EnValidator.isEmpty(dayslot)){
			return null;
		}
		//得到分诊台信息
		QueBenDO queBen = getQueBenDO(benId);
		if(EnValidator.isEmpty(queBen)){
			return null;
		}
		TriageBenInfoDTO triageInfo = new TriageBenInfoDTO();
		triageInfo.setCode_entp(code_entp);
		triageInfo.setSd_sctp(sctp);
		triageInfo.setId_queben(queBen.getId_queben());
		triageInfo.setName_queben(queBen.getName());
		triageInfo.setEu_pause(queBen.getEu_pause());
		triageInfo.setId_dayslot(dayslot.getId_dayslot());
		triageInfo.setName_dayslot(dayslot.getName());
		triageInfo.setDate(new FDate(dayslot.getDef1()));
		//分诊台所管理的科室
		DeptDO[] depts = getDepts(queBen.getIds_dep_use());
		if(!EnValidator.isEmpty(depts)){
			triageInfo.setDeps(EnAppUtils.doArray2List(depts));
		}
		return triageInfo;
	}
	
	/**
	 * 得到得到当前时间分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDaysLot(String scTp) throws BizException{
		return ServiceFinder.find(IScDaysLotService.class).getNowDaysLotCross(scTp, FBoolean.TRUE);
	}
	/**
	 * 得到分诊台信息
	 * 
	 * @param queBenId
	 * @return
	 * @throws BizException
	 */
	private QueBenDO getQueBenDO(String queBenId) throws BizException{
		IQuebenRService serv = ServiceFinder.find(IQuebenRService.class);
		String whereStr = String.format("%s.%s = '%s' and %s.%s = '%s'", 
				QueBenDODesc.TABLE_ALIAS_NAME, QueBenDO.ID_QUEBEN, queBenId, 
				QueBenDODesc.TABLE_ALIAS_NAME, QueBenDO.SD_QUEBENTP, IBdFcDictCodeConst.SD_QUETP_EMP);
		QueBenDO[] bens = serv.find(whereStr, null, FBoolean.FALSE);
		if(!EnValidator.isEmpty(bens))
			return bens[0];
		return null;
	}
	/**
	 * 分诊台所管理的科室
	 * 
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	private DeptDO[] getDepts(String depIds) throws BizException{
		if(EnValidator.isEmpty(depIds))
			return null;
		IDeptRService serv = ServiceFinder.find(IDeptRService.class);
		return serv.findByIds(depIds.split(","), FBoolean.FALSE);
	}
	/**
	 * 获取排班分类
	 * 
	 * @param code_entp
	 * @return
	 */
	private String getScTp(String code_entp){
		String scTp = IScDictCodeConst.SD_SCTP_OP;
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){
			scTp = IScDictCodeConst.SD_SCTP_JZ;
		}
		return scTp;
	}
}
