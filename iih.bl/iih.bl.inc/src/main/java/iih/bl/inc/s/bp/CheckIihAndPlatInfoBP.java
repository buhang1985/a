package iih.bl.inc.s.bp;

import java.util.List;

import iih.bl.inc.dto.blelecbillcheckdto.d.BlecIncCheckDTO;
import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.ei.bl.ecinc.d.EcIncBillListDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.i.IEcIncManageService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 核对平台和iih的电子票据详细信息
 * @author dk.jiang
 *
 */
public class CheckIihAndPlatInfoBP {
	
	/**
	 * 正常/异常数据查询
	 * @param qry
	 * @param option
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BlecIncCheckDTO> exec(QryRootNodeDTO qry, PaginationInfo pg, String option) throws BizException{
		//返回值
		PagingRtnData<BlecIncCheckDTO> result = new PagingRtnData<BlecIncCheckDTO>();
		
		//0.参数校验
		if (! checkParam(qry, option)) {
			return result;
		}
		
		//1.查询条件处理，返回where条件
		String whereStr = CheckElecBillBP.processQryRootNode(qry);
		
		//2.查询第三方数据
		EcIncBillListDTO[] thridDatas = new EcIncBillListDTO[0];
		//EcIncBillListDTO[] thridDatas = this.getThridBillInfoList();
		
		//如果平台数据为空
		if (ArrayUtil.isEmpty(thridDatas)) {
			//分页查询IIH数据
			PagingRtnData<BlecIncCheckDTO> iihDatasByPage = this.qryIIhDataByPage(whereStr, pg);
			//如果iih数据和第三方都为空 则返回
			if (iihDatasByPage == null) {
				return result;
			}else {
				if (CheckElecBillBP.SD_NORMAL.equals(option) ) {
					//正常数据，返回空
					return result;
				}else {
					//异常数据，只返回iih数据
					return iihDatasByPage;
				}
			}
		}else {
			//1.删除临时表
			CheckElecBillBP.deleteTempTable();
			
			//查询IIH数据
			BlecIncCheckDTO[] iihData = this.qryIIhData(whereStr);
			
			//2.第三方数据存到临时表中
			CheckElecBillBP.saveTridDataToTmpTable(CheckElecBillBP.SD_TMPTABLE_TRID, thridDatas);
			
			//4.IIH数据存到临时表中
			CheckElecBillBP.saveDataToTempTable(CheckElecBillBP.SD_TMPTABLE_IIH, iihData, "iih_");
			
			StringBuilder connSql = this.getInitTmpConnSql();
			
			if (CheckElecBillBP.SD_NORMAL.equals(option) ) {
				//正常数据
				PagingRtnData<BlecIncCheckDTO> normalDatas = this.qryNormalDatas(connSql, pg);
				return normalDatas;
			}else {
				//异常数据
				PagingRtnData<BlecIncCheckDTO> abnormalDatas = this.qryAbnormalDatas(connSql, pg);
				return abnormalDatas;
			}
		}
		
	}
	
	/**
	 * 分页查询IIH数据
	 * @param whereStr
	 * @param pg
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<BlecIncCheckDTO> qryIIhDataByPage(String whereStr, PaginationInfo pg) throws BizException {
		String sql = this.getQryIIhSql(whereStr);
		PagingServiceImpl<BlecIncCheckDTO> pageQryService = new PagingServiceImpl<BlecIncCheckDTO>();
		PagingRtnData<BlecIncCheckDTO> result = pageQryService.findByPageInfo(new BlecIncCheckDTO(), pg, sql, null, null);
		return result;
	}

	/**
	 * 异常数据查询-分页
	 * @param connSql 
	 * @param pg 
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<BlecIncCheckDTO> qryAbnormalDatas(StringBuilder connSql, PaginationInfo pg) throws BizException {
		String sql = this.getAbnormalDataSql(connSql);
		PagingServiceImpl<BlecIncCheckDTO> pageQryService = new PagingServiceImpl<BlecIncCheckDTO>();
		PagingRtnData<BlecIncCheckDTO> result = pageQryService.findByPageInfo(new BlecIncCheckDTO(), pg, sql, null, null);
//		List<BlecIncCheckDTO> dtos = (List<BlecIncCheckDTO>) new DAFacade().execQuery(sql, 
//				new BeanListHandler(BlecIncCheckDTO.class));
//		return dtos.toArray(new BlecIncCheckDTO[dtos.size()]);
		return result;
	}
	
	/**
	 * 正常数据查询-分页
	 * @param connSql 
	 * @param pg 
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<BlecIncCheckDTO> qryNormalDatas(StringBuilder connSql, PaginationInfo pg) throws BizException {
		String sql = this.getNormalDataSql(connSql);
		PagingServiceImpl<BlecIncCheckDTO> pageQryService = new PagingServiceImpl<BlecIncCheckDTO>();
		PagingRtnData<BlecIncCheckDTO> result = pageQryService.findByPageInfo(new BlecIncCheckDTO(), pg, sql, null, null);
//		List<BlecIncCheckDTO> dtos = (List<BlecIncCheckDTO>) new DAFacade().execQuery(sql, 
//				new BeanListHandler(BlecIncCheckDTO.class));
//		return dtos.toArray(new BlecIncCheckDTO[dtos.size()]);
		return result;
	}

	/**
	 * 两个临时表连接的sql初始化
	 * @param incPointcode	开票点编码
	 * @return
	 */
	public StringBuilder getInitTmpConnSql(){
		
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");	//
		sb.append(" iih.iih_dtinc, ");	//
		sb.append(" iih.iih_incno, ");	//
		sb.append(" iih.iih_billno, ");	//
		sb.append(" iih.iih_billbatchcode, ");	//
		sb.append(" iih.iih_placecode, ");	//
		sb.append(" iih.iih_placename, ");	//
		sb.append(" iih.iih_amt, ");	//
		sb.append(" iih.fg_iih_redbill, ");	//
		sb.append(" iih.iih_random, ");	//
		sb.append(" trid.ivcdatetime as trid_dtinc, ");	//
		sb.append(" trid.busno as trid_incno, ");	//
		sb.append(" trid.billno as trid_billno, ");	//
		sb.append(" trid.billbatchcode as trid_billbatchcode, ");	//
		sb.append(" trid.placecode as trid_placecode, ");	//
		//sb.append(" trid.trid_placename as trid_placename, ");	//
		sb.append(" trid.totalamt as trid_amt, ");	//
		//sb.append(" trid.state as fg_trid_redbill, ");	
		sb.append(" CASE WHEN trid.state = '1' THEN 'N' ");
		sb.append(" WHEN trid.state = '3' THEN 'Y' END AS as fg_trid_redbill, ");
		sb.append(" trid.random as trid_random ");	//
		String connTab = String.format("from %s as trid , %s as iih ", 
				CheckElecBillBP.SD_TMPTABLE_TRID,CheckElecBillBP.SD_TMPTABLE_IIH);
		sb.append(connTab);	//
		return sb;
	}
	
