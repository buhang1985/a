package iih.en.ip.s.bp;

import iih.en.ip2.dto.d.EnHpInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医保交易记录
 * 
 * @author yank
 *
 */
public class GetEnHpInfoDTOBP {
	/**
	 * 医保交易记录
	 * 
	 * @param pg
	 * @param param         
	 * @throws BizException
	 */
	public PagingRtnData<EnHpInfoDTO> exec(String wherestr,PaginationInfo pg) throws BizException {
		//获取sql	
		StringBuilder sql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT  PAT.CODE  AS CODE_PAT,");
		sql.append(" PAT.NAME AS NAME_PAT, ");
		sql.append("SEX.NAME AS SEX ,");
		sql.append("PAT.DT_BIRTH ,");
		sql.append("DEP.ID_DEP AS ID_DEP_PHY,");
		sql.append("DEP.CODE AS CODE_DEP_PHY ,");
		sql.append("DEP.NAME AS NAME_DEP_PHY ,");
		sql.append("ENT.CODE AS CODE_ENT,");
		sql.append("HPENTCODE.HP_ENT_SERIALNO AS  HP_ENT_SERIAL_NO  ,");
		sql.append("HPENTCODE.FG_ACTIVE, ");
		sql.append("HPENTCODE.CODE_HIS,");
		sql.append("HPENTCODE.FG_LOCK,");
		sql.append("HPENTCODE.DT_REG,");
		sql.append("HPENTCODE.NO_HP,");
		sql.append("HP.NAME AS NAME_HPTP,");
		sql.append("CA.ID_PATCA,");
		sql.append("CA.CODE AS SD_PATCA,");
		sql.append("CA.NAME AS NAME_PATCA , ");
		sql.append("HPENTCODE.READ_CARD_INFO,");
		sql.append("HPENTCODE.REGIST_INFO,");
		sql.append("HPENTCODE.CUSTOM_INFO  ");	
		sql.append("FROM BL_HP_ENTCODE_OEP HPENTCODE  ");
		sql.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = HPENTCODE.ID_PAT ");
		sql.append("INNER JOIN BD_UDIDOC SEX ON PAT.ID_SEX = ID_UDIDOC ");
		sql.append("INNER JOIN EN_ENT ENT ON ENT.ID_ENT = HPENTCODE.ID_ENT ");
		sql.append("INNER JOIN BD_DEP DEP ON DEP.ID_DEP = ENT.ID_DEP_PHY ");
		sql.append("INNER JOIN BD_PSNDOC PSN ON PSN.ID_PSNDOC = ENT.ID_EMP_PHY ");
		sql.append("INNER JOIN BD_HP HP ON HP.ID_HP = HPENTCODE.ID_HP ");
		sql.append("INNER JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA ");
		sql.append("WHERE  "+wherestr+" ");
		//获取结果数据
		PagingServiceImpl<EnHpInfoDTO> pageQryService = new PagingServiceImpl<EnHpInfoDTO>();
		PagingRtnData<EnHpInfoDTO> pgRtData = pageQryService.findByPageInfo(new EnHpInfoDTO(), pg, sql.toString(),
				null, sqlParam);
		
		//获取年龄
		FArrayList flResult = pgRtData.getPageData();
		for (int i = 0; i < flResult.size(); i++) {
			EnHpInfoDTO reg = (EnHpInfoDTO) flResult.get(i);
			reg.setAge(AgeCalcUtil.getAge(reg.getDt_birth()));
			
		}
		return pgRtData;
	}

	
}
