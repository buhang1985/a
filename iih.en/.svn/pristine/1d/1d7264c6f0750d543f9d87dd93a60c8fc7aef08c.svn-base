package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntIpStatusEnum;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.log.Log;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;

/**
 * 获取住院信息集合
 * 
 * @author renying
 */
public class GetIpDOListBP {

	private static final String KEY_NAME = "NAME";
	private static final String KEY_CODE = "CODE";
	private static final String KEY_CODE_CHIS = "CODE_CHIS";
	private static final String KEY_CODE_AMR_IP = "CODE_AMR_IP";
	private static final String KEY_ID_CODE = "ID_CODE";
	/**
	 * 住院就诊查询（分页）
	 * 
	 * @param qryModDTO
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<OutpatientQryDTO> exec(EntQryModDTO qryModDTO, PaginationInfo pg) throws BizException {
		//1.组装Sql语句
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		this.getBaseSql(qryModDTO, sb, param);
		String sql = sb.toString();
				
		//查询结果分页显示-fanlq-2018.10.30
		PagingServiceImpl<OutpatientQryDTO> pageQryService = new PagingServiceImpl<OutpatientQryDTO>();
		PagingRtnData<OutpatientQryDTO> datas = pageQryService.findByPageInfo(new OutpatientQryDTO(), pg, sql, null, param);
		FArrayList flResult = datas.getPageData();
		List<OutpatientQryDTO> outpatientQryDTOList = new ArrayList<OutpatientQryDTO>();
		for (int i = 0; i < flResult.size(); i++) {
			OutpatientQryDTO apt = (OutpatientQryDTO) flResult.get(i);
			outpatientQryDTOList.add(apt);
		}
		if (!EnValidator.isEmpty(outpatientQryDTOList)) {
			this.setAgeAndStatus(outpatientQryDTOList.toArray(new OutpatientQryDTO[0]));
		}
		return datas;
	}
	
	/**
	 * 住院就诊查询患者（不分页）
	 * 
	 * @param qryModDTO
	 * @return
	 * @throws BizException
	 */
	public OutpatientQryDTO[] exec(EntQryModDTO qryModDTO) throws BizException {
		//2.组装Sql语句
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		this.getBaseSql(qryModDTO, sb, param);
		String sql = sb.toString();				
		List<OutpatientQryDTO> list = (List<OutpatientQryDTO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(OutpatientQryDTO.class));
		if (!EnValidator.isEmpty(list)) {
			return list.toArray(new OutpatientQryDTO[0]);
		}

		return null;
	}
	
	/***
	 * 获取基本查询sql
	 * @param qryModDTO
	 * @param builder
	 * @param param
	 * @return
	 */
	private String getBaseSql(EntQryModDTO qryModDTO,StringBuilder builder,SqlParam param){
		if (EnValidator.isEmpty(qryModDTO)) {
			Log.error("住院就诊查询getOpList(EntQryModDTO)参数为null");
			return null;
		}

		builder.append(" select en.id_ent, ");
		builder.append(" en.id_entp as id_entp,");
		builder.append(" en.code_entp as code_entp,");
		builder.append(" en.code as code_ent,");
		builder.append(" en.name_pat,en.sd_sex_pat,");
		builder.append(" en.dt_birth_pat, en.id_emp_phy,");
		builder.append(" psn.name as name_emp_phy, ");
		builder.append(" en.dt_acpt ,");
		builder.append(" en.dt_end ,");
		builder.append(" pi.id_pat ,");
		builder.append(" pi.code as code_pat ,");
		builder.append(" en.id_dep_phy,");
		builder.append(" dep.name as name_dep,");
		builder.append(" doc.name as name_sex_pat,");
		builder.append(" bed.name as Name_bed,");
		//增加患者分类，价格分类，医保计划 zhangpp 2019.11.07
		builder.append(" en.id_patca as id_paticate, ");
		builder.append(" patca.name as name_paticate, ");
		builder.append(" en.id_pripat, ");
		builder.append(" pripat.name as name_pripat, ");
		builder.append(" enthp.id_hp, ");
		builder.append(" bdhp.name as name_hp, ");
		builder.append(" ip.sd_status, ");
		builder.append(" ip.code_amr_ip ");
		builder.append(" from en_ent en  ");
		builder.append(" inner join en_ent_ip ip on en.id_ent = ip.id_ent ");
		builder.append(" inner join pi_pat pi on en.id_pat = pi.id_pat ");
		builder.append(" left join bd_bed bed on bed.id_bed = ip.id_bed ");
		if (EntIpStatusEnum.TRANDEP.equals(qryModDTO.getEnt_ip_status())) {
			// 转科
			builder.append(" inner join en_ent_dep endep on en.id_ent = endep.id_ent ");
		}
		builder.append(" left join pi_pat_ca patca on en.id_patca = patca.id_patca ");
		builder.append(" left join bd_pri_pat pripat on en.id_pripat = pripat.id_pripat ");
		builder.append(" left join en_ent_hp enthp on enthp.id_ent = en.id_ent and enthp.fg_maj = 'Y' ");
		builder.append(" left join bd_hp bdhp on bdhp.id_hp = enthp.id_hp ");
		builder.append(" left join bd_psndoc  psn on id_psndoc =  en.id_emp_phy ");
		builder.append(" left join bd_dep dep on dep.id_dep = en.id_dep_phy ");
		builder.append(" left join bd_udidoc doc on en.id_sex_pat = doc.id_udidoc ");

		builder.append(" where en.fg_canc = 'N' ");
		builder.append(" and " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "en") + " ");
		// 结束日期加1天