	/**
	 * 异常数据sql查询拼接where条件
	 * @param connSql 
	 * @return
	 */
	private String getAbnormalDataSql(StringBuilder connSql) {
		connSql.append(" where trid.trid_billno != iih.iih_billno ");	//
		connSql.append(" OR trid.trid_dtinc != iih.iih_dtinc ");	//
		connSql.append(" OR trid.trid_billbatchcode != iih.iih_billbatchcode ");	//
		connSql.append(" OR trid.trid_amt != iih.iih_amt ");	//
		connSql.append(" OR trid.fg_trid_redbill != iih.fg_iih_redbill ");	//
		connSql.append(" OR trid.trid_random != iih.iih_random ");	//
		return connSql.toString();
	}

	/**
	 * 正常数据sql查询拼接where条件
	 * @param connSql 
	 * @return
	 */
	private String getNormalDataSql(StringBuilder connSql) {
		connSql.append(" where trid.trid_billno = iih.iih_billno ");	//
		connSql.append(" AND trid.trid_dtinc = iih.iih_dtinc ");	//
		connSql.append(" AND trid.trid_billbatchcode = iih.iih_billbatchcode ");	//
		connSql.append(" AND trid.trid_amt = iih.iih_amt ");	//
		connSql.append(" AND trid.fg_trid_redbill = iih.fg_iih_redbill ");	//
		connSql.append(" AND trid.trid_random = iih.iih_random ");	//
		return connSql.toString();
	}

	/**
	 * 查询IIH数据
	 * @param whereStr
	 * @return
	 * @throws DAException 
	 */
	private BlecIncCheckDTO[] qryIIhData(String whereStr) throws DAException {
		String sql = this.getQryIIhSql(whereStr);
		List<BlecIncCheckDTO> dtos = (List<BlecIncCheckDTO>) new DAFacade().execQuery(sql, 
				new BeanListHandler(BlecIncCheckDTO.class));
		return dtos.toArray(new BlecIncCheckDTO[dtos.size()]);
	}

