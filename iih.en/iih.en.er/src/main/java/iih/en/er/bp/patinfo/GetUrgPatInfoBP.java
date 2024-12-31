package iih.en.er.bp.patinfo;


import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.er.dto.d.UrgPatInfoDTO;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.op.i.IEnentoperRService;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.d.EnErPreScoreDO;
import iih.en.er.pre.i.IEnerpreRService;
import iih.en.er.pre.i.IEnerprescoredoRService;
import iih.en.pv.sco.scotp.d.EnScoTpDO;
import iih.en.pv.sco.scotp.i.IEnscotpRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUrgPatInfoBP {
	/**
	 * 获取急诊患者信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public UrgPatInfoDTO exec(String entId) throws BizException {
		UrgPatInfoDTO urgpat = null;
		//1.查询急诊患者信息
		urgpat = this.getEntInfo(entId);
		//2.查询预检信息
		this.getEnErPreInfo(urgpat);
		return urgpat;
	}

	/**
	 * 查询预检信息及年龄
	 * @param urgpat
	 * @throws BizException 
	 */
	private void getEnErPreInfo(UrgPatInfoDTO urgpat) throws BizException {
		//设置年龄
		urgpat.setAge(AgeCalcUtil.getAge(urgpat.getD_birth()));
		//设置预检信息
		IEnentoperRService serv2 = ServiceFinder.find(IEnentoperRService.class);
		EnEntOpErDO[] enEntOpErDOs = serv2.findByAttrValString(EnEntOpErDO.ID_ENT, urgpat.getId_ent());
		if(enEntOpErDOs == null || enEntOpErDOs.length <= 0){
			return;
		}
		EnEntOpErDO opdo = enEntOpErDOs[0];
		urgpat.setId_erpre(opdo.getId_erpre());
		IEnerpreRService serv = ServiceFinder.find(IEnerpreRService.class);
		EnErPreDO erpre = serv.findById(opdo.getId_erpre());
		if(erpre == null){
			return ;
		}
		urgpat.setDt_entry(erpre.getDt_entry());
		urgpat.setName_green_channel(erpre.getNames_green_channel());
		urgpat.setLevel(opdo.getName_scale_triage()); 
		//设置评分
		//urgpat.setNews(erpre.getSd_scale_news());
		//urgpat.setApac(erpre.getsd_scale); //Apac得分暂放??
		//urgpat.setGsc(erpre.getSd_scale_gsc());
		this.setScoreInfo(urgpat);
		FDateTime nowTime = EnAppUtils.getServerDateTime();
		if(erpre.getDt_entry() == null){
			return;
		}
		urgpat.setTime(erpre.getDt_end() == null? DateTimeUtils.getTimeLength(erpre.getDt_entry(), nowTime): DateTimeUtils.getTimeLength(erpre.getDt_entry(), erpre.getDt_end()));
	}
	
	/**
	 * 设置评分
	 * 
	 * @param urgpat
	 * @throws BizException 
	 */
	private void setScoreInfo(UrgPatInfoDTO urgpat) throws BizException {
		IEnerprescoredoRService serv = ServiceFinder.find(IEnerprescoredoRService.class);
		EnErPreScoreDO[] scoredos = serv.find(String.format(" ID_ERPRE = '%s' ",urgpat.getId_erpre()),"", FBoolean.FALSE);
		if(scoredos == null || scoredos.length <=0){
			return;
		}
		StringBuffer sqlSb = new StringBuffer();
		for (EnErPreScoreDO enErPreScoreDO : scoredos) {
			IEnscotpRService rserv=ServiceFinder.find(IEnscotpRService.class);
			EnScoTpDO sco = rserv.findById(enErPreScoreDO.getId_scotp());
			if(sco == null){
				break;
			}
			String scodesc = sco.getName()+":"+enErPreScoreDO.getScore()+" ";
			sqlSb.append(scodesc);
		}
		urgpat.setScore(sqlSb.toString());
	}

	/**
	 * 查询急诊患者信息
	 * @param entId
	 * @return
	 * @throws DAException
	 */
	private UrgPatInfoDTO getEntInfo(String entId) throws DAException {
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" Select ent.id_ent,");
		sqlSb.append(" ent.name_pat as name,");
		sqlSb.append(" ent.telno_pat as tel,");
		sqlSb.append(" ent.dt_birth_pat as d_birth,");
		sqlSb.append(" ent.addr_pat as name_admdiv,");
		sqlSb.append(" pat.code ,");
		sqlSb.append(" addr.street as street,");
		sqlSb.append(" dep.name as name_dep_phy,");
		sqlSb.append(" nur.name as name_dep_nur,");
		sqlSb.append(" bed.name as name_bed,");
		sqlSb.append(" psn.name as name_emp_phy ,");
		sqlSb.append(" al.name_alcla as name_altp ,");
		sqlSb.append(" udi.name as sex,");
		sqlSb.append(" udi2.name as marriage");
		sqlSb.append(" from en_ent ent left join pi_pat pat on ent.id_pat = pat.id_pat ");
		sqlSb.append("left join bd_udidoc udi on ent.id_sex_pat = udi.id_udidoc ");
		sqlSb.append("left join bd_udidoc udi2 on ent.id_mari_pat = udi2.id_udidoc ");
		sqlSb.append("left join bd_dep dep on ent.id_dep_phy = dep.id_dep ");
		sqlSb.append("left join bd_dep nur on ent.id_dep_nur = nur.id_dep ");
		sqlSb.append("left join bd_psndoc psn on ent.id_emp_phy = psn.id_psndoc ");
		sqlSb.append("left join pi_pat_addr addr on pat.id_pat = addr.id_pat ");
		sqlSb.append("left join pi_pat_al al on ent.id_pat = al.id_pat ");
		sqlSb.append("left join en_ent_op_er op on ent.id_ent = op.id_ent ");
		sqlSb.append("left join bd_bed bed on op.id_bed = bed.id_bed ");
		sqlSb.append("where ent.id_ent = ?");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		List<UrgPatInfoDTO> list = (List<UrgPatInfoDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(UrgPatInfoDTO.class));
		UrgPatInfoDTO[] dtos = list.toArray(new UrgPatInfoDTO[0]);
		return dtos[0];
	}

}
	
	