package iih.bl.cg.blstrikebalancebp;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.params.BlParams;
import iih.en.pv.enfee.dto.d.PatiFixedFeeLeftDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class BlstStrikeBalanceBp {
	public PatiFixedFeeLeftDTO[] getPatientListInfo(String id_dep_nuradm) throws BizException {
		// TODO Auto-generated method stub

		List<PatiFixedFeeLeftDTO> datas = null;
		// 1、查询病区下患者就诊信息以及收费模式
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT ENT.ID_ENT,DCG.SD_DCG_MODE,ENT.NAME_PAT,IP.NAME_BED BED_NAME,IP.CODE_AMR_IP ");
		sql.append(" FROM ");
		sql.append(" EN_ENT ENT INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT = IP.ID_ENT ");
		sql.append(" INNER JOIN EN_ENT_DCG DCG ON ENT.ID_ENT = DCG.ID_ENT ");
		sql.append(" WHERE ENT.FG_IP = 'Y' AND ");
		sql.append(" IP.CODE_AMR_IP IS NOT NULL AND ");
		sql.append(" ENT.ID_DEP_NUR='").append(id_dep_nuradm).append("' ");
		sql.append(" ORDER BY IP.NAME_BED");
		FArrayList flist = AppFwUtil.getMapListWithDao(sql.toString());
		if (null == flist || flist.size() == 0) {
			return null;
		}

		// 2、返回数据患者就诊数据
		datas = new ArrayList<PatiFixedFeeLeftDTO>();
		for (int i = 0; i < flist.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) flist.get(i);
			PatiFixedFeeLeftDTO dto = new PatiFixedFeeLeftDTO();
			String key = "id_ent";
			dto.setId_ent(map.get(key) == null ? null : map.get(key).toString());
			key = "sd_dcg_mode";
			dto.setSd_dcg_mode(map.get(key).toString().equals("1") ? FBoolean.TRUE : FBoolean.FALSE);

			key = "name_pat";
			dto.setName_pat(map.get(key) == null ? null : map.get(key).toString());
			key = "bed_name";
			dto.setBed_name(map.get(key) == null ? null : (map.get(key).toString() + "床"));
			key = "code_amr_ip";
			dto.setCode_amr_ip(map.get(key) == null ? null : map.get(key).toString());
			datas.add(dto);
		}
		PatiFixedFeeLeftDTO[] dtoArr = datas.toArray(new PatiFixedFeeLeftDTO[] {});

		return dtoArr;
	}

	public BlCgIpDO[] findBlCgIpDOsByIdent(String ident) throws BizException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("  select x.id_srv,x.id_mm,x.cd_batch,x.name_srv,x.name_mm, x.spec,x.price,x.quan,x.srvu, x.srvu_name, x.id_dep_or,x.id_dep_nur,x.id_dep_mp from                              ");
		sb.append("   (select  distinct p.id_srv,p.id_mm,p.cd_batch,p.name_srv,p.name_mm,p.spec,p.price,sum(p.quan*p.eu_direct) quan,  p.srvu, d.name as srvu_name  ");
		sb.append("      ,p.id_dep_or,p.id_dep_nur,p.id_dep_mp                                                                   ");
		sb.append("    FROM BL_CG_IP p                                                                                      ");
		sb.append("     inner join  bd_measdoc d on p.srvu = d.id_measdoc                                                  ");
		sb.append("    WHERE p.ID_ENT=?  and p.ds=0  and p.fg_st='N'                                                                     ");
		sb.append("     GROUP BY  p.id_srv,p.id_mm,p.cd_batch,p.name_srv,p.name_mm,p.spec,p.price,p.srvu,d.name             ");
		sb.append("     ,p.id_dep_or,p.id_dep_nur,p.id_dep_mp )x              ");
		sb.append("       where x.quan>0                                      ");
		sb.append("       order by  x.name_srv desc                           ");
		SqlParam sp = new SqlParam();
		sp.addParam(ident);

		@SuppressWarnings("unchecked")
		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(sb.toString(), sp, new BeanListHandler(BlCgIpDO.class));

		return list.toArray(new BlCgIpDO[0]);
	}

	public BlCgIpDO[] saveNurseTuifee(BlCgIpDO[] mendIpDos, String id_ent) throws BizException {
		BlCgIpDO[] blcgips = this.findBlCgIpDOsByIdent(id_ent); // 分组后的记账数据
		ArrayList<BlCgIpDO> newList = new ArrayList<BlCgIpDO>();
		IBlcgqueryRService cgRSer = ServiceFinder.find(IBlcgqueryRService.class);
		String[] sqlParamqry = new String[9];

		List<BlCgIpDO> qrylist = new ArrayList<BlCgIpDO>();
		if (mendIpDos == null || mendIpDos.length == 0)
			return null;
		//待冲账的账户金额总和
		FDouble fdAmtAcc=new FDouble();
		// 1.对由前台传过来的选中行数据，做遍历，反查其在数据库中的原来数据是对应哪条记账数据
		for (BlCgIpDO item : mendIpDos) {
			if (item.getId_srv() != null) {
				sqlParamqry[0] = item.getId_srv();
			} else {
				sqlParamqry[0] = "";
			}

			if (item.getId_mm() != null) {
				sqlParamqry[1] = item.getId_mm();
			} else {
				sqlParamqry[1] = "";
			}

			if (item.getCd_batch() != null) {
				sqlParamqry[2] = item.getCd_batch();
			} else {
				sqlParamqry[2] = "";
			}

			if (item.getSpec() != null) {
				sqlParamqry[3] = item.getSpec();
			} else {
				sqlParamqry[3] = "";
			}

			if (item.getPrice() != null) {
				sqlParamqry[4] = item.getPrice().toString();
			} else {
				sqlParamqry[4] = "";
			}

			if (item.getSrvu() != null) {
				sqlParamqry[5] = item.getSrvu();
			} else {
				sqlParamqry[5] = "";
			}

			if (item.getId_dep_or() != null) {
				sqlParamqry[6] = item.getId_dep_or();
			} else {
				sqlParamqry[6] = "";
			}

			if (item.getId_dep_nur() != null) {
				sqlParamqry[7] = item.getId_dep_nur();
			} else {
				sqlParamqry[7] = "";
			}

			if (item.getId_dep_mp() != null) {
				sqlParamqry[8] = item.getId_dep_mp();
			} else {
				sqlParamqry[8] = "";
			}

			StringBuffer sbf = new StringBuffer();
			sbf.append("   select p.id_cgip, p.id_srv,p.id_mm,p.cd_batch,p.spec,p.price,p.srvu,p.id_dep_or,p.id_dep_nur,p.id_dep_mp   ");
			sbf.append("    FROM BL_CG_IP p                                                  ");
			sbf.append("   WHERE   p.ID_ENT ='" + id_ent + "'            and p.ds=0              ");
			sbf.append("            and  p.id_srv  ='" + sqlParamqry[0] + "'");
			sbf.append("            and  p.id_mm    like '" + sqlParamqry[1] + "%'");
			sbf.append("            and  p.price   ='" + sqlParamqry[4] + "'");
			sbf.append("            and  p.srvu    ='" + sqlParamqry[5] + "'");
			sbf.append("            and  p.id_dep_or  like  '" + sqlParamqry[6] + "%'");
			sbf.append("            and  p.id_dep_nur like  '" + sqlParamqry[7] + "%'");
			sbf.append("            and  p.id_dep_mp  like  '" + sqlParamqry[8] + "%'");

			System.out.println(sbf.toString());
			qrylist = (List<BlCgIpDO>) new DAFacade().execQuery(sbf.toString(), new BeanListHandler(BlCgIpDO.class));

			// 2.对反查出来的结果，取其字段值赋值给新增数据的相应字段
			if (qrylist != null && qrylist.size() > 0) {
				BlCgIpDO oldDO = cgRSer.findById(qrylist.get(0).getId_cgip());
				BlCgIpDO newIpDO = new BlCgIpDO();
				newIpDO.setQuan(item.getQuan_mend());
				newIpDO.setId_grp(oldDO.getId_grp());
				newIpDO.setId_org(oldDO.getId_org());
				newIpDO.setId_pat(oldDO.getId_pat());
				newIpDO.setId_ent(oldDO.getId_ent());
				newIpDO.setId_enttp(oldDO.getId_enttp());
				newIpDO.setCode_enttp(oldDO.getCode_enttp());
				newIpDO.setEu_direct(-1);
				newIpDO.setSd_srvtp(oldDO.getSd_srvtp());
				newIpDO.setId_srvtp(oldDO.getId_srvtp());
				newIpDO.setId_srvca(oldDO.getId_srvca());
				newIpDO.setId_srv(oldDO.getId_srv());
				newIpDO.setName_srv(oldDO.getName_srv());
				newIpDO.setCode_srv(oldDO.getCode_srv());
				newIpDO.setName_mm(oldDO.getName_mm());
				newIpDO.setSrvu(oldDO.getSrvu());
				newIpDO.setPrice(oldDO.getPrice());
				newIpDO.setAmt_std(oldDO.getPrice().multiply(item.getQuan_mend()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				newIpDO.setId_org_or(oldDO.getId_org_or());
				newIpDO.setId_dep_or(oldDO.getId_dep_or());
				newIpDO.setId_emp_or(oldDO.getId_emp_or());
				newIpDO.setId_wg_or(oldDO.getId_wg_or());
				newIpDO.setId_dep_nur(oldDO.getId_dep_nur());
				newIpDO.setDt_or(oldDO.getDt_or());
				newIpDO.setId_dep_mp(oldDO.getId_dep_mp());
				newIpDO.setId_org_mp(oldDO.getId_org_mp());
				newIpDO.setDt_srv(oldDO.getDt_srv());
				newIpDO.setId_pripat(oldDO.getId_pripat());
				newIpDO.setRatio_pripat(oldDO.getRatio_pripat());
				newIpDO.setId_hp(oldDO.getId_hp());
				newIpDO.setRatio_hp(oldDO.getRatio_hp());
				newIpDO.setPrice_ratio(oldDO.getPrice_ratio());
				newIpDO.setCode_inccaitm(oldDO.getCode_inccaitm());
				newIpDO.setName_inccaitm(oldDO.getName_inccaitm());
				FDouble fdPriceRatio = oldDO.getPrice_ratio();
				newIpDO.setAmt(fdPriceRatio.multiply(item.getQuan_mend()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				newIpDO.setAmt_ratio(fdPriceRatio.multiply(item.getQuan_mend()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				newIpDO.setFg_bb(oldDO.getFg_bb());
				newIpDO.setNo_bb(oldDO.getNo_bb());
				newIpDO.setId_ent_mom(oldDO.getId_ent_mom());
				newIpDO.setId_ent_mom(oldDO.getId_ent_mom());
				newIpDO.setId_mm(oldDO.getId_mm());
				newIpDO.setCode_mm(oldDO.getCode_mm());
				newIpDO.setSd_mmtp(oldDO.getSd_mmtp());
				newIpDO.setId_mmtp(oldDO.getId_mmtp());
				newIpDO.setSpec(oldDO.getSpec());
				newIpDO.setOnlycode(oldDO.getOnlycode());
				newIpDO.setCd_batch(oldDO.getCd_batch());
				newIpDO.setApprno(oldDO.getApprno());
				newIpDO.setPgku_base(oldDO.getPgku_base());
				newIpDO.setPgku_cur(oldDO.getPgku_cur());
				newIpDO.setFactor(oldDO.getFactor());
				newIpDO.setQuan_base(oldDO.getQuan_base());
				newIpDO.setId_or(oldDO.getId_or());
				newIpDO.setId_orsrv(oldDO.getId_orsrv());
				newIpDO.setId_pres(oldDO.getId_pres());
				newIpDO.setFg_pddisc(oldDO.getFg_pddisc());
				newIpDO.setFg_st(FBoolean.FALSE);
				newIpDO.setId_stip(null);
				newIpDO.setDt_st(null);
				newIpDO.setFg_hp(FBoolean.FALSE);
				newIpDO.setFg_susp(FBoolean.FALSE);
				newIpDO.setFg_refund(FBoolean.FALSE);
				newIpDO.setId_par(oldDO.getId_cgip());
				newIpDO.setCode_cg(null);
				newIpDO.setId_dep_cg(Context.get().getDeptId());
				newIpDO.setId_org_cg(Context.get().getOrgId());
				newIpDO.setId_emp_cg(Context.get().getUserId());
				TimeService timeService = new TimeServiceImpl();
				FDateTime dateTime = timeService.getUFDateTime();
				newIpDO.setDt_cg(dateTime);
				newIpDO.setEu_srctp(oldDO.getEu_srctp());
				newIpDO.setFg_additm(FBoolean.TRUE);
				newIpDO.setNote("退费(调整)");
				newIpDO.setStatus(DOStatus.NEW);
				newList.add(newIpDO);
				//待冲账的总金额
				fdAmtAcc=fdAmtAcc.add(newIpDO.getAmt_ratio().multiply(newIpDO.getEu_direct()));
			}
		}
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);
		//母婴是否合并
		FBoolean isMerge =BlParams.BLSTIP0005();
		NewbornDO entNewBorn = inpPatAccImpls.getNewbornDO(newList.get(0).getId_ent());
		//2、母婴关系判断
		//预交金持有人，如果是新生儿，则用母亲账户
		String strIdEntAcc=null;
		if(entNewBorn!=null && FBoolean.TRUE.equals(isMerge))
		{
			strIdEntAcc = entNewBorn.getId_ent_mom();
		}
		else
		{
			strIdEntAcc=newList.get(0).getId_ent();
		}
		//6、预交金账户处理
		enAccService.consume(strIdEntAcc, fdAmtAcc);
		
		IBlcgqueryCudService blcgCudSer = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] saveArr = blcgCudSer.save(newList.toArray(new BlCgIpDO[] {}));
		return saveArr;
	}

	/**
	 * 通过患者的住院病区id、患者姓名、床号等信息搜索患者的信息
	 * 
	 * @param id_dep
	 * @param keyCond
	 * @param condition
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PatiFixedFeeLeftDTO[] getPatientListInfoByQueryCondition(String id_dep, String keyCond, String condition) throws BizException {
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append(" SELECT DISTINCT ENT.ID_ENT,DCG.SD_DCG_MODE,ENT.NAME_PAT,IP.NAME_BED BED_NAME,IP.CODE_AMR_IP ");
		sql.append(" FROM ");
		sql.append(" EN_ENT ENT INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT = IP.ID_ENT ");
		sql.append(" INNER JOIN EN_ENT_DCG DCG ON ENT.ID_ENT = DCG.ID_ENT ");
		sql.append(" WHERE ENT.FG_IP = 'Y' AND ");
		sql.append(" IP.CODE_AMR_IP IS NOT NULL AND ");
		sql.append(" IP.ID_DEP_NURADM=? ");
		param.addParam(id_dep);
		if ("0".equals(keyCond)) {
			sql.append("and (IP.name_bed like ? or ENT.NAME_PAT like ?) ");

			param.addParam("%"+condition+"%");
			param.addParam("%"+condition+"%");
		} else if ("1".equals(keyCond)) {
			sql.append(" and IP.name_bed like ? ");
			param.addParam("%"+condition+"%");
		} else if ("2".equals(keyCond)) {
			sql.append(" and ENT.NAME_PAT like ? ");
			param.addParam("%"+condition+"%");
		}
		sql.append(" ORDER BY IP.NAME_BED");

		List<PatiFixedFeeLeftDTO> patList = (List<PatiFixedFeeLeftDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(PatiFixedFeeLeftDTO.class));
		return patList.toArray(new PatiFixedFeeLeftDTO[] {});
	}

}
