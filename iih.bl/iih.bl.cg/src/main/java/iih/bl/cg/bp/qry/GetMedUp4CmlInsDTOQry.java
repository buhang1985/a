package iih.bl.cg.bp.qry;

import iih.bd.bc.param.IBdPpParamValueConst;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMedUp4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;
	//String drugName;

	/*
	 * 获取相关患者信息
	 */
	public GetMedUp4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
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
		
		sql.append(" SELECT  ");
		sql.append("INCOEP.INCNO , ");
		sql.append(" STOEP.CODE_ST HISTRADENO");//HIS交易流水号(一次结算的唯一号）
		sql.append(" ,ITMOEP.ID_CGITMOEP HISFYMXID");//HIS费用明细ID
		sql.append(" ,(SELECT wm_concat(PM.CODE) FROM BL_PAY_ITM_PAT_OEP PAYOEP INNER JOIN BD_PRI_PM PM ON PM.ID_PM=PAYOEP.ID_PM WHERE ID_PAYPATOEP=STOEP.ID_PAYPATOEP AND ROWNUM=1 GROUP BY PM.NAME) PAY_TYPE");//付款方类别
		sql.append(" ,'110' REGION_CODE");//保险地区代码
		sql.append(" ,'110' ORGANIZATION_ID");//保险机构代码
		sql.append(" ,AROEP.CODE_HP BXTRADENO");//保险交易流水号
		sql.append(" ,PAT.CODE PID");//患者ID
		sql.append(" ,(CASE WHEN SRVORCA.EU_HPSRVTP='1' THEN '0' ELSE '1' END)  ITEMTYPE");//--医保项目类别
		sql.append(" ,SRVORCA.CODE_CA CHARGETYPE");//--医保收费类别
		sql.append(" ,SRVORCA.CODE YBITEMCODE");//--医保项目编码
		sql.append(" ,SRVORCA.NAME YBITEMNAME");//--医保项目名称
		sql.append(" ,SRVORCA.SD_HPSRVTP CHARGE_GROUP");//--费用分组（甲乙丙为数字）
		sql.append(" ,ITMOEP.PRICE_RATIO PRICE");//--单价
		sql.append(" ,ITMOEP.QUAN AMOUNT");//--数量
		sql.append(" ,ITMOEP.AMT_RATIO TOATLAMOUNT");//--金额
		sql.append(" ,PDOC.CODE SEND_OPERA");//上传人
		sql.append(" ,STOEP.DT_ST SENDDATE");//上传时间
		sql.append(" ,NVL(AROEP.AMT_HP,'0') INSURANCE_AMOUNT");//--保险内金额
		sql.append(" ,ITMOEP.AMT_RATIO OUT_INSURANCE_AMOUNT");//--保险外金额
		sql.append(" ,'0' PERSONAL_PAY_TWO");//--个人自付二
		//sql.append(" --ANALYZE_STUTE");//--分解状态(状态是数字 具体有哪些？)
		//sql.append(" --ORDERNO");//--项目号（生成数据时自行添加）
		sql.append(" ,ITMOEP.ID_PRES RECIPENO");//处方号
//		sql.append(" ,ITMOEP.CODE_SRV HISCODE");//HIS项目编码
//		sql.append(" ,ITMOEP.NAME_SRV HISNAME");//HIS项目名称
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
		sql.append(" ,ENT.CODE VISIT_NO");//就诊号
		sql.append(" FROM BL_CG_ITM_OEP ITMOEP ");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ON STOEP.ID_STOEP=ITMOEP.ID_STOEP  ");
		sql.append(" INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP ");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=STOEP.ID_PAT ");
		sql.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT=STOEP.ID_ENT ");
		sql.append(" LEFT JOIN BL_PROP_OEP PROPOEP ON PROPOEP.ID_STOEP=STOEP.ID_STOEP ");
		sql.append(" LEFT JOIN BL_PROP_AR_OEP AROEP ON PROPOEP.ID_PROPOEP=AROEP.ID_PROPOEP ");
		sql.append(" LEFT JOIN BD_HP_SRVORCA SRVORCA ON SRVORCA.ID_SRV=ITMOEP.ID_SRV ");
		sql.append(" INNER JOIN BD_PSNDOC PDOC ON PDOC.ID_PSNDOC=STOEP.ID_EMP_ST ");
		sql.append(" LEFT JOIN BD_mm bdmm ON ITMOEP.id_mm=bdmm.id_mm ");
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
