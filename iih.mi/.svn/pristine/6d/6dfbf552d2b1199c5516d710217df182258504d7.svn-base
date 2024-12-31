package iih.mi.mc.s.util;

import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.i.IBdHpPatcaDORService;
import iih.bd.srv.bddsdef.d.BdDsDefDO;
import iih.bd.srv.bddsdef.i.IBddsdefRService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.mi.mc.dto.d.MiMcSpecDrugLimitDTO;
import iih.mi.mc.mimcspec.s.bp.qry.GetSpecPatDrugListQry;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

import com.core.SqlUtils;

/**
 * 获取医保基础数据
 * 
 * @author LIM
 * @since 2019-09-25
 */
public class MiBaseInfoUtil {

	/**
	 * 获得指定医保计划下无限制用量的药品名单ID_MM
	 * 
	 * @param id_hp
	 *            医保计划
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getBdHpUnlimitDrugDOLst(String id_hp) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_MM FROM mi_mc_unlimit_drug drug ");
		sqlBuilder.append(" WHERE drug.ID_HP=?");

		SqlParam param = new SqlParam();
		param.addParam(id_hp);

		// 查询不限量药品
		List<String> unlimitDrugLst = (List<String>) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnListHandler());
		return unlimitDrugLst;
	}

	/**
	 * 
	 * 判断患者是否全保内
	 * 
	 * @param idEn
	 *            就诊编号
	 * @return
	 * @throws BizException
	 */
	public static FBoolean getPatAllhp(String idEn) throws BizException {
		IBdHpPatcaDORService service = ServiceFinder.find(IBdHpPatcaDORService.class);
		String whereStr = " ID_HPPATCA||ID_HP IN (SELECT ID_HPPATCA||ID_HP FROM EN_ENT_HP WHERE FG_MAJ='Y' AND ID_ENT='" + idEn + "')";
		BdHpPatcaDO[] dos = (BdHpPatcaDO[]) service.find(whereStr, "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(dos) && dos.length > 0) {
			if (FBoolean.TRUE.equals(dos[0].getFg_allinhp())) {
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}

	/**
	 * 获取该诊断下所有可开物品id信息list
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param id_hp
	 *            医保计划id
	 * @param diIds
	 *            诊断id数组
	 * @return
	 * @throws DAException
	 */
	public static List<String> getSpecPatDrugList(String id_ent, String id_hp, String[] diIds) throws DAException {
		List<String> idMMList = new ArrayList<String>();
		GetSpecPatDrugListQry qry = new GetSpecPatDrugListQry(id_ent, id_hp, diIds,null);
		@SuppressWarnings("unchecked")
		List<MiMcSpecDrugLimitDTO> specPatDrugLst = (List<MiMcSpecDrugLimitDTO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
				new BeanListHandler(MiMcSpecDrugLimitDTO.class));
		if (!ListUtil.isEmpty(specPatDrugLst)) {
			for (MiMcSpecDrugLimitDTO dto : specPatDrugLst) {
				if (!idMMList.contains(dto.getId_mm())) {
					idMMList.add(dto.getId_mm());
				}
			}
		}
		return idMMList;
	}
	
	/**
	 * 获取诊断信息
	 * @param idDefArr
	 * @return
	 * @throws BizException 
	 */
	public static DiagDefDO[] getDiDefInfo(String[] idDefArr) throws BizException{
		String sWhere="fg_active='Y'";
		if(!ArrayUtils.isEmpty(idDefArr)){
			sWhere += " and " + SqlUtils.getInSqlByIds(DiagDefDO.ID_DIDEF, idDefArr);
		}
		IDiagdefMDORService ser= ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO[] DiDefArr=ser.find(sWhere, "", FBoolean.FALSE);
		return DiDefArr;
	}
	
	/**
	 * 获取病种信息
	 * @param idDefArr
	 * @return
	 * @throws BizException 
	 */
	public static BdDsDefDO[] getDsDefInfo(String[] idDefArr) throws BizException{
		String sWhere="fg_active='Y'";
		if(!ArrayUtils.isEmpty(idDefArr)){
			sWhere += " and " + SqlUtils.getInSqlByIds(BdDsDefDO.ID_DSDEF, idDefArr);
		}
		IBddsdefRService ser= ServiceFinder.find(IBddsdefRService.class);
		BdDsDefDO[] DsDefArr=ser.find(sWhere, "", FBoolean.FALSE);
		return DsDefArr;
	}
}