	/**
	 * 查询iih数据的sql
	 * @param whereStr
	 * @return
	 */
	private String getQryIIhSql(String whereStr) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select inc.id_incoep as id,inc.incno as iih_billno, ");	//
		sb.append(" inc.dt_inc as iih_dtinc, ");	//
		//开票点要判断是人还是计算机，字段上
		if (CheckElecBillBP.SD_INC_PSON.equals(CheckElecBillBP.blInc0012)) {
			sb.append(" ps.code as iih_placecode, ");	//
			sb.append(" ps.name as iih_placename, ");	//
		}else {
			sb.append(" pc.code as iih_placecode, ");	//
			sb.append(" pc.name as iih_placename, ");	//
		}
		sb.append(" inc.amt_ratio  as iih_amt, ");	//
		sb.append(" CASE WHEN inc.eu_direct = '1' THEN 'N' ELSE 'Y' END AS fg_iih_redbill, ");	//
		//sb.append(" inc.fg_canc AS fg_iih_redbill, ");	//
		sb.append(" inc.ec_inc_checkno as  iih_random, ");	//
		sb.append(" bl_st.code_st as iih_incno, ");	//业务流水号
		sb.append(" inc.ec_inc_code  as iih_billbatchcode ");	//
		sb.append(" from BL_INC_OEP inc  ");	//
		sb.append(" left join bd_psndoc ps ");	//
		sb.append(" on ps.id_psndoc = inc.id_emp_inc ");	//
		sb.append(" left join bd_pc pc ");	//
		sb.append(" on pc.id_pc = inc.id_pc ");	//
		sb.append(" left join bl_st_oep bl_st ");	//
		sb.append(" on bl_st.id_stoep = inc.id_stoep ");	//
		sb.append(" WHERE ");	//
		sb.append(whereStr);	//
		
		sb.append(" UNION ALL ");	//
		
		sb.append(" select inc.id_incip as id ,inc.incno as iih_billno,  ");	//
		sb.append(" inc.dt_inc as iih_dtinc, ");	//
		sb.append(" ps.code as iih_placecode, ");	//
		sb.append(" ps.name as iih_placename, ");	//
		sb.append(" inc.amt_ratio  AS iih_amt, ");	//
		sb.append(" CASE WHEN inc.eu_direct = '1' THEN 'N' ELSE 'Y' END AS fg_iih_redbill, ");	//
		sb.append(" inc.ec_inc_checkno as  iih_random, ");	//
		sb.append(" bl_st.code_st as iih_incno, ");	//业务流水号
		sb.append(" inc.ec_inc_code  as iih_billbatchcode ");	//
		sb.append(" from BL_INC_IP inc ");	//
		sb.append(" left join bd_psndoc ps ");	//
		sb.append(" on ps.id_psndoc = inc.id_emp_inc ");	//
		sb.append(" left join bd_pc pc ");	//
		sb.append(" on pc.id_pc = inc.id_pc ");	//
		sb.append(" left join bl_st_inc_ip bl_st_inc_ip ");	//right
		sb.append(" on bl_st_inc_ip.id_incip = inc.id_incip ");	//
		sb.append(" left join bl_st_ip bl_st ");
		sb.append(" on bl_st_inc_ip.id_stip = bl_st.id_stip ");
		sb.append(" WHERE ");	//
		sb.append(whereStr);	//
		return sb.toString();
	}

	/**
	 * 参数校验
	 * @param qry 
	 * @param option
	 * @return
	 */
	private Boolean checkParam(QryRootNodeDTO qry, String option) {
		Boolean pass = false;
		if (qry != null && option != null) {
			pass = true;
		}
		return pass;
	}
	
	/**
	 * 调用第三方获取总开票和总金额
	 * @return
	 * @throws BizException
	 */
	private EcIncBillListDTO[] getThridBillInfoList() throws BizException {
		CheckTotalDataDTO dto = new CheckTotalDataDTO();
		dto.setBgbusdate(new FDateTime(CheckElecBillBP.dtIncBegin));
		dto.setEndbusdate(new FDateTime(CheckElecBillBP.dtIncEnd));
		dto.setPlacecode(CheckElecBillBP.point);
		dto.setEudirect(Integer.valueOf(CheckElecBillBP.euDirect));
		IEcIncManageService service = ServiceFinder.find(IEcIncManageService.class);
		EcIncResultDTO<List<EcIncBillListDTO>> tridBillData = service.qryTridBillInfoList(dto);
		if (FBoolean.TRUE.equals(tridBillData.getFg_success())) {
			List<EcIncBillListDTO> dataList = tridBillData.getData();
			return dataList.toArray(new EcIncBillListDTO[dataList.size()]);
		}else {
			return null;
		}
	}
	
}
