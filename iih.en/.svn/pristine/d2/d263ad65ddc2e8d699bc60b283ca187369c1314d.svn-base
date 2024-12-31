package iih.en.que.s.event.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/****
 * 组装药房LED的上屏数据
 * @author fanlq
 *
 */
public class WrapObj2DrugQue4EsBP {

	/****
	 * 组装数据源
	 * @param id_quesit
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public AllQue4EsDTO exec(String quesiteId,String entqueId,String presids,String event) throws BizException{
		if(EnValidator.isEmpty(event) || EnValidator.isEmpty(quesiteId))
			return null;
		// 1.设置站点信息
		QueSiteDO site = new BdSiteEP().getSiteById(quesiteId);
		// 2.获取药房队列
		/*String depId = EnContextUtils.getDeptId();
		GetPharmQueByDepBP getPharamQueBP = new GetPharmQueByDepBP();
		QueDO queDO = getPharamQueBP.exec(depId);
		if (queDO == null) {
			throw new BizException("科室：" + depId + "的队列不存在");
		}*/
		if (site == null) {
			throw new BizException("该队列的药房站点为空!");
		}
		IQueRService queRService = ServiceFinder.find(IQueRService.class);
		QueDO queDO = queRService.findById(site.getId_que());
		
		// 3.获取药房上屏的站点相关数据
		AllQue4EsDTO allQue4EsDTO = this.setDrugBrdInfo(site,queDO);
		//获取要上屏或者下屏的就诊队列
		EnQueueDO enQueueDO = new EnQueEP().getEnQueueById(entqueId);
		if(enQueueDO != null ){
			allQue4EsDTO.setId_ent(enQueueDO.getId_ent());
			allQue4EsDTO.setName_pat(enQueueDO.getName_pat());
				if(enQueueDO.getSortno() != null){
					allQue4EsDTO.setTickno(enQueueDO.getSortno().toString());
			}
				this.setCodePat(allQue4EsDTO,enQueueDO);
		}
		return allQue4EsDTO;
	}
	/***
	 * 设置患者编码
	 * @param allQue4EsDTO
	 * @param enQueueDO
	 * @return
	 * @throws BizException 
	 */
	private AllQue4EsDTO setCodePat(AllQue4EsDTO allQue4EsDTO,EnQueueDO enQueueDO) throws BizException{
		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO pat = service.findById(enQueueDO.getId_pat());
		if(pat != null){
			allQue4EsDTO.setCode_pat(pat.getCode());
		}
		return allQue4EsDTO;
	}
	/****
	 * 获取药房上屏的站点相关数据
	 * @param site 站点do
	 * @param queDO 队列do
	 * @return
	 */
	public AllQue4EsDTO setDrugBrdInfo(QueSiteDO site,QueDO queDO){
		AllQue4EsDTO allQue4EsDTO = new AllQue4EsDTO();
		if (site.getShortname() == null) {
			allQue4EsDTO.setCode_room(site.getName());
		} else {
			allQue4EsDTO.setCode_room(site.getShortname());
		}
		allQue4EsDTO.setName_room(site.getName());
		allQue4EsDTO.setAddr_board_site(site.getAddr_board());
		allQue4EsDTO.setId_quesite(site.getId_quesite());
		allQue4EsDTO.setCode_quesite(site.getCode());
		allQue4EsDTO.setName_quesite(site.getName());
		if (site.getId_emp() != null) {
			allQue4EsDTO.setId_doc(site.getId_emp());
			allQue4EsDTO.setCode_doc(site.getEmp_code());
			allQue4EsDTO.setName_doc(site.getEmp_name());
		} else {
			allQue4EsDTO.setId_doc(allQue4EsDTO.getId_doc());
			allQue4EsDTO.setCode_doc(allQue4EsDTO.getCode_doc());
			allQue4EsDTO.setName_doc(allQue4EsDTO.getName_doc());
		}
		allQue4EsDTO.setId_que(queDO.getId_que());
		allQue4EsDTO.setCode_que(queDO.getCode());
		allQue4EsDTO.setCode_dep(queDO.getCode_dep());
		allQue4EsDTO.setName_dep(queDO.getName_dep());
		allQue4EsDTO.setAddr_board_ben(queDO.getAddr_board_ben());
		allQue4EsDTO.setAddr_board_que(queDO.getAddr_board());
		return allQue4EsDTO;
	}
	
	/***
	 * 获取药房队列中签到、配药、叫号的患者 
	 * @param que
	 * @param queSite
	 * @param date
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getBrdEntInfo(String entId,String presid) throws BizException{
		String whereStr = String.format(" %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' AND %s.ID_ENT = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_PHARMACY,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE,
				EnQueueDODesc.TABLE_ALIAS_NAME,entId);
				//EnQueueDODesc.TABLE_ALIAS_NAME,presid);
		String orderStr = String.format(" %s.SORTNO_CALLED, %s.Sortno ", EnQueueDODesc.TABLE_ALIAS_NAME, EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
}