		if (EntIpStatusEnum.INHOS.equals(qryModDTO.getEnt_ip_status())) {
			// 在院
			builder.append(" and en.fg_ip = ? ");
			param.addParam(FBoolean.TRUE);
			if(qryModDTO.getDt_b() !=null){
				builder.append(" and en.dt_acpt >= ? ");
				param.addParam(qryModDTO.getDt_b()+" 00:00:00");
			}
			if(qryModDTO.getDt_e() !=null){
				builder.append(" and en.dt_acpt <= ? ");
				param.addParam(qryModDTO.getDt_e()+" 23:59:59");
			}

		} else if (EntIpStatusEnum.TRANDEP.equals(qryModDTO.getEnt_ip_status())) {
			// 转科
			builder.append(" and endep.sd_entdeprole =?");
			builder.append(" and endep.sd_status = ?");
			builder.append(" and endep.fg_discharge = ? ");
			param.addParam(IEnDictCodeConst.SD_ENTDEPROLE_DEP); // 角色 科室
			param.addParam(IEnDictCodeConst.SD_ENTDEP_STATUS_SUC); // 完成
			param.addParam(FBoolean.FALSE);// 出院表示 false
			if(qryModDTO.getDt_b() !=null){
				builder.append(" and endep.dt_e >= ? ");
				param.addParam(qryModDTO.getDt_b()+" 00:00:00");				
			}
			if(qryModDTO.getDt_e() !=null){
				builder.append(" and endep.dt_e <= ? ");
				param.addParam(qryModDTO.getDt_e()+" 23:59:59");
			}

		} else if (EntIpStatusEnum.LEAVEHOS.equals(qryModDTO.getEnt_ip_status())) {
			// 出院
			builder.append(" and en.fg_ip = ? ");
			param.addParam(FBoolean.FALSE);
			if(qryModDTO.getDt_b() !=null){
				builder.append(" and en.dt_end >= ? ");
				param.addParam(qryModDTO.getDt_b()+" 00:00:00");
			}
			if(qryModDTO.getDt_b() !=null){
				builder.append(" and en.dt_end <= ? ");	
				param.addParam(qryModDTO.getDt_e()+" 23:59:59");
			}
			
		} 

