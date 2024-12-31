package iih.en.que.s.event.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.OpQue4EsDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * OpQue4EsDTO组装
 * 
 * @author liubin
 *
 */
public class WrapObj2OpQue4EsBP {
	
	/**
	 * 包装OpQue4EsDTO
	 * 
	 * @param queId 队列ID
	 * @param siteId 站点ID
	 * @param entId 就诊ID
	 * @throws BizException 
	 */
	public OpQue4EsDTO wrap(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		OpQue4EsDTO es = null;
		//获取队列和站点ID，fanlq - 2017-08-18
		if (!EnValidator.isEmpty(entId)) {
			es = this.setQueSiteEntpId(es, entId);
		} else{
			if(!EnValidator.isEmpty(queId)){
				// 1.设置队列信息
				es = this.setQueInfo(es, queId);
			}
			if(!EnValidator.isEmpty(siteId)){
				// 2.设置站点信息
				es = this.setSiteInfo(es, siteId);
			}
			//设置就诊类型
			es = this.setEnTpInfo(es, codeEnTp);
		}
		if(!EnValidator.isEmpty(queId) && EnValidator.isEmpty(es.getId_que())){
			es.setId_que(queId);
		}
		if(!EnValidator.isEmpty(siteId) && EnValidator.isEmpty(es.getId_que_site())){
			es.setId_que_site(siteId);
		}
		es.setId_ent(entId);
		return es;
	}
	
	/**
	 * 医生站下线，fanlq 2017-08-24 包装OpQue4EsDTO
	 * 
	 * @param queId
	 *            队列ID
	 * @param siteId
	 *            站点ID
	 * @param entId
	 *            就诊ID
	 * 
	 * @throws BizException
	 */
	public OpQue4EsDTO wrapLogOut(String queId, String siteId, String codeEnTp, String entId, String empId) throws BizException {
		OpQue4EsDTO es = null;
		if (!EnValidator.isEmpty(entId)) {
			es = this.setQueSiteId(es, entId);
		} else{
			if(!EnValidator.isEmpty(queId)){
				// 1.设置队列信息
				es = this.setQueInfo(es, queId);
			}
			if(!EnValidator.isEmpty(siteId)){
				// 2.设置站点信息
				es = this.setSiteInfo(es, siteId);
			}
			if(!EnValidator.isEmpty(empId)){
				// 3.设置医生信息
				es = this.setEmpInfo(es, empId);
			}
			//设置就诊类型
			es = this.setEnTpInfo(es, codeEnTp);
		}
		if(!EnValidator.isEmpty(queId) && EnValidator.isEmpty(es.getId_que())){
			es.setId_que(queId);
		}
		if(!EnValidator.isEmpty(siteId) && EnValidator.isEmpty(es.getId_que_site())){
			es.setId_que_site(siteId);
		}
		es.setId_ent(entId);
		return es;
	}
	
	/**
	 * 设置队列信息
	 * 
	 * @param queId
	 * @return
	 */
	private OpQue4EsDTO setQueInfo(OpQue4EsDTO es, String queId){
		if(!EnValidator.isEmpty(queId)){
			if(es == null)
				es = new OpQue4EsDTO();
			es.setId_que(queId);
		}else{
			Logger.info("Id_que为空！");
		}
		return es;
	}
	/**
	 * 设置站点信息
	 * 
	 * @param queId
	 * @return
	 * @throws BizException 
	 */
	private OpQue4EsDTO setSiteInfo(OpQue4EsDTO es, String siteId) throws BizException{
		if(!EnValidator.isEmpty(siteId)){
			if(es == null)
				es = new OpQue4EsDTO();
			es.setId_que_site(siteId);
			BdSiteEP ep = new BdSiteEP();
			QueSiteDO site = ep.getSiteByPK(siteId);
			if(site != null){
				es.setCode_room(site.getCode());
				es.setName_room(site.getName());
				es.setId_doc(site.getId_emp());
			}
		}else {
			Logger.info("Id_que_site为空！");
		}
		return es;
	}
	
	/**
	 * 设置就诊类型CODE
	 * 
	 * @param queId
	 * @return
	 */
	private OpQue4EsDTO setEnTpInfo(OpQue4EsDTO es, String codeEnTp){
		if(!EnValidator.isEmpty(codeEnTp)){
			if(es == null)
				es = new OpQue4EsDTO();
			es.setCode_entp(codeEnTp);
		}else{
			Logger.info("Code_entp为空！");
		}
		return es;
	}
	
	/**
	 * 设置站点ID,队列ID,就诊类型CODE
	 * 
	 * @param es
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private OpQue4EsDTO setQueSiteEntpId(OpQue4EsDTO es, String entId) throws BizException {
		if (es == null)
			es = new OpQue4EsDTO();
		if (!EnValidator.isEmpty(entId)) {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT QUE.ID_QUE,");
			sb.append("QUE.ID_QUE_SITE, ");
			sb.append("QUE.CODE_ENTP ");
			sb.append("FROM EN_ENT ENT ");
			sb.append("LEFT JOIN EN_ENT_QUE QUE ON ENT.ID_ENT = QUE.ID_ENT ");
			sb.append("WHERE ENT.ID_ENT = ? ");
			String sql = sb.toString();
			SqlParam param = new SqlParam();
			param.addParam(entId);
			List<OpQue4EsDTO> list = (List<OpQue4EsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpQue4EsDTO.class));
			if (!ListUtil.isEmpty(list)) {
				OpQue4EsDTO e = list.get(0);
				es.setId_que(e.getId_que());
				es.setId_que_site(e.getId_que_site());
				es.setCode_entp(e.getCode_entp());
			}
		} else {
			Logger.info("Id_ent为空！");
		}
		return es;
	}

	/**
	 * 设置站点和队列ID
	 * 
	 * @param es
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private OpQue4EsDTO setQueSiteId(OpQue4EsDTO es, String entId) throws BizException {
		if (es == null)
			es = new OpQue4EsDTO();
		if (!EnValidator.isEmpty(entId)) {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT QUE.ID_QUE,");
			sb.append("QUE.ID_QUE_SITE ");
			sb.append("FROM EN_ENT ENT ");
			sb.append("LEFT JOIN EN_ENT_QUE QUE ON ENT.ID_ENT = QUE.ID_ENT ");
			sb.append("WHERE ENT.ID_ENT = ? ");
			sb.append("AND QUE.SD_ENTQUE_TP = ? ");
			String sql = sb.toString();
			SqlParam param = new SqlParam();
			param.addParam(entId);
			param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
			List<OpQue4EsDTO> list = (List<OpQue4EsDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpQue4EsDTO.class));
			if (!EnValidator.isEmpty(list)) {
				OpQue4EsDTO e = list.get(0);
				es.setId_que(e.getId_que());
				es.setId_que_site(e.getId_que_site());
			}
		} else {
			Logger.info("Id_ent为空！");
		}
		return es;
	}
	
	/**
	 * 设置医生信息
	 * 
	 * @param empId
	 *            fanlq-2017-08-24
	 * @return
	 */
	private OpQue4EsDTO setEmpInfo(OpQue4EsDTO es, String empId) throws BizException {
		if (!EnValidator.isEmpty(empId)) {
			if (es == null)
				es = new OpQue4EsDTO();
			es.setId_doc(empId);
			IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
			PsnDocDO docDo = service.findById(empId);
			if (docDo == null)
				return es;
			es.setCode_doc(docDo.getCode());
			es.setName_doc(docDo.getName());
		} else {
			Logger.info("Id_doc为空！");
		}
		return es;
	}
}
