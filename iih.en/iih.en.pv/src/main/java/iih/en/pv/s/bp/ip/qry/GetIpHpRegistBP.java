package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.hpdto.d.IpHpRegistDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 获取患者住院登记医保信息
 * （医保转换）使用
 * 
 * @author liubin
 */
public class GetIpHpRegistBP {
	/**
     * 获取患者住院登记医保信息
     * （医保转换异常处理）使用
     * @param entId
     * @return
     * @throws BizException
     */
	public IpHpRegistDTO exec2(String patId) throws BizException {
		if(EnValidator.isEmpty(patId))
			return null;
		IpHpRegistDTO[] ipHpRegists = (IpHpRegistDTO[]) AppFwUtil.getDORstWithDao(new IpHpRegistByPatQry(patId), IpHpRegistDTO.class);
		//setDeptInfo(ipHpRegists);
		return EnValidator.isEmpty(ipHpRegists) ? null : ipHpRegists[0];
	}
	/**
     * 获取患者住院登记医保信息
     * （医保转换）使用
     * @param entId
     * @return
     * @throws BizException
     */
	public IpHpRegistDTO exec(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		IpHpRegistDTO[] ipHpRegists = (IpHpRegistDTO[]) AppFwUtil.getDORstWithDao(new IpHpRegistQry(entId), IpHpRegistDTO.class);
		setDeptInfo(ipHpRegists);
		return EnValidator.isEmpty(ipHpRegists) ? null : ipHpRegists[0];
	}
	/**
	 * 设置科室相关信息
	 * 
	 * @param ipHpRegists
	 * @throws BizException
	 */
	private void setDeptInfo(IpHpRegistDTO[] ipHpRegists) throws BizException{
		if(EnValidator.isEmpty(ipHpRegists))
			return;
		Set<String> depIdSets = new HashSet<String>();
		for(IpHpRegistDTO ipHpRegist : ipHpRegists){
			depIdSets.add(ipHpRegist.getId_dep_nur());
			depIdSets.add(ipHpRegist.getId_dep_phy());
			depIdSets.add(ipHpRegist.getId_dep_phyadm());
		}
		List<DeptDO> list = (List<DeptDO>) new DAFacade().findByPKs(DeptDO.class, depIdSets.toArray(new String[0]), 
				new String[]{DeptDO.ID_DEP, DeptDO.CODE, DeptDO.NAME});
		if(EnValidator.isEmpty(list))
			return;
		FMap map = EnFMapUtils.getFMap(DeptDO.ID_DEP, list.toArray(new DeptDO[0]));
		for(IpHpRegistDTO ipHpRegist : ipHpRegists){
			DeptDO dept = (DeptDO)map.get(ipHpRegist.getId_dep_nur());
			if(dept != null){
				ipHpRegist.setCode_dep_nur(dept.getCode());
				ipHpRegist.setName_dep_nur(dept.getName());
			}
			dept = (DeptDO)map.get(ipHpRegist.getId_dep_phy());
			if(dept != null){
				ipHpRegist.setCode_dep_phy(dept.getCode());
				ipHpRegist.setName_dep_phy(dept.getName());
			}
			dept = (DeptDO)map.get(ipHpRegist.getId_dep_phyadm());
			if(dept != null){
				ipHpRegist.setCode_dep_phyadm(dept.getCode());
				ipHpRegist.setName_dep_phyadm(dept.getName());
			}
			//if(ipHpRegist.getDt_birth() != null)
				//ipHpRegist.setAge(AgeCalcUtil.getAge(ipHpRegist.getDt_birth()));
			//获取患者就诊标签
			QryPatHpTagtpBP tagtp = new QryPatHpTagtpBP();
			tagtp.hpexec(ipHpRegist);
		}
		//设置年龄
		EnAgeCalcUtil.setDoAges(ipHpRegists, "Id_ent", "Age");
	}
	/**
	 * 查询患者住院登记医保信息
	 * 
	 * @author liubin
	 *
	 */
	private class IpHpRegistQry implements ITransQry {

		private String entId;
		
		public IpHpRegistQry(String entId){
			this.entId = entId;
		}
		
		@Override
		public SqlParam getQryParameter(StringBuffer arg0) {
			SqlParam param = new SqlParam();
			param.addParam(entId);
			return param;
		}

