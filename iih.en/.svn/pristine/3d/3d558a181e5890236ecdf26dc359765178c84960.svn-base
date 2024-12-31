package iih.en.er.bp.patinfo;


import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgPatInfoRecDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidoclistRService;
/***
 * 获取急诊流转记录
 * 
 * @author fanlq
 *
 */
public class GetUrgPatRecInfoBP {
	/**
	 * 获取急诊患者信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public UrgPatInfoRecDTO[] exec(String entId) throws BizException {
		return getEvtInfo(entId);
	}

	/**
	 * 查询急诊患者信息
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private UrgPatInfoRecDTO[] getEvtInfo(String entId) throws BizException {
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" Select evt.id_ent,");
		sqlSb.append(" evt.dt_evt as dt_send,");
		sqlSb.append(" evt.sd_entevt as evttp,");
		sqlSb.append(" evtp.name as resume,");
		sqlSb.append(" evt.des as des,");
		sqlSb.append(" evt.dt_insert as dt_record,");
		sqlSb.append(" psn.name as emp_record ");
		sqlSb.append(" from en_ent_evt evt ");
		sqlSb.append("left join bd_psndoc psn on evt.id_emp_rec = psn.id_psndoc ");
		sqlSb.append("left join bd_udidoc evtp on evtp.code = evt.sd_entevt and evtp.id_udidoclist = ? ");
		sqlSb.append("where 1=1 ");
		sqlSb.append("and (evt.id_ent = ? or (evt.id_erpre = (select oper.id_erpre from en_ent_op_er oper where oper.id_ent = ? ) and evt.sd_entevt in (?,?))) ");
		sqlSb.append("order by  evt.dt_evt ");
		SqlParam param = new SqlParam();
		param.addParam(this.getUdidocListId());
		param.addParam(entId);
		param.addParam(entId);
		param.addParam(IEnDictCodeConst.SD_ENTEVT_ARRIVEHOS);
		param.addParam(IEnDictCodeConst.SD_ENTEVT_ERPRE);
		@SuppressWarnings("unchecked")
		List<UrgPatInfoRecDTO> list = (List<UrgPatInfoRecDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(UrgPatInfoRecDTO.class));
		UrgPatInfoRecDTO[] dtos = list.toArray(new UrgPatInfoRecDTO[0]);
		return dtos;
	}
	
	/***
	 * 就诊事件自定义档案id-id_udidoclist
	 * @return
	 * @throws BizException
	 */
	private String getUdidocListId() throws BizException{
		IUdidoclistRService listservice = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] listDOs = listservice.findByAttrValString(UdidoclistDO.CODE, IEnDictCodeTypeConst.SD_ENTEVT_TYPE);
		if(!EnValidator.isEmpty(listDOs)){
			return listDOs[0].getId_udidoclist();
		}
		return null;
	}
}
	
	