		// 医疗组
		if (!EnValidator.isEmpty(qryModDTO.getId_medgrp())) {
			builder.append(" and  en.id_wg_phy = ? ");
			param.addParam(qryModDTO.getId_medgrp());
		}
		// 医生
		if (!EnValidator.isEmpty(qryModDTO.getId_emp())) {
			builder.append(" and  en.id_emp_phy = ?");
			param.addParam(qryModDTO.getId_emp());
		}
		// 科室
		if (!EnValidator.isEmpty(qryModDTO.getId_dep())) {
			builder.append(" and  en.id_dep_phy = ?");
			param.addParam(qryModDTO.getId_dep());
		}
		// 患者信息
		//revised by liubin 2017-01-12 : 添加条码号查询,去掉模糊查询
		//revised by liubin 2017-01-16 : 查询出患者合并记录
		if (!EnValidator.isEmpty(qryModDTO.getValue_pat())) {
			if (KEY_CODE_AMR_IP.equals(qryModDTO.getKey_pat())) {
				builder.append("AND IP.CODE_AMR_IP = ? ");
				param.addParam(qryModDTO.getValue_pat());
			} else {
				builder.append("AND PI.CODE IN (");
				builder.append("SELECT DISTINCT PAT.CODE FROM PI_PAT PAT LEFT JOIN PI_PAT_CARD CARD ON PAT.ID_PAT = CARD.ID_PAT ");
				builder.append("WHERE 1 = 1 ");
				if (KEY_NAME.equals(qryModDTO.getKey_pat())) {
					// 选择患者姓名
					builder.append("AND (PAT.NAME = ? ");
					param.addParam(qryModDTO.getValue_pat());
					builder.append("OR PAT.PYCODE =  ?) ");
					param.addParam(qryModDTO.getValue_pat().toUpperCase()+".");
				} else if (KEY_CODE.equals(qryModDTO.getKey_pat())) {
					// 选择患者编号
					builder.append("AND PAT.CODE = ? ");
					param.addParam(qryModDTO.getValue_pat());
				} else if (KEY_CODE_CHIS.equals(qryModDTO.getKey_pat())) {
					// 选择条码号
					builder.append("AND PAT.BARCODE_CHIS = ? ");
					param.addParam(qryModDTO.getValue_pat());
				} else if (KEY_ID_CODE.equals(qryModDTO.getKey_pat())) {
					// 选择条码号
					builder.append("AND PAT.ID_CODE = ? ");
					param.addParam(qryModDTO.getValue_pat());
				} else {
					builder.append("AND CARD.ID_PATCARDTP = ? AND CARD.CODE = ? ");
					param.addParam(qryModDTO.getKey_pat());
					param.addParam(qryModDTO.getValue_pat());
				}
				builder.append(") ");
			}
		}
		if (EntIpStatusEnum.LEAVEHOS.equals(qryModDTO.getEnt_ip_status())) {
			// 出院
			builder.append(" order by en.dt_end desc ");
		}else{
			builder.append(" order by en.dt_acpt desc ");
		}
		return builder.toString();
	}
	
	/***
	 * 设置年龄和就诊状态名称，
	 * @author fanlq 2018-10-30
	 * @param outpatientQryDTOs
	 * @throws BizException
	 */
	private void setAgeAndStatus(OutpatientQryDTO[] outpatientQryDTOs) throws BizException{
		IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService listservice = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] listDOs = listservice.find("code = '"+IEnDictCodeTypeConst.SD_STATUS+"'", null, FBoolean.FALSE);
		if(outpatientQryDTOs != null){
			//设置患者年龄
			EnAgeCalcUtil.setDoAges(outpatientQryDTOs, "Id_ent", "Age_pat");
			for(OutpatientQryDTO outpatientQryDTO : outpatientQryDTOs){
				//设置年龄
				//outpatientQryDTO.setAge_pat(AgeCalcUtil.getAge(outpatientQryDTO.getDt_birth_pat()));
				//设置就诊状态
				if(listDOs != null && listDOs[0] != null){
					UdidocDO[] ralsrcudidocDos = service.find("id_udidoclist = '"+listDOs[0].getId_udidoclist()+"' and code = '"+outpatientQryDTO.getSd_status()+"'",  null, FBoolean.FALSE);
					if(ralsrcudidocDos != null && ralsrcudidocDos.length > 0)
						outpatientQryDTO.setName_status(ralsrcudidocDos[0].getName());
				}
			}
		}
	}
}
