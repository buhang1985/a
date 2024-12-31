package iih.ei.std.s.v1.bp.en;

import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.ei.std.d.v1.en.opwaitquebysite.d.OpWaitQueBySiteDTO;
import iih.ei.std.d.v1.en.opwaitquebysite.d.OpWaitQueBySiteParamDTO;
import iih.ei.std.d.v1.en.opwaitquebysite.d.OpWaitQueBySiteResultDTO;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.DaysLotEP;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.en.que.i.IEnQueQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取医生站点候诊队列  BP
 * 
 * @author li.wm
 */
public class GetWaitQueBySiteBP extends IIHServiceBaseBP<OpWaitQueBySiteParamDTO, OpWaitQueBySiteResultDTO> {
	/***
	 * 入参校验
	 */
	@Override
	protected void checkParam(OpWaitQueBySiteParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getCode_site())){
			throw new BizException("站点编码不能为空");
		}
		if(StringUtils.isNullOrEmpty(param.getCode_opr())){
			throw new BizException("未传入操作员编码");
		}
	}
	/****
	 * 核心处理
	 */
	@Override
	protected OpWaitQueBySiteResultDTO process(OpWaitQueBySiteParamDTO param) throws BizException {
		OpWaitQueBySiteResultDTO resultDTO = new OpWaitQueBySiteResultDTO();
		//1.获取站点信息
		QueSiteDO site = getSite(param.getCode_site());
		if(site == null){
			throw new BizException("在IIH中未查询到该站点编码对应的站点信息！站点编码："+ param.getCode_site());
		}
		//2.获取日期分组信息
		DaysLotDO dayslot = new DaysLotEP().getCurDaysLot();
		if(dayslot == null){
			throw new BizException("未查询到到当前午别！");
		}
		//3.获取队列信息
		QueDO que = getQue(site.getId_que());
		if(que == null){
			throw new BizException("在IIH中未查询到队列信息！队列id："+ site.getId_que());
		}
		//4.获取候诊列表患者
		ReceptionQueDTO[] receptionQues = getReceptionQues(que, site, dayslot);
		if(receptionQues == null || receptionQues.length <= 0){
			throw new BizException("未查询到该站点的候诊患者！站点编码：" + param.getCode_site());
		}
		//5.获取正在接诊患者
		ReceptionQueDTO acpt = getCurAcpt(site, dayslot.getId_dayslot());
		//6.组装候诊队列
		List<OpWaitQueBySiteDTO> list = wrapOpWaitQues(receptionQues,acpt,site);
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到该站点的候诊患者！站点编码：" + param.getCode_site());
		}
		resultDTO.setOpwaitquebysite(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	
	}
	
	/**
	 * 组装OpWaitQueDTO
	 * 
	 * @param eqDTOs
	 * @return
	 */
	private List<OpWaitQueBySiteDTO> wrapOpWaitQues(ReceptionQueDTO[] rects,ReceptionQueDTO acpt,QueSiteDO site) throws BizException{
		if(ArrayUtil.isEmpty(rects) && acpt == null)
			return null;
		List<OpWaitQueBySiteDTO> list = new LinkedList<OpWaitQueBySiteDTO>();
		FDateTime curTime = EiAppUtils.getServerDateTime();
		int i=0;
		Integer waInteger = 0; // 等待人数
		if(acpt != null){
			i++;
			OpWaitQueBySiteDTO opWaitQue = new OpWaitQueBySiteDTO();
			opWaitQue.setRow_number(String.valueOf(i));
			opWaitQue.setFg_wait("N");
			assemly(opWaitQue, acpt, site, curTime);
			list.add(opWaitQue);
		}
		int heightLevel = EiParamUtils.getPvOrderAcptLevel();
		if(!ArrayUtil.isEmpty(rects)){
			for(ReceptionQueDTO rect : rects) {
				if(EiValidator.isNotEmptyIgnoreBlank(rect.getLevel_pri())){
					if(Integer.parseInt(rect.getLevel_pri()) >= heightLevel){
						continue;
					}
				}
				i++;
				OpWaitQueBySiteDTO opWaitQue = new OpWaitQueBySiteDTO();
				opWaitQue.setRow_number(String.valueOf(i));
				opWaitQue.setFg_wait("Y");
				if(!IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME.equals(rect.getSd_status_acpt())){
					opWaitQue.setWait_number(waInteger.toString());
					waInteger++;
				}else{
					opWaitQue.setWait_number("-");
				}
				assemly(opWaitQue, rect, site, curTime);
				if(FBoolean.TRUE.equals(rect.getFg_needrtn()))
					opWaitQue.setFg_rtn("Y");
				else
					opWaitQue.setFg_rtn("N");
				list.add(opWaitQue);
			}
		}
		return list;
	}
	/**
	 * 组装数据
	 * 
	 * @param opWaitQue
	 * @param rect
	 * @param site
	 * @param curTime
	 * @throws BizException
	 */
	private void assemly(OpWaitQueBySiteDTO opWaitQue, ReceptionQueDTO rect, QueSiteDO site, FDateTime curTime)throws BizException{
		opWaitQue.setCode_ticket(rect.getTicketno());
		opWaitQue.setCode_pat(rect.getCode_pat());
		opWaitQue.setName_pat(rect.getName_pat());
		opWaitQue.setTimes_op(rect.getTimes_op());
		opWaitQue.setCode_ent(rect.getCode_ent());
		opWaitQue.setRoom_ent(site.getRoom() + site.getName());
		opWaitQue.setId_ent(rect.getId_ent());
		opWaitQue.setId_ent_que(rect.getId_ent_que());
		opWaitQue.setSortno_called(rect.getSortno_called());
		opWaitQue.setCode_entstatus(rect.getSd_status());
		opWaitQue.setCode_questatus(rect.getSd_status_acpt());
		opWaitQue.setId_que_site(rect.getId_que_site());
		opWaitQue.setDt_birth_pat(rect.getDt_birth_pat());
		opWaitQue.setLevel_pri(rect.getSd_lev());
	}
	/**
	 * 设置当前接诊者序号
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private ReceptionQueDTO getCurAcpt(QueSiteDO site, String dayslotId) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EQ.ID_ENT ");
		sb.append("FROM EN_ENT_QUE EQ  ");
		sb.append("WHERE EQ.SD_STATUS_ACPT = ? ");
		sb.append("AND EQ.DT_REGIST = ? ");
		sb.append("AND EQ.ID_DATESLOT = ? ");
		sb.append("AND EQ.ID_QUE_SITE = ? ");
		sb.append("AND EQ.Sd_entque_tp = ? ");
		sb.append("ORDER BY EQ.DT_ACPT DESC ");
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(EiAppUtils.getServerDate());
		param.addParam(dayslotId);
		param.addParam(site.getId_quesite());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if (!ListUtil.isEmpty(list)) {
			return ServiceFinder.find(IEnQueQryService.class).getReceptionQueByEntId(list.get(0));
		}
		return null;
	}
	/**
	 * 获取候诊队列数据
	 * 
	 * @param ques
	 * @param site
	 * @param dayslot
	 * @return
	 * @throws BizException 
	 */
	private ReceptionQueDTO[] getReceptionQues(QueDO que, QueSiteDO site, DaysLotDO dayslot) throws BizException{
		IEnQueQryService serv = ServiceFinder.find(IEnQueQryService.class);
		EnTrDocSiteInfoDTO siteInfo = new EnTrDocSiteInfoDTO();	
		siteInfo.setId_quesite(site.getId_quesite());
		siteInfo.setId_dayslot(dayslot.getId_dayslot());
		siteInfo.setId_queben(site.getId_queben());
		siteInfo.setId_dep(site.getId_dep());
		siteInfo.setId_emp(site.getId_emp());
		siteInfo.setDate(new FDate(dayslot.getDef1()));
		siteInfo.setId_ques(EiAppUtils.objArray2List(que != null ? que.getId_que() : null));
		return serv.getDocAcptList(que, site, siteInfo, "Wait");
	}
	
	/**
	 * 获取队列
	 * 
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	private QueDO getQue(String queId) throws BizException {
		if(!EiValidator.isNotEmptyIgnoreBlank(queId))
			return null;
		return ServiceFinder.find(IQueRService.class).findById(queId);
	}
	
	/**
	 * 获取站点信息
	 * 
	 * @param siteCode
	 * @return
	 * @throws BizException
	 */
	private QueSiteDO getSite(String siteCode) throws BizException {
		String whereStr = String.format(" Code = '%s' and Sd_quesitetp = '%s' ", siteCode, IBdFcDictCodeConst.SD_QUESITETP_OP);
		IQuesiteRService serv = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO[] sites = serv.find(whereStr, null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(sites))
			return null;
		QueSiteDO site = sites[0];
		if(!PauseEnum.ONLINE.equals(site.getEu_pause()))
			return null;
		return site;
	}
	
}