		@Override
		public String getQrySQLStr() {
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SELECT EN.ID_ENT," );
			sqlBuilder.append("EN.CODE AS CODE_ENT,");
			sqlBuilder.append("EN.ID_PAT," ); 
			sqlBuilder.append("EN.NAME_PAT," );
			sqlBuilder.append("EN.DT_ENTRY,"); 
			sqlBuilder.append("EN.DT_END,"); 
			sqlBuilder.append("IP.ID_REFERALSRC, "); 
			sqlBuilder.append("REFERALSRC.NAME AS NAME_REFERALSRC, "); 
			sqlBuilder.append("IP.TIMES_IP, "); 
			sqlBuilder.append("IP.ID_LEVEL_DISEADM, ");
			sqlBuilder.append("DISELEVEL.CODE AS CODE_LEVEL_DISEADM, ");
			sqlBuilder.append("DISELEVEL.NAME AS NAME_LEVEL_DISEADM, "); 
			sqlBuilder.append("IP.ID_DIAG_OP, "); 
			sqlBuilder.append("DIDEF.CODE AS CODE_DIAG_OP,");
			sqlBuilder.append("DIDEF.NAME AS NAME_DIAG_OP, "); 
			sqlBuilder.append("IP.DESC_DIAG_OP, "); 
			sqlBuilder.append("EN.ID_DEP_NUR, "); 
			sqlBuilder.append("EN.ID_DEP_PHY, "); 
			sqlBuilder.append("IP.ID_DEP_PHYADM, ");
			sqlBuilder.append("IP.ID_BED, "); 
			sqlBuilder.append("IP.NAME_BED, "); 
			sqlBuilder.append("IP.SD_OUTCOMES, ");
			sqlBuilder.append("IP.ID_OUTCOMES, ");
			sqlBuilder.append("BED.CODE AS CODE_BED, ");
			sqlBuilder.append("EN.ID_PATCA, "); 
			sqlBuilder.append("PATCA.NAME AS NAME_PATCA, "); 
			sqlBuilder.append("EN.ID_PRIPAT, "); 
			sqlBuilder.append("PRIPAT.NAME AS NAME_PRIPAT, "); 
			sqlBuilder.append("EN.ID_PATCRET, "); 
			sqlBuilder.append("PATCRET.NAME AS NAME_PATCRET, "); 
			sqlBuilder.append("EN.ID_HP, "); 
			sqlBuilder.append("HP.CODE AS CODE_HP, "); 
			sqlBuilder.append("HP.NAME AS NAME_HP, ");
			sqlBuilder.append("ENTHP.NO_HP,");
			sqlBuilder.append("ENTHP.personno as Personno,");//个人编号，fanlq-2018-05-19
			sqlBuilder.append("EN.SD_SEX_PAT AS CODE_SEX,");
			sqlBuilder.append("SEX.NAME AS NAME_SEX,");
			sqlBuilder.append("PAT.SD_IDTP AS CODE_IDTP,");
			sqlBuilder.append("PAT.ID_CODE AS ID_CODE,");
			sqlBuilder.append("PAT.CODE AS CODE_PAT,");
			sqlBuilder.append("PAT.dt_birth as Dt_birth,");//患者出生日期，fanlq-2018-05-07
			sqlBuilder.append("NVL(PAT.MOB, PAT.TEL) AS PHONE,");
			sqlBuilder.append("EN.ID_ENTP,");
			sqlBuilder.append("EN.CODE_ENTP,");
			sqlBuilder.append("ENTP.NAME AS NAME_ENTP,");
			sqlBuilder.append("(case when EN.ID_EMP_PHY = '~' then ip.id_emp_opapply else EN.ID_EMP_PHY end ) as ID_EMP_PHY,");
			sqlBuilder.append("NVL(EMP.NAME,doc.NAME) AS NAME_EMP_PHY,");//责任医生为空时，取门诊医生，fanlq-2018-05-09
			sqlBuilder.append("NVL(EMP.CODE,doc.CODE) AS CODE_EMP_PHY,");
			sqlBuilder.append("EN.DT_BIRTH_PAT AS DT_BIRTH,");
			sqlBuilder.append("EN.CODE_HPMEDKIND,");
			sqlBuilder.append("MEDKIND.NAME AS NAME_HPMEDKIND,");
			sqlBuilder.append("ENTHP.FG_FUNDPAY,");
			sqlBuilder.append("ENTHP.CODE_HPKIND,");
			sqlBuilder.append("ENTHP.CODE_HPPATCA,");
			sqlBuilder.append("ENTHP.CODE_HPAREA,");
			sqlBuilder.append("ENTHP.FG_HP_CARD,");
			sqlBuilder.append("ENTHP.FG_HPSPCL, ");
			sqlBuilder.append("IP.CODE_AMR_IP ");
			sqlBuilder.append("FROM EN_ENT EN ");
			sqlBuilder.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
			sqlBuilder.append("INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
			sqlBuilder.append("LEFT JOIN EN_ENT_HP ENTHP ON EN.ID_ENT = ENTHP.ID_ENT AND EN.ID_HP = ENTHP.ID_HP "); 
			sqlBuilder.append("LEFT JOIN BD_HP HP ON EN.ID_HP = HP.ID_HP "); 
			sqlBuilder.append("LEFT JOIN BD_UDIDOC REFERALSRC ON IP.ID_REFERALSRC = REFERALSRC.ID_UDIDOC "); 
			sqlBuilder.append("LEFT JOIN BD_UDIDOC DISELEVEL ON IP.ID_LEVEL_DISEADM = DISELEVEL.ID_UDIDOC "); 
			sqlBuilder.append("LEFT JOIN BD_DI_DEF DIDEF ON IP.ID_DIAG_OP = DIDEF.ID_DIDEF "); 
			sqlBuilder.append("LEFT JOIN PI_PAT_CA PATCA ON EN.ID_PATCA = PATCA.ID_PATCA "); 
			sqlBuilder.append("LEFT JOIN BD_PRI_PAT PRIPAT ON EN.ID_PRIPAT = PRIPAT.ID_PRIPAT "); 
			sqlBuilder.append("LEFT JOIN PI_PAT_CRET PATCRET ON EN.ID_PATCRET = PATCRET.ID_PATCRET ");
			sqlBuilder.append("LEFT JOIN BD_UDIDOC SEX ON EN.ID_SEX_PAT = SEX.ID_UDIDOC ");
			sqlBuilder.append("LEFT JOIN BD_ENTP ENTP ON EN.ID_ENTP = ENTP.ID_ENTP ");
			sqlBuilder.append("LEFT JOIN BD_PSNDOC EMP ON EN.ID_EMP_PHY = EMP.ID_PSNDOC ");
			sqlBuilder.append("LEFT JOIN BD_PSNDOC doc ON ip.id_emp_opapply = doc.ID_PSNDOC ");
			sqlBuilder.append("LEFT JOIN BD_HP_MED_KIND_AH MEDKIND ON EN.CODE_HPMEDKIND = MEDKIND.CODE ");
			sqlBuilder.append("LEFT JOIN BD_BED BED ON IP.ID_BED = BED.ID_BED ");
			sqlBuilder.append("WHERE EN.ID_ENT = ? ");
 			return sqlBuilder.toString();
		}
		
	}
	/**
	 * 查询患者住院登记医保信息
	 * 
	 * @author fanlq
	 *
	 */
	private class IpHpRegistByPatQry implements ITransQry {

