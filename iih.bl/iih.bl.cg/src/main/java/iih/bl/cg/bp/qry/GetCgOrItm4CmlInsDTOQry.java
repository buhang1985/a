package iih.bl.cg.bp.qry;

import iih.bd.bc.param.IBdPpParamValueConst;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCgOrItm4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;
	//String drugName;

	/*
	 * 获取相关患者信息
	 */
	public GetCgOrItm4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
		if (billNos == null && billNos.length == 0)
			throw new BizException("请录入发票单号！");
		if (StringUtil.isEmpty(codePat))
			throw new BizException("请录入患者编码！");
		this.billNos = billNos;
		this.codePat = codePat;
		//获取医保上传药品名称类型
		//drugName= BlParamUtils.getHpUploadDrugNameType();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(codePat);
		for (String string : billNos) {
			param.addParam(string);
		}
		return param;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT ");
		sql.append(" STOEP.CODE_ST HISTRADENO"); //HIS交易流水号
		sql.append(" ,ENT.CODE VISIT_NO"); //就诊号
		sql.append(" ,PAT.CODE PID"); //患者ID
		sql.append(" ,ITMOEP.ID_PRES RECIPENO"); //处方号
		sql.append(" ,ITMOEP.CODE_APPLYTP ORDERNO"); //项目号（生成数据时自行添加）
		sql.append(" ,case ITMOEP.fg_mm when 'Y' then ITMOEP.CODE_MM else ITMOEP.CODE_SRV END HISCODE"); //HIS项目编码
		try {
			if(IBdPpParamValueConst.MI_DRUGNAMETYP_MMNAME.equals(BdPpParamUtils.GetMiDrugNameType())){//物品名
				sql.append(" ,case ITMOEP.fg_mm when 'Y' then ITMOEP.name_mm else ITMOEP.name_srv END HISNAME"); //HIS项目名称取name_mm
			}else if(IBdPpParamValueConst.MI_DRUGNAMETYP_SRVNAME.equals(BdPpParamUtils.GetMiDrugNameType())){//通用名
			sql.append(" ,ITMOEP.name_srv  HISNAME"); //HIS项目名称取name_srv
			}else if(IBdPpParamValueConst.MI_DRUGNAMETYP_MINAME.equals(BdPpParamUtils.GetMiDrugNameType())){//商品名
				sql.append(" ,case ITMOEP.fg_mm when 'Y' then bdmm.hiname else ITMOEP.name_srv END HISNAME "); //HIS项目名称取医保名称
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.append(" ,ITMOEP.SPEC DRUG_SPECIFICATION"); //规格
		sql.append(" ,DOSEDOC.CODE DOSE"); //剂型
		sql.append(" ,ORSRV.QUAN_MEDU DOSEGE"); //剂量
		sql.append(" ,MEASDOC.NAME DOSE_UNIT"); //剂量单位
		sql.append(" ,MEASDOC.NAME MINI_UNIT"); //用量单位
		sql.append(" ,ROUTE.CODE SUPPLY_CODE"); //用法
		sql.append(" ,FREQ.CODE FREQU_CODE"); //频率
		sql.append(" ,CIOR.DAYS_OR PERSIS_DAYS"); //执行天数
		sql.append(" ,SRVMM.DAYS_AVAILABLE PERSIS_DAYS_REAL"); //实际用药天数
		sql.append(" ,ITMOEP.PRICE_RATIO PRICE"); //单价
		sql.append(" ,ITMOEP.QUAN AMOUNT"); //数量
		sql.append(" ,MEASDOC.CODE PICK_UNIT"); //数量单位
		sql.append(" ,ITMOEP.AMT_RATIO TOATLAMOUNT"); //金额
//		sql.append(" --HISBILLCODE"); //HIS账单码（生成数据时自行添加）
		sql.append(" ,( CASE WHEN ORSRV.FG_INDIC='Y' THEN 1 ELSE 0 END  ) FITTING_FLAG "); //适应症标志
		sql.append(" ,( CASE WHEN ORSRV.FG_SELFPAY='Y' THEN 1 ELSE 0 END  ) SELF_FLAG "); //自费标志
		sql.append(" ,( CASE WHEN ORSRV.fg_skintest='Y' THEN 1 ELSE 0 END  ) SKIN_TEST_FLAG"); //皮试标志
		sql.append(" ,ITMOEP.APPRNO DRUG_APPROVAL_NUMBER"); //药品批准文号
		sql.append(" ,MPDEP.CODE EXEC_DEPT"); //执行科室
		sql.append(" ,PHDEP.CODE PHARMACY_CODE"); //药房编码
		sql.append(" ,PDOC.CODE CHARGE_OPERA"); //收费员
		sql.append(" ,STOEP.DT_ST CHARGEDATE"); //收费时间
		sql.append(" FROM BL_CG_ITM_OEP ITMOEP");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ON STOEP.ID_STOEP=ITMOEP.ID_STOEP");
		sql.append(" INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP");
		sql.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT=STOEP.ID_ENT");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=STOEP.ID_PAT");
		sql.append(" LEFT JOIN BD_HP_SRVORCA SRVORCA ON SRVORCA.ID_SRV=ITMOEP.ID_SRV");
		sql.append(" LEFT JOIN CI_OR_SRV_MM SRVMM ON SRVMM.ID_MM=ITMOEP.ID_MM AND SRVMM.ID_ORSRV=ITMOEP.ID_ORSRV");
		sql.append(" LEFT JOIN BD_UDIDOC DOSEDOC ON DOSEDOC.ID_UDIDOC=SRVMM.ID_DOSAGE");
		sql.append(" LEFT JOIN CI_OR_SRV ORSRV ON ORSRV.ID_ORSRV=ITMOEP.ID_ORSRV");
		sql.append(" LEFT JOIN CI_ORDER CIOR ON CIOR.ID_OR=ITMOEP.ID_OR");
		sql.append(" LEFT JOIN BD_MEASDOC MEASDOC ON MEASDOC.ID_MEASDOC=ORSRV.ID_MEDU");
		sql.append(" LEFT JOIN BD_ROUTE ROUTE ON ROUTE.ID_ROUTE=ORSRV.ID_ROUTE");
		sql.append(" LEFT JOIN BD_FREQ FREQ ON FREQ.ID_FREQ=ORSRV.ID_FREQ");
		sql.append(" LEFT JOIN BD_DEP PHDEP ON PHDEP.ID_DEP=ORSRV.ID_DEP_WH");
		sql.append(" LEFT JOIN BD_DEP MPDEP ON MPDEP.ID_DEP=ORSRV.ID_DEP_MP");
		sql.append(" INNER JOIN BD_PSNDOC PDOC ON PDOC.ID_PSNDOC=STOEP.ID_EMP_ST");
		sql.append(" LEFT JOIN BD_mm bdmm ON ITMOEP.id_mm=bdmm.id_mm " );
		sql.append(" WHERE PAT.code=? ");
		sql.append(" AND INCOEP.INCNO in (");
		for (int i = 0; i < billNos.length; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")");
		return sql.toString();
	}
}