		private String patId;
		
		public IpHpRegistByPatQry(String patId){
			this.patId = patId;
		}
		
		@Override
		public SqlParam getQryParameter(StringBuffer arg0) {
			SqlParam param = new SqlParam();
			param.addParam(patId);
			return param;
		}

		@Override
		public String getQrySQLStr() {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT PAT.NAME AS NAME_PAT, ");
			sql.append("SEX.CODE AS CODE_SEX, " );
			sql.append("SEX.NAME AS NAME_SEX, " );
			sql.append("PAT.SD_IDTP AS CODE_IDTP, " );
			sql.append("PAT.ID_CODE AS ID_CODE, " );
			sql.append("PAT.CODE AS CODE_PAT, " );
			sql.append("PAT.dt_birth as Dt_birth, " );
			sql.append("NVL(PAT.MOB, PAT.TEL) AS PHONE, " );
			sql.append("PAT.ID_PATICATE AS ID_PATCA " );
			sql.append("FROM PI_PAT PAT " );
			sql.append("INNER JOIN BD_UDIDOC SEX ON SEX.ID_UDIDOC = PAT.ID_SEX " );
			sql.append("LEFT JOIN PI_PAT_CA CA ON CA.ID_PATCA = PAT.ID_PATICATE " );
			sql.append("WHERE PAT.ID_PAT = ? ");
 			return sql.toString();
		}
	}	
}
